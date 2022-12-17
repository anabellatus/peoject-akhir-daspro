import java.util.Scanner;

public class ProjectAkhir04 {

    static Scanner input = new Scanner(System.in);

    static String dataPelanggan[][] = {
            // nama, tanggal pemesanan, tanggal kirim, pilihan kirim, nomor telepon, status
            // bayar, jenis pembayaran, pesanan
            { "Jay", "11", "12", "luar kota", "0812222", "lunas", "cash", "nasi kuning, nasi goreng" },
            { "Namjoon", "11", "13", "dalam kota", "0812223", "lunas", "cash", "nasi goreng, tumis sawi, salad buah" },
            { "Suga", "10", "11", "luar kota", "0812232", "dp", "cash", "salad buah" },
            { null, null, null, null, null, null, null, null },
            { null, null, null, null, null, null, null, null },
            { null, null, null, null, null, null, null, null }
    };

    static int dataPesanan[][] = {
            // jumlah pesanan, total pesanan, ongkir, total bayar
            { 30, 270000, 60000, 330000 }, // nasi kuning 15, nasi goreng 15
            { 31, 276000, 30000, 336000 }, // nasi goreng 20, tumis sawi 3, salad buah 8
            { 25, 125000, 60000, 185000 }, // salad buah 25
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 }
    };

    static String menuMakanan[] = { "nasi kuning", "nasi goreng", "tumis sawi", "salad buah" };

    static int harga[] = { 8000, 10000, 12000, 5000 };

    static int uang;

    public static void main(String[] args) {

        // transaksi();
        int hasil[] = searching();

        // System.out.println("|\tNama Pelanggan\t|\tTgl Psn\t|\tTgl Krm\t|\tPilKrm\t|\tNo.telp\t|\tStatus\t|\tPilKrm\t|\tBayar\t|\tPesanan\t|");
        // System.out.println("--------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < hasil.length; i++) {
            // System.out.println(hasil[i]);
            for (int j = 0; j < dataPelanggan[0].length; j++) {
                System.out.printf("|\t%s\t", dataPelanggan[i][j]);
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------");
        }

    }

    static void transaksi() {

        String menuDipesan[];
        // jumlah porsi, harga, total
        int jumlahPesanan[][];
        int baris, kodeMenu, jumlahPorsi, totalBayar = 0, jumlahDp, subTotal = 0, totalPorsi = 0, kembali = 0;
        String tglKirim;

        System.out.print("Masukkan tanggal pesanan diantar : ");
        tglKirim = input.nextLine();
        dataPelanggan[3][2] = tglKirim;
        dataPelanggan[3][1] = "16";

        tampilMenuMakanan();

        System.out.print("Ingin memesan berapa menu? : ");
        baris = input.nextInt();

        menuDipesan = new String[baris];
        jumlahPesanan = new int[baris][3];

        for (int i = 0; i < baris; i++) {
            System.out.print("Pilih Menu Makanan (1-4) : ");
            kodeMenu = input.nextInt();

            switch (kodeMenu) {
                case 1:
                    menuDipesan[i] = menuMakanan[0];

                    System.out.printf("Ingin pesan menu %s berapa porsi? : ", menuMakanan[0]);
                    jumlahPorsi = input.nextInt();

                    jumlahPesanan[i][0] = jumlahPorsi;
                    jumlahPesanan[i][1] = harga[0];
                    jumlahPesanan[i][2] = jumlahPorsi * harga[0];

                    subTotal += jumlahPesanan[i][2];
                    totalPorsi += jumlahPesanan[i][0];
                    break;

                case 2:
                    menuDipesan[i] = menuMakanan[1];

                    System.out.printf("Ingin pesan menu %s berapa porsi? : ", menuMakanan[1]);
                    jumlahPorsi = input.nextInt();

                    jumlahPesanan[i][0] = jumlahPorsi;
                    jumlahPesanan[i][1] = harga[1];
                    jumlahPesanan[i][2] = jumlahPorsi * harga[1];

                    subTotal += jumlahPesanan[i][2];
                    totalPorsi += jumlahPesanan[i][0];
                    break;

                case 3:
                    menuDipesan[i] = menuMakanan[2];

                    System.out.printf("Ingin pesan menu %s berapa porsi? : ", menuMakanan[2]);
                    jumlahPorsi = input.nextInt();

                    jumlahPesanan[i][0] = jumlahPorsi;
                    jumlahPesanan[i][1] = harga[2];
                    jumlahPesanan[i][2] = jumlahPorsi * harga[2];

                    subTotal += jumlahPesanan[i][2];
                    totalPorsi += jumlahPesanan[i][0];
                    break;

                case 4:
                    menuDipesan[i] = menuMakanan[3];

                    System.out.printf("Ingin pesan menu %s berapa porsi? : ", menuMakanan[3]);
                    jumlahPorsi = input.nextInt();

                    jumlahPesanan[i][0] = jumlahPorsi;
                    jumlahPesanan[i][1] = harga[3];
                    jumlahPesanan[i][2] = jumlahPorsi * harga[3];

                    subTotal += jumlahPesanan[i][2];
                    totalPorsi += jumlahPesanan[i][0];
                    break;

                default:
                    System.out.println("inputan menu tidak valid");
                    i--;
            }

        }

        System.out.println("Berikut menu makanan yang anda pesan : ");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|\tNama Menu\t|\tJumlah\t|\tHarga\t|\tTotal\t|");
        System.out.println("-------------------------------------------------------------------------");
        for (int i = 0; i < menuDipesan.length; i++) {
            System.out.printf("|\t%s\t|\t%s\t|\t%s\t|\t%s\t|", menuDipesan[i], jumlahPesanan[i][0], jumlahPesanan[i][1],
                    jumlahPesanan[i][2]);
            System.out.println("\n-------------------------------------------------------------------------");
        }

        System.out.println("Total Pesanan sebanyak : " + subTotal);
        input.nextLine();

        System.out.print("Masukkan tujuan pengiriman (dalam kota/luar kota): ");
        String inputPengiriman = input.nextLine();

        dataPelanggan[3][3] = inputPengiriman;

        int tarifOngkir = hitungOngkir(inputPengiriman);
        System.out.println("Tarif Ongkos Kirim : " + tarifOngkir);

        dataPesanan[3][2] = tarifOngkir;

        totalBayar = hitungTotalBayar(subTotal, tarifOngkir);

        System.out.println("Total Bayar : " + totalBayar);

        System.out.print("Inputkan nama pelanggan : ");
        dataPelanggan[3][0] = input.nextLine();

        System.out.print("Inputkan Nomor Telepon Pelanggan : ");
        dataPelanggan[3][4] = input.nextLine();

        System.out.print("Pembayaran Lunas / Dp ? : ");
        dataPelanggan[3][5] = input.nextLine();
        if (dataPelanggan[3][5].equalsIgnoreCase("dp")) {
            jumlahDp = totalBayar / 2;
            System.out.print("Jumlah dp yang harus dibayarkan sebesar : " + jumlahDp);
            kembali = hitungKembalian(jumlahDp);

        } else if (dataPelanggan[3][5].equalsIgnoreCase("lunas")) {
            kembali = hitungKembalian(totalBayar);
        }

        dataPesanan[3][3] = totalBayar;
        dataPesanan[3][0] = totalPorsi;
        dataPesanan[3][1] = subTotal;

        int increment = 0;
        do {

            if (dataPelanggan[3][7] == null) {
                dataPelanggan[3][7] = menuDipesan[increment];
            } else {
                dataPelanggan[3][7] += ", " + menuDipesan[increment];
            }

            increment++;
        } while (increment < menuDipesan.length);

        tampilStruk(dataPelanggan[3][0], menuDipesan, jumlahPesanan, subTotal, uang, kembali);

        laporan();
        cekStatusPembayaran();

        int hasil[] = searching();

        // System.out.println("|\tNama Pelanggan\t|\tTgl Psn\t|\tTgl Krm\t|\tPilKrm\t|\tNo.telp\t|\tStatus\t|\tPilKrm\t|\tBayar\t|\tPesanan\t|");
        // System.out.println("--------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < hasil.length; i++) {
            System.out.println(hasil[i]);
            // for (int j = 0; j < dataPelanggan[0].length; j++) {
            //     System.out.printf("|\t%s\t", dataPelanggan[i][j]);
            // }
            // System.out.println("--------------------------------------------------------------------------------------------------------------");
        }

    }

    static int[] searching() {
        String key;
        int hasil[] = new int[6];
        int counter = 0;

        input.nextLine();

        System.out.print("Masukkan Kata yang ingin dicari : ");
        key = input.nextLine();

        for (int i = 0; i < dataPelanggan.length; i++) {
            for (int j = 0; j < dataPelanggan[0].length; j++) {
                if (key.equalsIgnoreCase(dataPelanggan[i][j])) {
                    hasil[counter] = i;
                    counter++;
                }
            }
        }

        return hasil;
    }

    static int hitungKembalian(int totalBayar) {
        int kembalian = 0;
        System.out.print("\nMembayar via apa? (cash/debit)? : ");
        dataPelanggan[3][6] = input.nextLine();

        if (dataPelanggan[3][6].equalsIgnoreCase("cash")) {

            System.out.print("Masukkan jumlah uang : ");
            uang = input.nextInt();

            kembalian = uang - totalBayar;
            System.out.print("Kembalian : " + kembalian);
        } else {
            kembalian = 0;
        }

        return kembalian;
    }

    static int hitungTotalBayar(int total, int ongkos) {
        int grandTotal = total + ongkos;
        return grandTotal;
    }

    static int hitungOngkir(String jenisPengiriman) {
        int ongkir;

        if (jenisPengiriman.equalsIgnoreCase("dalam kota")) {
            return ongkir = 30000;
        } else if (jenisPengiriman.equalsIgnoreCase("luar kota")) {
            return ongkir = 60000;
        } else {
            System.out.println("jenis tujuan tidak ada");
            return ongkir = 0;
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

    static void tampilStruk(String nama, String pesanan[], int dataJumlah[][], int subTotal, int pembayaran,
            int kembalian) {
        System.out.println("\n\n\n=============================================");
        System.out.println("               Vante Catering             ");
        System.out.println("          Jalan Soekarno Hatta 401");
        System.out.println("=============================================");
        System.out.println("Tanggal Pemesanan : " + dataPelanggan[3][1]);
        System.out.println("Nama Pelanggan    : " + nama);
        System.out.println("=============================================");

        for (int i = 0; i < pesanan.length; i++) {
            System.out.printf("%s", pesanan[i]);
            System.out.printf("\n%s x @%s \t\t\t%s", dataJumlah[i][0], dataJumlah[i][1],
                    dataJumlah[i][2]);
            System.out.println("");
        }

        System.out.println("\nDikirim ke : " + dataPelanggan[3][3]);

        System.out.println("\n---------------------------------------------");
        System.out.println("\t\tSub Total \t: " + subTotal);
        System.out.println("\t\tOngkos Kirim \t: " + dataPesanan[3][2]);
        System.out.println("\t\tGrand Total \t: " + dataPesanan[3][3]);
        System.out.println("\t\tDibayar \t: " + dataPelanggan[3][5]);
        System.out.println("\t\tPembayaran \t: " + dataPelanggan[3][6] + " " + pembayaran);
        System.out.println("\t\tKembalian \t: " + kembalian);
        System.out.println("=============================================");

    }

    static void cekStatusPembayaran() {
        System.out.println("\n\n=============================================");
        System.out.println("             Cek Status Pembayaran           ");
        System.out.println("                Vante Catering               ");
        System.out.println("---------------------------------------------");
        System.out.println("Nama Pelanggan\tStatus Pembayaran\t");
        for (int i = 0; i < dataPelanggan.length; i++) {
            System.out.printf("%s\t \t%s\t", dataPelanggan[i][0], dataPelanggan[i][5]);
            System.out.println();
        }
        System.out.println("=============================================");
    }

    static void laporan() {
        int totalPemasukan = 0;
        System.out.println("\n\n=============================================");
        System.out.println("                Laporan Harian               ");
        System.out.println("                Vante Catering               ");
        System.out.println("---------------------------------------------");
        System.out.println("Nama Pelanggan\tTotal Bayar\t");
        for (int i = 0; i < dataPelanggan.length; i++) {
            System.out.printf("%s\t", dataPelanggan[i][0]);
            System.out.printf("\t%s\t", dataPesanan[i][3]);
            totalPemasukan += dataPesanan[i][3];
            System.out.println();
        }
        System.out.println("Total Pemasukan : " + totalPemasukan);
        System.out.println("=============================================");

    }
}