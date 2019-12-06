package com.tk.mapper;

import com.tk.domain.User;

import java.util.List;

/**
 * @Author Cheng
 * @Date 2019/12/5 22:38
 */
public interface UserMapper {

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAllUser();

    /**
     * 新增一个用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id删除用户
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 根据用户id查询用户信息
     * @param userId 用户id
     * @return
     */
    User findById(Integer userId);

    /**
     * 根据用户名称模糊查询
     * @param userName
     * @return
     */
    List<User> findByName(String userName);
}
