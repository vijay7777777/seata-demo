package dgy.obvcloud.seata.account;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AccountApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(AccountApplication.class, args);
        System.out.println("port: " + ctx.getEnvironment().getProperty("server.port"));
    }
}
