package world.keyi.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import world.keyi.domain.Notice;
import world.keyi.domain.CommonParamVo;
import world.keyi.service.NoticeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 万一
 * @DATE 2022年04月05日12:31
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("")
    public Map<String,Object> getNoticeList(CommonParamVo param){
        /*类型是3表示查询的是医院历史，不用进行分页*/
        if (!param.getType().equals("3")){
            PageHelper.startPage(param.getPageNum(),param.getPageSize());
        }
        ArrayList<Notice> list = noticeService.getNoticeList(param.getType());
        PageInfo<Notice> pageInfo = new PageInfo<>(list);
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("total",pageInfo.getTotal());
        objectMap.put("data",pageInfo.getList());
        objectMap.put("pages",pageInfo.getPages());
        return objectMap;
    }


}
