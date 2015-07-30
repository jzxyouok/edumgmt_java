package net.shinc.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

/**
 * mybatis及数据源配置信息
 * @author zhangtaichao 2015年7月10日
 */
@Configuration
@PropertySource("classpath:config/properties/config_${spring.profiles.active}.properties")
@MapperScan(basePackages={"net.shinc.orm.mybatis.mappers"})
public class DBConfig {
    
	@Autowired
	private Environment env;
	
	@Autowired
	private ApplicationContext context;
	
	/**
	 * @return 测试环境数据源
	 */
	@Bean(name="dataSource",destroyMethod="close")
	@Profile("develop")
	public DataSource developDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(env.getProperty("jdbc.driver"));
		ds.setUsername(env.getProperty("develop.jdbc.username"));
		ds.setPassword(env.getProperty("develop.jdbc.password"));
		ds.setUrl(env.getProperty("develop.jdbc.url"));
		return ds;
	}
	
	/**
	 * @return 生产环境数据源
	 */
	@Bean(name="dataSource",destroyMethod="close")
	@Profile("product")
	public DataSource productDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(env.getProperty("jdbc.driver"));
		ds.setUsername(env.getProperty("product.jdbc.username"));
		ds.setPassword(env.getProperty("product.jdbc.password"));
		ds.setUrl(env.getProperty("product.jdbc.url"));
		return ds;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {
		SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
		fb.setDataSource(dataSource);
		fb.setConfigLocation(new ClassPathResource("config/mybatisConfig.xml"));
		fb.setTypeAliasesPackage("net.shinc.orm.mybatis.bean");
		fb.setMapperLocations(context.getResources("classpath:config/mappers/*.xml"));
		return fb;
	}
	
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory ssf) {
		SqlSessionTemplate sqlSession = new SqlSessionTemplate(ssf);
		return sqlSession;
	}
}
