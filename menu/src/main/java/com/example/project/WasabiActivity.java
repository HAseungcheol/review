package com.example.project;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
                Intent intent = new Intent(getApplicationContext(), MemoActivity.class);
                startActivity(intent);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //변수에다가 AdapterView의 리스트 목록(Item)의 포지션을 담는다.
                //중요한 것은 ListView에 데이터가 있어야 불러 올 수 있다!
                Map<String, String> item = (Map) parent.getItemAtPosition(position);

                //String 타입의 변수에다가 Item의 get()를 활용하여 title컬럼, content컬럼의 값을 담는다.
                String title = item.get("title");
                String content = item.get("content");

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle(title);
                builder.setMessage(content);
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
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
}
