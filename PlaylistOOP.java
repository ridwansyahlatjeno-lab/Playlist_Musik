// ==========================================
// #4 Logic & Main Program
// ==========================================
public class PlaylistOOP {
    public static void main(String[] args) {
        // Inisialisasi Array 
        Lagu[] playlist = new Lagu[100]; 
        int jumlahLagu = 0;
        
        Scanner input = new Scanner(System.in);
        
        // Contoh instansiasi objek (Polymorphism) 
        User userAktif;
        Admin admin = new Admin("AdminPlaylist");
        Member member = new Member("MemberPlaylist");
        
        boolean running = true;

        System.out.println("=== Sistem Manajemen Playlist ===");

        while (running) {
            System.out.println("\n--- Menu Utama ---");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Member");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            String pilihan = input.nextLine();

            switch (pilihan) {
                case "1":
                    // Login sebagai Admin (Polymorphism)
                    userAktif = admin;
                    userAktif.tampilkanAkses();

                    boolean adminMenu = true;
                    while (adminMenu) {
                        System.out.println("\n--- Menu Admin ---");
                        System.out.println("1. Tambah Lagu");
                        System.out.println("2. Lihat Playlist");
                        System.out.println("3. Hitung Rata-Rata Durasi");
                        System.out.println("0. Kembali");
                        System.out.print("Pilihan: ");
                        String pilihanAdmin = input.nextLine();

                        switch (pilihanAdmin) {
                            case "1":
                                jumlahLagu = admin.tambahLagu(playlist, jumlahLagu, input);
                                break;
                            case "2":
                                // Admin juga bisa melihat playlist
                                member.lihatPlaylist(playlist, jumlahLagu);
                                break;
                            case "3":
                                // Hitung rata-rata durasi menggunakan loop
                                if (jumlahLagu == 0) {
                                    System.out.println("Playlist kosong, tidak bisa menghitung rata-rata.");
                                } else {
                                    double totalDurasi = 0;
                                    for (int i = 0; i < jumlahLagu; i++) {
                                        totalDurasi += playlist[i].getDurasi();
                                    }
                                    double rataRata = totalDurasi / jumlahLagu;
                                    System.out.printf("Rata-rata durasi: %.2f menit%n", rataRata);
                                }
                                break;
                            case "0":
                                adminMenu = false;
                                break;
                            default:
                                System.out.println("Pilihan tidak valid.");
                        }
                    }
                    break;

                case "2":
                    // Login sebagai Member (Polymorphism)
                    userAktif = member;
                    userAktif.tampilkanAkses();

                    boolean memberMenu = true;
                    while (memberMenu) {
                        System.out.println("\n--- Menu Member ---");
                        System.out.println("1. Lihat Playlist");
                        System.out.println("2. Cari Lagu");
                        System.out.println("0. Kembali");
                        System.out.print("Pilihan: ");
                        String pilihanMember = input.nextLine();

                        switch (pilihanMember) {
                            case "1":
                                member.lihatPlaylist(playlist, jumlahLagu);
                                break;
                            case "2":
                                System.out.print("Masukkan judul lagu yang dicari: ");
                                String keyword = input.nextLine();
                                member.cariLagu(playlist, keyword, jumlahLagu);
                                break;
                            case "0":
                                memberMenu = false;
                                break;
                            default:
                                System.out.println("Pilihan tidak valid.");
                        }
                    }
                    break;

                case "0":
                    running = false;
                    System.out.println("Terima kasih! Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        input.close();
    }
}