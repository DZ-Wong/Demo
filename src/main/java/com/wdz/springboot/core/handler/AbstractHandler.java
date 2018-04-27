package com.wdz.springboot.core.handler;


import com.wdz.springboot.Utils.BeanValidateDemo;
import com.wdz.springboot.core.request.GenericRequest;
import com.wdz.springboot.core.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by vip on 2018/4/24.
 */
public abstract class AbstractHandler<R extends GenericRequest, S extends GenericResponse>
        implements Handler<R, S> {

    @Autowired
    private BeanValidateDemo<GenericRequest> beanValidate;

    @Override
    public S handle(GenericRequest request) {
        /**这里插入业务处理逻辑。*/
        String errMeg = beanValidate.ValidateRequest(request);

        /*简单地判断*/
        S response = null;
        if (null != errMeg) {
            response = (S) new GenericResponse("31", errMeg);
        } else {
            response = (S) new GenericResponse();
        }

        return response;
    }
}
