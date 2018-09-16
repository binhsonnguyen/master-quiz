package mst.codegym.controller;

import mst.codegym.model.TestQuestion;
import mst.codegym.service.TestQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/question")
public class TestQuestionController {
    @Autowired
    private TestQuestionService testQuestionService;

    @GetMapping
    public ModelAndView accessCreateQuizQuestionPage() {
        ModelAndView modelAndView = new ModelAndView("question/create");
        TestQuestion question = new TestQuestion();
        question.setContent("a sample content");
        modelAndView.addObject("question", question);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView createQuizQuestion(@ModelAttribute("question") TestQuestion question) {
        testQuestionService.save(question);
        ModelAndView modelAndView = new ModelAndView("question/details");
        modelAndView.addObject("questioning", question);
        return modelAndView;
    }

}
