package com.example.fitfab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.AuthResult;

public class signUpActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    public void submit(View view){
        EditText name=findViewById(R.id.name);
        EditText email=findViewById(R.id.email);
        EditText age=findViewById(R.id.age);
        EditText weight=findViewById(R.id.weight);
        EditText height=findViewById(R.id.height);
        EditText password=findViewById(R.id.passwordSignUp);
        EditText conf_password=findViewById(R.id.passwordConfirm);
        if(name.getText().toString().isEmpty()){
            Toast.makeText(this, "Enter your name", Toast.LENGTH_SHORT).show();
        }
        if(email.getText().toString().isEmpty()){
            Toast.makeText(this, "Enter your email Id", Toast.LENGTH_SHORT).show();
        }
        if(age.getText().toString().isEmpty()){
            Toast.makeText(this, "Enter your age", Toast.LENGTH_SHORT).show();
        }
        if(weight.getText().toString().isEmpty()){
            Toast.makeText(this, "Enter your weight", Toast.LENGTH_SHORT).show();
        }
        if(height.getText().toString().isEmpty()){
            Toast.makeText(this, "Enter your height", Toast.LENGTH_SHORT).show();
        }
        if(password.getText().toString().isEmpty()){
            Toast.makeText(this, "Enter a password", Toast.LENGTH_SHORT).show();
        }
        if(conf_password.getText().toString().isEmpty()){
            Toast.makeText(this, "Confirm your password", Toast.LENGTH_SHORT).show();
        }
//        if(password.getText().toString()!=conf_password.getText().toString()){
//            Toast.makeText(this, "Entered password and Confirm password does not match", Toast.LENGTH_SHORT).show();
//        }
        FirebaseAuth firebaseAuth= FirebaseAuth.getInstance();
        if(!(name.getText().toString().isEmpty() && email.getText().toString().isEmpty() && age.getText().toString().isEmpty() && weight.getText().toString().isEmpty() && height.getText().toString().isEmpty() && password.getText().toString().isEmpty() && conf_password.getText().toString().isEmpty())){
            firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful()){
                       Intent in =new Intent(signUpActivity.this, MainActivity.class);
                       startActivity(in);
                   }
                   else{
                       Toast.makeText(signUpActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                   }
                }
            });
        }
        
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        
    }
}