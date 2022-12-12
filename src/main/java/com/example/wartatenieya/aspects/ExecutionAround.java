package  com.example.wartatenieya.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

@Component
@Aspect
@Slf4j
public class ExecutionAround {
/*
    @Around("execution(* tn.esprit.projet.services.ContratServiceImp.*(..))")
    public  Object LoginMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        StopWatch stopWatch= new StopWatch();
        stopWatch.start();
          Object obj=  proceedingJoinPoint.proceed();
        log.info("execution time of method: {} is {} "+proceedingJoinPoint.getSignature().getName(),stopWatch.getLastTaskTimeMillis());
        return obj;
    }

 /*   @Around("execution(* tn.esprit.projet.services.ContratServiceImp.addContrat(..))")
    public List<Object> LoginMeethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        StopWatch stopWatch= new StopWatch();
        stopWatch.start();
        List<Object> obj= new ArrayList<>();
            obj= (List<Object>) proceedingJoinPoint.proceed();
        log.info("execution time of method: {} is {} "+proceedingJoinPoint.getSignature().getName(),stopWatch.getLastTaskTimeMillis());
        return obj;
    }*/
}
