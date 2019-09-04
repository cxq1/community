package com.cxq.community.community.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class HotTagDTO implements Comparable{
    private String name;
    private Integer priority;

    @Override
    public int compareTo(Object o) {
        return this.priority-((HotTagDTO)o).getPriority();
    }
}
