import java.util.Scanner; // Import kelas Scanner untuk input dari pengguna

// Kelas Mahasiswa untuk merepresentasikan data mahasiswa
class Mahasiswa {
    String nim;       // Nomor Induk Mahasiswa
    String nama;      // Nama Mahasiswa
    String jurusan;   // Jurusan Mahasiswa
    double ipk;       // Indeks Prestasi Kumulatif

    // Konstruktor untuk menginisialisasi objek Mahasiswa
    public Mahasiswa(String nim, String nama, String jurusan, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    // Override method toString untuk menampilkan data mahasiswa dengan format tertentu
    @Override
    public String toString() {
        return String.format("NIM: %s\nNama: %s\nJurusan: %s\nIPK: %.2f", nim, nama, jurusan, ipk);
    }
}

public class PencarianDataMahasiswa {
    public static void main(String[] args) {
        // Array berisi daftar data mahasiswa
        Mahasiswa[] daftarMahasiswa = {
            new Mahasiswa("2023001", "Budi Santoso", "Teknik Informatika", 3.75),
            new Mahasiswa("2023002", "Andi Wijaya", "Sistem Informasi", 3.50),
            new Mahasiswa("2023003", "Dewi Lestari", "Teknik Komputer", 3.90),
            new Mahasiswa("2023004", "Rina Maulana", "Teknik Informatika", 3.60),
            new Mahasiswa("2023005", "Doni Kusuma", "Manajemen Informatika", 3.25),
            new Mahasiswa("2023006", "Sinta Rahma", "Sistem Informasi", 3.85),
            new Mahasiswa("2023007", "Rudi Hermawan", "Teknik Komputer", 3.40)
        };

        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk input

        System.out.println("=== SISTEM PENCARIAN DATA MAHASISWA ===");
        System.out.print("Masukkan NIM Mahasiswa yang dicari: ");
        String nimCari = scanner.nextLine(); // Membaca input NIM dari pengguna

        // Memanggil metode pencarian dengan NIM yang dimasukkan pengguna
        Mahasiswa hasilPencarian = cariMahasiswaByNIM(daftarMahasiswa, nimCari);

        System.out.println("\nHASIL PENCARIAN:");
        if (hasilPencarian != null) {
            // Jika ditemukan, tampilkan data mahasiswa
            System.out.println("Mahasiswa ditemukan!");
            System.out.println(hasilPencarian);
        } else {
            // Jika tidak ditemukan, tampilkan pesan
            System.out.println("Mahasiswa dengan NIM " + nimCari + " tidak ditemukan.");
        }

        scanner.close(); // Menutup objek Scanner
    }

    // Method untuk mencari mahasiswa berdasarkan NIM menggunakan pencarian linear
    public static Mahasiswa cariMahasiswaByNIM(Mahasiswa[] daftarMahasiswa, String nim) {
        for (int i = 0; i < daftarMahasiswa.length; i++) {
            // Bandingkan NIM mahasiswa saat ini dengan NIM yang dicari
            if (daftarMahasiswa[i].nim.equals(nim)) {
                return daftarMahasiswa[i]; // Return jika ditemukan
            }
        }
        return null; // Return null jika tidak ditemukan
    }
}
