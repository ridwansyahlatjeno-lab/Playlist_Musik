/**
 * ================================================
 *   Data Structures and Algorithm Analysis
 * ================================================
 * Kelompok 4
 *   1. ABZACHRIE DEFGHI FERDYAN - 2902741953
 *   2. AHMAD DWIYAN ANUGRAH PUTRA  - 2902742205
 *   3. KIMI MARTUA CASSANOVA SIMAJUNTAK - 2902733806
 *   4. RIDWANSYAH LATJENO – 2902699125
 *   5. SYAHRUL ADY PRATAMA - 2902728440
 * ================================================
 * 
 * PROGRAM: Sistem Manajemen Playlist
 * FOKUS: Operasi Array (Traversal, Insertion, Deletion, Searching, Sorting)
 * 
 * Classes:
 * - Lagu: Merepresentasikan sebuah lagu
 * - PlaylistArray: Mengelola array lagu dengan operasi CRUD
 * - PlaylistOOP: Program utama dengan menu interaktif
 */

import java.util.Scanner;

/**
 * Class PlaylistArray untuk mengelola array lagu dengan operasi:
 * Traversal (tampilkan semua), Insertion (tambah), Deletion (hapus), 
 * Searching (cari), dan Sorting (urutkan)
 */
public class PlaylistArray {
    private Lagu[] lagu;
    private int jumlahLagu;
    private static final int KAPASITAS_MAX = 10;

    /**
     * Constructor: Inisialisasi array dengan kapasitas maksimal 10 lagu
     */
    public PlaylistArray() {
        this.lagu = new Lagu[KAPASITAS_MAX];
        this.jumlahLagu = 0;
    }

    /**
     * TRAVERSAL: Menampilkan semua lagu di playlist
     * Dengan opsi untuk sorting berdasarkan durasi
     */
    public void tampilkanSemuaLagu(Scanner input) {
        if (jumlahLagu == 0) {
            System.out.println("Playlist kosong.");
            return;
        }
        System.out.println("\n=== Daftar Lagu ===");
        for (int i = 0; i < jumlahLagu; i++) {
            System.out.println("Lagu #" + (i + 1));
            lagu[i].tampilkanInfo();
        }

        // Tanyakan apakah user ingin mengurutkan
        System.out.print("Apakah Anda ingin mengurutkan berdasarkan durasi (ascending)? (y/n): ");
        String pilihan = input.nextLine().toLowerCase();
        if (pilihan.equals("y") || pilihan.equals("yes")) {
            tampilkanSemuaLaguDenganSorting();
        }
    }

    /**
     * Menampilkan semua lagu dengan sorting berdasarkan durasi ascending
     */
    private void tampilkanSemuaLaguDenganSorting() {
        // Salin array untuk sorting
        Lagu[] sorted = new Lagu[jumlahLagu];
        for (int i = 0; i < jumlahLagu; i++) {
            sorted[i] = lagu[i];
        }

        // Selection Sort berdasarkan durasi
        selectionSort(sorted);

        // Tampilkan urutan setelah sort
        System.out.println("\n=== Daftar Lagu (Setelah Diurutkan berdasarkan Durasi Ascending) ===");
        for (int i = 0; i < jumlahLagu; i++) {
            System.out.println("Lagu #" + (i + 1));
            sorted[i].tampilkanInfo();
        }
    }


    /**
     * INSERTION: Menambahkan lagu baru ke playlist
     * Cek apakah playlist sudah penuh atau belum
     */
    public void tambahLagu(String judul, String artis, double durasi) {
        if (jumlahLagu >= KAPASITAS_MAX) {
            System.out.println("Playlist sudah penuh! Maksimal " + KAPASITAS_MAX + " lagu.");
            return;
        }

        Lagu laguBaru = new Lagu(judul, artis, durasi);
        lagu[jumlahLagu] = laguBaru;
        jumlahLagu++;
        System.out.println("Lagu \"" + judul + "\" berhasil ditambahkan ke playlist!");
    }

    /**
     * DELETION: Menghapus lagu berdasarkan judul
     * Menggeser elemen array agar tetap rapat
     */
    public void hapusLagu(String judul) {
        if (jumlahLagu == 0) {
            System.out.println("Playlist kosong. Tidak ada lagu untuk dihapus.");
            return;
        }

        int indexHapus = -1;
        // Linear search untuk menemukan lagu
        for (int i = 0; i < jumlahLagu; i++) {
            if (lagu[i].getJudul().equalsIgnoreCase(judul)) {
                indexHapus = i;
                break;
            }
        }

        if (indexHapus == -1) {
            System.out.println("Lagu \"" + judul + "\" tidak ditemukan di playlist.");
            return;
        }

        // Geser elemen array agar tetap rapat
        for (int i = indexHapus; i < jumlahLagu - 1; i++) {
            lagu[i] = lagu[i + 1];
        }
        lagu[jumlahLagu - 1] = null;
        jumlahLagu--;
        System.out.println("Lagu \"" + judul + "\" berhasil dihapus dari playlist.");
    }

