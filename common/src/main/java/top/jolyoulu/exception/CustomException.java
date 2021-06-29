package top.jolyoulu.exception;

import lombok.Data;
import top.jolyoulu.config.exception.BaseCustomException;

/**
 * @Author: JolyouLu
 * @Date: 2021/6/29 10:38
 * @Version 1.0
 * 自定义异常类
 */
public class CustomException extends BaseCustomException {

    public CustomException(int code, String msg) {
        super(code, msg);
    }

    public CustomException(String msg) {
        super(msg);
    }
}
