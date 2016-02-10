package org.mju.aspect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Clase que implementa el aspecto para guardar los campos de auditoría en los registros de base de datos
 * @author Hugo
 *
 */
@Aspect
@Component
public class DBAuditAspect {

	Logger log = Logger.getLogger(DBAuditAspect.class);

	@Before("execution(* org.mju.dao.Dao.save(..))")
	public void save(JoinPoint joinPoint) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Object[] args = joinPoint.getArgs();
		Object entity = args[0];

		try {
			Method setCreacion = entity.getClass().getMethod("setCreacion", new Class[]{Timestamp.class});
			Method setModificacion = entity.getClass().getMethod("setModificacion", new Class[]{Timestamp.class});
			setCreacion.invoke(entity, new Object[]{timestamp});
			setModificacion.invoke(entity, new Object[]{timestamp});
		} catch (NoSuchMethodException e) {
			log.error(e.getMessage());
		} catch (SecurityException e) {
			log.error(e.getMessage());
		} catch (IllegalAccessException e) {
			log.error(e.getMessage());
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage());
		} catch (InvocationTargetException e) {
			log.error(e.getMessage());
		}
	}

	@Before("execution(* org.mju.dao.Dao.update(..))")
	public void update(JoinPoint joinPoint) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Object[] args = joinPoint.getArgs();
		Object entity = args[0];

		try {
			Method setModificacion = entity.getClass().getMethod("setModificacion", new Class[]{Timestamp.class});
			setModificacion.invoke(entity, new Object[]{timestamp});
		} catch (NoSuchMethodException e) {
			log.error(e.getMessage());
		} catch (SecurityException e) {
			log.error(e.getMessage());
		} catch (IllegalAccessException e) {
			log.error(e.getMessage());
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage());
		} catch (InvocationTargetException e) {
			log.error(e.getMessage());
		}
	}
	
}
