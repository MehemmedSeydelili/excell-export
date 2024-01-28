package com.mahammad.excellexport.controller;

import com.mahammad.excellexport.model.Person;
import com.mahammad.excellexport.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("/excel")
    public String exportExcell(@RequestBody List<Person> people){

        /*List<Person> people = Arrays.asList(
                new Person("Mahammad", "Seydalili",22),
                new Person("Ceyhun", "Muradov", 21)
        );*/

        String filePath = "D:\\Download\\aexcel\\Data.xlsx";
        personService.exportToExcel(people, filePath);

        return "Excell file has created successfully: "+ filePath;
    }

}
