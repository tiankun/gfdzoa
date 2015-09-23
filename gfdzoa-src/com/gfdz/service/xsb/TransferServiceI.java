package com.gfdz.service.xsb;

import org.jeecgframework.core.common.service.CommonService;

import com.gfdz.entity.xsb.TransferEntity;

public interface TransferServiceI extends CommonService{
	
	/**
	 * 
	  * @Title: savrTransfer
	  * @Description: 保存设计交底
	  * @param transfer void
	  * @throws 
	  * @exception
	  * @author fly
	  * @date 2015年8月14日 上午11:07:21
	 */
	public void saveTransfer(TransferEntity transfer) throws Exception;

}
