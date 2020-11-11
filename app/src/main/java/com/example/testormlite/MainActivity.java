package com.example.testormlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView scoresView;
    private DataBaseManeger dataBaseManeger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoresView = (TextView) findViewById(R.id.scoresView); // activity_main.xml
        dataBaseManeger = new DataBaseManeger(this); //creer un objet du dataBaseManeger

        //User jaune = new User("jaune", "bound","jaune@gmail.com"); => inserrer un champ dans la table USer
        //User jason = new User("jason", "bound","jason@gmail.com");  => inserrer un champ dans la table USer

        //=> inserrer deux dans la table Score grace a la methode insertScore dans la classe DataBaseManeger
       //dataBaseManeger.insertScore(new Score(jaune,1000, new Date()));
       //dataBaseManeger.insertScore(new Score(jason, 1200, new Date()));

        List<Score> scores = dataBaseManeger.readScore(); // afficher les contenu de la BD grace a la methode readScore()
        for(Score score : scores){
            scoresView.append(score.toString() + "\n\n" );
        }

        dataBaseManeger.close(); // Fermer
    }

}