package com.wdz.springboot.core.response;

import com.wdz.springboot.utils.JsonUtil;

/**
 * Created by vip on 2018/4/24.
 */
public class GenericResponse {
    private String rc;
    private String rcDetail;
    private Integer status;
    private Double fee;

    public GenericResponse(String rc, String rcDetail, Integer status, Double fee) {
        this.rc = rc;
        this.rcDetail = rcDetail;
        this.status = status;
        this.fee = fee;
    }

    public GenericResponse() {
        this.rc = "00";
        this.rcDetail = "test";
        this.status = 0;
        this.fee = 5.0;
    }

    public GenericResponse(String rc, String rcDetail) {
        this.rc = rc;
        this.rcDetail = rcDetail;
        this.status = 3;
        this.fee = 0.0;
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

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "GenericResponse{" + "rc='" + rc + '\'' + ", rcDetail='" + rcDetail + '\'' +
               ", status=" + status + '}';
    }

    public String toJSONString() {
        return JsonUtil.toJSONString(this, JsonUtil.getFormateConfig());
    }
}
