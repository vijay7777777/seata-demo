package dgy.obvcloud.seata.order;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@EnableFeignClients
@SpringBootApplication
public class OrderApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(OrderApplication.class, args);
        System.out.println("port: " + ctx.getEnvironment().getProperty("server.port"));
    }
}
