package parser;

import java.util.*;
import dom.ILoader;
import dom.LoaderFactory;

public class IdFilter implements IFilter {
	
	private String fileName;
	private String delimiter;
	private int id;
	private List<String[]> taskList;
	private List<String[]> IdTaskList = new ArrayList<String[]>();
	private String[] task;
	
	
	public IdFilter(int id, String fileName, String delimiter) {
		this.fileName = fileName;
		this.delimiter = delimiter;
		this.id = id;
	}
	
	public ILoader filter() {
		LoaderFactory loaderFactory = new LoaderFactory();
		ILoader loader = loaderFactory.createLoader(fileName, delimiter);
		loader.load();
		taskList = loader.getpData(); 
		for(int i=0; i<taskList.size(); i++) {
			task = taskList.get(i);
			if(task[0].equals(Integer.toString(id))) {
				IdTaskList.add(taskList.get(i));
			}
		}
		return loader;
	}

	public List<String[]> getTaskList() {
		return IdTaskList;
	}
	
	
}