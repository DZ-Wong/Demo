package com.wdz.springboot.core.handler;


import com.wdz.springboot.out.dispatcher.ChannelDispatcher;
import com.wdz.springboot.utils.BeanValidateDemo;
import com.wdz.springboot.core.request.GenericRequest;
import com.wdz.springboot.core.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 业务入口抽象处理器。
 * Created by vip on 2018/4/24.
 */
public abstract class AbstractHandler<R extends GenericRequest, S extends GenericResponse>
        implements Handler<R, S> {

    @Autowired
    private BeanValidateDemo<GenericRequest> beanValidate;

    @Autowired
    private ChannelDispatcher channelDispatcher;

    /**这里插入通用业务处理逻辑。*/
    @Override
    public S handle(GenericRequest request) throws Exception{
        /**当业务需要扩展，接口不一致时，需要下面的转换将通用请求转化为特定的*/
        /**这样好像解析了两次请求，所以需要把通用请求类优化。*/
        R wrappeiedRequest = null;
        try {
            wrappeiedRequest = wrapperRequest(request);
        } catch (Exception e) {
          throw new Exception(e.getMessage());
        }


        /*验证数据是否确实*/
        String errMeg = beanValidate.ValidateRequest(request);


        /*简单地判断校验结果,这种情况不需要泛型的返回*/
        S response = null;
        if (null != errMeg) {
            response = (S) new GenericResponse("31", errMeg);
            return response;
        }

        /**加入对外接口的扩展方式*/
        response = channelHandle(wrappeiedRequest);

        return response;
    }

    /**
     * 转化具体业务请求类。
     * @param request
     * @return R
     */
    protected R wrapperRequest(GenericRequest request) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /*获取实际调用者的Class信息*/
        Type genericInterfaces = this.getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType)genericInterfaces).getActualTypeArguments();

        /*获取实际调用者的Class类*/
        Class<R> responseClass = (Class) params[0];

        /*获取实际调用者构造器*/
        Constructor<R> constructor = responseClass.getDeclaredConstructor(String.class);

        /*生成调用者对象*/
        R instance = constructor.newInstance(request.getOrginData());

        return instance;
    }

    protected S channelHandle(R request) throws Exception {
        return (S) channelDispatcher.handle(request);
    }
}
