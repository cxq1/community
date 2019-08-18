package com.cxq.community.community.mapper;

import com.cxq.community.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("insert into user(name,account_id,token,gmtcreate,gmtmodified)values(#{name},#{account_id},#{token},#{gmtcreate},#{gmtmodified})")
    public int insert(User user);
}
