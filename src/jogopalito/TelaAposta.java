package jogopalito;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TelaAposta extends JPanel {
    CardSwitcher card;
    CardLayout lyt;
    JButton btnProximo;
    JPanel areaAposta, areaTools;
    JLabel frase, lblNumPalitos;
    DataTransport data;
    String valor;

    
    public TelaAposta(CardSwitcher card, DataTransport data){
        this.card = card;
        this.data = data;
        areaAposta = new JPanel();
        areaTools = new JPanel();
        valor = String.valueOf(data.core.quantJogadores);
        
        //frase = new JLabel("Fase 2");
        lblNumPalitos = new JLabel();
        //btnProximo = new JButton("Começar");
        
        
        areaAposta.setAlignmentX(Component.CENTER_ALIGNMENT);
        //frase.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblNumPalitos.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        areaTools.add(lblNumPalitos);
        //areaTools.add(frase);
        areaTools.add(areaAposta);

        //areaTools.add(btnProximo);
        areaTools.setLayout(new BoxLayout(areaTools, BoxLayout.Y_AXIS));
        areaTools.setBackground(Color.CYAN);
        
        lyt = new CardLayout();
        areaAposta.setBackground(Color.red);
        //areaAposta.setLayout(new BoxLayout(areaAposta, BoxLayout.Y_AXIS));
        areaAposta.setLayout(lyt);
        
        add(areaTools);
        setVisible(false);
        /*btnProximo.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                card.layout.next(card.container);
            } 
        });*/
        addComponentListener ( new ComponentAdapter ()
        {
            public void componentShown ( ComponentEvent e )
            {
                System.out.println ( "Show TelaAposta Panel" );
                data.core.sortearListaJogadores();
                String palito = "Palito(s): ";
                lblNumPalitos.setText(palito+String.valueOf(data.core.getTotalPalitos()));
                
                apostas(data.core.listaJogadores);
            }
            public void componentHidden ( ComponentEvent e )
            {
                areaAposta.removeAll();
                areaAposta.revalidate();
                System.out.println ( "Hidden TelaAposta Panel" );
            }
        });
    }
    public void apostas(ArrayList<Jogador> listaJogadores){
        for(Jogador e: listaJogadores){

            JPanel slotAposta = new JPanel();
            JLabel jogadorNome = new JLabel(e.getNome());
            JTextField txtAposta = new JTextField();
            JButton enviarAposta = new JButton("Apostar!");
            
            slotAposta.setLayout(new BoxLayout(slotAposta, BoxLayout.Y_AXIS));
            
            slotAposta.add(jogadorNome);
            slotAposta.add(txtAposta);
            slotAposta.add(enviarAposta);
            
            enviarAposta.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent a) { 
                    e.setAposta(Float.parseFloat(txtAposta.getText()));
                    JOptionPane.showMessageDialog(null, e.getNome());
                    lyt.next(areaAposta);
                } 
            });
            areaAposta.add(slotAposta);
        }
        JPanel slotAposta = new JPanel();
        JButton enviarAposta = new JButton("Visualizar Score!");
        enviarAposta.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                card.layout.next(card.container);
            } 
        });
        
        
        slotAposta.add(enviarAposta);
        areaAposta.add(slotAposta);
    }
}
