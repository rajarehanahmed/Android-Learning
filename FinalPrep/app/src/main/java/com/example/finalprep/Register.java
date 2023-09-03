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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    private EditText txtBoxEmail;
    private EditText txtBoxPassword;
    private EditText txtBoxName;
    private EditText txtBoxContact;
    private Button rgstr;
    private TextView tvLogin;
    private FirebaseAuth fbAuth;
    private FirebaseFirestore fStore;
    private String userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtBoxEmail = findViewById(R.id.txtBox1);
        txtBoxPassword = findViewById(R.id.txtBox2);
        txtBoxName = findViewById(R.id.txtBox3);
        txtBoxContact = findViewById(R.id.txtBox4);
        rgstr = findViewById(R.id.btn1);
        tvLogin = findViewById(R.id.tvLogin);
        fbAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        rgstr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(TextUtils.isEmpty(txtBoxEmail.getText()))) {
                    if(!(TextUtils.isEmpty(txtBoxPassword.getText()))) {
                        fbAuth.createUserWithEmailAndPassword(txtBoxEmail.getText().toString(), txtBoxPassword.getText().toString()).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    userId = fbAuth.getCurrentUser().getUid();
                                    DocumentReference documentRef = fStore.collection("users").document(userId);
                                    Map<String, Object> user = new HashMap<>();
                                    user.put("email", txtBoxEmail.getText().toString());
                                    user.put("name", txtBoxName.getText().toString());
                                    user.put("contactNo", txtBoxContact.getText().toString());
                                    user.put("pass", txtBoxPassword.getText().toString());
                                    documentRef.set(user);
                                    Toast.makeText(Register.this, "Account Registered Successfully.", Toast.LENGTH_LONG).show();
                                }
                                else {
                                    Toast.makeText(Register.this, "Account Register Failed : " + task.getException(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                    else{
                        Toast.makeText(Register.this, "Password Can't be empty", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(Register.this, "Both Fields have to be filled!", Toast.LENGTH_LONG).show();
                }
            }
        });
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this, Login.class));
            }
        });
    }
}