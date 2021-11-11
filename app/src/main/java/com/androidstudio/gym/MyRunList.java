package com.androidstudio.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MyRunList extends AppCompatActivity {
    ArrayList<String> users = new ArrayList<String>();
    ArrayList<String> selectedUsers = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ListView usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_run_list);
        Bundle bundle = getIntent().getExtras();
        try {
            String distance = bundle.get("distance").toString();
            String timer = bundle.get("timer").toString();
            Collections.addAll(users);
            // получаем элемент ListView
            usersList = findViewById(R.id.listview);
            // создаем адаптер
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, users);
            // устанавливаем для списка адаптер
            usersList.setAdapter(adapter);
            if (!distance.isEmpty() || !timer.isEmpty()) {
                adapter.add(distance + "        "+ timer);
                adapter.notifyDataSetChanged();
            }
        }catch (Exception e){
            Collections.addAll(users);
            usersList = findViewById(R.id.listview);
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, users);
            // устанавливаем для списка адаптер
            usersList.setAdapter(adapter);
        }



        // обработка установки и снятия отметки в списке
        usersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // получаем нажатый элемент
                String user = adapter.getItem(position);
                if (usersList.isItemChecked(position))
                    selectedUsers.add(user);
                else
                    selectedUsers.remove(user);
            }
        });
        Button plan = (Button) findViewById(R.id.button16);
        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyRunList.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button lessons = (Button) findViewById(R.id.button17);
        lessons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyRunList.this, Lessons.class);
                startActivity(intent);
                finish();
            }
        });
        Button profile = (Button) findViewById(R.id.button19);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyRunList.this, Profile.class);
                startActivity(intent);
                finish();
            }
        });
    }




    public void remove(View view) {
        // получаем и удаляем выделенные элементы
        for (int i = 0; i < selectedUsers.size(); i++) {
            adapter.remove(selectedUsers.get(i));
        }
        // снимаем все ранее установленные отметки
        usersList.clearChoices();
        // очищаем массив выбраных объектов
        selectedUsers.clear();

        adapter.notifyDataSetChanged();
    }
}