package com.devarchi33.config;

import com.devarchi33.dao.UserDao;
import com.devarchi33.domain.User;
import com.devarchi33.service.UserService;
import com.devarchi33.service.UserServiceImpl;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by donghoon on 2016. 8. 12..
 */
@Configuration
@EnableTransactionManagement
@MapperScan(
        basePackages = {"com.devarchi33.dao"}
)
@PropertySource("classpath:mybatis/mybatis.properties")
public class MybatisConfig {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${MYSQL_DRIVER}")
    private String MYSQL_DIRVER;
    @Value("${JSCAN_DRIVER}")
    private String JSCAN_DRIVER;
    @Value("${DEVARCHI_DB_URL}")
    private String IRUEN_DB_URL;
    @Value("${DEVARCHI_JSCAN_DB_URL}")
    private String JSCAN_DB_URL;
    @Value("${DEVARCHI_USER}")
    private String USERNAME;
    @Value("${DEVARCHI_PASSWORD}")
    private String PASSWORD;
    @Value("${DATASOURCE}")
    private String DATASOURCE_TYPE;

    private DataSource makeBasicDataSource(String driverClassName, String dbUrl) {

        BasicDataSource datasource = new BasicDataSource();
        datasource.setDriverClassName(driverClassName);
        datasource.setUrl(dbUrl);
        datasource.setUsername(USERNAME);
        datasource.setPassword(PASSWORD);

        return datasource;
    }

    private DataSource makeComboPooledDataSource(String driverClass, String dbUrl) {

        ComboPooledDataSource datasource = new ComboPooledDataSource();

        try {
            datasource.setDriverClass(driverClass);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        datasource.setJdbcUrl(dbUrl);
        datasource.setUser(USERNAME);
        datasource.setPassword(PASSWORD);

        return datasource;
    }

    @Bean
    public DataSource basicDataSource() {
        return makeBasicDataSource(MYSQL_DIRVER, IRUEN_DB_URL);
    }

    @Bean
    public DataSource jscanBasicDataSource() {
        return makeBasicDataSource(JSCAN_DRIVER, JSCAN_DB_URL);
    }

    @Bean
    public DataSource comboPooledDataSource() {
        return makeComboPooledDataSource(MYSQL_DIRVER, IRUEN_DB_URL);
    }

    @Bean
    public DataSource jscanComboPooledDataSource() {
        return makeComboPooledDataSource(JSCAN_DRIVER, JSCAN_DB_URL);
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {

        if (DATASOURCE_TYPE.equals("jscanDataSource"))
            return new DataSourceTransactionManager(jscanComboPooledDataSource());
        else
            return new DataSourceTransactionManager(comboPooledDataSource());


    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

        if (DATASOURCE_TYPE.equals("jscanDataSource"))
            sessionFactory.setDataSource(jscanComboPooledDataSource());
        else
            sessionFactory.setDataSource(comboPooledDataSource());

        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mybatis/user-mapper.xml"));

        Class[] typeAliases = {User.class};
        sessionFactory.setTypeAliases(typeAliases);

        return sessionFactory.getObject();
    }

    @Bean
    public MapperFactoryBean mapperFactoryBean() throws Exception {
        MapperFactoryBean mapperFactoryBean = new MapperFactoryBean();
        mapperFactoryBean.setMapperInterface(UserDao.class);
        mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory());

        return mapperFactoryBean;
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

}