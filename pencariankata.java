import java.util.ArrayList;
import java.util.Scanner;

public class pencariankata {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Membuat scanner untuk input dari pengguna

        System.out.println("=== SISTEM PENCARIAN KATA ===");

        // Meminta pengguna memasukkan teks sumber
        System.out.print("Masukkan teks: ");
        String teks = scanner.nextLine();

        // Meminta pengguna memasukkan kata yang ingin dicari
        System.out.print("Masukkan kata yang dicari: ");
        String kataCari = scanner.nextLine();

        // Memanggil method untuk mencari posisi kata dalam teks
        ArrayList<Integer> posisiDitemukan = cariKata(teks, kataCari);

        // Menampilkan hasil pencarian
        System.out.println("\nHASIL PENCARIAN:");
        if (posisiDitemukan.size() > 0) {
            // Jika kata ditemukan, tampilkan jumlah dan posisi kemunculan
            System.out.println("Kata '" + kataCari + "' ditemukan sebanyak " +
                               posisiDitemukan.size() + " kali pada posisi:");

            // Menampilkan semua indeks kemunculan kata
            for (int i = 0; i < posisiDitemukan.size(); i++) {
                System.out.println("- Indeks ke-" + posisiDitemukan.get(i) +
                                   " (karakter ke-" + (posisiDitemukan.get(i) + 1) + ")");
            }

            // Menampilkan teks dengan highlight pada kata yang ditemukan
            System.out.println("\nTeks dengan highlight:");
            tampilkanTeksHighlight(teks, kataCari, posisiDitemukan);
        } else {
            // Jika kata tidak ditemukan
            System.out.println("Kata '" + kataCari + "' tidak ditemukan dalam teks.");
        }

        scanner.close(); // Menutup scanner
    }

    // Method untuk mencari semua posisi kemunculan kata dalam teks (case-insensitive)
    public static ArrayList<Integer> cariKata(String teks, String kata) {
        ArrayList<Integer> posisi = new ArrayList<>(); // Menyimpan hasil posisi

        // Mengubah ke lowercase agar pencarian tidak sensitif terhadap huruf besar/kecil
        String teksLower = teks.toLowerCase();
        String kataLower = kata.toLowerCase();

        int panjangKata = kataLower.length();
        int panjangTeks = teksLower.length();

        // Melakukan pencarian linear dari awal teks hingga akhir
        for (int i = 0; i <= panjangTeks - panjangKata; i++) {
            // Ambil substring dari posisi i dengan panjang kata
            String potongan = teksLower.substring(i, i + panjangKata);

            // Jika substring sama dengan kata yang dicari, simpan posisinya
            if (potongan.equals(kataLower)) {
                posisi.add(i);

                // Optional: jika ingin menghindari pencocokan yang saling overlap,
                // bisa menggunakan i += panjangKata - 1;
            }
        }

        return posisi; // Mengembalikan daftar posisi kemunculan kata
    }

    // Method untuk menampilkan teks dengan highlight di sekitar kata yang ditemukan
    public static void tampilkanTeksHighlight(String teks, String kata, ArrayList<Integer> posisi) {
        StringBuilder hasil = new StringBuilder(teks); // Menggunakan StringBuilder untuk efisiensi

        // Sisipkan tanda "[" dan "]" dari belakang agar indeks tidak tergeser
        for (int i = posisi.size() - 1; i >= 0; i--) {
            int pos = posisi.get(i);
            hasil.insert(pos + kata.length(), "]"); // Tambahkan "]" setelah kata
            hasil.insert(pos, "[");                // Tambahkan "[" sebelum kata
        }

        // Cetak teks hasil highlight
        System.out.println(hasil.toString());
    }
}
