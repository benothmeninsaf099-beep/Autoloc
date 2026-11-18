package tn.esprit.autoloc.autolocapi.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class PerformanceAspect {

    @Around("execution(* tn.esprit.autoloc.autolocapi.service.*.*(..))")
    public Object mesurerTemps(ProceedingJoinPoint pjp) throws Throwable {
        long debut = System.currentTimeMillis();

        Object resultat = pjp.proceed();          // exécute la vraie méthode

        long duree = System.currentTimeMillis() - debut;
        String nomMethode = pjp.getSignature().getName();

        log.info("Performance - " + nomMethode + " exécutée en " + duree + " ms");

        if (duree > 1000) {
            log.warn("ATTENTION - la méthode " + nomMethode + " est lente : " + duree + " ms (> 1000 ms)");
        }

        return resultat;                          // on retourne le résultat de la méthode
    }
}