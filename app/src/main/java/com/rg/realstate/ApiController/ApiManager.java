package com.rg.realstate.ApiController;



import com.rg.realstate.ApiController.ResponseDTO.LoginResponseDto;
import com.rg.realstate.ApiController.ResponseDTO.ProfileResponseDTO;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by kishor on 02/04/17.
 */

public class ApiManager {

    public static final String TAG = "ApiManager";
    //public static String schema= AppCache.getCachedJob().getSchemaname();
    public static String schema="";


    //get login

    public static void getLogin(Callback<LoginResponseDto> callback, String phone) {
        ApiInterface apiInterface = RestServiceGenerator.createService(ApiInterface.class);
        Call<LoginResponseDto> call = apiInterface.getLogin(phone);
        call.enqueue(callback);
    }


    public static void validateSMSCode(Callback<LoginResponseDto> callback, String phone, String code) {
        ApiInterface apiInterface = RestServiceGenerator.createService(ApiInterface.class);
        Call<LoginResponseDto> call = apiInterface.validateSMSCode(phone,code);
        call.enqueue(callback);
    }

    public static void getProfile(Callback<ProfileResponseDTO> callback, String phone, String auth) {
        ApiInterface apiInterface = RestServiceGenerator.createService(ApiInterface.class);
        Call<ProfileResponseDTO> call = apiInterface.getProfileDetail(phone,auth);
        call.enqueue(callback);
    }


    public static void editUserProfile(Callback<ProfileResponseDTO> callback, String phone, String auth,String firstname, String lastname) {
        ApiInterface apiInterface = RestServiceGenerator.createService(ApiInterface.class);
        Call<ProfileResponseDTO> call = apiInterface.editUserProfile(phone,auth,firstname,lastname);
        call.enqueue(callback);
    }

   /* //post job notes

    public static void  postJobNotes(Callback<PostJobNotesDTO> callback, String tblname, String refid, String userid,String notes) {
        ApiInterface apiInterface = RestServiceGenerator.createService(ApiInterface.class);
        Call<PostJobNotesDTO> call = apiInterface.postJobNotes(tblname,refid,userid,notes);
        call.enqueue(callback);
    }

    //post job notes

    public static void  postJobNotesBody(Callback<PostJobNotesDTO> callback, CreateJobNotesDTO model) {
        ApiInterface apiInterface = RestServiceGenerator.createService(ApiInterface.class);
        Call<PostJobNotesDTO> call = apiInterface.postJobNotesBody(model);
        call.enqueue(callback);
    }


    //post garagedoor

    public static void  postGaragedoorBody(Callback<PostJobNotesDTO> callback, GarageDoorDto model) {
        ApiInterface apiInterface = RestServiceGenerator.createService(ApiInterface.class);
        Call<PostJobNotesDTO> call = apiInterface.postGarage(model);
        call.enqueue(callback);
    }
*/
}
