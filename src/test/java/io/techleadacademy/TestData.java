package io.techleadacademy;

import com.github.javafaker.Faker;

public class TestData {
    Faker fake = new Faker();

    public String firstName() {
       return fake.name().firstName();
    }

    public String lastName() {
        return fake.name().lastName();
    }

    public String phoneNumber() {
        return fake.phoneNumber().cellPhone();
    }

    public String address() {
        return fake.address().fullAddress();
    }
}
