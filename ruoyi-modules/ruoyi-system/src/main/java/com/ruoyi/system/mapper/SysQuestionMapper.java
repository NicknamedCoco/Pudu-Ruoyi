package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysQuestions;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysQuestionMapper {
    void save(SysQuestions sysQuestions);
}
