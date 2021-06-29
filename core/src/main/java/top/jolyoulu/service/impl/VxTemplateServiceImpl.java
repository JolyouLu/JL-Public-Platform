package top.jolyoulu.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jolyoulu.config.VxParameterConfig;
import top.jolyoulu.constant.RedisConstants;
import top.jolyoulu.domain.request.PushTemplateFormBody;
import top.jolyoulu.service.VxTemplateService;
import top.jolyoulu.utils.HttpUtil;
import top.jolyoulu.utils.RedisCacheUtils;

/**
 * @Author: JolyouLu
 * @Date: 2021/6/29 9:58
 * @Version 1.0
 */
@Service
public class VxTemplateServiceImpl implements VxTemplateService {

    @Autowired
    private RedisCacheUtils redisCacheUtils;

    @Autowired
    private VxParameterConfig vxParameterConfig;

    public String postTemplate(PushTemplateFormBody templateFormBody){
        String token = redisCacheUtils.getCacheObj(RedisConstants.ACCESS_TOKEN);
        String url = vxParameterConfig.getPostTemplateUrl();
        url = url.replace("ACCESS_TOKEN", token);
        String body = JSONObject.toJSONString(templateFormBody);
        String resp = HttpUtil.sendJsonPost(url, body);
        return resp;
    }
}
