module learnWordEasy {
	requires javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires java.net.http;
	requires org.jsoup;
	requires javafx.web;
	exports ua.budenkov.learnWorldEasy;
	exports ua.budenkov.learnWorldEasy.Controllers to javafx.fxml;
	
	opens ua.budenkov.learnWorldEasy.Controllers;
}