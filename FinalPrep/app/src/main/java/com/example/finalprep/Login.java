package com.example.finalprep;

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

public class Login extends AppCompatActivity {
    private EditText txtBoxEmail;
    private EditText txtBoxPassword;
    private Button btnLogin;
    private TextView tvRegister;
    private FirebaseAuth fbAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtBoxEmail = findViewById(R.id.txtBox1);
        txtBoxPassword = findViewById(R.id.txtBox2);
        btnLogin = findViewById(R.id.btn1);
        tvRegister = findViewById(R.id.tvReg);
        fbAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(TextUtils.isEmpty(txtBoxEmail.getText()))) {
                    if (!(TextUtils.isEmpty(txtBoxPassword.getText()))) {
                        fbAuth.signInWithEmailAndPassword(txtBoxEmail.getText().toString(), txtBoxPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    startActivity(new Intent(Login.this, MainActivity.class));
                                }
                                else{
                                    Toast.makeText(Login.this, "Login Failed : " + task.getException(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                    else{
                        Toast.makeText(Login.this, "Password Can't be empty", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(Login.this, "Both Fields have to be filled!", Toast.LENGTH_LONG).show();
                }
            }
        });


        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });
    }
}