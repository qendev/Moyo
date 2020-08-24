package models.Post;

import com.google.gson.annotations.SerializedName;

public class PostBp {
    @SerializedName("sys")
    private String Sysolic;

    @SerializedName("dia")
    private  String Diastolic;

    @SerializedName("heart_rate")
    private String HeartRate;

    @SerializedName("patient_id")
    private String PatientId;

    public PostBp(String sysolic, String diastolic, String heartRate, String patientId) {
        Sysolic = sysolic;
        Diastolic = diastolic;
        HeartRate = heartRate;
        PatientId = patientId;
    }
}
