package world.keyi.service;

import world.keyi.domain.Dept;

import java.util.ArrayList;

public interface DeptService {
    ArrayList<Dept> getDeptById(String deptId);
}
