package com.zcz.crowd;

import com.zcz.entity.Admin;
import com.zcz.mapper.AdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

// 指定 Spring 给 Junit 提供的运行器类
@RunWith(SpringJUnit4ClassRunner.class)
// 加载 Spring 配置文件的注解
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml"})
public class CrowdSpringTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;
    @Test
    public void testAdminMapperAutowired() {
        Admin admin = new Admin(null,"zhangsan","123123","张三","@qq.tangmu.com",null);
        int insert = adminMapper.insert(admin);
        System.out.println("添加了"+insert+"行数据");
    }
    @Test
    public void testDataSource() throws SQLException {
// 1.通过数据源对象获取数据源连接
        Connection connection = dataSource.getConnection();
// 2.打印数据库连接
        System.out.println(connection);
    }

    @Test
    public void test03(){
        //获取Logger对象，这里传入的Class就是当前打印日志的类
        Logger logger = LoggerFactory.getLogger(CrowdSpringTest.class);
        //等级 DEBUG < INFO < WARN < ERROR
        logger.debug("I am DEBUG!!!");

        logger.info("I am INFO!!!");

        logger.warn("I am WARN!!!");

        logger.error("I am ERROR!!!");

    }
}
