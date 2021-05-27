package top.jolyoulu.handle;

import lombok.extern.slf4j.Slf4j;
import top.jolyoulu.enums.MsgType;
import top.jolyoulu.pipline.AbstractRequestHandlerContext;
import top.jolyoulu.pipline.RequestContext;
import top.jolyoulu.utils.MessageUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: JolyouLu
 * @Date: 2021/5/20 15:34
 * @Version 1.0
 * 图片处理Handle
 */
@Slf4j
public class ImageTypeHandle extends AbstractRequestHandlerContext {

    public ImageTypeHandle(String name) {
        super(name);
    }

    @Override
    public void requestHandle(RequestContext requestContext) {
        Map<String, String> msgMap = requestContext.getMsg();
        if (msgMap.get("MsgType").equals(MsgType.IMAGE_TYPE.getType())){
            log.info("进入到ImageTypeHandle");
        }else {
            super.requestHandlerContext.requestHandle(requestContext);
        }
    }
}
