package top.jolyoulu.passiveMsg.entity.video;

import lombok.AllArgsConstructor;
import lombok.Data;
import top.jolyoulu.passiveMsg.annotation.PassiveMsg;
import top.jolyoulu.passiveMsg.annotation.PassiveMsgProperty;

/**
 * @Author: JolyouLu
 * @Date: 2021/5/25 14:16
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@PassiveMsg
public class VideoCtx {

    @PassiveMsgProperty(name = "MediaId",addCDATA = true)
    private String mediaId;

    @PassiveMsgProperty(name = "Title",addCDATA = true)
    private String title;

    @PassiveMsgProperty(name = "Description",addCDATA = true)
    private String description;

}
