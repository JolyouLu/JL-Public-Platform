package top.jolyoulu.passiveMsg.entity.image;

import lombok.Data;
import top.jolyoulu.passiveMsg.annotation.PassiveMsg;
import top.jolyoulu.passiveMsg.annotation.PassiveMsgProperty;
import top.jolyoulu.passiveMsg.entity.BaseMessage;

/**
 * @Author: JolyouLu
 * @Date: 2021/5/25 11:15
 * @Version 1.0
 * 回复图片消息实体
 */
@Data
@PassiveMsg
public class ImageMessage extends BaseMessage {

    @PassiveMsgProperty(name = "Image",contentObj = ImageCtx.class)
    private ImageCtx image;

}
