package world.keyi.controller;

import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import world.keyi.domain.DrugInfo;
import world.keyi.domain.Tag;
import world.keyi.domain.WeatherInfo;

import java.util.*;

/**
 * @author 万一
 * @DATE 2022年03月17日20:23
 */
@RestController
@RequestMapping("/index")
@RefreshScope
public class IndexController {

    @Value("${cityName}")
    private String cityName;

    @Value("${wwyy.showapi_appid}")
    private String showapi_appid;

    @Value("${wwyy.showapi_sign}")
    private String showapi_sign;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/weatherInfo")
    public Object getWeatherInfo(){
        //暂时先实现固定位置天气
        /*HashMap<String, WeatherInfo> result = new HashMap<>();
        RestTemplate restTemplate = new RestTemplate();
        HashMap map = restTemplate.getForObject("http://t.weather.sojson.com/api/weather/city/" + cityCode, HashMap.class);
        ArrayList<HashMap> forecast = new ArrayList<>();
        if (!Objects.isNull(map)&&
                !Objects.isNull(map= (HashMap) map.get("data"))&&
                !Objects.isNull(forecast=(ArrayList) map.get("forecast"))
        ){
            for (HashMap hashMap:forecast){

                String high = (String) hashMap.get("high");
                String newHigh = high.substring(3).replace("℃", "");
                String low = (String) hashMap.get("low");
                String newLow = low.substring(3).replace("℃", "");
                result.put((String) hashMap.get("date"),
                        new WeatherInfo(Integer.valueOf(newHigh),Integer.valueOf(newLow),(String) hashMap.get("date")));
            }
        }*/

        LinkedHashMap<String, WeatherInfo> result = new LinkedHashMap<>();
        /*请求参数封装*/
        HashMap<String, Object> param = new HashMap<>();
        param.put("showapi_appid",showapi_appid);
        param.put("showapi_sign",showapi_sign);
        param.put("area",cityName);
        RestTemplate restTemplate = new RestTemplate();
        String url ="http://route.showapi.com/9-9?" +
                "showapi_appid={showapi_appid}" +
                "&showapi_sign={showapi_sign}" +
                "&area={area}";
        HashMap map = (HashMap) restTemplate.getForObject(url, HashMap.class,param).get("showapi_res_body");
        ArrayList<HashMap<String,String>> arrayList = (ArrayList<HashMap<String, String>>) map.get("dayList");

        for (HashMap<String,String> hashMap:arrayList){
            String high = hashMap.get("day_air_temperature");
            String low = hashMap.get("night_air_temperature");
            String daytime = hashMap.get("daytime");
            result.put(daytime,
                    new WeatherInfo(Integer.valueOf(high),Integer.valueOf(low),daytime));
        }
        ArrayList finalResult = new ArrayList();
        finalResult.add(cityName);
        finalResult.add(result);
        return finalResult;
    }

    @RequestMapping("/virusInfo")
    public Object getVirusInfo(){
        return new Object();
    }


    @GetMapping("/tags")
    public ArrayList<Object> getTags(){
        ArrayList<Object> strings = new ArrayList<>();
        strings.add("舍生忘死");
        strings.add("妙手仁心");
        strings.add("华佗再世");
        strings.add("悬壶济世");
        strings.add("乐于助人");
        strings.add("功德无量");
        strings.add("医术高明");
        strings.add("药到病除");
        strings.add("白衣天使");
        strings.add("伟大高尚");
        strings.add("誉满杏林");
        strings.add("医德高尚");
        strings.add("大医精诚");
        strings.add("舍己为人");
        return strings;
    }

    /*根据药品名称查询药品信息*/
    @GetMapping("/drugSearch")
    public Object drugSearch(DrugInfo drugInfo){
        /*请求参数封装*/
        HashMap<String, Object> param = new HashMap<>();
        param.put("showapi_appid",showapi_appid);
        param.put("showapi_sign",showapi_sign);
        param.put("page",drugInfo.getPageNum());
        param.put("limit",drugInfo.getPageSize());
        param.put("keyword",drugInfo.getKeyword());
        RestTemplate restTemplate = new RestTemplate();
        String url ="http://route.showapi.com/93-97?" +
                    "showapi_appid={showapi_appid}" +
                    "&showapi_sign={showapi_sign}" +
                    "&keyword={keyword}" +
                    "&page={page}" +
                    "&limit={limit}";

        return restTemplate.getForObject(url, HashMap.class,param).get("showapi_res_body");
    }

