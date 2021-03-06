package com.delala.delala.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.delala.delala.skill.SkillRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import lombok.Data;

@Data
@Controller
public class TalentRegistration {

    @Autowired
    SkillRepository skillRepository;

    @NotNull(message = "Invalid Username")
    @NotBlank(message = "Username can't be blank")
    private String username;
    @NotNull(message = "Invalid Password")
    @NotBlank(message = "password can't be blank")
    private String password;
    @NotNull(message = "Invalid Lastname")
    @NotBlank(message = "Last Name can't be blank")
    private String lastName;
    @NotNull(message = "Invalid Firstname")
    @NotBlank(message = "First Name can't be blank")
    private String firstName;
    @NotNull(message = "Invalid email")
    @NotBlank(message = "First Name can't be blank")
    @Email(message = "NOt a valid email address")
    private String email;
    private String skill;
    @Size(min = 10, max = 10, message = "Phone number must be 10 digits")
    private String phoneNumber;

    public User toUser(PasswordEncoder encoder) {
        User user = new User();
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setUsername(this.username);
        user.setEmail(this.email);
        user.setPhoneNumber(this.phoneNumber);
        user.setPassword(encoder.encode(this.password));
        user.setRole("TALENT");
        // System.out.println(skillRepository == null);
        return user;
    }
}