package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeituraController implements ILeituraController {
    public LeituraController(){
        super();
    }

    @Override
    public void readDir(String path) throws IOException {
    	File dir = new File(path);
		if(dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles();
			for(File f : files) {
				if (f.isFile()) {
					System.out.println("     \t"+f.getName());
				}else {
					System.out.println("<DIR>\t" +f.getName());
				}
			}
		}else {
			throw new IOException("Diretório inválido!");
		}
        
    }

    @Override
    public void readFile(String path, String nome) throws IOException {
        File arq = new File(path, nome);
		if(arq.exists() && !arq.isDirectory()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			System.out.printf("%-20s %-25s %-20s%n", "FOOD NAME", "SCIENTIFIC NAME", "SUBGROUP");
	        System.out.println("-----------------------------------------------------------------------");
			while(linha != null) {
				if(linha.contains("Tropical fruits")) {
					String[] coluna = linha.split(",");
					if (coluna.length >= 3) {
	                    String nomeAlimento = coluna[0].trim();
	                    String nomeCientif = coluna[1].trim();
	                    String subgrupo = coluna[2].trim();

	                    System.out.printf("%-20s %-25s %-20s%n", nomeAlimento, nomeCientif, subgrupo);
	                }
				}
				linha = buffer.readLine();
	
			}
			buffer.close();
			leitor.close();
			fluxo.close();	
		}else {
			throw new IOException("Arquivo inválido!");
		}
        
    }

}
