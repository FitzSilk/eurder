package be.adrienhelin.project.api.security;

import be.adrienhelin.project.api.controllers.CustomerController;
import be.adrienhelin.project.api.controllers.ItemController;
import be.adrienhelin.project.api.controllers.OrderController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationEntryPoint authEntryPoint;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @Autowired
    public SecurityConfig(AuthenticationEntryPoint authEntryPoint, UserAuthenticationProvider userAuthenticationProvider) {
        this.authEntryPoint = authEntryPoint;
        this.userAuthenticationProvider = userAuthenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.csrf().disable().authorizeRequests()
                .antMatchers(CustomerController.CUSTOMER_RESOURCE_PATH + "/**").permitAll()
                .antMatchers(ItemController.ITEM_RESOURCE_PATH + "/**").permitAll()
                .antMatchers(OrderController.ORDER_RESOURCE_PATH + "/**").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic()
                .authenticationEntryPoint(authEntryPoint)
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(userAuthenticationProvider);
    }

}
