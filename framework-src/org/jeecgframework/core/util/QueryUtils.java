package org.jeecgframework.core.util;

import java.beans.PropertyDescriptor;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.collection.internal.PersistentBag;
import org.jeecgframework.core.util.ReflectHelper;

/**
 * 查询工具
 * @author fly
 *
 */
public class QueryUtils {
	public final static int SQL = 0;
	public final static int HQL = 1;
	private static String QUERY_ = ".";

	/***
	 * 根据实体里面的值生成HQL查询追加条件
	 * 
	 * @param pix
	 *            前缀（表别名）
	 * @param entity
	 *            实体
	 * @return
	 * @throws Exception
	 */
	public static <T> String getQueryCondition(String pix, T entity, int queryType) {
		StringBuffer hql = new StringBuffer("");
		try {
			PropertyDescriptor pro[] = PropertyUtils.getPropertyDescriptors(entity);
			for (int i = 0; i < pro.length; i++) {
				String name = pro[i].getName();// 属性名称
				String type = pro[i].getPropertyType().toString();// 属性类型
				Object value = pro[i].getReadMethod().invoke(entity, new Object[0]);
				if (StringUtil.isNotEmpty(value) && !name.equals("class")) {
					if (type.contains(".entity.")) {// 属性为entity对象
						if (queryType == 0) {
							QUERY_ = "_";
							boolean prefix = pix.indexOf(".") != -1;
							hql.append(getQueryCondition(pix + (prefix ? "_" : ".") + name, value, SQL));
							QUERY_ = ".";
						} else {
							hql.append(getQueryCondition(pix + QUERY_ + name, value, HQL));
						}

					} else if (type.contains("java.lang.Integer") || type.contains("java.lang.Double")) {
						hql.append(" and " + pix + QUERY_ + name + "=" + value);

					} else if (type.contains("java.lang.String")) {
						if ("id".equals(name)) {
							hql.append(" and " + pix + QUERY_ + name + " = '" + value + "'");

						} else {
							hql.append(" and " + pix + QUERY_ + name + " like '%" + value + "%'");
						}
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hql.toString();
	}

	/**
	 * 
	 * @author WU
	 * @date 2014-10-30 下午8:50:22
	 * @param entity
	 * @param entityName
	 * @param state
	 *            节点状态, 'open' 或者 'closed'
	 * @return
	 */
	public static <T> JSONArray entityList2JSONArray(List<T> entity, List<String> entityName, String state) {
		JSONArray list = new JSONArray();
		for (int i = 0; i < entity.size(); i++) {
			list.add(entity2JSONObject(entity.get(i), entityName, state));
		}
		return list;
	}

	/***
	 * 
	 * @author WU
	 * @date 2014-10-30 下午4:48:30
	 * @param entity
	 * @param entityName
	 * @param pix
	 * @return
	 */
	public static <T> JSONObject entity2JSONObject(T entity, List<String> entityName, String state) {
		JSONObject json = new JSONObject();
		ReflectHelper reflectHelper = new ReflectHelper(entity);
		json.put("state", state);
		for (int i = 0; i < entityName.size(); i++) {
			String name, key;
			if (entityName.get(i).contains(":")) {
				String[] var = entityName.get(i).split(":");
				key = var[0];
				name = var[1];
			} else {
				name = entityName.get(i);
				key = entityName.get(i);
			}
			if (name.contains(".")) {

			} else {
				Object obj = reflectHelper.getMethodValue(name);
				if (obj == null)
					continue;
				String type = obj.getClass().toString();
				if (type.contains("org.hibernate.collection.internal.PersistentBag")) {
					PersistentBag bag = (PersistentBag) obj;
					JSONArray list = new JSONArray();
					for (int j = 0; j < bag.size(); j++) {
						list.add(entity2JSONObject(bag.get(j), entityName, state));
					}
					json.put(key, list);
				} else {
					json.put(key, obj);
				}
			}
		}
		return json;
	}
}
