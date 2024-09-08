package com.luoge.bos.invoice.file;

import com.luoge.bos.core.BosAppCode;
import com.luoge.bos.core.model.FileBO;
import com.luoge.bos.core.utils.DateUtil;
import com.luoge.bos.data.FileDao;
import com.luoge.bos.data.configuration.AppConfiguration;
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
import java.util.Objects;

@Service
public class AppFileService {
    private static final Logger log = LoggerFactory.getLogger(AppFileService.class);
    @Resource
    private FileDao fileDao;
    @Resource
    private FileStorageService fileStorageService;
    @Resource
    private AppConfiguration appConfiguration;

    static final String FILE_URL = "/invoice/common/file/preview?fileId=%s";

    public static String getCommonFilePreviewUrl(Integer fileId) {
        return String.format(FILE_URL, fileId);
    }

    /**
     * 把远程url 文件的内容保存到本地， 返回文件id
     *
     * @param orgId     机构id
     * @param remoteUrl 远程url
     * @return 文件对象
     */
    public FileBO upload(int orgId, int enterpriseId, String remoteUrl) {
        if (remoteUrl == null) {
            return null;
        }

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
                .setUrl(getCommonFilePreviewUrl(fileDO.getId()))
                .setContentType(fileInfo.getContentType());
    }

//    public FileBO upload(int orgId, int enterpriseId, byte[] file) {
//        FileInfo fileInfo = fileStorageService.of(file)
//                .upload();
//        log.info("上传文件结果：{}", fileInfo);
//
//        SysFileDO fileDO = saveFile(orgId, enterpriseId, fileInfo);
//        return new FileBO()
//                .setId(fileDO.getId())
//                .setName(fileDO.getOriginalName())
//                .setUrl(InvoiceUtil.getCommonFilePreviewUrl(fileDO.getId()))
//                .setContentType(fileInfo.getContentType());
//    }
//
//    public FileBO upload(int orgId, int enterpriseId, byte[] file, String fileName) {
//        FileInfo fileInfo = fileStorageService.of(file, fileName)
//                .upload();
//        log.info("上传文件结果：{}", fileInfo);
//
//        SysFileDO fileDO = saveFile(orgId, enterpriseId, fileInfo);
//        return new FileBO()
//                .setId(fileDO.getId())
//                .setName(fileDO.getOriginalName())
//                .setUrl(InvoiceUtil.getCommonFilePreviewUrl(fileDO.getId()))
//                .setContentType(fileInfo.getContentType());
//    }

    /**
     * 从本地文件表中获取文件
     *
     * @param orgId  机构id
     * @param fileId 文件id
     */
    public R<FileBO> downloadFile(int orgId, int fileId) {
        FileDO sysFileDO = fileDao.get(fileId);
        if (Objects.isNull(sysFileDO)) {
            return R.fail(BosAppCode.FILE_DOWNLOAD_ERROR);
        }

        FileInfo fileInfo = toFileInfo(sysFileDO);
        try {
            Downloader download = fileStorageService.download(fileInfo);
            return R.success(new FileBO()
                    .setId(fileId)
                    .setContentType(sysFileDO.getContentType())
                    .setName(sysFileDO.getName())
                    .setOriginalName(sysFileDO.getOriginalName())
                    .setContent(download.bytes()));
        } catch (Throwable e) {
            log.error("文件下载失败", e);
            return R.fail(BosAppCode.FILE_DOWNLOAD_ERROR);
        }
    }

//    public List<SysFileDO> listFileByIds(int orgId, List<Integer> fileIds) {
//        return fileDao.listByIds(orgId, fileIds);
//    }
//
//
//    /**
//     * 上传文件的返回结果转为ocr 图片调用对象
//     *
//     * @param fileId 上传文件的id
//     */
//    public ImageBO toImageBO(int orgId, Integer fileId) {
//        R<FileBO> fileBOR = downloadFile(orgId, fileId);
//        if (fileBOR.failed()) {
//            log.error("download file error:{}", fileBOR.getMessage());
//            return new ImageBO().setId(String.valueOf(fileId))
//                    .setUrl(null)
//                    .setBase64Str("");
//        }
//        byte[] fileContent = fileBOR.getData().getContent();
//        return new ImageBO()
//                .setId(String.valueOf(fileId))
//                .setUrl(null)
//                .setBase64Str(fileContent != null ? Base64.getEncoder().encodeToString(fileContent) : "");
//    }

    public FileDO saveFile(int orgId, Integer enterpriseId, FileInfo upload) {
        FileDO sysFileDO = toSysFileDO(orgId, enterpriseId, upload);
        fileDao.insert(sysFileDO);
        return sysFileDO;
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

    private FileInfo toFileInfo(FileDO sysFileDO) {
        return new FileInfo()
                .setFilename(sysFileDO.getName())
                .setPlatform(sysFileDO.getStorageType())
                .setOriginalFilename(sysFileDO.getOriginalName())
                .setBasePath(appConfiguration.getFileStoragePath())
                .setPath("")
                .setUrl(sysFileDO.getUrl())
                .setExt(sysFileDO.getContentType());
    }

}
