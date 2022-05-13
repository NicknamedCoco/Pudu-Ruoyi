package world.keyi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import world.keyi.domain.Dept;
import world.keyi.domain.User;

import java.util.ArrayList;

@Mapper
@Repository
public interface DeptMapper {

    ArrayList<Dept> getDeptById(@Param("id") String deptId);

    ArrayList<User> getUserById(@Param("id") String deptId);
}
