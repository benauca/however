package com.bte.however.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the _has_device database table.
 * 
 */
@Entity
@Table(name="_has_device")
@NamedQuery(name="UserHasDeviceDomain.findAll", query="SELECT u FROM UserHasDeviceDomain u")
public class UserHasDeviceDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to UserDomain
	@ManyToOne
	@JoinColumn(name="id_user")
	private UserDomain hvrUser;

	//bi-directional many-to-one association to DeviceDomain
	@ManyToOne
	@JoinColumn(name="id_device")
	private DeviceDomain hvrDevice;

	public UserHasDeviceDomain() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserDomain getHvrUser() {
		return this.hvrUser;
	}

	public void setHvrUser(UserDomain hvrUser) {
		this.hvrUser = hvrUser;
	}

	public DeviceDomain getHvrDevice() {
		return this.hvrDevice;
	}

	public void setHvrDevice(DeviceDomain hvrDevice) {
		this.hvrDevice = hvrDevice;
	}

}