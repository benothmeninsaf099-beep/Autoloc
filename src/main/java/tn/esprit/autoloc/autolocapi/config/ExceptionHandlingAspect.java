package tn.esprit.autoloc.autolocapi.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExceptionHandlingAspect {

    @AfterThrowing(
            pointcut = "execution(* tn.esprit.autoloc.autolocapi.service.*.*(..))",
            throwing = "ex"
    )
    public void gererException(JoinPoint joinPoint, Exception ex) {
        String nomMethode = joinPoint.getSignature().getName();
        log.error("Exception dans la méthode : " + nomMethode);
        log.error("Type de l'exception : " + ex.getClass().getSimpleName());
        log.error("Message d'erreur : " + ex.getMessage());
    }
}