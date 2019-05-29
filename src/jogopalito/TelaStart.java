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
        JLabel frase = new JLabel("Fase1!!");
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
    }
}
