package co.test.lulobank.dto;


public class Employee {

    public Integer id;
    public String employee_name;
    public Integer employee_salary;
    public Integer employee_age;
    public String profile_image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employee_name;
    }

    public void setEmployeeName(String employee_name) {
        this.employee_name = employee_name;
    }

    public Integer getEmployeeSalary() {
        return employee_salary;
    }

    public void setEmployeeSalary(Integer employee_salary) {
        this.employee_salary = employee_salary;
    }

    public Integer getEmployeeAge() {
        return employee_age;
    }

    public void setEmployeeAge(Integer employee_age) {
        this.employee_age = employee_age;
    }

    public String getProfileImage() {
        return profile_image;
    }

    public void setProfileImage(String profile_image) {
        this.profile_image = profile_image;
    }
}