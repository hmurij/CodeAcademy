package lt.codeacademy.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth
//                .inMemoryAuthentication()
//                .withUser("admin")
//                      .password(encoder.encode("admin")).roles("ADMIN")
//                .password("{bcrypt}$2a$10$JM11cOpmVZMhEIjwp4gfTuztM2YUEs7FbWJYrpG6pLDEk6NYib/TO").roles("ADMIN")
//                .and()
//                .withUser("user")
////                      .password(encoder.encode("user")).roles("USER");
//                .password("{bcrypt}$2a$10$eL1q3ek7KbWBAo2tRr.IueMSxy5P.7qtkUcHELSVPdeTlN1CLny6u").roles("USER")
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "SELECT username, password, TRUE AS enabled FROM blog_user WHERE username = ?"
                )
                .authoritiesByUsernameQuery(
                        "SELECT username, authority FROM blog_user WHERE username = ?"
                );
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests(authoriseRequests -> authoriseRequests
                        .antMatchers("/api/posts/**", "/api/auth/**", "/h2-console/**", "/**").permitAll()
                        // require authentication on all requests
                        .anyRequest().authenticated()
                )
                // disable CSRF
                .csrf(CsrfConfigurer::disable)
                // disable frame options for H2 console
                .headers().frameOptions().disable().and()
                // disable sessions
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
