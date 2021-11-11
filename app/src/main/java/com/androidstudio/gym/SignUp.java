package com.androidstudio.gym;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        TextView back = (TextView) findViewById(R.id.textView8);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, SignIn.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void SignUpClick(View view) {

        EditText logT = findViewById(R.id.login);
        EditText email = findViewById(R.id.email);
        EditText passT = findViewById(R.id.password1);
        EditText passT2 = findViewById(R.id.password2);
        String emailru = "@",emailcom = "@gmail.com";
        if (logT.getText().toString().equals("") || email.getText().toString().equals("") || passT.getText().toString().equals("") || passT2.getText().toString().equals("")) {
            AlertDialog.Builder alert = new AlertDialog.Builder(SignUp.this);
            alert.setTitle("Ошибка");
            if (logT.getText().toString().equals("")) {
                alert.setMessage("Заполните поле login");
            } else if (email.getText().toString().equals("")) {
                alert.setMessage("Заполните поле Email");
            } else if (passT.getText().toString().equals("")) {
                alert.setMessage("Заполните поле Пароль");
            } else if (passT2.getText().toString().equals("")) {
                alert.setMessage("Заполните поле Пароль");
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
        if (!passT.getText().toString().equals(passT2.getText().toString())) {
            AlertDialog.Builder alert = new AlertDialog.Builder(SignUp.this);
            alert.setTitle("Ошибка");
            alert.setMessage("Пароли не совпадают");
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
        if (!email.getText().toString().contains(emailru)) {
            AlertDialog.Builder alert = new AlertDialog.Builder(SignUp.this);
            alert.setTitle("Ошибка");
            alert.setMessage("Неверный Email");
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

        String Log = logT.getText().toString();
        String Pass = passT.getText().toString();
        AlertDialog.Builder alert = new AlertDialog.Builder(this);


        boolean found = false;

        for (User item : SignIn.Users) {
            if (Log.equals(item.login)) {
                found = true;
                alert.setTitle("Уже существует");
                alert.setMessage("Пользователь существует");
                alert.show();
            }
        }
        if (!found) {
            SaveUser(Log, Pass);
            alert.setMessage("Успешная регистриция");
            alert.setTitle("OK");
            alert.setPositiveButton("Sign In", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    Intent intent = new Intent(SignUp.this, SignIn.class);
                    startActivity(intent);
                    finish();
                }
            });
            alert.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialogInterface) {
                    Intent intent = new Intent(SignUp.this, SignIn.class);
                    startActivity(intent);
                    finish();
                }
            });
            alert.show();
        }
    }

    public void SaveUser(String login, String password) {
        ContentValues cv = new ContentValues();
        cv.put("login", login);
        cv.put("password", password);
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("Users.db", MODE_PRIVATE, null);
        db.insert("Users", null, cv);
        db.close();
        SignIn.Users.add(new User(login, password));
    }
}
