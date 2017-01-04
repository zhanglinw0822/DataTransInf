package com.zhanglin.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhanglin.Constant;
import com.zhanglin.bean.Data;
import com.zhanglin.dao.TransferRequestMapper;
import com.zhanglin.pojo.TransferRequest;
import com.zhanglin.pojo.TransferRequestExample;
import com.zhanglin.service.IRequestService;
@Service("requestService")
public class RequestServiceImpl implements IRequestService{
	
	@Resource
	private TransferRequestMapper requestDao;

	public BigDecimal insertRequest(Data data, String status) {
		TransferRequest request = new TransferRequest();
		request.setData(data.getOrigJson());
		request.setDelay(new BigDecimal(data.getDelay()));
		request.setDescomid(data.getId());
		request.setMsguid(data.getMsguid());
		request.setOrdertime(data.getOrdertime());
		request.setRealtime(data.getRealtime());
		request.setNet(data.getNetvalue());
		request.setStatus(status);
		requestDao.insert(request);
		
		data.setRequestId(request.getId());
		return request.getId();
	}

	public TransferRequest getRequest(Data data) {
		
		TransferRequestExample example = new TransferRequestExample();
		example.createCriteria().andMsguidEqualTo(data.getMsguid()).andStatusEqualTo(Constant.REQUEST_STATUS_SUCESS);
		List<TransferRequest> list = requestDao.selectByExample(example );
		return list.size()>0?list.get(0):null;
	}

	public void updateRequest(Data data, String status) {
		TransferRequest request = new TransferRequest();
		request.setMsguid(data.getMsguid());
		request.setStatus(status);
		request.setId(data.getRequestId());
		requestDao.updateByMsguid(request);
	}
}
