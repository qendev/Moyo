package models.response;

import com.google.gson.annotations.SerializedName;

public class ResponseLogin {

    @SerializedName("user")
    private User user;
    private String token;

    public User getUser() {
        return user;
    }

    public String getToken() {
        return token;
    }
}
