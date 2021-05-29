package top.jolyoulu.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import top.jolyoulu.utils.MessageUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: LZJ
 * @Date: 2020/6/23 9:07
 * @Version 1.0
 */
@Slf4j
@Aspect
@Component
public class VxMsgAspect {

    //线程安全的HashMap
    private static final ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();

    //定义切入点
    @Pointcut("execution(* top.jolyoulu.controller.VxController.receiver(..))")
    public void pointCutVXReceiver(){};

    //环绕通知
    @Around("pointCutVXReceiver()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object retVal = null;
        //从连接点中获取参数
        Object[] args = pjp.getArgs();
        String xml = (String) args[0];
        //将来获取到的参数格式化
        Map<String, String> msgMap = MessageUtil.string2Map(xml);
        String msgId = msgMap.get("FromUserName") + msgMap.get("CreateTime");
        //如果已经存在于map中不做任何处理
        if (map.containsKey(msgId)){
            log.error("请求处理超时,接收到重复消息!");
            //直接返回空
            return null;
        }else {
            //否则将消息存入到map中
            map.put(msgId,msgId);
            //执行切面的方法，得到接口返回结果
            retVal = pjp.proceed(args);
            //执行完毕后删除map中保存的值
            map.remove(msgId);
        }
        //返回执行结果
        return retVal;
    }
}
