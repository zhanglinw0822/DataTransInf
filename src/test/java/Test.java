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
		FileName filename = new FileName();
		filename.setNewid(BigDecimal.ONE.toString());
		filename.setOrdertime("2016-09-28");
		filename.setRealtime("1023");
		System.out.println(filename);
		
		Path path = FileSystems.getDefault().getPath(filename.toString());
		Files.write(path, "0|600889|B||LIMIT|T5|0|2000\r\n".getBytes(),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
		Files.write(path, "0|600889|S||LIMIT|T5|0|2000\r\n".getBytes(),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
	}

}
