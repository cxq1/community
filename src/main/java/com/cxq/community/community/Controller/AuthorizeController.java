package com.cxq.community.community.Controller;

import com.cxq.community.community.dto.AccessTokenDTO;
import com.cxq.community.community.dto.GithubUser;
import com.cxq.community.community.mapper.UserMapper;
import com.cxq.community.community.model.User;
import com.cxq.community.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;
    @Autowired
    private UserMapper userMapper;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.url}")
    private String redirectUrl;
    @GetMapping("/callback")
    public String callback(String code, String state, HttpServletRequest request, HttpServletResponse response){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUrl);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if(githubUser!=null){
//            request.getSession().setAttribute("user",githubUser);
            User user =new User();
            user.setName(githubUser.getLogin());
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setGmtcreate(System.currentTimeMillis());
            user.setGmtmodified(user.getGmtcreate());
            user.setAccount_id(String.valueOf(githubUser.getId()));
            userMapper.insert(user);
            response.addCookie(new Cookie("token",token));
            return "redirect:/";
        }else {
            return "redirect:/";
        }

    }
}
