package com.example.moyoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import models.Post.PostRequestOtp;
import models.response.ResponseGetOtp;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import services.MoyoService;
import services.MyConfig;
import services.RetrofitRequest;

public class EnterPhoneActivity extends AppCompatActivity {

    private Button buttonVerify;
//    private TextView forgotpasswordtextView;
    ProgressBar progressBar;

    MoyoService moyoService;

    EditText editText_enterphonenumber ;
//    EditText editText_signin_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterphonenumber);

        //hide the appbar
        getSupportActionBar().hide();

        setView();

        progressBar.setVisibility(View.GONE);


    }


    private void setView() {
        editText_enterphonenumber = findViewById(R.id.editText_enterphonenumber);
//        editText_signin_password = findViewById(R.id.editText_signin_password);

        buttonVerify = findViewById(R.id.buttonVerify);
//        forgotpasswordtextView = findViewById(R.id.textView_forgotpassword);
        progressBar = findViewById(R.id.my_progressBar);

//
//        forgotpasswordtextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(EnterPhoneActivity.this, ResetPasswordActivity.class);
//                startActivity(intent);
//            }
//        });


        buttonVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                String phonenumber = editText_enterphonenumber.getText().toString();
                phonenumber = phonenumber.substring(1);
                moyoService = RetrofitRequest.getRetrofitInstance().create(MoyoService.class);
                PostRequestOtp postRequestOtp=new PostRequestOtp("+254"+phonenumber);
                Call<ResponseGetOtp> requestOtpCall = moyoService.getOtp(postRequestOtp);
                requestOtpCall.enqueue(new Callback<ResponseGetOtp>() {
                    @Override
                    public void onResponse(Call<ResponseGetOtp> call, Response<ResponseGetOtp> response) {
                        progressBar.setVisibility(View.GONE);

                        Log.e("phoneNambaTest",String.valueOf(response.body()));

                        if (response.isSuccessful()){
                            progressBar.setVisibility(View.GONE);



                            saveToSharedprefference(response.body().getPhone(),response.body().getDoctor_id());



                        }
                        Intent intent = new Intent(EnterPhoneActivity.this,VerifyActivity.class);
                        startActivity(intent);
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onFailure(Call<ResponseGetOtp> call, Throwable t) {

                    }
                });






            }
        });

    }

//    public void LogIn(SignIn signIn) {
//        progressBar.setVisibility(View.VISIBLE);
//
//        moyoService = RetrofitRequest.getRetrofitInstance().create(MoyoService.class);
//        Call<ResponseLogin> responseLoginCall = moyoService.signIn(signIn);
//        responseLoginCall.enqueue(new Callback<ResponseLogin>() {
//            @Override
//            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
//
//                if (response.isSuccessful()) {
//                    progressBar.setVisibility(View.GONE);
//
//                    ResponseLogin responseLogin = response.body();
//                    //todo
////                    get token and id from reponse
//                    String token = responseLogin.getToken();
//                    String userId = responseLogin.getUser().getId();
//
//                    //save to shareprefference
//                    saveToSharedprefference(token, userId);
//                    Intent intent = new Intent(EnterPhoneActivity.this, VerifyActivity.class);
//                    startActivity(intent);
//                }else{
//                    progressBar.setVisibility(View.GONE);
//
//                    Toast.makeText(EnterPhoneActivity.this, "Login Failed!", Toast.LENGTH_LONG).show();
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseLogin> call, Throwable t) {
//
//
//
////                Toast.makeText(EnterPhoneActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(EnterPhoneActivity.this, "Login Failed!!!Check Your Internet Connection...", Toast.LENGTH_LONG).show();
//                progressBar.setVisibility(View.GONE);
//
//
//
//
//            }
//        });
//
//    }
//
public void saveToSharedprefference(String phone, String doctors_id) {
    SharedPreferences sharedPref = getSharedPreferences(MyConfig.SHARED_PREF_USER, Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPref.edit();
    editor.putString("phone", phone);
    editor.putString("doctors_id", doctors_id);
    editor.apply();
}
}