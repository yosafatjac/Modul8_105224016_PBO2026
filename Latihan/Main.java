// ini untuk membuat kelas Main 
// yang akan menjalankan program pembayaran menggunakan KartuKredit dan EWallet, 
// serta memanfaatkan interface Keamanan untuk autentikasi sebelum memproses pembayaran.

public class Main {
    public static void main(String[] args) {
        Pembayaran[] transaksi = {
            new KartuKredit("Yosafat Jacobus", 500_000, "4111-1111-1111-1111"),
            new EWallet("Dwi Setiawan", 150_000, "08123456789")
        };
        // Untuk menjalankan program pembayaran menggunakan KartuKredit dan EWallet,
        for (Pembayaran p : transaksi) {
            System.out.println("================================================");
            p.tampilkanDetail();

            // Cek apakah mengimplementasikan Keamanan menggunakan instanceof
            if (p instanceof Keamanan) {
                Keamanan k = (Keamanan) p;
                boolean sukses = k.autentikasi();
                if (sukses) {
                    p.prosesPembayaran();
                }
            }
        }
        System.out.println("================================================");
    }
}
