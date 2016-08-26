package com.skyquill.minder.server.report;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.isomorphic.log.Logger;
import com.pdfjet.*;
import com.skyquill.minder.model.ReportParameters;
import com.skyquill.minder.server.gae.GenericJdoDao;
import com.skyquill.minder.server.gae.PMF;

@SuppressWarnings("unchecked")
public class ReportGenerationController extends AbstractController {

//	protected Log logger = LogFactory.getLog(ReportGenerationController.class);
	private Logger logger = new Logger(GenericJdoDao.class.getName());
	
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("ReportGenerationController.handleRequestInternal(): starting");

		
		// get parameters from request
		String rptId = request.getParameter("rptId");
		if (rptId==null) {
			logger.info("ReportGenerationController.handleRequestInternal(): rptId is null!");
		} else {
//			String rptId = (String)sessObj;
//			ReportParameters reportParms = (ReportParameters)request.getSession().getAttribute("reportParameters");
//			String format = reportParms.getOutputFormat();
			logger.info("ReportGenerationController.handleRequestInternal(): rptId=" + rptId);
			
//			if (format.equals("PDF")) {
//				
//			} else if (format.equals("XLS")) {
//				
//			} else {
//			}

		}

		PersistenceManager pm = PMF.get().getPersistenceManager();
		Object obj = pm.getObjectById(ReportParameters.class, rptId);			
		if (obj!=null) {
			logger.info("ReportGenerationController.handleRequestInternal(): retrieved the reportparameters");
			ReportParameters parms = (ReportParameters)obj;
			String empType = parms.getEmpType();
			String format = parms.getOutputFormat();
			logger.info("ReportGenerationController.handleRequestInternal(): empType=" + empType + ", format=" + format);
			
			ServletOutputStream out = response.getOutputStream();
			logger.info("ReportGenerationController.handleRequest(): building pdf");
			PDF pdf = buildReport(out);

			logger.info("ReportGenerationController.handleRequest(): done building pdf");
			pdf.flush();
			out.flush();
			out.close();
		}
		
		
		logger.info("ReportGenerationController.handleRequest(): done");
		
        return null;
	}

	
	public PDF buildReport(ServletOutputStream out) throws Exception {
		logger.info("ReportGenerationController.buildReport(): starting");
		
        PDF pdf = new PDF(out);
        pdf.setTitle("Using TextColumn and Paragraph classes");
        pdf.setSubject("Examples");
        pdf.setAuthor("Innovatics Inc.");
        Font f1 = new Font(pdf, "Helvetica");
        Font f2 = new Font(pdf, "Helvetica-Bold");

		logger.info("ReportGenerationController.buildReport(): 2");
        Page page = new Page(pdf, Letter.PORTRAIT);

        f1.setSize(12);
        f2.setSize(14);
        
        List<List<Cell>> rowCells = new ArrayList<List<Cell>>();
        
        for (int i = 0; i < 20; i++) {
	        
    		logger.info("ReportGenerationController.buildReport(): 3");
	        List<Cell> columnCells = new ArrayList<Cell>();
	        for (int j = 0; j < 20; j++) {
		        Cell cell = new Cell(f2);
		        cell.setText("row" + i + " col" + j);
		        columnCells.add(cell);
	        }
	        rowCells.add(columnCells);
		}
        
        Table table = new Table(f1, f2);
        table.setData(rowCells);
        
		logger.info("ReportGenerationController.buildReport(): 4");
//        table.se
//        table.setData(
//                "data/world-communications.txt",
//                "|",
//                Table.DATA_HAS_2_HEADER_ROWS);
        
        table.setLineWidth(0.2);
        table.setPosition(70.0, 30.0);
        table.setTextColorInRow(2, RGB.BLUE);
        table.setTextColorInRow(5, RGB.RED);
        table.setTextFontInRow(6, f1, 7);
        table.removeLineBetweenRows(12, 13);
        table.autoAdjustColumnWidths();
//        table.setWidthForColumn(0, 120);
        table.rightAlignNumbers();
        int numOfPages = table.getNumberOfPages(page);
        while (true) {
            table.drawOn(page);
            // TO DO: Draw "Page 1 of N" here
            if (!table.hasMoreData()) break;
            page = new Page(pdf, Letter.PORTRAIT);
        }

        
        
//        TextLine line1 = new TextLine(f2, "Switzerland");
//        line1.setColor(RGB.BLACK);
//        
        
//		logger.info("ReportGenerationController.buildReport(): 3");
//        line1.drawOn(page);
        
		logger.info("ReportGenerationController.buildReport(): done");
        return pdf;
        
    }
	
