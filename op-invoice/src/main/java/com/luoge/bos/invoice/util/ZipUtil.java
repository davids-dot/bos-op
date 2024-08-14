package com.luoge.bos.invoice.util;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtil {

    public static void addFileToZip(byte[] content, String name, ZipOutputStream zos) throws IOException {
        ZipEntry zipEntry = new ZipEntry(name);
        zos.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        ByteArrayInputStream bas = new ByteArrayInputStream(content);
        while ((length = bas.read(bytes)) >= 0) {
            zos.write(bytes, 0, length);
        }
        zos.closeEntry();
    }


    public static void addFileToZip(String filePath, String zipEntryName, ZipOutputStream zos) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            ZipEntry zipEntry = new ZipEntry(zipEntryName);
            zos.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zos.write(bytes, 0, length);
            }
            zos.closeEntry();
        }
    }
}
