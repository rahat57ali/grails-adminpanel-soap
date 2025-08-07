package proj.assignment.config

import org.apache.cxf.Bus
import org.apache.cxf.bus.spring.SpringBus
import org.apache.cxf.jaxws.EndpointImpl
import org.apache.cxf.transport.servlet.CXFServlet
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ComponentScan
import proj.assignment.soap.UserDetailsServiceImpl

@Configuration
@ComponentScan(basePackages = "proj.assignment.soap")
class CxfConfiguration {

    @Bean(name = "cxf")
    Bus cxfBus() {
        return new SpringBus()
    }

    @Bean
    ServletRegistrationBean cxfServletRegistration() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new CXFServlet(), "/ws/*")
        servletRegistrationBean.setLoadOnStartup(1)
        return servletRegistrationBean
    }

    @Bean
    EndpointImpl userDetailsEndpoint(UserDetailsServiceImpl userDetailsServiceImpl, Bus cxf) {
        EndpointImpl endpoint = new EndpointImpl(cxf, userDetailsServiceImpl)
        endpoint.publish("/UserDetailsService")
        return endpoint
    }
}