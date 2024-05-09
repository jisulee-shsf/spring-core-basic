package course.springcorebasic.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StateTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(statefulServiceTestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        statefulService1.order("A", 10000);
        statefulService2.order("B", 30000);

        // thread A: 사용자 A 주문 건
        int price1 = statefulService1.getPrice();
        // thread B: 사용자 B 주문 건
        int price2 = statefulService2.getPrice();

        Assertions.assertThat(price1).isEqualTo(30000);
        Assertions.assertThat(price2).isEqualTo(30000);
    }

    static class statefulServiceTestConfig {

        @Bean
        StatefulService statefulService() {
            return new StatefulService();
        }
    }

    @Test
    void statelessServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(statelssServiceTestConfig.class);
        StatelessService statelessService1 = ac.getBean("statelessService", StatelessService.class);
        StatelessService statelessService2 = ac.getBean("statelessService", StatelessService.class);

        // thread A: 사용자 A 주문 건
        int price1 = statelessService1.order("A", 10000);
        // thread B: 사용자 B 주문 건
        int price2 = statelessService2.order("B", 30000);

        Assertions.assertThat(price1).isEqualTo(10000);
        Assertions.assertThat(price2).isEqualTo(30000);
    }

    static class statelssServiceTestConfig {

        @Bean
        StatelessService statelessService() {
            return new StatelessService();
        }
    }
}