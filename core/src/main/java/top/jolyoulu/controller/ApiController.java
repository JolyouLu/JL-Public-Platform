package top.jolyoulu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.jolyoulu.domain.request.PushTemplateFormBody;
import top.jolyoulu.exception.CustomException;
import top.jolyoulu.service.VxTemplateService;

/**
 * @Author: JolyouLu
 * @Date: 2021/6/29 10:31
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private VxTemplateService vxTemplateService;

    @PostMapping(value = "/pushMsg")
    @ResponseBody
    public void pushMsg(@RequestBody PushTemplateFormBody templateFormBody){
        try {
            vxTemplateService.postTemplate(templateFormBody);
        } catch (Exception e) {
            throw new CustomException(500,e.getMessage());
        }
    }
}
