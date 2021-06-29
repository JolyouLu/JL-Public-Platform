package top.jolyoulu.config.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: JolyouLu
 * @Date: 2021/6/29 10:40
 * @Version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> errorHandler(Exception ex){
        Map<String,Object> map = new HashMap<>();
        map.put("code", 500);
        //判断异常的类型,返回不一样的返回值
        if(ex instanceof BaseCustomException){
            map.put("code",((BaseCustomException) ex).getCode());
            map.put("msg",((BaseCustomException) ex).getMsg());
        }
        return map;
    }

}
