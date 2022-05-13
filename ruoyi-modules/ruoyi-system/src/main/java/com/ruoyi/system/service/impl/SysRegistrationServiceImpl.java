package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.SysRegistration;
import com.ruoyi.system.mapper.SysRegistrationMapper;
import com.ruoyi.system.service.ISysRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author 万一
 * @DATE 2022年04月28日17:27
 */
@Service
public class SysRegistrationServiceImpl implements ISysRegistrationService {

    @Autowired
    private SysRegistrationMapper registrationMapper;

    @Override
    public void addRegistration(SysRegistration registration) {
        registrationMapper.addRegistration(registration);
    }

    @Override
    public ArrayList<SysRegistration> registrationList(String number,String patientId) {
        return registrationMapper.getList(number,patientId);
    }

    @Override
    public Integer updateById(SysRegistration registration) {
        return registrationMapper.updateById(registration);
    }

    @Override
    public SysRegistration getById(Integer id) {

        return registrationMapper.getById(id);
    }
}
