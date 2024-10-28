package view;

import java.io.IOException;
import controller.ILeituraController;
import controller.LeituraController;

public class LeituraPrincipal {
    public static void main(String[] args) {
        ILeituraController arquivo = new LeituraController();
		String dirWin = "C:\\TEMP";
		String path = "C:\\TEMP";
		String nome = "generic_food.csv";
		
		try {
			arquivo.readDir(dirWin);
			System.out.println("-----------------------------------------------------------------------");
			arquivo.readFile(path, nome);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
