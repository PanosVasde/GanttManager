package parser;

import dom.LoaderFactory;
import java.util.*;
import dom.ILoader;


public class TopLevelFilter implements IFilter {
	
	private String fileName;
	private String delimiter;
	private List<String[]> taskList;
	private List<String[]> TopLevelTaskList = new ArrayList<String[]>();
	private String[] task;
	
	public TopLevelFilter(String fileName, String delimiter) {
		this.fileName = fileName;
		this.delimiter = delimiter;
	}
	
	public ILoader filter() {
		LoaderFactory loaderFactory = new LoaderFactory();
		ILoader loader = loaderFactory.createLoader(fileName, delimiter);
		loader.load();
		taskList = loader.getpData(); 
		for(int i=0; i<taskList.size(); i++) {
			task = taskList.get(i);
			if(task[2].equals("0")) {
				TopLevelTaskList.add(taskList.get(i));
			}
		}
		return loader;
	}

	public List<String[]> getTaskList() {
		return TopLevelTaskList;
	}
	
}
