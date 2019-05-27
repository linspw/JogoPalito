package jogopalito;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPanel extends JPanel implements ActionListener{
    public JLabel tituloSuperior, tituloUsersBars;
    public JButton btnIniciar, btnAddJogador, btnSair;
    public JPanel superior, centro, centro_middle, usersBars;
    public CardSwitcher switcher;
    public GridBagConstraints gbc;
    public DataTransport data;
    Font fontTitle = new Font("Verdana", Font.BOLD, 24);

    public MenuPanel(){
        setLayout(new BorderLayout());
        superior = new JPanel();
        centro = new JPanel();
        centro_middle = new JPanel();
        usersBars = new JPanel();
        centro_middle.setLayout(new BoxLayout(centro_middle, BoxLayout.PAGE_AXIS));
        centro.setLayout(new GridBagLayout());

        //Arrumando Centralização do usersBars
        tituloSuperior = new JLabel("Jogo do Pálito");
        
        btnIniciar = new JButton("Iniciar jogo");
        btnIniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAddJogador = new JButton("Adicionar Jogador");
        btnAddJogador.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSair = new JButton("Sair");
        btnSair.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        superior.add(tituloSuperior);
        superior.add(Box.createRigidArea(new Dimension(0, 80)));
        
        centro_middle.add(Box.createRigidArea(new Dimension(400,30)));
        centro_middle.add(btnIniciar);
        centro_middle.add(Box.createRigidArea(new Dimension(400,30)));
        centro_middle.add(btnAddJogador);
        centro_middle.add(Box.createRigidArea(new Dimension(400,30)));
        centro_middle.add(btnSair);
        centro_middle.add(Box.createRigidArea(new Dimension(400,30)));
        centro_middle.setAlignmentY(Component.CENTER_ALIGNMENT);

        centro.setBackground(Color.green);
        centro.add(centro_middle, new GridBagConstraints());
        
        //centro.add(usersBars);
        usersBars.setVisible(false);

        tituloSuperior.setSize(100, 100);
        tituloSuperior.setFont(fontTitle);
        
        add(superior, BorderLayout.NORTH);
        add(centro, BorderLayout.CENTER);
        setSize(800, 600);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent e) {
        Object botao = e.getSource();
        if (btnIniciar == botao) {
            
        }
        else if(btnAddJogador == botao){
            this.switcher.trocarScreen("Tela2");
        }
        else if(btnSair == botao){
            this.data.app.dispose();
        }
        //JOptionPane.showMessageDialog(null, "Menu Panel");
    }
    public void inicializar(CardSwitcher switcher, DataTransport data){
        this.switcher = switcher;
        this.data = data;
        btnIniciar.addActionListener(this);
        btnAddJogador.addActionListener(this);
        btnSair.addActionListener(this);
    }
    
    public void usersBar(){
        data.core.mostrarLista();
        tituloUsersBars = new JLabel("Jogadores:");
        usersBars.add(tituloUsersBars);
        usersBars.setVisible(true);
        //usersBars.setLayout(null);
        usersBars.setBounds(0,0, 300, 400);
        centro.add(usersBars, gbc);
        

    }
}
