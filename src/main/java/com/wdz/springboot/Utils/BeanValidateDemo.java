package com.wdz.springboot.Utils;

import org.springframework.stereotype.Component;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * 程序化验证示例。
 */
@Component
public class BeanValidateDemo<R> {
    /*程序化验证, 为了通用，引入泛型*/
    public  String  ValidateRequest(R request) {
        /**首先要有个Validator 对象， 从工厂类里面获取*/
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        /**验证Bean. 调用validator 的validate方法，验证结果返回Set集合*/
        Set<ConstraintViolation<R>> violations  = validator.validate(request);

        /*遍历前判断下是否为null，以及结果集大小*/
        if (violations != null && violations.size() > 0 ) {
            /*构建一个StringBuilder 容器 装所有错误信息*/
            StringBuilder stringBuilder = new StringBuilder();

            /**遍历结果集，getMessage查看是否违规信息*/
            for (ConstraintViolation<R> violation : violations) {
                /*为了美观，加入分隔符 ‘，’*/
                if (stringBuilder.length() != 0){
                    stringBuilder.append(",");
                }
                /*将错误信息赋值给容器*/
                stringBuilder.append(violation.getPropertyPath());
                stringBuilder.append(violation.getMessage());
            }
            return stringBuilder.toString();
        }
        return null;
    }
}
