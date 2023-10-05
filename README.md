This project built Using Spring Boot 

Has mainluy 4 Rest API
1. GetAllEmployee : http://localhost:8080/api/employee/getAll
   HTTP Method Type : Get
   Returns 3 types of Employees
  
2. GetEmployeeByID : http://localhost:8080/api/employee/28
   HTTP Method Type : Get
   Returns Employee By Id, if not found will throw Error
 
3. ModifyWorkingHour :  http://localhost:8080/api/employee/work/28/20
   HTTP Method Type : Put
   Append working Daya to the Given Employee, if not found will throw Error. If total count more than 260 Will throw Error and won't update. Also recalculate Vacationdays as per new workingdays.
   
4. TakeVacation : http://localhost:8080/api/employee/takeVacation/28/24
   HTTP Method Type : Put
   Deduct vacation days count for the Given Employee and if vacation days is more than the available then request throws Errors.  
