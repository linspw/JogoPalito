
package jogopalito;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CardSwitcher {
    CardLayout layout;
    Container container;
    public CardSwitcher(Container container, CardLayout layout) {
        this.layout = layout;
        this.container = container;
    }

    public void trocarScreen(String nome) {
        layout.show(container, nome);
    }
}