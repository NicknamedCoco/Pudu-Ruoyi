package world.keyi.service;

import world.keyi.domain.User;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    ArrayList<User> getUserListByIds(List<Integer> ids);
}
