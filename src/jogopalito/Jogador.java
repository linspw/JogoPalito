package jogopalito;


public class Jogador {
    public String nome;
    public int idade;
    public String genero;
    public double pontuacao = 0;
    public int quantPalitos = 0;
    
    public Jogador(){
        
    }
    public Jogador(String nome, String genero, int idade){
        this.setNome(nome);
        this.setGenero(genero);
        this.setIdade(idade);
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setGenero(String nome){
        this.genero = genero;
    }
    public String getGenero(){
        return this.genero;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public int getIdade(){
        return this.idade;
    }
    public void setPontuacao(double pontuacao){
        this.pontuacao = pontuacao;
    }
    public double getPontuacao(){
        return this.pontuacao;
    }
    public void somaPontuacao(double valor){
        this.pontuacao+=valor;
    }
    public void setPalito(int valor){
        this.quantPalitos = (valor);
    }
    public int getPalito(){
        return this.quantPalitos;
    }
    public int apostar(int valor){
        
        return 0;
    }
    

}
