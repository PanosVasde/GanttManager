package dom;

import java.util.*;

public class Classifier {
	
	private List<String[]> taskList;
	private List<Integer> topLevelTaskPos = new ArrayList<Integer>();
	private String[] task;
	

	
	public Classifier(List<String[]> taskList) {
		this.taskList = taskList;
	}
	
	public List<String[]> getTaskList() {
		return taskList;
	}
		
	public void arraySortByTaskid() {
		Collections.sort(taskList, new Comparator<String[]>() {
			public int compare(String[] strings, String[] otherStrings) {
				return strings[0].compareTo(otherStrings[0]);
			}
		});
	}
	
	public void findTopLevelPos() {
		for(int i=0; i<taskList.size(); i++) {
			task = taskList.get(i);
			if(task[2].equals("0")) {
				topLevelTaskPos.add(i);
			}
		}
		topLevelTaskPos.add(taskList.size());
		
		Calculator cal = new Calculator(topLevelTaskPos, taskList);
		taskList = cal.calculateStartEndCost();
	}
}