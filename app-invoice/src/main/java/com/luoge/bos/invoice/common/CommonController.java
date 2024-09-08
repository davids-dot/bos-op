package com.luoge.bos.invoice.common;

import com.luoge.bos.core.model.FileBO;
import com.luoge.bos.invoice.file.AppFileService;
import com.luoge.bos.invoice.utils.WebUtil;
import com.luoge.ctx.Context;
import com.luoge.ns.core.Code;
import com.luoge.ns.core.R;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

/**
 * 公共/公共接口
 */
@RestController
@RequestMapping("/invoice/common")
public class CommonController {
    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    //    @Resource
//    private EnterpriseExtService enterpriseExtService;
//    @Resource
//    private InvoiceInCollectService collectService;
//    @Resource
//    private AppConfig appConfig;
//    @Resource
//    private UcService ucService;
    @Resource
    private AppFileService appFileService;
//    @Resource
//    private CustomerService customerService;


    /**
     * 上传文件
     *
     * @param file 上传的文件, 在 multipart/form-data 中
     */
    @PostMapping("/file/upload")
    R<FileBO> uploadFile(MultipartFile file, Context ctx) {
        return R.success(appFileService.upload(ctx.getOrgId(), file, ctx.getEnterpriseId()));
    }


    /**
     * 预览文件
     *
     * @param fileId 文件id
     */
    @GetMapping(value = "/file/preview", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PDF_VALUE, MediaType.IMAGE_JPEG_VALUE})
    public R<Void> preview(@Valid @NotNull @RequestParam("fileId") Integer fileId, HttpServletResponse response) {
        R<FileBO> r = appFileService.downloadFile(0, fileId);
        if (!Objects.equals(r.getCode(), Code.SUCCESS)) {
            return R.fail(r.getCode());
        }

        return WebUtil.previewFile(r, response);
    }

}
