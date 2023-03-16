import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.IFilter;
import parser.FilterFactory;
import parser.IdFilter;
import parser.PrefixFilter;
import parser.TopLevelFilter;

public class FilterTest {
	
	private FilterFactory filterFactory;
	
	@Before
	public void setUp() throws Exception {
		filterFactory = new FilterFactory();
	}

	@Test
	public void testIdFilterCreation() {
		IFilter filter = filterFactory.createIdFilter(100, "./src/test/resources/input/Eggs.tsv", "\t");
		assertNotNull(filter);
		assertTrue(filter instanceof IdFilter);
	}
	
	@Test
	public void testPrefixFilterCreation() {
		IFilter filter = filterFactory.createPrefixFilter("Tr", "./src/test/resources/input/Eggs.tsv", "\t");
		assertNotNull(filter);
		assertTrue(filter instanceof PrefixFilter);
	}
	
	@Test
	public void testTopLevelFilterCreation() {
		IFilter filter = filterFactory.createTopLevelFilter("./src/test/resources/input/Eggs.tsv", "\t");
		assertNotNull(filter);
		assertTrue(filter instanceof TopLevelFilter);
	}
}