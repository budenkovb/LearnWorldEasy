package ua.budenkov.learnWorldEasy.http;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Cambridge {
	
	private String textRequest = "https://dictionary.cambridge.org/dictionary/english/";
	private String fileCSS = "/c.css";
	
	private String mainClass = "hfr-m ltab lp-m_l-15";
	
	private String [] div_to_delete = {"pr lcs bh", "smartt daccord", "bb hax", "lmb-20", 
										"bw hbss x lmb-25", "pr bw hbss x lmb-25", 
										"daccord", "tz0 topslot-container","dwla wordlist-add-button",
										"pr di superentry __"};
	private String [] teg_to_delete = {"meta", "amp-audio"};
	
	public Cambridge(String wordToFind){
		this.textRequest += wordToFind; 
	}
	
	public String getData() {
		
		try {
			// create a client
			var client = HttpClient.newHttpClient();
			
			// create a request
			var request = HttpRequest.newBuilder(
			       URI.create(textRequest))
			   .header("accept", "application/json")
			   .build();
			
			var response = client.send(request, BodyHandlers.ofString());
			Document html_document = Jsoup.parse(response.body());
			for (String  each : div_to_delete) {
				Elements main_to_delete = html_document.getElementsByClass(each);
				if (main_to_delete!=null) {
					main_to_delete.remove();
				}
			}
			
			for (String  each : teg_to_delete) {
				Elements main_to_delete = html_document.getElementsByTag(each);
				if (main_to_delete!=null) {
					main_to_delete.remove();
				}
			}
			
			Elements main_div = html_document.getElementsByClass(mainClass);
			if (main_div==null) {
				String res = "Не нашли основной элемент! Возможно поменялась разметка!";
				System.out.println(res);
				return res;
			}
			// getCSS()+
			return getCSS()+"<body>"+main_div.html()+"</body>";
			
			//System.out.println(response.body());
			
		}catch (Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	private String getCSS() throws IOException {

		try {
			URL css_url = getClass().getResource("/cambridge.css");
	        BufferedReader in = new BufferedReader(
	        new InputStreamReader(css_url.openStream()));
	        String result = "";
	        String inputLine = "";
	        while ((inputLine = in.readLine()) != null)
	        	result += inputLine+ "\r\n";
	        in.close();
	        
			return result;
			
		} catch (IOException e) {
			
			e.printStackTrace();
			return "";
		}
	}

}
