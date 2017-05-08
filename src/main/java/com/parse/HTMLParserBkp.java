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

public class HTMLParserBkp{

	public static void main(String[] args) {
		String htmlPath =args[0];
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
			Document doc = Jsoup.parse(content);
			Elements tables = doc.select("table");
			if(tables != null ){
					loadProfile(tables,args[1]);
					loadTableSpaceIostats(tables,args[1]);
					loadTop5timedEvents(tables,args[1]);
			}

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
	static void loadTop5timedEvents(Elements tables,String outputPath){
		try {
		Map<Integer,String> csvData=new HashMap<Integer, String>();
		
		String csvLocation=outputPath+"top5timed_events.csv";
		if(outputPath == null || "".equals(outputPath.trim())){
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
								//csvData.put(27, timePeriod);
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
	
	static void loadTableSpaceIostats(Elements tables,String outputPath){
		try {

			String csvLocation="";
			if(outputPath != null && !"".equals(outputPath)){
				csvLocation=outputPath+"tablespace_iostats_outputfile.csv";
			}
			if(outputPath == null || "".equals(outputPath.trim())){
				csvLocation = "C:\\awr\\AWRDataOutputFiles\\tablespace_iostats_outputfile.csv";
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
				
				for(Map.Entry<Integer, String> map: getIOStatsHeaderData().entrySet()){
					colsMapHeader.add(map.getValue());
				}
				writer = new FileWriter(csvLocation,true);
				CSVUtils.writeLine(writer, colsMapHeader);
				for(Integer i=0;i<=295;i++){
					csvData.put(i, "0.00");
				}
				
			}else{
				writer = new FileWriter(csvLocation,true);
				for(Integer i=0;i<=295;i++){
					csvData.put(i, "0.00");
				}
			}
			
			//File
			
			
			for (Element table : tables) {
				tableCount++;
				if(tableCount >33){
					break;
				}
				if(tableCount == 2|| tableCount==33){
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
					}else if(tableCount == 33){
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
						boolean flag29=false;
						boolean flag30=false;
						boolean flag31=false;
						boolean flag32=false;
						boolean flag33=false;
						boolean flag34=false;
						boolean flag35=false;
						boolean flag36=false;
						boolean flag37=false;
						boolean flag38=false;
						boolean flag39=false;
						boolean flag40=false;
						boolean flag41=false;
						boolean flag42=false;
						boolean flag43=false;
						
						for (int i = 0; i < rows.size(); i++) { // first row is the
							Element row = rows.get(i);
							Elements cols = null;
							cols = row.select("td");
							for (int j = 0; j < cols.size(); j++) {
								
								
								String value=cols.get(0).text();
								if(value != null && "CRELSCM_DATA".equals(value)){
									flag1=true;
								}else if(value != null && "CRELSCM_INDX2".equals(value)){
									flag2=true;
								}else if(value != null && "CRELSCM_INDX".equals(value.trim())){
									flag3=true;
								}else if(value != null && "TEMP03".equals(value.trim())){
									flag4=true;
								}else if(value != null && "CRELSCM_LOB".equals(value.trim())){
									flag5=true;
								}else if(value != null && "UNDOTBS4".equals(value)){
									flag6=true;
								}else if(value != null && "CRELSCM_INDX3".equals(value)){
									flag7=true;
								}else if(value != null && "CRELSCM_LOB2".equals(value.trim())){
									flag8=true;
								}else if(value != null && "CRELSCM_SHD2".equals(value.trim())){
									flag9=true;
								}else if(value != null && "CRELSCM_SHD".equals(value.trim())){
									flag10=true;
								}else if(value != null && "SYSAUX".equals(value.trim())){
									flag11=true;
								}else if(value != null && "SYSTEM".equals(value.trim())){
									flag12=true;
								}else if(value != null && "UNDOTBS2".equals(value)){
									flag13=true;
								}else if(value != null && "CRELSCMS_DATA".equals(value.trim())){
									flag14=true;
								}else if(value != null && "UNDOTBS1".equals(value.trim())){
									flag15=true;
								}else if(value != null && "CRELSOMS_LOB".equals(value.trim())){
									flag16=true;
								}else if(value != null && "CRELSCMS_SHD".equals(value)){
									flag17=true;
								}else if(value != null && "UNDOTBS3".equals(value)){
									flag18=true;
								}else if(value != null && "CRELSCMS_INDX".equals(value.trim())){
									flag19=true;
								}else if(value != null && "CRELSCMS_LOB".equals(value.trim())){
									flag20=true;
								}else if(value != null && "CRELSOMS_DATA".equals(value.trim())){
									flag21=true;
								}else if(value != null && "USERS2".equals(value.trim())){
									flag22=true;
								}else if(value != null && "CRELSOMS_INDX".equals(value.trim())){
									flag23=true;
								}else if(value != null && "CRELSOMS_SHD".equals(value)){
									flag24=true;
								}else if(value != null && "TIVOLIORTS".equals(value.trim())){
									flag25=true;
								}else if(value != null && "CRELSCM_DATA3".equals(value.trim())){
									flag26=true;
								}else if(value != null && "USERS".equals(value.trim())){
									flag27=true;
								}else if(value != null && "CRELSCMS_LOB1".equals(value)){
									flag28=true;
								}else if(value != null && "CRELSCMS_LOB2".equals(value)){
									flag29=true;
								}else if(value != null && "CRELSCMS_LOB3".equals(value.trim())){
									flag30=true;
								}else if(value != null && "CRELSCMS_LOB4".equals(value.trim())){
									flag31=true;
								}else if(value != null && "CRELSCM_DATA1".equals(value.trim())){
									flag32=true;
								}else if(value != null && "CRELSCM_DATA2".equals(value.trim())){
									flag33=true;
								}else if(value != null && "CRELSCM_LOB1".equals(value.trim())){
									flag34=true;
								}else if(value != null && "CRELSCM_LOB3".equals(value)){
									flag35=true;
								}else if(value != null && "CRELSCM_LOB4".equals(value.trim())){
									flag36=true;
								}else if(value != null && "TEST_TS".equals(value.trim())){
									flag37=true;
								}
								
								if(flag1){
									csvData.put(1, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(2, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(3, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(4, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(5, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(6, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(7, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(8, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag2){
									csvData.put(9, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(10, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(11, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(12, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(13, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(14, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(15, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(16, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag3){
									csvData.put(17, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(18, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(19, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(20, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(21, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(22, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(23, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(24, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag4){
									csvData.put(25, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(26, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(27, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(28, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(29, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(30, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(31, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(32, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag5){
									csvData.put(33, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(34, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(35, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(36, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(37, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(38, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(39, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(40, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag6){
									csvData.put(41, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(42, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(43, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(44, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(45, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(46, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(47, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(48, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag7){
									csvData.put(49, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(50, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(51, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(52, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(53, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(54, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(55, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(56, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag8){
									csvData.put(57, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(58, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(59, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(60, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(61, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(62, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(63, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(64, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag9){
									csvData.put(65, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(66, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(67, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(68, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(69, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(70, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(71, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(72, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag10){
									csvData.put(73, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(74, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(75, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(76, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(77, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(78, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(79, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(80, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag11){
									csvData.put(81, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(82, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(83, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(84, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(85, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(86, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(87, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(88, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag12){
									csvData.put(89, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(90, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(91, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(92, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(93, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(94, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(95, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(96, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag13){
									csvData.put(97, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(98, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(99, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(100, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(101, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(102, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(103, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(104, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag14){
									csvData.put(105, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(106, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(107, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(108, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(109, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(110, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(111, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(112, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag15){
									csvData.put(113, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(114, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(115, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(116, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(117, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(118, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(119, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(120, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag16){
									csvData.put(121, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(122, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(123, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(124, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(125, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(126, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(127, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(128, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag17){
									csvData.put(129, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(130, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(131, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(132, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(133, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(134, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(135, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(136, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag18){
									csvData.put(137, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(138, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(139, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(140, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(141, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(142, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(143, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(144, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								
								if(flag19){
									csvData.put(145, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(146, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(147, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(148, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(149, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(150, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(151, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(152, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag20){
									csvData.put(153, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(154, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(155, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(156, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(157, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(158, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(159, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(160, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag21){
									csvData.put(161, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(162, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(163, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(164, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(165, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(166, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(167, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(168, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag22){
									csvData.put(169, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(170, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(171, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(172, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(173, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(174, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(175, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(176, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag23){
									csvData.put(177, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(178, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(179, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(180, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(181, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(182, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(183, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(184, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag24){
									csvData.put(185, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(186, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(187, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(188, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(189, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(190, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(191, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(192, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag25){
									csvData.put(193, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(194, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(195, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(196, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(197, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(198, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(199, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(200, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag26){
									csvData.put(201, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(202, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(203, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(204, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(205, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(206, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(207, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(208, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag27){
									csvData.put(209, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(210, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(211, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(212, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(213, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(214, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(215, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(216, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag28){
									csvData.put(217, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(218, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(219, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(220, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(221, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(222, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(223, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(224, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag29){
									csvData.put(225, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(226, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(227, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(228, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(229, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(230, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(231, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(232, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag30){
									csvData.put(233, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(234, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(235, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(236, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(237, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(238, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(239, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(240, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag31){
									csvData.put(241, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(242, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(243, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(244, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(245, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(246, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(247, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(248, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag32){
									csvData.put(249, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(250, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(251, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(252, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(253, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(254, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(255, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(256, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag33){
									csvData.put(257, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(258, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(259, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(260, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(261, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(262, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(263, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(264, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag34){
									csvData.put(265, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(266, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(267, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(268, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(269, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(270, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(271, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(272, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag35){
									csvData.put(273, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(274, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(275, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(276, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(277, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(278, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(279, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(280, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag36){
									csvData.put(281, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(282, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(283, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(284, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(285, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(286, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(287, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(288, cols.get(8).text().replace("\u00a0", "").replaceAll(",", ""));
								}
								if(flag37){
									csvData.put(289, cols.get(1).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(290, cols.get(2).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(291, cols.get(3).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(292, cols.get(4).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(293, cols.get(5).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(294, cols.get(6).text().replace("\u00a0", "").replaceAll(",", ""));
									csvData.put(295, cols.get(7).text().replace("\u00a0", "").replaceAll(",", ""));
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
								flag29=false;
								flag30=false;
								flag31=false;
								flag32=false;
								flag33=false;
								flag34=false;
								flag35=false;
								flag36=false;
								flag37=false;
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
	private static Map<Integer,String> getIOStatsHeaderData(){
		Map <Integer,String> csvData=new HashMap<Integer, String>();
		csvData.put(0,"Begin time - End Time");
		csvData.put(1,"CRELSCM_DATA Reads");
		csvData.put(2,"CRELSCM_DATA Av Reads/s");
		csvData.put(3,"CRELSCM_DATA Av Rd(ms)");
		csvData.put(4,"CRELSCM_DATA Av Blks/Rd");
		csvData.put(5,"CRELSCM_DATA Writes");
		csvData.put(6,"CRELSCM_DATA Av Writes/s");
		csvData.put(7,"CRELSCM_DATA Buffer Waits");
		csvData.put(8,"CRELSCM_DATA Av Buf Wt(ms)");
		csvData.put(9,"CRELSCM_INDX2 Reads");
		csvData.put(10,"CRELSCM_INDX2 Av Reads/s");
		csvData.put(11,"CRELSCM_INDX2 Av Rd(ms)");
		csvData.put(12,"CRELSCM_INDX2 Av Blks/Rd");
		csvData.put(13,"CRELSCM_INDX2 Writes");
		csvData.put(14,"CRELSCM_INDX2 Av Writes/s");
		csvData.put(15,"CRELSCM_INDX2 Buffer Waits");
		csvData.put(16,"CRELSCM_INDX2 Av Buf Wt(ms)");
		csvData.put(17,"CRELSCM_INDX Reads");
		csvData.put(18,"CRELSCM_INDX Av Reads/s");
		csvData.put(19,"CRELSCM_INDX Av Rd(ms)");
		csvData.put(20,"CRELSCM_INDX Av Blks/Rd");
		csvData.put(21,"CRELSCM_INDX Writes");
		csvData.put(22,"CRELSCM_INDX Av Writes/s");
		csvData.put(23,"CRELSCM_INDX Buffer Waits");
		csvData.put(24,"CRELSCM_INDX Av Buf Wt(ms)");
		csvData.put(25,"TEMP03 Reads");
		csvData.put(26,"TEMP03 Av Reads/s");
		csvData.put(27,"TEMP03 Av Rd(ms)");
		csvData.put(28,"TEMP03 Av Blks/Rd");
		csvData.put(29,"TEMP03 Writes");
		csvData.put(30,"TEMP03 Av Writes/s");
		csvData.put(31,"TEMP03 Buffer Waits");
		csvData.put(32,"TEMP03 Av Buf Wt(ms)");
		csvData.put(33,"CRELSCM_LOB Reads");
		csvData.put(34,"CRELSCM_LOB Av Reads/s");
		csvData.put(35,"CRELSCM_LOB Av Rd(ms)");
		csvData.put(36,"CRELSCM_LOB Av Blks/Rd");
		csvData.put(37,"CRELSCM_LOB Writes");
		csvData.put(38,"CRELSCM_LOB Av Writes/s");
		csvData.put(39,"CRELSCM_LOB Buffer Waits");
		csvData.put(40,"CRELSCM_LOB Av Buf Wt(ms)");
		csvData.put(41,"UNDOTBS4 Reads");
		csvData.put(42,"UNDOTBS4 Av Reads/s");
		csvData.put(43,"UNDOTBS4 Av Rd(ms)");
		csvData.put(44,"UNDOTBS4 Av Blks/Rd");
		csvData.put(45,"UNDOTBS4 Writes");
		csvData.put(46,"UNDOTBS4 Av Writes/s");
		csvData.put(47,"UNDOTBS4 Buffer Waits");
		csvData.put(48,"UNDOTBS4 Av Buf Wt(ms)");
		csvData.put(49,"CRELSCM_INDX3 Reads");
		csvData.put(50,"CRELSCM_INDX3 Av Reads/s");
		csvData.put(51,"CRELSCM_INDX3 Av Rd(ms)");
		csvData.put(52,"CRELSCM_INDX3 Av Blks/Rd");
		csvData.put(53,"CRELSCM_INDX3 Writes");
		csvData.put(54,"CRELSCM_INDX3 Av Writes/s");
		csvData.put(55,"CRELSCM_INDX3 Buffer Waits");
		csvData.put(56,"CRELSCM_INDX3 Av Buf Wt(ms)");
		csvData.put(57,"CRELSCM_LOB2 Reads");
		csvData.put(58,"CRELSCM_LOB2 Av Reads/s");
		csvData.put(59,"CRELSCM_LOB2 Av Rd(ms)");
		csvData.put(60,"CRELSCM_LOB2 Av Blks/Rd");
		csvData.put(61,"CRELSCM_LOB2 Writes");
		csvData.put(62,"CRELSCM_LOB2 Av Writes/s");
		csvData.put(63,"CRELSCM_LOB2 Buffer Waits");
		csvData.put(64,"CRELSCM_LOB2 Av Buf Wt(ms)");
		csvData.put(65,"CRELSCM_SHD2 Reads");
		csvData.put(66,"CRELSCM_SHD2 Av Reads/s");
		csvData.put(67,"CRELSCM_SHD2 Av Rd(ms)");
		csvData.put(68,"CRELSCM_SHD2 Av Blks/Rd");
		csvData.put(69,"CRELSCM_SHD2 Writes");
		csvData.put(70,"CRELSCM_SHD2 Av Writes/s");
		csvData.put(71,"CRELSCM_SHD2 Buffer Waits");
		csvData.put(72,"CRELSCM_SHD2 Av Buf Wt(ms)");
		csvData.put(73,"CRELSCM_SHD Reads");
		csvData.put(74,"CRELSCM_SHD Av Reads/s");
		csvData.put(75,"CRELSCM_SHD Av Rd(ms)");
		csvData.put(76,"CRELSCM_SHD Av Blks/Rd");
		csvData.put(77,"CRELSCM_SHD Writes");
		csvData.put(78,"CRELSCM_SHD Av Writes/s");
		csvData.put(79,"CRELSCM_SHD Buffer Waits");
		csvData.put(80,"CRELSCM_SHD Av Buf Wt(ms)");
		csvData.put(81,"SYSAUX Reads");
		csvData.put(82,"SYSAUX Av Reads/s");
		csvData.put(83,"SYSAUX Av Rd(ms)");
		csvData.put(84,"SYSAUX Av Blks/Rd");
		csvData.put(85,"SYSAUX Writes");
		csvData.put(86,"SYSAUX Av Writes/s");
		csvData.put(87,"SYSAUX Buffer Waits");
		csvData.put(88,"SYSAUX Av Buf Wt(ms)");
		csvData.put(89,"SYSTEM Reads");
		csvData.put(90,"SYSTEM Av Reads/s");
		csvData.put(91,"SYSTEM Av Rd(ms)");
		csvData.put(92,"SYSTEM Av Blks/Rd");
		csvData.put(93,"SYSTEM Writes");
		csvData.put(94,"SYSTEM Av Writes/s");
		csvData.put(95,"SYSTEM Buffer Waits");
		csvData.put(96,"SYSTEM Av Buf Wt(ms)");
		csvData.put(97,"UNDOTBS2 Reads");
		csvData.put(98,"UNDOTBS2 Av Reads/s");
		csvData.put(99,"UNDOTBS2 Av Rd(ms)");
		csvData.put(100,"UNDOTBS2 Av Blks/Rd");
		csvData.put(101,"UNDOTBS2 Writes");
		csvData.put(102,"UNDOTBS2 Av Writes/s");
		csvData.put(103,"UNDOTBS2 Buffer Waits");
		csvData.put(104,"UNDOTBS2 Av Buf Wt(ms)");
		csvData.put(105,"CRELSCMS_DATA Reads");
		csvData.put(106,"CRELSCMS_DATA Av Reads/s");
		csvData.put(107,"CRELSCMS_DATA Av Rd(ms)");
		csvData.put(108,"CRELSCMS_DATA Av Blks/Rd");
		csvData.put(109,"CRELSCMS_DATA Writes");
		csvData.put(110,"CRELSCMS_DATA Av Writes/s");
		csvData.put(111,"CRELSCMS_DATA Buffer Waits");
		csvData.put(112,"CRELSCMS_DATA Av Buf Wt(ms)");
		csvData.put(113,"UNDOTBS1 Reads");
		csvData.put(114,"UNDOTBS1 Av Reads/s");
		csvData.put(115,"UNDOTBS1 Av Rd(ms)");
		csvData.put(116,"UNDOTBS1 Av Blks/Rd");
		csvData.put(117,"UNDOTBS1 Writes");
		csvData.put(118,"UNDOTBS1 Av Writes/s");
		csvData.put(119,"UNDOTBS1 Buffer Waits");
		csvData.put(120,"UNDOTBS1 Av Buf Wt(ms)");
		csvData.put(121,"CRELSOMS_LOB Reads");
		csvData.put(122,"CRELSOMS_LOB Av Reads/s");
		csvData.put(123,"CRELSOMS_LOB Av Rd(ms)");
		csvData.put(124,"CRELSOMS_LOB Av Blks/Rd");
		csvData.put(125,"CRELSOMS_LOB Writes");
		csvData.put(126,"CRELSOMS_LOB Av Writes/s");
		csvData.put(127,"CRELSOMS_LOB Buffer Waits");
		csvData.put(128,"CRELSOMS_LOB Av Buf Wt(ms)");
		csvData.put(129,"CRELSCMS_SHD Reads");
		csvData.put(130,"CRELSCMS_SHD Av Reads/s");
		csvData.put(131,"CRELSCMS_SHD Av Rd(ms)");
		csvData.put(132,"CRELSCMS_SHD Av Blks/Rd");
		csvData.put(133,"CRELSCMS_SHD Writes");
		csvData.put(134,"CRELSCMS_SHD Av Writes/s");
		csvData.put(135,"CRELSCMS_SHD Buffer Waits");
		csvData.put(136,"CRELSCMS_SHD Av Buf Wt(ms)");
		csvData.put(137,"UNDOTBS3 Reads");
		csvData.put(138,"UNDOTBS3 Av Reads/s");
		csvData.put(139,"UNDOTBS3 Av Rd(ms)");
		csvData.put(140,"UNDOTBS3 Av Blks/Rd");
		csvData.put(141,"UNDOTBS3 Writes");
		csvData.put(142,"UNDOTBS3 Av Writes/s");
		csvData.put(143,"UNDOTBS3 Buffer Waits");
		csvData.put(144,"UNDOTBS3 Av Buf Wt(ms)");
		csvData.put(145,"CRELSCMS_INDX Reads");
		csvData.put(146,"CRELSCMS_INDX Av Reads/s");
		csvData.put(147,"CRELSCMS_INDX Av Rd(ms)");
		csvData.put(148,"CRELSCMS_INDX Av Blks/Rd");
		csvData.put(149,"CRELSCMS_INDX Writes");
		csvData.put(150,"CRELSCMS_INDX Av Writes/s");
		csvData.put(151,"CRELSCMS_INDX Buffer Waits");
		csvData.put(152,"CRELSCMS_INDX Av Buf Wt(ms)");
		csvData.put(153,"CRELSCMS_LOB Reads");
		csvData.put(154,"CRELSCMS_LOB Av Reads/s");
		csvData.put(155,"CRELSCMS_LOB Av Rd(ms)");
		csvData.put(156,"CRELSCMS_LOB Av Blks/Rd");
		csvData.put(157,"CRELSCMS_LOB Writes");
		csvData.put(158,"CRELSCMS_LOB Av Writes/s");
		csvData.put(159,"CRELSCMS_LOB Buffer Waits");
		csvData.put(160,"CRELSCMS_LOB Av Buf Wt(ms)");
		csvData.put(161,"CRELSOMS_DATA Reads");
		csvData.put(162,"CRELSOMS_DATA Av Reads/s");
		csvData.put(163,"CRELSOMS_DATA Av Rd(ms)");
		csvData.put(164,"CRELSOMS_DATA Av Blks/Rd");
		csvData.put(165,"CRELSOMS_DATA Writes");
		csvData.put(166,"CRELSOMS_DATA Av Writes/s");
		csvData.put(167,"CRELSOMS_DATA Buffer Waits");
		csvData.put(168,"CRELSOMS_DATA Av Buf Wt(ms)");
		csvData.put(169,"USERS2 Reads");
		csvData.put(170,"USERS2 Av Reads/s");
		csvData.put(171,"USERS2 Av Rd(ms)");
		csvData.put(172,"USERS2 Av Blks/Rd");
		csvData.put(173,"USERS2 Writes");
		csvData.put(174,"USERS2 Av Writes/s");
		csvData.put(175,"USERS2 Buffer Waits");
		csvData.put(176,"USERS2 Av Buf Wt(ms)");
		csvData.put(177,"CRELSOMS_INDX Reads");
		csvData.put(178,"CRELSOMS_INDX Av Reads/s");
		csvData.put(179,"CRELSOMS_INDX Av Rd(ms)");
		csvData.put(180,"CRELSOMS_INDX Av Blks/Rd");
		csvData.put(181,"CRELSOMS_INDX Writes");
		csvData.put(182,"CRELSOMS_INDX Av Writes/s");
		csvData.put(183,"CRELSOMS_INDX Buffer Waits");
		csvData.put(184,"CRELSOMS_INDX Av Buf Wt(ms)");
		csvData.put(185,"CRELSOMS_SHD Reads");
		csvData.put(186,"CRELSOMS_SHD Av Reads/s");
		csvData.put(187,"CRELSOMS_SHD Av Rd(ms)");
		csvData.put(188,"CRELSOMS_SHD Av Blks/Rd");
		csvData.put(189,"CRELSOMS_SHD Writes");
		csvData.put(190,"CRELSOMS_SHD Av Writes/s");
		csvData.put(191,"CRELSOMS_SHD Buffer Waits");
		csvData.put(192,"CRELSOMS_SHD Av Buf Wt(ms)");
		csvData.put(193,"TIVOLIORTS Reads");
		csvData.put(194,"TIVOLIORTS Av Reads/s");
		csvData.put(195,"TIVOLIORTS Av Rd(ms)");
		csvData.put(196,"TIVOLIORTS Av Blks/Rd");
		csvData.put(197,"TIVOLIORTS Writes");
		csvData.put(198,"TIVOLIORTS Av Writes/s");
		csvData.put(199,"TIVOLIORTS Buffer Waits");
		csvData.put(200,"TIVOLIORTS Av Buf Wt(ms)");
		csvData.put(201,"CRELSCM_DATA3 Reads");
		csvData.put(202,"CRELSCM_DATA3 Av Reads/s");
		csvData.put(203,"CRELSCM_DATA3 Av Rd(ms)");
		csvData.put(204,"CRELSCM_DATA3 Av Blks/Rd");
		csvData.put(205,"CRELSCM_DATA3 Writes");
		csvData.put(206,"CRELSCM_DATA3 Av Writes/s");
		csvData.put(207,"CRELSCM_DATA3 Buffer Waits");
		csvData.put(208,"CRELSCM_DATA3 Av Buf Wt(ms)");
		csvData.put(209,"USERS Reads");
		csvData.put(210,"USERS Av Reads/s");
		csvData.put(211,"USERS Av Rd(ms)");
		csvData.put(212,"USERS Av Blks/Rd");
		csvData.put(213,"USERS Writes");
		csvData.put(214,"USERS Av Writes/s");
		csvData.put(215,"USERS Buffer Waits");
		csvData.put(216,"USERS Av Buf Wt(ms)");
		csvData.put(217,"CRELSCMS_LOB1 Reads");
		csvData.put(218,"CRELSCMS_LOB1 Av Reads/s");
		csvData.put(219,"CRELSCMS_LOB1 Av Rd(ms)");
		csvData.put(220,"CRELSCMS_LOB1 Av Blks/Rd");
		csvData.put(221,"CRELSCMS_LOB1 Writes");
		csvData.put(222,"CRELSCMS_LOB1 Av Writes/s");
		csvData.put(223,"CRELSCMS_LOB1 Buffer Waits");
		csvData.put(224,"CRELSCMS_LOB1 Av Buf Wt(ms)");
		csvData.put(225,"CRELSCMS_LOB2 Reads");
		csvData.put(226,"CRELSCMS_LOB2 Av Reads/s");
		csvData.put(227,"CRELSCMS_LOB2 Av Rd(ms)");
		csvData.put(228,"CRELSCMS_LOB2 Av Blks/Rd");
		csvData.put(229,"CRELSCMS_LOB2 Writes");
		csvData.put(230,"CRELSCMS_LOB2 Av Writes/s");
		csvData.put(231,"CRELSCMS_LOB2 Buffer Waits");
		csvData.put(232,"CRELSCMS_LOB2 Av Buf Wt(ms)");
		csvData.put(233,"CRELSCMS_LOB3 Reads");
		csvData.put(234,"CRELSCMS_LOB3 Av Reads/s");
		csvData.put(235,"CRELSCMS_LOB3 Av Rd(ms)");
		csvData.put(236,"CRELSCMS_LOB3 Av Blks/Rd");
		csvData.put(237,"CRELSCMS_LOB3 Writes");
		csvData.put(238,"CRELSCMS_LOB3 Av Writes/s");
		csvData.put(239,"CRELSCMS_LOB3 Buffer Waits");
		csvData.put(240,"CRELSCMS_LOB3 Av Buf Wt(ms)");
		csvData.put(241,"CRELSCMS_LOB4 Reads");
		csvData.put(242,"CRELSCMS_LOB4 Av Reads/s");
		csvData.put(243,"CRELSCMS_LOB4 Av Rd(ms)");
		csvData.put(244,"CRELSCMS_LOB4 Av Blks/Rd");
		csvData.put(245,"CRELSCMS_LOB4 Writes");
		csvData.put(246,"CRELSCMS_LOB4 Av Writes/s");
		csvData.put(247,"CRELSCMS_LOB4 Buffer Waits");
		csvData.put(248,"CRELSCMS_LOB4 Av Buf Wt(ms)");
		csvData.put(249,"CRELSCM_DATA1 Reads");
		csvData.put(250,"CRELSCM_DATA1 Av Reads/s");
		csvData.put(251,"CRELSCM_DATA1 Av Rd(ms)");
		csvData.put(252,"CRELSCM_DATA1 Av Blks/Rd");
		csvData.put(253,"CRELSCM_DATA1 Writes");
		csvData.put(254,"CRELSCM_DATA1 Av Writes/s");
		csvData.put(255,"CRELSCM_DATA1 Buffer Waits");
		csvData.put(256,"CRELSCM_DATA1 Av Buf Wt(ms)");
		csvData.put(257,"CRELSCM_DATA2 Reads");
		csvData.put(258,"CRELSCM_DATA2 Av Reads/s");
		csvData.put(259,"CRELSCM_DATA2 Av Rd(ms)");
		csvData.put(260,"CRELSCM_DATA2 Av Blks/Rd");
		csvData.put(261,"CRELSCM_DATA2 Writes");
		csvData.put(262,"CRELSCM_DATA2 Av Writes/s");
		csvData.put(263,"CRELSCM_DATA2 Buffer Waits");
		csvData.put(264,"CRELSCM_DATA2 Av Buf Wt(ms)");
		csvData.put(265,"CRELSCM_LOB1 Reads");
		csvData.put(266,"CRELSCM_LOB1 Av Reads/s");
		csvData.put(267,"CRELSCM_LOB1 Av Rd(ms)");
		csvData.put(268,"CRELSCM_LOB1 Av Blks/Rd");
		csvData.put(269,"CRELSCM_LOB1 Writes");
		csvData.put(270,"CRELSCM_LOB1 Av Writes/s");
		csvData.put(271,"CRELSCM_LOB1 Buffer Waits");
		csvData.put(272,"CRELSCM_LOB1 Av Buf Wt(ms)");
		csvData.put(273,"CRELSCM_LOB3 Reads");
		csvData.put(274,"CRELSCM_LOB3 Av Reads/s");
		csvData.put(275,"CRELSCM_LOB3 Av Rd(ms)");
		csvData.put(276,"CRELSCM_LOB3 Av Blks/Rd");
		csvData.put(277,"CRELSCM_LOB3 Writes");
		csvData.put(278,"CRELSCM_LOB3 Av Writes/s");
		csvData.put(279,"CRELSCM_LOB3 Buffer Waits");
		csvData.put(280,"CRELSCM_LOB3 Av Buf Wt(ms)");
		csvData.put(281,"CRELSCM_LOB4 Reads");
		csvData.put(282,"CRELSCM_LOB4 Av Reads/s");
		csvData.put(283,"CRELSCM_LOB4 Av Rd(ms)");
		csvData.put(284,"CRELSCM_LOB4 Av Blks/Rd");
		csvData.put(285,"CRELSCM_LOB4 Writes");
		csvData.put(286,"CRELSCM_LOB4 Av Writes/s");
		csvData.put(287,"CRELSCM_LOB4 Buffer Waits");
		csvData.put(288,"CRELSCM_LOB4 Av Buf Wt(ms)");
		csvData.put(289,"TEST_TS Reads");
		csvData.put(290,"TEST_TS Av Reads/s");
		csvData.put(291,"TEST_TS Av Rd(ms)");
		csvData.put(292,"TEST_TS Av Blks/Rd");
		csvData.put(293,"TEST_TS Writes");
		csvData.put(294,"TEST_TS Av Writes/s");
		csvData.put(295,"TEST_TS Buffer Waits ");
		return csvData;
	}
}
