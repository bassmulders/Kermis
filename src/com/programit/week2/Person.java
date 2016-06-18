package com.programit.week2;

/**
 * Created by Bas on 13-6-2016.
 */
 class Person {
    private String firstName;
    private String lastName;
    private String phoneNr;
    private String address;

    String getFirstName() {
        return firstName;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getLastName() {
        return lastName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    String getPhoneNr() {
        return phoneNr;
    }

    void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    String getAddress() {
        return address;
    }

    void setAddress(String address) {
        this.address = address;
    }
}
