package top.shiyana.marketgoods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.shiyana.marketgoods.dao")
public class MarketGoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketGoodsApplication.class, args);
    }

}
