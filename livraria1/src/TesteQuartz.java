import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class TesteQuartz {

	public static void main(String[] args) throws SchedulerException {
		
		JobKey jobKeyA = new JobKey("jobA", "group1");
    	JobDetail jobA = JobBuilder.newJob(JobABean.class)
		.withIdentity(jobKeyA).build();
    	
    	
    	Trigger trigger1 = TriggerBuilder
    			.newTrigger()
    			.withIdentity("dummyTriggerName1", "group1")
    			.withSchedule(
    				CronScheduleBuilder.cronSchedule("0/6 * * * * ?"))
    			.build();
   	
    	Scheduler scheduler = new StdSchedulerFactory().getScheduler();

    	scheduler.start();
    	scheduler.scheduleJob(jobA, trigger1);	
    	
	}

}
