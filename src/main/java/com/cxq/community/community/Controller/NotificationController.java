package com.cxq.community.community.Controller;

import com.cxq.community.community.dto.NotificationDTO;
import com.cxq.community.community.enums.NotificationTypeEnum;
import com.cxq.community.community.model.User;
import com.cxq.community.community.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notification/{id}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name = "id") Long id) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }
        NotificationDTO notificationDTO =notificationService.read(id,user);
        if(NotificationTypeEnum.REPLY_COMMENT.getType()==notificationDTO.getType()
        || NotificationTypeEnum.REPLY_QUESTION.getType() == notificationDTO.getType()){
            return "redirect:/question/" + notificationDTO.getOuterid();
        }
        else {
            return "redirect:/";
        }
    }
}
