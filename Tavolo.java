/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bar_semaphore;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Nicolo
 */
public class Tavolo {
    
    Semaphore vuoto = new Semaphore(0);
    Semaphore pieno = new Semaphore(1);
     int numOrdinazioniCaffe;
     int incassoTot = 0;
    
    
    public void deposita(int numCaffe){
        
        try {
            vuoto.acquire();
        } catch (InterruptedException ex) {
        }
        
        this.numOrdinazioniCaffe = numCaffe;
        this.incassoTot += this.numOrdinazioniCaffe;
        System.out.println("Sono stati ordinati: " + this.numOrdinazioniCaffe + "caffe");
        pieno.release();
    }
    
    public int preleva(){
        
        try {
            pieno.acquire();
        } catch (InterruptedException ex) {
        }
        
        System.out.println("Sono stati serviti: " + this.numOrdinazioniCaffe + " caffe");
        vuoto.release();
        return this.numOrdinazioniCaffe;
    }
}
