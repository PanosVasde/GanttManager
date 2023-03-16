package reporter;

import java.util.*;
import java.io.*;
import dom.ILoader;
import dom.LoaderFactory;


public class ReporterText implements IReporter {
	private String path;
	private String fileName;
	private String delimiter;
	private List<String[]> taskList;
	private int taskProcessed = -1;
	private String columns;
	
	public ReporterText(String path, String fileName, String delimiter) {
		this.path = path;
		this.fileName = fileName;
		this.delimiter = delimiter;
	}
	
	public void loadCurrentList() {
		LoaderFactory loaderFactory = new LoaderFactory();
		ILoader loader = loaderFactory.createLoader(fileName, delimiter);
		loader.load();
		taskList = loader.getpData(); 
		columns = String.join("	", loader.getpColumnNames());
	}
	
	public int getTaskProcessed() {
		return taskProcessed;
	}
	
	public void createReport() {
		try {
			File f = new File(path);
			f.delete();
			BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
			writer.append(columns+"\n");
			for(int i=0; i<taskList.size(); i++) {
				writer.append(String.join("	", taskList.get(i)) + "\n");
			}
			taskProcessed = taskList.size();
			writer.close();
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
	} 
}
