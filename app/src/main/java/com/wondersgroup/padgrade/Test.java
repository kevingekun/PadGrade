package com.wondersgroup.padgrade;

/**
 * Created by Buger on 17/5/4/004.
 */

public class Test {

    /**
     * result : 100
     * message : 操作成功
     * sessionID : null
     * userInfo : {"aac003":"223424","aac147":"37023423424234","ajl011":0,"cec001":0,"cec002":"","cee011":0,"cee015":0,"cee017":0,"cee018":"","cee019":"","cee020":0,"cee021":"","cee022":0}
     */

    private String result;
    private String message;
    private String sessionID;
    private UserInfoBean userInfo;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public static class UserInfoBean {
        /**
         * aac003 : 223424
         * aac147 : 37023423424234
         * ajl011 : 0
         * cec001 : 0
         * cec002 :
         * cee011 : 0
         * cee015 : 0
         * cee017 : 0
         * cee018 :
         * cee019 :
         * cee020 : 0
         * cee021 :
         * cee022 : 0
         */

        private String aac003;
        private String aac147;
        private int ajl011;
        private int cec001;
        private String cec002;
        private int cee011;
        private int cee015;
        private int cee017;
        private String cee018;
        private String cee019;
        private int cee020;
        private String cee021;
        private int cee022;

        public String getAac003() {
            return aac003;
        }

        public void setAac003(String aac003) {
            this.aac003 = aac003;
        }

        public String getAac147() {
            return aac147;
        }

        public void setAac147(String aac147) {
            this.aac147 = aac147;
        }

        public int getAjl011() {
            return ajl011;
        }

        public void setAjl011(int ajl011) {
            this.ajl011 = ajl011;
        }

        public int getCec001() {
            return cec001;
        }

        public void setCec001(int cec001) {
            this.cec001 = cec001;
        }

        public String getCec002() {
            return cec002;
        }

        public void setCec002(String cec002) {
            this.cec002 = cec002;
        }

        public int getCee011() {
            return cee011;
        }

        public void setCee011(int cee011) {
            this.cee011 = cee011;
        }

        public int getCee015() {
            return cee015;
        }

        public void setCee015(int cee015) {
            this.cee015 = cee015;
        }

        public int getCee017() {
            return cee017;
        }

        public void setCee017(int cee017) {
            this.cee017 = cee017;
        }

        public String getCee018() {
            return cee018;
        }

        public void setCee018(String cee018) {
            this.cee018 = cee018;
        }

        public String getCee019() {
            return cee019;
        }

        public void setCee019(String cee019) {
            this.cee019 = cee019;
        }

        public int getCee020() {
            return cee020;
        }

        public void setCee020(int cee020) {
            this.cee020 = cee020;
        }

        public String getCee021() {
            return cee021;
        }

        public void setCee021(String cee021) {
            this.cee021 = cee021;
        }

        public int getCee022() {
            return cee022;
        }

        public void setCee022(int cee022) {
            this.cee022 = cee022;
        }
    }
}
