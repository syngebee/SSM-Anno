package cn.itcast.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(value = "cn.itcast",excludeFilters = {@ComponentScan.Filter(classes = Controller.class)})
@PropertySource("classpath:jdbc.properties")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.url}")
    private String url;


//为何这边用@Value注入为空? ↑    使用网上解决方案形参@Value注入↓  网上没有解释为什么会为空 只贴了代码
//怀疑加载顺序,先实例bean再注入导致,bean取值为空

    @Bean
    public DataSource getDateSource(/*@Value("${jdbc.driver}") String driver,
                                    @Value("${jdbc.username}") String username,
                                    @Value("${jdbc.password}") String password,
                                    @Value("${jdbc.url}") String url*/){

        //打印形参注入
        System.out.println("打印@Value注入:"+driver+":"+username+":"+password+":"+url);
//        System.out.println("打印成员变量@Value注入:"+this.driver+":"+this.username+":"+this.password+":"+this.url);
        System.out.println();

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        return dataSource;
    }
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

}
