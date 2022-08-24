package com.example.app.cronexamples.controller;

import com.example.app.cronexamples.domain.Employee;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
public class RestController4RestTemplate {
    private final RestTemplate restTemplate;

    private static final Logger log = LoggerFactory.getLogger(RestController4RestTemplate.class);

    @Scheduled(cron = "0 0/5 * * * *")
    @RequestMapping(path = "/template/json")
    public Employee[] getEmployees() {
        log.debug("Tarea realizada");
        Employee[] response = restTemplate.getForEntity("http://localhost:8080/employee/all", Employee[].class).getBody();
        assert response != null;
        log.debug(Arrays.stream(response).toList().toString());
        return response;

    }

    @Scheduled(cron = "0 0/1 * * * *")
    public void postEmployees(){
        List<Employee> newEmployees = new ArrayList<>();
        newEmployees.add(new Employee("Intern"));
        newEmployees.add(new Employee("CEO"));
        log.debug("Mis datos: " + newEmployees.get(0));

        try {
            log.debug("Enviando Datos Post");
            restTemplate.postForObject(
                    "http://localhost:8080/employee/",
                    newEmployees,
                    ResponseEntity.class);
        }catch (Exception ex) {
            log.debug(ex.getMessage());
        }

    }


}
