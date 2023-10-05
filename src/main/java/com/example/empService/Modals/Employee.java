package com.example.empService.Modals;

import com.example.empService.Enums.EmployeeTypeEnum;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    private int id;
    private String name;
    private int work;
    private float vacationDays;
    private int maxVacationDays;
    private String type;

    public Employee(int id, String name, int work, EmployeeTypeEnum empType) {
        this.id = id;
        this.name = name;
        this.work = work;
        this.type=empType.name();
        this.maxVacationDays = empType.getValues();
        this.calculateVacationDays();
    }

    public void calculateVacationDays(){
        this.setVacationDays(((float) (this.getWork() * this.getMaxVacationDays()) /260));
    };

    public void work(int workdays){
        this.vacationDays = workdays;
    }

    public float takeVacation(float daysUsed){
        return this.vacationDays - daysUsed;
    }
}
