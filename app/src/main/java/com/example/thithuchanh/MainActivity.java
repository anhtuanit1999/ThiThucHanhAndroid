package com.example.thithuchanh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.thithuchanh.api.APIService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements onClickListener, View.OnClickListener {
    List<User> users;
    RecyclerView recyclerV;
    CustomAdapter adt;

    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerV = findViewById(R.id.recyclerV);
        users = new ArrayList<>();
        adt = new CustomAdapter( getBaseContext(),users,this);

        btnBack = findViewById(R.id.btnBack_main);
        btnBack.setOnClickListener(this);

        recyclerV.setHasFixedSize(true);
        recyclerV.setAdapter(adt);
        recyclerV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        getAll();
    }

    @Override
    public void ClickItem(User user) {

    }

    public void getAll(){
        APIService.apiService.findAll().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                users = response.body();
                adt.setList(response.body());
                Toast.makeText(getBaseContext(), "success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBack_main: {
                finish();
            }
        }
    }
}