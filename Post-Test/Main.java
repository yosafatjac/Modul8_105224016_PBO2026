public class Main {
    public static void main(String[] args) {
        // ini untuk membuat objek dari kelas PengirimanDarat dan PengirimanUdara
        PengirimanDarat darat = new PengirimanDarat("DRT-001", 50, 100, "Tronton");
        PengirimanUdara udara = new PengirimanUdara("UDR-999", 10, 800, "GA-123", 5_000_000);

        // Update status lokasi untuk kedua layanan pengiriman
        darat.updateStatus("Sedang di jalan tol Cipali");
        udara.updateStatus("Transit di Bandara Soekarno-Hatta");

        // Kita buat array dari tipe LayananPengiriman untuk menampung kedua objek tersebut
        LayananPengiriman[] armada = { darat, udara };

        // Iterasi array
        for (LayananPengiriman layanan : armada) {
            System.out.println("╔══════════════════════════════════════════════╗");

            // Cetak resi
            layanan.cetakResi();

            // Mengecek lokasi terakhir (polimorfik casting ke LacakKargo)
            if (layanan instanceof LacakKargo) {
                LacakKargo lk = (LacakKargo) layanan;
                System.out.println("Lokasi Terakhir: " + lk.cekLokasiTerakhir());
            }

            // Menghitung ongkos kirim dasar
            double ongkosKirim = layanan.hitungOngkosKirim();
            double totalTagihan = ongkosKirim;

            // Mendeteksi fasilitas asuransi
            if (layanan instanceof Asuransi) {
                Asuransi asuransi = (Asuransi) layanan;
                asuransi.cetakPolis();

                // Untuk memudahkan casting ke PengirimanUdara untuk ambil nilaiBarang
                PengirimanUdara pu = (PengirimanUdara) layanan;
                double premi = asuransi.hitungPremi(pu.getNilaiBarang());
                System.out.println("Premi Asuransi (3%): Rp " + String.format("%,.0f", premi));
                totalTagihan += premi;
            }
            // Untuk menampilkan total tagihan dengan format mata uang Indonesia
            System.out.println("Ongkos Kirim Dasar : Rp " + String.format("%,.0f", ongkosKirim));
            System.out.println(">>> TOTAL TAGIHAN  : Rp " + String.format("%,.0f", totalTagihan));
            System.out.println("╚══════════════════════════════════════════════╝");
            System.out.println();
        }
    }
}
