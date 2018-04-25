package com.wdz.springboot.core.request;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by vip on 2018/4/24.
 */
public class GenericRequest {
    private String id;
    private Integer swtich;
    private String args;

    public GenericRequest(String reqData) {
        JSONObject requestObject = JSONObject.parseObject(reqData);
        id = requestObject.getString("id");
        swtich = requestObject.getIntValue("switch");
        args = requestObject.getString("args");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSwtich() {
        return swtich;
    }

    public void setSwtich(Integer swtich) {
        this.swtich = swtich;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return "GenericRequest{" + "id='" + id + '\'' + ", swtich=" + swtich + ", args='" + args +
               '\'' + '}';
    }
}
