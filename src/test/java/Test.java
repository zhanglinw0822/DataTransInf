import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.zhanglin.bean.FileName;



public class Test {

	public Test() {
		
	}
	
	public static void main(String[] args) throws Exception {
		FileName filename = new FileName();
		filename.setNewid("123");
		filename.setOrdertime("2017-03-01");
		filename.setRealtime("1354");
		
		System.err.println(filename.toString());
	}

}
