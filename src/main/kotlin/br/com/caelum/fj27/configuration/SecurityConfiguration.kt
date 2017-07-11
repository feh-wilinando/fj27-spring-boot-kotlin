package br.com.caelum.fj27.configuration

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

/**
 * Created by nando on 08/07/17.
 */
@EnableWebSecurity
open class SecurityConfiguration : WebSecurityConfigurerAdapter() {


    override fun configure(http: HttpSecurity?) {
        http?.authorizeRequests()?.anyRequest()?.permitAll()
    }

}