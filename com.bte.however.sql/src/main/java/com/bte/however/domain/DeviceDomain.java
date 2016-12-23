package com.bte.however.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the hvr_devices database table.
 * 
 */
@Entity
@Table(name="hvr_devices")
@NamedQuery(name="DeviceDomain.findAll", query="SELECT d FROM DeviceDomain d")
public class DeviceDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_DEVICE")
	private int idDevice;

	@Column(name="LAST_LOGGIN")
	private Timestamp lastLoggin;

	private String location;

	private String name;

	//bi-directional many-to-one association to UserHasDeviceDomain
	@OneToMany(mappedBy="hvrDevice")
	private List<UserHasDeviceDomain> hasDevices;

	public DeviceDomain() {
	}

	public int getIdDevice() {
		return this.idDevice;
	}

	public void setIdDevice(int idDevice) {
		this.idDevice = idDevice;
	}

	public Timestamp getLastLoggin() {
		return this.lastLoggin;
	}

	public void setLastLoggin(Timestamp lastLoggin) {
		this.lastLoggin = lastLoggin;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserHasDeviceDomain> getHasDevices() {
		return this.hasDevices;
	}

	public void setHasDevices(List<UserHasDeviceDomain> hasDevices) {
		this.hasDevices = hasDevices;
	}

	public UserHasDeviceDomain addHasDevice(UserHasDeviceDomain hasDevice) {
		getHasDevices().add(hasDevice);
		hasDevice.setHvrDevice(this);

		return hasDevice;
	}

	public UserHasDeviceDomain removeHasDevice(UserHasDeviceDomain hasDevice) {
		getHasDevices().remove(hasDevice);
		hasDevice.setHvrDevice(null);

		return hasDevice;
	}

}