package com.example.appvideo.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appvideo.Database.DBManager;
import com.example.appvideo.FirebaseConection.FirebaseUser;
import com.example.appvideo.R;
import com.example.appvideo.model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseUser firebaseUser;
    Button buttonLogUp;
    DBManager dbManager;
    EditText nameSigUp, emailSigUp, passwordSigUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firebaseUser = new FirebaseUser();
        buttonLogUp = findViewById(R.id.signUpUser);
        nameSigUp = findViewById(R.id.namesigup);
        emailSigUp = findViewById(R.id.emailsigup);
        passwordSigUp = findViewById(R.id.passwordSigup);
        firebaseUser.createUserObject();

        dbManager = new DBManager(SignUpActivity.this);
        setOnclickBt();
    }

    private void setOnclickBt() {
        buttonLogUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int d = random.nextInt(99999);
                User user = new User(d, nameSigUp.getText().toString(), emailSigUp.getText().toString(), "không có dữ liệu", "không có dữ liệu", "không có dữ liệu", passwordSigUp.getText().toString());


                //// lưu dữ liệu user vào fribase//////

                firebaseUser.addUserObject(user);
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
    }
}