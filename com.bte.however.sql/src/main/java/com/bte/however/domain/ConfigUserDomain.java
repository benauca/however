package com.bte.however.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hvr_config_user database table.
 * 
 */
@Entity
@Table(name="hvr_config_user")
@NamedQuery(name="ConfigUserDomain.findAll", query="SELECT c FROM ConfigUserDomain c")
public class ConfigUserDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CONFIG")
	private int idConfig;

	@Column(name="FIRST_DAY")
	private int firstDay;

	@Column(name="FORMAT_TIME")
	private int formatTime;

	//bi-directional many-to-one association to UserHasConfigDomain
	@OneToMany(mappedBy="hvrConfigUser")
	private List<UserHasConfigDomain> hasConfigs;

	public ConfigUserDomain() {
	}

	public int getIdConfig() {
		return this.idConfig;
	}

	public void setIdConfig(int idConfig) {
		this.idConfig = idConfig;
	}

	public int getFirstDay() {
		return this.firstDay;
	}

	public void setFirstDay(int firstDay) {
		this.firstDay = firstDay;
	}

	public int getFormatTime() {
		return this.formatTime;
	}

	public void setFormatTime(int formatTime) {
		this.formatTime = formatTime;
	}

	public List<UserHasConfigDomain> getHasConfigs() {
		return this.hasConfigs;
	}

	public void setHasConfigs(List<UserHasConfigDomain> hasConfigs) {
		this.hasConfigs = hasConfigs;
	}

	public UserHasConfigDomain addHasConfig(UserHasConfigDomain hasConfig) {
		getHasConfigs().add(hasConfig);
		hasConfig.setHvrConfigUser(this);

		return hasConfig;
	}

	public UserHasConfigDomain removeHasConfig(UserHasConfigDomain hasConfig) {
		getHasConfigs().remove(hasConfig);
		hasConfig.setHvrConfigUser(null);

		return hasConfig;
	}

}