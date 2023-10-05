package com.example.empService.Services;

import com.example.empService.Exceptions.ResourceNotFoundException;
import com.example.empService.Exceptions.VacationDaysNotAvailableException;
import com.example.empService.Exceptions.WorkDaysNotValidException;
import com.example.empService.Modals.Employee;
import com.example.empService.Modals.Hourly;
import com.example.empService.Modals.Manager;
import com.example.empService.Modals.Salary;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

@Service
public class EmployeeService {

    static List<Employee> employees = new ArrayList<>();

    public EmployeeService() {

        createEmployee();
    }

    public void createEmployee(){

        employees.add(new Hourly(1,"sam h", 120));
        employees.add(new Hourly(2,"tom h", 240));
        employees.add(new Hourly(3,"roger h", 150));
        employees.add(new Hourly(4,"pam h", 150));
        employees.add(new Hourly(5,"tommy h", 100));
        employees.add(new Hourly(6,"shan h", 140));
        employees.add(new Hourly(7,"nilofer h", 220));
        employees.add(new Hourly(8,"rajiv h", 260));
        employees.add(new Hourly(9,"rock h", 110));
        employees.add(new Hourly(10,"ahsan h" , 110));

        employees.add(new Salary(11,"sam s", 120));
        employees.add(new Salary(12,"tom s", 240));
        employees.add(new Salary(13,"roger s", 150));
        employees.add(new Salary(14,"pam s", 100));
        employees.add(new Salary(15,"tommy s", 140));
        employees.add(new Salary(16,"shan s", 220));
        employees.add(new Salary(17,"nilofer s", 220));
        employees.add(new Salary(18,"rajiv s", 20));
        employees.add(new Salary(19,"rock s", 260));
        employees.add(new Salary(20,"ahsan s", 120));

        employees.add(new Manager(21,"sam m", 20));
        employees.add(new Manager(22,"tom m", 220));
        employees.add(new Manager(23,"roger m", 223));
        employees.add(new Manager(24,"pam m" , 123));
        employees.add(new Manager(25,"tommy m", 129));
        employees.add(new Manager(26,"shan m", 199));
        employees.add(new Manager(27,"nilofer m", 180));
        employees.add(new Manager(28,"rajiv m", 178));
        employees.add(new Manager(29,"rock m", 10));
        employees.add(new Manager(30,"ahsan m", 260));

//        Employee he = new Hourly(1,"anup-hourly", 120);
//        Employee se = new Salary(2,"anup-Salary", 120);
//        Employee me = new Manager(3,"anup-manager", 120);
//        employees.add(he);
//        employees.add(se);
//        employees.add(me);

    }
    public List<Employee> getEmployees() {
        return  employees;
    }

    public Optional<Employee> getEmploye(int id){
        return employees.stream().filter(emp-> emp.getId() == id).findFirst();
    }

    public Optional<Employee> updateWorkDays(int id, int workDays)  throws RuntimeException{
        Optional<Employee> employee = employees.stream().filter(emp-> emp.getId() == id).findFirst();
        employee.ifPresent(emp -> {
            int totalWorkdays = workDays + emp.getWork();
            if(totalWorkdays >= 0 && totalWorkdays <= 260) {
                float totalVacationdays = (float)(workDays * emp.getMaxVacationDays())/260 + emp.getVacationDays();
                emp.setWork(emp.getWork() + workDays);
                emp.setVacationDays(totalVacationdays > emp.getMaxVacationDays() ? emp.getMaxVacationDays() : totalVacationdays);
            }else
                throw new WorkDaysNotValidException("Workdays should be in range of 0 to 260. (New total Count is: " + totalWorkdays +" )"   );
        });

        return employee;
    }

    public Optional<Employee> takeVacation(int id, int vacationDays) throws RuntimeException{
        Optional<Employee> employee = employees.stream().filter(emp-> emp.getId() == id).findFirst();
        employee.ifPresent(emp -> {

            if(emp.getVacationDays() > 0 && emp.getVacationDays() - vacationDays > 0) {
                emp.setVacationDays(emp.getVacationDays() - vacationDays); ;
            }
            else
                throw new VacationDaysNotAvailableException("Vacation days can't Exceeds than accumulated. (Available total Balance is " + emp.getVacationDays() +" )");
        });
        return employee;
    }


}
