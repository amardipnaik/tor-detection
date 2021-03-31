package com.project.tor.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ip_Address")
public class IpAddressBean {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getIsTor() {
		return isTor;
	}

	public void setIsTor(String isTor) {
		this.isTor = isTor;
	}

/*	@Column(name = "created_by")
    private Long createdBy;

	@Column(name = "modified_by")
    private Long modifiedBy;

	@Column(name = "created_on")
    private Timestamp createdOn;

	@Column(name = "modified_on")
    private Timestamp modifiedOn;

	@Column(name = "delete_flag")
    private String deleteFlag;*/
	
	@Column(name = "ip_address")
	private String ipAddress;
	


	@Override
	public String toString() {
		return "IpAddressBean [id=" + id + ", ipAddress=" + ipAddress + ", port=" + port + ", isTor=" + isTor
				+ ", hostname=" + hostname + ", remarks=" + remarks + "]";
	}

	@Column(name = "port")
	private String port;
	
	@Column(name = "is_tor")
	private String isTor;
	
	@Column(name = "hostname")
	private String hostname;
	
	@Column(name = "remarks")
	private String remarks;

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	
}
