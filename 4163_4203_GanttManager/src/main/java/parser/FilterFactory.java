package parser;


public class FilterFactory {
	public IFilter createPrefixFilter(String prefix, String fileName, String delimiter) {
		return new PrefixFilter(prefix, fileName, delimiter);
	}
	
	public IFilter createIdFilter(int id, String fileName, String delimiter) {
		return new IdFilter(id, fileName, delimiter);
	} 
	
	public IFilter createTopLevelFilter(String fileName, String delimiter) {
		return new TopLevelFilter(fileName, delimiter);
	}
}
