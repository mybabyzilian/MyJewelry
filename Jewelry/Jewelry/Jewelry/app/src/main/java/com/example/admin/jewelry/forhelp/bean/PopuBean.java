package com.example.admin.jewelry.forhelp.bean;

import java.util.List;

/**
 * Created by admin on 2016/8/17.
 */
public class PopuBean {


    /**
     * status : 1
     * msg : 鑾峰彇鏁版嵁鎴愬姛锛�
     * object : {"tlist":[{"Val":"","Title":"绫诲瀷"},{"Val":"SCORE","Title":"绉垎鎮祻"},{"Val":"MONEY","Title":"绾㈠寘鎮祻"}],"alist":[{"Val":"","Title":"鎵撹祻"},{"Val":"Y","Title":"宸叉墦璧�"},{"Val":"N","Title":"鏈墦璧�"}],"clist":[{"entity_id":"","parent_id":"","category_name":"鍒嗙被","sort":"","state":"","ccs":[]},{"entity_id":"1","parent_id":"","category_name":"鐜夌煶","sort":"1","state":"1","ccs":[]},{"entity_id":"2","parent_id":"","category_name":"瀹濈煶","sort":"2","state":"1","ccs":[]},{"entity_id":"3","parent_id":"","category_name":"鏂囩帺","sort":"3","state":"1","ccs":[]},{"entity_id":"4","parent_id":"","category_name":"鍏朵粬","sort":"4","state":"1","ccs":[]}],"addlist":[{"entity_id":"1","parent_id":"","category_name":"鐜夌煶","sort":"1","state":"1","ccs":[]},{"entity_id":"2","parent_id":"","category_name":"瀹濈煶","sort":"2","state":"1","ccs":[]},{"entity_id":"3","parent_id":"","category_name":"鏂囩帺","sort":"3","state":"1","ccs":[]},{"entity_id":"4","parent_id":"","category_name":"鍏朵粬","sort":"4","state":"1","ccs":[]}]}
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
         * Val :
         * Title : 绫诲瀷
         */

        private List<TlistBean> tlist;
        /**
         * Val :
         * Title : 鎵撹祻
         */

        private List<AlistBean> alist;
        /**
         * entity_id :
         * parent_id :
         * category_name : 鍒嗙被
         * sort :
         * state :
         * ccs : []
         */

        private List<ClistBean> clist;
        /**
         * entity_id : 1
         * parent_id :
         * category_name : 鐜夌煶
         * sort : 1
         * state : 1
         * ccs : []
         */

        private List<AddlistBean> addlist;

        public List<TlistBean> getTlist() {
            return tlist;
        }

        public void setTlist(List<TlistBean> tlist) {
            this.tlist = tlist;
        }

        public List<AlistBean> getAlist() {
            return alist;
        }

        public void setAlist(List<AlistBean> alist) {
            this.alist = alist;
        }

        public List<ClistBean> getClist() {
            return clist;
        }

        public void setClist(List<ClistBean> clist) {
            this.clist = clist;
        }

        public List<AddlistBean> getAddlist() {
            return addlist;
        }

        public void setAddlist(List<AddlistBean> addlist) {
            this.addlist = addlist;
        }

        public static class TlistBean {
            private String Val;
            private String Title;

            public String getVal() {
                return Val;
            }

            public void setVal(String Val) {
                this.Val = Val;
            }

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }
        }

        public static class AlistBean {
            private String Val;
            private String Title;

            public String getVal() {
                return Val;
            }

            public void setVal(String Val) {
                this.Val = Val;
            }

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }
        }

        public static class ClistBean {
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

        public static class AddlistBean {
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
