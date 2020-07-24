package models.Post;

public class PostPatientData {

    private String patient_id ;
    private String weight;
    private String height;

    public PostPatientData(String patient_id, String weight, String height) {
        this.patient_id = patient_id;
        this.weight = weight;
        this.height = height;
    }
}
