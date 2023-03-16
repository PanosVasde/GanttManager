package reporter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import dom.ILoader;
import dom.LoaderFactory;


public class ReporterMarkdown implements IReporter {
	private String path;
	private String fileName;
	private String delimiter;
	private List<String[]> taskList;
	private int taskProcessed = -1;
	private String columns;
	private String dumbStr;

	
	public ReporterMarkdown(String path, String fileName, String delimiter) {
		this.path = path;
		this.fileName = fileName;
		this.delimiter = delimiter;
	}
	
	public void loadCurrentList() {
		LoaderFactory loaderFactory = new LoaderFactory();
		ILoader loader = loaderFactory.createLoader(fileName, delimiter);
		loader.load();
		taskList = loader.getpData();
		columns = String.join("*  *", loader.getpColumnNames());
	}
	
	public int getTaskProcessed() {
		return taskProcessed;
	}
	
	public void createReport() {
		try {
			File f = new File(path);
			f.delete();
			BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
			writer.append("*"+columns+"*"+"\n");
			for(int i=0; i<taskList.size(); i++) {
				if(taskList.get(i)[2].equals("0")) {
					dumbStr = Arrays.toString(taskList.get(i));
					writer.append(dumbStr.replace(",", "").replace("[", "**").replace("]", "**") + "\n");
				}
				else {
					dumbStr = Arrays.toString(taskList.get(i));
					writer.append(dumbStr.replace(",", "").replace("[", "").replace("]", "") + "\n");
				}
			}
			taskProcessed = taskList.size();
			writer.close();
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
