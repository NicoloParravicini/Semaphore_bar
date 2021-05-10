/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bar_semaphore;

/**
 *
 * @author Nicolo
 */
public class Cliente extends Thread{
    
    int numCaffe;
    Tavolo t;

    public Cliente(Tavolo t) {
        this.t = t;
    }
    
    public void run(){
        
        try {
            sleep((int) (Math.random()* 1000)); //attesa caffè
        } catch (Exception e) {
        }
        
       
        t.deposita((int) ((Math.random() * 4) + 1));
    }
    
    
}
