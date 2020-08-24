package services;

import java.util.ArrayList;

import models.Post.PostBp;
import models.Post.PostBpReading;
import models.Post.PostOtp;
import models.Post.PostPatientData;
import models.Post.PostRequestDoctor;
import models.Post.PostRequestOtp;
import models.Post.SignIn;
import models.RegisterUSer;
import models.response.BpReadings;
import models.response.PatientData;
import models.response.ResponseBloodPressure;
import models.response.ResponseBpReadings;
import models.response.ResponseGetOtp;
import models.response.ResponseLogin;
import models.response.ResponseMyDoctor;
import models.response.ResponseNewPatientData;
import models.response.ResponsePatientBp;
import models.response.ResponsePatientDataNew;
import models.response.ResponseRequestDoctor;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface MoyoService {



    @POST("register")
    Call<ResponseBody> registration(@Body RegisterUSer registerUSer);

    @POST("login")
    Call<ResponseLogin> signIn(@Body SignIn signIn);

    @POST("patient-bp")
    Call<ResponseBody> postBpReading(@Header("Authorization") String token,@Body PostBpReading postBpReading);

    @POST("patient-data")
    Call<ResponseBody> postPatientData(@Header("Authorization") String token,@Body PostPatientData postPatientData);

    @GET("patient-bp/{userId}")
    Call<ArrayList<ResponseBloodPressure>> getReadings(@Header("Authorization") String token, @Path("userId") String userId);

    @GET("patient-data/{userId}")
    Call<ArrayList<PatientData>> getPatientData(@Header("Authorization") String token, @Path("userId") String userId);

    @POST("request-doctor")
    Call<ResponseRequestDoctor> postRequestDoctor(@Header("Authorization") String token, @Body PostRequestDoctor postRequestDoctor);

    @GET("patient-prescription/{userId}")
    Call<ArrayList<ResponseNewPatientData>> getNewPatientData(@Header("Authorization") String token, @Path("userId") String userId);

    @GET("doctors/{userId}")
    Call<ResponseMyDoctor>getMyDoctor(@Header("Authorization") String token, @Path("userId") String userId);

    @PUT("otp/update")
    Call<ResponseGetOtp> getOtp(@Body PostRequestOtp postRequestOtp);

    @POST("login")
    Call<ResponseLogin> postOtp(@Body PostOtp postOtp);

    @GET("patient-prescription/{userId}")
    Call<ArrayList<ResponsePatientDataNew>> getPatientNew(@Header("Authorization") String token, @Path("userId") String userId);

    @GET("bp-readings/{userId}")
    Call<ArrayList<ResponseBpReadings>> getBpReadings(@Header("Authorization") String token, @Path("userId") String userId);

    @POST("patient-bp")
    Call<ResponsePatientBp> postPatientBp(@Header("Authorization") String token, @Body PostBp postBp);






}
