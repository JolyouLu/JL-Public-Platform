package top.jolyoulu.domain.request;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: JolyouLu
 * @Date: 2021/6/29 10:01
 * @Version 1.0
 */
@Data
public class PushTemplateFormBody {
    private String touser;
    private String template_id;
    private String url;
    private Map<String,Object> data;

    public static void main(String[] args) {
        PushTemplateFormBody body = new PushTemplateFormBody();
        body.setTouser("o28L5w_cMJDhO79m9yj1HxU5NPJI");
        body.setTemplate_id("4nzvUCRd5_OkIbdrCySZnrQob59--sHFvr_M-ftDgP4");
        body.setUrl("");

        Map<String,Object> data = new HashMap<>();
        data.put("first","模板消息发送给o28L5w_cMJDhO79m9yj1HxU5NPJI");
        body.setData(data);
        System.out.println(JSONObject.toJSON(body));
    }
}
