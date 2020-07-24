package models.response;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("_id")
    private String id;
    private String  first_name ;
    private String  last_name ;
    private String  town ;

    public String getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getTown() {
        return town;
    }
}
