package org.chen.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.views.xslt.ArrayAdapter;
import org.chen.table.Delivery;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 送货方式的dao
 * @author ChenZhongPu
 *
 */
public class DeliveryDao {

	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	public List<Delivery> getDeliveries()
	{
		List<Delivery> deliveries = new ArrayList<Delivery>();
		List rows = jt.queryForList("select * from dilivery");
		Iterator iterator = rows.iterator();
		while(iterator.hasNext())
		{
			Map map = (Map) iterator.next();
			Delivery delivery = new Delivery();
			delivery.setCharge((float)map.get("charge"));
			delivery.setDetail(map.get("detail").toString());
			deliveries.add(delivery);
		}
		
		return deliveries;
	}
}
