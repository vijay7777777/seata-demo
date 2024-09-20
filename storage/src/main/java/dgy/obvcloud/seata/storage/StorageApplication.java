package dgy.obvcloud.seata.storage;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class StorageApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(StorageApplication.class, args);
        System.out.println("port: " + ctx.getEnvironment().getProperty("server.port"));
    }
}
