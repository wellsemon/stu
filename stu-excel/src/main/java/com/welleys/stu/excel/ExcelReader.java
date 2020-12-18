package com.welleys.stu.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by suzw1 on 2018/09/11.
 */
public class ExcelReader {
    /**
     * 读取excel指定列
     *
     * @param filePath excel文件绝对路径
     * @param column   指定列, start at 1
     * @return 列数据集合
     * @throws Exception 异常
     */
    public static List<String> fromExcelColumn(String filePath, int column) throws Exception {
        List<String> dataList = new ArrayList<>();

        InputStream iStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(iStream);
        for (Sheet xssfSheet : workbook) {
            if (xssfSheet == null) {
                continue;
            }
            for (int runNum = 0; runNum < xssfSheet.getLastRowNum(); runNum++) {
                Row row = xssfSheet.getRow(runNum);
                Cell cell = row.getCell(column - 1);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                dataList.add(cell.getStringCellValue());
            }
        }

        return dataList;
    }
}