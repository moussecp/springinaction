package core.aop;

import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {

    @Pointcut("execution(** Performance.perform(..))")
    public void performance() {}

    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Before: Silencing cell phones");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("Before: Taking seats");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("AfterReturning: CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("AfterThrowing: Demanding a refund");
    }

    @Before("execution(** Performance.pay(int)) && args(amount)")
    public void payReport(int amount) {
        System.out.println("Before: Need to pay " + amount);
    }

//    @Around("performance()")
//    public void watchPerformance(ProceedingJoinPoint jp) {
//        try {
//            System.out.println("Around: Silencing cell phones");
//            System.out.println("Around: Taking seats");
//            jp.proceed();
//            System.out.println("Around: CLAP CLAP CLAP!!!");
//        } catch (Throwable e) {
//            System.out.println("Around: Demanding a refund");
//        }
//    }
}
