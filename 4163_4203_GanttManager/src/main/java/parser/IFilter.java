package parser;

import java.util.List;

import dom.ILoader;

public interface IFilter {
	public ILoader filter();
	public List<String[]> getTaskList();
}
