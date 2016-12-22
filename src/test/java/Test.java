import java.math.BigDecimal;

import com.zhanglin.bean.PositionRTKey;


public class Test {

	public Test() {
		
	}
	
	public static void main(String[] args) {
		PositionRTKey key1 = new PositionRTKey("800080",BigDecimal.ZERO);
		System.out.println(key1.equals(null));
		PositionRTKey key2 = new PositionRTKey("800080",BigDecimal.ZERO);
		System.out.println(key1.equals(key2));
	}

}
