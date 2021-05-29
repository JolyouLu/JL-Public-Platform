package top.jolyoulu.passiveMsg.entity.articles;

import lombok.AllArgsConstructor;
import lombok.Data;
import top.jolyoulu.passiveMsg.annotation.PassiveMsg;
import top.jolyoulu.passiveMsg.annotation.PassiveMsgProperty;

/**
 * @Author: JolyouLu
 * @Date: 2021/5/25 14:28
 * @Version 1.0
 * 回复图文消息集合内容
 */
@Data
@AllArgsConstructor
@PassiveMsg
public class ArticlesCtx {

    @PassiveMsgProperty(name = "Title",addCDATA = true)
    private String title;

    @PassiveMsgProperty(name = "Description",addCDATA = true)
    private String description;

    @PassiveMsgProperty(name = "PicUrl",addCDATA = true)
    private String picUrl;

    @PassiveMsgProperty(name = "Url",addCDATA = true)
    private String url;

}
