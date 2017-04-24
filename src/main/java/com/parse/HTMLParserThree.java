package com.parse;

import java.io.BufferedReader;
import java.io.File;
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

public class HTMLParserThree {

	public static void main(String[] args) {

		String htmlPath = args[0];
		
		if(htmlPath == null || "".equals(htmlPath.trim())){
			htmlPath = "C:\\awr\\AWRDataProgramFiles\\AWR.html";
		}
		System.out.println("htmlPath:::::" + htmlPath);
		File htmlf= new File(htmlPath);
		boolean isHtmlExist=true;
		if(!htmlf.exists()){
			isHtmlExist=false;
			System.out.println("Html file not found on given location");
		}
		if(isHtmlExist){
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



			// String csvFile = "D:\\table3.csv";

			Document doc = Jsoup.parse(content);
			
			// Element table = doc.select("table").get(0);

			Elements tables = doc.select("table");
			if(tables != null ){
					loadProfile(tables,args[1]);
			}
			Map<Integer,String> csvData=new HashMap<Integer, String>();
			
			String csvLocation=args[1]+"top5timed_events.csv";
			if(args[1] == null || "".equals(args[1].trim())){
				csvLocation = "C:\\awr\\AWRDataOutputFiles\\top5timed_events.csv";
			}
			System.out.println("csvLocation::::" + csvLocation);
			int tableCount=0;
			List colsData = new ArrayList();
			String timePeriod="";
			FileWriter writer=null;
			File f= new File(csvLocation);
			if(!f.exists()){
				List colsMapHeader = new ArrayList();
				
				for(Map.Entry<Integer, String> map: getHeaderData().entrySet()){
					colsMapHeader.add(map.getValue());
				}
				writer = new FileWriter(csvLocation,true);
				CSVUtils.writeLine(writer, colsMapHeader);
				for(Integer i=0;i<=186;i++){
					csvData.put(i, "0");
				}
			}else{
				writer = new FileWriter(csvLocation,true);
				for(Integer i=0;i<=186;i++){
					csvData.put(i, "0");
				}
			}
			//FileWriter 
			for (Element table : tables) {
				tableCount++;
				if(tableCount >17){
					break;
				}
				if(tableCount == 2|| tableCount==8){
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
										if("".equals(timePeriod)){
										timePeriod=timePeriod+cols.get(j).text();
										}else{
											timePeriod=timePeriod+" - "+cols.get(j).text();
										}
									}
									
		
								}
								
		
							}
					}else if(tableCount == 8){
						Elements rows = table.select("tr");
						for (int i = 0; i < rows.size(); i++) { // first row is the
							Element row = rows.get(i);
							Elements cols = null;
							cols = row.select("td");
							
							boolean cntFileFlag=false;
							boolean cpuFlag=false;
							boolean cacheBuffFlag=false;
							boolean relibleFlag=false;
							boolean dbFlag=false;
							/* our extension */
							boolean gcFlag=false;
							boolean logFlag=false;
							boolean lockFlag=false;
							boolean libFlag=false;
							
							
							boolean flag1=false;
							boolean flag2=false;
							boolean flag3=false;
							boolean flag4=false;
							
							
							boolean flag5=false;
							boolean flag6=false;
							boolean flag7=false;
							boolean flag8=false;
							
							boolean flag9=false;
							boolean flag10=false;
							boolean flag11=false;
							boolean flag12=false;
							
							boolean flag13=false;
							boolean flag14=false;
							boolean flag15=false;
							boolean flag16=false;
							
							boolean flag17=false;
							boolean flag18=false;
							boolean flag19=false;
							boolean flag20=false;
							boolean flag21=false;
							boolean flag22=false;
							boolean flag23=false;
							boolean flag24=false;
							boolean flag25=false;
							boolean flag26=false;
							boolean flag27=false;
							boolean flag28=false;
							
							for (int j = 0; j < cols.size(); j++) {
								if(j==0){
									String value=cols.get(j).text();
									if(value != null && "control file sequential read".equals(value)){
										cntFileFlag=true;
									}else if(value != null && "CPU time".equals(value)){
										cpuFlag=true;
									}else if(value != null && "latch: cache buffers chains".equals(value.trim())){
										cacheBuffFlag=true;
									}else if(value != null && "reliable message".equals(value.trim())){
										relibleFlag=true;
									}else if(value != null && "db file sequential read".equals(value.trim())){
										dbFlag=true;
									}
									/* our extension */
									
									else if(value != null && "gc cr block 2-way".equals(value)){
										gcFlag=true;
									}else if(value != null && "log file sequential read".equals(value.trim())){
										logFlag=true;
									}else if(value != null && "enq: TX - row lock contention".equals(value.trim())){
										lockFlag=true;
									}else if(value != null && "library cache lock".equals(value.trim())){
										libFlag=true;
									}
									
									
									
									
									
									else if(value != null && "enq: PS - contention".equals(value)){
										flag1=true;
									}else if(value != null && "db file scattered read".equals(value.trim())){
										flag2=true;
									}else if(value != null && "Log archive I/O".equals(value.trim())){
										flag3=true;
									}else if(value != null && "log file parallel write".equals(value.trim())){
										flag4=true;
									}
									
									else if(value != null && "enq: TC - contention".equals(value)){
										flag5=true;
									}else if(value != null && "SQL*Net more data from client".equals(value.trim())){
										flag6=true;
									}else if(value != null && "enq: WF - contention".equals(value.trim())){
										flag7=true;
									}else if(value != null && "PX Deq: reap credit".equals(value.trim())){
										flag8=true;
									}
									
									else if(value != null && "Data file init write".equals(value)){
										flag9=true;
									}else if(value != null && "DFS lock handle".equals(value.trim())){
										flag10=true;
									}else if(value != null && "buffer busy waits".equals(value.trim())){
										flag11=true;
									}else if(value != null && "gc current grant busy".equals(value.trim())){
										flag12=true;
									}
									
									else if(value != null && "log file sync".equals(value)){
										flag13=true;
									}else if(value != null && "gc current block 2-way".equals(value.trim())){
										flag14=true;
									}else if(value != null && "gc cr grant 2-way".equals(value.trim())){
										flag15=true;
									}else if(value != null && "os thread startup".equals(value.trim())){
										flag16=true;
									}
									
									else if(value != null && "enq: TX - allocate ITL entry".equals(value)){
										flag17=true;
									}else if(value != null && "db file parallel read".equals(value.trim())){
										flag18=true;
									}else if(value != null && "read by other session".equals(value.trim())){
										flag19=true;
									}else if(value != null && "free buffer waits".equals(value.trim())){
										flag20=true;
									}
									
									else if(value != null && "row cache lock".equals(value)){
										flag21=true;
									}else if(value != null && "enq: TX - contention".equals(value.trim())){
										flag22=true;
									}else if(value != null && "enq: CF - contention".equals(value.trim())){
										flag23=true;
									}else if(value != null && "gc buffer busy".equals(value.trim())){
										flag24=true;
									}
									
									else if(value != null && "enq: TX - index contention".equals(value)){
										flag25=true;
									}else if(value != null && "enq: HW - contention".equals(value.trim())){
										flag26=true;
									}else if(value != null && "PX Deq Credit: send blkd".equals(value.trim())){
										flag27=true;
									}else if(value != null && "gc cr multi block request".equals(value.trim())){
										flag28=true;
									}
									
								}
								
								if(cntFileFlag){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(56, cols.get(1).text().replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(57,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(58,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(59,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(60,val.trim());
									}
									
								}
								if(cpuFlag){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(66, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(67,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(68,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(69,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(70,val.trim());
									}
								}
								if(cacheBuffFlag){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(16, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(17,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(18,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(19,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(20,val.trim());
									
									}
								}
								if(relibleFlag){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(106, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(107,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(108,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(109,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(110,val.trim());
									}	
									
								}
								if(dbFlag){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(101, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(102,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(103,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(104,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(105,val.trim());
									}	
								}
								
								
								if(gcFlag){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(1, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(2,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(3,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(4,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(5,val.trim());
									}	
								}
								
								if(logFlag){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(6, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(7,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(8,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(9,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(10,val.trim());
									}	
								}
								
								if(lockFlag){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(11, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(12,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(13,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(14,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(15,val.trim());
									}	
								}
								
								
								if(libFlag){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(21, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(22,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(23,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(24,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(25,val.trim());
									}	
								}
								
								
								if(flag1){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(26, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(27,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(28,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(29,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(30,val.trim());
									}	
								}
								
								
								if(flag2){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(31, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(32,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(33,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(34,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(35,val.trim());
									}	
								}
								
								if(flag3){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(36, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(37,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(38,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(39,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(40,val.trim());
									}	
								}
								
								if(flag4){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(41, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(42,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(43,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(44,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(45,val.trim());
									}	
								}
								
								if(flag5){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(46, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(47,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(48,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(49,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(50,val.trim());
									}	
								}
								
								
								if(flag6){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(51, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(52,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(53,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(54,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(55,val.trim());
									}	
								}
								
								if(flag7){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(61, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(62,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(63,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(64,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(65,val.trim());
									}	
								}
								
							
								if(flag8){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(71, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(72,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(73,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(74,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(75,val.trim());
									}	
								}
								
							
								if(flag9){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(76, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(77,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(78,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(79,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(80,val.trim());
									}	
								}
								
							
								if(flag10){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(81, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(82,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(83,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(84,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(85,val.trim());
									}	
								}
								
							
								if(flag11){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(86, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(87,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(88,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(89,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(90,val.trim());
									}	
								}
								
						
								if(flag12){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(91, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(92,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(93,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(94,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(95,val.trim());
									}	
								}
							
								if(flag13){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(96, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(97,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(98,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(99,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(100,val.trim());
									}	
								}
							
								if(flag14){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(111, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(112,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(113,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(114,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(115,val.trim());
									}	
								}

								if(flag15){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(116, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(117,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(118,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(119,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(120,val.trim());
									}	
								}
								
								if(flag16){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(121, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(122,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(123,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(124,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(125,val.trim());
									}	
								}
								
								
								if(flag17){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(126, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(127,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(128,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(129,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(130,val.trim());
									}	
								}
								

								if(flag18){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(131, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(132,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(133,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(134,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(135,val.trim());
									}	
								}
								
							
								if(flag19){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(136, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(137,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(138,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(139,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(140,val.trim());
									}	
								}
								
								
								if(flag20){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(141, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(142,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(143,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(144,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(145,val.trim());
									}	
								}
								
							
								if(flag21){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(146, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(147,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(148,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(149,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(150,val.trim());
									}	
								}
								
								
								if(flag22){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(151, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(152,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(153,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(154,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(155,val.trim());
									}	
								}
								
							
								if(flag23){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(156, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(157,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(158,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(159,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(160,val.trim());
									}	
								}
								
							
								if(flag24){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(161, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(162,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(163,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(164,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(165,val.trim());
									}	
								}
								
								/* pending*/
								if(flag25){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(166, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(167,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(168,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(169,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(170,val.trim());
									}	
								}
								
								
								if(flag26){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(171, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(172,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(173,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(174,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(175,val.trim());
									}	
								}
								/* pending*/
								if(flag27){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(176, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(177,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(178,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(179,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(180,val.trim());
									}	
								}
								
								/* pending*/
								if(flag28){
									String val=cols.get(1).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(181, val.replaceAll(",",""));
									}
									val=cols.get(2).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(182,val);
									}
									val=cols.get(3).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(183,val);
									}
									val=cols.get(4).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(184,val.trim());
									}
									val=cols.get(5).text().replace("\u00a0", "");
									if(val != null && !"".equals(val.trim())){
										csvData.put(185,val.trim());
									}	
								}
								
								cntFileFlag=false;
								cpuFlag=false;
								cacheBuffFlag=false;
								relibleFlag=false;
								dbFlag=false;
								gcFlag=false;
								logFlag=false;
								lockFlag=false;
								libFlag=false;
								
								flag1=false;
								flag2=false;
								flag3=false;
								flag4=false;
								
								flag5=false;
								flag6=false;
								flag7=false;
								flag8=false;
								
								flag9=false;
								flag10=false;
								flag11=false;
								flag12=false;
								
								flag13=false;
								flag14=false;
								flag15=false;
								flag16=false;
								
								flag17=false;
								flag18=false;
								flag19=false;
								flag20=false;
								flag21=false;
								flag22=false;
								flag23=false;
								flag24=false;
								flag25=false;
								flag26=false;
								flag27=false;
								flag28=false;
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
	private static Map<Integer,String> getLoadProfileHeaderData(){
		Map <Integer,String> csvData=new HashMap<Integer, String>();
		csvData.put(0,"Begin time - End Time");
		csvData.put(1,"Redo Size per Second");	
		csvData.put(2,"Redo Size per Transaction");	
		csvData.put(3,"Logical reads per Second");	
		csvData.put(4,"Logical reads per Transaction");
		csvData.put(5,"Block changesper Second");	
		csvData.put(6,"Block changes per Transaction");	
		csvData.put(7,"Physical reads per Second");	
		csvData.put(8,"Physical reads per Transaction");	
		csvData.put(9,"Physical writes per Second");
		csvData.put(10,"Physical writes per Transaction");	
		csvData.put(11,"User calls per Second");
		csvData.put(12,"User calls per Transaction");	
		csvData.put(13,"Parses per Second");	
		csvData.put(14,"Parses per Transaction");
		csvData.put(15,"Hard Parses per Second");	
		csvData.put(16,"Hard Parses per Transaction");
		csvData.put(17,"Sorts per Second");
		csvData.put(18,"Sorts per Transaction");
		csvData.put(19,"Logons per Second");	
		csvData.put(20,"Logons per Transaction");	
		csvData.put(21,"Executes per Second");
		csvData.put(22,"Executes per Transaction");	
		csvData.put(23,"Transactions per Second");
		csvData.put(24,"Transactions  per Transaction ");	

		return csvData;
	}

	private static Map<Integer,String> getHeaderData(){
		Map <Integer,String> csvData=new HashMap<Integer, String>();
		csvData.put(0,"Begin time - End Time");
		csvData.put(1,"gc cr block 2-way Waits");	
		csvData.put(2,"gc cr block 2-way Time(s)");	
		csvData.put(3,"gc cr block 2-way Avg Wait(ms)");	
		csvData.put(4,"gc cr block 2-way % Total Call Time");
		csvData.put(5,"gc cr block 2-way Wait Class");	
		csvData.put(6,"log file sequential read Waits");	
		csvData.put(7,"log file sequential read Time(s)");	
		csvData.put(8,"log file sequential read Avg Wait(ms)");	
		csvData.put(9,"log file sequential read % Total Call Time");
		csvData.put(10,"log file sequential read Wait Class");	
		csvData.put(11,"enq: TX - row lock contention Waits");
		csvData.put(12,"enq: TX - row lock contention Time(s)");	
		csvData.put(13,"enq: TX - row lock contention Avg Wait(ms)");	
		csvData.put(14,"enq: TX - row lock contention % Total Call Time");
		csvData.put(15,"enq: TX - row lock contention Wait Class");	
		csvData.put(16,"latch: cache buffers chains Waits");
		csvData.put(17,"latch: cache buffers chains Time(s)");
		csvData.put(18,"latch: cache buffers chains Avg Wait(ms)");
		csvData.put(19,"latch: cache buffers chains % Total Call Time");	
		csvData.put(20,"latch: cache buffers chains Wait Class");	
		csvData.put(21,"library cache lock Waits");
		csvData.put(22,"library cache lock Time(s)");	
		csvData.put(23,"library cache lock Avg Wait(ms)");	
		csvData.put(24,"library cache lock % Total Call Time");
		csvData.put(25,"library cache lock Wait Class");	
		csvData.put(26,"enq: PS - contention Waits");	
		csvData.put(27,"enq: PS - contention Time(s)");
		csvData.put(28,"enq: PS - contention Avg Wait(ms)");	
		csvData.put(29,"enq: PS - contention % Total Call Time");
		csvData.put(30,"enq: PS - contention Wait Class");
		csvData.put(31,"db file scattered read Waits");
		csvData.put(32,"db file scattered read Time(s)");	
		csvData.put(33,"db file scattered read Avg Wait(ms)");
		csvData.put(34,"db file scattered read % Total Call Time");
		csvData.put(35,"db file scattered read Wait Class");	
		csvData.put(36,"Log archive I/O Waits");	
		csvData.put(37,"Log archive I/O Time(s)");
		csvData.put(38,"Log archive I/O Avg Wait(ms)");
		csvData.put(39,"Log archive I/O % Total Call Time");	
		csvData.put(40,"Log archive I/O Wait Class");
		csvData.put(41,"log file parallel write Waits");
		csvData.put(42,"log file parallel write Time(s)");
		csvData.put(43,"log file parallel write Avg Wait(ms)");	
		csvData.put(44,"log file parallel write % Total Call Time");	
		csvData.put(45,"log file parallel write Wait Class");	
		csvData.put(46,"enq: TC - contention Waits");	
		csvData.put(47,"enq: TC - contention Time(s)");	
		csvData.put(48,"enq: TC - contention Avg Wait(ms)");	
		csvData.put(49,"enq: TC - contention % Total Call Time");	
		csvData.put(50,"enq: TC - contention Wait Class");	
		csvData.put(51,"SQL*Net more data from client Waits");	
		csvData.put(52,"SQL*Net more data from client Time(s)");	
		csvData.put(53,"SQL*Net more data from client Avg Wait(ms)");	
		csvData.put(54,"SQL*Net more data from client % Total Call Time");	
		csvData.put(55,"SQL*Net more data from client Wait Class");
		csvData.put(56,"control file sequential read Waits");	
		csvData.put(57,"control file sequential read Time(s)");	
		csvData.put(58,"control file sequential read Avg Wait(ms)");	
		csvData.put(59,"control file sequential read % Total Call Time");	
		csvData.put(60,"control file sequential read Wait Class");	
		csvData.put(61,"enq: WF - contention Waits");	
		csvData.put(62,"enq: WF - contention Time(s)");
		csvData.put(63,"enq: WF - contention Avg Wait(ms)");	
		csvData.put(64,"enq: WF - contention % Total Call Time");	
		csvData.put(65,"enq: WF - contention Wait Class");	
		csvData.put(66,"CPU time Waits");	
		csvData.put(67,"CPU time Time(s)");
		csvData.put(68,"CPU time Avg Wait(ms)");	
		csvData.put(69,"CPU time % Total Call Time");	
		csvData.put(70,"CPU time Wait Class");	
		csvData.put(71,"PX Deq: reap credit Waits");	
		csvData.put(72,"PX Deq: reap credit Time(s)");	
		csvData.put(73,"PX Deq: reap credit Avg Wait(ms)");	
		csvData.put(74,"PX Deq: reap credit % Total Call Time");	
		csvData.put(75,"PX Deq: reap credit Wait Class");	
		csvData.put(76,"Data file init write Waits");	
		csvData.put(77,"Data file init write Time(s)");	
		csvData.put(78,"Data file init write Avg Wait(ms)");	
		csvData.put(79,"Data file init write % Total Call Time");	
		csvData.put(80,"Data file init write Wait Class");	
		csvData.put(81,"DFS lock handle Waits");	
		csvData.put(82,"DFS lock handle Time(s)");
		csvData.put(83,"DFS lock handle Avg Wait(ms)");
		csvData.put(84,"DFS lock handle % Total Call Time");	
		csvData.put(85,"DFS lock handle Wait Class");	
		csvData.put(86,"buffer busy waits Waits");
		csvData.put(87,"buffer busy waits Time(s)");	
		csvData.put(88,"buffer busy waits Avg Wait(ms)");	
		csvData.put(89,"buffer busy waits % Total Call Time");
		csvData.put(90,"buffer busy waits Wait Class");
		csvData.put(91,"gc current grant busy Waits");	
		csvData.put(92,"gc current grant busy Time(s)");	
		csvData.put(93,"gc current grant busy Avg Wait(ms)");	
		csvData.put(94," current grant busy % Total Call Time");	
		csvData.put(95,"gc current grant busy Wait Class");
		csvData.put(96,"log file sync Waits");
		csvData.put(97,"log file sync Time(s)");	
		csvData.put(98,"log file sync Avg Wait(ms)");	
		csvData.put(99,"log file sync % Total Call Time");	
		csvData.put(100,"log file sync Wait Class");
		csvData.put(101,"db file sequential read Waits");	
		csvData.put(102,"db file sequential read Time(s)");	
		csvData.put(103,"db file sequential read Avg Wait(ms)");	
		csvData.put(104,"db file sequential read % Total Call Time");	
		csvData.put(105,"db file sequential read Wait Class");	
		csvData.put(106,"reliable message Waits");	
		csvData.put(107,"reliable message Time(s)");
		csvData.put(108,"reliable message Avg Wait(ms)");	
		csvData.put(109,"reliable message % Total Call Time");	
		csvData.put(110,"reliable message Wait Class");
		csvData.put(111,"gc current block 2-way Waits");	
		csvData.put(112,"gc current block 2-way Time(s)");	
		csvData.put(113,"gc current block 2-way Avg Wait(ms)");	
		csvData.put(114,"gc current block 2-way % Total Call Time");
		csvData.put(115,"gc current block 2-way Wait Class");	
		csvData.put(116,"gc cr grant 2-way Waits");	
		csvData.put(117,"gc cr grant 2-way Time(s)");	
		csvData.put(118,"gc cr grant 2-way Avg Wait(ms)");	
		csvData.put(119,"gc cr grant 2-way % Total Call Time");	
		csvData.put(120,"gc cr grant 2-way Wait Class");
		csvData.put(121,"os thread startup Waits");	
		csvData.put(122,"os thread startup Time(s)");	
		csvData.put(123,"os thread startup Avg Wait(ms)");	
		csvData.put(124,"os thread startup % Total Call Time");	
		csvData.put(125,"os thread startup Wait Class");
		csvData.put(126,"enq: TX - allocate ITL entry Waits");	
		csvData.put(127,"enq: TX - allocate ITL entry Time(s)");	
		csvData.put(128,"enq: TX - allocate ITL entry Avg Wait(ms)");	
		csvData.put(129,"enq: TX - allocate ITL entry % Total Call Time");	
		csvData.put(130,"enq: TX - allocate ITL entry Wait Class");
		csvData.put(131,"db file parallel read Waits");	
		csvData.put(132,"db file parallel read Time(s)");	
		csvData.put(133,"db file parallel read Avg Wait(ms)");	
		csvData.put(134,"db file parallel read % Total Call Time");
		csvData.put(135,"db file parallel read Wait Class");	
		csvData.put(136,"read by other session Waits");
		csvData.put(137,"read by other session Time(s)");	
		csvData.put(138,"read by other session Avg Wait(ms)");	
		csvData.put(139,"read by other session % Total Call Time");
		csvData.put(140,"read by other session Wait Class");	
		csvData.put(141,"free buffer waits Waits");	
		csvData.put(142,"free buffer waits Time(s)");	
		csvData.put(143,"free buffer waits Avg Wait(ms)");	
		csvData.put(144,"free buffer waits % Total Call Time");	
		csvData.put(145,"free buffer waits Wait Class");	
		csvData.put(146,"row cache lock Waits");
		csvData.put(147,"row cache lock Time(s)");	
		csvData.put(149,"row cache lock Avg Wait(ms)");	
		csvData.put(150,"row cache lock % Total Call Time	");
		csvData.put(151,"row cache lock Wait Class");	
		csvData.put(152,"enq: TX - contention Waits");	
		csvData.put(153,"enq: TX - contention Time(s)");	
		csvData.put(154,"enq: TX - contention Avg Wait(ms)");	
		csvData.put(155,"enq: TX - contention % Total Call Time");	
		csvData.put(156,"enq: TX - contention Wait Class");	
		csvData.put(157,"enq: CF - contention Waits");	
		csvData.put(158,"enq: CF - contention Time(s)");	
		csvData.put(159,"enq: CF - contention Avg Wait(ms)");	
		csvData.put(160,"enq: CF - contention % Total Call Time");	
		csvData.put(161,"enq: CF - contention Wait Class");	
		csvData.put(162,"gc buffer busy Waits");
		csvData.put(163,"gc buffer busy Time(s)");	
		csvData.put(164,"gc buffer busy Avg Wait(ms)");	
		csvData.put(165,"gc buffer busy % Total Call Time");	
		csvData.put(166,"gc buffer busy Wait Class");	
		csvData.put(167,"enq: TX - index contention Waits");
		csvData.put(168,"enq: TX - index contention Time(s)");	
		csvData.put(169,"enq: TX - index contention Avg Wait(ms)");	
		csvData.put(170,"enq: TX - index contention % Total Call Time");	
		csvData.put(171,"enq: TX - index contention Wait Class");	
		csvData.put(172,"enq: HW - contention Waits");	
		csvData.put(173,"enq: HW - contention Time(s)");	
		csvData.put(174,"enq: HW - contention Avg Wait(ms)");	
		csvData.put(175,"enq: HW - contention % Total Call Time");	
		csvData.put(176,"enq: HW - contention Wait Class");	
		csvData.put(177,"PX Deq Credit: send blkd Waits");	
		csvData.put(178,"PX Deq Credit: send blkd Time(s)");	
		csvData.put(179,"PX Deq Credit: send blkd Avg Wait(ms)");	
		csvData.put(180,"PX Deq Credit: send blkd % Total Call Time");	
		csvData.put(181,"PX Deq Credit: send blkd Wait Class");	
		csvData.put(182,"gc cr multi block request Waits");	
		csvData.put(183,"gc cr multi block request Time(s)");	
		csvData.put(184,"gc cr multi block request Avg Wait(ms)");	
		csvData.put(185,"gc cr multi block request % Total Call Time");
		csvData.put(186,"gc cr multi block request Wait Class");
		return csvData;
	}
	
	static void loadProfile(Elements tables,String outputPath){
		try {

			String csvLocation="";//args[1];
			if(outputPath != null && !"".equals(outputPath)){
				csvLocation=outputPath+"load_profile_outputfile.csv";
			}
			if(outputPath == null || "".equals(outputPath.trim())){
				csvLocation = "C:\\awr\\AWRDataOutputFiles\\load_profile_outputfile.csv";
			}
			System.out.println("csvLocation::::" + csvLocation);
			int tableCount=0;
			List colsData = new ArrayList();
			String timePeriod="";
			Map<Integer,String> csvData=new HashMap<Integer, String>();
			FileWriter writer=null;
			File f= new File(csvLocation);
			if(!f.exists()){
				List colsMapHeader = new ArrayList();
				
				for(Map.Entry<Integer, String> map: getLoadProfileHeaderData().entrySet()){
					colsMapHeader.add(map.getValue());
				}
				writer = new FileWriter(csvLocation,true);
				CSVUtils.writeLine(writer, colsMapHeader);
				for(Integer i=0;i<25;i++){
					csvData.put(i, "0.00");
				}
				
			}else{
				writer = new FileWriter(csvLocation,true);
				for(Integer i=0;i<25;i++){
					csvData.put(i, "0.00");
				}
			}
			
			//File
			
			
			for (Element table : tables) {
				tableCount++;
				if(tableCount >4){
					break;
				}
				if(tableCount == 2|| tableCount==4){
				synchronized (table) {
					if(tableCount==2){
							Elements rows = table.select("tr");
							for (int i = 0; i < rows.size(); i++) { // first row is the
								Element row = rows.get(i);
								Elements cols = null;
								cols = row.select("td");
								if(i==3){
									csvData.put(0, timePeriod);
									break;
								}
								for (int j = 0; j < cols.size(); j++) {
									if(j==2){
										if("".equals(timePeriod)){
										timePeriod=timePeriod+cols.get(j).text();
										}else{
											timePeriod=timePeriod+" - "+cols.get(j).text();
										}
									}
									
		
								}
								
		
							}
					}else if(tableCount == 4){
						Elements rows = table.select("tr");
						boolean flag1=false;
						boolean flag2=false;
						boolean flag3=false;
						boolean flag4=false;
						
						
						boolean flag5=false;
						boolean flag6=false;
						boolean flag7=false;
						boolean flag8=false;
						
						boolean flag9=false;
						boolean flag10=false;
						boolean flag11=false;
						boolean flag12=false;
						for (int i = 0; i < rows.size(); i++) { // first row is the
							Element row = rows.get(i);
							Elements cols = null;
							cols = row.select("td");
							for (int j = 0; j < cols.size(); j++) {
								
								
								String value=cols.get(0).text();
								if(value != null && "Redo size:".equals(value)){
									flag1=true;
								}else if(value != null && "Logical reads:".equals(value)){
									flag2=true;
								}else if(value != null && "Block changes:".equals(value.trim())){
									flag3=true;
								}else if(value != null && "Physical reads:".equals(value.trim())){
									flag4=true;
								}else if(value != null && "Physical writes:".equals(value.trim())){
									flag5=true;
								}else if(value != null && "User calls:".equals(value)){
									flag6=true;
								}else if(value != null && "Parses:".equals(value)){
									flag7=true;
								}else if(value != null && "Hard parses:".equals(value.trim())){
									flag8=true;
								}else if(value != null && "Sorts:".equals(value.trim())){
									flag9=true;
								}else if(value != null && "Logons:".equals(value.trim())){
									flag10=true;
								}else if(value != null && "Executes:".equals(value.trim())){
									flag11=true;
								}else if(value != null && "Transactions:".equals(value.trim())){
									flag12=true;
								}
								
								if(flag1){
									csvData.put(1, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(2, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag2){
									csvData.put(3, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(4, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag3){
									csvData.put(5, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(6, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag4){
									csvData.put(7, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(8, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag5){
									csvData.put(9, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(10, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag6){
									csvData.put(11, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(12, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag7){
									csvData.put(13, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(14, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag8){
									csvData.put(15, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(16, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag9){
									csvData.put(17, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(18, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag10){
									csvData.put(19, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(20, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag11){
									csvData.put(21, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(22, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag12){
									csvData.put(23, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(24, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								
								/*if(j==1 || j==2){
									if(cols.get(j).text() != null && !"".equals(cols.get(j).text().trim())){
										colsData.add(cols.get(j).text().replace("\u00a0", ""));
									}else{
										colsData.add("0");
									}
								}*/
								flag1=false;
								flag2=false;
								flag3=false;
								flag4=false;
								flag5=false;
								flag6=false;
								flag7=false;
								flag8=false;
								flag9=false;
								flag10=false;
								flag11=false;
								flag12=false;
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
