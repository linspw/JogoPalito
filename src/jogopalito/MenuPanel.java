package jogopalito;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPanel extends JPanel implements ActionListener{
    public JLabel tituloSuperior, tituloUsersBars;
    public JButton btnIniciar, btnAddJogador, btnSair;
    public JPanel superior, centro, centro_middle, usersBars;
    public CardSwitcher switcher;
    public GridBagConstraints gbc, gbt;
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
        //centro.setLayout(null);
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

        gbc = new GridBagConstraints();
        gbc.ipadx = 10;
        gbc.ipady = 10;
        //gbc.insets = new Insets(25, 25, 0, 0);
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 1;
        gbc.gridwidth = 3;

        gbc.anchor = GridBagConstraints.CENTER;
        centro.setBackground(Color.green);
        centro.add(centro_middle, gbc);
        
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
            if(this.data.core.listaJogadores.size()==0){
                JOptionPane.showMessageDialog(null, "Nenhum jogador Adicionado! Adicione");
            }
            else{
                this.data.core.sortTotalPalitos();
                this.data.core.distribuirPalitos();
                this.data.core.mostrarLista();
                this.switcher.trocarScreen("Tela3");
            }

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
        if(usersBars.isVisible()){
            centro.remove(usersBars);
            usersBars = new JPanel();
            tituloUsersBars = new JLabel("Jogadores:");

        }else{
            tituloUsersBars = new JLabel("Jogadores:");
        }
        usersBars.setLayout(new BoxLayout(usersBars, BoxLayout.Y_AXIS));
        gbt = new GridBagConstraints();
        gbt.ipadx = 20;
        gbt.ipady = 10;
        gbc.insets = new Insets(40, 40, 10, 10);
        gbt.weightx = 0;
        gbt.weighty = 0;
        gbt.anchor = GridBagConstraints.FIRST_LINE_END;
        usersBars.add(tituloUsersBars);
        usersBars.setVisible(true);

        centro.add(usersBars, gbt);
        this.gerarIconGamer();
        

    }
    public void gerarIconGamer(){
        for(Jogador e: data.core.listaJogadores){
            JLabel player = new JLabel(e.nome+" "+e.genero);
            usersBars.add(player);
        }
    }
}
