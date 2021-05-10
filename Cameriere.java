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
public class Cameriere extends Thread{
    
    int numcaffe;
    Tavolo t;
    int numClienti;

    public Cameriere(Tavolo t, int numClienti) {
        this.t = t;
        this.numClienti = numClienti;
    }
    
    public void run(){
        
        while(numClienti > 0){
            
            numcaffe = t.preleva();
            
            try {
                sleep ((int)  (Math.random()* 1000)); //prepara caffè
            } catch (InterruptedException ex) {
            }
            
            numClienti --;
        }
        
    }
}
