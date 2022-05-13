package world.keyi.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 万一
 * @DATE 2022年03月17日21:21
 */
@Configuration
public class MyConfig {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        //先获取到converter列表
        List<HttpMessageConverter<?>> converters = builder.build().getMessageConverters();
        for(HttpMessageConverter<?> converter : converters){
            //因为我们只想要jsonConverter支持对text/html的解析
            if(converter instanceof MappingJackson2HttpMessageConverter){
                try{
                    //先将原先支持的MediaType列表拷出
                    List<MediaType> mediaTypeList = new ArrayList<>(converter.getSupportedMediaTypes());
                    //加入对text/html的支持
                    mediaTypeList.add(MediaType.TEXT_HTML);
//将已经加入了text/html的MediaType支持列表设置为其支持的媒体类型列表
                    ((MappingJackson2HttpMessageConverter) converter).setSupportedMediaTypes(mediaTypeList);
                    ((MappingJackson2HttpMessageConverter) converter).setDefaultCharset(Charset.forName("utf-8"));
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return builder.build();
    }
}
