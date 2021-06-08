package top.jolyoulu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.jolyoulu.config.VxParameterConfig;
import top.jolyoulu.constant.RedisConstants;
import top.jolyoulu.domain.entity.VxMenu;
import top.jolyoulu.domain.request.InitMenuFormBody;
import top.jolyoulu.enums.TreeLevel;
import top.jolyoulu.enums.VxResult;
import top.jolyoulu.mapper.VxMenuMapper;
import top.jolyoulu.service.VxMenuService;
import top.jolyoulu.utils.HttpUtil;
import top.jolyoulu.utils.RedisCacheUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: JolyouLu
 * @Date: 2021/4/30 17:20
 * @Version 1.0
 */
@Slf4j
@Service
@Transactional
public class VxMenuServiceImpl extends ServiceImpl<VxMenuMapper, VxMenu> implements VxMenuService {

    @Autowired
    private VxParameterConfig vxParameterConfig;

    @Autowired
    private VxMenuMapper vxMenuMapper;

    @Autowired
    private RedisCacheUtils redisCacheUtils;

    @Override
    public void initMenu(){
        List<InitMenuFormBody> initMenuFormBodies = new ArrayList<>();
        String token = redisCacheUtils.getCacheObj(RedisConstants.ACCESS_TOKEN);

        try {
            initMenuFormBodies = vxMenuMapper.selectMenuTree();
        }catch (BadSqlGrammarException e){
            log.error("获取菜单数据异常，请确认sys_menu表是否已创建/表结构是否有误");
            log.error(e.getMessage());
        }

        Map<String,List<InitMenuFormBody>> map = new HashMap<>();
        map.put("button",initMenuFormBodies);

        String jsonString = JSONObject.toJSONString(map);
        try {
            String url = vxParameterConfig.getMenuUrl();
            url = url.replace("ACCESS_TOKEN", token);
            String json = HttpUtil.sendJsonPost(url, jsonString);
            VxResult weXinErr = JSONObject.parseObject(json, VxResult.class);
            log.info(weXinErr.toString());
        } catch (Exception e) {
            log.error("AccessToken获取失败!");
        }
    }

}
