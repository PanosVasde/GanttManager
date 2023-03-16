import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import reporter.ReporterFactory;
import reporter.IReporter;
import reporter.ReporterMarkdown;
import reporter.ReporterText;
import backend.ReportType;

public class ReporterTest {
		
	private ReporterFactory reporterFactory;
	
	@Before
	public void setUp() throws Exception {
		reporterFactory = new ReporterFactory();
	}
	
	@Test
	public void testReporterMarkdownCreation() {
		IReporter reporter = reporterFactory.createReport("./src/test/resources/output/Eggs.md", ReportType.MD, "./src/test/resources/input/Eggs.tsv", "\t");
		assertNotNull(reporter);
		assertTrue(reporter instanceof ReporterMarkdown);
	}
	
	@Test
	public void testReporterTextCreation() {
		IReporter reporter = reporterFactory.createReport("./src/test/resources/output/Eggs.txt", ReportType.TEXT, "./src/test/resources/input/Eggs.tsv", "\t");
		assertNotNull(reporter);
		assertTrue(reporter instanceof ReporterText);
	}
	
}
