package jogopalito;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaScore extends JPanel{
    CardSwitcher card;
    JButton btnProximo, btnMenu;
    JLabel frase;
    DataTransport data;
    
    public TelaScore(CardSwitcher card, DataTransport data, CardSwitcher switcher){
        this.card = card;
        JPanel areaAposta = new JPanel();
        JLabel frase = new JLabel("Fase3!!");
        btnProximo = new JButton("Começar");
        btnMenu = new JButton("Menu");
        areaAposta.add(btnProximo);
        areaAposta.add(frase);
        areaAposta.add(btnMenu);
        add(areaAposta);
        setVisible(false);
        btnProximo.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                card.layout.next(card.container);
            } 
        });
        btnMenu.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                switcher.layout.show(switcher.container, "Tela1");
            } 
        });
    }
}
