package com.luoge.bos.invoice.utils;

import com.luoge.bos.core.BosAppCode;
import com.luoge.bos.core.model.FileBO;
import com.luoge.bos.core.utils.StrUtil;
import com.luoge.ns.core.R;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class WebUtil {
    private static final Logger log = LoggerFactory.getLogger(WebUtil.class);

    public static R<Void> downloadFile(R<FileBO> r, HttpServletResponse response) {
        if (r.failed()) {
            return R.fail(r.getCode(), "文件下载失败，请稍后再试");
        }
        return downloadFile(r.getData(), response);
    }

    public static R<Void> downloadFile(FileBO file, HttpServletResponse response) {
        try {
            response.resetBuffer();
            response.setContentType(file.getContentType());
            response.addHeader("Content-Disposition", "attachment; filename="
                    + StrUtil.encodeUrl(file.getOriginalName()));
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(file.getContent());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            log.error("download file error", e);
            return R.fail(BosAppCode.FILE_DOWNLOAD_ERROR);
        }
        return null;
    }

    public static R<Void> previewFile(R<FileBO> r, HttpServletResponse response) {
        if (r.failed()) {
            return R.fail(r.getCode(), "文件预览失败，请稍后再试");
        }
        return previewFile(r.getData(), response);
    }

    public static R<Void> previewFile(FileBO file, HttpServletResponse response) {
        try {
            response.resetBuffer();
            response.setContentType(file.getContentType());
            response.addHeader("Content-Disposition", "inline; filename=" + StrUtil.encodeUrl(file.getOriginalName()));
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(file.getContent());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            log.error("preview file error", e);
            return R.fail(BosAppCode.FILE_DOWNLOAD_ERROR);
        }
        return null;
    }
}
