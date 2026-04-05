# Sistem Manajemen Playlist Musik - Array Operations

Sistem manajemen playlist musik yang fokus pada **Operasi Array dalam Struktur Data**, mencakup Traversal, Insertion, Deletion, Searching, dan Sorting.

## 📋 Deskripsi Program

Program ini adalah implementasi praktis dari operasi array dasar dalam bahasa Java. User dapat mengelola playlist musik dengan fitur-fitur berikut:

### Fitur Utama:
1. **Traversal** - Menampilkan semua lagu di playlist
2. **Insertion** - Menambahkan lagu baru (dengan pengecekan kapasitas)
3. **Deletion** - Menghapus lagu berdasarkan judul (dengan penggeseran elemen)
4. **Searching** - Mencari lagu menggunakan Linear Search
5. **Sorting** - Mengurutkan lagu berdasarkan durasi (Selection Sort, ascending)

### Struktur Data:
- **Array Statis**: Kapasitas maksimal 10 lagu
- **Class Lagu**: Merepresentasikan satu lagu dengan atribut judul, artis, dan durasi
- **Class PlaylistArray**: Mengelola operasi array pada playlist

## 🚀 Cara Menjalankan

### 1. Clone Repository
```bash
git clone https://github.com/ridwansyahlatjeno-lab/Playlist.git
cd Playlist
```

### 2. Compile Program
```bash
javac *.java
```

### 3. Jalankan Program
```bash
java PlaylistArray
```

## 📝 Menu Program

```
=== MENU PLAYLIST MUSIK ===
1. Tampilkan semua lagu
2. Tambah lagu baru
3. Hapus lagu berdasarkan judul
4. Cari lagu berdasarkan judul
5. Keluar
```

### Penjelasan Menu:

**1. Tampilkan semua lagu**
- Menampilkan semua lagu dalam playlist
- Menawarkan opsi untuk mengurutkan lagu berdasarkan durasi (ascending)
- Menggunakan Selection Sort untuk pengurutan

**2. Tambah lagu baru**
- Input: Judul lagu, Nama artis, Durasi (dalam menit)
- Program akan mengecek apakah playlist sudah penuh
- Jika penuh (kapasitas 10), penambahan ditolak

**3. Hapus lagu berdasarkan judul**
- Input: Judul lagu yang ingin dihapus
- Linear Search untuk menemukan lagu
- Elemen array di-shift agar tetap rapat

**4. Cari lagu berdasarkan judul**
- Input: Kata kunci pencarian
- Linear Search untuk mencari lagu yang mengandung kata kunci
- Case-insensitive search

**5. Keluar**
- Menutup program

## 📂 File-file Program

```
Playlist/
├── Lagu.java           # Class Lagu dengan atribut dan method tampilkanInfo()
├── PlaylistArray.java  # Class PlaylistArray dengan operasi array + main method
└── README.md          # Dokumentasi program
```

## 🎵 Data Awal

Program memulai dengan 8 lagu default:
1. Bohemian Rhapsody - Queen (5.55 menit)
2. Imagine - John Lennon (3.03 menit)
3. Stairway to Heaven - Led Zeppelin (8.02 menit)
4. Hotel California - Eagles (6.30 menit)
5. Yesterday - The Beatles (2.03 menit)
6. Livin' on a Prayer - Bon Jovi (4.10 menit)
7. Someone Like You - Adele (4.45 menit)
8. Perfect - Ed Sheeran (4.23 menit)

## 💡 Contoh Penggunaan

### Tampilkan dan Urutkan Lagu:
1. Pilih menu **1**
2. Lihat semua lagu
3. Jawab **y** pada pertanyaan pengurutan
4. Lagu akan ditampilkan kembali dalam urutan durasi ascending

### Tambah Lagu Baru:
1. Pilih menu **2**
2. Masukkan judul: "Blinding Lights"
3. Masukkan artis: "The Weeknd"
4. Masukkan durasi: 3.20
5. Lagu berhasil ditambahkan

### Cari Lagu:
1. Pilih menu **4**
2. Masukkan kata kunci: "imagine"
3. Program akan menampilkan lagu yang mengandung "imagine"

### Hapus Lagu:
1. Pilih menu **3**
2. Masukkan judul yang akan dihapus: "Perfect"
3. Lagu akan dihapus dan elemen array di-shift

## 🛠 Persyaratan

- Java Development Kit (JDK) 8 atau lebih tinggi
- Terminal/Command Prompt

## 👥 Kelompok 4

1. ABZACHRIE DEFGHI FERDYAN - 2902741953
2. AHMAD DWIYAN ANUGRAH PUTRA - 2902742205
3. KIMI MARTUA CASSANOVA SIMAJUNTAK - 2902733806
4. RIDWANSYAH LATJENO - 2902699125
5. SYAHRUL ADY PRATAMA - 2902728440

## 📚 Mata Kuliah

Data Structures and Algorithm Analysis - Semester 2

---

**Status**: ✅ Fully Functional  
**Last Updated**: April 6, 2026
