package Controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private TextField username;
	
	@FXML
	private TextField password;
	
	public Stage primaryStage;
	
	public void entrar() {
		System.out.println("Login realizado com sucesso");
		if(username.getText().equals("admin") && password.getText().equals("admin")) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/dashboard.fxml"));
				StackPane root = loader.load();
				Scene scene = new Scene(root, 600, 400);
				Stage currentStage = (Stage) username.getScene().getWindow();
				currentStage.close();
				
				currentStage.setScene(scene);
				currentStage.setTitle("DashBoard");
				currentStage.show();
			} catch(IOException e){
				e.printStackTrace();
			}
			System.out.println("Realizando login");
		} else {
			mensagemDeErro();
		}
	}
	
	public void mensagemDeErro() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Sua senha está incorreta");
		alert.setContentText("Senha incorreta!");
		alert.setHeaderText(null);
		alert.showAndWait();
	}
}
