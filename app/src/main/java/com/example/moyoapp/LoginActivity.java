 package com.example.moyoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import models.Post.SignIn;
import models.response.ResponseLogin;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.MoyoService;
import services.MyConfig;
import services.RetrofitRequest;

 public class LoginActivity extends AppCompatActivity {

    private Button loginbutton;
    private TextView forgotpasswordtextView;

    MoyoService moyoService;

    EditText editText_signin_email,editText_signin_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //hide the appbar
        getSupportActionBar().hide();

        setView();



    }

     private void setView() {
         editText_signin_email =findViewById(R.id.editText_signin_email);
         editText_signin_password=findViewById(R.id.editText_signin_password);

         loginbutton = findViewById(R.id.button_login);
         forgotpasswordtextView = findViewById(R.id.textView_forgotpassword);


         forgotpasswordtextView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(LoginActivity.this,ResetPasswordActivity.class);
                 startActivity(intent);
             }
         });


         loginbutton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 String email=editText_signin_email.getText().toString();
                 String password=editText_signin_password.getText().toString();
                 SignIn signIn=new SignIn(email,password);
                 LogIn(signIn);
             }
         });

     }

     public void LogIn(SignIn signIn){
        moyoService = RetrofitRequest.getRetrofitInstance().create(MoyoService.class);
        Call<ResponseLogin> responseLoginCall=moyoService.signIn(signIn);
        responseLoginCall.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {

                if (response.isSuccessful()){
                    ResponseLogin responseLogin=response.body();
                    //todo
//                    Save token and id from reponse
                    String token=responseLogin.getToken();
                    String userId=responseLogin.getUser().getId();

                    //save to shareprefference
                    saveToSharedprefference(token,userId);
                    Intent intent = new Intent(
                            LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {

                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void saveToSharedprefference(String token,String id){
        SharedPreferences sharedPref = getSharedPreferences(MyConfig.SHARED_PREF_USER, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("token", token);
        editor.putString("id", id);
//                    editor.putString("CLIENT_SUBTYPE", clientSubType.toString());
        editor.apply();
    }
}