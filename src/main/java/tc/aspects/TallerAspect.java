package tc.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


/**
 * Complete este aspecto para que haga lo siguiente:
 * 1 (50%). Intercepte todos los llamados (call) a los setters de clases en el paquete tc.aspects.data 
 *   que hayan sido llamados desde la clase University
 * 		- Imprima por pantalla la firma completa del método interceptado y la línea en el código donde se produjo la intercepción
 * 
 * 2 (50%). Intercepte todas las ejecuciones (execution) a los getters de clases en el paquete tc.aspects.data 
 *   cuya clase esté anotada con @Auditable
 * 		- Imprima por pantalla la firma completa del método interceptado y el valor retornado por el método
 * 
 * NOTA: Para hacer pruebas, si es necesario, modifique el resto del código. Explique dichas modificaciones en el video
 */
@Aspect
public class TallerAspect {
	@Before("call(* tc.aspects.data.*.set*(..))")
	public void point1(JoinPoint jp){
		System.out.println("Interceptado: " + jp.getSignature().toLongString() + " en " + jp.getSourceLocation().getLine());
	}

	@Before("execution(* tc.aspects.data.*.get*(..)) && @annotation(tc.aspects.annotations.Auditable)")
	public void point2(JoinPoint jp) throws Throwable{
		System.out.println("Interceptado: " + jp.getSignature().toLongString() + " con valor " + jp.getArgs()[0]);
	}
}
