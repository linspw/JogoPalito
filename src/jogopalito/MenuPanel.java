package jogopalito;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class MenuPanel extends JPanel implements ActionListener{
    public JLabel tituloSuperior;
    public JButton btnIniciar, btnAddJogador, btnRanking, btnSair;
    public JPanel superior, centro, centro_middle, usersBars;
    public CardSwitcher switcher;
    public GridBagConstraints gbc, gbt;
    public DataTransport data;
    public Database db;
    private Font fontTitle = new Font("Verdana", Font.BOLD, 24);
    private Font f = new Font("Arial", Font.BOLD, 18);
    public JButton btnGravarJogadores;

    private String[] colunasTabela = new String[]{ "Nome", "Score" };
    private JTable table = new JTable();


    public MenuPanel(){
        setLayout(new BorderLayout());
        superior = new JPanel();
        centro = new JPanel();
        centro_middle = new JPanel();
        usersBars = new JPanel();
        centro_middle.setLayout(new BoxLayout(centro_middle, BoxLayout.PAGE_AXIS));
        centro.setLayout(new GridBagLayout());

        tituloSuperior = new JLabel("Jogo do Palito");
        
        btnIniciar = new JButton("Iniciar jogo");
        btnIniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAddJogador = new JButton("Adicionar Jogador");
        btnAddJogador.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRanking = new JButton("Ranking");
        btnRanking.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSair = new JButton("Sair");
        btnSair.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnGravarJogadores = new JButton("Registrar Score");
        
        superior.add(tituloSuperior);
        superior.add(Box.createRigidArea(new Dimension(0, 80)));
        
        centro_middle.add(Box.createRigidArea(new Dimension(400,30)));
        centro_middle.add(btnIniciar);
        centro_middle.add(Box.createRigidArea(new Dimension(400,30)));
        centro_middle.add(btnAddJogador);
        centro_middle.add(Box.createRigidArea(new Dimension(400,30)));
        centro_middle.add(btnRanking);
        centro_middle.add(Box.createRigidArea(new Dimension(400,30)));
        centro_middle.add(btnSair);
        centro_middle.add(Box.createRigidArea(new Dimension(400,30)));
        centro_middle.setAlignmentY(Component.CENTER_ALIGNMENT);

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
        
        usersBars.setLayout(new BoxLayout(usersBars, BoxLayout.Y_AXIS));
        usersBars.setVisible(false);
        
        gbt = new GridBagConstraints();
        gbt.ipadx = 20;
        gbt.ipady = 10;
        gbc.insets = new Insets(40, 40, 10, 10);
        gbt.weightx = 0;
        gbt.weighty = 0;
        gbt.anchor = GridBagConstraints.FIRST_LINE_END;
        centro.add(usersBars, gbt);

        tituloSuperior.setSize(100, 100);
        tituloSuperior.setFont(fontTitle);
        
        add(superior, BorderLayout.NORTH);
        add(centro, BorderLayout.CENTER);
        setSize(800, 600);
        setVisible(true);
        addComponentListener ( new ComponentAdapter ()
        {
            public void componentShown ( ComponentEvent ae )
            {
                System.out.println ( "Show MenuPanel Panel" );
                listarJogadores();
            }
            public void componentHidden ( ComponentEvent ae )
            {
                System.out.println ( "Hidden MenuPanel Panel" );
            }
        });
        
    }
    
    
    public void actionPerformed(ActionEvent e) {
        Object botao = e.getSource();
        if (btnIniciar == botao) {
            if(this.data.core.listaJogadores.size()==0){
                JOptionPane.showMessageDialog(null, "Nenhum jogador Adicionado! Adicione");
            }
            else{
                this.switcher.trocarScreen("Tela3");
            }
        }
        else if(btnAddJogador == botao){
            this.switcher.trocarScreen("Tela2");
        }
        else if(btnRanking == botao){
            this.switcher.trocarScreen("Tela4");
        }
        else if(btnSair == botao){
            this.data.app.dispose();
        }
        else if(btnGravarJogadores == botao){
            db = new Database();
            db.inserirJogadores(data.core.listaJogadores);
            db.delete();
        }
    }
    public void inicializar(CardSwitcher switcher, DataTransport data){
        this.switcher = switcher;
        this.data = data;
        btnIniciar.addActionListener(this);
        btnAddJogador.addActionListener(this);
        btnRanking.addActionListener(this);
        btnSair.addActionListener(this);
        btnGravarJogadores.addActionListener(this);
    }
    public void listarJogadores(){
        if(data.core.listaJogadores.size()>0){
            usersBars.removeAll();
            usersBars.revalidate();
            usersBars.setVisible(true);
            DefaultTableModel modeloTabela = new DefaultTableModel(null,colunasTabela);
            modeloTabela.setColumnIdentifiers(colunasTabela);

            for(Jogador e: data.core.listaJogadores){
                modeloTabela.addRow(new String[] {e.getNome(), String.valueOf(e.getPontuacao())}); 

            }
            table = new JTable(modeloTabela);
            JTableHeader header = table.getTableHeader();
            header.setFont(f);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            table.setFillsViewportHeight(true);
            usersBars.add(header, BorderLayout.NORTH);
            usersBars.add(table, BorderLayout.CENTER);

            btnGravarJogadores.setAlignmentX(Component.CENTER_ALIGNMENT);
            btnGravarJogadores.setAlignmentY(Component.BOTTOM_ALIGNMENT);
            usersBars.add(btnGravarJogadores, BorderLayout.SOUTH);     
        }
        else{
            usersBars.removeAll();
            usersBars.revalidate();
            usersBars.setVisible(false);
        }
    }
}
