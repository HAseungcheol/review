package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //각 레이아웃에 창 전환 Event
        ImageView wasabi = findViewById(R.id.wasabi);
        wasabi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WasabiActivity.class);
                startActivity(intent);
            }
        });
        ImageView tuna = findViewById(R.id.tuna);
        tuna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TunaActivity.class);
                startActivity(intent);
            }
        });
        ImageView egg = findViewById(R.id.egg);
        egg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EggActivity.class);
                startActivity(intent);
            }
        });
        ImageView pork = findViewById(R.id.pork);
        pork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PorkActivity.class);
                startActivity(intent);
            }
        });

    }
}
