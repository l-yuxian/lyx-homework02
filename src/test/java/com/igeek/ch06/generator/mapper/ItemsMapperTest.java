package com.igeek.ch06.generator.mapper;


import com.igeek.ch06.generator.pojo.Items;
import com.igeek.ch06.generator.pojo.ItemsExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class ItemsMapperTest {

    private SqlSessionFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
    }

    @Test
    public void selectByExample() {
        SqlSession sqlSession = factory.openSession();
        //需求：根据商品名称模糊查询信息
        ItemsExample example = new ItemsExample();
        //创建条件对象
        ItemsExample.Criteria c = example.createCriteria();
        c.andNameLike("%机%");
        //执行
        ItemsMapper itemsMapper = sqlSession.getMapper(ItemsMapper.class);
        List<Items> items = itemsMapper.selectByExample(example);
        for(Items item : items){
            System.out.println(item.getName());
        }
        sqlSession.close();
    }
}
