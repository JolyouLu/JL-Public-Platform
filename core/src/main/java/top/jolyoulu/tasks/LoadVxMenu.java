package top.jolyoulu.tasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import top.jolyoulu.constant.RedisConstants;
import top.jolyoulu.service.VxMenuService;
import top.jolyoulu.utils.RedisCacheUtils;

import java.util.concurrent.ExecutorService;

/**
 * @Author: JolyouLu
 * @Date: 2021/6/8 15:09
 * @Version 1.0
 */
@Slf4j
@Component
public class LoadVxMenu implements CommandLineRunner {

    @Autowired
    private ExecutorService executorService;

    @Autowired
    private VxMenuService menuService;

    @Autowired
    private RedisCacheUtils redisCacheUtils;

    @Override
    public void run(String... args){
        executorService.execute(new LoadMenuTask());
    }

    private class LoadMenuTask implements Runnable{
        @Override
        public void run() {
            log.debug("正在尝试异步加载菜单");
            while (true){
                if (redisCacheUtils.existsCacheObj(RedisConstants.ACCESS_TOKEN)){
                    menuService.initMenu();
                    log.debug("异步加载菜单完毕");
                    break;
                }
            }
        }
    }
}
