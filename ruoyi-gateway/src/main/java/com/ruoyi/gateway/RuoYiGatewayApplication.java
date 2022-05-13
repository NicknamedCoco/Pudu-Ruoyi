package com.ruoyi.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 网关启动程序
 * 
 * @author ruoyi
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class RuoYiGatewayApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(RuoYiGatewayApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  若依网关启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " __      __                    __    __       \n" +
                "/\\ \\  __/\\ \\                  /\\ \\  /\\ \\__    \n" +
                "\\ \\ \\/\\ \\ \\ \\     __      ___ \\ `\\`\\\\/'/\\_\\   \n" +
                " \\ \\ \\ \\ \\ \\ \\  /'__`\\  /' _ `\\`\\ `\\ /'\\/\\ \\  \n" +
                "  \\ \\ \\_/ \\_\\ \\/\\ \\L\\.\\_/\\ \\/\\ \\ `\\ \\ \\ \\ \\ \\ \n" +
                "   \\ `\\___x___/\\ \\__/.\\_\\ \\_\\ \\_\\  \\ \\_\\ \\ \\_\\\n" +
                "    '\\/__//__/  \\/__/\\/_/\\/_/\\/_/   \\/_/  \\/_/");
    }
}
