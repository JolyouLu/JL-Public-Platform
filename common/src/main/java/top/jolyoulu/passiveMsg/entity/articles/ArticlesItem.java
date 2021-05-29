package top.jolyoulu.passiveMsg.entity.articles;

import lombok.AllArgsConstructor;
import lombok.Data;
import top.jolyoulu.passiveMsg.annotation.PassiveMsg;
import top.jolyoulu.passiveMsg.annotation.PassiveMsgProperty;

/**
 * @Author: JolyouLu
 * @Date: 2021/5/25 14:28
 * @Version 1.0
 * 回复图文消息集合
 */
@Data
@AllArgsConstructor
@PassiveMsg
public class ArticlesItem {

    @PassiveMsgProperty(name = "item",contentObj = ArticlesCtx.class)
    private ArticlesCtx item;

}
