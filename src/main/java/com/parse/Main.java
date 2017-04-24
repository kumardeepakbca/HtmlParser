package com.parse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.parse.CSVUtils;

public class Main {
	private static final String NEW_LINE_SEPARATOR = "\n";

	public static void main(String[] args) {

		String content = "";
		try {
			BufferedReader in = new BufferedReader(new FileReader(
					"D:/HTML_TO_CSV/TableCSVExport-master/AWR.html"));
			String str;
			while ((str = in.readLine()) != null) {
				content += str;
			}
			in.close();
		} catch (IOException e) {
		}

		try {

			// initialize FileWriter object
			String csvFile = "D:\\table4.csv";
			FileWriter writer = new FileWriter(csvFile);

			Document doc = Jsoup.parse(content);
			System.out.println(doc + ">>>>>>>>>>");
			Element table = doc.select("table").get(0);
			Elements rows = table.select("tr");
			
			for (int i = 0; i < rows.size(); i++) { // first row is the col
													// names so skip it.
				Element row = rows.get(i);
				Elements cols = null;
				List colsData = new ArrayList();
				if (i == 0) {
					cols = row.select("th");
					if (cols == null) {
						cols = row.select("td");
					}
				} else {
					cols = row.select("td");
				}
				for (int j = 0; j < cols.size(); j++) {
					colsData.add(cols.get(j).text());

				}
				CSVUtils.writeLine(writer, colsData);
				System.out.println("CSV file was created successfully !!!");
			}
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}