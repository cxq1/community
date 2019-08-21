package com.cxq.community.community.Controller;

import com.cxq.community.community.dto.QuestionDTO;
import com.cxq.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable("id")Integer id, Model model){
        QuestionDTO questionDTO= questionService.getById(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
