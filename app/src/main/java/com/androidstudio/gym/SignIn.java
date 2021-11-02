package com.androidstudio.gym;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SignIn extends AppCompatActivity {
    public static ArrayList<User> Users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        TextView skip = (TextView) findViewById(R.id.textView3);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SignIn.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });
        TextView signup = (TextView) findViewById(R.id.textView2);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignIn.this, SignUp.class);
                startActivity(intent);
                finish();
            }
        });
        Users = new ArrayList<>();

        //Загружаем данные пользователей из бд
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("Users.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users (login TEXT, password TEXT)");
        Cursor query = db.rawQuery("SELECT * FROM users;", null);
        while (query.moveToNext()) {
            String login = query.getString(0);
            String password = query.getString(1);
            Users.add(new User(login, password));
        }
        query.close();
        db.close();
    }
    public void LogInClick(View view) {
        Intent profile = new Intent(SignIn.this, MainActivity.class);
        EditText logT = findViewById(R.id.editTextTextPersonName);
        EditText passT = findViewById(R.id.editTextTextPersonName2);
        if (logT.length() == 0 | passT.length() == 0) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Ошибка");
            if (logT.length() == 0) {
                alert.setMessage("Заполните поле login");
            }
            else {
                alert.setMessage("Заполните поле password");
            }
            alert.setIcon(android.R.drawable.ic_dialog_alert);
            alert.setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            alert.show();
            return;
        }

        boolean found = false;
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        for (User item : SignIn.Users) {
            if (logT.getText().toString().equals(item.login)) {
                found = true;

                if (item.getPassword().equals(passT.getText().toString())) {
                    User.LastUser = item.login;
                    logT.setText("");
                    passT.setText("");
                    startActivity(profile);
                    break;
                } else {
                    alert.setTitle("Ошибка");
                    alert.setIcon(android.R.drawable.ic_dialog_alert);
                    alert.setMessage("Неверный пароль");
                    alert.show();
                }

            }
        }
        if (!found) {
            alert.setTitle("Ошибка");
            alert.setMessage("Пользователя с таким логином не найдено");
            alert.setIcon(android.R.drawable.ic_dialog_alert);
            alert.show();
        }

    }

}