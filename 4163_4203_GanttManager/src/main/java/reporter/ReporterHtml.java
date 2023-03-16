package reporter;

import java.util.*;
import dom.ILoader;
import dom.LoaderFactory;


//This class is NOT completed

public class ReporterHtml implements IReporter {
	private String path;
	private String fileName;
	private String delimiter;
	private List<String[]> taskList;
	private int taskProcessed = -1;
	private String columns;
	
	public ReporterHtml(String path, String fileName, String delimiter) {
		this.path = path;
		this.fileName = fileName;
		this.delimiter = delimiter;
	}
	
	public void loadCurrentList() {
		LoaderFactory loaderFactory = new LoaderFactory();
		ILoader loader = loaderFactory.createLoader(fileName, delimiter);
		loader.load();
		taskList = loader.getpData();
		columns = String.join(" ", loader.getpColumnNames());
	}
	
	public int getTaskProcessed() {
		return taskProcessed;
	}
	
	public void createReport() {
		
	}
}
