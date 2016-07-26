package xparty.prado.com.myapplication.View.Model;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Prado on 25/07/2016.
 */

public class Usuario {

    private int login;
    private String senha;

    public Usuario(int login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }
}
