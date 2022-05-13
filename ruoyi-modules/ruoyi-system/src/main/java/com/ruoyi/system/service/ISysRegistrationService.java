package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysRegistration;

import java.util.ArrayList;

public interface ISysRegistrationService {

    void addRegistration(SysRegistration registration);

    ArrayList<SysRegistration> registrationList(String number,String patientId);

    Integer updateById(SysRegistration registration);

    SysRegistration getById(Integer id);
}
