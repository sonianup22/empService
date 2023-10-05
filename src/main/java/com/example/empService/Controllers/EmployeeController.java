package com.example.empService.Controllers;

import com.example.empService.Modals.Employee;
import com.example.empService.Exceptions.ResourceNotFoundException;
import com.example.empService.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAll(){
        List<Employee> employeeList =  employeeService.getEmployees();
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> get(@PathVariable int id){
        Optional<Employee> employee = employeeService.getEmploye(id);
        if(employee.isEmpty())
            throw new ResourceNotFoundException("Employee not found.");

        return ResponseEntity.ok(employee.get());
    }

    @PutMapping("work/{id}/{workDays}")
    public ResponseEntity<Employee> updateWorkDays(@PathVariable int id, @PathVariable int workDays){
        Optional<Employee> employee = Optional.empty();
            employee = employeeService.updateWorkDays(id, workDays);
            if (employee.isEmpty())
                throw new ResourceNotFoundException("Employee not found.");

            return ResponseEntity.ok(employee.get());
    }

    @PutMapping("takeVacation/{id}/{vacationDays}")
    public ResponseEntity<Employee> TakeVacation(@PathVariable int id, @PathVariable int vacationDays){
        Optional<Employee> employee = employeeService.takeVacation(id, vacationDays);
        if(employee.isEmpty())
            throw new ResourceNotFoundException("Employee not found.");

        return ResponseEntity.ok(employee.get());

    }

}
