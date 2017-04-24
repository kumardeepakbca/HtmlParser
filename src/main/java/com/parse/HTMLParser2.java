package com.parse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLParser2 {

	public static void main(String[] args) {

		//String htmlPath = args[0];

		String htmlPath = "D:/HTML_TO_CSV/TableCSVExport-master/AWR.html";

		System.out.println("htmlPath:::::" + htmlPath);

		String content = "";

		try {

			BufferedReader in = new BufferedReader(new FileReader(htmlPath));
			String str;

			while ((str = in.readLine()) != null) {
				content += str;
			}

			in.close();

		} catch (IOException e) {

		}

		try {


			String csvPath = "";

			//String csvLocation=args[1];

			String csvLocation = "D:\\data\\top5timed_events.csv";

			System.out.println("csvLocation::::" + csvLocation);

			// String csvFile = "D:\\table3.csv";

			Document doc = Jsoup.parse(content);

			// Element table = doc.select("table").get(0);

			Elements tables = doc.select("table");

			System.out.println(tables.size()
					+ ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			
			Map<Integer,String> csvData=new HashMap<Integer, String>();
			for(Integer i=0;i<=185;i++){
				csvData.put(i, "0");
			}
			
			int tableCount=0;
			List colsData = new ArrayList();
			String timePeriod="";
			FileWriter writer = new FileWriter(csvLocation,true);
			for (Element table : tables) {
				tableCount++;
				if(tableCount >17){
					break;
				}
				if(tableCount == 2|| tableCount==16){
				synchronized (table) {
					//csvPath = csvLocation + System.currentTimeMillis() + ".csv";
					if(tableCount==2){
							Elements rows = table.select("tr");
							for (int i = 0; i < rows.size(); i++) { // first row is the
								Element row = rows.get(i);
								Elements cols = null;
								cols = row.select("td");
								if(i==3){
									csvData.put(0, timePeriod);
									csvData.put(27, timePeriod);
									break;
								}
								for (int j = 0; j < cols.size(); j++) {
									if(j==2){
										System.out.println("timePeriod==="+timePeriod);
										if("".equals(timePeriod)){
										timePeriod=timePeriod+cols.get(j).text();
										}else{
											timePeriod=timePeriod+" - "+cols.get(j).text();
										}
									}
									
		
								}
								
		
							}
					}else if(tableCount == 16){
						Elements rows = table.select("tr");
						for (int i = 0; i < rows.size(); i++) { // first row is the
							Element row = rows.get(i);
							Elements cols = null;
							cols = row.select("td");
							boolean colFlag=false;
							boolean seqFlag=false;
							boolean cacheFlag=false;
							boolean libflag=false;
							boolean psflag=false;
							boolean bloc3Flag=false;
							boolean logSeqFlag=false;
							boolean logArcFlag=false;
							boolean logFileFlag=false;
							boolean sqlDataFlag=false;
							boolean cntFileFlag=false;
							boolean wfFlag=false;
							for (int j = 0; j < cols.size(); j++) {
								if(j==0){
									String value=cols.get(j).text();
									if(value != null && "gc cr block 2-way".equals(value)){
										colFlag=true;
									}else if(value != null && "latch: cache buffers chains".equals(value)){
										cacheFlag=true;
									}else if(value != null && "log file sequential read".equals(value.trim())){
										seqFlag=true;
									}else if(value != null && "latch: library cache lock".equals(value.trim())){
										libflag=true;
									}else if(value != null && "enq: PS - contention".equals(value.trim())){
										psflag=true;
									}else if(value != null && "gc current block 3-way".equals(value.trim())){
										bloc3Flag=true;
									}else if(value != null && "log file sequential read".equals(value.trim())){
										logSeqFlag=true;
									}else if(value != null && "Log archive I/O".equals(value.trim())){
										logArcFlag=true;
									}else if(value != null && "log file parallel write".equals(value.trim())){
										logFileFlag=true;
									}else if(value != null && "SQL*Net more data from client".equals(value.trim())){
										sqlDataFlag=true;
									}else if(value != null && "control file sequential read".equals(value.trim())){
										cntFileFlag=true;
									}else if(value != null && "enq: WF - contention".equals(value.trim())){
										wfFlag=true;
									}
										
									
									
									
									
									
									
									
								}
								
								
								if(colFlag){
									csvData.put(1, cols.get(1).text().replaceAll(",",""));
									csvData.put(2,cols.get(3).text());
									csvData.put(3,cols.get(4).text());
									String val=cols.get(2).text();
									/*if(val != null){
										if(!"".equals(val.trim())){
											csvData.put(4,val);
										}
									}*/
								}
								
								if(j==0){
									
								}
								if(seqFlag){
									csvData.put(6,cols.get(1).text().replaceAll(",",""));
									csvData.put(7,cols.get(2).text());
									csvData.put(8,cols.get(3).text());
								}
								if(cacheFlag){
									csvData.put(16,cols.get(1).text().replaceAll(",",""));
									csvData.put(17,cols.get(3).text());
									csvData.put(18,cols.get(4).text());
								}
								if(libflag){
									csvData.put(21,cols.get(1).text().replaceAll(",",""));
									csvData.put(22,cols.get(3).text());
									csvData.put(23,cols.get(4).text());
								}
								if(psflag){
									csvData.put(26,cols.get(1).text().replaceAll(",",""));
								}
								if(bloc3Flag){
									csvData.put(28,cols.get(1).text().replaceAll(",",""));
									csvData.put(29,cols.get(3).text());
									csvData.put(30,cols.get(4).text());
								}
								if(logFileFlag){
									csvData.put(41,cols.get(1).text().replaceAll(",",""));
									csvData.put(42,cols.get(3).text());
									csvData.put(43,cols.get(4).text());
								}
								if(sqlDataFlag){
									csvData.put(51,cols.get(1).text().replaceAll(",",""));
									csvData.put(52,cols.get(3).text());
									csvData.put(53,cols.get(4).text());
								}
								if(cntFileFlag){
									csvData.put(56,cols.get(1).text().replaceAll(",",""));
									csvData.put(57,cols.get(3).text());
									csvData.put(58,cols.get(4).text());
								}
								if(wfFlag){
									csvData.put(61,cols.get(1).text().replaceAll(",",""));
									csvData.put(62,cols.get(3).text());
									csvData.put(63,cols.get(4).text());
								}
								seqFlag=false;
								colFlag=false;
								cacheFlag=false;
								libflag=false;
								psflag=false;
								bloc3Flag=false;
								logSeqFlag=false;
								logArcFlag=false;
								logFileFlag=false;
								sqlDataFlag=false;
								cntFileFlag=false;
								wfFlag=false;
								break;
							}
							
							
							
	
						}
					}
				}
				}
				
			}
			List colsMapData = new ArrayList();
			for(Map.Entry<Integer, String> map: csvData.entrySet()){
				colsMapData.add(map.getValue());
			}
			CSVUtils.writeLine(writer, colsMapData);
			Thread.sleep(50);
			System.out.println("CSV file was created successfully !!!");
			writer.flush();
			writer.close();

		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}

	}

}
