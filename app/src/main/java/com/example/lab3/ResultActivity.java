package com.example.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().hide();
        EditText result = findViewById(R.id.result);

        result.setKeyListener(null);
        result.setText("");

        result.append(String.format("%s %s \n", getString(R.string.you), getIntent().getStringExtra("fio")));
        result.append(String.format("%s %s \n", getString(R.string.your_gender), getIntent().getStringExtra("gender")));
        result.append(String.format("%s %s \n", getString(R.string.your_cookie), getIntent().getStringExtra("cookie")));
        result.append(String.format("%s %s \n", getString(R.string.your_info), getIntent().getStringExtra("info")));
        result.append(String.format("%s %s \n", getString(R.string.your_nationality), getIntent().getStringExtra("nationality")));
    }
    public void toTest(View v) {
        Intent intent = new Intent(ResultActivity.this, TestActivity.class);
        startActivity(intent);
    }
    public void exit(View v) {
        finishAffinity();
    }
}
