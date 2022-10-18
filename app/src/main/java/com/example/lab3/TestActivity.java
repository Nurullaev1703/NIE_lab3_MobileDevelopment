package com.example.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class TestActivity extends AppCompatActivity {

    private EditText editText;
    private CheckBox cookie,info,politicy;
    private RadioGroup radioGroup;
    private RadioButton selectRadioButton,radioButton;
    private Spinner spinner;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        getSupportActionBar().hide();

        editText = findViewById(R.id.editTextTextPersonName);
        cookie = findViewById(R.id.cookie);
        info= findViewById(R.id.catchInfo);
        politicy = findViewById(R.id.politicy);
        radioGroup = findViewById(R.id.radioGroup);
        spinner = findViewById(R.id.spinner);
        radioButton = findViewById(R.id.radioButton);
        radioButton.toggle();
        next = findViewById(R.id.buttonNext);
        next.setEnabled(false);
        if (savedInstanceState != null) {
            editText.setText(savedInstanceState.getString("y"));
            next.setEnabled( savedInstanceState.getBoolean("vButton") );
        }
        else{
            next.setEnabled(false);
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Сохранение нужных нам значений компонент при перевороте экрана
        outState.putString("y", editText.getText().toString());
        outState.putBoolean("vButton", next.isEnabled());
    }
    public void enableButton(View v){
        if(politicy.isChecked() == true){
            next.setEnabled(true);
        }
        else{
            next.setEnabled(false);
        }
    }
    public void onResult(View v){
        Intent intent = new Intent(TestActivity.this, ResultActivity.class);
        selectRadioButton = findViewById(radioGroup.getCheckedRadioButtonId());
        intent.putExtra("fio", editText.getText().toString());
        intent.putExtra("info", info.isChecked() ? "Принято" : "Не принято");
        intent.putExtra("cookie", cookie.isChecked() ? "Принято" : "Не принято");
        intent.putExtra("gender", selectRadioButton.getText());
        intent.putExtra("nationality", spinner.getSelectedItem().toString());

        startActivity(intent);
    }

    public void back(View v) {
        Intent intent = new Intent(TestActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void onExit(View v) {
        finishAffinity();
    }
}
