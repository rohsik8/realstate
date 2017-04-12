package com.rg.realstate.ApiController.ResponseDTO;

/**
 * Created by kishor on 02/04/17.
 */

public class ProfileResponseDTO {


    /**
     * statusCode : 2000
     * statusMessage : Code OK
     * data : {"id":10,"username":"","firstName":"Martin","lastName":"Wolff","phone":"4915121700538","mail":"","lang":"de","role":"user","corporation":"","corporationId":"","enabled":true}
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
         * id : 10
         * username :
         * firstName : Martin
         * lastName : Wolff
         * phone : 4915121700538
         * mail :
         * lang : de
         * role : user
         * corporation :
         * corporationId :
         * enabled : true
         */

        private int id;
        private String username;
        private String firstName;
        private String lastName;
        private String phone;
        private String mail;
        private String lang;
        private String role;
        private String corporation;
        private String corporationId;
        private String imageSmall;

        public String getImageSmall() {
            return imageSmall;
        }

        public void setImageSmall(String imageSmall) {
            this.imageSmall = imageSmall;
        }

        public String getImageBig() {
            return imageBig;
        }

        public void setImageBig(String imageBig) {
            this.imageBig = imageBig;
        }

        private String imageBig;
        private boolean enabled;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getCorporation() {
            return corporation;
        }

        public void setCorporation(String corporation) {
            this.corporation = corporation;
        }

        public String getCorporationId() {
            return corporationId;
        }

        public void setCorporationId(String corporationId) {
            this.corporationId = corporationId;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }
}
