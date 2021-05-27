package top.jolyoulu.config.threadPool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: JolyouLu
 * @Date: 2021/5/6 11:05
 * @Version 1.0
 */
@Configuration
public class ThreadPoolConfig {


    @Bean
    public ExecutorService getThreadPool(){
        return Executors.newFixedThreadPool(10);
    }
}
