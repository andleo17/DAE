
import java.awt.Frame;


public class Main {
    
   public static void main (String args[]) {
       JFPrincipal principal = new JFPrincipal();
       principal.setExtendedState(Frame.MAXIMIZED_BOTH);
       principal.setVisible(true);
   }
    
}
