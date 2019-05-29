package jogopalito;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaStart extends JPanel{
    CardSwitcher card;
    JButton btnProximo;
    JLabel frase;
    DataTransport data;
    
    
    public TelaStart(CardSwitcher card, DataTransport data){
        this.card = card;
        JPanel areaAposta = new JPanel();
        JLabel frase = new JLabel("Prepare-se");
        btnProximo = new JButton("Começar");
        areaAposta.add(btnProximo);
        areaAposta.add(frase);
        add(areaAposta);
        setVisible(false);
        btnProximo.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                card.layout.next(card.container);
            } 
        });
        
                        
        addComponentListener ( new ComponentAdapter ()
        {
            public void componentShown ( ComponentEvent ae )
            {
                System.out.println ( "Show TelaStart Panel" );
                data.core.sortearListaJogadores();
                data.core.sortTotalPalitos();
                data.core.distribuirPalitos();
                data.core.mostrarLista();
                
            }
            public void componentHidden ( ComponentEvent ae )
            {
                System.out.println ( "Hidden TelaStart Panel" );
            }
        });
    }
}
