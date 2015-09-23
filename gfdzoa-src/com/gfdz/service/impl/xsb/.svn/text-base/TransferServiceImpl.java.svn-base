package com.gfdz.service.impl.xsb;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.entity.gc.ProjectInfoEntity;
import com.gfdz.entity.xsb.TransferEntity;
import com.gfdz.service.xsb.TransferServiceI;

@Service("transferService")
@Transactional
public class TransferServiceImpl extends CommonServiceImpl implements TransferServiceI {

	@Override
	public void saveTransfer(TransferEntity transfer) throws Exception {
		ProjectInfoEntity project = this.get(ProjectInfoEntity.class, transfer.getProject().getId());
		MyBeanUtils.copyBeanNotNull2Bean(transfer.getProject(), project);
		this.saveOrUpdate(project);
		if("".equals(transfer.getId())){
			transfer.setId(null);
		}
		this.saveOrUpdate(transfer);
	}
	
}