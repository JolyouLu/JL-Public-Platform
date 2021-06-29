package top.jolyoulu.config.exception;

import lombok.Data;

/**
 * @Author: JolyouLu
 * @Date: 2021/6/29 10:38
 * @Version 1.0
 * 自定义异常类基类
 */
@Data
public class BaseCustomException extends RuntimeException {
    protected int code;
    protected String msg;

    public BaseCustomException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseCustomException(String msg) {
        super(msg);
        this.msg = msg;
    }

}
