package com.cxq.community.community.Controller;

import com.cxq.community.community.dto.PaginationDTO;
import com.cxq.community.community.dto.QuestionDTO;
import com.cxq.community.community.mapper.UserMapper;
import com.cxq.community.community.model.User;
import com.cxq.community.community.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Slf4j
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size,
                        @RequestParam(name = "search",required = false)String search){
        try {

            PaginationDTO paginationDTO= questionService.list(search,page,size);
            model.addAttribute("pagination",paginationDTO);
            model.addAttribute("search",search);
            log.error("callback get paginationDTO error,{}", paginationDTO);
        }catch (Exception e){

        }

        return "index";
    }
}
