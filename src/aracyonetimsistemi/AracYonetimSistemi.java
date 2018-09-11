/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aracyonetimsistemi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ercan
 */
public class AracYonetimSistemi {

    /**
     * @param args the command line arguments
     */
    static List<Otomobil> otomobil = new ArrayList<Otomobil>();
    static List<Arac> arac = new ArrayList<Arac>();
    static int[] idNow = new int[5];

    public static void main(String[] args) throws IOException {

        menuFonk();
    }

    static void menuFonk() throws IOException {
        Scanner scan = new Scanner(System.in);
        int menu1 = 0, menu2 = 0, menu3 = 0, degis;
        String deger, idGir;

        while (true) {
            for (int i = 0; i < 5; i++) {
                idNow[i] = 0;
            }
            if (menu1 == 4 || menu2 == 7 || menu3 == 5) {
                break;
            }
            menu1 = 0;
            menu2 = 0;
            menu3 = 0;
            System.out.println("Yapmak istediğiniz işlemi seçiniz:");
            System.out.println("1. Veri Girişinde Bulun");
            System.out.println("2. Veri Listele");
            System.out.println("3. Veri Güncelle");
            System.out.println("4. Çıkış");
            menu1 = scan.nextInt();
            switch (menu1) {
                case 1:
                    System.out.println("Veri girişinde bulunacağınız aracı seçiniz");
                    System.out.println("1. Otomobil");
                    System.out.println("2. Bisiklet");
                    System.out.println("3. Gemi");
                    System.out.println("4. Uçak");
                    System.out.println("5. Uçan Gemi");
                    System.out.println("6. Bir önceki menüye geri dön");
                    System.out.println("7. Çıkış");
                    menu2 = scan.nextInt();
                    switch (menu2) {
                        case 1: {
                            try {
                                otomobilEkle();
                            } catch (IOException ex) {
                                Logger.getLogger(AracYonetimSistemi.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                        case 2: {
                            try {
                                bisikletEkle();
                            } catch (IOException ex) {
                                Logger.getLogger(AracYonetimSistemi.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                        case 3: {
                            try {
                                gemiEkle();
                            } catch (IOException ex) {
                                Logger.getLogger(AracYonetimSistemi.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                        case 4: {
                            try {
                                ucakEkle();
                            } catch (IOException ex) {
                                Logger.getLogger(AracYonetimSistemi.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                        case 5: {
                            try {
                                ucanGemiEkle();
                            } catch (IOException ex) {
                                Logger.getLogger(AracYonetimSistemi.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                        case 6:
                            menuFonk();
                            break;
                        case 7:
                            System.exit(0);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Listelemek İstediğiniz Veri Tipini Seçiniz");
                    System.out.println("1. Kara Taşıtları");
                    System.out.println("2. Deniz Taşıtları");
                    System.out.println("3. Hava Taşıtları");
                    System.out.println("4. Bir önceki menüye geri dön");
                    System.out.println("5. Çıkış");
                    menu3 = scan.nextInt();
                    switch (menu3) {
                        case 1: {
                            try {
                                kayitListele(menu3);
                            } catch (IOException ex) {
                                Logger.getLogger(AracYonetimSistemi.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                        case 2:
                            try {
                                kayitListele(menu3);
                            } catch (IOException ex) {
                                Logger.getLogger(AracYonetimSistemi.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        case 3:
                            try {
                                kayitListele(menu3);
                            } catch (IOException ex) {
                                Logger.getLogger(AracYonetimSistemi.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        case 4:
                            menuFonk();
                            break;
                        case 5:
                            System.exit(0);
                            break;

                    }
                    break;
                case 3:
                    int sorgu = -1;
                    System.out.println("ID giriniz");
                    idGir = scan.next();
                    if (idSearch(idGir) == false) {
                        break;
                    }
                    if (idGir.startsWith("bisiklet")) {
                        sorgu = 1;
                    }
                    if (idGir.startsWith("gemi")) {
                        sorgu = 2;
                    }
                    String secim;
                    String newDeger;
                    System.out.println("Markayi degistirmek icin 'marka'");
                    if (sorgu != 0) {
                        System.out.println("Yakit turunu degistirmek icin 'yakit'");
                    }
                    System.out.println("Hizini degistirmek icin 'hiz'");
                    System.out.println("Yolcu sayisini degistirmek icin 'yolcusayisi'");
                    if (sorgu != 2) {
                        System.out.println("Tekerlek Sayisini degistirmek icin 'tekerleksayisi'");
                    }
                    System.out.println("Fiyatini degistirmek icin 'fiyat'");
                    System.out.println("Uretim yilini degistirmek icin 'uretimyili'");
                    System.out.println("Rengini degistirmek icin 'renk' yaziniz");
                    secim = scan.next();
                    switch (secim) {
                        case "marka": {
                            System.out.println("Yeni markayı giriniz");
                            newDeger = scan.next();
                            dosyaGuncelle(idGir, 1, newDeger);
                            menuFonk();
                            break;
                        }
                        case "yakit": {
                            System.out.println("Yeni yakit türünü giriniz");
                            newDeger = scan.next();
                            dosyaGuncelle(idGir, 2, newDeger);
                            menuFonk();
                            break;
                        }
                        case "hiz": {
                            System.out.println("Yeni hizi giriniz");
                            newDeger = scan.next();
                            dosyaGuncelle(idGir, 3, newDeger);
                            menuFonk();
                            break;
                        }
                        case "yolcusayisi": {
                            System.out.println("Yeni yolcu sayisini giriniz");
                            newDeger = scan.next();
                            dosyaGuncelle(idGir, 4, newDeger);
                            menuFonk();
                            break;
                        }
                        case "tekerleksayisi": {
                            System.out.println("Yeni tekerlek sayisini giriniz");
                            newDeger = scan.next();
                            dosyaGuncelle(idGir, 5, newDeger);
                            menuFonk();
                            break;
                        }
                        case "fiyat": {
                            System.out.println("Yeni fiyati giriniz");
                            newDeger = scan.next();
                            dosyaGuncelle(idGir, 6, newDeger);
                            menuFonk();
                            break;
                        }
                        case "uretimyili": {
                            System.out.println("Yeni uretim yilini giriniz");
                            newDeger = scan.next();
                            dosyaGuncelle(idGir, 7, newDeger);
                            menuFonk();
                            break;
                        }
                        case "renk": {
                            System.out.println("Yeni rengi giriniz");
                            newDeger = scan.next();
                            dosyaGuncelle(idGir, 8, newDeger);
                            menuFonk();
                            break;
                        }

                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

    static void otomobilEkle() throws IOException {
        String Marka;
        String Yakit;
        int hizDegis;
        int Hiz;
        int YolcuSayisi;
        int TekerSayisi;
        int Fiyat;
        int UretimYili;
        String aracRenk;
        String cevap;
        Scanner sc = new Scanner(System.in);
        Otomobil oto = new Otomobil();
        System.out.println("Marka giriniz");
        Marka = sc.next();
        oto.setAracMarka(Marka);
        System.out.println("Yakit türünü giriniz");
        Yakit = sc.next();
        oto.setAracYakit(Yakit);
        System.out.println("Hizini giriniz");
        Hiz = sc.nextInt();
        oto.setAracHiz(Hiz);
        System.out.println("Yolcu Sayisini giriniz");
        YolcuSayisi = sc.nextInt();
        oto.setAracYolcuSayisi(YolcuSayisi);
        System.out.println("Tekerlek Sayisini giriniz");
        TekerSayisi = sc.nextInt();
        oto.setAracTekerSayisi(TekerSayisi);
        System.out.println("Fiyatini giriniz");
        Fiyat = sc.nextInt();
        oto.setAracFiyat(Fiyat);
        System.out.println("Üretim yılını giriniz");
        UretimYili = sc.nextInt();
        oto.setAracUretimYili(UretimYili);
        System.out.println("Rengini giriniz");
        aracRenk = sc.next();
        oto.setAracRenk(aracRenk);
        while (true) {
            System.out.println("Su an aracin hizi " + oto.getAracHiz());
            System.out.println("Hizlanmak için'hizlan' yavaslamak icin 'yavasla' durmak için 'dur' yazınız ");
            System.out.println("Islem yapmak istemiyorsanız 'b' yazınız");
            cevap = sc.next();
            if (cevap.equals("hizlan")) {
                System.out.println("Hizlanma miktarini girin");
                hizDegis = sc.nextInt();
                oto.hizlanma(hizDegis);
                System.out.println("Su an aracin hizi " + oto.getAracHiz());
                idKontrol();
                oto.setID(idNow[0] + 1);
                dosyaKayit(oto);
                break;
            }
            else if (cevap.equals("yavasla")) {
                System.out.println("Yavaslama miktarini girin");
                hizDegis = sc.nextInt();
                oto.yavasla(hizDegis);
                System.out.println("Su an aracin hizi " + oto.getAracHiz());
                idKontrol();
                oto.setID(idNow[0] + 1);
                dosyaKayit(oto);
                break;
            }
            else if (cevap.equals("durdur")) {
                oto.durdur();
                System.out.println("Su an aracin hizi " + oto.getAracHiz());
                idKontrol();
                oto.setID(idNow[0] + 1);
                dosyaKayit(oto);
                break;
            }
            else if(cevap.equals("b")){
                idKontrol();
                oto.setID(idNow[0] + 1);
                dosyaKayit(oto);
                break;
            }
            else System.out.println("Yanlis secim yaptiniz.Tekrar deneyin");
        }

        
    }

    static void bisikletEkle() throws IOException {
        String Marka;
        String Yakit;
        int hizDegis;
        int Hiz;
        int YolcuSayisi;
        int TekerSayisi;
        int Fiyat;
        int UretimYili;
        String ID;
        String aracRenk;
        String cevap;

        Scanner sc = new Scanner(System.in);
        Bisiklet bis = new Bisiklet();
        System.out.println("Marka giriniz");
        Marka = sc.next();
        bis.setAracMarka(Marka);
        System.out.println("Hizini giriniz");
        Hiz = sc.nextInt();
        bis.setAracHiz(Hiz);
        System.out.println("Yolcu Sayisini giriniz");
        YolcuSayisi = sc.nextInt();
        bis.setAracYolcuSayisi(YolcuSayisi);
        System.out.println("Tekerlek Sayisini giriniz");
        TekerSayisi = sc.nextInt();
        bis.setAracTekerSayisi(TekerSayisi);
        System.out.println("Fiyatini giriniz");
        Fiyat = sc.nextInt();
        bis.setAracFiyat(Fiyat);
        System.out.println("Üretim yılını giriniz");
        UretimYili = sc.nextInt();
        bis.setAracUretimYili(UretimYili);
        System.out.println("Rengini giriniz");
        aracRenk = sc.next();
        bis.setAracRenk(aracRenk);
        
        while (true) {
            System.out.println("Su an aracin hizi " + bis.getAracHiz());
            System.out.println("Hizlanmak için'hizlan' yavaslamak icin 'yavasla' durmak için 'dur' yazınız ");
            System.out.println("Islem yapmak istemiyorsanız 'b' yazınız");
            cevap = sc.next();
            if (cevap.equals("hizlan")) {
                System.out.println("Hizlanma miktarini girin");
                hizDegis = sc.nextInt();
                bis.hizlanma(hizDegis);
                System.out.println("Su an aracin hizi " + bis.getAracHiz());
                idKontrol();
                bis.setID(idNow[1] + 1);
                dosyaKayit(bis);
                break;
            }
            else if (cevap.equals("yavasla")) {
                System.out.println("Yavaslama miktarini girin");
                hizDegis = sc.nextInt();
                bis.yavasla(hizDegis);
                System.out.println("Su an aracin hizi " + bis.getAracHiz());
                idKontrol();
                bis.setID(idNow[1] + 1);
                dosyaKayit(bis);
                break;
            }
            else if (cevap.equals("dur")) {
                bis.durdur();
                System.out.println("Su an aracin hizi " + bis.getAracHiz());
                idKontrol();
                bis.setID(idNow[1] + 1);
                dosyaKayit(bis);
                break;
            }
            else if(cevap.equals("b")){
                idKontrol();
                bis.setID(idNow[1] + 1);
                dosyaKayit(bis);
                break;
            }
            else System.out.println("Yanlis secim yaptiniz.Tekrar deneyin");
        }
    }

    static void gemiEkle() throws IOException {
        String Marka;
        String Yakit;
        int Hiz;
        int YolcuSayisi;
        int Fiyat;
        int UretimYili;
        int hizDegis;
        String ID;
        String aracRenk;
        String cevap;

        Scanner sc = new Scanner(System.in);
        Gemi gemi = new Gemi();
        System.out.println("Marka giriniz");
        Marka = sc.next();
        gemi.setAracMarka(Marka);
        System.out.println("Yakit türünü giriniz");
        Yakit = sc.next();
        gemi.setAracYakit(Yakit);
        System.out.println("Hizini giriniz");
        Hiz = sc.nextInt();
        gemi.setAracHiz(Hiz);
        System.out.println("Yolcu Sayisini giriniz");
        YolcuSayisi = sc.nextInt();
        gemi.setAracYolcuSayisi(YolcuSayisi);
        System.out.println("Fiyatini giriniz");
        Fiyat = sc.nextInt();
        gemi.setAracFiyat(Fiyat);
        System.out.println("Üretim yılını giriniz");
        UretimYili = sc.nextInt();
        gemi.setAracUretimYili(UretimYili);
        System.out.println("Rengini giriniz");
        aracRenk = sc.next();
        gemi.setAracRenk(aracRenk);
        
        while (true) {
            System.out.println("Su an aracin hizi " + gemi.getAracHiz());
            System.out.println("Hizlanmak için'hizlan' yavaslamak icin 'yavasla' durmak için 'dur' yazınız ");
            System.out.println("Islem yapmak istemiyorsanız 'b' yazınız");
            cevap = sc.next();
            if (cevap.equals("hizlan")) {
                System.out.println("Hizlanma miktarini girin");
                hizDegis = sc.nextInt();
                gemi.hizlanma(hizDegis);
                System.out.println("Su an aracin hizi " + gemi.getAracHiz());
                idKontrol();
                gemi.setID(idNow[2] + 1);
                dosyaKayit(gemi);
                break;
            }
            else if (cevap.equals("yavasla")) {
                System.out.println("Yavaslama miktarini girin");
                hizDegis = sc.nextInt();
                gemi.yavasla(hizDegis);
                System.out.println("Su an aracin hizi " + gemi.getAracHiz());
                idKontrol();
                gemi.setID(idNow[2] + 1);
                dosyaKayit(gemi);
                break;
            }
            else if (cevap.equals("dur")) {
                gemi.durdur();
                System.out.println("Su an aracin hizi " + gemi.getAracHiz());
                idKontrol();
                gemi.setID(idNow[2] + 1);
                dosyaKayit(gemi);
                break;
            }
            else if(cevap.equals("b")){
                idKontrol();
                gemi.setID(idNow[2] + 1);
                dosyaKayit(gemi);
                break;
            }
            else System.out.println("Yanlis secim yaptiniz.Tekrar deneyin");
        }
        
        
        
    }

    static void ucakEkle() throws IOException {
        String Marka;
        String Yakit;
        int hizDegis;
        int Hiz;
        int YolcuSayisi;
        int TekerSayisi;
        int Fiyat;
        int UretimYili;
        String cevap;
        String ID;
        String aracRenk;

        Scanner sc = new Scanner(System.in);
        Ucak ucak = new Ucak();
        System.out.println("Marka giriniz");
        Marka = sc.next();
        ucak.setAracMarka(Marka);
        System.out.println("Yakit türünü giriniz");
        Yakit = sc.next();
        ucak.setAracYakit(Yakit);
        System.out.println("Hizini giriniz");
        Hiz = sc.nextInt();
        ucak.setAracHiz(Hiz);
        System.out.println("Yolcu Sayisini giriniz");
        YolcuSayisi = sc.nextInt();
        ucak.setAracYolcuSayisi(YolcuSayisi);
        System.out.println("Tekerlek Sayisini giriniz");
        TekerSayisi = sc.nextInt();
        ucak.setAracTekerSayisi(TekerSayisi);
        System.out.println("Fiyatini giriniz");
        Fiyat = sc.nextInt();
        ucak.setAracFiyat(Fiyat);
        System.out.println("Üretim yılını giriniz");
        UretimYili = sc.nextInt();
        ucak.setAracUretimYili(UretimYili);
        System.out.println("Rengini giriniz");
        aracRenk = sc.next();
        ucak.setAracRenk(aracRenk);

        while (true) {
            System.out.println("Su an aracin hizi " + ucak.getAracHiz());
            System.out.println("Hizlanmak için'hizlan' yavaslamak icin 'yavasla' durmak için 'dur' yazınız ");
            System.out.println("Islem yapmak istemiyorsanız 'b' yazınız");
            cevap = sc.next();
            if (cevap.equals("hizlan")) {
                System.out.println("Hizlanma miktarini girin");
                hizDegis = sc.nextInt();
                ucak.hizlanma(hizDegis);
                System.out.println("Su an aracin hizi " + ucak.getAracHiz());
                idKontrol();
                ucak.setID(idNow[2] + 1);
                dosyaKayit(ucak);
                break;
            }
            else if (cevap.equals("yavasla")) {
                System.out.println("Yavaslama miktarini girin");
                hizDegis = sc.nextInt();
                ucak.yavasla(hizDegis);
                System.out.println("Su an aracin hizi " + ucak.getAracHiz());
                idKontrol();
                ucak.setID(idNow[2] + 1);
                dosyaKayit(ucak);
                break;
            }
            else if (cevap.equals("dur")) {
                ucak.durdur();
                System.out.println("Su an aracin hizi " + ucak.getAracHiz());
                idKontrol();
                ucak.setID(idNow[2] + 1);
                dosyaKayit(ucak);
                break;
            }
            else if(cevap.equals("b")){
                idKontrol();
                ucak.setID(idNow[2] + 1);
                dosyaKayit(ucak);
                break;
            }
            else System.out.println("Yanlis secim yaptiniz.Tekrar deneyin");
        }
    }

    static void ucanGemiEkle() throws IOException {
        String Marka;
        String Yakit;
        int hizDegis;
        int Hiz;
        int YolcuSayisi;
        int TekerSayisi;
        int Fiyat;
        int UretimYili;
        String cevap;
        String ID;
        String aracRenk;

        Scanner sc = new Scanner(System.in);
        ucanGemi ug = new ucanGemi();
        ucanGemi.ucanGemi1 ugemi = ug.new ucanGemi1();

        System.out.println("Marka giriniz");
        Marka = sc.next();
        ugemi.setAracMarka(Marka);
        System.out.println("Yakit türünü giriniz");
        Yakit = sc.next();
        ugemi.setAracYakit(Yakit);
        System.out.println("Hizini giriniz");
        Hiz = sc.nextInt();
        ugemi.setAracHiz(Hiz);
        System.out.println("Yolcu Sayisini giriniz");
        YolcuSayisi = sc.nextInt();
        ugemi.setAracYolcuSayisi(YolcuSayisi);
        System.out.println("Tekerlek Sayisini giriniz");
        TekerSayisi = sc.nextInt();
        ugemi.setAracTekerSayisi(TekerSayisi);
        System.out.println("Fiyatini giriniz");
        Fiyat = sc.nextInt();
        ugemi.setAracFiyat(Fiyat);
        System.out.println("Üretim yılını giriniz");
        UretimYili = sc.nextInt();
        ugemi.setAracUretimYili(UretimYili);
        System.out.println("Rengini giriniz");
        aracRenk = sc.next();
        ugemi.setAracRenk(aracRenk);
        
        while (true) {
            System.out.println("Su an aracin hizi " + ugemi.getAracHiz());
            System.out.println("Hizlanmak için'hizlan' yavaslamak icin 'yavasla' durmak için 'dur' yazınız ");
            System.out.println("Islem yapmak istemiyorsanız 'b' yazınız");
            cevap = sc.next();
            if (cevap.equals("hizlan")) {
                System.out.println("Hizlanma miktarini girin");
                hizDegis = sc.nextInt();
                ugemi.hizlanma(hizDegis);
                System.out.println("Su an aracin hizi " + ugemi.getAracHiz());
                idKontrol();
                ugemi.setID(idNow[2] + 1);
                dosyaKayit(ugemi);
                break;
            }
            else if (cevap.equals("yavasla")) {
                System.out.println("Yavaslama miktarini girin");
                hizDegis = sc.nextInt();
                ugemi.yavasla(hizDegis);
                System.out.println("Su an aracin hizi " + ugemi.getAracHiz());
                idKontrol();
                ugemi.setID(idNow[2] + 1);
                dosyaKayit(ugemi);
                break;
            }
            else if (cevap.equals("dur")) {
                ugemi.durdur();
                System.out.println("Su an aracin hizi " + ugemi.getAracHiz());
                idKontrol();
                ugemi.setID(idNow[2] + 1);
                dosyaKayit(ugemi);
                break;
            }
            else if(cevap.equals("b")){
                idKontrol();
                ugemi.setID(idNow[2] + 1);
                dosyaKayit(ugemi);
                break;
            }
            else System.out.println("Yanlis secim yaptiniz.Tekrar deneyin");
        }
    }

    static boolean idSearch(String id) throws FileNotFoundException, IOException {
        boolean devam = true;
        File file = new File("aracKayit.txt");
        String sinif = null;
        if (!file.exists()) {
            devam = false;
        }
        if (devam == true) {
            FileReader fileReader = new FileReader("aracKayit.txt");
            BufferedReader br = new BufferedReader(fileReader);
            String[] line = new String[9];
            String text = br.readLine();
            while (text != null) {
                line = text.split(",");
                if (line[0].equals(id)) {
                    return true;
                }
                text = br.readLine();
            }
        }
        return false;
    }

    static void idKontrol() throws FileNotFoundException, IOException {
        boolean devam = true;
        File file = new File("aracKayit.txt");
        String sinif = null;
        if (!file.exists()) {
            devam = false;
        }
        if (devam == true) {
            FileReader fileReader = new FileReader("aracKayit.txt");
            BufferedReader br = new BufferedReader(fileReader);
            String[] line = new String[9];
            String text = br.readLine();
            while (text != null) {
                line = text.split(",");
                int a = 0;
                if (line[0].startsWith("otomobil")) {
                    sinif = line[0].replace("otomobil", "");
                    idNow[0] = Integer.parseInt(sinif);
                }
                if (line[0].startsWith("bisiklet")) {
                    sinif = line[0].replace("bisiklet", "");
                    idNow[1] = Integer.parseInt(sinif);
                }
                if (line[0].startsWith("gemi")) {
                    sinif = line[0].replace("gemi", "");
                    idNow[2] = Integer.parseInt(sinif);
                }
                if (line[0].startsWith("ucangemi")) {
                    sinif = line[0].replace("ucangemi", "");
                    idNow[3] = Integer.parseInt(sinif);
                }
                if (line[0].startsWith("ucak")) {
                    sinif = line[0].replace("ucak", "");
                    idNow[4] = Integer.parseInt(sinif);
                }
                text = br.readLine();
            }
        }

    }

    static void listele() throws IOException {
        String secim;
        Scanner sc = new Scanner(System.in);
        System.out.println("Kara için 1");
        System.out.println("Deniz için 2");
        System.out.println("Hava için 3");
        secim = sc.next();
        kayitListele(Integer.parseInt(secim));
    }

    private static void dosyaKayit(Otomobil oto) throws IOException {

        String str = oto.getID() + "," + oto.getAracMarka() + "," + oto.getAracYakit() + "," + oto.getAracHiz() + "," + oto.getAracYolcuSayisi() + "," + oto.getAracTekerSayisi() + "," + oto.getAracFiyat() + "," + oto.getAracUretimYili() + "," + oto.getAracRenk();
        System.out.println(str);
        boolean yeni = true;
        File file = new File("aracKayit.txt");
        if (!file.exists()) {
            file.createNewFile();
        } else {
            yeni = false;
        }
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        if (yeni == false) {
            bWriter.newLine();
        }
        bWriter.write(str);
        bWriter.close();
    }

    private static void dosyaKayit(Bisiklet bis) throws IOException {

        String str = bis.getID() + "," + bis.getAracMarka() + "," + "" + "," + bis.getAracHiz() + "," + bis.getAracYolcuSayisi() + "," + bis.getAracTekerSayisi() + "," + bis.getAracFiyat() + "," + bis.getAracUretimYili() + "," + bis.getAracRenk();
        System.out.println(str);
        boolean yeni = true;
        File file = new File("aracKayit.txt");
        if (!file.exists()) {
            file.createNewFile();
        } else {
            yeni = false;
        }
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        if (yeni == false) {
            bWriter.newLine();
        }
        bWriter.write(str);
        bWriter.close();

    }

    private static void dosyaKayit(Gemi gemi) throws IOException {

        String str = gemi.getID() + "," + gemi.getAracMarka() + "," + gemi.getAracYakit() + "," + gemi.getAracHiz() + "," + gemi.getAracYolcuSayisi() + "," + "" + "," + gemi.getAracFiyat() + "," + gemi.getAracUretimYili() + "," + gemi.getAracRenk();
        System.out.println(str);
        boolean yeni = true;
        File file = new File("aracKayit.txt");
        if (!file.exists()) {
            file.createNewFile();
        } else {
            yeni = false;
        }
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        if (yeni == false) {
            bWriter.newLine();
        }
        bWriter.write(str);
        bWriter.close();

    }

    private static void dosyaKayit(Ucak ucak) throws IOException {

        String str = ucak.getID() + "," + ucak.getAracMarka() + "," + ucak.getAracYakit() + "," + ucak.getAracHiz() + "," + ucak.getAracYolcuSayisi() + "," + ucak.getAracTekerSayisi() + "," + ucak.getAracFiyat() + "," + ucak.getAracUretimYili() + "," + ucak.getAracRenk();
        System.out.println(str);
        boolean yeni = true;
        File file = new File("aracKayit.txt");
        if (!file.exists()) {
            file.createNewFile();
        } else {
            yeni = false;
        }
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        if (yeni == false) {
            bWriter.newLine();
        }
        bWriter.write(str);
        bWriter.close();

    }

    private static void dosyaKayit(ucanGemi.ucanGemi1 ugemi) throws IOException {

        String str = ugemi.getID() + "," + ugemi.getAracMarka() + "," + ugemi.getAracYakit() + "," + ugemi.getAracHiz() + "," + ugemi.getAracYolcuSayisi() + "," + ugemi.getAracTekerSayisi() + "," + ugemi.getAracFiyat() + "," + ugemi.getAracUretimYili() + "," + ugemi.getAracRenk();
        System.out.println(str);
        boolean yeni = true;
        File file = new File("aracKayit.txt");
        if (!file.exists()) {
            file.createNewFile();
        } else {
            yeni = false;
        }
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        if (yeni == false) {
            bWriter.newLine();
        }
        bWriter.write(str);
        bWriter.close();

    }

    private static void dosyaGuncelle(String id, int sira, String yeniDeger) throws IOException {

        FileReader fileReader = new FileReader("aracKayit.txt");
        BufferedReader br = new BufferedReader(fileReader);

        List<Object> object = new ArrayList<Object>();
        int sutun = 0;
        String[] line = new String[9];
        boolean guncelle = false;
        String text = br.readLine();
        String no = id;
        while (text != null) {
            sutun = 0;
            line = text.split(",");
            int a = 0;
            for (String deger : line) {

                if (sira == sutun && line[0].equals(no)) {
                    line[sutun] = yeniDeger;
                    guncelle = true;

                } else if (sira != sutun && line[0].equals(no)) {
                    line[sutun] = deger;
                    sutun++;
                } else {
                    sutun++;
                }
            }
            if (guncelle == true) {
                text = null;
                for (int i = 0; i < line.length; i++) {
                    if (i == 0) {
                        text = line[0];
                    } else {
                        text = text + "," + line[i];
                    }

                }
                object.add(text);
            } else {
                object.add(text);
            }
            text = br.readLine();
        }
        if (guncelle == true) {
            File file = new File("aracKayit.txt");
            if (!file.exists()) {
                System.out.println("Dosya Bulunamadı");
            }
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            String satir = null;
            for (int i = 0; i < object.size(); i++) {
                satir = String.valueOf(object.get(i));
                if (i != 0) {
                    bWriter.newLine();
                }
                bWriter.write(satir);
            }
            bWriter.close();

        }

    }

    private static void kayitListele(int secim) throws IOException {
        FileReader fileReader = new FileReader("aracKayit.txt");
        BufferedReader br = new BufferedReader(fileReader);
        List<Object> kara = new ArrayList<Object>();
        List<Object> deniz = new ArrayList<Object>();
        List<Object> hava = new ArrayList<Object>();
        String[] line = new String[9];
        String text = br.readLine();
        while (text != null) {
            line = text.split(",");
            int a = 0;
            if (line[0].startsWith("otomobil") || line[0].startsWith("bisiklet")) {
                kara.add(text);
            }
            if (line[0].startsWith("gemi") || line[0].startsWith("ucangemi")) {
                deniz.add(text);
            }
            if (line[0].startsWith("ucak") || line[0].startsWith("ucangemi")) {
                hava.add(text);
            }
            text = br.readLine();
        }
        if (secim == 1) {
            for (int i = 0; i < kara.size(); i++) {
                System.out.println(kara.get(i));
            }
        }
        if (secim == 2) {
            for (int i = 0; i < deniz.size(); i++) {
                System.out.println(deniz.get(i));
            }
        }
        if (secim == 3) {
            for (int i = 0; i < hava.size(); i++) {
                System.out.println(hava.get(i));
            }
        }
    }
}