    /*查询药品目录*/
    @RequestMapping("/menu")
    public Object getMenu(){
        /*请求参数封装*/
        HashMap<String, Object> param = new HashMap<>();
        param.put("showapi_appid",showapi_appid);
        param.put("showapi_sign",showapi_sign);
        RestTemplate restTemplate = new RestTemplate();
        String url ="http://route.showapi.com/1468-1?" +
                "showapi_appid={showapi_appid}" +
                "&showapi_sign={showapi_sign}";

        HashMap map = (HashMap) restTemplate.getForObject(url, HashMap.class,param).get("showapi_res_body");

        ArrayList<HashMap<String,String>> arrayList = (ArrayList<HashMap<String, String>>) map.get("data");

        HashMap<String, ArrayList<HashMap<String, String>>> hashMap = new HashMap<>();

        arrayList.forEach(m->{
            if (hashMap.get(m.get("class"))==null){
                ArrayList<HashMap<String, String>> list = new ArrayList<>();
                HashMap<String, String> map1 = new HashMap<>();
                map1.put("label",m.get("classify"));
                map1.put("value",m.get("classifyId"));
                list.add(map1);
                hashMap.put(m.get("class"),list);
            }else{
                ArrayList<HashMap<String, String>> list = hashMap.get(m.get("class"));
                HashMap<String, String> map1 = new HashMap<>();
                map1.put("label",m.get("classify"));
                map1.put("value",m.get("classifyId"));
                list.add(map1);
            }
        });

        Set<Map.Entry<String, ArrayList<HashMap<String, String>>>> entries = hashMap.entrySet();
        Iterator<Map.Entry<String, ArrayList<HashMap<String, String>>>> iterator = entries.iterator();
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        while (iterator.hasNext()){
            Map.Entry<String, ArrayList<HashMap<String, String>>> entry = iterator.next();
            HashMap<String, Object> map1 = new HashMap<>();
            map1.put("label",entry.getKey());
            map1.put("value","");
            map1.put("children",entry.getValue());
            list.add(map1);
        }

        return list;
    }

    /*根据症状查询药品信息*/
    @RequestMapping("/drugQuery")
    public Object drugQuery(DrugInfo drugInfo){
        /*请求参数封装*/
        HashMap<String, Object> param = new HashMap<>();
        param.put("showapi_appid",showapi_appid);
        param.put("showapi_sign",showapi_sign);
        param.put("page",drugInfo.getPageNum());
        param.put("maxResult",drugInfo.getPageSize());
        param.put("classifyId",drugInfo.getClassifyId());
        String url ="http://route.showapi.com/1468-2?" +
                "showapi_appid={showapi_appid}" +
                "&showapi_sign={showapi_sign}" +
                "&classifyId={classifyId}" +
                "&page={page}" +
                "&maxResult={maxResult}";
        HashMap map = (HashMap) restTemplate.getForObject(url, HashMap.class,param).get("showapi_res_body");
        ArrayList<HashMap<String,Object>> list = (ArrayList<HashMap<String, Object>>) map.get("data");
        Integer total = (Integer) map.get("count");
        ArrayList<HashMap<String, Object>> dataList = new ArrayList<>();
        ArrayList<Thread> runnables = new ArrayList<>();
        for (HashMap<String,Object> hashMap:list){
            runnables.add(new Thread(()->{
                ArrayList<HashMap<String, Object>> item = (ArrayList<HashMap<String, Object>>) getDrugById(drugInfo.getClassifyId(), (String) hashMap.get("drugId"), "4");
                dataList.addAll(item);
            }));
        }
        runnables.forEach(Thread::start);
        for (Thread thread : runnables) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        HashMap<String, Object> result = new HashMap<>();
        result.put("allResults",total);
        result.put("drugList",dataList);
        return result;
    }

    public Object getDrugById(String classifyId,String searchKey,String searchType){
        HashMap<String, Object> param = new HashMap<>();
        param.put("showapi_appid",showapi_appid);
        param.put("showapi_sign",showapi_sign);
        param.put("classifyId",classifyId);
        param.put("searchKey",searchKey);
        param.put("searchType",searchType);
        String url ="http://route.showapi.com/1468-3?" +
                "showapi_appid={showapi_appid}" +
                "&showapi_sign={showapi_sign}" +
                "&classifyId={classifyId}" +
                "&searchKey={searchKey}" +
                "&searchType={searchType}";

        HashMap resBody = (HashMap) restTemplate.getForObject(url, HashMap.class, param).get("showapi_res_body");
        ArrayList list = (ArrayList) resBody.get("drugList");
        return list;
    }


    @RequestMapping("/news")
    public Object getNews(String keyword,String maxResult){
        /*请求参数封装*/
        HashMap<String, Object> param = new HashMap<>();
        param.put("showapi_appid",showapi_appid);
        param.put("showapi_sign",showapi_sign);
        param.put("title",keyword);
        param.put("maxResult",maxResult);
        String url ="http://route.showapi.com/109-35?" +
                "showapi_appid={showapi_appid}" +
                "&showapi_sign={showapi_sign}" +
                "&title={title}" +
                "&needAllList=0" +
                "&maxResult={maxResult}";
        HashMap map = (HashMap) restTemplate.getForObject(url, HashMap.class,param).get("showapi_res_body");
        HashMap pagebean = (HashMap) map.get("pagebean");
        ArrayList<HashMap<String,Object>> contentlist = (ArrayList<HashMap<String, Object>>) pagebean.get("contentlist");
        return contentlist;
    }
}
