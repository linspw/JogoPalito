package jogopalito;


public class DataTransport {
    public GameCore core;
    public MainScreen app;
    public MenuPanel tela1;
    public SignPanel tela2;
    public GamePanel tela3;
    public RankingPanel tela4;
    
    public DataTransport(GameCore core){
        this.core = core;
    }
    public DataTransport(GameCore core, MainScreen app){
        this.core = core;
        this.app = app;
    }
    public DataTransport(GameCore core, MainScreen app, SignPanel tela2){
        this.core = core;
        this.app = app;
        this.tela2 = tela2;
    }
    public void setMenuPanel(MenuPanel tela1){
        this.tela1 = tela1;
    }
    public void setSignPanel(SignPanel tela2){
        this.tela2 = tela2;
    }
    public void setGamePanel(GamePanel tela3){
        this.tela3 = tela3;
    }
    public void setRankingPanel(RankingPanel tela4){
        this.tela4 = tela4;
    }
}
