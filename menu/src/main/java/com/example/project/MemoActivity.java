package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MemoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_memo);

        Button save = findViewById(R.id.btnSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_values();
                Intent intent = new Intent(getApplicationContext(), WasabiActivity.class);
                startActivity(intent);
                finish();
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
}

