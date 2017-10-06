package core.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AopConfiguration.class)
public class PerformanceTest {

    @Autowired
    @Qualifier("theatre")
    Performance theatre;

    @Autowired
    @Qualifier("cinema")
    Performance cinema;

    @Test
    public void testPerform() {
        System.out.println("Theatre scenario");
        try {
            theatre.perform();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        System.out.println("Cinema scenario");
        try {
            cinema.perform();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testPay() {
        System.out.println("Theatre scenario");
        try {
            theatre.pay(10);
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        System.out.println("Cinema scenario");
        try {
            cinema.pay(8);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}