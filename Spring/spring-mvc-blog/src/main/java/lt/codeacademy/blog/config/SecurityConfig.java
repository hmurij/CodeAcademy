package lt.codeacademy.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth
                .inMemoryAuthentication()
                .withUser("admin")
//                      .password(encoder.encode("admin")).roles("ADMIN")
                .password("{bcrypt}$2a$10$JM11cOpmVZMhEIjwp4gfTuztM2YUEs7FbWJYrpG6pLDEk6NYib/TO").roles("ADMIN")
                .and()
                .withUser("user")
//                      .password(encoder.encode("user")).roles("USER");
                .password("{bcrypt}$2a$10$eL1q3ek7KbWBAo2tRr.IueMSxy5P.7qtkUcHELSVPdeTlN1CLny6u").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/main").permitAll()
//                .and().authorizeRequests().antMatchers("/login", "logout").permitAll()
                .and().authorizeRequests().antMatchers("/static/**").permitAll()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/main").permitAll()
                .and().logout().invalidateHttpSession(true).deleteCookies("JSESSIONID")
                .logoutUrl("/logout")
                .logoutSuccessUrl("/logout-success")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
        ;
    }
}
