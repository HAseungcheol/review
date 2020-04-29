package com.example.project;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class WasabiActivity extends AppCompatActivity {
    SQLiteDatabase sqliteDB;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wasabi);
        sqliteDB = init_database();
        load_values();
        //'메모작성' 버튼 Click 이벤트
        Button newmemo = findViewById(R.id.btnNewMemo);
        newmemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WasabiActivity.this, MemoActivity.class);
                startActivity(intent);
            }
        });
    }
    private void load_values() {
        //MVC 중에서 Model
        ArrayList<HashMap<String, String>> list = new MemoDAO().selectAll(getApplicationContext());

        //Adapter (==Controller) - SimpleAdapter로 만듬
        SimpleAdapter simpleAdapter =
                new SimpleAdapter(this,
                        list,                                                 // Model(data)
                        android.R.layout.simple_list_item_2,                 // View
                        new String[]{"title", "time"},
                        new int[]{android.R.id.text1, android.R.id.text2});
        //ListView에 adapter 연결
        ListView listView = findViewById(R.id.reviewList);
        listView.setAdapter(simpleAdapter);
    }
    private SQLiteDatabase init_database() {
        dbHelper = new DBHelper(getApplicationContext());   //DB table 생성
        SQLiteDatabase db = dbHelper.getWritableDatabase(); //DB
        return db;
    }
}
