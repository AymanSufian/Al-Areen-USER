package com.example.alareencenter;

public class Users {

    String Patient_Name, Inj_Place, Inj_Des, Calender, Datepicker;

    public Users() {
    }

    public Users(String patientName, String injuryPlace, String injuryDes, String calender, String datepicker) {
        Patient_Name = patientName;
        Inj_Place = injuryPlace;
        Inj_Des = injuryDes;
        Calender = calender;
        Datepicker = datepicker;
    }


    public String getPatientName() {
        return Patient_Name;
    }

    public void setPatientName(String patientName) {
        Patient_Name = patientName;
    }

    public String getInjuryPlace() {
        return Inj_Place;
    }

    public void setInjuryPlace(String injuryPlace) {
        Inj_Place = injuryPlace;
    }

    public String getInjuryDes() {
        return Inj_Des;
    }

    public void setInjuryDes(String injuryDes) {
        Inj_Des = injuryDes;
    }

    public String getCalender() {
        return Calender;
    }

    public void setCalender(String calender) {
        Calender = calender;
    }

    public String getDatepicker() {
        return Datepicker;
    }

    public void setDatepicker(String datepicker) {
        Datepicker = datepicker;
    }
}

