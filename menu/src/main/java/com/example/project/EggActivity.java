package com.example.project;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class EggActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egg);

        Button button = findViewById(R.id.material3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("★재료 준비★")
                        .setMessage(" 계란 3개,  옥수수 통조림 반컵,\n 슬라이스햄 2장, 슬라이스 치즈 1장,\n" +
                                "마요네즈 0.5, 우유 3, 소금/후추\n" +
                                "\n" +
                                "1인분 기준 (우유 1 = 우유 1큰술 = 15ml)");
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
}
