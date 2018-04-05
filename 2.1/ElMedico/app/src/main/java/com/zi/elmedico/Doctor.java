package com.zi.elmedico;

/**
 * Created by zi on 3/28/2018.
 */

class Doctor {
    private String name;
    private String speciality;
    private String address;


    public Doctor(String name, String speciality, String address) {
        this.speciality = speciality;
        this.name = name;
        this.address = address;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
