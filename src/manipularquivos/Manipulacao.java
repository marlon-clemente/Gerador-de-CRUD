package manipularquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class Manipulacao {
    public void criarDiretorio(String pasta, String diretorio){
        File file = new File(diretorio+"\\"+pasta);
        //Criar pasta
        file.mkdirs();
        //apagar pasta
        //file.delete();
        System.out.println("Criado o diretório "+diretorio+"\\"+pasta);
    }
    
    public void criaArquivo(String name,  String diretorio){
        File file = new File(diretorio+"\\"+name);
        try {
            file.createNewFile();
        } catch (IOException ex) {
        }
        
    }
    
    public void lerArquivo(String diretorio){
        File file = new File(diretorio);
        
        try {
            FileReader ler = new FileReader(file);
            BufferedReader lerBuffer = new BufferedReader(ler);
            String linha = lerBuffer.readLine();
            while (linha != null){
                System.out.println(linha);
                linha = lerBuffer.readLine();
            }
            
            
        } catch (IOException ex) {
        }
    }
    
    public void escreverArquivo(List <String> codigo, String diretorio){
        File file = new File(diretorio);
        
        try {
            FileReader ler = new FileReader(file);
            
            FileWriter escr = new FileWriter(file);
            BufferedWriter escreve = new BufferedWriter(escr);
            for (int i = 0; i < codigo.size(); i++) {
                escreve.write(codigo.get(i) + System.getProperty("line.separator")); // 
            }
            escreve.close();
            escr.close();
            
            
        } catch (IOException ex) {
        }
    }
    
}
