package com.bte.however.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hvr_server database table.
 * 
 */
@Entity
@Table(name="hvr_server")
@NamedQuery(name="ServerDomain.findAll", query="SELECT s FROM ServerDomain s")
public class ServerDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_SERVER")
	private int idServer;

	private String hostname;

	@Column(name="MONGO_DATABASE")
	private String mongoDatabase;

	//bi-directional many-to-one association to UserHasBoardDomain
	@OneToMany(mappedBy="hvrServer")
	private List<UserHasBoardDomain> userHasBoards;

	public ServerDomain() {
	}

	public int getIdServer() {
		return this.idServer;
	}

	public void setIdServer(int idServer) {
		this.idServer = idServer;
	}

	public String getHostname() {
		return this.hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getMongoDatabase() {
		return this.mongoDatabase;
	}

	public void setMongoDatabase(String mongoDatabase) {
		this.mongoDatabase = mongoDatabase;
	}

	public List<UserHasBoardDomain> getUserHasBoards() {
		return this.userHasBoards;
	}

	public void setUserHasBoards(List<UserHasBoardDomain> userHasBoards) {
		this.userHasBoards = userHasBoards;
	}

	public UserHasBoardDomain addUserHasBoard(UserHasBoardDomain userHasBoard) {
		getUserHasBoards().add(userHasBoard);
		userHasBoard.setHvrServer(this);

		return userHasBoard;
	}

	public UserHasBoardDomain removeUserHasBoard(UserHasBoardDomain userHasBoard) {
		getUserHasBoards().remove(userHasBoard);
		userHasBoard.setHvrServer(null);

		return userHasBoard;
	}

}