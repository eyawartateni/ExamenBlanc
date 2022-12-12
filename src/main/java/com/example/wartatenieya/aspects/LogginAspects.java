package  com.example.wartatenieya.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogginAspects {
   @After("execution(*  com.example.wartatenieya.controller.EyaWartaController.*(..))")
    public  void LoginMethod(JoinPoint joinPoint)
    {
log.info("methode executée :" +joinPoint.getSignature().getName());
    }
}
