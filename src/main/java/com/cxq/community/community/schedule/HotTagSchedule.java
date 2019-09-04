package com.cxq.community.community.schedule;

import com.cxq.community.community.cache.HotTagCache;
import com.cxq.community.community.mapper.QuestionMapper;
import com.cxq.community.community.model.Question;
import com.cxq.community.community.model.QuestionExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
@Slf4j
public class HotTagSchedule {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private HotTagCache hotTagCache;

//    @Scheduled(fixedRate = 5000)
    @Scheduled(fixedRate = 1000 * 60 * 60 * 3)
    public void hotTagSchedule() {
        int offest = 0;
        int limit = 5;
        log.info("The time is now {}", new Date());
        List<Question> list = new ArrayList<>();
        Map<String,Integer>priorties=new HashMap<>();
        while (offest==0||list.size()==limit){
            list = questionMapper.selectByExampleWithRowbounds(new QuestionExample(),new RowBounds(offest,limit));
            for (Question question : list) {
                String[] tags = StringUtils.split(question.getTag(), ",");
                for (String tag : tags) {
                    Integer priority= priorties.get(tag);
                    if(priority!=null){
                        priorties.put(tag,priority+5+question.getCommentCount());
                    }else {
                        priorties.put(tag,5+question.getCommentCount());
                    }
                }

            }
            offest+=limit;
        }


        hotTagCache.updateTags(priorties);

        log.info("hotSchedule stop:{}",new Date());
    }
}
