package com.gfdz.service.impl.gc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.entity.gc.MaterialBaseEntity;
import com.gfdz.entity.gc.ProjectInfoEntity;
import com.gfdz.service.gc.ProjectInfoServiceI;

@Service("projectInfoService")
@Transactional
public class ProjectInfoServiceImpl extends CommonServiceImpl implements ProjectInfoServiceI {

	@Override
	public void saveProject(ProjectInfoEntity projectInfo,HttpServletRequest request) {
		this.save(projectInfo);
		List<MaterialBaseEntity> list = projectInfo.getMaterials();	
		if(list!=null && list.size()>0){
			for (int k = list.size()-1;k >= 0 ;k--) {
				MaterialBaseEntity tp = list.get(k);
				if(tp!=null && tp.getDesignAmount()!=null){
					tp.setProject(projectInfo);
					this.save(tp);
				}
			}
		}
	}

	@Override
	public void updateProject(ProjectInfoEntity projectInfo,HttpServletRequest request) throws Exception {

		List<MaterialBaseEntity> list = this.findByProperty(MaterialBaseEntity.class, "project.id", projectInfo.getId());
		if(list!=null && list.size()>0){
			for (MaterialBaseEntity  materialBase : list) {
				this.delete(materialBase);
			}
		}
		ProjectInfoEntity t = this.findUniqueByProperty(ProjectInfoEntity.class,"id", projectInfo.getId());
		MyBeanUtils.copyBeanNotNull2Bean(projectInfo, t);
		t.setMaterials(null);
		this.saveOrUpdate(t);
		if(projectInfo.getMaterials()!=null && projectInfo.getMaterials().size()>0){
			for (MaterialBaseEntity  material :  projectInfo.getMaterials()) {
				if(material!=null && material.getDesignAmount()!=null && material.getDesignPrice()!=null){
					material.setProject(t);
					this.save(material);
				}
			}
		}
		
	
		
	}
	
	
	
}