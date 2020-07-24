package models.Post;

public class PostBpReading {

    private String patient_id;
    private String systolic_diastolic;
    private String heart_rate;


    public PostBpReading(String patient_id, String systolic_diastolic, String heart_rate) {
        this.patient_id = patient_id;
        this.systolic_diastolic = systolic_diastolic;
        this.heart_rate = heart_rate;
    }

}
