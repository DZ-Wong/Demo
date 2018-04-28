package com.wdz.springboot.Incoming.request;

import com.alibaba.fastjson.JSONObject;
import com.wdz.springboot.core.request.GenericRequest;

import javax.validation.constraints.NotNull;

/**
 * 具体业务请求接口类。
 */
public class RealRequest extends GenericRequest{

    /*具体业务下新增的字段*/
    @NotNull
    private String IP;

    public RealRequest(String reqData) {
        super(reqData);
        JSONObject requestObject = JSONObject.parseObject(reqData);
        IP = requestObject.getString("IP");
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }
}
