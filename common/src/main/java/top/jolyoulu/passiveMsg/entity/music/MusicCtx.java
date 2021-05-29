package top.jolyoulu.passiveMsg.entity.music;

import lombok.AllArgsConstructor;
import lombok.Data;
import top.jolyoulu.passiveMsg.annotation.PassiveMsg;
import top.jolyoulu.passiveMsg.annotation.PassiveMsgProperty;

/**
 * @Author: JolyouLu
 * @Date: 2021/5/25 14:21
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@PassiveMsg
public class MusicCtx {

    @PassiveMsgProperty(name = "Title",addCDATA = true)
    private String title;

    @PassiveMsgProperty(name = "Description",addCDATA = true)
    private String description;

    @PassiveMsgProperty(name = "MusicUrl",addCDATA = true)
    private String musicUrl;

    @PassiveMsgProperty(name = "HQMusicUrl",addCDATA = true)
    private String hQMusicUrl;

    @PassiveMsgProperty(name = "ThumbMediaId",addCDATA = true)
    private String thumbMediaId;
}
