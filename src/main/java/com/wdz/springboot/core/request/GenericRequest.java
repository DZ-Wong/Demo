package com.wdz.springboot.core.request;

import com.alibaba.fastjson.JSONObject;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by vip on 2018/4/24.
 */
public class GenericRequest {
    @NotNull(message = "Id should not be null")
    @NotEmpty(message = "Id should not be Empty")
    private String id;

    @Min(value = 1, message = "Switch should not be less 1")
    @Max(value = 20, message = "Switch should not be greater than 20")
    private Integer swtich;

    @NotEmpty(message = "Args should not be Empty")
    private String args;

    public GenericRequest(String reqData) {
        JSONObject requestObject = JSONObject.parseObject(reqData);
        id = requestObject.getString("id");
        swtich = requestObject.getIntValue("swtich");
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
