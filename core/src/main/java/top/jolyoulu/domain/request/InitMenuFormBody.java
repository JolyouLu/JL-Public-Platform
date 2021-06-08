package top.jolyoulu.domain.request;

import lombok.Data;

import java.util.List;

/**
 * @Author: JolyouLu
 * @Date: 2021/4/30 17:49
 * @Version 1.0
 */
@Data
public class InitMenuFormBody {

    private String name;
    private String type;
    private String url;
    private String key;
    private List<InitMenuFormBody> sub_button;

}