//	pdf.wrap();
	//
//			String fileName = "Example_03.pdf";
	//
//			resp.setContentType("application/pdf");
//			resp.setHeader("Content-Disposition", "attachment; filename=\"" +
//			fileName + "\"");
//			ServletOutputStream outs = res;
			
			
	
//		UserContext context = (UserContext)request.getSession().getAttribute("userContext");
//		String generationType = (String)reportParmContainer.getParmStringMap().get("GENERATION_TYPE");
//		String tenantName = (String)reportParmContainer.getParmStringMap().get(Constants.TENANT_NAME);
//		String reportTitle = (String)reportParmContainer.getParmStringMap().get(Constants.REPORT_NAME);
//		String parms = (String)reportParmContainer.getParmStringMap().get(Constants.REPORT_PARAMETERS);
//		String comments = (String)reportParmContainer.getParmStringMap().get(Constants.COMMENTS);
//		List columnsSelected = reportParmContainer.getColumns();
//		reportParameters.put(Constants.TENANT_NAME, tenantName);
//		reportParameters.put(Constants.REPORT_NAME, reportTitle);
//		reportParameters.put(Constants.REPORT_PARAMETERS, parms);
//		reportParameters.put(Constants.COMMENTS, comments);
//		reportParameters.put("SUBREPORT_DIR", "WEB-INF/classes");


		// get datasource
//		logger.info("ReportGenerationController.handleRequestInternal() generating " + reportTitle + " as " + format + " for " + tenantName);
//		ds = new JRBeanCollectionDataSource(createBeanCollection(reportParmContainer, context));
//		logger.debug("ReportGenerationController.handleRequestInternal() got datasource");
//
//		JasperReport jr = null;
//		JasperPrint jp = null;
		
		// if dynamic
//		if (generationType==null || generationType.equals("DYNAMIC")) {
//			// dynamic report generation - uses supplied templateFileName
//			DynamicReport dr = buildReport(tenantName, reportTitle, parms, comments, columnsSelected);
//			logger.debug("ReportGenerationController.handleRequestInternal() built DynamicReport");
//			jr = DynamicJasperHelper.generateJasperReport(dr, getLayoutManager(), reportParameters);
//			logger.debug("ReportGenerationController.handleRequestInternal() generated JasperReport");
//			
//			
//		} else {
//			// else static - load & compile templateFileName jrxml
//			logger.debug("ReportGenerationController.handleRequestInternal() loading compiled static report as resource");
//			DefaultResourceLoader rl = new DefaultResourceLoader();
//			Resource rs = rl.getResource(templateFileName);
//			logger.debug("ReportGenerationController.handleRequestInternal() loading compiled static report file");
//			File reportFile = rs.getFile();
//			
////			File reportFile = new File(getServletContext().getRealPath("/BasicReport.jasper"));
//			
//			logger.debug("ReportGenerationController.handleRequestInternal() jrloader");
//			
//			jr = (JasperReport)JRLoader.loadObject(reportFile);
////			jp = 
//			logger.debug("ReportGenerationController.handleRequestInternal() got jr");
//			
//		}
		

//		// fill report using parameters and datasource
//		if (!format.equals(Constants.PDF)) {
//			reportParameters.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.TRUE);
//		}
//		JasperPrint jp = JasperFillManager.fillReport(jr, reportParameters, ds);
//		logger.debug("ReportGenerationController.handleRequestInternal() filled report");
//
//
//		
//		// export to desired format
//		generateOutput(response, format, jp);  


		//		logger.debug("ReportGenerationController.handleRequest(): setting PDF exporter");
