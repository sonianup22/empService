package com.example.empService.Enums;
 public enum EmployeeTypeEnum {

        HOURLY(10),
        SALARY(15),
        MANAGER(30);

    private int value;

    public int getValues() {
        return this.value;
    }

    EmployeeTypeEnum(int value) {
        this.value = value;
    }

};