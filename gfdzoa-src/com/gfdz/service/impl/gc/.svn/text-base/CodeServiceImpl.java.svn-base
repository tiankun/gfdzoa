package com.gfdz.service.impl.gc;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfdz.entity.gc.CodeEntity;
import com.gfdz.service.gc.CodeServiceI;

@Service("codeService")
@Transactional
public class CodeServiceImpl extends CommonServiceImpl implements CodeServiceI {

	@Override
	public String getCode(String pix, int num) {
		CodeEntity code = findUniqueByProperty(CodeEntity.class, "codeType", pix);
		if (code == null) {
			code = new CodeEntity(pix, 1);
			this.save(code);
		} else {
			code.setSeveral(code.getSeveral() + 1);
		}
		String dfStr = "";
		for (int i = 0; i < num; i++) {
			dfStr += "0";
		}
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
		DecimalFormat df = new DecimalFormat(dfStr);
		String timeStr = sd.format(new Date());
		String billCode = pix + timeStr + df.format(code.getSeveral());
		return billCode;
	}
}