//		byte[] pdfByteArray = JasperExportManager.exportReportToPdf(jasperPrint);
//		response.setHeader(Constants.CONTENT_DISPOSITION, "inline; filename=report.pdf");
//		ServletOutputStream out = response.getOutputStream();
//		out.write(pdfByteArray, 0, pdfByteArray.length);
//		out.flush();
//		out.close();
//	} else if (format.equals(Constants.EXCEL)) {
//		logger.debug("ReportGenerationController.handleRequest(): setting EXCEL exporter");
//		response.addHeader(Constants.CONTENT_TYPE, "application/octet-stream");
//		response.setHeader(Constants.CONTENT_DISPOSITION, "attachment; filename=report.xls");
//		exporter = new JRXlsExporter();
//		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
//		exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
//		exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
//		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
//		exporter.exportReport();
//	} else if (format.equals(Constants.HTML)) {
//		logger.debug("ReportGenerationController.handleRequest(): setting HTML exporter");
//		exporter = new JRHtmlExporter();
//		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//		exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, response.getWriter());
//		exporter.exportReport();
//	} else if (format.equals(Constants.CSV)) {
//		logger.debug("ReportGenerationController.handleRequest(): setting CSV exporter");
//		response.addHeader(Constants.CONTENT_TYPE, "text/csv");
//		response.setHeader(Constants.CONTENT_DISPOSITION, "attachment; filename=report.csv");
////		JRCsvExporter csvExporter = new JRCsvExporter();
//		exporter = new JRCsvExporter();
//		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
//		exporter.exportReport();
//	}
		

//	protected abstract List createBeanCollection(ReportParmContainer reportParmContainer, UserContext context);
	
