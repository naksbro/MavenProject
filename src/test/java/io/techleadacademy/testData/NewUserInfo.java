package io.techleadacademy.testData;

import com.github.javafaker.Faker;

import java.util.Locale;

public class NewUserInfo {
    public NewUserInfo () {
        createNewUser();
    }

    private static String firstName;
    private static String lastName;
    private static String phnNum;
    private static String email;
    private static String password;
    Faker fake = new Faker(new Locale("en-US"));

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getPhnNum () {
        return phnNum;
    }

    public void setPhnNum (String phnNum) {
        this.phnNum = phnNum;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public void createNewUser () {
        setFirstName(fake.name().firstName());
        setLastName(fake.name().lastName());
        setPhnNum(fake.phoneNumber().cellPhone());
        setEmail(fake.internet().emailAddress());
        setPassword(fake.internet().password());
    }
}
