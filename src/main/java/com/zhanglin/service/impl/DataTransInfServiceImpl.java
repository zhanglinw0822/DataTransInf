package com.zhanglin.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zhanglin.cache.CacheManager;
import com.zhanglin.pojo.Data;
import com.zhanglin.pojo.Descom;
import com.zhanglin.service.IDataTransInfService;

@Service("dataTransInfService")
public class DataTransInfServiceImpl implements IDataTransInfService {

	public void dataTransInfo(List<Data> datas) {
		for (Iterator<Data> iterator = datas.iterator(); iterator.hasNext();) {
			Data data = iterator.next();
			Descom descom = CacheManager.getInstance().getDescom(data.getId());
			
			if(checkRisk(data)){
				int num = generatePostion(descom,data);
				
				generateAsset(data,num);
			}
			
			System.out.println("处理数据："+data);
		}

	}

	/**
	 * 生成交易指令
	 * @param data
	 * @param num
	 */
	private void generateAsset(Data data, int num) {
		
	}

	/**
	 * 匹配组合持仓 
	 * @param descom
	 * @param data
	 */
	private int generatePostion(Descom descom, Data data) {
		
		return 0;
	}

	/**
	 * 风控检查
	 * 1.单只个股权调仓后最大权重不超过30%,超过就按30%算;2.非st.
	 * @param descom
	 */
	private boolean checkRisk(Data Data) {
		
		
		return true;
	}

}
