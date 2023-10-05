This project built Using Spring Boot 

4 Rest API's
1. GetAllEmployee : http://localhost:8080/api/employee/getAll 
HTTP Method Type : Get 
Returns 3 types of Employees

2. GetEmployeeByID : http://localhost:8080/api/employee/28 
HTTP Method Type : Get 
Returns Employee By Id, if not found will throw Error

3. ModifyWorkingHour :  http://localhost:8080/api/employee/work/28/20 
HTTP Method Type : Put 
Append working Days to the Given Employee, if not found will throw Error. If the total count is more than 260 Will throw an Error and won't update. Also recalculate Vacationdays as per new working days.

4. TakeVacation : http://localhost:8080/api/employee/takeVacation/28/24 
HTTP Method Type : Put 
Deduct vacation days count for the Given Employee and if vacation days are more than the available then the request throws Errors.

