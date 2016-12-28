package com.bte.pero.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.bte.pero.bean.User;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

public class UserDao {

	MongoClient aMgClient = new MongoClient("localhost", 27017);
	MongoDatabase dataBase = aMgClient.getDatabase("test2");

	public UserDao() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public User findUser(long id) {
		Document documentDetail = new Document();
		documentDetail.put("id", "1");
		FindIterable<Document> result = dataBase.getCollection("usuario").find(documentDetail);
		for (Document aDoc : result) {
			System.out.println("User:" + aDoc.toJson());
		}
		Document aDoc = result.first();
		User anUser = new User(new Long(aDoc.get("id").toString()), aDoc.get("name").toString(),
				aDoc.get("email").toString());
		return anUser;
	}

	/**
	 * 
	 * @return
	 */
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		FindIterable<Document> result = dataBase.getCollection("usuario").find();
		for (Document aDoc : result) {
			System.out.println("User:" + aDoc.toJson());
			User anUser = new User(new Long(aDoc.get("id").toString()), aDoc.get("name").toString(),
					aDoc.get("email").toString());
			users.add(anUser);
		}
		return users;
	}
}
