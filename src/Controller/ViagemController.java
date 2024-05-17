package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Fly;
import repository.ViagensRepository;

public class ViagemController {

	@FXML
	private TableView<Fly> tableView;
	
	@FXML
	private TableColumn<Fly, String> cNome;
	
	@FXML
	private TableColumn<Fly, String> cInicioVoo;
	
	@FXML
	private TableColumn<Fly, String> cFimVoo;
	
	
	@FXML 
	private TextField nome;
	
	@FXML 
	private TextField InicioVoo;
	
	@FXML
	private TextField FimVoo;
	
	@FXML
	public void initialize() {
		repoViagem = new ViagensRepository();
	}
	
	private ViagensRepository repoViagem;
	
	public void cadastrar() {
		Fly fly = new Fly();
		fly.setNome(nome.getText());
		fly.setInicioVoo(InicioVoo.getText());
		fly.setFimVoo(FimVoo.getText());
		repoViagem.addFly(fly);
	}
	
	public void ClearFields() {
		nome.clear();
		InicioVoo.clear();
		FimVoo.clear();
	}
	
	public void limpar() {
		ClearFields();
	}
}
