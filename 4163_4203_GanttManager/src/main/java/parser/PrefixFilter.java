package parser;

import java.util.*;
import dom.ILoader;
import dom.LoaderFactory;


public class PrefixFilter implements IFilter {
	private String fileName;
	private String delimiter;
	private String prefix;
	private List<String[]> taskList;
	private List<String[]> prefixTaskList = new ArrayList<String[]>();
	private String[] task;
	
	
	public PrefixFilter(String prefix, String fileName, String delimiter) {
		this.fileName = fileName;
		this.delimiter = delimiter;
		this.prefix = prefix;
	}
	
	public ILoader filter() {
		LoaderFactory loaderFactory = new LoaderFactory();
		ILoader loader = loaderFactory.createLoader(fileName, delimiter);
		loader.load();
		taskList = loader.getpData(); 
		for(int i=0; i<taskList.size(); i++) {
			task = taskList.get(i);
			if(task[1].startsWith(prefix)) {
				prefixTaskList.add(taskList.get(i));
			}
		}
		return loader;
	}

	public List<String[]> getTaskList() {
		return prefixTaskList;
	}
}
