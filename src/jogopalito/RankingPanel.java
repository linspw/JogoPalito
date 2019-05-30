package jogopalito;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class RankingPanel extends JPanel implements ActionListener{
    private JPanel superior, centro, centro_middle;
    private JLabel tituloSuperior;
    private GridBagConstraints gbc;
    public RankingPanel(){
        setLayout(new BorderLayout());
        superior = new JPanel();
        centro = new JPanel();
        centro_middle = new JPanel();
        
        centro_middle.setLayout(new BoxLayout(centro_middle, BoxLayout.PAGE_AXIS));
        centro.setLayout(new GridBagLayout());
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
        
        tituloSuperior = new JLabel("Cadastre o Jogador");
        
        superior.add(tituloSuperior);
        superior.add(Box.createRigidArea(new Dimension(0, 80)));
        setVisible(false);
        add(superior, BorderLayout.NORTH);
        add(centro, BorderLayout.CENTER);
        addComponentListener ( new ComponentAdapter ()
        {
            public void componentShown ( ComponentEvent ae )
            {
                System.out.println ( "Show MenuRanking Panel" );
                
            }
            public void componentHidden ( ComponentEvent ae )
            {
                System.out.println ( "Hidden MenuRanking Panel" );
            }
        });
    }
    
    public void actionPerformed(ActionEvent e) {
        Object botao = e.getSource();
    }
}
