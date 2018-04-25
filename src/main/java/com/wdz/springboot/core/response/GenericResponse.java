package com.wdz.springboot.core.response;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by vip on 2018/4/24.
 */
public class GenericResponse {
    private String rc;
    private String rcDetail;
    private Integer status;

    public GenericResponse(String rc, String rcDetail, Integer status) {
        this.rc = rc;
        this.rcDetail = rcDetail;
        this.status = status;
    }

    public GenericResponse() {
        this.rc = "test";
        this.rcDetail = "test";
        this.status = 99;
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    public String getRcDetail() {
        return rcDetail;
    }

    public void setRcDetail(String rcDetail) {
        this.rcDetail = rcDetail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GenericResponse{" + "rc='" + rc + '\'' + ", rcDetail='" + rcDetail + '\'' +
               ", status=" + status + '}';
    }

//    public String toJSONString() {
//        return JSONObject.toJSONString(this, FastJson);
//    }
}
