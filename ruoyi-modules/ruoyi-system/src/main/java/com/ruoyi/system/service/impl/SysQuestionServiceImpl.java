package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.SysQuestions;
import com.ruoyi.system.mapper.SysQuestionMapper;
import com.ruoyi.system.service.ISysQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 万一
 * @DATE 2022年05月02日13:51
 */
@Service
public class SysQuestionServiceImpl implements ISysQuestionService {


    @Autowired
    private SysQuestionMapper questionMapper;

    @Override
    public void save(SysQuestions sysQuestions) {
        questionMapper.save(sysQuestions);
    }
}
