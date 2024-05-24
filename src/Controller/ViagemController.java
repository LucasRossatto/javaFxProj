package Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
	
	private ObservableList<Fly> data;

	private ViagensRepository FliesRepository;


	@FXML
	public void initialize() {
		// Instanciando com o valor default da celula
		cNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cInicioVoo.setCellValueFactory(new PropertyValueFactory<>("InicioVoo"));
		cFimVoo.setCellValueFactory(new PropertyValueFactory<>("FimVoo"));

		// Instanciando lista observable
		data = FXCollections.observableArrayList();

		// tableview aceita somente ObervableList
		tableView.setItems(data);

		FliesRepository = new ViagensRepository();
		carregarDadosSalvos();
	}

	public void carregarDadosSalvos() {
		try (BufferedReader br = new BufferedReader(new FileReader("databaseflys.txt"))) {
			String line;
			// caso linha nao tenha registro, o while para
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(";");
				// 0: id, 1: nome, 2: inicioVoo, 3: FimVoo
				if (parts.length >= 4) {
					// preenche o objeto fly
					Fly fly = new Fly();
					fly.setId(Integer.parseInt(parts[0]));
					fly.setNome(parts[1]);
					fly.setInicioVoo(parts[2]);
					fly.setFimVoo(parts[3]);
					// adiciona no ObservableList
					data.add(fly);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cadastrar() {
		Fly fly = new Fly();
		fly.setNome(nome.getText());
		fly.setInicioVoo(InicioVoo.getText());
		fly.setFimVoo(FimVoo.getText());
		FliesRepository.addFly(fly);
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
