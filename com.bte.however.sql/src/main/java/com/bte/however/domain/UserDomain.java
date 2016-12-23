package com.bte.however.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * The persistent class for the hvr_user database table.
 * 
 */
@Entity
@Table(name = "hvr_user")
@NamedQuery(name = "UserDomain.findAll", query = "SELECT u FROM UserDomain u")
public class UserDomain implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USER")
	private int idUser;

	/**
	 * Tipo de Autenticación 0- Password 1- Google 2- Facebook 3- LDAP
	 */
	@Column(name = "AUTH_TYPE")
	private int authType;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "FULL_NAME")
	private String fullName;

	/**
	 * Login: Por defecto será el nombre asociado sin el dominio
	 */
	@Column(name = "LOGIN")
	private String login;

	/**
	 * Indicador de si el usuario es Administrador o no.
	 */
	@Column(name = "IS_ADMIN")
	private boolean isAdmin;

	// bi-directional many-to-one association to UserHasConfigDomain
	@OneToMany(mappedBy = "hvrUser")
	private List<UserHasConfigDomain> hasConfigs;

	// bi-directional many-to-one association to UserHasDeviceDomain
	@OneToMany(mappedBy = "hvrUser")
	private List<UserHasDeviceDomain> hasDevices;

	// bi-directional many-to-one association to UserHasBoardDomain
	@OneToMany(mappedBy = "hvrUser")
	private List<UserHasBoardDomain> userHasBoards;

	public UserDomain() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getAuthType() {
		return this.authType;
	}

	public void setAuthType(int authType) {
		this.authType = authType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public List<UserHasConfigDomain> getHasConfigs() {
		return this.hasConfigs;
	}

	public void setHasConfigs(List<UserHasConfigDomain> hasConfigs) {
		this.hasConfigs = hasConfigs;
	}

	public UserHasConfigDomain addHasConfig(UserHasConfigDomain hasConfig) {
		getHasConfigs().add(hasConfig);
		hasConfig.setHvrUser(this);

		return hasConfig;
	}

	public UserHasConfigDomain removeHasConfig(UserHasConfigDomain hasConfig) {
		getHasConfigs().remove(hasConfig);
		hasConfig.setHvrUser(null);

		return hasConfig;
	}

	public List<UserHasDeviceDomain> getHasDevices() {
		return this.hasDevices;
	}

	public void setHasDevices(List<UserHasDeviceDomain> hasDevices) {
		this.hasDevices = hasDevices;
	}

	public UserHasDeviceDomain addHasDevice(UserHasDeviceDomain hasDevice) {
		getHasDevices().add(hasDevice);
		hasDevice.setHvrUser(this);

		return hasDevice;
	}

	public UserHasDeviceDomain removeHasDevice(UserHasDeviceDomain hasDevice) {
		getHasDevices().remove(hasDevice);
		hasDevice.setHvrUser(null);

		return hasDevice;
	}

	public List<UserHasBoardDomain> getUserHasBoards() {
		return this.userHasBoards;
	}

	public void setUserHasBoards(List<UserHasBoardDomain> userHasBoards) {
		this.userHasBoards = userHasBoards;
	}

	public UserHasBoardDomain addUserHasBoard(UserHasBoardDomain userHasBoard) {
		getUserHasBoards().add(userHasBoard);
		userHasBoard.setHvrUser(this);

		return userHasBoard;
	}

	public UserHasBoardDomain removeUserHasBoard(UserHasBoardDomain userHasBoard) {
		getUserHasBoards().remove(userHasBoard);
		userHasBoard.setHvrUser(null);

		return userHasBoard;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("idUser", idUser).add("authType", authType)
				.add("password", "informada").add("email", email).add("fullName", fullName).add("login", login)
				.add("isAdmin", isAdmin).toString();
	}

}