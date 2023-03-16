package dom;


public class LoaderFactory {
	public ILoader createLoader(String fileName, String delimiter) {
		return new Loader(fileName, delimiter);
	}
}