package com.example.moyoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import models.RegisterUSer;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.MoyoService;
import services.RetrofitRequest;

public class SignUpActivity extends AppCompatActivity {

    private Button signUpbutton;

    MoyoService moyoService;

    TextView editText_signup_city,editText_signup_password,editText_signup_email,editText_lastname,editText_firstname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //hide the appbar
        getSupportActionBar().hide();

        setViews();

        signUpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get all the fields
                String first=editText_firstname.getText().toString();
                String last_name=editText_lastname.getText().toString();
                String email=editText_signup_email.getText().toString();
                String password=editText_signup_password.getText().toString();
                String town=editText_signup_city.getText().toString();

                RegisterUSer registerUSer=new RegisterUSer(first,last_name,email,password,town);
                postRegistration(registerUSer);


            }
        });


    }

    private void setViews() {

        signUpbutton = findViewById(R.id.button_signup);

        editText_firstname=findViewById(R.id.editText_firstname);
        editText_lastname=findViewById(R.id.editText_lastname);
        editText_signup_email=findViewById(R.id.editText_signup_email);
        editText_signup_password=findViewById(R.id.editText_signup_password);
        editText_signup_city=findViewById(R.id.editText_signup_city);

    }

    public void postRegistration(RegisterUSer registerUSer){

        moyoService = RetrofitRequest.getRetrofitInstance().create(MoyoService.class);

        Call<ResponseBody> responseCall = moyoService.registration(registerUSer);
        responseCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful()){
                                    Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Toast.makeText(SignUpActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }});
        }



}
