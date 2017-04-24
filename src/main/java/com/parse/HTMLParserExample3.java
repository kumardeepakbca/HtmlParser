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

public class HTMLParserExample3 {

	public static void main(String[] args) {

		String htmlPath ="";// args[0];
		
		if(htmlPath == null || "".equals(htmlPath.trim())){
			htmlPath = "C:\\awr\\AWRDataProgramFiles\\AWR.html";
		}
		System.out.println("htmlPath:::::" + htmlPath);

		File htmlf= new File(htmlPath);
		boolean isHtmlExist=true;
		if(!htmlf.exists()){
			isHtmlExist=false;
			System.out.println("Please check html file present on the given path");
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

			String csvPath = "";
			String csvLocation="";//args[1];
			if(csvLocation == null || "".equals(csvLocation.trim())){
				csvLocation = "C:\\awr\\AWRDataOutputFiles\\load_profile_outputfile.csv";
			}
			System.out.println("csvLocation::::" + csvLocation);

			System.out.println("csvLocation::::" + csvLocation);
			Document doc = Jsoup.parse(content);

			Elements tables = doc.select("table");

			System.out.println(tables.size()
					+ ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			int tableCount=0;
			List colsData = new ArrayList();
			String timePeriod="";
			Map<Integer,String> csvData=new HashMap<Integer, String>();
			FileWriter writer=null;
			File f= new File(csvLocation);
			if(!f.exists()){
				List colsMapHeader = new ArrayList();
				
				for(Map.Entry<Integer, String> map: getHeaderData().entrySet()){
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
	private static Map<Integer,String> getHeaderData(){
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

}
