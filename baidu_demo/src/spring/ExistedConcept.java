package spring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ExistedConcept {
	private Set<String> concept = new HashSet<String>();
	private static Map<Integer, String> conc = new HashMap<Integer, String>();
	private static List<String> conl = new ArrayList<String>();
	//private static Map<String, Integer> conc = new HashMap<String, Integer>();
	public void readConcept() throws IOException{
		File file = new File("TranslateCategory.txt");
		if(file.isFile() && file.exists()){
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"UTF-8");
			BufferedReader br = new BufferedReader(reader);
			String line = null;
			//int id = 1;
			while((line = br.readLine()) != null){
				String[] seg = line.split("\t");
				concept.add(seg[1]);
				//conc.put(id, line);
				//conl.add(line);
				//id++;
			}
			br.close();
		}
	}
	
	public boolean ifExisted(String c){
		if(concept.contains(c))
			return true;
		return false;
	}
	
	public Set<String> getConcept(){
		return concept;
	}
	
	public Map<Integer, String> getConc(){
		return conc;
	}
	
	public List<String> getConcL(){
		return conl;
	}
}
