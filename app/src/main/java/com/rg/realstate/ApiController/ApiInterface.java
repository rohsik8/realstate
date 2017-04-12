package com.rg.realstate.ApiController;



import com.rg.realstate.ApiController.ResponseDTO.LoginResponseDto;
import com.rg.realstate.ApiController.ResponseDTO.ProfileResponseDTO;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by kishor on 02/04/17.
 */

public interface ApiInterface{


    //for login
    @GET(ApiConfig.loginUrl)
    Call<LoginResponseDto> getLogin(@Path("phone") String phone);


    @GET(ApiConfig.smsCodeValidUrl)
    Call<LoginResponseDto> validateSMSCode(@Path("phone") String phone, @Path("code") String code);


    @GET(ApiConfig.profileUrl)
    Call<ProfileResponseDTO> getProfileDetail(@Header("Phone") String phone, @Header("Auth-Token") String token);

    @FormUrlEncoded
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @POST(ApiConfig.editUserProfileUrl)
    Call<ProfileResponseDTO> editUserProfile(@Header("Phone") String phone, @Header("Auth-Token") String token, @Field("firstname") String firstname, @Field("lastname") String lastname);





}
