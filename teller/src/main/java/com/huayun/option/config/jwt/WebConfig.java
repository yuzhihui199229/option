package com.huayun.option.config.jwt;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * springmvc 拦截器的设置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor())
                //有用的路径都要经过拦截器
                .addPathPatterns("/option/**")
                //排除登录的路径,释放swagger-ui路径
                .excludePathPatterns("/option/tellInfo/login");
    }
}
