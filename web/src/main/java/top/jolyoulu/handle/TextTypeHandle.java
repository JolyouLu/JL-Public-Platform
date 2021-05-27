package top.jolyoulu.handle;

import lombok.extern.slf4j.Slf4j;
import top.jolyoulu.enums.MsgType;
import top.jolyoulu.pipline.AbstractRequestHandlerContext;
import top.jolyoulu.pipline.RequestContext;

import java.util.Date;
import java.util.Map;

/**
 * @Author: JolyouLu
 * @Date: 2021/5/20 13:11
 * @Version 1.0
 * 文本处理Handle
 */
@Slf4j
public class TextTypeHandle extends AbstractRequestHandlerContext {

    public TextTypeHandle(String name) {
        super(name);
    }

    @Override
    public void requestHandle(RequestContext requestContext) {
        Map<String, String> msgMap = requestContext.getMsg();
        if (msgMap.get("MsgType").equals(MsgType.TEXT_TYPE.getType())){
            log.info("进入到TextTypeHandle");
        }else {
            super.requestHandlerContext.requestHandle(requestContext);
        }
    }
}
