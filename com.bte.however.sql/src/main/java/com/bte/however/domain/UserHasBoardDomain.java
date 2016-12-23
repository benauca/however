package com.bte.however.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the _user_has_board database table.
 * 
 */
@Entity
@Table(name="_user_has_board")
@NamedQuery(name="UserHasBoardDomain.findAll", query="SELECT u FROM UserHasBoardDomain u")
public class UserHasBoardDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="HASH_BOARD")
	private String hashBoard;

	@Column(name="NAME_BOARD")
	private String nameBoard;

	//bi-directional many-to-one association to UserDomain
	@ManyToOne
	@JoinColumn(name="id_user")
	private UserDomain hvrUser;

	//bi-directional many-to-one association to ServerDomain
	@ManyToOne
	@JoinColumn(name="ID_SERVER")
	private ServerDomain hvrServer;

	public UserHasBoardDomain() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHashBoard() {
		return this.hashBoard;
	}

	public void setHashBoard(String hashBoard) {
		this.hashBoard = hashBoard;
	}

	public String getNameBoard() {
		return this.nameBoard;
	}

	public void setNameBoard(String nameBoard) {
		this.nameBoard = nameBoard;
	}

	public UserDomain getHvrUser() {
		return this.hvrUser;
	}

	public void setHvrUser(UserDomain hvrUser) {
		this.hvrUser = hvrUser;
	}

	public ServerDomain getHvrServer() {
		return this.hvrServer;
	}

	public void setHvrServer(ServerDomain hvrServer) {
		this.hvrServer = hvrServer;
	}

}