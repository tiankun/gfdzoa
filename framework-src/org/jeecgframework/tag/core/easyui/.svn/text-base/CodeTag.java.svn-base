package org.jeecgframework.tag.core.easyui;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.pojo.base.TSType;
import org.jeecgframework.web.system.pojo.base.TSTypegroup;

@SuppressWarnings("serial")
public class CodeTag extends BodyTagSupport {

	public String value;
	public String typeGroupCode;

	public int doStartTag() {
		try {
			if (StringUtil.isNotEmpty(typeGroupCode) && StringUtil.isNotEmpty(value)) {
				List<TSType> list = TSTypegroup.allTypes.get(typeGroupCode.toLowerCase());
				if (list != null && list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getTypecode().equals(value)) {
							  pageContext.getOut().print(list.get(i).getTypename());
							break;
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Tag.EVAL_BODY_INCLUDE;
	}
 
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getTypeGroupCode() {
		return typeGroupCode;
	}

	public void setTypeGroupCode(String typeGroupCode) {
		this.typeGroupCode = typeGroupCode;
	}

}
