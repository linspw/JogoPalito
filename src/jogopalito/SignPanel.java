package jogopalito;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignPanel extends JPanel implements ActionListener{
    public JLabel tituloSuperior, lblTitulo, lblNome, lblIdade, lblGenero;
    public JButton btnCadastrar, btnCancelar;
    public JTextField txtNome, txtIdade;
    public JPanel superior, centro, centro_middle, cm_slot1, cm_slot2, cm_slot3, cm_slot4, cm_slotLeave;
    public ButtonGroup generoGroup;
    public JRadioButton rdbGeneroMasculino, rdbGeneroFeminino;
    public String genero;

    public CardSwitcher switcher;
    public DataTransport data;
    Font fontTitle = new Font("Verdana", Font.BOLD, 24);
    Font fontPainelTitle = new Font("Verdana", Font.BOLD, 20);


    
    public SignPanel(){
        setLayout(new BorderLayout());
        superior = new JPanel();
        centro = new JPanel();
        centro_middle = new JPanel();
        
        cm_slotLeave = new JPanel();
        cm_slot1 = new JPanel();
        cm_slot2 = new JPanel();
        cm_slot3 = new JPanel();
        cm_slot4 = new JPanel();
        centro_middle.setLayout(new BoxLayout(centro_middle, BoxLayout.PAGE_AXIS));
        centro.setLayout(new GridBagLayout());
        
        
        tituloSuperior = new JLabel("Cadastre o Jogador");
        lblTitulo = new JLabel("Dados do Jogador:");
        txtNome = new JTextField(10);
        lblNome = new JLabel("Nome:");
        rdbGeneroMasculino = new JRadioButton("Masculino", true);
        rdbGeneroFeminino = new JRadioButton("Feminino", false);
        generoGroup = new ButtonGroup();
        lblGenero = new JLabel("Genero:");
        txtIdade = new JTextField(10);
        lblIdade = new JLabel("Idade");
        lblTitulo.setFont(fontPainelTitle);
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        superior.add(tituloSuperior);
        superior.add(Box.createRigidArea(new Dimension(0, 80)));
        
        cm_slot1.add(lblTitulo);
        cm_slot2.add(lblNome);
        cm_slot2.add(txtNome);
        cm_slot3.add(lblGenero);
        generoGroup.add(rdbGeneroMasculino);
        generoGroup.add(rdbGeneroFeminino);

        cm_slot3.add(rdbGeneroMasculino);
        cm_slot3.add(rdbGeneroFeminino);
        cm_slot4.add(lblIdade);
        cm_slot4.add(txtIdade);
        cm_slotLeave.add(btnCadastrar);
        cm_slotLeave.add(btnCancelar);
        
        centro_middle.add(Box.createRigidArea(new Dimension(400,10)));
        centro_middle.add(cm_slot1);
        centro_middle.add(Box.createRigidArea(new Dimension(400,5)));
        centro_middle.add(cm_slot2);
        centro_middle.add(Box.createRigidArea(new Dimension(400,5)));
        centro_middle.add(cm_slot3);
        centro_middle.add(Box.createRigidArea(new Dimension(400,5)));
        centro_middle.add(cm_slot4);
        centro_middle.add(Box.createRigidArea(new Dimension(400,30)));
        centro_middle.add(cm_slotLeave);
        centro_middle.add(Box.createRigidArea(new Dimension(400,5)));
        
        centro.setBackground(Color.green);
        centro.add(centro_middle);
        tituloSuperior.setSize(100, 100);
        tituloSuperior.setFont(fontTitle);
        
        add(superior, BorderLayout.NORTH);
        add(centro, BorderLayout.CENTER);
        setSize(800, 600);
        setVisible(true);
  
    }
    public void inicializar(CardSwitcher switcher, DataTransport data){
        this.switcher = switcher;
        this.data = data;
        btnCadastrar.addActionListener(this);
        btnCancelar.addActionListener(this);

    }
    
    public void actionPerformed(ActionEvent e) {
        Object botao = e.getSource();
        if(botao == btnCadastrar){
            //JOptionPane.showMessageDialog(null, "Cadastrando!!"+getTxtNome());

            this.cadastrarJogador();
        }
        else if (botao == btnCancelar){
            this.switcher.trocarScreen("Tela1");
        }
        //tela.setTela("Tela1");
        //JOptionPane.showMessageDialog(null, "InfoBox: ");
    }
    
    public String getTxtNome(){
        return txtNome.getText();
    }
    public String getTxtIdade(){
        return txtIdade.getText();
    }
    public String getGenero(){
        if(rdbGeneroMasculino.isSelected()){
            this.genero = "M";
        }
        else{
            this.genero = "F";
        }
        return this.genero;
    }
    public void cleanAllSlots(){
        txtNome.setText("");
        txtIdade.setText("");
        rdbGeneroMasculino.setSelected(true);
    }
    public boolean checkAllSlots(){
        if(this.getTxtNome().length()==0 || this.getTxtIdade().length() == 0){
            JOptionPane.showMessageDialog(null, "Campo não preenchido");

            return false;
        }
        else{
            //JOptionPane.showMessageDialog(null, "Campo  preenchido");
            return true;
        }
    }
    public void cadastrarJogador(){
        if(this.checkAllSlots()){
            int numero = Integer.parseInt(this.getTxtIdade());
            Jogador player = new Jogador(this.getTxtNome(),this.getGenero(), numero);
            data.core.addJogador(player);
            JOptionPane.showMessageDialog(null, "Jogador Cadastrado com Sucesso!");
            this.cleanAllSlots();
            this.switcher.trocarScreen("Tela1");
            data.tela1.usersBar();
        }
        
    }
}
