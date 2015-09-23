package com.gfdz.service.impl.gc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.entity.gc.MaterialBaseEntity;
import com.gfdz.entity.gc.ProjectScheduleDetailEntity;
import com.gfdz.entity.gc.ProjectScheduleEntity;
import com.gfdz.service.gc.ProjectScheduleServiceI;

@Service("projectScheduleService")
@Transactional
public class ProjectScheduleServiceImpl extends CommonServiceImpl implements ProjectScheduleServiceI {

	@Override
	public void saveProjectSchedule(ProjectScheduleEntity projectSchedule,HttpServletRequest request) {
		if("".equals(projectSchedule.getId())){
			projectSchedule.setId(null);
		}
		this.saveOrUpdate(projectSchedule);
		List<ProjectScheduleDetailEntity> list = projectSchedule.getProjectScheduleDetail();
		if(list!=null && list.size()>0){
			for (int k = list.size()-1;k >= 0 ;k--) {
				ProjectScheduleDetailEntity tp = list.get(k);
				if(tp!=null && tp.getAmount()!=null){
					tp.setProjectSchedule(projectSchedule);
					this.saveOrUpdate(tp);
				}
			}
		}
	}
}