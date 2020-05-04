package com.example.project;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class WasabiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wasabi);

        Button button = findViewById(R.id.material);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("★재료 준비★")
                        .setMessage("필수재료\n" +
                                "따뜻한 밥(1공기), 날치알(1), 김가루(적당량)\n" +
                                "\n" +
                                "선택재료\n" +
                                "맛살(2쪽), 쪽파(1대)\n" +
                                "\n" +
                                "양념\n" +
                                "소금(약간), 설탕(0.5), 식초(1.5), 와사비(0.5)");
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
