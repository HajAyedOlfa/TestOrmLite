package com.example.testormlite;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

//declarer le nom de la table du BD
@DatabaseTable( tableName = "T_user")

public class User {

    @DatabaseField( columnName = "idUser" , generatedId = true)
    private int idUser;

    @DatabaseField
    private String first_name;

    @DatabaseField
    private String last_name;

    @DatabaseField
    private String email;

    public User() { }

    public User(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public int getIdUser() {
        return idUser;
    }
    public String getFirst_name() {
        return first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public String getEmail() {
        return email;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