    /**
     * SEARCHING: Mencari lagu berdasarkan judul menggunakan Linear Search
     * Menampilkan semua lagu yang judulnya mengandung kata kunci
     */
    public void cariLagu(String judul) {
        if (jumlahLagu == 0) {
            System.out.println("Playlist kosong.");
            return;
        }

        boolean ditemukan = false;
        System.out.println("\n=== Hasil Pencarian untuk \"" + judul + "\" ===");
        
        // Linear search
        for (int i = 0; i < jumlahLagu; i++) {
            if (lagu[i].getJudul().toLowerCase().contains(judul.toLowerCase())) {
                System.out.println("Lagu #" + (i + 1));
                lagu[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Lagu dengan judul \"" + judul + "\" tidak ditemukan.");
        }
    }

    /**
     * SORTING: Mengurutkan lagu berdasarkan durasi (ascending)
     * Menggunakan Selection Sort
     * Menampilkan hasil sebelum dan sesudah pengurutan
     */
    public void urutkanBerdasarkanDurasi() {
        if (jumlahLagu == 0) {
            System.out.println("Playlist kosong. Tidak ada yang bisa diurutkan.");
            return;
        }

        // Tampilkan urutan sebelum sort
        System.out.println("\n=== Daftar Lagu (Sebelum Pengurutan) ===");
        for (int i = 0; i < jumlahLagu; i++) {
            System.out.println("Lagu #" + (i + 1));
            lagu[i].tampilkanInfo();
        }

        // Salin array untuk sorting
        Lagu[] sorted = new Lagu[jumlahLagu];
        for (int i = 0; i < jumlahLagu; i++) {
            sorted[i] = lagu[i];
        }

        // Selection Sort berdasarkan durasi
        selectionSort(sorted);

        // Tampilkan urutan setelah sort
        System.out.println("\n=== Daftar Lagu (Setelah Pengurutan berdasarkan Durasi Ascending) ===");
        for (int i = 0; i < jumlahLagu; i++) {
            System.out.println("Lagu #" + (i + 1));
            sorted[i].tampilkanInfo();
        }
    }

    /**
     * Implementasi Selection Sort untuk mengurutkan lagu berdasarkan durasi
     * Selection Sort dipilih karena:
     * - Efisien untuk dataset kecil (max 10 lagu)
     * - Jumlah swap minimal
     * - Kompleksitas O(n²) tapi dengan performa lebih baik dari bubble sort
     */
    private void selectionSort(Lagu[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            // Cari index lagu dengan durasi minimum
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].getDurasi() < array[minIndex].getDurasi()) {
                    minIndex = j;
                }
            }
            // Tukar elemen
            if (minIndex != i) {
                Lagu temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    /**
     * Getter untuk jumlah lagu saat ini
     */
    public int getJumlahLagu() {
        return jumlahLagu;
    }

    /**
     * Getter untuk kapasitas maksimal
     */
    public int getKapasitasMax() {
        return KAPASITAS_MAX;
    }

    /**
     * Main method: Program utama dengan menu interaktif
     */
    public static void main(String[] args) {
        // Inisialisasi PlaylistArray
        PlaylistArray playlist = new PlaylistArray();
        
        // Inisialisasi data awal (8 lagu)
        inisialisasiDataAwal(playlist);
        
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== MENU PLAYLIST MUSIK ===");
            System.out.println("1. Tampilkan semua lagu");
            System.out.println("2. Tambah lagu baru");
            System.out.println("3. Hapus lagu berdasarkan judul");
            System.out.println("4. Cari lagu berdasarkan judul");
            System.out.println("5. Keluar");
            System.out.print("Pilihan: ");
            String pilihan = input.nextLine();

            switch (pilihan) {
                case "1":
                    playlist.tampilkanSemuaLagu(input);
                    break;

                case "2":
                    System.out.print("Masukkan judul lagu: ");
                    String judul = input.nextLine();
                    System.out.print("Masukkan nama artis: ");
                    String artis = input.nextLine();
                    System.out.print("Masukkan durasi (menit): ");
                    try {
                        double durasi = Double.parseDouble(input.nextLine());
                        playlist.tambahLagu(judul, artis, durasi);
                    } catch (NumberFormatException e) {
                        System.out.println("Durasi harus berupa angka!");
                    }
                    break;

                case "3":
                    System.out.print("Masukkan judul lagu yang akan dihapus: ");
                    String judulHapus = input.nextLine();
                    playlist.hapusLagu(judulHapus);
                    break;

                case "4":
                    System.out.print("Masukkan judul lagu yang dicari: ");
                    String keyword = input.nextLine();
                    playlist.cariLagu(keyword);
                    break;

                case "5":
                    running = false;
                    System.out.println("Terima kasih! Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        input.close();
    }

    /**
     * Inisialisasi data awal dengan 8 lagu default
     */
    private static void inisialisasiDataAwal(PlaylistArray playlist) {
        playlist.tambahLagu("Bohemian Rhapsody", "Queen", 5.55);
        playlist.tambahLagu("Imagine", "John Lennon", 3.03);
        playlist.tambahLagu("Stairway to Heaven", "Led Zeppelin", 8.02);
        playlist.tambahLagu("Hotel California", "Eagles", 6.30);
        playlist.tambahLagu("Yesterday", "The Beatles", 2.03);
        playlist.tambahLagu("Livin' on a Prayer", "Bon Jovi", 4.10);
        playlist.tambahLagu("Someone Like You", "Adele", 4.45);
        playlist.tambahLagu("Perfect", "Ed Sheeran", 4.23);
    }
}
