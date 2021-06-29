package top.jolyoulu.service;

import top.jolyoulu.domain.request.PushTemplateFormBody;

/**
 * @Author: JolyouLu
 * @Date: 2021/6/29 9:58
 * @Version 1.0
 */
public interface VxTemplateService {

    /**
     * 消息推送
     * @param templateFormBody 推送表单内容
     * @return
     */
    String postTemplate(PushTemplateFormBody templateFormBody);

}
