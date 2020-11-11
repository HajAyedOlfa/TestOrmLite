package com.example.testormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.util.List;

//orm : Mapping Objet Relationnel : est une couche intermediare entre la BD et notre projet
// ici on fait tous les manipulations entre la base de données et notre projet
//Partie Controller

public class DataBaseManeger extends OrmLiteSqliteOpenHelper{ // OrmLiteSqliteOpenHelper : permet d'utiliser L'orm

    private static final String DATABASE_NAME ="Game.db"; // declarer le nom de la BD
    private static final int DATABASE_VERSION = 2; //  declarer la version de la BD => si on a fait un changement au niveau de nos tables on doit changer de version

    //Construcrteur
    public DataBaseManeger(Context context){

        super (context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    /*puisqu'on a utiliser extends OrmLiteSqliteOpenHelper, on doit obligatoirement faire la redefinition de deux methodes :
      onCreate et onUpgrade (les parametres se mettent par defaut)*/

    @Override // cette methode sert a creer nos tables automatiquement
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Score.class);//creation de la table Score
            TableUtils.createTable(connectionSource, User.class); //creation de la table User
            Log.e("DATABASE", "Oncreate invoked"); // la table est creer

        }catch (Exception exception){
            Log.e("DATABASE", "Can't create Database", exception); // il ya un erreur : par exemple manque du nom de la table
        }
    }

    @Override // cette methode sert a supprimer les tables
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Score.class, true);
            TableUtils.dropTable(connectionSource, User.class, true);
            onCreate(database,connectionSource);
            Log.e("DATABASE", "Upgrade invoked");

        }catch (Exception exception){
            Log.e("DATABASE", "Can't Upgrade Database", exception);
        }
    }

    // cette methode sert a inseret un objet de type Score(Classe) dans la BD
    public void  insertScore(Score score){
        try {
            //Dao : Objet d'accées aux données => permet d'éviter l'utilisation du language SQL
            Dao<Score,Integer> dao = getDao(Score.class);
            dao.create(score); //
            Log.e("DATABASE", "insert score into Database");

        }catch(Exception exception){
            Log.e("DATABASE", "Can't insert score into Database", exception);

        }

    }
    //cette methode sert a lire les données stockés dans la BD
    public List<Score> readScore(){
        try {
            Dao<Score,Integer> dao = getDao(Score.class);
           List<Score> scores = dao.queryForAll();
            Log.e("DATABASE", "read Score invoked");
            return scores;
        }catch(Exception exception){
            Log.e("DATABASE", "Can't read score into Database", exception);
            return null;
        }
    }
}
