package gerador;

import java.util.ArrayList;
import java.util.List;
import manipularquivos.DadosDAO;
import manipularquivos.Manipulacao;

public class GeradorConexao {
    Manipulacao manip = new Manipulacao();
    DadosDAO dadosDAO = new DadosDAO();
    
    public void criaClassDAO(String nomeClasse, String pasta, String nomeTabela){
        manip.criarDiretorio("conexoes",pasta+"\\src");
        manip.criaArquivo("ConexaoMySql.java", pasta+"\\src\\conexoes");
        
        List<String> codigo = new ArrayList<>();
        
        codigo.add("package conexoes;");
        
        codigo.add("import java.sql.Connection;");
        codigo.add("import java.sql.DriverManager;");
        codigo.add("import java.sql.ResultSet;");
        codigo.add("import java.sql.SQLException;");
        codigo.add("import java.sql.Statement;");
        codigo.add("import java.sql.swing.JOptionPane;\n");
        
        codigo.add("public class ConexaoMySql{");
        codigo.add("    private boolean status = false;");
        codigo.add("    private String mensagem = \"\";");
        codigo.add("    private Connection con = null;");
        codigo.add("    private Statement statement;");
        codigo.add("    private ResultSet resultSet;\n");
        
        codigo.add("    private String servidor = \"localhost\";");
        codigo.add("    private String nomeDoBanco = \" NOME DO BANCO AQUI\";");
        codigo.add("    private String usuario = \"root\";");
        codigo.add("    private String senha = \"\";\n");
        
        codigo.add("    public ConexaoMySql(){}");
        codigo.add("    ");
        codigo.add("    public ConexaoMySql(String pServidor, String pNomeDoBanco, String pUsuario, String pSenha){");
        codigo.add("        this.servidor = pServidor;");
        codigo.add("        this.nomeDoBanco = pNomeDoBanco;");
        codigo.add("        this.usuario = pUsuario;");
        codigo.add("        this.senha = pSenha;");
        codigo.add("    }\n");
        
        codigo.add("    public Connection conectar(){");
        codigo.add("        try {");
        codigo.add("            Class.forName(\"com.mysql.jdbc.Driver\").newInstance();");
        codigo.add("            String url = \"jdbc:mysql://\" + servidor + \"/\" + nomeDoBanco;");
        codigo.add("            this.setCon((Connection) DriverManager.getConnection(url, usuario, senha));");
        codigo.add("            this.status = true;");
        codigo.add("        }");
        codigo.add("        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e){\n" +
                   "            JOptionPane.showMessageDialog(null, e.getMessage());");
        codigo.add("        }");
        codigo.add("        return this.getCon();");
        codigo.add("    }\n");
        
        
        codigo.add("    public boolean executarSQL(String pSQL){");
        codigo.add("        try {");
        codigo.add("            this.setStatement(getCon().createStatement());");
        codigo.add("            this.setResultSet(getStatement().executeQuery(pSQL));");
        codigo.add("        } catch (SQLException ex) {");
        codigo.add("            ex.printStackTrace();");
        codigo.add("            return false;");
        codigo.add("        }");
        codigo.add("        return true;");
        codigo.add("    }\n");
        
        
        codigo.add("    public boolean executarUpdateDeleteSQL(String pSQL){");
        codigo.add("        try {");
        codigo.add("            this.setStatement(getCon().createStatement());");
        codigo.add("            getStatement().executeUpdate(pSQL);");
        codigo.add("        } catch (SQLException ex) {");
        codigo.add("            ex.printStackTrace();");
        codigo.add("            return false;");
        codigo.add("        }");
        codigo.add("        return true;");
        codigo.add("    }\n");
        
        codigo.add("    public int insertSQL(String pSQL){");
        codigo.add("        int status = 0;");
        codigo.add("        try{");
        codigo.add("            this.setStatement(getCon().createStatement());");
        codigo.add("            this.getStatement().executeUpdate(pSQL);");
        codigo.add("            this.setResultSet(this.getStatement().executeQuery(\"SELECT last_insert_id();\"));");
        codigo.add("            while(this.resultSet.next()){");
        codigo.add("                status = this.resultSet.getInt(1);");
        codigo.add("            }");
        codigo.add("            return status;");
        codigo.add("        } catch (SQLException ex) {");
        codigo.add("            ex.printStackTrace();");
        codigo.add("            return status;");
        codigo.add("        }");
        codigo.add("    }\n");
        
        codigo.add("    public boolean fecharConexao(){");
        codigo.add("        try{");
        codigo.add("            if((this.getResultSet() != null) && (this.statement != null)){");
        codigo.add("                this.getResultSet().close();");
        codigo.add("                this.statement.close();");
        codigo.add("            }");
        codigo.add("            this.getCon().close();");
        codigo.add("            return true;");
        codigo.add("            } catch(SQLException e) {");
        codigo.add("                 JOptionPane.showMessageDialog(null, e.getMessage());");
        codigo.add("            }");
        codigo.add("            return false;");
        codigo.add("        }");
        codigo.add("}\n");
        
        
    
        manip.escreverArquivo(codigo, pasta+"\\src\\conexoes\\ConexaoMySql.java");
    }
}
