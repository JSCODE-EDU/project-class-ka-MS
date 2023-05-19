package com.jscode.minseok.config;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

    /*
        @Configuration
        스프링이 빈 팩토리를 위해 별도의 환경설정 정보를 담당하는 클래스라고 인식할 수 있도록 @configuration 애노테이션을 추가합니다.
        @MapperScan
        베이스패키지라는 이름으로 Scan할 범위를 지정하고
        그 베이스패키지부터 하위패키지 까지 Mapper Interface 가 있는지 모두 스캔하여 모든 Mapper를 등록합니다.
        이 스캔 기능은 마이바티스 스프링 연동모듈이 자동스캔 해주는 것입니다.
*/

@Configuration
@RequiredArgsConstructor
@MapperScan(basePackages = "com.jscode.minseok.mapper")
public class DatabaseConfig {

    private final ApplicationContext applicationContext;

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(
                applicationContext.getResources("classpath:/mapper/**/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
