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

        tituloSuperior = new JLabel("Jogo do Pálito");
        
        
        superior.add(tituloSuperior);
        superior.add(Box.createRigidArea(new Dimension(0, 80)));
        
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
        
        addComponentListener ( new ComponentAdapter ()
        {
            public void componentShown ( ComponentEvent e )
            {
                System.out.println ( "Show Game Panel" );
                comecarJogo();
            }

            public void componentHidden ( ComponentEvent e )
            {
                System.out.println ( "Hidden Game Panel" );
            }
        } );



        tituloSuperior.setSize(100, 100);
        tituloSuperior.setFont(fontTitle);
        
        add(superior, BorderLayout.NORTH);
        add(centro, BorderLayout.CENTER);
        setSize(800, 600);
        //setVisible(true);
    }
    
    public void trocarTela(String nome){
        lyt.show(centro_middle, nome);
    }
    public void comecarJogo(){
        TelaStart = new JPanel();
        TelaAposta = new JPanel();
        TelaPontuacao = new JPanel();
        centro_middle.add(TelaStart, "TelaStart");
        centro_middle.add(TelaAposta, "TelaAposta");
        centro_middle.add(TelaPontuacao, "TelaPontuacao");
        
        TelaStart.addComponentListener ( new ComponentAdapter ()
        {
            public void componentShown ( ComponentEvent e )
            {
                System.out.println ( "Tela Start shown" );
                etapaStart();
            }

            public void componentHidden ( ComponentEvent e )
            {
                System.out.println ( "Tela Start hidden" );
            }
        } );
        lyt.show(centro_middle, "TelaStart");



        
    }
    public void etapaStart(){
        JPanel areaAposta = new JPanel();
        JLabel frase1 = new JLabel("Fase1!!");
        btnProximo1 = new JButton("Começar");
        areaAposta.add(btnProximo1);
        areaAposta.add(frase1);
        TelaStart.add(areaAposta);
        TelaStart.setVisible(false);
        btnProximo1.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                lyt.next(centro_middle);
            } 
        });
    }
    public void etapaAposta(){
        JLabel frase2 = new JLabel("Fase2!!");
        btnProximo2 = new JButton("Proximo");
        TelaAposta.add(btnProximo2);
        TelaAposta.add(frase2);
        TelaAposta.setVisible(false);
        btnProximo2.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                lyt.next(centro_middle);
            } 
        });
    }
    public void etapaPontuacao(){
        JLabel frase = new JLabel("Fase3!!");
        JButton btnProximo = new JButton("Proximo");
        TelaPontuacao.add(btnProximo);
        TelaPontuacao.add(frase);
        TelaPontuacao.setVisible(false);
        btnProximo.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                lyt.next(centro_middle);
            } 
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object botao = e.getSource();   
    }
    public void inicializar(CardSwitcher switcher, DataTransport data){
        this.switcher = switcher;
        this.data = data;
    }
    
}
