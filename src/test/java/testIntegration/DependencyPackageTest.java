package testIntegration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import jdepend.framework.DependencyConstraint;
import jdepend.framework.JDepend;
import jdepend.framework.JavaPackage;


public class DependencyPackageTest{
	
	@Test
	public void testPackageExceptionNotDependsOfPackageModel() throws IOException {
		final JDepend jdepend = new JDepend();
		jdepend.addDirectory("./");
		jdepend.analyze();
		DependencyConstraint constraint = new DependencyConstraint();
		JavaPackage  model= constraint.addPackage("model");
		JavaPackage  exception= constraint.addPackage("exception");
		
		exception.dependsUpon(model);

		assertFalse(jdepend.dependencyMatch(constraint));
	}
	
	@Test
	public void testPackageMenuSearchDependsOfModelAndExceptionPackage() throws IOException {
		final JDepend jdepend = new JDepend();
		jdepend.addDirectory("./");
		jdepend.analyze();
		
		JavaPackage  model= jdepend.getPackage("model");
		JavaPackage  exception= jdepend.getPackage("exception");
		JavaPackage  menusearch= jdepend.getPackage("menusearch");
				
		exception.dependsUpon(model); 
		exception.dependsUpon(menusearch);	
		
		jdepend.analyze();
		assertTrue(exception.containsCycle());
		
	}
	
	@Test
	public void testPackageModelHasDependecyCycles() throws IOException { 
		final JDepend jdepend = new JDepend();
		jdepend.addDirectory("./");
		jdepend.analyze();
		
		JavaPackage  model= jdepend.getPackage("model");
		
		assertNotNull(model);
		assertTrue(model.containsCycle());
		
	}
	
	@Test
	public void testPackageExceptionDosentHasDependecyCycles() throws IOException { 
		final JDepend jdepend = new JDepend();
		jdepend.addDirectory("./");
		jdepend.analyze();
		JavaPackage  exception= jdepend.getPackage("exception");
		assertNotNull(exception);
		assertFalse(exception.containsCycle());
		
	}


}