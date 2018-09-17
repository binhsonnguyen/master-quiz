package mst.codegym.controller;

import mst.codegym.model.TestQuestion;
import mst.codegym.service.TestQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
        String redirectURL = String.format("redirect:/question/details/%d", question.getId());
        return new ModelAndView(redirectURL);
    }

    @GetMapping("details/{id}")
    public ModelAndView viewTestQuestionDetails(@PathVariable long id) {
        TestQuestion question = testQuestionService.find(id);
        ModelAndView modelAndView = new ModelAndView("question/details");
        modelAndView.addObject("questioning", question);
        return modelAndView;
    }

}
