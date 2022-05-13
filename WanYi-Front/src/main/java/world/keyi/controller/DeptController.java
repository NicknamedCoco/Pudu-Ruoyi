package world.keyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import world.keyi.domain.Dept;
import world.keyi.service.DeptService;

import java.util.ArrayList;

/**
 * @author 万一
 * @DATE 2022年04月05日12:30
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("{id}")
    public ArrayList<Dept> getDeptById(@PathVariable("id") String deptId){
        return deptService.getDeptById(deptId);
    }
}
