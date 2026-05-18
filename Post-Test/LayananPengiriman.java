// Kelas abstrak LayananPengiriman yang memiliki atribut noResi, beratBarang, dan jarakTempuh.

public abstract class LayananPengiriman {
    protected String noResi;
    protected double beratBarang; // kg
    protected double jarakTempuh; // km
    // Konstruktor untuk inisialisasi noResi, beratBarang, dan jarakTempuh
    public LayananPengiriman(String noResi, double beratBarang, double jarakTempuh) {
        this.noResi = noResi;
        this.beratBarang = beratBarang;
        this.jarakTempuh = jarakTempuh;
    }
    // Method untuk menampilkan detail resi pengiriman
    // Method untuk menampilkan detail resi pengiriman
    public void cetakResi() {
        System.out.println("No. Resi       : " + noResi);
        System.out.println("Berat Barang   : " + beratBarang + " kg");
        System.out.println("Jarak Tempuh   : " + jarakTempuh + " km");
    }
    //  Method abstrak untuk menghitung ongkos kirim, yang akan diimplementasikan oleh kelas turunan
    public abstract double hitungOngkosKirim();
}
