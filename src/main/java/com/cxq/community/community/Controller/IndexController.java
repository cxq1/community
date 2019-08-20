package com.cxq.community.community.Controller;

import com.cxq.community.community.dto.QuestionDTO;
import com.cxq.community.community.mapper.UserMapper;
import com.cxq.community.community.model.User;
import com.cxq.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,Model model){
        try {
            Cookie[] cookies = request.getCookies();
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    User user =userMapper.findByToken(token);
                    if(user!=null){
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
            List<QuestionDTO>questionDTOS = questionService.list();
            model.addAttribute("questions",questionDTOS);

        }catch (Exception e){

        }

        return "index";
    }
}
