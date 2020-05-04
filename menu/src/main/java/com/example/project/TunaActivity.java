package com.example.project;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TunaActivity extends AppCompatActivity {
    ListView comment_list;
    TextView time_text;
    EditText comment_edit;
    ImageView jrv_image_img;
    Comment_Adapter ca;
    ArrayList<Comment_Item> c_arr = new ArrayList<Comment_Item>();
    View header,footer;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuna);
        init();
    }
    public void init() {
        comment_list = (ListView) findViewById(R.id.jrv_comment_list);
    }
}
