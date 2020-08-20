package models.response;

public class HeartrateNew {

    private String sys;

    private String dia;

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

    @Override
    public String toString()
    {
        return "ClassPojo [sys = "+sys+", dia = "+dia+"]";
    }
}
