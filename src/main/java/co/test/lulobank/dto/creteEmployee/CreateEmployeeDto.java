package co.test.lulobank.dto.creteEmployee;

public class CreateEmployeeDto {

    public String status;
    public CreateEmployeeData data;
    public String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CreateEmployeeData getData() {
        return data;
    }

    public void setData(CreateEmployeeData data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}