package jogopalito;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener{
    public JLabel tituloSuperior, tituloUsersBars;
    public JButton btnIniciar, btnAddJogador, btnSair, btnProximo1, btnProximo2;
    public JPanel superior, centro, centro_middle, usersBars, TelaStart, TelaAposta, TelaPontuacao;
    public CardSwitcher switcher;
    public GridBagConstraints gbc, gbt;
    public DataTransport data;
    public CardLayout lyt;
    Font fontTitle = new Font("Verdana", Font.BOLD, 24);

    public GamePanel(){
        setLayout(new BorderLayout());
        superior = new JPanel();
        centro = new JPanel();
        centro_middle = new JPanel();
        
        centro.setLayout(new GridBagLayout());
        //centro.setLayout(null);
        //Arrumando Centralização do usersBars
        tituloSuperior = new JLabel("Jogo do Pálito");
        
        
        superior.add(tituloSuperior);
        superior.add(Box.createRigidArea(new Dimension(0, 80)));
        
        centro_middle.add(Box.createRigidArea(new Dimension(400,30)));
        centro_middle.add(Box.createRigidArea(new Dimension(400,30)));
        centro_middle.setAlignmentY(Component.CENTER_ALIGNMENT);
        lyt = new CardLayout();
        centro_middle.setLayout(lyt);
        
        gbc = new GridBagConstraints();
        gbc.ipadx = 10;
        gbc.ipady = 10;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 1;
        gbc.gridwidth = 3;

        gbc.anchor = GridBagConstraints.CENTER;
        centro.setBackground(Color.green);
        centro.add(centro_middle, gbc);
        
        //this.etapaStart();
        //this.etapaAposta();
        TelaStart = new JPanel();
        JLabel frase = new JLabel("Prepare!!");
        btnProximo1 = new JButton("Jaimo");
        TelaStart.add(btnProximo1);
        TelaStart.add(frase);
        TelaStart.setVisible(false);

        
        TelaAposta = new JPanel();
        btnProximo2 = new JButton("Proximo");
        TelaAposta.add(btnProximo2);
        TelaAposta.add(frase);
        TelaAposta.setVisible(true);

        centro_middle.add(TelaStart, "TelaStart");
        centro_middle.add(TelaAposta, "TelaAposta");
        lyt.show(centro_middle, "TelaAposta");


        //centro.add(usersBars);

        tituloSuperior.setSize(100, 100);
        tituloSuperior.setFont(fontTitle);
        
        add(superior, BorderLayout.NORTH);
        add(centro, BorderLayout.CENTER);
        setSize(800, 600);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent e) {
        Object botao = e.getSource();
        if(botao == btnProximo1 || botao == btnProximo2){
            JOptionPane.showMessageDialog(null, "Apertou");
            lyt.next(centro_middle);
        }
        
    }
    public void inicializar(CardSwitcher switcher, DataTransport data){
        this.switcher = switcher;
        this.data = data;
        
    }
    
    public void trocarTela(String nome){
        lyt.show(centro_middle, nome);
    }
    public void etapaStart(){
        TelaStart = new JPanel();
        JLabel frase = new JLabel("Prepare!!");
        btnProximo1 = new JButton("Jaimo");
        TelaStart.add(btnProximo1);
        TelaStart.add(frase);
        TelaStart.setVisible(true);
    }
    public void etapaAposta(){
        TelaAposta = new JPanel();
        JLabel frase = new JLabel("Apostando!!");
        btnProximo2 = new JButton("Proximo");
        TelaAposta.add(btnProximo2);
        TelaAposta.add(frase);
        System.out.println("Ativour");
        TelaAposta.setVisible(true);
    }
}
