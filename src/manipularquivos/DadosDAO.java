package manipularquivos;

import gerador.Dados;
import java.util.ArrayList;
import java.util.List;

public class DadosDAO {
    public static List<Dados> lstDados = new ArrayList<Dados>();
    
    public void salvarDados (Dados dados){
        lstDados.add(dados);
    }
    
    public void removerDado(String tipo, String nome){
        for(int i = 0; i < lstDados.size(); i++){
            if(lstDados.get(i).getTipo()== tipo && lstDados.get(i).getNome()== nome){
                lstDados.remove(i);
                break;
            }
        }
    }
    
    public List<Dados> listarDados(){
        return lstDados;
    }
}
