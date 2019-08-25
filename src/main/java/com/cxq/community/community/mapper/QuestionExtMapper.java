package com.cxq.community.community.mapper;


import com.cxq.community.community.dto.QuestionQueryDTO;
import com.cxq.community.community.model.Question;

import java.util.List;

public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);
    List<Question> selectRelated(Question question);

    Integer countBySearch(QuestionQueryDTO questionQueryDTO);

    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);
}