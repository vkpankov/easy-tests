package easytests.controller;

import easytests.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import easytests.entities.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    @ResponseBody
    public String test() {
        User user = new User("Test", "Testov", "Testovich");
        userRepository.save(user);
        return "User was added successfully!";
    }
}