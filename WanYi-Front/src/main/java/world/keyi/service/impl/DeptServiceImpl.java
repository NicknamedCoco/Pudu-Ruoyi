package world.keyi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import world.keyi.domain.Dept;
import world.keyi.domain.User;
import world.keyi.mapper.DeptMapper;
import world.keyi.service.DeptService;

import java.util.ArrayList;

/**
 * @author 万一
 * @DATE 2022年04月05日12:35
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public ArrayList<Dept> getDeptById(String deptId) {
        ArrayList<Dept> depts = deptMapper.getDeptById(deptId);
        for (Dept dept:depts){
            ArrayList<User> users = deptMapper.getUserById(dept.getDeptId());
            dept.setMembers(users);
        }
        return depts;
    }
}
