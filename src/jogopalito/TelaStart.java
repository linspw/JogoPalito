package jogopalito;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;


public class TelaStart extends JPanel{
    private CardSwitcher card;
    private JButton btnProximo;
    private JLabel frase;
    private DataTransport data;
    private Font f = new Font("Arial", Font.BOLD, 18);
    static int segundos;

    
    public TelaStart(CardSwitcher card, DataTransport data){
        this.card = card;
        this.data = data;
        JPanel areaTopo = new JPanel();
        JPanel areaAposta = new JPanel();
        areaAposta.setLayout(new BorderLayout());
        frase = new JLabel("Prepare-se!!");
        frase.setFont(f);
        areaTopo.add(frase);
        btnProximo = new JButton("Começar");
        areaAposta.add(areaTopo, BorderLayout.NORTH);
        areaAposta.add(btnProximo, BorderLayout.SOUTH);
        frase.setAlignmentX(Component.CENTER_ALIGNMENT);
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
                data.core.resetAllAposta();
                data.core.sortearListaJogadores();
                data.core.sortTotalPalitos();
                System.out.println(data.core.getTotalPalitos());
                atualizaLabel();
                data.core.distribuirPalitos();
                data.core.mostrarLista();
            }
            public void componentHidden ( ComponentEvent ae )
            {
                System.out.println ( "Hidden TelaStart Panel" );
            }
        });
    }
    public void atualizaLabel(){
        Timer timer = new Timer();
        segundos = 8;
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                segundos = segundos - 1;
                if(segundos >=3 ){
                    frase.setText((segundos-3) + "");
                }
                else{
                    frase.setText("Prepare-se Sorteando!!");
                }
                
                //
                if (segundos == 0) {
                    frase.setText("Palitos: "+String.valueOf(data.core.getTotalPalitos())+"!!");
                    timer.cancel();
                    timer.purge();

                }

            }
        };
        frase.setText(segundos-3 + "");

        timer.scheduleAtFixedRate(task, 1000, 1000);
    }
}
