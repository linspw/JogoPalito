package jogopalito;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JogoPalito {


    public static void main(String[] args) {
        GameCore core = new GameCore();
        //MenuPanel menu = new MenuPanel();
        
        MainScreen app = new MainScreen();
        DataTransport data = new DataTransport(core, app);
        MenuPanel tela1 = new MenuPanel();
        SignPanel tela2 = new SignPanel();
        GamePanel tela3 = new GamePanel();
        data.setMenuPanel(tela1);
        data.setSignPanel(tela2);
        data.setGamePanel(tela3);
        app.addTela(tela1, "Tela1");
        app.addTela(tela2, "Tela2");
        app.addTela(tela3, "Tela3");
        tela1.inicializar(app.switcher, data);
        tela2.inicializar(app.switcher, data);
        tela3.inicializar(app.switcher, data);
        
        
        //app.pulaTela();
        //app.setTela("Home");
        //app.setTela("ola");
    //    app.pulaTela();

        //app.addTela(menu);
        /*
        while(true){
            Scanner sc1Name = new Scanner(System.in);
            //Scanner sc1Idade = new Scanner(System.in);

            System.out.println("Digite o Nome do Jogador:");
            String name = sc1Name.next();
            //System.out.println("Digite a Idade do Jogador:");
            //int idade = sc1Idade.nextInt();
            Jogador j1 = new Jogador();
            j1.setNome(name);
            //j1.setIdade(idade);
            core.addJogador(j1);
            if(core.getLista().size()==3){
                break;
            }
        }
        core.sortearListaJogadores();
        core.mostrarLista();
        core.sortTotalPalitos();
        System.out.printf("Valor total de palitos: %d\n",core.getTotalPalitos());
        core.distribuirPalitos();
        core.mostrarLista();
        core.sortearListaJogadores();*/

/*
        for(int i=0; i<100; i++){
            System.out.printf("\n\n\n\n %dª - Teste \n",i);
            core.sortTotalPalitos();
            System.out.printf("Valor total de palitos: %d\n",core.getTotalPalitos());
            core.distribuirPalitos();
            core.mostrarLista();
        }*/
        /*
        for(Jogador e: core.listaJogadores){
            Scanner sc1Valor = new Scanner(System.in);
            System.out.printf("Digite o valor da Aposta, %s: \n",e.getNome());
            String valor = sc1Valor.next();

            e.setAposta(Integer.parseInt(valor));
        }
        core.distribuirScore();
        core.mostrarPontuacao();
        
*/        
    }
}
