import java.util.Scanner;

public class ProjectAkhir04 {

    static Scanner input = new Scanner(System.in);
    static int tgl;

    static String menuMakanan[] = { "nasi kuning", "nasi goreng", "tumis sawi", "salad buah" };

    static int harga[] = { 8000, 10000, 12000, 5000, 7000, 6000 };

    public static void main(String[] args) {
        transaksi();

    }

    static void transaksi() {

        String menuDipesan[][];
        int baris, kodeMenu, totalBayar = 0;

        System.out.print("Masukkan tanggal pesanan diantar : ");
        tgl = input.nextInt();

        tampilMenuMakanan();
        System.out.print("Ingin memesan berapa menu? : ");
        baris = input.nextInt();

        menuDipesan = new String[baris][1];

        for (int i = 0; i < baris; i++) {

            System.out.print("Pilih Menu Makanan (1-4) : ");
            kodeMenu = input.nextInt();

            switch (kodeMenu) {
                case 1:
                    menuDipesan[i] = menuMakanan[0];
                    totalBayar += harga[0];
                    break;
                case 2:
                    menuDipesan[i] = menuMakanan[1];
                    totalBayar += harga[0];
                    break;
                case 3:
                    menuDipesan[i] = menuMakanan[2];
                    totalBayar += harga[0];
                    break;
                case 4:
                    menuDipesan[i] = menuMakanan[3];
                    totalBayar += harga[0];
                    break;
            }
        }

        System.out.println("Berikut menu makanan yang anda pesan : ");
        for (int i = 0; i < menuDipesan.length; i++) {
            System.out.println(menuDipesan[i]);
        }

    }

    static void tampilMenuMakanan() {

        System.out.println("Menu : ");
        System.out.println("-----------------------------------------");
        for (int i = 0; i < menuMakanan.length; i++) {
            System.out.printf("|  %s  |\t%s\t|\t%s\t|\n", i + 1, menuMakanan[i], harga[i]);
            System.out.println("-----------------------------------------");
        }

    }
}