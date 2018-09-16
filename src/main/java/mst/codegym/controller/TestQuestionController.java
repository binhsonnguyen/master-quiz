package mst.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/question")
public class TestQuestionController {

    @GetMapping("")
    public ModelAndView createQuizQuestion() {
        ModelAndView modelAndView = new ModelAndView("question/create");
        return modelAndView;
    }
}
