package world.keyi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import world.keyi.domain.User;
import world.keyi.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 万一
 * @DATE 2022年04月05日13:33
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/{ids}")
    public ArrayList<User> getUserListByIds(@PathVariable Integer[] ids){
        return userService.getUserListByIds(Arrays.asList(ids));
    }
}
