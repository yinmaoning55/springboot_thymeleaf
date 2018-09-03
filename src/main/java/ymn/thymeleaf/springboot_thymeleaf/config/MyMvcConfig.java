package ymn.thymeleaf.springboot_thymeleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import ymn.thymeleaf.springboot_thymeleaf.component.LoginHandlerInterceptor;
import ymn.thymeleaf.springboot_thymeleaf.component.MylocaleResolver;

//springmvc全面接管配置，springboot默认配置失效，静态资源访问失效
//@EnableWebMvc
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // super.addViewControllers(registry);
        //浏览器发送 /path 请求来到 success
        registry.addViewController("/path").setViewName("success");
    }
    //配置访问静态资源
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter= new WebMvcConfigurerAdapter(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry){
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/mian.html").setViewName("dashboard");

            }
            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //spring boot已经做好了静态资源映射
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login");
            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){

        return new MylocaleResolver();
    }

}
