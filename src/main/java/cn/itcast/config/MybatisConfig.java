package cn.itcast.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MybatisConfig {

    @Bean("sqlSessionFactoryBean")
    public SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //不要mybatis主配置文件
        //sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("/mybatis.xml"));

        //环境问题,主动指定使用的日志
//        org.apache.ibatis.logging.LogFactory.useLog4JLogging();
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        msc.setBasePackage("cn.itcast.dao");
        return msc;
    }
}
