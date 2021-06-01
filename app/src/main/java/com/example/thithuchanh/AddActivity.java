package com.example.thithuchanh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thithuchanh.api.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        btnCreate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCreate_add: {
                String name = tvName.getText().toString();
                String age = tvAge.getText().toString();
                String depart = tvDepartment.getText().toString();
                APIService.apiService.addUser(new User(name, age, depart)).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        clear();
                        Toast.makeText(getBaseContext(), "success", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });
            }
        }
    }

    public void clear() {
        tvName.setText("");
        tvAge.setText("");
        tvDepartment.setText("");
    }

}