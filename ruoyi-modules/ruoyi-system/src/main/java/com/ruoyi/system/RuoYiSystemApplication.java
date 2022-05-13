package com.ruoyi.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ruoyi.common.security.annotation.EnableCustomConfig;
import com.ruoyi.common.security.annotation.EnableRyFeignClients;
import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 系统模块
 * 
 * @author ruoyi
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class RuoYiSystemApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(RuoYiSystemApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  系统模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " __      __                    __    __       \n" +
                "/\\ \\  __/\\ \\                  /\\ \\  /\\ \\__    \n" +
                "\\ \\ \\/\\ \\ \\ \\     __      ___ \\ `\\`\\\\/'/\\_\\   \n" +
                " \\ \\ \\ \\ \\ \\ \\  /'__`\\  /' _ `\\`\\ `\\ /'\\/\\ \\  \n" +
                "  \\ \\ \\_/ \\_\\ \\/\\ \\L\\.\\_/\\ \\/\\ \\ `\\ \\ \\ \\ \\ \\ \n" +
                "   \\ `\\___x___/\\ \\__/.\\_\\ \\_\\ \\_\\  \\ \\_\\ \\ \\_\\\n" +
                "    '\\/__//__/  \\/__/\\/_/\\/_/\\/_/   \\/_/  \\/_/");
    }
}
