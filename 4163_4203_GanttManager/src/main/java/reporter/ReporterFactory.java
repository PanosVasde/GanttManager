package reporter;

import backend.ReportType;

public class ReporterFactory {
	public IReporter createReport(String path, ReportType type, String fileName, String delimiter) {
		if(type == ReportType.TEXT) {
			return new ReporterText(path, fileName, delimiter);
		}
		else if(type == ReportType.MD) {
			return new ReporterMarkdown(path, fileName, delimiter);
		}
		else if(type == ReportType.HTML) {
			return new ReporterHtml(path, fileName, delimiter);
		}
		
		return null;
	}
}