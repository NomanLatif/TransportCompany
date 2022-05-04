package com.transport.transport.config;

import static com.transport.transport.config.Role.ADMIN;
import static com.transport.transport.config.Role.NORMAL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
//@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	@Override
	protected void configure(HttpSecurity http)	throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/", "index", "/css/*", "/js/*").permitAll()
				.antMatchers("/api/**").hasRole(ADMIN.name())
				.anyRequest()
				.authenticated()
				.and()
				.httpBasic();
	}

	  @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails noman = User.builder()
                .username("noman")
                .password(passwordEncoder.encode("password"))
                .roles(ADMIN.name()) //ROLE_STUDENT
//                .authorities(STUDENT.getSimpleGrantedAuthorities())
                .build();

        UserDetails yuxin = User.builder()
                .username("yuxin")
                .password(passwordEncoder.encode("password123"))
                .roles(ADMIN.name()) //ROLE_ADMIN
//                .authorities(ADMIN.getSimpleGrantedAuthorities())
                .build();

        UserDetails savannah = User.builder()
                .username("savannah")
                .password(passwordEncoder.encode("password123"))
                .roles(NORMAL.name()) //ROLE_ADMINTRAINEE
//                .authorities(ADMINTRAINEE.getSimpleGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(
                noman,
                yuxin,
                savannah);
    }
}
