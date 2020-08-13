package models.response;

public class Prescription
{
    private String duration;

    private String dosage;

    private String name;

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public String getDosage ()
    {
        return dosage;
    }

    public void setDosage (String dosage)
    {
        this.dosage = dosage;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [duration = "+duration+", dosage = "+dosage+", name = "+name+"]";
    }
}