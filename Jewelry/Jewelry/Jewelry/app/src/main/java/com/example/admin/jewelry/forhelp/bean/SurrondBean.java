package com.example.admin.jewelry.forhelp.bean;

import java.util.List;

/**
 * Created by admin on 2016/8/18.
 */
public class SurrondBean {


    /**
     * status : 1
     * msg : 获取围观讨论帖子列表成功！
     * object : {"list":[{"entity_id":"1","help_userId":"1000002","help_userHeadPic":"http://192.168.31.110:8911/resources/boastjewelry/upload/1000002/user_head/icon.jpg","help_userNickName":"拉克丝","help_userIdTitle":"光辉女郎","category_id":"1","talk_title":"玉石讨论帖主题01","talk_info":"玉石讨论帖内容01","talk_pic":"http://192.168.31.110:8911/resources/boastjewelry/upload/1000005/dhHelp/talk01.jpg,http://192.168.31.110:8911/resources/boastjewelry/upload/1000005/dhHelp/talk02.jpg","look_times":"2","reply_num":"4","create_time":"2016-08-03 12:34:45","state":"1","isLike":"","like_num":"3","isReport":"1"},{"entity_id":"2","help_userId":"1000005","help_userHeadPic":"http://192.168.31.110:8911/resources/boastjewelry/upload/1000005/user_head/icon.jpg","help_userNickName":"盖伦","help_userIdTitle":"玛西亚之力","category_id":"1","talk_title":"玉石讨论帖主题02","talk_info":"玉石讨论帖内容02","talk_pic":"http://192.168.31.110:8911/resources/boastjewelry/upload/1000005/dhHelp/talk01.jpg,http://192.168.31.110:8911/resources/boastjewelry/upload/1000005/dhHelp/talk02.jpg","look_times":"0","reply_num":"0","create_time":"2016-08-03 12:34:45","state":"1","isLike":"","like_num":"2","isReport":"2"},{"entity_id":"3","help_userId":"1000005","help_userHeadPic":"http://192.168.31.110:8911/resources/boastjewelry/upload/1000005/user_head/icon.jpg","help_userNickName":"盖伦","help_userIdTitle":"玛西亚之力","category_id":"1","talk_title":"玉石讨论帖主题03","talk_info":"玉石讨论帖内容03","talk_pic":"http://192.168.31.110:8911/resources/boastjewelry/upload/1000005/dhHelp/talk01.jpg,http://192.168.31.110:8911/resources/boastjewelry/upload/1000005/dhHelp/talk02.jpg","look_times":"0","reply_num":"1","create_time":"2016-08-03 12:34:45","state":"1","isLike":"","like_num":"2","isReport":""},{"entity_id":"4","help_userId":"1000005","help_userHeadPic":"http://192.168.31.110:8911/resources/boastjewelry/upload/1000005/user_head/icon.jpg","help_userNickName":"盖伦","help_userIdTitle":"玛西亚之力","category_id":"1","talk_title":"玉石讨论帖主题04","talk_info":"玉石讨论帖内容04","talk_pic":"http://192.168.31.110:8911/resources/boastjewelry/upload/1000005/dhHelp/talk01.jpg,http://192.168.31.110:8911/resources/boastjewelry/upload/1000005/dhHelp/talk02.jpg","look_times":"0","reply_num":"0","create_time":"2016-08-03 12:34:45","state":"1","isLike":"","like_num":"1","isReport":""},{"entity_id":"5","help_userId":"1000005","help_userHeadPic":"http://192.168.31.110:8911/resources/boastjewelry/upload/1000005/user_head/icon.jpg","help_userNickName":"盖伦","help_userIdTitle":"玛西亚之力","category_id":"1","talk_title":"玉石讨论帖主题05","talk_info":"玉石讨论帖内容05","talk_pic":"http://192.168.31.110:8911/resources/boastjewelry/upload/1000005/dhHelp/talk01.jpg,http://192.168.31.110:8911/resources/boastjewelry/upload/1000005/dhHelp/talk02.jpg","look_times":"0","reply_num":"0","create_time":"2016-08-03 12:34:45","state":"1","isLike":"","like_num":"1","isReport":""},{"entity_id":"6","help_userId":"1000005","help_userHeadPic":"http://192.168.31.110:8911/resources/boastjewelry/upload/1000005/user_head/icon.jpg","help_userNickName":"盖伦","help_userIdTitle":"玛西亚之力","category_id":"2","talk_title":"宝石讨论帖主题01","talk_info":"宝石讨论帖内容01","talk_pic":"http://192.168.31.110:8911/resources/boastjewelry/upload/1000005/dhHelp/talk01.jpg,http://192.168.31.110:8911/resources/boastjewelry/upload/1000005/dhHelp/talk02.jpg","look_times":"0","reply_num":"0","create_time":"2016-08-03 12:34:45","state":"1","isLike":"","like_num":"0","isReport":"3"}]}
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
         * help_userId : 1000002
         * help_userHeadPic : http://192.168.31.110:8911/resources/boastjewelry/upload/1000002/user_head/icon.jpg
         * help_userNickName : 拉克丝
         * help_userIdTitle : 光辉女郎
         * category_id : 1
         * talk_title : 玉石讨论帖主题01
         * talk_info : 玉石讨论帖内容01
         * talk_pic : http://192.168.31.110:8911/resources/boastjewelry/upload/1000005/dhHelp/talk01.jpg,http://192.168.31.110:8911/resources/boastjewelry/upload/1000005/dhHelp/talk02.jpg
         * look_times : 2
         * reply_num : 4
         * create_time : 2016-08-03 12:34:45
         * state : 1
         * isLike :
         * like_num : 3
         * isReport : 1
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
            private String help_userId;
            private String help_userHeadPic;
            private String help_userNickName;
            private String help_userIdTitle;
            private String category_id;
            private String talk_title;
            private String talk_info;
            private String talk_pic;
            private String look_times;
            private String reply_num;
            private String create_time;
            private String state;
            private String isLike;
            private String like_num;
            private String isReport;

            public String getEntity_id() {
                return entity_id;
            }

            public void setEntity_id(String entity_id) {
                this.entity_id = entity_id;
            }

            public String getHelp_userId() {
                return help_userId;
            }

            public void setHelp_userId(String help_userId) {
                this.help_userId = help_userId;
            }

            public String getHelp_userHeadPic() {
                return help_userHeadPic;
            }

            public void setHelp_userHeadPic(String help_userHeadPic) {
                this.help_userHeadPic = help_userHeadPic;
            }

            public String getHelp_userNickName() {
                return help_userNickName;
            }

            public void setHelp_userNickName(String help_userNickName) {
                this.help_userNickName = help_userNickName;
            }

            public String getHelp_userIdTitle() {
                return help_userIdTitle;
            }

            public void setHelp_userIdTitle(String help_userIdTitle) {
                this.help_userIdTitle = help_userIdTitle;
            }

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getTalk_title() {
                return talk_title;
            }

            public void setTalk_title(String talk_title) {
                this.talk_title = talk_title;
            }

            public String getTalk_info() {
                return talk_info;
            }

            public void setTalk_info(String talk_info) {
                this.talk_info = talk_info;
            }

            public String getTalk_pic() {
                return talk_pic;
            }

            public void setTalk_pic(String talk_pic) {
                this.talk_pic = talk_pic;
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

            public String getIsLike() {
                return isLike;
            }

            public void setIsLike(String isLike) {
                this.isLike = isLike;
            }

            public String getLike_num() {
                return like_num;
            }

            public void setLike_num(String like_num) {
                this.like_num = like_num;
            }

            public String getIsReport() {
                return isReport;
            }

            public void setIsReport(String isReport) {
                this.isReport = isReport;
            }
        }
    }
}
