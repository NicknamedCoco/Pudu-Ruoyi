package com.ruoyi.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 文件服务
 * 
 * @author ruoyi
 */
@EnableCustomSwagger2
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class RuoYiFileApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(RuoYiFileApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  文件服务模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " __      __                    __    __       \n" +
                "/\\ \\  __/\\ \\                  /\\ \\  /\\ \\__    \n" +
                "\\ \\ \\/\\ \\ \\ \\     __      ___ \\ `\\`\\\\/'/\\_\\   \n" +
                " \\ \\ \\ \\ \\ \\ \\  /'__`\\  /' _ `\\`\\ `\\ /'\\/\\ \\  \n" +
                "  \\ \\ \\_/ \\_\\ \\/\\ \\L\\.\\_/\\ \\/\\ \\ `\\ \\ \\ \\ \\ \\ \n" +
                "   \\ `\\___x___/\\ \\__/.\\_\\ \\_\\ \\_\\  \\ \\_\\ \\ \\_\\\n" +
                "    '\\/__//__/  \\/__/\\/_/\\/_/\\/_/   \\/_/  \\/_/");
    }
}
