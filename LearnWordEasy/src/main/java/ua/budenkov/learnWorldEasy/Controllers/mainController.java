package ua.budenkov.learnWorldEasy.Controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import ua.budenkov.learnWorldEasy.http.Cambridge;

public class mainController {
	
	@FXML
	private Button bt1;
	@FXML
	private WebView webView;
	@FXML
	private TextField wordToFind;
	
	@FXML
	private void onBtn1Click(ActionEvent e) throws IOException { 
				
				if(wordToFind.getText().isBlank()) {
					return;
				};
				
				Cambridge c = new Cambridge(wordToFind.getText());
				String html_c = c.getData();
				WebEngine webEngine = webView.getEngine();
				webEngine.loadContent(html_c);
				write_to_file(html_c, "c:/temp/c.html");
				//System.out.println(c.getData());
		   } 
	
	public void write_to_file(String s, String fileName) throws IOException {
			try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			    writer.write(s);
			    
			    writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
