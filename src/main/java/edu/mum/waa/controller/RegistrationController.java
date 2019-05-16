package edu.mum.waa.controller;

import edu.mum.waa.entity.RoleEntity;
import edu.mum.waa.entity.UserEntity;
import edu.mum.waa.service.RoleService;
import edu.mum.waa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @ModelAttribute("roles")
    public List<RoleEntity> getRoles(Model model) {
        return roleService.findAll();
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(@ModelAttribute("user") UserEntity user) {

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String createNewUser(@Valid @ModelAttribute("user") UserEntity user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        UserEntity userExists = userService.findById(user.getUserid());
        if (userExists != null) {
            bindingResult
                    .rejectValue("userid", "error.user",
                            "There is already a user registered with the ID provided");
        }
        else {
            userService.saveUser(user);
            model.addAttribute("successMessage", "User has been registered successfully");
            model.addAttribute("user", new UserEntity());
            return "redirect:/login";
        }
        return "registration";
    }
}
