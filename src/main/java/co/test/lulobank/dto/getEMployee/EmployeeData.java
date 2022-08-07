package co.test.lulobank.dto.getEMployee;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@SuperBuilder
public class EmployeeData {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("employee_name")
    public String employeeName;
    @JsonProperty("employee_salary")
    public Integer employeeSalary;
    @JsonProperty("employee_age")
    public Integer employeeAge;
    @JsonProperty("profile_image")
    public String profileImage;

}