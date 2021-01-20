package com.bit.config;

import com.bit.interceptor.InterceptorAdapterDemo;
import com.bit.interceptor.InterceptorDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Autowired
    private InterceptorDemo interceptorDemo;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 日志拦截器
        //registry.addInterceptor(logInterceptor).addPathPatterns("/**");
        // 登录拦截器
        registry.addInterceptor(interceptorDemo).addPathPatterns("/**").excludePathPatterns("/login");
        //registry.addInterceptor(new InterceptorAdapterDemo()).addPathPatterns("/**");
        //registry.addInterceptor(interceptorDemo).addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/web/**").addResourceLocations("classpath:/static/");
    }

    @Bean
    public RestTemplate restTemplate() {
//        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//        requestFactory.setReadTimeout(1000);
//        requestFactory.setConnectTimeout(1000);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    //@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            //重写父类提供的跨域请求处理的接口
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                //添加映射路径
                registry.addMapping("/**")
                        //放行哪些原始域
                        .allowedOrigins("*")
                        //是否发送Cookie信息
                        .allowCredentials(true)
                        //放行哪些原始域(请求方式)
                        .allowedMethods("GET","POST", "PUT", "DELETE")
                        //放行哪些原始域(头部信息)
                        .allowedHeaders("*")
                        //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
                        .exposedHeaders("Header1", "Header2");
            }
        };
    }
}
