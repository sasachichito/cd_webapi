package com.github.sasachichito.cd_webapi.port.adapter.resource;

import com.github.sasachichito.cd_webapi.application.UserService;
import com.github.sasachichito.cd_webapi.application.presentationmodel.OneUser;
import com.github.sasachichito.cd_webapi.application.presentationmodel.Users;
import com.github.sasachichito.cd_webapi.domain.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    UserService userService;

    @RequestMapping(method= RequestMethod.POST, value="{name}")
    @ResponseStatus(value=HttpStatus.OK)
    public void save(@PathVariable String name) {
        this.userService.saveUser(name);
    }

    @RequestMapping(method= RequestMethod.GET, value="{name}")
    public OneUser ofName(@PathVariable String name) {
        User user = this.userService.ofName(name);
        return new OneUser(user);
    }

    @RequestMapping(method= RequestMethod.GET)
    public Users all() {
        List<User> users = userService.getAll();
        return new Users(users);
    }
}
