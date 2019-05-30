package jogopalito;
import java.sql.*;
import java.util.ArrayList;

public class Database {
    String bd_user = "root";
    String bd_senha = "";
    String bd_caminho = "jdbc:mysql://localhost/bd_jogopalito";
    Connection con = null;
    public Database() {
        create();
    }
    public void create(){
        try{
            con = DriverManager.getConnection(bd_caminho, bd_user, bd_senha);
            System.out.println("Conexao MS-ACCESS O.K.");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void delete(){
        try{
            this.con.close();
            System.out.println("Conexao MS-ACCESS Fechada");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public ResultSet lerDados(){
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM tb_jogador ORDER BY pontuacao desc");
            return rs;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void inserirJogador(Jogador player){
        try{
            String sql = "INSERT INTO `tb_jogador` (`id`, `nome`, `idade`, `sexo`, `pontuacao`) VALUES (NULL, '"+player.getNome()+"', '"+player.getIdade()+"', '"+player.getGenero()+"', '"+player.getPontuacao()+"');";
            System.out.println(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void inserirJogadores(ArrayList<Jogador>listaJogadores){
        for(Jogador e: listaJogadores){
            this.inserirJogador(e);
        }
    }
}
