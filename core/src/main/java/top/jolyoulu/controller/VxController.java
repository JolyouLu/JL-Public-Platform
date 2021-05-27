package top.jolyoulu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.jolyoulu.config.VxParameterConfig;
import top.jolyoulu.utils.CheckUtil;

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


    @GetMapping("/master1")
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
}
