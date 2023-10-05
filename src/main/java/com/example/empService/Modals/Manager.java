package com.example.empService.Modals;

import com.example.empService.Enums.EmployeeTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;


public class Manager extends Salary{

//    private int maxVacationDays = 30;

    public Manager(int id, String name, int workDays) {
        super(id, name, workDays, EmployeeTypeEnum.MANAGER);
        super.calculateVacationDays();
    }

}
