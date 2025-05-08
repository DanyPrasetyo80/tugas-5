public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        int n = arr.length;  // Menyimpan panjang array

        // Simpan elemen terakhir dari array
        int lastElement = arr[n - 1];

        // Ganti elemen terakhir dengan target sebagai sentinel
        arr[n - 1] = target;

        int i = 0;

        // Lakukan pencarian tanpa perlu cek batas array,
        // karena kita yakin target pasti ada sebagai sentinel
        while (arr[i] != target) {
            i++;
        }

        // Kembalikan elemen terakhir ke nilai aslinya
        arr[n - 1] = lastElement;

        // Jika ditemukan sebelum elemen terakhir,
        // atau jika target memang adalah elemen terakhir yang asli
        if (i < n - 1 || lastElement == target) {
            return i;  // Target ditemukan di indeks ke-i
        }

        // Jika tidak ditemukan (yang cocok hanya sentinel),
        // maka kembalikan -1 sebagai tanda "tidak ditemukan"
        return -1;
    }

    // Contoh penggunaan
    public static void main(String[] args) {
        int[] data = {10, 20, 30, 40, 50};
        int target = 30;

        int hasil = linearSearch(data, target);

        if (hasil != -1) {
            System.out.println("Target ditemukan pada indeks: " + hasil);
        } else {
            System.out.println("Target tidak ditemukan.");
        }
    }
}
