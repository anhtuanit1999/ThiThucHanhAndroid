package com.example.thithuchanh;

import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import com.google.firebase.auth.FirebaseAuth;

public class ManagerActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnInfo, btnAdd, btnLogout;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        auth = FirebaseAuth.getInstance();

        btnInfo = findViewById(R.id.btnInfo);
        btnAdd = findViewById(R.id.btnAdd);
        btnLogout = findViewById(R.id.btnLogout);

        btnInfo.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnInfo: {
                Intent intent = new Intent(ManagerActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btnAdd: {
                Intent intent = new Intent(ManagerActivity.this, AddActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btnLogout: {
                auth.signOut();
                Intent intent = new Intent(ManagerActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
