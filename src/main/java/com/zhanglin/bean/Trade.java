package com.zhanglin.bean;

public class Trade {
	public static final String SEPARATOR = "|";
	public static final String TRADETYPE_PRFIX = "TRADETYPE_";
	private String market;
	private String code;
	private String tradetype;
	private String hedgingOrSpeculation="";
	private String priceModel="LIMIT";
	private String priceType="F";
	private String price;
	private String num;

	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		if(code.startsWith("SZ")){
			this.market = "1";
		}else if(code.startsWith("SH")){
			market = "0";
		}
		this.code = code.substring(2);
	}
	public String getTradetype() {
		return tradetype;
	}
	public void setTradetype(String tradetype) {
		this.tradetype = TradeTypeEnum.valueOf(TRADETYPE_PRFIX+tradetype).value;
	}
	public String getHedgingOrSpeculation() {
		return hedgingOrSpeculation;
	}
	public void setHedgingOrSpeculation(String hedgingOrSpeculation) {
		this.hedgingOrSpeculation = hedgingOrSpeculation;
	}
	public String getPriceModel() {
		return priceModel;
	}
	public void setPriceModel(String priceModel) {
		this.priceModel = priceModel;
	}
	public String getPriceType() {
		return priceType;
	}
	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	public String getTradeOrder() {
		return market + SEPARATOR + code + SEPARATOR + tradetype
				+ SEPARATOR + hedgingOrSpeculation + SEPARATOR + priceModel
				+ SEPARATOR + priceType + SEPARATOR + price + SEPARATOR + num +"\r\n";
	}
	
	/**
	 * @author zhanglin
	 *委托方向枚举变量
	 */
	public enum TradeTypeEnum{
		TRADETYPE_0("S"),TRADETYPE_1("B");
		private String value;
		private TradeTypeEnum(String value) {
			this.value = value;
		}
	}

}
