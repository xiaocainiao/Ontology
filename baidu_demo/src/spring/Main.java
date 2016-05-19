package spring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.lang.builder.CompareToBuilder;

import de.tudarmstadt.ukp.wikipedia.api.Wikipedia;

/**
 * 直接运行main方法即可输出翻译结果
 */
public class Main {
	private static Set<String> conceptSet = new HashSet<String>();
	//private static Map<Integer, String> conc = new HashMap<Integer, String>();
	//private static List<String> conl = new ArrayList<String>();
	//private static Map<String, Integer> conc = new HashMap<String, Integer>();
	public static void main(String[] args) throws Exception {
		long startTime = System.currentTimeMillis();
		
		ExistedConcept ec = new ExistedConcept();
	    ec.readConcept();
	    conceptSet = ec.getConcept();
		System.out.println(conceptSet.size());
		
	    /*
		Collections.sort(conl);
		for(int i = 0;i<conl.size();i++){
			System.out.println(conl.get(i));
		}*/
		//Wikipedia处理对象
		Wikipedia wiki = new Connect().connDatabase();	
	
		WikiCat wc = new WikiCat();
		/*for(String str:conceptSet){
			wc.save("Translate.txt",str);
		}*/
		wc.setConceptSet(conceptSet);
		wc.setWiki(wiki);
		wc.TranslateWikiCategory();
		
		long endTime = System.currentTimeMillis();
		long t = endTime-startTime;
		System.out.println("程序运行："+(double)t/1000+"s");
	}
}
