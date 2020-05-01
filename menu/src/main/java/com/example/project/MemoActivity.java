package com.example.project;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MemoActivity extends AppCompatActivity {
    Button save;
    Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_memo);

        save = findViewById(R.id.btnSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("저장하실 건가요?").setMessage("아직 실력이 부족해서 삭제 기능을 못 구현하였습니다.. ㅠ");
                builder.setPositiveButton("등록", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getApplicationContext(), "등록 완료!", Toast.LENGTH_SHORT).show();
                        save_values();
                        Intent intent = new Intent(getApplicationContext(), WasabiActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getApplicationContext(), "한 번 더 확인해 주셔서 감사합니다!", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        delete = findViewById(R.id.btnDelete);
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "미구현 ㅠㅠ....", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void save_values() {
        EditText editTitle = (EditText) findViewById(R.id.editTitle);
        String title = editTitle.getText().toString();
        EditText editContent = (EditText) findViewById(R.id.editContent);
        String content = editContent.getText().toString();

        MemoVO vo = new MemoVO();
        vo.setTitle(title);
        vo.setContent(content);
        new MemoDAO().insert(getApplicationContext(), vo);
    }
    private void delete_value() {

    }
}

