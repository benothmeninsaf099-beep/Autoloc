package tn.esprit.autoloc.autolocapi.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    // Avant chaque méthode de la couche service
    @Before("execution(* tn.esprit.autoloc.autolocapi.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String nomMethode = joinPoint.getSignature().getName();
        Object[] parametres = joinPoint.getArgs();
        log.info("Before - méthode appelée : " + nomMethode);
        log.info("Before - paramètres : " + Arrays.toString(parametres));
    }

    // Après chaque méthode de la couche service (succès ou exception, comme un finally)
    @After("execution(* tn.esprit.autoloc.autolocapi.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        String nomMethode = joinPoint.getSignature().getName();
        log.info("After - fin d'exécution de la méthode : " + nomMethode);
    }
}