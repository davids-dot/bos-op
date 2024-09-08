package com.luoge.bos.invoice.common;

import com.luoge.bos.core.BosAppCode;
import com.luoge.bos.core.model.FileBO;
import com.luoge.bos.core.utils.DateUtil;
import com.luoge.bos.data.FileDao;
import com.luoge.bos.invoice.configuration.AppConfig;
import com.luoge.bos.data.entity.FileDO;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import org.dromara.x.file.storage.core.Downloader;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@Service
public class FileService {

    private static final Logger log = LoggerFactory.getLogger(FileService.class);

    @Resource
    private FileDao fileDao;
    @Resource
    private FileStorageService fileStorageService;
    @Resource
    private AppConfig appConfig;


    /**
     * 把远程url 文件的内容保存到本地， 返回文件id
     *
     * @param orgId     机构id
     * @param remoteUrl 远程url
     * @return 文件对象
     */
    public FileBO upload(int orgId, int enterpriseId, String remoteUrl) {
        // 上传文件
        log.info("上传文件参数：{} {} {}", orgId, enterpriseId, remoteUrl);
        FileInfo upload = fileStorageService.of(URI.create(remoteUrl))
                .upload();
        log.info("上传文件结果：{}", upload);

        FileDO fileDO = saveFile(orgId, enterpriseId, upload);
        return new FileBO()
                .setId(fileDO.getId())
                .setUrl(upload.getUrl())
                .setName(upload.getFilename())
                .setContentType(upload.getContentType());
    }

    public FileBO upload(int orgId, MultipartFile file, int enterpriseId) {
        FileInfo fileInfo = fileStorageService.of(file)
                .upload();
        log.info("上传文件结果：{}", fileInfo);

        FileDO fileDO = saveFile(orgId, enterpriseId, fileInfo);
        return new FileBO()
                .setId(fileDO.getId())
                .setName(fileDO.getOriginalName())
                .setContentType(fileInfo.getContentType());
    }

    /**
     * 从本地文件表中获取文件
     *
     * @param fileId 文件id
     */
    public R<FileBO> downloadFile(int fileId) {
        FileDO fileDO = fileDao.get(fileId);
        if (Objects.isNull(fileDO)) {
            return R.fail(BosAppCode.FILE_DOWNLOAD_ERROR);
        }

        FileInfo fileInfo = toFileInfo(fileDO);
        long startTime = System.currentTimeMillis();
        byte[] content = new byte[0];
        try {
            Downloader download = fileStorageService.download(fileInfo);
            content = download.bytes();
            log.debug("下载文件[{}]完成，耗时：{} ms", fileInfo.getFilename(), System.currentTimeMillis() - startTime);
        } catch (Exception e) {
            log.error("download file error", e);
        }
        return R.success(new FileBO()
                .setContentType(fileDO.getContentType())
                .setName(fileDO.getName())
                .setOriginalName(fileDO.getOriginalName())
                .setContent(content));
    }

    public List<FileDO> listFileByIds(int orgId, List<Integer> fileIds) {
        return fileDao.listByIds(orgId, fileIds);
    }


    public FileDO saveFile(int orgId, Integer enterpriseId, FileInfo upload) {
        FileDO fileDO = toSysFileDO(orgId, enterpriseId, upload);
        fileDao.insert(fileDO);
        return fileDO;
    }


    private FileDO toSysFileDO(int orgId, Integer enterpriseId, FileInfo fileInfo) {
        return new FileDO()
                .setOrgId(orgId)
                .setEnterpriseId(enterpriseId)
                .setName(fileInfo.getFilename())
                .setContentType(fileInfo.getContentType())
                .setSize(fileInfo.getSize())
                .setUrl(fileInfo.getUrl())
                .setStorageType(fileInfo.getPlatform())
                .setOriginalName(fileInfo.getOriginalFilename())
                .setCreateTime(DateUtil.toLocalDateTime(fileInfo.getCreateTime()));
    }

    private FileInfo toFileInfo(FileDO fileDO) {
        return new FileInfo()
                .setFilename(fileDO.getName())
                .setPlatform(fileDO.getStorageType())
                .setOriginalFilename(fileDO.getOriginalName())
                .setBasePath(appConfig.getFileStoragePath())
                .setPath("")
                .setUrl(fileDO.getUrl())
                .setExt(fileDO.getContentType());
    }

}
