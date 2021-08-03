package top.jolyoulu.handle;

import lombok.extern.slf4j.Slf4j;
import top.jolyoulu.enums.MsgType;
import top.jolyoulu.passiveMsg.entity.text.TextMessage;
import top.jolyoulu.passiveMsg.utils.PassiveMsgUtil;
import top.jolyoulu.pipline.AbstractRequestHandlerContextAdapter;
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
public class TextTypeHandle extends AbstractRequestHandlerContextAdapter {

    public TextTypeHandle(String name) {
        super(name);
    }

    @Override
    public void requestHandle(RequestContext requestContext) {
        Map<String, String> msgMap = requestContext.getMsg();
        if (msgMap.get("MsgType").equals(MsgType.TEXT_TYPE.getType())){
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(msgMap.get("FromUserName"));
            textMessage.setFromUserName(msgMap.get("ToUserName"));
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MsgType.TEXT_TYPE.getType());
            textMessage.setContent(msgMap.get("Content"));
            String xml = PassiveMsgUtil.INSTANCE.getMsgXml(textMessage);
            requestContext.resultMsg(xml);
        }else {
            super.requestHandlerContext.requestHandle(requestContext);
        }
    }
}
