package com.mkyong;

import com.mkyong.domain.User;
import com.mkyong.domain.UserDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@RequestMapping("/register")
public class RegistrationController {
    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;
    public RegistrationController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }
    @GetMapping
    public String registerForm() {
        return "registration";
    }
    @PostMapping
    public String processRegistration(UserDto userDto) {
        userRepo.save(new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()), userDto.getFullname(), userDto.getStreet(), userDto.getCity(),userDto.getState(), userDto.getZip(), userDto.getPhone()));
        return "redirect:/login";
    }
}

