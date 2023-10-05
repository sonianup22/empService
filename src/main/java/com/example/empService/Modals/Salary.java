package com.example.empService.Modals;


import com.example.empService.Enums.EmployeeTypeEnum;


public class Salary extends Employee {

//    int maxVacationDays = 15;

    public Salary(int id, String name, int workDays) {
        super(id, name, workDays, EmployeeTypeEnum.SALARY);
    }
    public Salary(int id, String name, int workDays, EmployeeTypeEnum empType) {
        super(id, name, workDays,empType);
    }

}
