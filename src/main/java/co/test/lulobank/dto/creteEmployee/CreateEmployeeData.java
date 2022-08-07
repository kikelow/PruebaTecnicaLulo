package co.test.lulobank.dto.creteEmployee;


public class CreateEmployeeData {

    public Integer id;
    public String name;
    public String salary;
    public String age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return name;
    }

    public void setEmployeeName(String employee_name) {
        this.name = employee_name;
    }

    public String getEmployeeSalary() {
        return salary;
    }

    public void setEmployeeSalary(String employee_salary) {
        this.salary = employee_salary;
    }

    public String getEmployeeAge() {
        return age;
    }

    public void setEmployeeAge(String employee_age) {
        this.age = employee_age;
    }

}