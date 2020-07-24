package models;

public class RegisterUSer  {

    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String town;
    private String role="patients";


    public RegisterUSer(String first_name, String last_name, String email, String password, String town) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.town = town;
    }
}
