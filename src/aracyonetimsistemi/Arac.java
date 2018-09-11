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
public class Arac {
    
    private String aracMarka;
    private String aracYakit;
    private int aracHiz;
    private int aracYolcuSayisi;
    private int aracTekerSayisi;
    private int aracFiyat;
    private int aracUretimYili;
    private String aracRenk;
    private String ID;
    
   
    public Arac()
    {}
    
    public Arac(String aracMarka, String aracYakit, int aracHiz, int aracYolcuSayisi, int aracTekerSayisi, int aracFiyat, int aracUretimYili,String aracRenk )
    {
    this.aracMarka=aracMarka;
    this.aracYakit=aracYakit;
    this.aracHiz=aracHiz;
    this.aracYolcuSayisi=aracYolcuSayisi;
    this.aracTekerSayisi=aracTekerSayisi;
    this.aracFiyat=aracFiyat;
    this.aracUretimYili=aracUretimYili;
    this.aracRenk=aracRenk;
    }
    /**
     * @return the aracMarka
     */
    public String getAracMarka() {
        return aracMarka;
    }

    /**
     * @param aracMarka the aracMarka to set
     */
    public void setAracMarka(String aracMarka) {
        this.aracMarka = aracMarka;
    }

    /**
     * @return the aracYakit
     */
    public String getAracYakit() {
        return aracYakit;
    }

    /**
     * @param aracYakit the aracYakit to set
     */
    public void setAracYakit(String aracYakit) {
        this.aracYakit = aracYakit;
    }

    /**
     * @return the aracHiz
     */
    public int getAracHiz() {
        return aracHiz;
    }

    /**
     * @param aracHiz the aracHiz to set
     */
    public void setAracHiz(int aracHiz) {
        this.aracHiz = aracHiz;
    }

    /**
     * @return the aracYolcuSayisi
     */
    public int getAracYolcuSayisi() {
        return aracYolcuSayisi;
    }

    /**
     * @param aracYolcuSayisi the aracYolcuSayisi to set
     */
    public void setAracYolcuSayisi(int aracYolcuSayisi) {
        this.aracYolcuSayisi = aracYolcuSayisi;
    }

    /**
     * @return the aracTekerSayisi
     */
    public int getAracTekerSayisi() {
        return aracTekerSayisi;
    }

    /**
     * @param aracTekerSayisi the aracTekerSayisi to set
     */
    public void setAracTekerSayisi(int aracTekerSayisi) {
        this.aracTekerSayisi = aracTekerSayisi;
    }

    /**
     * @return the aracFiyat
     */
    public int getAracFiyat() {
        return aracFiyat;
    }

    /**
     * @param aracFiyat the aracFiyat to set
     */
    public void setAracFiyat(int aracFiyat) {
        this.aracFiyat = aracFiyat;
    }

    /**
     * @return the aracUretimYili
     */
    public int getAracUretimYili() {
        return aracUretimYili;
    }

    /**
     * @param aracUretimYili the aracUretimYili to set
     */
    public void setAracUretimYili(int aracUretimYili) {
        this.aracUretimYili = aracUretimYili;
    }

    /**
     * @return the aracRenk
     */
    public String getAracRenk() {
        return aracRenk;
    }

    /**
     * @param aracRenk the aracRenk to set
     */
    public void setAracRenk(String aracRenk) {
        this.aracRenk = aracRenk;
    }

    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }
    public void durdur()
    {
       
    this.aracHiz=0;
    }
    public void hizlanma()
    { 
    }
    public void yavasla()
    {
    }
}
