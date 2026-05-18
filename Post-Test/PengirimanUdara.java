
// Membuat kelas PengirimanUdara yang merupakan subclass dari LayananPengiriman serta
// mengimplementasikan interface LacakKargo dan Asuransi
public class PengirimanUdara extends LayananPengiriman implements LacakKargo, Asuransi {
    private String nomorPenerbangan;
    private String statusSaatIni;
    private double nilaiBarang;

    public PengirimanUdara(String noResi, double beratBarang, double jarakTempuh,
                           String nomorPenerbangan, double nilaiBarang) {
        super(noResi, beratBarang, jarakTempuh);
        this.nomorPenerbangan = nomorPenerbangan;
        this.nilaiBarang = nilaiBarang;
        this.statusSaatIni = "Menunggu Jadwal Penerbangan"; // status awal otomatis
    }

    public double getNilaiBarang() {
        return nilaiBarang;
    }

    @Override
    public double hitungOngkosKirim() {
        return (beratBarang * 25_000) + (jarakTempuh * 5_000);
    }

    @Override
    public double hitungPremi(double nilaiBarang) {
        return nilaiBarang * 0.03; // 3% dari nilai barang
    }

    @Override
    public void updateStatus(String status) {
        this.statusSaatIni = status;
    }

    @Override
    public String cekLokasiTerakhir() {
        return statusSaatIni;
    }
}
