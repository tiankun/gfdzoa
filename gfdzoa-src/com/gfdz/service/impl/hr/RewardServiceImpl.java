package com.gfdz.service.impl.hr;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.service.hr.RewardService;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("rewardService")
@Transactional
public class RewardServiceImpl extends CommonServiceImpl implements RewardService {
	
}