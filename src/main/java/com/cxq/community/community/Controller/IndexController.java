package com.cxq.community.community.Controller;

import com.cxq.community.community.cache.HotTagCache;
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
    @Autowired
    private HotTagCache hotTagCache;
    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size,
                        @RequestParam(name = "search", required = false) String search,
                        @RequestParam(name = "tag",required = false) String tag) {
        PaginationDTO<QuestionDTO> pagination=null;
        try {
            pagination = questionService.list(search,tag, page, size);
            List<String> tags = hotTagCache.getHots();
            model.addAttribute("pagination", pagination);
            model.addAttribute("search", search);
            model.addAttribute("tag",tag);
            model.addAttribute("tags",tags);
            return "index";
        }catch (Exception e){
            log.error("pagination："+pagination);
            e.printStackTrace();
            return "index";
        }

    }
}
