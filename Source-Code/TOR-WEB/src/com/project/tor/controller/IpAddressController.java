package com.project.tor.controller;


import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.tor.bean.IpAddressBean;
import com.project.tor.bean.UserBean;
import com.project.tor.service.IIpAddressService;

@RestController
public class IpAddressController {

    private IIpAddressService iIpAddressService;
    
    
	
	@Autowired(required=true)
	@Qualifier(value="iIpAddressService")
	public void setPersonService(IIpAddressService ipAddressService){
		this.iIpAddressService = ipAddressService;
	}
	
	
	
	 @RequestMapping(value="/login", method = RequestMethod.POST)
	    public ModelAndView loginMain(HttpServletRequest req, HttpServletResponse res)
	    {
	    	
	    	HttpSession session=req.getSession();
	    	String login=req.getParameter("login");
	    	String password=req.getParameter("password");
	    	
	    	System.out.println("Login ::"+login);
	    	System.out.println("password ::"+password);
	    	
	    	UserBean userBean=new UserBean();
	    	userBean.setLogin(login);
	    	userBean.setPassword(password);
	    	
	    	List<UserBean> userBeanList=iIpAddressService.userBeanList(userBean);
	    	String profile=null;
	    	
	    	if(!userBeanList.isEmpty())
	    	{
	    		UserBean user=new UserBean();
	    		user=userBeanList.get(0);
	    		profile=user.getProfile();
	    	}
	    	
	    	session.setAttribute("profile",profile );
	    	System.out.println("userBeanList ::"+userBeanList);
	    	
	    	session.setAttribute("loggedInUser", req.getAttribute("uname"));
	    	return new ModelAndView("login");
		
	    }
	
	
	
	 @RequestMapping(value="checkTor", method=RequestMethod.POST)
	    public Map<String,String> torCheck(@RequestBody IpAddressBean ipAddress) throws Exception
	    {
		 
		 try {
				SSLContext sc = SSLContext.getInstance("TLS");
				sc.init(null, new TrustManager[] { new TrustAllX509TrustManager() }, new java.security.SecureRandom());
				HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
				HttpsURLConnection.setDefaultHostnameVerifier( new HostnameVerifier(){
				    public boolean verify(String string,SSLSession ssls) {
				        return true;
				    }
				});
			} catch (KeyManagementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 String status=null;
		 Map<String,String> resultMap=new HashMap<String,String>();
		 
		 System.out.println("ipAddress is : "+ipAddress);
		 String ipAddressCheck=ipAddress.getIpAddress();
		 
		 System.out.println("ipAddressCheck is : "+ipAddressCheck);
		 
		 
		 
		 try {
			ExitNodeCheck exitNodeCheck=new ExitNodeCheck();
			 boolean isTorExitNode2 = exitNodeCheck.isExitNodeInOnlineList(ipAddressCheck);
			 
			 if(isTorExitNode2==true)
			 {
				 status="ALERT!! IP Address Relay On TOR Network";
			 }
			 else
			 {
				 status="Found A Normal IP Address ";
				 
			 }
			 
			 System.out.println(" Is This a TOR Exit Node isTorExitNode2 :: "+isTorExitNode2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			status="Error!! You Have Enter a Wrong IP Address";
			e.printStackTrace();
		}

		 resultMap.put("result", status);
		 return resultMap;
		
	    }
	 
	 
	 @RequestMapping(value="scanAll", method=RequestMethod.GET)
	    public Map<String,String> scanAllIps() throws Exception
	    {
		 
		 try {
				SSLContext sc = SSLContext.getInstance("TLS");
				sc.init(null, new TrustManager[] { new TrustAllX509TrustManager() }, new java.security.SecureRandom());
				HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
				HttpsURLConnection.setDefaultHostnameVerifier( new HostnameVerifier(){
				    public boolean verify(String string,SSLSession ssls) {
				        return true;
				    }
				});
			} catch (KeyManagementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 String status=null;
		 Map<String,String> resultMap=new HashMap<String,String>();
			 
		
			 
			 List<IpAddressBean> ipaddressList=new ArrayList<>();
				ipaddressList=this.iIpAddressService.listIpAddress("no");
				
				for(IpAddressBean ipAddress:ipaddressList)
				{
					String ipCheck=ipAddress.getIpAddress();
					
					 try {	
			 
			ExitNodeCheck exitNodeCheck=new ExitNodeCheck();
			 boolean isTorExitNode2 = exitNodeCheck.isExitNodeInOnlineList(ipCheck);
			 
			 if(isTorExitNode2==true)
			 {
				 status="TOR IP";
			 }
			 else
			 {
				 status="Normal IP";
				 
			 }
			 
			 System.out.println(" Is This a TOR Exit Node isTorExitNode2 :: "+isTorExitNode2);
		} catch (Exception e) {
			
			 status="Wrong IP";
			e.printStackTrace();
		}
					 resultMap.put(ipCheck, status);
					 
				}

		System.out.println(resultMap);
		 return resultMap;
		
	    }
	 
	 
	 
	 
	
	@RequestMapping(value = "viewIp", method = RequestMethod.POST)
	public List<IpAddressBean> listIpAddress(@RequestBody IpAddressBean ipAddress) {
		System.out.println("In Controller ipAddress "+ipAddress);
		String isTor=ipAddress.getIsTor();
		List<IpAddressBean> ipaddressList=new ArrayList<>();
		ipaddressList=this.iIpAddressService.listIpAddress(isTor);
		
		return ipaddressList;
	}
	
	//For add and update person both
	@RequestMapping(value= "addTor", method = RequestMethod.POST)
	public Map<String,String> addTor(@RequestBody IpAddressBean ipAddress){
		
		 String status=null;
		 System.out.println("ipAddress"+ipAddress);
		 Map<String,String> resultMap=new HashMap<String,String>();
		
			try {
				this.iIpAddressService.addIpAddress(ipAddress);
				status="Record Added Successfully!!";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				status="Record Id Not Added !!! Check DB Connection";
			}
		
			resultMap.put("result",status);
		return resultMap;
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.iIpAddressService.removeIpAddress(id);
        return "redirect:/ipAddress";
    }
 
	
	@RequestMapping(value = "blockTor", method = RequestMethod.POST)
    public String removePerson(@RequestBody IpAddressBean ipAddress){
		String result=null;
        try {
			this.iIpAddressService.updateIpAddress(ipAddress);
			result="success";
		} catch (Exception e) {
			result="failure";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	
  /*  @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("ipAddress", this.iIpAddressService.getIpAddressById(id));
        model.addAttribute("listIpAddress", this.iIpAddressService.listIpAddress());
        return "ipAddress";
    }*/
	
	
}
