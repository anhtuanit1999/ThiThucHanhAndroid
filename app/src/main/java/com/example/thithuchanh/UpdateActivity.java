package com.example.thithuchanh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thithuchanh.api.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvName, tvAge, tvDepartment;
    private Button btnUpdate, btnBack;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        tvName = findViewById(R.id.tvName_update);
        tvAge = findViewById(R.id.tvAge_update);
        tvDepartment = findViewById(R.id.tvDepart_update);

        btnUpdate = findViewById(R.id.btnSave_update);
        btnBack = findViewById(R.id.btnBack_update);

        btnUpdate.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        Intent intent = getIntent();
        user = new User();
        user.setId(intent.getStringExtra("id"));
        user.setName(intent.getStringExtra("name"));
        user.setAge(intent.getStringExtra("age"));
        user.setDepartment(intent.getStringExtra("department"));

        tvName.setText(user.getName());
        tvAge.setText(user.getAge());
        tvDepartment.setText(user.getDepartment());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave_update: {
                user.setName(tvName.getText().toString());
                user.setAge(tvAge.getText().toString());
                user.setDepartment(tvDepartment.getText().toString());
                APIService.apiService.updateUser(user.getId(), user).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Toast.makeText(getBaseContext(), "success", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });
                break;
            }
            case R.id.btnBack_update: {
                finish();
                break;
            }
        }
    }
}