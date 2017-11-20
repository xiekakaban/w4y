package com.st.test.crawler;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.Reader;

/**
 * Created by ruantianbo on 2017/11/20.
 */
public class MybatisOOCTest {



    @Test
    public void testMybatis() throws Exception{
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.selectOne("com.st.comon.w4y.entity.M4YSongUnionMapper.selectM4YSongUnionById","1");
        sqlSession.close();

    }
}
