package jogopalito;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TelaAposta extends JPanel {
    CardSwitcher card;
    JButton btnProximo;
    JPanel areaAposta, areaTools;
    JLabel frase, lblNumPalitos;
    DataTransport data;
    String valor;
    int i=0;

    
    public TelaAposta(CardSwitcher card, DataTransport data){
        this.card = card;
        this.data = data;
        areaAposta = new JPanel();
        areaTools = new JPanel();
        valor = String.valueOf(data.core.quantJogadores);
        
        frase = new JLabel("Fase 2");
        lblNumPalitos = new JLabel();
        btnProximo = new JButton("Começar");
        
        areaAposta.setBackground(Color.red);
        
        areaAposta.setAlignmentX(Component.CENTER_ALIGNMENT);
        frase.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblNumPalitos.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        areaTools.add(lblNumPalitos);
        areaTools.add(frase);
        areaTools.add(areaAposta);

        areaTools.add(btnProximo);
        areaTools.setLayout(new BoxLayout(areaTools, BoxLayout.Y_AXIS));
        areaTools.setBackground(Color.CYAN);
        
        add(areaTools);
        setVisible(false);
        btnProximo.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                card.layout.next(card.container);
            } 
        });
        addComponentListener ( new ComponentAdapter ()
        {
            public void componentShown ( ComponentEvent e )
            {
                System.out.println ( "Show TelaAposta Panel" );
                String palito = "Palito(s): ";
                lblNumPalitos.setText(palito+String.valueOf(data.core.getTotalPalitos()));
                
                i = i + 1;
                //areaAposta.add(new Label(palito+String.valueOf(i)));
                apostas(data.core.listaJogadores);
            }
            public void componentHidden ( ComponentEvent e )
            {
                System.out.println ( "Hidden TelaAposta Panel" );
            }
        });
    }
    public void apostas(ArrayList<Jogador> listaJogadores){
        for(Jogador e: listaJogadores){
            areaAposta.removeAll();
            areaAposta.revalidate();
            JLabel jogadorNome = new JLabel(e.getNome());
            areaAposta.add(jogadorNome);
            JOptionPane.showMessageDialog(null, e.getNome());
        }
    }
}
