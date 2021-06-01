package com.example.thithuchanh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText tvEmail, tvPass;
    private Button btnLogin;
    private TextView txtExit;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();

        tvEmail = findViewById(R.id.tvEmail_login);
        tvPass = findViewById(R.id.tvPass_login);

        btnLogin = findViewById(R.id.btnLogin);
        txtExit = findViewById(R.id.txtExit);

        btnLogin.setOnClickListener(this);
        txtExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin: {
                String email = tvEmail.getText().toString();
                String pass = tvPass.getText().toString();
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pass))
                    Toast.makeText(getBaseContext(), "Input field is empty", Toast.LENGTH_SHORT).show();
                else login(email, pass);
                break;
            }
            case R.id.txtExit: {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
                break;
            }
        }
    }

    public void login(String email, String pass) {
        auth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Intent intent = new Intent(LoginActivity.this, ManagerActivity.class);
                            Toast.makeText(getBaseContext(), "success", Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        } else {
                            Toast.makeText(getBaseContext(), "Fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}