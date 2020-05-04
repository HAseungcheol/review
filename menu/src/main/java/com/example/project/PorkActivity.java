package com.example.project;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class PorkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pork);

        Button button = findViewById(R.id.material4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("★재료 준비★")
                        .setMessage(" 메인재료>\n" +
                                "돼지고기(안심) 210g, 양파 1/4개 빨강·노랑 파프리카 1/2개씩,\n" +
                                "브로콜리 150g 마늘 3개\n" +
                                "\n" +
                                " 돼지고기 밑간 재료>\n" +
                                "진간장 1TS, 청주 1TS, 생강가루 0.5ts, 참기름 0.5ts,\n" +
                                "후춧가루 조금\n" +
                                "\n" +
                                " 볶음양념 재료>\n" +
                                "두반장 2TS, 고추기름 1TS, 멸치육수 1TS, 간장 1ts, 청주 1ts, 참기름 0.5ts");
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
