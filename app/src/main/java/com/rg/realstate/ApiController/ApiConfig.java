package com.rg.realstate.ApiController;

/**
 * Created by kishor on 02/04/17.
 */

public interface ApiConfig {

    int CONNECT_TIMEOUT = 5000;
    int READ_TIMEOUT = 10000;
    String baseUrl = "http://134.119.9.116:8080";
    String loginUrl = baseUrl+"/rest/login/{phone}";
    String smsCodeValidUrl = loginUrl+"/validate/{code}";
    String profileUrl = baseUrl+"/rest/user/my";
    String editUserProfileUrl = baseUrl+"/rest/user/edit";

}
