package atmApp;

import java.util.Scanner;

public class AtmApp {

    private static double bakiye = 2000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dostbank'a Hoşgeldiniz!");
        System.out.println("Sizlere nasıl yardımcı olabiliriz?");
        
        while (bakiye > 0) {
            System.out.println("Yapmak istediğiniz işlemi seçiniz.");
            System.out.println("1- Hesaba para yatır");
            System.out.println("2- Para çek");
            System.out.println("3- Kredi kartı borcu öde");
            System.out.println("4- Çıkış yap");

            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    paraYatir(scanner);
                    break;
                case 2:
                    paraCek(scanner);
                    break;
                case 3:
                    krediKartiBorcuOde(scanner);
                    break;
                case 4:
                    cikisYap();
                    scanner.close();
                    return;
                default:
                    System.out.println("Eksik veya hatalı giriş yaptınız!");
            }
        }
    }

    private static void paraYatir(Scanner scanner) {
        System.out.println("Mevcut bakiyeniz: " + bakiye);
        System.out.print("Yatırmak istediğiniz miktarı giriniz: ");
        double miktar = scanner.nextDouble();
        bakiye += miktar;
        System.out.println("Yeni bakiyeniz: " + bakiye);
    }

    private static void paraCek(Scanner scanner) {
        System.out.println("Mevcut bakiyeniz: " + bakiye);
        System.out.print("Çekmek istediğiniz miktarı giriniz: ");
        double miktar = scanner.nextDouble();
        if (miktar > bakiye) {
            System.out.println("Yetersiz bakiye!");
        } else {
            bakiye -= miktar;
            System.out.println("Kalan bakiyeniz: " + bakiye);
        }
    }

    private static void krediKartiBorcuOde(Scanner scanner) {
        System.out.println("Mevcut bakiyeniz: " + bakiye);
        System.out.println("Ödemek istediğiniz borç türünü seçin: 5- Ekstre, 6- Asgari");
        int input = scanner.nextInt();
        double miktar;
        
        if (input == 5) {
            System.out.print("Ekstre ödeme miktarını giriniz: ");
            miktar = scanner.nextDouble();
            odemeYap(miktar);
        } else if (input == 6) {
            System.out.print("Asgari ödeme miktarını giriniz: ");
            miktar = scanner.nextDouble() * 0.30;
            odemeYap(miktar);
        } else {
            System.out.println("Eksik veya hatalı giriş yaptınız!");
        }
    }

    private static void odemeYap(double miktar) {
        if (miktar > bakiye) {
            System.out.println("Yetersiz bakiye ödeme yapamazsınız!");
        } else {
            bakiye -= miktar;
            System.out.println("Ödeme başarıyla gerçekleştirildi. Yeni bakiyeniz: " + bakiye);
        }
    }

    private static void cikisYap() {
        System.out.println("Güncel bakiyeniz: " + bakiye);
        System.out.println("Bizi tercih ettiğiniz için teşekkürler, iyi günler!");
    }
}