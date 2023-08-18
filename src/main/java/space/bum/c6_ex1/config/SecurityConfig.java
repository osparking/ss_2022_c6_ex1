package space.bum.c6_ex1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	// @formatter:off
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.httpBasic().and()
				.authorizeRequests()
//					.mvcMatchers(HttpMethod.GET, "/demo/**").hasAuthority("read")
//				.anyRequest().authenticated().and()
					.antMatchers("/test/test1", "/test/test1/").authenticated()
					.anyRequest().permitAll().and()
					.csrf().disable() // don't do this for production
				.build();
	}
	// @formatter:on

	@Bean
	UserDetailsService userDetailsService() {
		var man = new InMemoryUserDetailsManager();

		var user1 = User.withUsername("park")
				.password(passwordEncoder().encode("1234")).authorities("read").build();

		var user2 = User.withUsername("will")
				.password(passwordEncoder().encode("1234")).authorities("write")
				.build();

		man.createUser(user1);
		man.createUser(user2);
		return man;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
