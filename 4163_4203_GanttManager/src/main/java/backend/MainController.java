package backend;

import dom2app.SimpleTableModel;
import dom.LoaderFactory;
import dom.ILoader;
import parser.FilterFactory;
import parser.IFilter;
import reporter.IReporter;
import reporter.ReporterFactory;

public class MainController implements IMainController {
	
	private String fileName;
	private String delimiter;
	
	@Override
	public SimpleTableModel load(String fileName, String delimiter) {
		this.fileName = fileName;
		this.delimiter = delimiter;
		LoaderFactory loaderFactory = new LoaderFactory();
		ILoader loader = loaderFactory.createLoader(fileName, delimiter);
		loader.load();
		SimpleTableModel tableModel = new SimpleTableModel(loader.getFileName(), loader.getFileName(), loader.getpColumnNames(), loader.getpData());
		return tableModel;
	}

	@Override
	public SimpleTableModel getTasksByPrefix(String prefix) {
		FilterFactory prefixFactory = new FilterFactory();
		IFilter prefixFilter = prefixFactory.createPrefixFilter(prefix, fileName, delimiter);
		ILoader prefixLoader = prefixFilter.filter();
		SimpleTableModel tableModel = new SimpleTableModel(prefixLoader.getFileName(), prefixLoader.getFileName(), prefixLoader.getpColumnNames(), prefixFilter.getTaskList());
		return tableModel;
	}

	@Override
	public SimpleTableModel getTaskById(int id) {
		FilterFactory idFactory = new FilterFactory();
		IFilter idFilter = idFactory.createIdFilter(id, fileName, delimiter);
		ILoader idLoader = idFilter.filter();
		SimpleTableModel tableModel = new SimpleTableModel(idLoader.getFileName(), idLoader.getFileName(), idLoader.getpColumnNames(), idFilter.getTaskList());
		return tableModel;
	}

	@Override
	public SimpleTableModel getTopLevelTasks() {
		FilterFactory topLevelFactory = new FilterFactory();
		IFilter topLevelFilter = topLevelFactory.createTopLevelFilter(fileName, delimiter);
		ILoader topLevelLoader = topLevelFilter.filter();
		SimpleTableModel tableModel = new SimpleTableModel(topLevelLoader.getFileName(), topLevelLoader.getFileName(), topLevelLoader.getpColumnNames(), topLevelFilter.getTaskList());
		return tableModel;
	}

	@Override
	public int createReport(String path, ReportType type) {
		ReporterFactory reportFactory = new ReporterFactory();
		IReporter report = reportFactory.createReport(path, type, fileName, delimiter);
		report.loadCurrentList();
		report.createReport();
		return report.getTaskProcessed();
	}
	

}
