package dgy.obvcloud.seata.order.configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 * @Author: lwj
 * @Description: TODO
 * @Date: 2024/9/18 10:55
 * @Version: 1.0
 */
@Configuration
public class FeignConfig implements RequestInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_TOKEN_PREFIX = "Bearer ";


    @Override
    public void apply(RequestTemplate requestTemplate) {
//        requestTemplate.header(Const.REQUEST_ID, MDC.get(Const.REQUEST_ID));
//        requestTemplate.header(AUTHORIZATION_HEADER, Collections.singletonList(BEARER_TOKEN_PREFIX + "test"));
    }

}

