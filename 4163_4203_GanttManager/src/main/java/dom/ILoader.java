package dom;

import java.util.List;

public interface ILoader {
	public String[] getpColumnNames();
	public String getFileName();
	public List<String[]> getpData();
	public void load();
	
}
