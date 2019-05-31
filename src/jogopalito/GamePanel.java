package jogopalito;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener{
    public JLabel tituloSuperior, tituloUsersBars;
    public JButton btnIniciar, btnAddJogador, btnSair, btnProximo1, btnProximo2;
    public JPanel superior, centro, centro_middle, usersBars;
    public TelaStart telaStart;
    public TelaAposta telaAposta;
    public TelaScore telaScore;
    public CardSwitcher switcher, switcherTela;
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

        tituloSuperior = new JLabel("Jogo do Palito");
        
        
        superior.add(tituloSuperior);
        superior.add(Box.createRigidArea(new Dimension(0, 80)));
        
        centro_middle.setAlignmentY(Component.CENTER_ALIGNMENT);
        
        lyt = new CardLayout();
        centro_middle.setLayout(lyt);
        switcherTela = new CardSwitcher(centro_middle, lyt);
        
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
        
        


        tituloSuperior.setSize(100, 100);
        tituloSuperior.setFont(fontTitle);
        
        add(superior, BorderLayout.NORTH);
        add(centro, BorderLayout.CENTER);
        setSize(800, 600);
    }
    
    public void trocarTela(String nome){
        lyt.show(centro_middle, nome);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object botao = e.getSource();   
    }
    public void inicializar(CardSwitcher switcher, DataTransport data){
        this.switcher = switcher;
        this.data = data;
        addComponentListener ( new ComponentAdapter ()
        {
            public void componentShown ( ComponentEvent e )
            {
                System.out.println ( "Show Game Panel" );
                telaStart = new TelaStart(switcherTela, data);
                telaAposta = new TelaAposta(switcherTela, data);
                telaScore = new TelaScore(switcherTela, data, switcher);
                centro_middle.add(telaStart, "TelaStart");
                centro_middle.add(telaAposta, "TelaAposta");
                centro_middle.add(telaScore, "TelaScore");
                lyt.show(centro_middle, "TelaStart");

            }

            public void componentHidden ( ComponentEvent e )
            {
                System.out.println ( "Hidden Game Panel" );
            }
        } );

    }
    
}
