package com.example.admin.jewelry.information.bean;

import java.util.List;

/**
 * Created by admin on 2016/8/15.
 */
public class InformationBean {
    /**
     * status : 1
     * msg : 鑾峰彇澶ц瘽璧勮鍒楄〃鎴愬姛锛�
     * object : {"list":[{"entity_id":"1","message_userId":"1000005","message_userHeadPic":"http://192.168.31.110:8911/resources/boastjewelry/upload/user_head/icon.jpg","message_userNickName":"鐩栦鸡","message_userIdTitle":"鐜涜タ浜氫箣鍔�","category_id":"1","message_title":"1000005_璧勮01_绫诲埆1","message_info":"","message_facePic":"http://192.168.31.110:8911/resources/boastjewelry/upload/dhMessage/dhzx01.jpg","message_pic":"http://192.168.31.110:8911/resources/boastjewelry/upload/dhMessage/dhzx01.jpg,http://192.168.31.110:8911/resources/boastjewelry/upload/dhMessage/dhzx02.jpg","look_times":"0","reply_num":"7","create_time":"2016-08-02 12:34:45","state":"","webViewHref":"views/message/info.jsp?eid=1"},{"entity_id":"2","message_userId":"1000005","message_userHeadPic":"http://192.168.31.110:8911/resources/boastjewelry/upload/user_head/icon.jpg","message_userNickName":"鐩栦鸡","message_userIdTitle":"鐜涜タ浜氫箣鍔�","category_id":"1","message_title":"1000005_璧勮02_绫诲埆1","message_info":"","message_facePic":"http://192.168.31.110:8911/resources/boastjewelry/upload/dhMessage/dhzx02.jpg","message_pic":"http://192.168.31.110:8911/resources/boastjewelry/upload/dhMessage/dhzx02.jpg,http://192.168.31.110:8911/resources/boastjewelry/upload/dhMessage/dhzx01.jpg","look_times":"0","reply_num":"0","create_time":"2016-08-02 12:34:45","state":"","webViewHref":"views/message/info.jsp?eid=2"},{"entity_id":"3","message_userId":"1000005","message_userHeadPic":"http://192.168.31.110:8911/resources/boastjewelry/upload/user_head/icon.jpg","message_userNickName":"鐩栦鸡","message_userIdTitle":"鐜涜タ浜氫箣鍔�","category_id":"2","message_title":"1000005_璧勮03_绫诲埆2","message_info":"","message_facePic":"http://192.168.31.110:8911/resources/boastjewelry/upload/dhMessage/dhzx01.jpg","message_pic":"http://192.168.31.110:8911/resources/boastjewelry/upload/dhMessage/dhzx01.jpg,http://192.168.31.110:8911/resources/boastjewelry/upload/dhMessage/dhzx02.jpg","look_times":"0","reply_num":"0","create_time":"2016-08-02 12:34:45","state":"","webViewHref":"views/message/info.jsp?eid=3"}]}
     */

    private String status;
    private String msg;
    private ObjectBean object;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ObjectBean getObject() {
        return object;
    }

    public void setObject(ObjectBean object) {
        this.object = object;
    }

    public static class ObjectBean {
        /**
         * entity_id : 1
         * message_userId : 1000005
         * message_userHeadPic : http://192.168.31.110:8911/resources/boastjewelry/upload/user_head/icon.jpg
         * message_userNickName : 鐩栦鸡
         * message_userIdTitle : 鐜涜タ浜氫箣鍔�
         * category_id : 1
         * message_title : 1000005_璧勮01_绫诲埆1
         * message_info :
         * message_facePic : http://192.168.31.110:8911/resources/boastjewelry/upload/dhMessage/dhzx01.jpg
         * message_pic : http://192.168.31.110:8911/resources/boastjewelry/upload/dhMessage/dhzx01.jpg,http://192.168.31.110:8911/resources/boastjewelry/upload/dhMessage/dhzx02.jpg
         * look_times : 0
         * reply_num : 7
         * create_time : 2016-08-02 12:34:45
         * state :
         * webViewHref : views/message/info.jsp?eid=1
         */

        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private String entity_id;
            private String message_userId;
            private String message_userHeadPic;
            private String message_userNickName;
            private String message_userIdTitle;
            private String category_id;
            private String message_title;
            private String message_info;
            private String message_facePic;
            private String message_pic;
            private String look_times;
            private String reply_num;
            private String create_time;
            private String state;
            private String webViewHref;

            public String getEntity_id() {
                return entity_id;
            }

            public void setEntity_id(String entity_id) {
                this.entity_id = entity_id;
            }

            public String getMessage_userId() {
                return message_userId;
            }

            public void setMessage_userId(String message_userId) {
                this.message_userId = message_userId;
            }

            public String getMessage_userHeadPic() {
                return message_userHeadPic;
            }

            public void setMessage_userHeadPic(String message_userHeadPic) {
                this.message_userHeadPic = message_userHeadPic;
            }

            public String getMessage_userNickName() {
                return message_userNickName;
            }

            public void setMessage_userNickName(String message_userNickName) {
                this.message_userNickName = message_userNickName;
            }

            public String getMessage_userIdTitle() {
                return message_userIdTitle;
            }

            public void setMessage_userIdTitle(String message_userIdTitle) {
                this.message_userIdTitle = message_userIdTitle;
            }

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getMessage_title() {
                return message_title;
            }

            public void setMessage_title(String message_title) {
                this.message_title = message_title;
            }

            public String getMessage_info() {
                return message_info;
            }

            public void setMessage_info(String message_info) {
                this.message_info = message_info;
            }

            public String getMessage_facePic() {
                return message_facePic;
            }

            public void setMessage_facePic(String message_facePic) {
                this.message_facePic = message_facePic;
            }

            public String getMessage_pic() {
                return message_pic;
            }

            public void setMessage_pic(String message_pic) {
                this.message_pic = message_pic;
            }

            public String getLook_times() {
                return look_times;
            }

            public void setLook_times(String look_times) {
                this.look_times = look_times;
            }

            public String getReply_num() {
                return reply_num;
            }

            public void setReply_num(String reply_num) {
                this.reply_num = reply_num;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getWebViewHref() {
                return webViewHref;
            }

            public void setWebViewHref(String webViewHref) {
                this.webViewHref = webViewHref;
            }
        }
    }
}