//	private static void buildColumns() throws Exception {
//		
//		final NumberFormat nf = NumberFormat.getIntegerInstance(); 
//		nf.setMinimumIntegerDigits(2);  
//		
//		AbstractColumn nameCol = ColumnBuilder.getInstance()
//		.setCustomExpression( 
//				new CustomExpression() {
//					public String getClassName() {
//						return String.class.getName();
//					}
//					public Object evaluate(Map fields, Map variables, Map parameters) {
//						Map map = (Map) fields;
//						String lastName = (String) map.get(Constants.ITINERARY_TRAVELLER_PERSONAL_DETAILS_LAST_NAME);
//						String firstName = (String) map.get(Constants.ITINERARY_TRAVELLER_PERSONAL_DETAILS_FIRST_NAME);
//						return lastName + ", " + firstName;
//					}
//				}
//		)
//		.setTitle(Constants.NAME_COL)
//		.setWidth(125)
//		.setStyle(detailStyle).setHeaderStyle(headerStyle)
//		.build();
//		availableColumns.put(Constants.NAME_COL, nameCol);
//
//		
//		AbstractColumn empTitleCol = ColumnBuilder.getInstance()
//		.setCustomExpression( 
//				new CustomExpression() {
//					public String getClassName() {
//						return String.class.getName();
//					}
//					public Object evaluate(Map fields, Map variables, Map parameters) {
//						Map map = (Map) fields;
//						Boolean employee = (Boolean) map.get(Constants.ITINERARY_TRAVELLER_PERSONAL_DETAILS_EMPLOYEE);
//						if (employee) {
//							return (String)map.get(Constants.ITINERARY_TRAVELLER_EMPLOYMENT_DETAILS_TITLE);
//						} else {
//							return (String)map.get(Constants.ITINERARY_TRAVELLER_NONEMPLOYMENT_DETAILS_TITLE);
//						}
//					}
//				}
//		)
//		.setTitle(Constants.TITLE_COL)
//		.setWidth(125)
//		.setStyle(detailStyle).setHeaderStyle(headerStyle)
//		.build();
//		availableColumns.put(Constants.TITLE_COL, empTitleCol);
//
//		
//		AbstractColumn depDateCol = ColumnBuilder.getInstance()
//		.setCustomExpression( 
//				new CustomExpression() {
//					public String getClassName() {
//						return String.class.getName();
//					}
//					public Object evaluate(Map fields, Map variables, Map parameters) {
//						Map map = (Map) fields;
//						Date depDate = (Date) map.get(Constants.FLIGHT_DEPARTURE_DEPARTURE_DATE);
//						Integer depHrs = (Integer) map.get(Constants.FLIGHT_DEPARTURE_DEPARTURE_TIME_HRS);
//						Integer depMins = (Integer) map.get(Constants.FLIGHT_DEPARTURE_DEPARTURE_TIME_MINS);
//						return new SimpleDateFormat(Constants.YYYY_MM_DD).format(depDate) + " " + nf.format((long)depHrs) + ":" + nf.format((long)depMins);
//					}
//				}
//		)
//		.setTitle(Constants.DEPART_DATE_COL)
//		.setWidth(100)
//		.setStyle(detailStyle).setHeaderStyle(headerStyle)
//		.build();
//		availableColumns.put(Constants.DEPART_DATE_COL, depDateCol);
//
//		AbstractColumn origCityCol = ColumnBuilder.getInstance()
//		.setCustomExpression( 
//				new CustomExpression() {
//					public String getClassName() {
//						return String.class.getName();
//					}
//					public Object evaluate(Map fields, Map variables, Map parameters) {
//						Map map = (Map) fields;
//						String origCity = (String) map.get(Constants.FLIGHT_DEPARTURE_FLIGHT_ROUTE_ORIGIN_AIRPORT_CITY_NAME);
//						String origIata = (String) map.get(Constants.FLIGHT_DEPARTURE_FLIGHT_ROUTE_ORIGIN_AIRPORT_IATA_CODE);
//						return origCity + "/" + origIata;
//					}
//				}
//		)
//		.setTitle(Constants.ORIG_CITY_COL)
//		.setWidth(125)
//		.setStyle(detailStyle).setHeaderStyle(headerStyle)
//		.build();
//		availableColumns.put(Constants.ORIG_CITY_COL, origCityCol);
//		
//		AbstractColumn origCountryCol = ColumnBuilder.getInstance()
//		.setColumnProperty(Constants.ORIG_COUNTRY_FIELD[0], Constants.ORIG_COUNTRY_FIELD[1])
//		.setTitle(Constants.ORIG_COUNTRY_COL)
//		.setWidth(125)
//		.setStyle(detailStyle).setHeaderStyle(headerStyle)
//		.build();
//		availableColumns.put(Constants.ORIG_COUNTRY_COL, origCountryCol);
//		
//		AbstractColumn arrDateCol = ColumnBuilder.getInstance()
//		.setCustomExpression( 
//				new CustomExpression() {
//					public String getClassName() {
//						return String.class.getName();
//					}
//					public Object evaluate(Map fields, Map variables, Map parameters) {
//						Map map = (Map) fields;
//						Date arrDate = (Date) map.get(Constants.FLIGHT_DEPARTURE_ARRIVAL_DATE);
//						Integer arrHrs = (Integer) map.get(Constants.FLIGHT_DEPARTURE_ARRIVAL_TIME_HRS);
//						Integer arrMins = (Integer) map.get(Constants.FLIGHT_DEPARTURE_ARRIVAL_TIME_MINS);
//						return new SimpleDateFormat(Constants.YYYY_MM_DD).format(arrDate) + " " + nf.format((long)arrHrs) + ":" + nf.format((long)arrMins);
//					}
//				}
//		)
//		.setTitle(Constants.ARRIVE_DATE_COL)
//		.setWidth(100)
//		.setStyle(detailStyle).setHeaderStyle(headerStyle)
//		.build();
//		availableColumns.put(Constants.ARRIVE_DATE_COL, arrDateCol);
//		
//		AbstractColumn destCityCol = ColumnBuilder.getInstance()
//		.setCustomExpression( 
//				new CustomExpression() {
//					public String getClassName() {
//						return String.class.getName();
//					}
//					public Object evaluate(Map fields, Map variables, Map parameters) {
//						Map map = (Map) fields;
//						String destCity = (String) map.get(Constants.FLIGHT_DEPARTURE_FLIGHT_ROUTE_DEST_AIRPORT_CITY_NAME);
//						String destIata = (String) map.get(Constants.FLIGHT_DEPARTURE_FLIGHT_ROUTE_DEST_AIRPORT_IATA_CODE);
//						return destCity + "/" + destIata;
//					}
//				}
//		)
//		.setTitle(Constants.DEST_CITY_COL)
//		.setWidth(125)
//		.setStyle(detailStyle).setHeaderStyle(headerStyle)
//		.build();
//		availableColumns.put(Constants.DEST_CITY_COL, destCityCol);
//		
//		AbstractColumn destCountryCol = ColumnBuilder.getInstance()
//		.setColumnProperty(Constants.DEST_COUNTRY_FIELD[0], Constants.DEST_COUNTRY_FIELD[1])
//		.setTitle(Constants.DEST_COUNTRY_COL)
//		.setWidth(125)
//		.setStyle(detailStyle).setHeaderStyle(headerStyle)
//		.build();
//		availableColumns.put(Constants.DEST_COUNTRY_COL, destCountryCol);
//
//		AbstractColumn purposeCol = ColumnBuilder.getInstance()
//		.setColumnProperty(Constants.ITIN_PURPOSE_FIELD[0], Constants.ITIN_PURPOSE_FIELD[1])
//		.setTitle(Constants.PURPOSE_COL)
//		.setWidth(125)
//		.setStyle(detailStyle).setHeaderStyle(headerStyle)
//		.build();
//		availableColumns.put(Constants.PURPOSE_COL, purposeCol);
//
//		AbstractColumn deptCol = ColumnBuilder.getInstance()
//		.setColumnProperty(Constants.EMP_DEPT_FIELD[0], Constants.EMP_DEPT_FIELD[1])
//		.setTitle(Constants.DEPT_COL)
//		.setWidth(125)
//		.setStyle(detailStyle).setHeaderStyle(headerStyle)
//		.build();
//		availableColumns.put(Constants.DEPT_COL, deptCol);
//
//		AbstractColumn divnCol = ColumnBuilder.getInstance()
//		.setColumnProperty(Constants.EMP_DIVN_FIELD[0], Constants.EMP_DIVN_FIELD[1])
//		.setTitle(Constants.DIVN_COL)
//		.setWidth(125)
//		.setStyle(detailStyle).setHeaderStyle(headerStyle)
//		.build();
//		availableColumns.put(Constants.DIVN_COL, divnCol);
//		
//		// for all custom expressions above,
//		// define the fields used 
//		fields.add(Constants.LAST_NAME_FIELD);
//		fields.add(Constants.FIRST_NAME_FIELD);
//		fields.add(Constants.DEP_DATE_FIELD);
//		fields.add(Constants.DEP_HRS_FIELD);
//		fields.add(Constants.DEP_TIME_MINS_FIELD);
//		fields.add(Constants.ARR_DATE_FIELD);
//		fields.add(Constants.ARR_HRS_FIELD);
//		fields.add(Constants.ARR_MINS_FIELD);
//		fields.add(Constants.ORIG_IATA_FIELD);
//		fields.add(Constants.ORIG_CITY_FIELD);
//		fields.add(Constants.DEST_IATA_FIELD);
//		fields.add(Constants.DEST_CITY_FIELD);
//		fields.add(Constants.EMP_TYPE_FIELD);
//		fields.add(Constants.EMP_TITLE_FIELD);
//		fields.add(Constants.NONEMP_TITLE_FIELD);
//		
//	}

