package spring;

import de.tudarmstadt.ukp.wikipedia.api.DatabaseConfiguration;
import de.tudarmstadt.ukp.wikipedia.api.Wikipedia;
import de.tudarmstadt.ukp.wikipedia.api.WikiConstants.Language;
import de.tudarmstadt.ukp.wikipedia.api.exception.WikiInitializationException;

public class Connect {
	//连接数据库，返回Wikipedia处理对象
	public Wikipedia connDatabase() throws WikiInitializationException{
		DatabaseConfiguration dbConfig = new DatabaseConfiguration();
		
		dbConfig.setHost("localhost");
		dbConfig.setDatabase("enwiki");
		dbConfig.setUser("root");
		dbConfig.setPassword("123");
		dbConfig.setLanguage(Language.english);
		
		// 创建Wikipedia处理对象
		Wikipedia wiki = new Wikipedia(dbConfig);
		
		return wiki;
	}
}
