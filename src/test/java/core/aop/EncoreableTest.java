package core.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AopConfiguration.class)
public class EncoreableTest {

    @Autowired
    Performance theatre;

    @Test
    public void testEncore() {
//        Encoreable encoreable = (Encoreable) new AnnotationConfigApplicationContext(AopConfiguration.class).getBean("theatre").encoreable;
//        encoreable.performEncore();
        theatre.perform();
    }

}