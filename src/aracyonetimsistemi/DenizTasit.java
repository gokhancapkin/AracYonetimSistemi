/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aracyonetimsistemi;

/**
 *
 * @author Ercan
 */
public class DenizTasit extends Arac{
    public void hizlanma(int c)
    {
    this.setAracHiz(this.getAracHiz()+c); 
    }
    public void yavasla(int c)
    {
        if (this.getAracHiz()<c)
        {System.out.println("Yavaşlatmak istediğiniz hız aracın hızından büyük");}
    else
        {
            this.setAracHiz(this.getAracHiz()-c);
        }
            
    }
}
