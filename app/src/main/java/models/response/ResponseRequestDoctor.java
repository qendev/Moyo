package models.response;

public class ResponseRequestDoctor {
    private String _id;
    private String patient_id;
    private String name;
    private String email;
    private String status;
    private String createdAt;

    public String get_id() {
        return _id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
