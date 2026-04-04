/**
 * ================================================
 *   Introduction to OOP & Data Structures
 * ================================================
 * Kelompok 4
 *   1. [Abzachrie Defghi Ferdyan] - [2902741953]
 *   2. [Nama] - [NIM]
 *   3. [Nama] - [NIM]
 *   4. [Nama] - [NIM]
 * ================================================
 */
 
import java.util.Scanner;
 
// ============================================================
// #1 CLASS Lagu
//  Merepresentasikan sebuah lagu dengan enkapsulasi penuh.
//  Semua atribut bersifat private dan diakses via getter/setter.
// ============================================================
class Lagu {
    // Atribut private (Enkapsulasi)
    private String judul;
    private String artis;
    private double durasi; // dalam menit
 
    /**
     * Constructor: Menginisialisasi objek Lagu dengan
     * judul, artis, dan durasi yang diberikan.
     */
    public Lagu(String judul, String artis, double durasi) {
        this.judul  = judul;
        this.artis  = artis;
        this.durasi = durasi;
    }
 
    // ---------- Getter ----------
 
    /** Mengembalikan judul lagu */
    public String getJudul()  { return judul; }
 
    /** Mengembalikan nama artis */
    public String getArtis()  { return artis; }
 
    /** Mengembalikan durasi lagu (menit) */
    public double getDurasi() { return durasi; }
 
    // ---------- Setter ----------
 
    /** Mengubah judul lagu */
    public void setJudul(String judul)   { this.judul  = judul; }
 
    /** Mengubah nama artis */
    public void setArtis(String artis)   { this.artis  = artis; }
 
    /** Mengubah durasi lagu */
    public void setDurasi(double durasi) { this.durasi = durasi; }
 
    /**
     * Menampilkan informasi lengkap sebuah lagu:
     * judul, artis, dan durasi dalam format yang mudah dibaca.
     */
    public void tampilkanInfo() {
        System.out.println("  Judul  : " + judul);
        System.out.println("  Artis  : " + artis);
        System.out.printf ("  Durasi : %.2f menit%n", durasi);
        System.out.println("  " + "-".repeat(30));
    }
}