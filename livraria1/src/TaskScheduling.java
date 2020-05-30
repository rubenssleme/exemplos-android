import java.util.Timer;

public class TaskScheduling {

	public static void main(String[] args) {
		Timer timer = new Timer();

		// Schedule to run after every 3 second(3000 millisecond)
		timer.schedule( new Task(), 3000);   
	}


}
