package repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;

import model.Fly;

public class ViagensRepository {

	private List<Fly> flies;
	private File database;

	public ViagensRepository() {
		this.database = new File("databaseflys.txt");
		this.flies = new ArrayList<>();
		loadFLies();
	}

	private void loadFLies() {
		try (Scanner sc = new Scanner(database)) {
			while (sc.hasNextLine()) {
				String[] data = sc.nextLine().split(";");
				if (data.length >= 4) {
					Fly fly = new Fly();
					fly.setId(Integer.parseInt(data[0]));
					fly.setNome(data[1]);
					fly.setInicioVoo(data[2]);
					fly.setFimVoo(data[3]);
					flies.add(fly);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado, criando um novo!");
			createFileIfNotExists();
		}
	}
	
	private void createFileIfNotExists() {
		try {
			if(!database.exists()) {
				database.createNewFile();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


	public void updateFly(Fly updatedFly) {
		for (int i = 0; i < flies.size(); i++) {
			if (flies.get(i).getId() == updatedFly.getId()) {
				flies.set(i, updatedFly);
				saveFlies();
				break;
			}
		}
		saveFlies();
	}

	public Fly getFlyById(int id) {
		for (Fly fly : flies) {
			if (fly.getId() == id) {
				return fly;
			}
		}
		return null;
	}

	public List<Fly> buscarTodos() {
		return new ArrayList<>(flies);
	}

	public void deleteFly(int id) {
		flies.removeIf(fly -> fly.getId() == id);
		saveFlies();
	}

	public void addFly(Fly fly) {
		fly.setId(1);
		flies.add(fly);
		saveFlies();
	}

	public int getNextId() {
		int maxId = 0;
		for (Fly fly : flies) {
			if (fly.getId() > maxId) {
				maxId = fly.getId();
			}
		}
		return maxId + 1;
	}

	private void saveFlies() {
		try (PrintWriter writer = new PrintWriter(new FileOutputStream(database, false))) {
			for (Fly fly : flies) {
				String data = fly.getId() + ";" + fly.getNome() + ";" 
						+ fly.getInicioVoo() + ";" + fly.getFimVoo();
				writer.println(data);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo database deletado com sucesso");
		}
	}

}
