package mst.codegym.controller;

import mst.codegym.model.TestQuestion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/question")
public class TestQuestionController {

    @GetMapping
    public ModelAndView createQuizQuestion() {
        ModelAndView modelAndView = new ModelAndView("question/create");
        TestQuestion question = new TestQuestion();
        question.setContent("a sample content");
        modelAndView.addObject("question", question);
        return modelAndView;
    }

}
