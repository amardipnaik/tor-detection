package com.project.tor.service;

import java.util.List;

import com.project.tor.bean.IpAddressBean;
import com.project.tor.bean.UserBean;

public interface IIpAddressService {
	
	
	public void addIpAddress(IpAddressBean ipAddress);
	public void updateIpAddress(IpAddressBean ipAddress);
	public List<IpAddressBean> listIpAddress(String isTor);
	public IpAddressBean getIpAddressById(int id);
	public void removeIpAddress(int id);
	public List<UserBean> userBeanList(UserBean userBean);

}