//	private static void defineStyles() {
//		titleStyle.setFont(new Font(10,Font._FONT_VERDANA,true));
//		titleStyle.setHorizontalAlign(HorizontalAlign.CENTER);
//
//		subTitleStyle.setFont(new Font(10,Font._FONT_VERDANA,true));
//		subTitleStyle.setStretchWithOverflow(true);
//		subTitleStyle.setStreching(Stretching.NO_STRETCH);
//		subTitleStyle.setHorizontalAlign(HorizontalAlign.CENTER);
//		subTitleStyle.setVerticalAlign(VerticalAlign.TOP);
//
//		headerStyle.setFont(new Font(8,Font._FONT_VERDANA,true));
//		headerStyle.setBorderBottom(Border.THIN);
//		headerStyle.setTextColor(Color.black);
//		headerStyle.setHorizontalAlign(HorizontalAlign.LEFT);
//		headerStyle.setVerticalAlign(VerticalAlign.MIDDLE);
//
//		detailStyle.setFont(new Font(8,Font._FONT_VERDANA,false));
//		detailStyle.setVerticalAlign(VerticalAlign.TOP);
//
//		numberStyle.setVerticalAlign(VerticalAlign.TOP);
//		numberStyle.setHorizontalAlign(HorizontalAlign.RIGHT);
//
//		amountStyle.setVerticalAlign(VerticalAlign.TOP);
//		amountStyle.setHorizontalAlign(HorizontalAlign.RIGHT);
//		amountStyle.setBackgroundColor(Color.cyan);
//		amountStyle.setTransparency(Transparency.OPAQUE);
//
//		oddRowStyle.setBorder(Border.THIN);
//
//		Color veryLightGrey = new Color(230,230,230);
//		Color veryLightBlue = new Color(210,210,250);
//
//		oddRowStyle.setBorderColor(veryLightBlue);
//		oddRowStyle.setBackgroundColor(veryLightGrey);oddRowStyle.setTransparency(Transparency.OPAQUE);
//	}
//	
//	protected LayoutManager getLayoutManager() {
//		return new ClassicLayoutManager();
//	}
//
//	private DynamicReport buildReport(String tenantName, String reportTitle, String parms, String comments, List columnsSelected) throws Exception {
//		logger.debug("ReportGenerationController.buildReport() starting using template file " + templateFileName);
//

