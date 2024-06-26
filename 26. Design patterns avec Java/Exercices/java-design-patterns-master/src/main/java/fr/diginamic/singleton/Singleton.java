package fr.diginamic.singleton;

import java.util.HashMap;
import java.util.ResourceBundle;

public class Singleton {
	/** Constructeur privé */
	private HashMap<String, String> config = new HashMap<>();
	
	private Singleton()
	{
		init();
	}
	private void init() {
		ResourceBundle bundle = ResourceBundle.getBundle("configuration");
		bundle.getString("db.url");
		
		for(String key : bundle.keySet()) {
			config.put(key, bundle.getString(key));
		}
	}
	/** Holder */
	private static class SingletonHolder
	{
		
	/** Instance unique non préinitialisée */
		private final static Singleton instance = new Singleton();
	
	}
	/** Point d'accès pour l'instance unique du singleton */
	public static Singleton getInstance()
	{
	return SingletonHolder.instance;
	}
	
	public String getValue(String key) {
		return config.get(key);
	}
}
