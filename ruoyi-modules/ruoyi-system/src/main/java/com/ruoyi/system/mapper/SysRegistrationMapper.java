package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysRegistration;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface SysRegistrationMapper {

    void addRegistration(SysRegistration registration);

    ArrayList<SysRegistration> getList(@Param("number") String number,@Param("patientId") String patientId);

    Integer updateById(SysRegistration registration);

    SysRegistration getById(Integer id);
}
