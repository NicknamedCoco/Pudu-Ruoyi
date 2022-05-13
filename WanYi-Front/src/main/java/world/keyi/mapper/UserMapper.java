package world.keyi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import world.keyi.domain.User;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    ArrayList<User> getUserListByIds(@Param("ids") List<Integer> ids);
}
