package com.ruoyi.system.controller;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.system.api.domain.SysRole;
import com.ruoyi.system.domain.SysQuestions;
import com.ruoyi.system.service.ISysQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @author 万一
 * @DATE 2022年05月02日13:44
 */
@RestController
@RequestMapping("/questions")
public class SysQuestionController {

    @Autowired
    private ISysQuestionService questionService;

    /*
        查询问答列表，给参数
     */
    @GetMapping("/list")
    public AjaxResult queList(String pageNum,String pageSize,String title,String patientName){
        List<SysRole> roles = SecurityUtils.getLoginUser().getSysUser().getRoles();
        Boolean flag = false;
        for (SysRole role : roles) {
            Long roleId = role.getRoleId();
            //102是院外人员角色，即患者角色，根据角色的不同，返回不同的数据
            if (roleId!=102){
                flag=true;
            }
        }

        /*if (flag){
            return ResultGenerator.genSuccessResult(questionsService.queryList(queryRequest,entity));
        }else if (userManager.isPatientsRole(userId)){
            return ResultGenerator.genSuccessResult(questionsService.queryListByPatient(queryRequest,entity,userId));
        }*/
        return AjaxResult.success();
    }

    /*
        新增问答,给参数
     */
    @PostMapping("/ask")
    public AjaxResult ask(@RequestBody SysQuestions sysQuestions){
        sysQuestions.setPatientId(Math.toIntExact(SecurityUtils.getUserId()));
        questionService.save(sysQuestions);
        return AjaxResult.success();
    }

    /*
        删除问答
     */
    /*@DeleteMapping("/{ids}")
    public Object delQuestions(@PathVariable("ids") Integer[] ids){
        for (Integer id : ids) {
            questionsService.removeById(id);
            QueryWrapper<Questions> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("parent_id",id);
            questionsService.remove(queryWrapper);
        }
        return ResultGenerator.genSuccessResult();
    }*/

    /*
        回复问题,给参数
     */
    /*@PutMapping("/reply")
    public Object reply(@RequestBody Questions questions){
        Integer userId = TokenUtil.getAdminUserId(request.getHeader("Authorization"));
        Questions entity = new Questions();
        entity.setParentId(questions.getId());
        entity.setPatientId(questions.getPatientId());
        entity.setDoctorId(userId);
        entity.setTitle(questions.getReply());
        questionsService.save(entity);
        return ResultGenerator.genSuccessResult();
    }*/
}
