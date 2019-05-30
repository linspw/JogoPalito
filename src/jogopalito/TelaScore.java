package jogopalito;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaScore extends JPanel{
    CardSwitcher card, switcher;
    JButton btnProximo, btnMenu;
    JLabel frase;
    JPanel areaAposta, areaTools;
    DataTransport data;
    
    public TelaScore(CardSwitcher card, DataTransport data, CardSwitcher switcher){
        this.card = card;
        this.data = data;
        this.switcher = switcher;
        
        areaAposta = new JPanel();
        areaTools = new JPanel();
        
        btnProximo = new JButton("Nova Rodada");
        btnMenu = new JButton("Sair Para menu");
        
        JLabel frase = new JLabel("Jogador");
        JLabel frase2 = new JLabel("Score");
        JLabel frase3 = new JLabel("Quantidade de Palitos");
        JLabel frase4 = new JLabel("Valor Apostado");

        JPanel linha = new JPanel();
        JPanel linha0 = new JPanel();

        linha0.add(btnProximo);
        linha0.add(btnMenu);        
        linha.add(frase);
        linha.add(frase2);
        linha.add(frase3);
        linha.add(frase4);
        
        areaTools.add(linha0);
        areaTools.add(linha);
        
        areaTools.add(areaAposta);
        
        areaTools.setLayout(new BoxLayout(areaTools, BoxLayout.Y_AXIS));
        areaAposta.setLayout(new BoxLayout(areaAposta, BoxLayout.Y_AXIS));

        
        areaAposta.setBackground(Color.red);

        add(areaTools);
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
        addComponentListener ( new ComponentAdapter ()
        {
            public void componentShown ( ComponentEvent ae )
            {
                System.out.println ( "Show Score Panel" );
                data.core.distribuirScore();
                mostrarScore();
                
            }
            public void componentHidden ( ComponentEvent ae )
            {
                System.out.println ( "Hidden TelaScore Panel" );
                areaAposta.removeAll();
                areaAposta.revalidate();
            }
        });
    }
    public void mostrarScore(){
        for(Jogador e: data.core.listaJogadores){
            JLabel player = new JLabel(e.getNome());
            JLabel pontua = new JLabel(String.valueOf(e.getPontuacao()));
            JLabel quantidadePalitos = new JLabel(String.valueOf(e.getPalito()));
            JLabel valorApostado = new JLabel(String.valueOf(e.aposta));
            
            JPanel linha = new JPanel();
            linha.add(player);
            linha.add(pontua);
            linha.add(quantidadePalitos);
            linha.add(valorApostado);
            areaAposta.add(linha);
        }
        areaAposta.revalidate();
        areaAposta.repaint();
    }
}
