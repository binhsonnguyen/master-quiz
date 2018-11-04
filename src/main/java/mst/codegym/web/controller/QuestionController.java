package mst.codegym.web.controller;

import lombok.extern.slf4j.Slf4j;
import mst.codegym.model.Question;
import mst.codegym.service.TestQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/question")
@Slf4j
public class QuestionController {
  @Autowired
  private TestQuestionService testQuestionService;

  @PostConstruct
  public void iAmAlive() {
    System.out.println("hello");
  }

  @GetMapping
  public ModelAndView accessCreateQuizQuestionPage() {
    ModelAndView modelAndView = new ModelAndView("question/create");
    Question question = Question.builder()
        .build();
    modelAndView.addObject("question", question);
    return modelAndView;
  }

  @PostMapping
  public ModelAndView createQuizQuestion(@ModelAttribute("question") Question question) {
    testQuestionService.save(question);
    String redirectURL = String.format("redirect:/question/details/%d", question.getId());
    return new ModelAndView(redirectURL);
  }

  @GetMapping("details/{id}")
  public ModelAndView viewTestQuestionDetails(@PathVariable long id) {
    Question question = testQuestionService.find(id);
    ModelAndView modelAndView = new ModelAndView("question/details");
    modelAndView.addObject("question", question);
    return modelAndView;
  }

  @GetMapping("details")
  public ModelAndView viewTestQuestionDetails(Question question) {
    ModelAndView modelAndView = new ModelAndView("question/details");
    modelAndView.addObject("question", question);
    return modelAndView;
  }

}
