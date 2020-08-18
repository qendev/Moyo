package models.response;

public class ResponseGetOtp
{
    private String id_number;

    private String last_name;

    private String weight;

    private String heart_rate;

    private String doctor_id;

    private String createdAt;

    private String password;

    private String phone;

    private String __v;

    private String _id;

    private String first_name;

    private String email;

    private String height;

    private String updatedAt;

    public String getId_number ()
    {
        return id_number;
    }

    public void setId_number (String id_number)
    {
        this.id_number = id_number;
    }

    public String getLast_name ()
    {
        return last_name;
    }

    public void setLast_name (String last_name)
    {
        this.last_name = last_name;
    }

    public String getWeight ()
    {
        return weight;
    }

    public void setWeight (String weight)
    {
        this.weight = weight;
    }

    public String getHeart_rate ()
    {
        return heart_rate;
    }

    public void setHeart_rate (String heart_rate)
    {
        this.heart_rate = heart_rate;
    }

    public String getDoctor_id ()
    {
        return doctor_id;
    }

    public void setDoctor_id (String doctor_id)
    {
        this.doctor_id = doctor_id;
    }

    public String getCreatedAt ()
    {
        return createdAt;
    }

    public void setCreatedAt (String createdAt)
    {
        this.createdAt = createdAt;
    }

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }

    public String getPhone ()
    {
        return phone;
    }

    public void setPhone (String phone)
    {
        this.phone = phone;
    }

    public String get__v ()
    {
        return __v;
    }

    public void set__v (String __v)
    {
        this.__v = __v;
    }

    public String get_id ()
    {
        return _id;
    }

    public void set_id (String _id)
    {
        this._id = _id;
    }

    public String getFirst_name ()
    {
        return first_name;
    }

    public void setFirst_name (String first_name)
    {
        this.first_name = first_name;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getHeight ()
    {
        return height;
    }

    public void setHeight (String height)
    {
        this.height = height;
    }

    public String getUpdatedAt ()
    {
        return updatedAt;
    }

    public void setUpdatedAt (String updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id_number = "+id_number+", last_name = "+last_name+", weight = "+weight+", heart_rate = "+heart_rate+", doctor_id = "+doctor_id+", createdAt = "+createdAt+", password = "+password+", phone = "+phone+", __v = "+__v+", _id = "+_id+", first_name = "+first_name+", email = "+email+", height = "+height+", updatedAt = "+updatedAt+"]";
    }
}
