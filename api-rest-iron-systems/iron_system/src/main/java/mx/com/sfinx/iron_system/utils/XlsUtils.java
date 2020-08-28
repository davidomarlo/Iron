package mx.com.sfinx.iron_system.utils;

import mx.com.sfinx.iron_system.business.SyscomProduct;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;


public class XlsUtils {

    /**
     * Contract od this method is to write data into excel file
     *
     * @param jsonInfo
     */
    public static void writeExcel(SyscomProduct jsonInfo) {

        HSSFWorkbook hssfWorkbook = null;
        HSSFRow row = null;
        HSSFSheet hssfSheet = null;
        FileOutputStream fileOutputStream = null;
        Properties properties = null;
        try {
            String filename = "c:/JSON/JSONInfo.xls";
            hssfWorkbook = new HSSFWorkbook();
            hssfSheet = hssfWorkbook.createSheet("new sheet");

            HSSFRow rowhead = hssfSheet.createRow((short) 0); // Header
            rowhead.createCell((short) 0).setCellValue("SNo");
            rowhead.createCell((short) 1).setCellValue(
                    "RegisteredForActualService");
            rowhead.createCell((short) 2).setCellValue("EmsCreationTime");
            rowhead.createCell((short) 3).setCellValue("RequestsOffering");
            rowhead.createCell((short) 4).setCellValue("Record Type");
            rowhead.createCell((short) 5).setCellValue("Related Properties");

            fileOutputStream = new FileOutputStream(filename);
            hssfWorkbook.write(fileOutputStream);
            fileOutputStream.close();
            System.out.println("JSON data successfully exported to excel!");
        } catch (Throwable throwable) {
            System.out.println("Exception in writting data to excel : "
                    + throwable);
        }
    }

}
