package com.ruoyi.system.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.utils.IdUtils;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.system.domain.SysRegistration;
import com.ruoyi.system.service.ISysRegistrationService;
import com.ruoyi.system.utils.OrderSnUtil;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 万一
 * @date 2021年06月22日11:19
 */
@RestController
@RequestMapping("/registration")
public class SysRegistrationController {

    @Autowired
    private ISysRegistrationService registrationService;

    /*
        查询挂号列表
        管理员没有挂号列表功能，所以registrationService.queryList不可能执行
     */
    @GetMapping("/list")
    public Object listRegistration(Integer pageSize,Integer pageNum,String number){
        PageHelper.startPage(pageNum,pageSize);
        ArrayList<SysRegistration> list = registrationService.registrationList(number, String.valueOf(SecurityUtils.getUserId()));
        PageInfo pageInfo = new PageInfo(list);
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("total",pageInfo.getTotal());
        objectMap.put("data",pageInfo.getList());
        objectMap.put("pages",pageInfo.getPages());
        return objectMap;
    }

    /*
        新增挂号,给参数
     */
    @PostMapping("")
    public Object add(@RequestBody SysRegistration registration){
        //number编号
        registration.setNumber(String.valueOf(new Date().getTime()).substring(0,10));
        //设置病人id
        registration.setPatientsId(Math.toIntExact(SecurityUtils.getUserId()));

        //设置挂号金额
        int min=0,max=0;
        if ("门诊号".equals(registration.getLevel())){
            min=10;
            max=50;
        }else if ("特需号".equals(registration.getLevel())){
            min=50;
            max=100;
        }else if ("会诊号".equals(registration.getLevel())){
            min=200;
            max=500;
        }else{
            return null;
        }
        BigDecimal v = BigDecimal.valueOf(Math.random() * (max - min) + min).setScale(2, RoundingMode.HALF_UP);
        registration.setAmountPayable(v);
        System.out.println(registration.toString());
        registrationService.addRegistration(registration);
        return "已支付"+v+"元";
    }

    /*
        开发票,给id
     */
    @PutMapping("/{id}")
    public Integer openInvoice(@PathVariable("id") Integer id){
        SysRegistration registration = new SysRegistration();
        registration.setId(id);
        //生成发票代码，12位数，随机生成
        registration.setInvoiceCode(String.valueOf(OrderSnUtil.getRandom(12)));
        //生成发票号，9位数，随机生成
        registration.setInvoiceNumber(String.valueOf(OrderSnUtil.getRandom(9)));
        //生成发票日期
        registration.setInvoiceDate(LocalDate.now());
        //改变状态
        registration.setIsInvoice(true);
        return registrationService.updateById(registration);
    }

    /*
        通过id获取信息，给id
     */
    @GetMapping("/{id}")
    public SysRegistration getInfoById(@PathVariable Integer id){
        return registrationService.getById(id);
    }

    /*
        采纳，给id
     */
    /*@GetMapping("/accept/{id}")
    public Result accept(@PathVariable Integer id){
        Registration registration = new Registration();
        registration.setId(id);
        registration.setAccept(1);
        registrationService.updateById(registration);
        return ResultGenerator.genSuccessResult();
    }*/

    /*
        不采纳，给id
     */
    /*@GetMapping("/notAccept/{id}")
    public Result notAccept(@PathVariable Integer id){
        Registration registration = new Registration();
        registration.setId(id);
        registration.setStatus(0);
        registration.setAccept(2);
        registrationService.updateById(registration);
        return ResultGenerator.genSuccessResult();
    }*/

    /*
        评价,给参数
     */
    /*@PutMapping("/evaluate")
    public Result evaluate(@RequestBody Registration registration){
        registrationService.updateById(registration);
        return ResultGenerator.genSuccessResult();
    }*/

}
