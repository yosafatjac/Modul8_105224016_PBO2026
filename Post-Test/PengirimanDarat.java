// Kita buat kelas PengirimanDarat yang merupakan subclass dari LayananPengiriman dan mengimplementasikan interface LacakKargo

public class PengirimanDarat extends LayananPengiriman implements LacakKargo {
    private String jenisTruk;
    private String statusSaatIni;

    // Ini untuk membuat konstruktor yang menerima parameter noResi, beratBarang, jarakTempuh, dan jenisTruk
    public PengirimanDarat(String noResi, double beratBarang, double jarakTempuh, String jenisTruk) {
        super(noResi, beratBarang, jarakTempuh);
        this.jenisTruk = jenisTruk;
        this.statusSaatIni = "Menunggu Kurir"; 
    }
    // Override metode hitungOngkosKirim untuk menghitung ongkos kirim berdasarkan berat, jarak, dan jenis truk
    @Override
    public double hitungOngkosKirim() {
        double ongkos = (beratBarang * 5000) + (jarakTempuh * 2000);
        // Biaya tambahan Rp 150.000 khusus truk Tronton (case-insensitive)
        if (jenisTruk.equalsIgnoreCase("Tronton")) {
            ongkos += 150_000;
        }
        return ongkos;
    }

    // Implementasi metode updateStatus untuk mengupdate status pengiriman
    @Override
    public void updateStatus(String status) {
        this.statusSaatIni = status;
    }

    @Override
    public String cekLokasiTerakhir() {
        return statusSaatIni;
    }
}
