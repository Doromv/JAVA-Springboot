package com.doromv.mapper;

import com.doromv.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Doromv
 * @create 2022-03-12-15:33
 */
@Mapper//这个注解表示了这是一个mybatis的mapper类
@Repository
public interface UserMapper {
    List<User> queryUserList();
    User queryUserById(Integer id);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(Integer id);
}
