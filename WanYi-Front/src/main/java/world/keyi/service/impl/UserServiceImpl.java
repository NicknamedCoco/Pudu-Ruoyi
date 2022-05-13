package world.keyi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import world.keyi.domain.User;
import world.keyi.mapper.UserMapper;
import world.keyi.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 万一
 * @DATE 2022年04月05日13:37
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ArrayList<User> getUserListByIds(List<Integer> ids) {

        return userMapper.getUserListByIds(ids);
    }
}
