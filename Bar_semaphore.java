/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bar_semaphore;

import static java.lang.Thread.sleep;

/**
 *
 * @author Nicolo
 */
public class Bar_semaphore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        
        Tavolo t = new Tavolo();
        int numClienti = 10;
        int incasso = 0;
        
        System.out.println("Apertura bar, in attesa di clienti");
        sleep((int) (Math.random()* 3000));
        
        Cameriere cam = new Cameriere(t, numClienti);
        cam.start();
        
        
        for(int i= 0; i < numClienti; i++){
            Cliente c = new Cliente(t);
            c.start();
        }
        
        for(int i = 0; i < numClienti; i++){
            Cliente c = new Cliente(t);
            c.join();
        }
        cam.join();
        incasso = t.incassoTot;
        
        System.out.println("L'incasso totale della giornata è: " + incasso + " euro");
        System.out.println("Bar in chiusura");
    }
    
}
