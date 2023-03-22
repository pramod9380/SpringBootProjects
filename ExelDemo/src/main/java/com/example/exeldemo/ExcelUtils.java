package com.example.exeldemo;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.*;
import java.util.*;

public class ExcelUtils {

    public Map<Object,Object> getCSDLAndNDSLCompanyNameAndDPId(String path) {
        Map<Object, Object> map = new HashMap<>();
        List<Object> list = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(new File(path));
            HSSFWorkbook wb = new HSSFWorkbook(fis);
            HSSFSheet sheet = wb.getSheetAt(0);
            int count=0;
            for (Row row : sheet)
            {
                count+=1;
                if(count==1 || count==2 || count==3)
                    continue;
                else {
                    Cell cell1 = row.getCell(1);
                    list.add(cell1.getStringCellValue());
                    Cell cell2 = row.getCell(0);
                    list.add(cell2.getStringCellValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.printf(e.getMessage());
        }
        for (int i = 0; i < list.size() - 1; i += 2) {
            String str = list.get(i + 1).toString().toUpperCase();
            String str1 = "";
            if (str.contains("LTD") || str.contains("PVT") || str.contains("&") || str.contains("."))
                str1 = str.replace("LTD", "LIMITED").replace("PVT", "PRIVATE").replace("&","AND").replace(".","");
            else
                str1 = str;
            map.put(list.get(i), str1);
        }
        return map;
//        map.entrySet().stream().forEach(i -> System.out.println(i.getKey() + "<===========>" + i.getValue()));
    }

    public List<Object> getCompanyNames() {
        List<Object> list = new ArrayList<>();
        List<Object> updatedList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(new File("/home/pramod/SpecialTraining/ExelDemo/data/DP ID Master.xlsx"));
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file
            while (itr.hasNext()) {
                Row row = itr.next();
                Cell cell = row.getCell(1);   //iterating over each column
                list.add(cell.getStringCellValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list.size() - 1; i++) {
            String str = list.get(i).toString().toUpperCase();
            String str1 = "";
            if (str.contains("LTD") || str.contains("PVT") || str.contains("&") || str.contains(".")) {
                str1 = str.replace("LTD", "LIMITED").replace("PVT", "PRIVATE").replace("&", "AND").replace(".","");
                updatedList.add(str1);
            } else updatedList.add(str);
        }
        return updatedList;
//        map2.entrySet().stream().forEach(i-> System.out.println(i.getKey()+"<===========>"+i.getValue()));
    }


    public static void main(String[] args) throws IOException {
        Map<Object, Object[]> map = new HashMap<>();
        Map<Object,Object> NSDLMap = new ExcelUtils().getCSDLAndNDSLCompanyNameAndDPId("/home/pramod/SpecialTraining/ExelDemo/data/Registered_Depository_Participants_-_NSDL_as_on_Nov_22_2022.xls");
        Map<Object,Object> CSDLMap = new ExcelUtils().getCSDLAndNDSLCompanyNameAndDPId("/home/pramod/SpecialTraining/ExelDemo/data/Registered_Depository_Participants_-_CDSL_as_on_Nov_22_2022.xls");
        List<Object> companyNameList = new ExcelUtils().getCompanyNames();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("DP_ID");
        XSSFRow row;

        for (int i = 0; i < companyNameList.size(); i++) {
            if (NSDLMap.containsValue(companyNameList.get(i)) || CSDLMap.containsValue(companyNameList.get(i))) {
                Object obj1 = companyNameList.get(i);
                Optional<Object> obj2 = NSDLMap.keySet()
                        .stream()
                        .filter(key -> obj1.equals(NSDLMap.get(key)))
                        .findFirst();
                Optional<Object> obj3 = CSDLMap.keySet()
                        .stream()
                        .filter(key -> obj1.equals(CSDLMap.get(key)))
                        .findFirst();
                if (obj2.isPresent())
                    map.put(i,new Object[]{obj1, obj2.get()});
                if (obj3.isPresent())
                    map.put(i,new Object[]{obj1, obj3.get()});
            }
        }

        int rowid = 0;
        Set<Object> keys = map.keySet();
        for (Object key : keys) {
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = map.get(key);
            int cellid = 0;
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }

        FileOutputStream out = new FileOutputStream(
                new File("/home/pramod/SpecialTraining/ExelDemo/data/Updated_DP_ID_Sheet.xlsx"));

        workbook.write(out);
        out.close();

//        map.entrySet().stream().forEach(i -> System.out.println(i.getKey() + "--------" + i.getValue()));
//        System.out.println("size:" + map.size());
    }

}
