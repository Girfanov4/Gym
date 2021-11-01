package com.androidstudio.gym;

public class User {
    public static String LastUser;
    String login, password;
    public User(String log, String pass)
    {
        this.login = log;
        this.password = pass;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
