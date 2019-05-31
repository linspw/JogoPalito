package jogopalito;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class GameCore {
    public ArrayList<Jogador>listaJogadores = new ArrayList<Jogador>();
    public int quantTotalPalitos = 0; 
    public int quantJogadores = 0;
    
    
    public void sortearListaJogadores(){
        Collections.shuffle(listaJogadores);
    }
    public void addJogador(Jogador jogador){
        listaJogadores.add(jogador);
        this.quantJogadores = this.listaJogadores.size();
    }
    public int getJogador(String nome){
        return listaJogadores.indexOf(nome);
    }
    public ArrayList<Jogador> getLista(){
        return this.listaJogadores;
    }
    public void mostrarLista(){
        for (Jogador e: this.listaJogadores){
            System.out.println(e.getNome());
            System.out.println(e.getPalito());
        }
    }
    public void mostrarPontuacao(){
        for (Jogador e: this.listaJogadores){
            System.out.printf("\nJogador: %s --- Pontuacao: %.2f --- Aposta: %.0f --- Valor Real: %d",e.getNome(), e.getPontuacao(), e.aposta, e.getPalito());
        }
    }
    public int getTotalPalitos(){
        return this.quantTotalPalitos;
    }
    public void setTotalPalitos(int valor){
        this.quantTotalPalitos = valor;
    }
    public void sortTotalPalitos(){
        Random rand = new Random();
        int numero = rand.nextInt(30);
        numero+=1;
        this.setTotalPalitos(numero);
    }
    public int sortNum(int limite){
        if(limite == 0){
            return 0;
        }
        Random rand = new Random();
        int numero = rand.nextInt(limite);
        numero +=1;
        return numero;
    }
    public void distribuirPalitos(){
        int resto = this.getTotalPalitos();
        int i=1;
        for (Jogador e: this.listaJogadores){
            int numero = sortNum(resto);
            resto = resto - numero;
            if(this.listaJogadores.size() == i){
                e.setPalito(resto>0 ? numero+resto: numero);
            }
            else{
                e.setPalito(numero>0?numero:0);            
            }
            i++;
        }
    }
    public void distribuirScore(){
        for (Jogador e: this.listaJogadores){
            e.setScore();
        }
    }
    public void resetAllAposta(){
        for (Jogador e: this.listaJogadores){
            e.setAposta(0);
        }
    }
}
