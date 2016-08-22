package com.example.admin.jewelry.information.bean;

import java.util.List;

/**
 * Created by admin on 2016/8/16.
 */
public class TitleBean {

    /**
     * status : 1
     * msg : 鑾峰彇鏁版嵁鎴愬姛锛�
     * object : {"parentlist":[{"entity_id":"1","parent_id":"","category_name":"鐜夌煶","sort":"1","state":"1","ccs":[]},{"entity_id":"2","parent_id":"","category_name":"瀹濈煶","sort":"2","state":"1","ccs":[]},{"entity_id":"3","parent_id":"","category_name":"鏂囩帺","sort":"3","state":"1","ccs":[]},{"entity_id":"4","parent_id":"","category_name":"鍏朵粬","sort":"4","state":"1","ccs":[]}]}
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
         * parent_id :
         * category_name : 鐜夌煶
         * sort : 1
         * state : 1
         * ccs : []
         */

        private List<ParentlistBean> parentlist;

        public List<ParentlistBean> getParentlist() {
            return parentlist;
        }

        public void setParentlist(List<ParentlistBean> parentlist) {
            this.parentlist = parentlist;
        }

        public static class ParentlistBean {
            private String entity_id;
            private String parent_id;
            private String category_name;
            private String sort;
            private String state;
            private List<?> ccs;

            public String getEntity_id() {
                return entity_id;
            }

            public void setEntity_id(String entity_id) {
                this.entity_id = entity_id;
            }

            public String getParent_id() {
                return parent_id;
            }

            public void setParent_id(String parent_id) {
                this.parent_id = parent_id;
            }

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public List<?> getCcs() {
                return ccs;
            }

            public void setCcs(List<?> ccs) {
                this.ccs = ccs;
            }
        }
    }
}
