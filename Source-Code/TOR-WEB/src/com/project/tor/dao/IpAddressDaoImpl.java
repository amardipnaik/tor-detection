package com.project.tor.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import com.project.tor.bean.IpAddressBean;
import com.project.tor.bean.UserBean;

@Repository
public class IpAddressDaoImpl implements IIpAddressDao{

	
	//private static final Logger logger = LoggerFactory.getLogger(IpAddressDaoImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	
	public void addIpAddress(IpAddressBean ipAddress) {
		
		ipAddress.setIsTor("no");
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(ipAddress);
		System.out.println("ipAddress saved successfully, ipAddress Details="+ipAddress);
		
	}

	public void updateIpAddress(IpAddressBean ipAddress) {
		
		/*Session session = this.sessionFactory.getCurrentSession();
		session.update(ipAddress);*/
		Session session = this.sessionFactory.getCurrentSession();
		StringBuilder querryBuilder=new StringBuilder();
		
		querryBuilder.append("update ip_address set is_tor='yes' where ip_address=:ipAddress");
		
		SQLQuery query
		 = session.createSQLQuery(querryBuilder.toString()).addEntity(UserBean.class);
		
		query.setParameter("ipAddress",ipAddress.getIpAddress());
		
		System.out.println("IpAddressBean updated successfully, IpAddressBean Details="+ipAddress);
		int result=query.executeUpdate();
		System.out.println("Update Result Is:: "+result);
		
	}

	public List<IpAddressBean> listIpAddress(String isTor) {
		Session session = this.sessionFactory.getCurrentSession();
		
		StringBuilder querryBuilder=new StringBuilder();
		
		querryBuilder.append("SELECT * FROM Ip_address WHERE ");
		
		if(isTor.equalsIgnoreCase("yes"))
		{
			querryBuilder.append(" is_tor='yes'");

		}
		else
		{
			querryBuilder.append(" is_tor='no'");
			
		}
	
		List<IpAddressBean> ipAddressList = session.createSQLQuery(querryBuilder.toString()).addEntity(IpAddressBean.class).list();
		/*for(IpAddressBean ipAddress : ipAddressList){
			System.out.println("IpAddressBean List::"+ipAddress);
		}*/
		return ipAddressList;
		
	}
	
	
	public List<UserBean> userBeanList(UserBean userBean) {
		Session session = this.sessionFactory.getCurrentSession();
		
		StringBuilder querryBuilder=new StringBuilder();
		
		querryBuilder.append("SELECT * FROM user_table where login=:login and password=:password ");
		
		SQLQuery query
		 = session.createSQLQuery(querryBuilder.toString()).addEntity(UserBean.class);
		
		query.setParameter("login",userBean.getLogin());
		query.setParameter("password",userBean.getPassword());
		
		List<UserBean> userBeanList=query.list();
		
		return userBeanList;
		
	}
	
	

	public IpAddressBean getIpAddressById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		IpAddressBean ipAddress = (IpAddressBean) session.load(IpAddressBean.class, new Integer(id));
		System.out.println("IpAddressBean loaded successfully, IpAddressBean details="+ipAddress);
		return ipAddress;
		
	}

	public void removeIpAddress(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		IpAddressBean ipAddress = (IpAddressBean) session.load(IpAddressBean.class, new Integer(id));
		if(null != ipAddress){
			session.delete(ipAddress);
		}
		System.out.println("IpAddressBean deleted successfully, IpAddressBean details="+ipAddress);
		
	}

}
