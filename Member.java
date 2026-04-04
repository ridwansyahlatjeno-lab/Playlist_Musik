
// ==========================================
// #3 Inheritance (Member)
// ==========================================
class Member extends User {
    public Member(String username) {
        super(username);
    }

    @Override
    public void tampilkanAkses() {
        System.out.println("Akses: Member (Bisa cari & lihat lagu)");
    }

    /**
     * Menampilkan seluruh daftar lagu yang ada di playlist.
     *
     * @param playlist array Lagu
     * @param count    jumlah lagu saat ini
     */
    public void lihatPlaylist(Lagu[] playlist, int count) {
        if (count == 0) {
            System.out.println("Playlist kosong.");
            return;
        }
        System.out.println("\n=== Daftar Lagu ===");
        for (int i = 0; i < count; i++) {
            System.out.println("Lagu #" + (i + 1));
            playlist[i].tampilkanInfo();
        }
    }

    /**
     * Mencari lagu berdasarkan judul (case-insensitive).
     * Menampilkan semua lagu yang judulnya mengandung kata kunci.
     *
     * @param playlist array Lagu
     * @param judul    kata kunci pencarian
     * @param count    jumlah lagu saat ini
     */
    public void cariLagu(Lagu[] playlist, String judul, int count) {
        boolean ditemukan = false;
        System.out.println("\nHasil pencarian untuk \"" + judul + "\":");
        for (int i = 0; i < count; i++) {
            if (playlist[i].getJudul().toLowerCase().contains(judul.toLowerCase())) {
                playlist[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Lagu tidak ditemukan.");
        }
    }
}
