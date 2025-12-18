package org.example.adressbook;

import javafx.beans.property.SimpleStringProperty;

public class Person {

    private SimpleStringProperty pip = new SimpleStringProperty("");
    private SimpleStringProperty phone = new SimpleStringProperty("");

    public Person() {}

    public Person(String pip, String phone) {
        this.pip = new SimpleStringProperty(pip);
        this.phone = new SimpleStringProperty(phone);
    }

    public String getPip() {
        return pip.get();
    }

    public void setPip(String pip) {
        this.pip.set(pip);
    }

    public SimpleStringProperty pipProperty() {
        return pip;
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pip=" + pip +
                ", phone=" + phone +
                '}';
    }
}