package com.cxq.community.community.mapper;

import com.cxq.community.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user(name,account_id,token,gmtcreate,gmtmodified,avatar_url)values(#{name},#{account_id},#{token},#{gmtcreate},#{gmtmodified},#{avatarUrl})")
    public int insert(User user);
    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);
}
