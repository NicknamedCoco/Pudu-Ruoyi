package com.ruoyi.modules.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import de.codecentric.boot.admin.server.config.EnableAdminServer;

/**
 * 监控中心
 */
@EnableAdminServer
@SpringBootApplication
public class RuoYiMonitorApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(RuoYiMonitorApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  监控中心启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " __      __                    __    __       \n" +
                "/\\ \\  __/\\ \\                  /\\ \\  /\\ \\__    \n" +
                "\\ \\ \\/\\ \\ \\ \\     __      ___ \\ `\\`\\\\/'/\\_\\   \n" +
                " \\ \\ \\ \\ \\ \\ \\  /'__`\\  /' _ `\\`\\ `\\ /'\\/\\ \\  \n" +
                "  \\ \\ \\_/ \\_\\ \\/\\ \\L\\.\\_/\\ \\/\\ \\ `\\ \\ \\ \\ \\ \\ \n" +
                "   \\ `\\___x___/\\ \\__/.\\_\\ \\_\\ \\_\\  \\ \\_\\ \\ \\_\\\n" +
                "    '\\/__//__/  \\/__/\\/_/\\/_/\\/_/   \\/_/  \\/_/");
    }
}
