package com.igeek.ch03.mapper;

import com.igeek.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class UserMapperTest {

    //关联会话工厂对象
    private SqlSessionFactory factory;

    //在启动测试方法之前做一些准备工作
    @Before
    public void setUp() throws Exception {
        //加载mybatis的核心配置文件，产生流对象
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建会话工厂对象
        factory = new SqlSessionFactoryBuilder().build(is);
    }

    @Test
    public void findOne() {
        //创建会话对象
        SqlSession sqlSession = factory.openSession();
        //获得代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //测试通过id查询用户信息的方法
        User user = userMapper.findOne(10);
        System.out.println(user);
        //关闭资源
        sqlSession.close();
    }

    @Test
    public void findByName(){
        //创建会话对象
        SqlSession sqlSession = factory.openSession();
        //获得代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.findByName("明");
        for(User user : list){
            System.out.println(user);
        }
        //关闭资源
        sqlSession.close();
    }

    @Test
    public void insert() throws ParseException {
        //创建会话对象
        SqlSession sqlSession = factory.openSession();
        //获得代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //封装User对象
        String str = "2019-09-09";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(str);
        User user = new User("马汉","1",date,"江苏无锡");

        //执行插入操作
        userMapper.insert(user);
        System.out.println(user);
        //提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }
}
