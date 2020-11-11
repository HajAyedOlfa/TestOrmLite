package com.example.testormlite;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable( tableName = "T_score") //declarer le nom de la table du BD

public class Score {
    // Declarer les champs de notre table "T_score"

    @DatabaseField( columnName = "idScore" , generatedId = true) //generatedId = true ==> auto generer
    private int idScore; // generer automatiquement par la base de donées

    @DatabaseField(canBeNull = false, foreign = true, foreignColumnName = "idUser", foreignAutoCreate = true)
    // foreign = true : montre la jointure avec une autre table
    private User user;

    @DatabaseField
    private int score;

    @DatabaseField
    private Date when;

    //constructeur sans parametre
    public Score() { }

    //constructeur avec parametre
    public Score(User user, int score, Date when) {
        this.user = user;
        this.score = score;
        this.when = when;
    }

    //les getters
    public int getIdScore() {
        return idScore;
    }
    public User getUser() {
        return user;
    }
    public int getScore() {
        return score;
    }
    public Date getWhen() {
        return when;
    }

    //les Setters
    public void setIdScore(int idScore) {
        this.idScore = idScore;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setWhen(Date when) {
        this.when = when;
    }

    //Affichage ToString

    @Override
    public String toString() {
        return "Score{" +
                "idScore=" + idScore +
                ", nom='" + user + '\'' +
                ", score=" + score +
                ", when=" + when +
                '}';
    }
}
