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
public class ucanGemi extends HavaTasit {

    public class ucanGemi1 extends DenizTasit {

        @Override
        public void durdur() {
            if (this.getAracHiz() != 0) {
                System.out.println("Uçak durdurulamadı. Şuanda " + this.getAracHiz() + " hiz ile seyir halinde");
            } else {
                System.out.println("Uçan Gemi durduruldu");

            }

        }

        @Override
        public void hizlanma(int c) {
            this.setAracHiz(this.getAracHiz() + c);
        }

        @Override
        public void yavasla(int c) {
            if (this.getAracHiz() < c) {
                System.out.println("Yavaşlatmak istediğiniz hız aracın hızından büyük");
            } else {
                this.setAracHiz(this.getAracHiz() - c);
            }

        }
        

        public void setID(int deger) {
            this.setID("ucangemi" + String.valueOf(deger));
        }
    }
}
