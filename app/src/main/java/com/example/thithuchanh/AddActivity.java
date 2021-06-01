package com.example.thithuchanh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText tvName, tvAge, tvDepartment;
    private Button btnCreate, btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        tvName = findViewById(R.id.tvName_add);
        tvAge = findViewById(R.id.tvAge_add);
        tvDepartment = findViewById(R.id.tvDepart_add);

        btnCreate = findViewById(R.id.btnCreate_add);
        btnBack = findViewById(R.id.btnBack_add);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCreate_add: {
                String Name = tvName.getText().toString();
                String age = tvAge.getText().toString();
                String depart = tvDepartment.getText().toString();
            }
        }
    }
}