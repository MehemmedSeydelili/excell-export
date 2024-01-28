package com.mahammad.excellexport.service;

import com.mahammad.excellexport.model.Person;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class PersonService {

    public void exportToExcel(List<Person> people, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Veri Sayfası");

            // Başlık satırı
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Ad");
            headerRow.createCell(1).setCellValue("Soyad");
            headerRow.createCell(2).setCellValue("Yaş");

            // Verileri Excel dosyasına yaz
            int rowNum = 1;
            for (Person person : people) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(person.getFirstName());
                row.createCell(1).setCellValue(person.getLastName());
                row.createCell(2).setCellValue(person.getAge());
            }

            // Excel dosyasını kaydet
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
            System.out.println("Excel file created");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}