package com.bte.pero.mongo;

import static org.junit.Assert.*;

import org.bson.BSON;
import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.config.YamlProcessor.DocumentMatcher;

import com.mongodb.BasicDBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.client.MongoDatabase;

public class MongoDBTest {

	Mongo aMongo = new Mongo();

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDataBase() {
		System.out.println(aMongo.getDatabaseNames());
		assertNotNull(aMongo.getDatabaseNames());
	}

	@Test
	public void testGetDataBaseWithMongoClient() {

		MongoClient aClient = new MongoClient("localhost", 27017);
		ListDatabasesIterable<Document> databases = aClient.listDatabases();
		for (Document aDatabase : databases) {
			System.out.println(aDatabase.toJson());
		}
	}

	@Test
	public void testCreateCollections() {
		MongoClient aMgClient = new MongoClient("localhost", 27017);
		/**
		 * En caso de no existir la base de datos el sistema la crea.
		 */
		MongoDatabase dataBase = aMgClient.getDatabase("test2");
		dataBase.createCollection("usuario");
	}

	@Test
	public void testCreateUser() {
		MongoClient aMgClient = new MongoClient("localhost", 27017);
		/**
		 * En caso de no existir la base de datos el sistema la crea.
		 */
		MongoDatabase dataBase = aMgClient.getDatabase("test2");
		Document documentDetail = new Document();
		documentDetail.put("id", "2");
		documentDetail.put("name", "Jesús Benavente");
		documentDetail.put("email", "jbe@gmail.com");

		dataBase.getCollection("usuario").insertOne(documentDetail);

	}

	@Test
	public void testGetUser() {
		MongoClient aMgClient = new MongoClient("localhost", 27017);
		/**
		 * En caso de no existir la base de datos el sistema la crea.
		 */
		MongoDatabase dataBase = aMgClient.getDatabase("test2");
		Document documentDetail = new Document();
		documentDetail.put("name", "Jonh Doe");
		FindIterable<Document> result = dataBase.getCollection("usuario").find(documentDetail);
		for (Document aUser : result) {
			System.out.println("User:" + aUser.toJson());
		}
	}
	
	@Test
	public void testDropUser() {
		MongoClient aMgClient = new MongoClient("localhost", 27017);
		/**
		 * En caso de no existir la base de datos el sistema la crea.
		 */
		MongoDatabase dataBase = aMgClient.getDatabase("test2");
		Document documentDetail = new Document();
		documentDetail.put("name", "Jonh Doe2");
		FindIterable<Document> result = dataBase.getCollection("usuario").find(documentDetail);
		for (Document aUser : result) {
			dataBase.getCollection("usuario").drop();
		}
	}
}
