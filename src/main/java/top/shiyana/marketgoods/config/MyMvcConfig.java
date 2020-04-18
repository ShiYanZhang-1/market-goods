package top.shiyana.marketgoods.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ProjectName: market-goods
 * @Package: top.shiyana.marketgoods.config
 * @ClassName: MyMvcConfig
 * @Author: dangerous
 * @Description:
 * @Date: 2020/4/16 11:53
 * @Version: 1.0
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/backIndex").setViewName("/pages/back/index");
        registry.addViewController("/pages/back/index").setViewName("/pages/back/index");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //  pathPatterns  为前端URL访问路径  addResourceLocations（） 为本地磁盘映射
        registry.addResourceHandler("/images/*/**").addResourceLocations("file:"+System.getProperty("user.dir")+"/src/main/view/static/images/");
    }
}
