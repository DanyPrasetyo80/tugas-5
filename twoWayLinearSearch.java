public class twoWayLinearSearch {

public static int twoWayLinearSearch(int[] arr, int target) {
    int left = 0;                       // Inisialisasi indeks dari kiri
    int right = arr.length - 1;        // Inisialisasi indeks dari kanan

    // Loop berjalan selama indeks kiri belum melewati indeks kanan
    while (left <= right) {
        // Periksa elemen dari arah kiri
        if (arr[left] == target) {
            return left;               // Jika ditemukan, kembalikan indeks kiri
        }

        // Periksa elemen dari arah kanan
        if (arr[right] == target) {
            return right;              // Jika ditemukan, kembalikan indeks kanan
        }

        // Geser indeks kiri ke kanan, dan indeks kanan ke kiri
        left++;
        right--;
    }

    // Jika tidak ditemukan setelah seluruh perbandingan, kembalikan -1
    return -1;
 }
}

