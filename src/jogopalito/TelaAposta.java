package jogopalito;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.border.*;

public class TelaAposta extends JPanel {
    private CardSwitcher card;
    private CardLayout lyt;
    private JButton btnProximo;
    private JPanel areaAposta, areaTools;
    private JLabel frase, lblNumPalitos;
    private DataTransport data;
    private String valor;
    private Font f = new Font("Arial", Font.BOLD, 18);

    
    public TelaAposta(CardSwitcher card, DataTransport data){
        this.card = card;
        this.data = data;
        areaAposta = new JPanel();
        areaTools = new JPanel();
        valor = String.valueOf(data.core.quantJogadores);
        
        lblNumPalitos = new JLabel();
        lblNumPalitos.setFont(f);
        
        areaAposta.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblNumPalitos.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        areaTools.setLayout(new BorderLayout());
        areaTools.add(lblNumPalitos, BorderLayout.NORTH);
        areaTools.add(areaAposta, BorderLayout.CENTER);

        areaTools.setLayout(new BoxLayout(areaTools, BoxLayout.Y_AXIS));
        areaTools.setBackground(Color.CYAN);
        
        lyt = new CardLayout();
        //areaAposta.setBackground(Color.red);
        areaAposta.setLayout(lyt);
        areaAposta.setBorder(new EmptyBorder(10, 10, 10, 10));
;
        
        add(areaTools);
        setVisible(false);

        addComponentListener ( new ComponentAdapter ()
        {
            public void componentShown ( ComponentEvent e )
            {
                System.out.println ( "Show TelaAposta Panel" );
                data.core.sortearListaJogadores();
                String palito = "Palito(s) no Total: ";
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
            
            slotAposta.setLayout(new BorderLayout());
            
            txtAposta.setBorder(new EmptyBorder(10, 10, 10, 10));
            enviarAposta.setBorder(new EmptyBorder(10, 10, 10, 10));
            
            slotAposta.add(jogadorNome, BorderLayout.NORTH);
            slotAposta.add(txtAposta, BorderLayout.CENTER);
            slotAposta.add(enviarAposta, BorderLayout.SOUTH);
            
            enviarAposta.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent a) {
                    boolean isNumber;
                    try {
                        Integer.parseInt(txtAposta.getText());
                        isNumber = true;
                    }catch (NumberFormatException e) {
                        isNumber = false;
                    }
                    if(txtAposta.getText().length()==0){
                        JOptionPane.showMessageDialog(null, "Campo não preenchido!");

                        
                    }else if (isNumber == false){
                        JOptionPane.showMessageDialog(null, "Digite um número!");
                    }else{
                        e.setAposta(Float.parseFloat(txtAposta.getText()));
                        lyt.next(areaAposta);
                    }
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
