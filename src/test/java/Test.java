import java.text.SimpleDateFormat;
import java.util.Date;



public class Test {

	public Test() {
		
	}
	
	public static void main(String[] args) throws Exception {
		String time = "2012-8-21 16:16:23.234";
		Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").parse(time);
		System.out.println(new SimpleDateFormat("yyyyMMdd").format(date));
		System.out.println(new SimpleDateFormat("HHmm").format(date));
		System.out.println(date);
	}

}
