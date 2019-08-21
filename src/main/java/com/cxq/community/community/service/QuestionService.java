package com.cxq.community.community.service;

import com.cxq.community.community.dto.PaginationDTO;
import com.cxq.community.community.dto.QuestionDTO;
import com.cxq.community.community.mapper.QuestionMapper;
import com.cxq.community.community.mapper.UserMapper;
import com.cxq.community.community.model.Question;
import com.cxq.community.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;

    public PaginationDTO list(Integer page, Integer size) {
        PaginationDTO paginationDTO=null;
        try {
            paginationDTO= new PaginationDTO();
            Integer totalCount= questionMapper.count();
            paginationDTO.setPagination(totalCount,page,size);
            if(page<1){
                page=1;
            }
            if(page>paginationDTO.getTotalPage()){
                page = paginationDTO.getTotalPage();
            }
            Integer offset = size*(page-1);

            List<Question>questions= questionMapper.list(offset,size);
            List<QuestionDTO> questionDTOS = new ArrayList<QuestionDTO>();
            for (Question question : questions) {
                User user= userMapper.findById(question.getCreator());

                QuestionDTO questionDTO = new QuestionDTO();
                BeanUtils.copyProperties(question,questionDTO);

                questionDTO.setUser(user);
                questionDTOS.add(questionDTO);
            }
            paginationDTO.setQuestions(questionDTOS);
        }catch (Exception e){

        }

        return paginationDTO;
    }
}
