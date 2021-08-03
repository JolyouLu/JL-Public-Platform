package top.jolyoulu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.jolyoulu.config.VxParameterConfig;
import top.jolyoulu.pipline.AbstractRequestHandlerContextAdapter;
import top.jolyoulu.pipline.DefaultRequestPipeline;
import top.jolyoulu.pipline.RequestContext;
import top.jolyoulu.utils.CheckUtil;
import top.jolyoulu.utils.MessageUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: LZJ
 * @Date: 2020/5/24 0:14
 * @Version 1.0
 */
@Slf4j
@Controller
@RequestMapping("/myWeXin")
public class VxController {

    @Autowired
    private VxParameterConfig vxParameterConfig;

    @Autowired
    private DefaultRequestPipeline defaultRequestPipeline;

    @GetMapping("/master")
    @ResponseBody
    public String init(@RequestParam("signature") String signature,
                       @RequestParam("timestamp") String timestamp,
                       @RequestParam("nonce") String nonce,
                       @RequestParam("echostr") String echostr){
        if (CheckUtil.checkSignature(vxParameterConfig.getToken(),signature,timestamp,nonce)){
            return echostr;
        }
        return null;
    }

    @PostMapping(value = "/master")
    public void receiver(@RequestBody String xml, HttpServletResponse resp, HttpServletRequest request){
        try {
            Map<String, String> msgMap = MessageUtil.string2Map(xml);
            RequestContext requestContext = new RequestContext(msgMap, resp, request);
            AbstractRequestHandlerContextAdapter ctx = defaultRequestPipeline.getCtx();
            ctx.requestHandle(requestContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
