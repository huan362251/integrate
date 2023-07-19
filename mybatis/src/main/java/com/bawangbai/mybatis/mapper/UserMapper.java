package com.bawangbai.mybatis.mapper;

import com.bawangbai.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     * 添加用户信息
     * @return
     */
    int insertUser();

    void updateUser();

    void deleteUser();

    User queryById();

    List<User> queryAllUser();

    User queryByIds(long id);

    @MapKey("id")
    Map<String,Object> queryResultMap();

    List queryLikeName(String username);
}
