package com.example.project;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class WasabiActivity extends AppCompatActivity {
    SQLiteDatabase sqliteDB;
    DBHelper dbHelper;
    ListView listView;
    MemoVO vo = new MemoVO();
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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
//                builder.setTitle();
//                builder.setMessage(vo.getContent());
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();
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
                        new String[]{"_id", "time"},
                        new int[]{android.R.id.text1, android.R.id.text2});
        //ListView에 adapter 연결
        listView = findViewById(R.id.reviewList);
        listView.setAdapter(simpleAdapter);
    }

    private SQLiteDatabase init_database() {
        dbHelper = new DBHelper(getApplicationContext());   //DB table 생성
        SQLiteDatabase db = dbHelper.getWritableDatabase(); //DB
        return db;
    }

    //삭제
    public static void delete_value() {

    }
}
