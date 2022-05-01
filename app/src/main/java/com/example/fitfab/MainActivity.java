package com.example.fitfab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    EditText userid;
    EditText password;
    public void login(View view){
        if(userid.getText().toString().isEmpty()){
            Toast.makeText(this, "Please enter a valid user id", Toast.LENGTH_SHORT).show();
        }
        if(password.getText().toString().isEmpty()){
            Toast.makeText(this, "Enter a valid password", Toast.LENGTH_SHORT).show();
        }
        if(!(userid.getText().toString().isEmpty() && password.getText().toString().isEmpty())){
            Intent main=new Intent(MainActivity.this, MainActivity2.class);
            startActivity(main);
        }
    }
    public void signup(View view){
        Intent intent=new Intent(MainActivity.this, signUpActivity.class);
        startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userid=findViewById(R.id.userid);
        password=findViewById(R.id.password);
    }
}