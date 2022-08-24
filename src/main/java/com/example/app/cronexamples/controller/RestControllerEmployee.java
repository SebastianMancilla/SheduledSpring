package com.example.app.cronexamples.controller;

import com.example.app.cronexamples.domain.Employee;
import com.example.app.cronexamples.service.IEmployeeService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
@AllArgsConstructor
public class RestControllerEmployee {
    private  final IEmployeeService employeeService;

    private static final Logger log = LoggerFactory.getLogger(RestControllerEmployee.class);

    @GetMapping(path = "/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        log.debug("Kaifuku Enviado");
        return  new ResponseEntity<>(this.employeeService.findAll(), HttpStatus.OK);

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return  new ResponseEntity<>(this.employeeService.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public  ResponseEntity<Employee> createNewEmployee(@RequestBody Employee employee){
        if(employee.getTittle().isEmpty()) {
            log.debug("No se Envio atributos");
        }
        log.debug("Se creo el Employee");
        return  new ResponseEntity<>(this.employeeService.save(employee), HttpStatus.CREATED);

    }
}
