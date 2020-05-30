import java.util.*;

public class Task extends TimerTask{
	int count = 1;
	@Override
	public void run() {
		System.out.println(count+" : Menino Jun");
        count++;
		
	}

}
