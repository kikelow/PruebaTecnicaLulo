package co.test.lulobank.dto.creteEmployee;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@SuperBuilder
public class CreateEmployeeData {

    public Integer id;
    public String name;
    public String salary;
    public String age;

}