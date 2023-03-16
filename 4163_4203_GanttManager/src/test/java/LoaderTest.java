import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import dom.ILoader;
import dom.LoaderFactory;
import dom.Loader;

public class LoaderTest {

	private LoaderFactory loaderFactory;

	@Before
	public void setUp() throws Exception {
		loaderFactory = new LoaderFactory();
	}

	@Test
	public void testLoaderCreation() {
		ILoader loader = loaderFactory.createLoader("./src/test/resources/input/Eggs.tsv", "\t");
		assertNotNull(loader);
		assertTrue(loader instanceof Loader);
	}
}
