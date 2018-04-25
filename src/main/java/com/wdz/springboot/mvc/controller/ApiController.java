package com.wdz.springboot.mvc.controller;

import com.wdz.springboot.Incoming.dispatcher.IncomingDispatcher;
import com.wdz.springboot.core.request.GenericRequest;
import com.wdz.springboot.core.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Created by vip on 2018/4/23.
 */
@RestController
@RequestMapping("/api")
public class ApiController {
    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private IncomingDispatcher dispatcher;

    @RequestMapping(value = "/handle", produces = {"application/json"}, method = RequestMethod.POST)
    @ResponseBody
    public String handle(@RequestBody String reqData) {
        logger.debug("requset: " + reqData);
        GenericRequest request = new GenericRequest(reqData);
        GenericResponse response = dispatcher.handle(request);
        return "{\"handle\":\"123\"}";
    }

    @RequestMapping("/newhandle")
    public String orghandle() {
        return "newhandle";
    }


}
