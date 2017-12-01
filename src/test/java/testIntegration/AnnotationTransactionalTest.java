package testIntegration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.springframework.transaction.annotation.Transactional;

import org.junit.Test;
import org.reflections.Reflections;

import jdepend.framework.DependencyConstraint;
import jdepend.framework.JDepend;
import jdepend.framework.JavaPackage;
import services.GenericService;
import services.MenuService;
import services.UserService;

public class AnnotationTransactionalTest {
	
	
	 
	@Test
	public void testAllMethodsInPackageServicesAddAnnotatedTransactional() throws IOException {
		
		
		Reflections reflections = new Reflections("");    
		@SuppressWarnings("")
		Set<Class<? extends GenericService>> classes = reflections.getSubTypesOf( GenericService.class);

		 	for (Class<? extends GenericService> class1 : classes) {
		 		List<Method> lista = this.getMethodsAnnotatedWith(class1,Transactional.class);
		 		
				//assertEquals(class1.getName(),0,lista.size() );
			}
			

			
		
	}
	
	public static List<Method> getMethodsAnnotatedWith(final Class<?> type, final Class<? extends Annotation> annotation) {
	    final List<Method> methods = new ArrayList<Method>();
	    Class<?> klass = type;
	    while (klass != Object.class) { // need to iterated thought hierarchy in order to retrieve methods from above the current instance
	        // iterate though the list of methods declared in the class represented by klass variable, and add those annotated with the specified annotation
	        final List<Method> allMethods = new ArrayList<Method>(Arrays.asList(klass.getDeclaredMethods()));       
	        for (final Method method : allMethods) {
	            if (!method.isAnnotationPresent(annotation) && method.getModifiers()== Modifier.PUBLIC) {
	                Annotation annotInstance = method.getAnnotation(annotation);
	                methods.add(method);
	            }
	        }
	        // move to the upper class in the hierarchy in search for more methods
	        klass = klass.getSuperclass();
	    }
	    return methods;
	}
	
	
}