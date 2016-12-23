package com.bte.however.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the _has_config database table.
 * 
 */
@Entity
@Table(name="_has_config")
@NamedQuery(name="UserHasConfigDomain.findAll", query="SELECT u FROM UserHasConfigDomain u")
public class UserHasConfigDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to UserDomain
	@ManyToOne
	@JoinColumn(name="id_user")
	private UserDomain hvrUser;

	//bi-directional many-to-one association to ConfigUserDomain
	@ManyToOne
	@JoinColumn(name="id_config")
	private ConfigUserDomain hvrConfigUser;

	public UserHasConfigDomain() {
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

	public ConfigUserDomain getHvrConfigUser() {
		return this.hvrConfigUser;
	}

	public void setHvrConfigUser(ConfigUserDomain hvrConfigUser) {
		this.hvrConfigUser = hvrConfigUser;
	}

}