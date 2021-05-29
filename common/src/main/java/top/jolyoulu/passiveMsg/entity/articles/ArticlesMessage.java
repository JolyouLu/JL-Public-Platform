package top.jolyoulu.passiveMsg.entity.articles;

import lombok.Data;
import top.jolyoulu.passiveMsg.annotation.PassiveMsg;
import top.jolyoulu.passiveMsg.annotation.PassiveMsgProperty;
import top.jolyoulu.passiveMsg.entity.BaseMessage;

import java.util.List;

/**
 * @Author: JolyouLu
 * @Date: 2021/5/25 14:27
 * @Version 1.0
 * 回复图文消息
 */
@Data
@PassiveMsg
public class ArticlesMessage extends BaseMessage {

    @PassiveMsgProperty(name = "ArticleCount")
    private Integer articleCount;

    @PassiveMsgProperty(name = "Articles",contentObj = ArticlesItem.class)
    private List<ArticlesItem> item;
}
