package jogopalito;


public class Jogador {
    public String nome;
    public int idade;
    public String genero;
    public double pontuacao = 0;
    public int quantPalitos = 0;
    public double aposta = 0;
    
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
    public void setGenero(String genero){
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
    public void setScore(){
        double diferenca = Math.abs(this.quantPalitos - this.aposta);
        double valor;
        if(diferenca >=10){
            valor = 0;
        }else{
            valor = 10*(1-(diferenca/10));
        }
        this.somaPontuacao(valor);
    }
    public void setPalito(int valor){
        this.quantPalitos = (valor);
    }
    public int getPalito(){
        return this.quantPalitos;
    }
    public void setAposta(double valor){
        this.aposta = valor;
    }
    public double getAposta(){
        return this.aposta;
    }
    

}
