package mst.codegym.web.controller;

import mst.codegym.viewModel.account.Register;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/register")
public class RegistrationController {
  @GetMapping
  public ModelAndView accessRegisterPage() {
    ModelAndView modelAndView = new ModelAndView("account/register");
    modelAndView.addObject("account", Register.builder().build());
    return modelAndView;
  }
}
