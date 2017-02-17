import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import com.zhanglin.bean.FileName;
import com.zhanglin.bean.Trade;



public class Test {

	public Test() {
		
	}
	
	public static void main(String[] args) throws IOException {
		String temp = "SH600987".substring(2, 3);
		System.out.println(temp);
		temp = "SH600987".substring(0, 2);
		System.out.println(temp);
		temp = "SH600987".substring(2);
		System.out.println(temp);
	}

}
