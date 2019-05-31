package jogopalito;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.*;


public class RankingPanel extends JPanel implements ActionListener{
    private JPanel superior, centro, centro_middle;
    private JLabel tituloSuperior;
    private GridBagConstraints gbc;
    private int index = 1;
    private ResultSet rs;
    private String[] colunasTabela = new String[]{ "Posição", "Nome", "Idade", "Sexo", "Score" };
    private JTable table = new JTable();;
    private Font f = new Font("Arial", Font.BOLD, 18);
    private Font fontTitle = new Font("Verdana", Font.BOLD, 20);
    private JButton btnVoltar;
    public CardSwitcher switcher;
    public DataTransport data;

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
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 1;
        gbc.gridwidth = 3;

        gbc.anchor = GridBagConstraints.CENTER;
        
        centro.setBackground(Color.green);
        centro.add(centro_middle, gbc);
        centro_middle.setLayout(new BoxLayout(centro_middle, BoxLayout.PAGE_AXIS));
        tituloSuperior = new JLabel("Ranking de Jogadores direto do BD");
        tituloSuperior.setFont(fontTitle);
        
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
                centro_middle.removeAll();
                centro_middle.revalidate();
                gerarLista();                
            }
            public void componentHidden ( ComponentEvent ae )
            {
                System.out.println ( "Hidden MenuRanking Panel" );
            }
        });
    }
    
    public void actionPerformed(ActionEvent e) {
        Object botao = e.getSource();
        if(botao == btnVoltar){
            this.switcher.trocarScreen("Tela1");
        }
    }
    public void gerarLista(){
        try{
            Database db = new Database();
            this.rs = db.lerDados();
            DefaultTableModel modeloTabela = new DefaultTableModel(null,colunasTabela);

            modeloTabela.setColumnIdentifiers(colunasTabela);
            if(rs != null) {
                index = 1;
                while(rs.next()) {
                    System.out.println("Nome: " + rs.getString("nome") ); 
                    System.out.println("Pontuacao:" + rs.getString("pontuacao"));
                    modeloTabela.addRow(new String[] {  
                            String.valueOf(index),  
                            rs.getString("nome"),  
                            rs.getString("idade"),
                            rs.getString("sexo"),
                            rs.getString("pontuacao")
                        }); 
                    index = index + 1;
                }
            }
            btnVoltar = new JButton("Voltar");
            table = new JTable(modeloTabela);
            JTableHeader header = table.getTableHeader();
            header.setFont(f);
            
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            table.setFillsViewportHeight(true);
            JScrollPane scroll = new JScrollPane(table);
            centro_middle.add(header, BorderLayout.NORTH);
            //centro_middle.add(panelApoio, BorderLayout.CENTER);
            centro_middle.add(scroll, BorderLayout.CENTER );

            centro_middle.add(Box.createRigidArea(new Dimension(400,10)), BorderLayout.SOUTH);
            
            JPanel centralizar = new JPanel();
            centralizar.setLayout(new BoxLayout(centralizar, BoxLayout.PAGE_AXIS));
            centralizar.add(btnVoltar);
            btnVoltar.setAlignmentX(Component.CENTER_ALIGNMENT);
            btnVoltar.setAlignmentY(Component.CENTER_ALIGNMENT);

            centro_middle.add(centralizar, BorderLayout.SOUTH);
            centro_middle.setPreferredSize(new Dimension(400, 200));
            btnVoltar.addActionListener(this);

            db.delete();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void inicializar(CardSwitcher switcher, DataTransport data){
        this.switcher = switcher;
        this.data = data;
    }
}
