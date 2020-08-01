package models.Post;

public class PostRequestDoctor {
    public String patient_id;
    public String name;
    public String email;
    public Boolean status;

    public PostRequestDoctor(String patient_id, String name, String email, Boolean status) {
        this.patient_id = patient_id;
        this.name = name;
        this.email = email;
        this.status = status;
    }
}
