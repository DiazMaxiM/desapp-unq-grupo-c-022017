package aspects;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.joda.time.DateTime;

@Aspect
public class LoggingAspect {
	private static Logger log = Logger.getLogger(LoggingAspect.class.getName());

	public LoggingAspect() {
		PropertyConfigurator.configure("src/main/java/log4j.properties");
	}

	public Object logAfter(ProceedingJoinPoint jointPoint) throws Throwable {
		MethodSignature signature = (MethodSignature) jointPoint.getSignature();
		DateTime initialTime = new DateTime();
		String nameMethod = signature.getMethod().getName();
		log.info("Start " + nameMethod + " in " + initialTime);
		this.printArguments(jointPoint.getArgs());
		Object response = jointPoint.proceed();
		DateTime endTime = new DateTime();
		log.info("End " + nameMethod + " in " + endTime);
		return response;
	}

	public void printArguments(Object[] arguments) {
		log.info("*****Arguments*****");
		for (Object o : arguments) {
			log.info(o.toString());
		}
	}
}