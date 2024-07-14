package com.luoge.bos.op.invoice.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.CellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.handler.context.CellWriteHandlerContext;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.style.column.AbstractColumnWidthStyleStrategy;
import com.alibaba.fastjson2.JSON;
import com.luoge.bos.op.core.BosAppCode;
import com.luoge.bos.op.core.utils.StrUtil;
import com.luoge.ns.core.R;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.http.HttpStatus;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUtils.class);


    private static final String EXPOSE_HEADERS = "Access-Control-Expose-Headers";

    /**
     * excel 流导出(需返回前端指定信息时调用该方法)
     *
     * @param response   输出流
     * @param fileName   文件名前缀
     * @param exportData 导出数据
     * @param clazz      Class对象
     * @throws IOException 异常
     */
    public static void exportExcel(HttpServletResponse response, String fileName, List exportData, Class clazz) throws IOException {
        exportExcel(response, fileName, exportData, clazz, "导出成功", R.SUCCESS.getCode());
    }

    /**
     * excel 流导出(需返回前端指定信息时调用该方法)
     *
     * @param response   输出流
     * @param fileName   文件名前缀
     * @param exportData 导出数据
     * @param clazz      Class对象
     * @param resultMsg  返回前端数据（放header里面返回）为空默认导出成功
     * @param code       返回前端状态码：与controller返回状态码一致 全部成功：600 失败：800 为空默认600（放header里面与resultMsg一起返回）
     * @throws IOException 异常
     */
    public static void exportExcel(HttpServletResponse response, String fileName, List exportData, Class clazz, String resultMsg, int code) throws IOException {
        try {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");

            // 设置返回前端信息
            Map<String, Object> result = new HashMap<>();
            result.put("code", code);
            result.put("msg", resultMsg);
            response.setHeader("result", URLEncoder.encode(JSON.toJSONString(result), StandardCharsets.UTF_8));

            //设置该属性前端可见
            response.setHeader(EXPOSE_HEADERS, "result,Content-disposition");

            // 使用URLEncoder.encode 防止中文乱码
            String fileNameEncode = fileName + new SimpleDateFormat("yyyy-MM-dd-HHmmss").format(new Date());
            response.setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + StrUtil.encodeUrl(fileNameEncode + ".xlsx"));

            // 设置不关闭流
            EasyExcel.write(response.getOutputStream(), clazz)
                    .registerWriteHandler(new CellWriteWidthHandler())
                    .autoCloseStream(Boolean.FALSE)
                    .sheet(fileName)
                    .doWrite(exportData);
        } catch (Exception e) {
            LOGGER.error("下载文件失败：", e);
            // 重置response
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().println(JSON.toJSONString(R.fail(BosAppCode.EXPORT_FILE_FAIL)));
        }
    }

    /**
     * excel 流导出(需返回前端指定信息时调用该方法)
     *
     * @param response   输出流
     * @param fileName   文件名前缀
     * @param exportData 导出数据
     * @param clazz      Class对象
     * @throws IOException 异常
     */
    public static void exportCsv(HttpServletResponse response, String fileName, List exportData, Class clazz) throws IOException {
        try {
            response.setContentType("text/csv;charset=utf-8");
            // 使用URLEncoder.encode 防止中文乱码
            String fileNameEncode = URLEncoder.encode(fileName, StandardCharsets.UTF_8) + new SimpleDateFormat("yyyy-MM-dd-HHmmss").format(new Date());
            response.setHeader("Content-disposition", "attachment;filename=" + fileNameEncode + ".csv");

            // 设置不关闭流
            EasyExcel.write(response.getOutputStream(), clazz)
                    .excelType(ExcelTypeEnum.CSV)
                    .charset(StandardCharsets.UTF_8)
                    .autoCloseStream(Boolean.FALSE)
                    .sheet(fileName)
                    .doWrite(exportData);

        } catch (Exception e) {
            LOGGER.error("下载文件失败：", e);
            // 重置response
            response.reset();
            HttpUtil.writeError(response, HttpStatus.SC_INTERNAL_SERVER_ERROR, JSON.toJSONString(R.fail(BosAppCode.EXPORT_FILE_FAIL)));
        }
    }

    /**
     * 导出excel 到文件
     */
    public static <T> void exportExcel(FileOutputStream outputStream, String fileName, List<T> exportData, Class<T> clazz) {
        // 使用URLEncoder.encode 防止中文乱码
        String fileNameEncode = fileName + new SimpleDateFormat("yyyy-MM-dd-HHmmss").format(new Date()) + ".xlsx";
        // 设置不关闭流
        EasyExcel.write(outputStream, clazz)
                .registerWriteHandler(new CellWriteWidthHandler())
                .autoCloseStream(Boolean.FALSE)
                .sheet(fileName)
                .doWrite(exportData);
    }


    static class CellWriteWidthHandler extends AbstractColumnWidthStyleStrategy {

        private final Map<Integer, Map<Integer, Integer>> CACHE = new HashMap<>();

        @Override
        protected void setColumnWidth(CellWriteHandlerContext context) {
            List<WriteCellData<?>> cellDataList = context.getCellDataList();
            Cell cell = context.getCell();
            boolean needSetWidth = context.getHead() || (null != cellDataList && cellDataList.size() > 0);
            WriteSheetHolder writeSheetHolder = context.getWriteSheetHolder();
            if (needSetWidth) {
                Map<Integer, Integer> maxColumnWidthMap = CACHE.computeIfAbsent(writeSheetHolder.getSheetNo(), k -> new HashMap<>());

                Integer columnWidth = this.dataLength(cellDataList, cell, context.getHead());
                if (columnWidth >= 0) {
                    if (columnWidth > 50) {
                        columnWidth = 50;
                    }

                    Integer maxColumnWidth = maxColumnWidthMap.get(cell.getColumnIndex());
                    if (maxColumnWidth == null || columnWidth > maxColumnWidth) {
                        maxColumnWidthMap.put(cell.getColumnIndex(), columnWidth);
                        writeSheetHolder.getSheet().setColumnWidth(cell.getColumnIndex(), columnWidth * 256);
                    }

                }
            }
        }


        private Integer dataLength(List<WriteCellData<?>> cellDataList, Cell cell, Boolean isHead) {
            if (isHead) {
                return cell.getStringCellValue().getBytes().length;
            } else {
                CellData cellData = cellDataList.get(0);
                CellDataTypeEnum type = cellData.getType();
                if (type == null) {
                    return -1;
                } else {
                    return switch (type) {
                        case STRING -> cellData.getStringValue().getBytes().length;
                        case BOOLEAN -> cellData.getBooleanValue().toString().getBytes().length;
                        case NUMBER -> cellData.getNumberValue().toString().getBytes().length;
                        default -> -1;
                    };
                }
            }
        }

    }
}
