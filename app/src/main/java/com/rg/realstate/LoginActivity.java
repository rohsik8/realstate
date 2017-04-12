package com.rg.realstate;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.rg.realstate.ApiController.ApiManager;

import com.rg.realstate.ApiController.CustomDialogs;
import com.rg.realstate.ApiController.ResponseDTO.LoginResponseDto;
import com.rg.realstate.utils.AppConstants;
import com.rg.realstate.utils.AppLog;
import com.rg.realstate.utils.AppUtils;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;


/**
 * Created by kishor on 08/03/17.
 */

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();
    Dialog pDialog;

    SharedPreferences sharedPreferences;
    private Callback<LoginResponseDto> loginResponseDtoCallback;

    @BindView(R.id.btn_send_sms_code)
    Button sendSmsCode;

    @BindView(R.id.tv_phone_number)
    EditText phoneNumber;

    @BindView(R.id.ll_pop_up_message)
    LinearLayout popUp;


   /* @OnClick(R.id.tv_phone_number) void editClick(){
        popUp.setVisibility(View.GONE);
    }*/

    @OnClick(R.id.btn_send_sms_code) void sendCode(){
        if(phoneNumber.getText().toString().isEmpty()){
            popUp.setVisibility(View.VISIBLE);
        }else {

            /*Intent intent;
            intent = new Intent(SendSmsCodeActvity.this, ValidateSmsCodeActivity.class);
            intent.putExtra("number", phoneNumber.getText().toString());
            startActivity(intent);
            finish();*/

            if (AppUtils.hasInternet(LoginActivity.this)) {

                pDialog = CustomDialogs.progressDialog(LoginActivity.this,"Loading");
                pDialog.show();
                ApiManager.getLogin(loginResponseDtoCallback, phoneNumber.getText().toString());

            } else {

                Toast.makeText(LoginActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();

            }
        }
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        ButterKnife.bind(this);
        AppUtils.transparentStatusBar(getWindow());
        KeyboardVisibilityEvent.setEventListener(
                this,
                new KeyboardVisibilityEventListener() {
                    @Override
                    public void onVisibilityChanged(boolean isOpen) {
                        popUp.setVisibility(View.GONE);
                    }
                });

        /*smsCode.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    popUp.setVisibility(View.GONE);
                }
            }
        });*/

        //retrofit login response call back
        loginResponseDtoCallback = new Callback<LoginResponseDto>() {
            @Override
            public void onResponse(Call<LoginResponseDto> call, retrofit2.Response<LoginResponseDto> response) {
                AppLog.d(TAG, response.body().toString());
                pDialog.dismiss();
                if (response.isSuccessful()) {
                    LoginResponseDto validateSMSResponse = response.body();

                    if (validateSMSResponse.getStatusCode()==200) {

//                        Toast.makeText(LoginActivity.this,"SMS was sent to"+loginResponse.getPhone(),Toast.LENGTH_SHORT).show();
                        sharedPreferences.edit().putString(AppConstants.TOKEN, validateSMSResponse.getData().getToken()).apply();
                        sharedPreferences.edit().putString(AppConstants.PHONE, validateSMSResponse.getData().getPhone()).apply();
                        AppLog.e(TAG, "Token: "+validateSMSResponse.getData().getToken());

                        Intent intent;
                        intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();



                    } else if(validateSMSResponse.getStatusCode()==401){

                        Toast.makeText(LoginActivity.this, validateSMSResponse.getStatusMessage(), Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Server Error", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<LoginResponseDto> call, Throwable t) {
                pDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                AppLog.e(TAG, "error code: ");
                AppLog.d(TAG, "failed");
            }
        };




    }
}
