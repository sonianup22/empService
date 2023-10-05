package com.example.empService.Modals;

import com.example.empService.Enums.EmployeeTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;


public class Hourly extends Employee {

//    private int maxVacationDays = 10;

    public Hourly(int id, String name, int workDays) {
        super(id, name, workDays, EmployeeTypeEnum.HOURLY);
    }

}
