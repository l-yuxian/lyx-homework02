package com.igeek.ch05.om;


import com.igeek.pojo.OrdersCustom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class OrdersAndDetailMapperTest {

    private SqlSessionFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
    }

    @Test
    public void find() {
        SqlSession sqlSession = factory.openSession();
        OrdersAndDetailMapper mapper = sqlSession.getMapper(OrdersAndDetailMapper.class);
        List<OrdersCustom> list = mapper.find();
        for(OrdersCustom o : list){
            System.out.println(o);
        }
        sqlSession.close();
    }
}
