package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	
	final private Environment enviroment;

	public WebSecurity(Environment enviroment) {
		super();
		this.enviroment = enviroment;
	}
	
	@Override
	 protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("/**").permitAll();
        httpSecurity.headers().frameOptions().sameOrigin();
    }
	
	}