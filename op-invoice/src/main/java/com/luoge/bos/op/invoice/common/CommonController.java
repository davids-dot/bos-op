package com.luoge.bos.op.invoice.common;

import com.luoge.bos.op.core.BosAppCode;
import com.luoge.bos.op.core.model.FileBO;
import com.luoge.bos.op.core.utils.StrUtil;
import com.luoge.bos.op.invoice.entity.ParkEnterpriseCustomerDO;
import com.luoge.bos.op.invoice.entity.ParkEnterprisePayerDO;
import com.luoge.bos.op.invoice.entity.uc.RegionDO;
import com.luoge.ns.core.Code;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

/**
 * 公共接口
 */
@RequestMapping("/bos-op/common")
@RestController
public class CommonController {

    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    @Resource
    private CommonService commonService;
    @Resource
    private FileService fileService;

    /**
     * 上传文件
     *
     * @param file 上传的文件, 在 multipart/form-data 中
     */
    @PostMapping("/file/upload")
    R<FileBO> uploadFile(MultipartFile file) {
        return R.success(fileService.upload(0, file, 0));
    }

    /**
     * 下载文件
     *
     * @param fileId 文件id
     */
    @GetMapping(value = "/file/download", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_PDF_VALUE,
            "application/vnd.ms-excel"})
    R<Void> downloadFile(@RequestParam(name = "fileId") int fileId, HttpServletResponse response) {
        R<FileBO> fileBOR = fileService.downloadFile(fileId);
        if (fileBOR.failed()) {
            return R.fail(fileBOR);
        }
        try {
            FileBO file = fileBOR.getData();
            response.resetBuffer();
            response.setContentType(file.getContentType());
            response.addHeader("Content-Disposition", "attachment; filename="
                    + StrUtil.encodeUrl(file.getOriginalName()));
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(file.getContent());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            log.error("invoice get file error", e);
            return R.fail(BosAppCode.FILE_DOWNLOAD_ERROR);
        }
        return null;
    }

    /**
     * 预览文件
     *
     * @param fileId 文件id
     */
    @GetMapping(value = "/file", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_PDF_VALUE,
            MediaType.IMAGE_JPEG_VALUE})
    public R<Void> preview(@Valid @NotNull @RequestParam("fileId") Integer fileId, HttpServletResponse response) {
        R<FileBO> r = fileService.downloadFile(fileId);
        if (!Objects.equals(r.getCode(), Code.SUCCESS)) {
            return R.fail(r.getCode());
        }

        try {
            FileBO file = r.getData();
            response.resetBuffer();
            response.setContentType(file.getContentType());
            // 设置为预览而不是下载
            response.addHeader("Content-Disposition", "inline; filename=" + URLEncoder.encode(file.getName(), StandardCharsets.UTF_8));
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(file.getContent());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            log.error("invoice get file error", e);
            return R.fail(BosAppCode.FILE_DOWNLOAD_ERROR);
        }
        return null;
    }


    /**
     * 获取 支付方列表
     */
    @GetMapping("/enterprise/payer")
    public R<List<ParkEnterprisePayerDO>> listParkEnterprisePayer() {
        return R.success(commonService.listParkEnterprisePayer());
    }

    /**
     * 获取客户列表
     */
    @GetMapping("/enterprise/customer")
    public R<List<ParkEnterpriseCustomerDO>> listParkEnterpriseCustomer() {
        return R.success(commonService.listParkEnterpriseCustomer());
    }

    /**
     * 获取省份列表
     */
    @GetMapping("/province")
    public R<List<RegionDO>> listProvince() {
        return R.success(commonService.listProvince());
    }

}
