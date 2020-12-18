package com.welleys.stu.excel;

import org.junit.Test;

import java.util.List;
import java.util.logging.Logger;

/**
 * {@link ExcelReader} test
 *
 * @author suzw1
 * @date 2018/09/11
 */
public class ExcelReaderTest {
    private static final Logger LOG = Logger.getLogger(ExcelReaderTest.class.getName());

    @Test
    public void fromExcelColumn() throws Exception {
        List<String> columnList = ExcelReader.fromExcelColumn("C:\\Users\\suzw1\\Documents\\Tencent " +
                "Files\\505485510\\FileRecv\\userphoto.xlsx", 2
        );

        LOG.info(columnList.toString());

    }
}