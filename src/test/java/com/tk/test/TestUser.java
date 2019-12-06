package com.tk.test;

import com.tk.domain.User;
import com.tk.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Author Cheng
 * @Date 2019/12/5 23:02
 */
public class TestUser {

    private InputStream in;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private UserMapper mapper;

    @Before
    public void init() throws Exception {
        //1.读取配置文件
        in = Resources.getResourceAsStream("mybatis-config.xml");
        //2.创建SqlSessionFactory工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产sqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void close() throws Exception {
        //提交事务
        sqlSession.commit();
        //7.释放资源
        sqlSession.close();
        in.close();
    }

    /**
     * 查询所有用户
     */
    @Test
    public void testFindAllUser() {
        List<User> allUser = mapper.findAllUser();

        for (User u:allUser) {
            System.out.println(u);
        }
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUsername("嘻嘻");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("北京朝阳");
        mapper.saveUser(user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(50);
        user.setUsername("哈哈");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("湖南长沙");
        mapper.updateUser(user);
    }

    @Test
    public void testDeleteUser() {
        mapper.deleteUser(49);
    }

    @Test
    public void testFindById() {
        User byId = mapper.findById(48);
        System.out.println(byId);
    }

    @Test
    public void testFindByName() {
        // %在前会导致索引失效，查询全走全表扫描
        List<User> byName = mapper.findByName("%王%");

        for (User u:byName) {
            System.out.println(u);
        }
    }
}
