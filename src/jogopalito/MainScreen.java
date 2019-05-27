package jogopalito;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainScreen extends JFrame {
    public Container JANELA;
    public JPanel telaAtual;
    public CardLayout card;
    public CardSwitcher switcher;
    public DataTransport data;
    //public MenuPanel mnpn = new MenuPanel();
    public MainScreen(){
        JANELA = getContentPane();
        JANELA.setBackground(Color.WHITE);
        card = new CardLayout();
        switcher = new CardSwitcher(JANELA, card);
        JANELA.setLayout(switcher.layout);        
        //JANELA.setSize(800, 600);

        pack();
        setSize(800, 600);
        setLocationRelativeTo(null);
        //setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void addTela(JPanel tela, String telaNome){
        JANELA.add(tela, telaNome);
    }
    public void setTela(String nome){
        switcher.trocarScreen(nome);
    }
    public void pulaTela(){
        card.next(JANELA);
    }
    public void inicializar(DataTransport data){
        this.data = data;
    }
}
