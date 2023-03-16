package dom;

import java.util.*;
import java.io.*; 


public class Loader implements ILoader {
	private static String[] COLUMN_NAMES = {"TaskId" , "TaskText", "MamaId","Start" , "End" , "Cost" };
	private List<String[]> pData;
	private String[] pColumnNames;
	private String delimiter;
	private String fileName;
	
	
	public Loader(String fileName, String delimiter) {
		this.fileName = fileName;
		this.delimiter = delimiter;
		pColumnNames = COLUMN_NAMES;
	}

	public String[] getpColumnNames() {
		return pColumnNames;
	}

	public String getFileName() {
		return fileName;
	}

	public List<String[]> getpData() {
		return pData;
	}

	public void load() {
		List<String[]> taskList = new ArrayList<String[]>();
		Scanner sc;
		String[] dumbArray; 
		
		try {
			sc = new Scanner(new File(fileName));
			
			while(sc.hasNextLine()) {
				String[] taskArray = {"0", "0", "0", "0", "0", "0"};
				String line = sc.nextLine();
				dumbArray = line.split(delimiter);
				for(int i=0; i<dumbArray.length; i++) {
					taskArray[i] = dumbArray[i];
				}
				taskList.add(taskArray);
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Classifier sortedTaskList = new Classifier(taskList);
		sortedTaskList.arraySortByTaskid();
		sortedTaskList.findTopLevelPos();
		pData = sortedTaskList.getTaskList();
	}
	
	
	
}
