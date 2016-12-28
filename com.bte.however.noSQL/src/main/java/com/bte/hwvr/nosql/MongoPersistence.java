package com.bte.hwvr.nosql;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MongoPersistence {

	private Map<String, EntityManagerFactory> entityManagers = Collections
			.synchronizedMap(new HashMap<String, EntityManagerFactory>());

	public EntityManager getEntityManager(String databaseSchema) {
		EntityManagerFactory emf = entityManagers.get(databaseSchema.toUpperCase());
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("com.bte.however.noSQL", createMap(databaseSchema));
			entityManagers.put(databaseSchema, emf);
		}
		return emf.createEntityManager();
	}

	public static Map<String, String> createMap(String databaseSchema) {
		Map<String, String> map = new HashMap();
		map.put("eclipselink.nosql.property.mongo.db", databaseSchema);
		return map;
	}
}
