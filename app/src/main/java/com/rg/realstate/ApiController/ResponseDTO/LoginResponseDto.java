package com.rg.realstate.ApiController.ResponseDTO;

/**
 * Created by kishor on 02/04/17.
 */

public class LoginResponseDto {
    /**
     * statusCode : 2000
     * statusMessage : Code OK
     * data : {"phone":"123123123","token":"5581c53953c7874be59b1f7403f0fd12"}
     */

    private int statusCode;
    private String statusMessage;
    private DataBean data;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * phone : 123123123
         * token : 5581c53953c7874be59b1f7403f0fd12
         */

        private String phone;
        private String token;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }




   /* *//**
     * statusCode : 2000
     * statusMessage : SMS sent
     * phone : 49123465789
     * token :
     *//*

    private int statusCode;
    private String statusMessage;
    private String phone;
    private String token;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }*/
}
