package jogopalito;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class JogoPalito {


    public static void main(String[] args) {
        
        
        /*
        Database db = new Database();
        //db.inserirJogador(new Jogador("Jesse", "M", 22));
        db.lerDados();
        ResultSet rs = db.lerDados();
        try{
            while(rs.next()){
                String w_nome=rs.getString("nome");
                Double w_pontuacao=rs.getDouble("pontuacao");
                System.out.println("Nome: " + w_nome.trim() ); 
                System.out.println("Pontuacao:"+w_pontuacao.toString());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }*/
        
        GameCore core = new GameCore();
        
        MainScreen app = new MainScreen();
        DataTransport data = new DataTransport(core, app);
        MenuPanel tela1 = new MenuPanel();
        SignPanel tela2 = new SignPanel();
        GamePanel tela3 = new GamePanel();
        RankingPanel tela4 = new RankingPanel();
        
        data.setMenuPanel(tela1);
        data.setSignPanel(tela2);
        data.setGamePanel(tela3);
        data.setRankingPanel(tela4);
        
        app.addTela(tela1, "Tela1");
        app.addTela(tela2, "Tela2");
        app.addTela(tela3, "Tela3");
        app.addTela(tela4, "Tela4");
        tela1.inicializar(app.switcher, data);
        tela2.inicializar(app.switcher, data);
        tela3.inicializar(app.switcher, data);
        tela4.inicializar(app.switcher, data);
        
        
    }
}
