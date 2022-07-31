package gerador;


import java.util.ArrayList;
import java.util.List;
import manipularquivos.DadosDAO;
import static manipularquivos.DadosDAO.lstDados;
import manipularquivos.Manipulacao;

public class GeradorModel {
    Manipulacao manip = new Manipulacao();
    DadosDAO dadosDAO = new DadosDAO();
    
    public void criarClasseModel(String nomeClasse, String tipo, String pasta){
        manip.criarDiretorio("src",pasta);
        manip.criarDiretorio("model",pasta+"\\src");
        manip.criaArquivo("Model"+nomeClasse+".java", pasta+"\\src\\model");

        List<String> codigo = new ArrayList<>();
        
        codigo.add("package model;");
        
        codigo.add(tipo + " class Model" + nomeClasse +" {");
        for (int i = 0; i < lstDados.size(); i++){
            codigo.add("     "+lstDados.get(i).getTipo()+" "+lstDados.get(i).getNome()+";");
        }
        //cosntrutor vazio
        codigo.add("\n");
        codigo.add("public Model" + nomeClasse + " (){");
        codigo.add("}\n");
        
        // construtor completo
        String cons = "";
        for (int i = 0; i < lstDados.size(); i++){
            cons += lstDados.get(i).getTipo()+" "+lstDados.get(i).getNome()+", ";
        }
        cons = cons.substring(0, cons.length() - 1);
        codigo.add("public " + nomeClasse + " ("+cons+"){");
        for (int i = 0; i < lstDados.size(); i++){
            codigo.add("     this."+lstDados.get(i).getNome()+" = "+lstDados.get(i).getNome()+";");
        }
        codigo.add("}\n");
        
        //get e sets
        for (int i = 0; i < lstDados.size(); i++){
            //get
            codigo.add("public " + lstDados.get(i).getTipo()+" get"+lstDados.get(i).getNome()+"() {");
            codigo.add("     return " + lstDados.get(i).getNome()+";\n}\n");
            //set
            codigo.add("public void set" + lstDados.get(i).getNome()+"("+lstDados.get(i).getTipo()+" "+lstDados.get(i).getNome()+") {");
            codigo.add("     this."+lstDados.get(i).getNome()+" = "+lstDados.get(i).getNome()+";\n}\n");
        }
        
        String toStr = "";
        for (int i = 0; i < lstDados.size(); i++){
            toStr += lstDados.get(i).getNome()+"+ \";\"+";
        }
        toStr = toStr.substring(0, toStr.length() - 1);
        
        codigo.add("@Override\n"
                    + "    public String toString() {\n"
                    + "        return " + toStr +";\n"
                    + "    }");
        codigo.add("}");
        codigo.add("\n");
        
        manip.escreverArquivo(codigo, pasta+"\\src\\model\\Model"+nomeClasse+".java");
    }
}
