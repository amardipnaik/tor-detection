package com.project.tor.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.tor.bean.IpAddressBean;
import com.project.tor.bean.UserBean;
import com.project.tor.dao.IIpAddressDao;

@Service
public class IpAddressServiceImpl implements IIpAddressService{
	
	private  IIpAddressDao iIpAddressDao;


	

	public IIpAddressDao getiIpAddressDao() {
		return iIpAddressDao;
	}

	public void setiIpAddressDao(IIpAddressDao iIpAddressDao) {
		this.iIpAddressDao = iIpAddressDao;
	}

	@Transactional
	public void addIpAddress(IpAddressBean ipAddress) {
		iIpAddressDao.addIpAddress(ipAddress);
		
	}

	@Transactional
	public void updateIpAddress(IpAddressBean ipAddress) {
		 iIpAddressDao.updateIpAddress(ipAddress);
		
	}

	@Transactional
	public List<IpAddressBean> listIpAddress(String isTor) {
		// TODO Auto-generated method stub
		return iIpAddressDao.listIpAddress(isTor);
	}

	@Transactional
	public List<UserBean> userBeanList(UserBean userBean)
	{
		return iIpAddressDao.userBeanList(userBean);
	}
	
	@Transactional
	public IpAddressBean getIpAddressById(int id) {
		// TODO Auto-generated method stub
		return iIpAddressDao.getIpAddressById(id);
	}

	@Transactional
	public void removeIpAddress(int id) {
		// TODO Auto-generated method stub
		
	}

}
