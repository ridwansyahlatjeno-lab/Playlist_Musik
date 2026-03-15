class Admin extends User {
    public Admin(String username) {
        super(username);
    }

    @Override
    public void tampilkanAkses() {
        System.out.println("Akses: Admin (Bisa tambah & lihat lagu)");
    }

    /**
     * Menambahkan lagu baru ke playlist.
     * Meminta input judul, artis, dan durasi dari user,
     * lalu menyimpannya ke dalam array playlist.
     *
     * @param playlist array Lagu yang menjadi playlist
     * @param count    jumlah lagu saat ini di playlist
     * @param input    Scanner untuk membaca input user
     * @return         jumlah lagu setelah penambahan
     */
    public int tambahLagu(Lagu[] playlist, int count, Scanner input) {
        if (count >= playlist.length) {
            System.out.println("Playlist sudah penuh!");
            return count;
        }

        Lagu laguBaru = new Lagu();

        System.out.print("Masukkan judul lagu : ");
        laguBaru.setJudul(input.nextLine());

        System.out.print("Masukkan nama artis : ");
        laguBaru.setArtis(input.nextLine());

        System.out.print("Masukkan durasi (menit) : ");
        laguBaru.setDurasi(Double.parseDouble(input.nextLine()));

        playlist[count] = laguBaru;
        System.out.println("Lagu berhasil ditambahkan!");
        return count + 1;
    }
}
