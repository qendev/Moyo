package models.response;

public class ResponseBloodPressure {
    private String createdAt;

    private String patient_id;

    private String __v;

    private String heart_rate;

    private String _id;

    private String sys;

    private String dia;

    private String updatedAt;

    public String getCreatedAt ()
    {
        return createdAt;
    }

    public void setCreatedAt (String createdAt)
    {
        this.createdAt = createdAt;
    }

    public String getPatient_id ()
    {
        return patient_id;
    }

    public void setPatient_id (String patient_id)
    {
        this.patient_id = patient_id;
    }

    public String get__v ()
    {
        return __v;
    }

    public void set__v (String __v)
    {
        this.__v = __v;
    }

    public String getHeart_rate ()
    {
        return heart_rate;
    }

    public void setHeart_rate (String heart_rate)
    {
        this.heart_rate = heart_rate;
    }

    public String get_id ()
    {
        return _id;
    }

    public void set_id (String _id)
    {
        this._id = _id;
    }

    public String getSys ()
    {
        return sys;
    }

    public void setSys (String sys)
    {
        this.sys = sys;
    }

    public String getDia ()
    {
        return dia;
    }

    public void setDia (String dia)
    {
        this.dia = dia;
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
        return "ClassPojo [createdAt = "+createdAt+", patient_id = "+patient_id+", __v = "+__v+", heart_rate = "+heart_rate+", _id = "+_id+", sys = "+sys+", dia = "+dia+", updatedAt = "+updatedAt+"]";
    }
}
