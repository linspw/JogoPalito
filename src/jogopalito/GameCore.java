package jogopalito;
import java.util.ArrayList;
import java.util.Random;


public class GameCore {
    public ArrayList<Jogador>listaJogadores = new ArrayList<Jogador>();
    public int quantTotalPalitos = 0; 
    public int quantJogadores = 0;
    
    public void addJogador(Jogador jogador){
        listaJogadores.add(jogador);
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
            System.out.println(e.getIdade());
            System.out.println(e.getGenero());
            System.out.println(e.getPontuacao());
            System.out.println(e.getPalito());
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
            System.out.printf("Numero sorteado: %d\n", numero);
            resto = resto - numero;
            System.out.printf("Valor sobrado: %d\n",resto);
            
            if(this.listaJogadores.size() == i){
                e.setPalito(resto>0 ? numero+resto: numero);
            }
            else{
                e.setPalito(numero>0?numero:0);            
            }

            i++;
            
        }
    }
}
