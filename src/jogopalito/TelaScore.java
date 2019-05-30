package jogopalito;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class TelaScore extends JPanel{
    CardSwitcher card, switcher;
    private JButton btnProximo, btnMenu;
    private JLabel frase;
    private JPanel areaAposta, areaTools;
    public DataTransport data;
    private Font f = new Font("Arial", Font.BOLD, 18);

    private String[] colunasTabela = new String[]{ "Nome", "Chute", "Valor Real", "Score"};
    private JTable table = new JTable();

    
    public TelaScore(CardSwitcher card, DataTransport data, CardSwitcher switcher){
        this.card = card;
        this.data = data;
        this.switcher = switcher;
        
        areaAposta = new JPanel();
        areaTools = new JPanel();
        
        btnProximo = new JButton("Nova Rodada");
        btnMenu = new JButton("Sair Para menu");

        JPanel linha0 = new JPanel();

        linha0.add(btnProximo);
        linha0.add(btnMenu);        

        areaTools.add(areaAposta);
        areaTools.add(linha0);
        
        
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
        DefaultTableModel modeloTabela = new DefaultTableModel(null,colunasTabela);
        modeloTabela.setColumnIdentifiers(colunasTabela);
        for(Jogador e: data.core.listaJogadores){
            modeloTabela.addRow(new String[] {e.getNome(), String.valueOf(e.getAposta()), String.valueOf(e.getPalito()), String.valueOf(e.getPontuacao())}); 
        }
        table = new JTable(modeloTabela);
        JTableHeader header = table.getTableHeader();
        header.setFont(f);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        areaAposta.add(header, BorderLayout.NORTH);
        areaAposta.add(table, BorderLayout.CENTER);
        areaAposta.revalidate();
        areaAposta.repaint();
    }
}
