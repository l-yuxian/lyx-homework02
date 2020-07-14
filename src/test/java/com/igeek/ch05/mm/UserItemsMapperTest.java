package com.igeek.ch05.mm;


import com.igeek.pojo.UserCustom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class UserItemsMapperTest {

    private SqlSessionFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
    }

    @Test
    public void find() {
        SqlSession sqlSession = factory.openSession();
        UserItemsMapper mapper = sqlSession.getMapper(UserItemsMapper.class);
        List<UserCustom> list = mapper.find();
        for(UserCustom user : list){
            System.out.println(user);
        }
        sqlSession.close();
    }

    /*
        UserCustom{User{id=1, username='王五', sex='2', birthday=null, address='null'},
            orderList=[
                OrdersCustom{Orders{id=3, userId=1, createtime=2015-02-04 13:22:35.0, number='1000010', note='null'}, userCustom=null,
                    detailList=[
                        detailList=[
                            OrderdetailCustom{Orderdetail{id=1, ordersId=3, itemsId=1, itemsNum=1},
                                OrderdetailCustom{itemsCustom=Items{id=1, name='台式机', price=3000.0, detail='该电脑质量非常好！！！！', createtime=2015-02-03 13:22:53.0, pic='null'}},
                            OrderdetailCustom{Orderdetail{id=2, ordersId=3, itemsId=2, itemsNum=3},
                                OrderdetailCustom{itemsCustom=Items{id=2, name='笔记本', price=6000.0, detail='笔记本性能好，质量好！！！！！', createtime=2015-02-09 13:22:57.0, pic='null'}}]},
               OrdersCustom{Orders{id=4, userId=1, createtime=2015-02-03 13:22:41.0, number='1000011', note='null'}, userCustom=null,
                    detailList=[
                        OrderdetailCustom{itemsCustom=Items{id=3, name='背包', price=200.0, detail='名牌背包，容量大质量好！！！！', createtime=2015-02-06 13:23:02.0, pic='null'}},
                        OrderdetailCustom{itemsCustom=Items{id=2, name='笔记本', price=6000.0, detail='笔记本性能好，质量好！！！！！', createtime=2015-02-09 13:22:57.0, pic='null'}}]}]}
     */
}
