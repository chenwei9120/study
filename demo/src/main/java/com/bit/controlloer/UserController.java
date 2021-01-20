package com.bit.controlloer;


import com.bit.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
//    @RequiresLogin
//    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8;"})
//    public String getUserList(){
//
//        System.out.println("--------------");
//        return "[{'id': 1, 'username':'zhangsan'}]";
//    }

    private List<User> userList = new ArrayList<>();

    public UserController() {
        userList.add(new User(1L, "Li lei"));
        userList.add(new User(2L, "Han meimei"));
        userList.add(new User(3L, "Lucy"));
        userList.add(new User(4L, "Jack"));
    }

    @GetMapping
    public User getUserById(@RequestParam Long id) {
        List<User> users = userList.stream().filter(u->u.getId().equals(id)).collect(Collectors.toList());
        return users.size() > 0 ? users.get(0) : new User();
    }

    @GetMapping("/{id}")
    public User getUserById2(@PathVariable Long id) {//@PathParam是jboss包下面的一个实现,@PathVariable是spring的实现
        List<User> users = userList.stream().filter(u->u.getId().equals(id)).collect(Collectors.toList());
        return users.size() > 0 ? users.get(0) : new User();
    }

    @PostMapping("/create")
    @ResponseBody
    public boolean create(@RequestBody User user) {//
        return userList.add(user);
    }
}

