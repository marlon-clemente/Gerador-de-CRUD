package gerador;

import java.util.ArrayList;
import java.util.List;
import manipularquivos.DadosDAO;
import static manipularquivos.DadosDAO.lstDados;
import manipularquivos.Manipulacao;

public class GeradorDAO {
    Manipulacao manip = new Manipulacao();
    DadosDAO dadosDAO = new DadosDAO();
    
    public void criaClassDAO(String nomeClasse, String pasta, String nomeTabela){
        manip.criarDiretorio("DAO",pasta+"\\src");
        manip.criaArquivo("DAO"+nomeClasse+".java", pasta+"\\src\\DAO");
        
        List<String> codigo = new ArrayList<>();
        
        codigo.add("package DAO;");
        codigo.add("import model."+nomeClasse+";");
        codigo.add("import conexoes.ConexaoMySQL;");
        codigo.add("import java.util.ArrayList;\n");
        
        codigo.add("public class DAO"+nomeClasse+" extends ConexaoMySql {\n");
        
        codigo.add("    public int salvar"+nomeClasse+"DAO(Model"+nomeClasse+" model"+nomeClasse+"){");
        codigo.add("          try{");
        codigo.add("            this.conectar();");
        codigo.add("            return this.insertSQL(");
        codigo.add("               \"INSERT INTO "+nomeTabela+"(\"");
         for (int i = 0; i < lstDados.size(); i++){
            codigo.add("               + \""+lstDados.get(i).getNome()+",\"");
        }
        codigo.add("              + \") VALUES (\"");
        for (int i = 0; i < lstDados.size(); i++){
            codigo.add("              + \"'\" + model"+nomeClasse+".get"+lstDados.get(i).nome+"() + \"',\"");
        }
        codigo.add("               + \");\"");
        codigo.add("               );");
        codigo.add("          }catch(Exeption e){");
        codigo.add("               e.printStackTrace();");
        codigo.add("               return 0;");
        codigo.add("          }finally{");
        codigo.add("               this.fecharConexao();");
        codigo.add("          }");
        codigo.add("    }\n\n");
        

// FIM CLASSE Salvar
        codigo.add("    public Model"+nomeClasse+" get"+nomeClasse+"DAO(String pNome){");
        codigo.add("        Model"+nomeClasse+" model"+nomeClasse+" =new Model"+nomeClasse+"();");
        codigo.add("        try{");
        codigo.add("            this.conectar();");
        codigo.add("            this.executarSQL(");
        codigo.add("              \"SELECT \"");
        for (int i = 0; i < lstDados.size(); i++){
        codigo.add("                    + \""+lstDados.get(i).getNome()+",\"");
        }
        codigo.add("               + \" FROM \"");
        codigo.add("                    + \" "+nomeTabela+" \"");
        codigo.add("               + \" WHERE \"");
        for (int i = 0; i < 1; i++){
        codigo.add("                    + \" "+lstDados.get(0).getNome()+" = ' \" + pNome + \" ' \"");
        }
        codigo.add("                    + \" ; \"");
        codigo.add("            );\n");
        
        codigo.add("            while(this.getResultSet().next()){");
        for (int i = 0; i < lstDados.size(); i++){
        codigo.add("                   model"+nomeClasse+".set"+lstDados.get(i).getNome()+"(this.gerResultSet().getString("+i+"));");
        }
        codigo.add("            }\n");
        codigo.add("          }catch(Exeption e){");
        codigo.add("               e.printStackTrace();");
        codigo.add("               return 0;");
        codigo.add("          }finally{");
        codigo.add("               this.fecharConexao();");
        codigo.add("          }");
        codigo.add("    return model"+nomeClasse+";");
        codigo.add("    }\n\n");
        
        //outra classe
        codigo.add("    public ArrayList<Model"+nomeClasse+"> getLista"+nomeClasse+"DAO(){");
        codigo.add("        ArrayList<Model"+nomeClasse+"> listamodel"+nomeClasse+" = new ArrayList();");
        codigo.add("        Model"+nomeClasse+" model"+nomeClasse+" = new Model"+nomeClasse+"();");
        codigo.add("        try{");
        codigo.add("            this.conectar();");
        codigo.add("            this.executarSQL(");
        codigo.add("               \"SELECT \"");
        for (int i = 0; i < lstDados.size(); i++){
        codigo.add("                    + \""+lstDados.get(i).getNome()+",\"");
        }
        codigo.add("               + \" FROM \"");
        codigo.add("                    + \" "+nomeTabela+" \"");
        codigo.add("               + \" ; \"");
        codigo.add("        );");
        
        codigo.add("                while(this.getResultSet().next()){");
        codigo.add("                    model"+nomeClasse+" = new Model"+nomeClasse);
        for (int i = 0; i < lstDados.size(); i++){
        codigo.add("                    model"+nomeClasse+".set"+lstDados.get(i).getNome()+"(this.gerResultSet().getString("+i+"));");
        }
        codigo.add("                    listamodel"+nomeClasse+".add(model"+nomeClasse+");");
        codigo.add("                }");
        codigo.add("          }catch(Exeption e){");
        codigo.add("               e.printStackTrace();");
        codigo.add("               return 0;");
        codigo.add("          }finally{");
        codigo.add("               this.fecharConexao();");
        codigo.add("          }");
        codigo.add("    return listamodel"+nomeClasse+";");
        codigo.add("    }\n\n");
        
        //Atualizaaa
        codigo.add("    public boolean atualiza"+nomeClasse+"DAO (Model"+nomeClasse+" pModel"+nomeClasse+"){");
        codigo.add("        try{");
        codigo.add("            this.conectar();");
        codigo.add("            return this.executarUpdateDeleteSQL(");
        codigo.add("               \"UPDATE "+nomeTabela+" SET \"");
        for (int i = 0; i < lstDados.size(); i++){
        codigo.add("                    + \""+lstDados.get(i).getNome()+" '\" + pModel"+nomeClasse+".get"+lstDados.get(i).getNome()+" + \" ',\"");
        }
                codigo.add("               + \" WHERE \"");
        for (int i = 0; i < 1; i++){
        codigo.add("                    + \" "+lstDados.get(0).getNome()+" = '\" + pModel"+nomeClasse+".get"+lstDados.get(0).getNome()+" + \" '\"");
        }
        codigo.add("               + \" ; \"");
        codigo.add("        );");
        codigo.add("          }catch(Exeption e){");
        codigo.add("               e.printStackTrace();");
        codigo.add("               return 0;");
        codigo.add("          }finally{");
        codigo.add("               this.fecharConexao();");
        codigo.add("          }");
        codigo.add("    }\n\n");
        
        // exclui
        codigo.add("    public boolean excluir"+nomeClasse+"DAO> (String valor(){");
        codigo.add("        try{");
        codigo.add("            this.conectar();");
        codigo.add("            return this.executarUpdateDeleteSQL(");
        codigo.add("               \"DELETE FROM "+nomeTabela+" \"");
        codigo.add("               + \" WHERE \"");
        for (int i = 0; i < 1; i++){
        codigo.add("                    + \" "+lstDados.get(0).getNome()+" = '\" + valor + \" '\"");
        }
        codigo.add("               + \" ; \"");
        codigo.add("        );");
        codigo.add("          }catch(Exeption e){");
        codigo.add("               e.printStackTrace();");
        codigo.add("               return 0;");
        codigo.add("          }finally{");
        codigo.add("               this.fecharConexao();");
        codigo.add("          }");
        codigo.add("    }\n\n");
        codigo.add("}\n");
        
        manip.escreverArquivo(codigo, pasta+"\\src\\DAO\\DAO"+nomeClasse+".java");
    }
}
