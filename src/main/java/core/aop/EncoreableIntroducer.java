package core.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EncoreableIntroducer {

    @DeclareParents(value="Performance+",
            defaultImpl=DefaultEncoreable.class)
    public static Encoreable encoreable;


}