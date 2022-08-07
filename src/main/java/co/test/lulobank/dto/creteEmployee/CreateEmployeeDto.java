package co.test.lulobank.dto.creteEmployee;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Data
public class CreateEmployeeDto {

    public String status;
    public CreateEmployeeData data;
    public String message;

}