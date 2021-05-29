package top.jolyoulu.passiveMsg.entity.video;

import lombok.Data;
import top.jolyoulu.passiveMsg.annotation.PassiveMsg;
import top.jolyoulu.passiveMsg.annotation.PassiveMsgProperty;
import top.jolyoulu.passiveMsg.entity.BaseMessage;

/**
 * @Author: JolyouLu
 * @Date: 2021/5/25 14:16
 * @Version 1.0
 */
@Data
@PassiveMsg
public class VideoMessage extends BaseMessage {

    @PassiveMsgProperty(name = "Video",contentObj = VideoCtx.class)
    private VideoCtx video;

}
