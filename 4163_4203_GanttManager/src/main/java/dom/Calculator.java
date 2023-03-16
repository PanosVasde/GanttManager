package dom;

import java.util.*;


public class Calculator {
	
	private List<String[]> newTaskList = new ArrayList<String[]>();
	private List<String[]> topLevelTaskSublist;
	private int cost, start, end;
	private String[] task;
	private List<Integer> topLevelTaskPos;
	private List<String[]> taskList;
	private List<Integer> startList;
	private List<Integer> endList;
	
	public Calculator(List<Integer> topLevelTaskPos, List<String[]> taskList) {
		this.topLevelTaskPos = topLevelTaskPos;
		this.taskList = taskList;
	}
	
	public List<String[]> calculateStartEndCost() {
		
		for(int i=0, j=1; i<topLevelTaskPos.size() & j<topLevelTaskPos.size(); i++, j++) {
			topLevelTaskSublist = taskList.subList(topLevelTaskPos.get(i), topLevelTaskPos.get(j));
			//topLevelTaskSublist.sort(Comparator.comparing(a -> a[3]));
			
			cost = 0;
			start = 0;
			end = 0;
			startList = new ArrayList<Integer>();
			endList = new ArrayList<Integer>();
			for(int k=0; k<topLevelTaskSublist.size(); k++) {
				task = topLevelTaskSublist.get(k);
				cost += Integer.parseInt(task[5]);
				if(Integer.parseInt(task[3])>0) {
					startList.add(Integer.parseInt(task[3]));
				}
				endList.add(Integer.parseInt(task[4]));
			}
			start = Collections.min(startList);
			end = Collections.max(endList);
			task = topLevelTaskSublist.get(0);
			task[3] = Integer.toString(start);
			task[4] = Integer.toString(end);
			task[5] = Integer.toString(cost);
			topLevelTaskSublist.set(0, task);
			newTaskList.addAll(topLevelTaskSublist);
		}
		
		
		return newTaskList;
	}
}
