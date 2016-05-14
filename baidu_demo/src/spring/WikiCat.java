package spring;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import de.tudarmstadt.ukp.wikipedia.api.Category;
import de.tudarmstadt.ukp.wikipedia.api.Wikipedia;


public class WikiCat {
	private Wikipedia wiki;
	private String path;
	private Set<String> conceptSet = new HashSet<String>();
	
	public void TranslateWikiCategory() throws Exception {
		//path = "TranslateCategory.txt";
		path = "TranslateTest.txt";
		String source = "Sports";
		Category root = wiki.getCategory(source);	
		//String result = BaiduTranslateDemo.translateToEn(source);
		/*if(result == null){
			System.out.println("翻译出错，参考百度错误代码和说明。");
			return;
		}
		System.out.println(source + "：" + result);*/
		getCategory(root);		
		System.out.println("conceptSet size "+conceptSet.size());
	}

	//获得每个子类别下的文章标题写入文本文件
	public void getCategory(Category category) throws Exception{
		String s = category.getTitle().toString();
		
		if(category.getChildren()!=null && !s.equalsIgnoreCase("Choreography")){
			String concept = "";
			String result = "";
			long id = 0;
			for (Category child : category.getChildren()) {
				id = child.__getId();
				concept = child.getTitle().toString();
				if(!conceptSet.contains(concept)){
					conceptSet.add(concept);
					//result = BaiduTranslateDemo.translateToEn(concept);
					String content = String.valueOf(id)+'\t'+concept;
					//String content = String.valueOf(id)+'\t'+concept+'\t'+result;
					System.out.println(content);
					save(path, content);
				}else{
					continue;
				}
				if(!concept.equalsIgnoreCase("Choreography")){
					getCategory(child);
				}
			}				
		}		
	}
	
	public void save(String path,String content) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path),true));	
		String txtStr = content+"\r\n";			
		writer.write(txtStr);		
		writer.close();
	}
	
	public Wikipedia getWiki() {
		return wiki;
	}

	public void setWiki(Wikipedia wiki) {
		this.wiki = wiki;
	}

	public Set<String> getConceptSet() {
		return conceptSet;
	}

	public void setConceptSet(Set<String> conceptSet) {
		this.conceptSet = conceptSet;
	}
}