//		DynamicReportBuilder drb = new DynamicReportBuilder();
//		drb.setTemplateFile(templateFileName);
//
//		Integer margin = new Integer(20);
//
//		drb
//		.setDefaultStyles(titleStyle, subTitleStyle, headerStyle, detailStyle)
//		.setPageSizeAndOrientation(Page.Page_Letter_Landscape())
//		.setUseFullPageWidth(true)
////		.setTitle(tenantName + " - " + reportTitle)
////		.setSubtitle(parms + " - " + comments)
////		.setTitleHeight(new Integer(20))
////		.setSubtitleHeight(new Integer(20))
//		.setDetailHeight(new Integer(15))
//		.setLeftMargin(margin)
//		.setRightMargin(margin)
//		.setTopMargin(margin)
//		.setBottomMargin(margin)
//		.setPrintBackgroundOnOddRows(true)
//		.setOddRowBackgroundStyle(oddRowStyle)
//		.setColumnsPerPage(new Integer(1))
//		.setColumnSpace(new Integer(5));
//
//		// add all fields
//		for (Iterator iterator2 = fields.iterator(); iterator2.hasNext();) {
//			String[] field = (String[]) iterator2.next();
//			logger.debug("ReportGenerationController.buildReport() adding " + field[0] + " as " + field[1]);
//			drb.addField(field[0], field[1]);
//		}
//
//		// add selected columns to report
//		for (Iterator iterator = columnsSelected.iterator(); iterator.hasNext();) {
//			String colName = (String)iterator.next();
//			
//			AbstractColumn col = availableColumns.get(colName);
//
//			if (col!=null) {
//				logger.debug("ReportGenerationController.buildReport() adding col " + col.getTitle());
//				drb.addColumn(col);
//			}
//		}
//
////		drb.addAutoText(AutoText.AUTOTEXT_CREATED_ON, AutoText.POSITION_HEADER, AutoText.ALIGMENT_RIGHT, AutoText.PATTERN_DATE_DATE_TIME);
////		drb.addAutoText(AutoText.AUTOTEXT_PAGE_X_OF_Y, AutoText.POSITION_FOOTER, AutoText.ALIGMENT_CENTER);
//
//		logger.debug("ReportGenerationController.buildReport() building");
//
//		DynamicReport dr = drb.build();
//
//		logger.debug("ReportGenerationController.buildReport() done");

//		return dr;
	}

//	private void generateOutput(HttpServletResponse response, String format, JasperPrint jasperPrint) throws JRException, IOException {
//
//		// create appropriate exporter
//		JRAbstractExporter exporter = null;
//		if (format.equals(Constants.PDF)) {
//			logger.debug("ReportGenerationController.handleRequest(): setting PDF exporter");
//			byte[] pdfByteArray = JasperExportManager.exportReportToPdf(jasperPrint);
//			response.setHeader(Constants.CONTENT_DISPOSITION, "inline; filename=report.pdf");
//			ServletOutputStream out = response.getOutputStream();
//			out.write(pdfByteArray, 0, pdfByteArray.length);
//			out.flush();
//			out.close();
//		} else if (format.equals(Constants.EXCEL)) {
//			logger.debug("ReportGenerationController.handleRequest(): setting EXCEL exporter");
//			response.addHeader(Constants.CONTENT_TYPE, "application/octet-stream");
//			response.setHeader(Constants.CONTENT_DISPOSITION, "attachment; filename=report.xls");
//			exporter = new JRXlsExporter();
//			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
//			exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
//			exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
//			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
//			exporter.exportReport();
//		} else if (format.equals(Constants.HTML)) {
//			logger.debug("ReportGenerationController.handleRequest(): setting HTML exporter");
//			exporter = new JRHtmlExporter();
//			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//			exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, response.getWriter());
//			exporter.exportReport();
//		} else if (format.equals(Constants.CSV)) {
//			logger.debug("ReportGenerationController.handleRequest(): setting CSV exporter");
//			response.addHeader(Constants.CONTENT_TYPE, "text/csv");
//			response.setHeader(Constants.CONTENT_DISPOSITION, "attachment; filename=report.csv");
////			JRCsvExporter csvExporter = new JRCsvExporter();
//			exporter = new JRCsvExporter();
//			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
//			exporter.exportReport();
//		}
//	}

//	public String getTemplateFileName() {
//		return templateFileName;
//	}
//
//	public void setTemplateFileName(String templateFileName) {
//		this.templateFileName = templateFileName;
//	}
//
//	public TravellerService getTravellerService() {
//		return travellerService;
//	}
//
//	public void setTravellerService(TravellerService travellerService) {
//		logger.debug("BasicReportController.setTravellerService()");
//		this.travellerService = travellerService;
//	}
//}
