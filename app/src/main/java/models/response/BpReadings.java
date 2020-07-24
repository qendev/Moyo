package models.response;

public class BpReadings {

    private String height;
    private String weight;


    public BpReadings(String height, String weight) {
        this.height = height;
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }
}
