// Buat kelas abstrak Pembayaran yang memiliki atribut namaPembayar dan nominal
public abstract class Pembayaran {
    protected String namaPembayar;
    protected double nominal;

    // Konstruktor untuk inisialisasi namaPembayar dan nominal
    public Pembayaran(String namaPembayar, double nominal) {
        this.namaPembayar = namaPembayar;
        this.nominal = nominal;
    }

    // Method untuk menampilkan detail pembayaran
    public void tampilkanDetail() {
        System.out.println("Nama Pembayar : " + namaPembayar);
        System.out.println("Nominal       : Rp " + String.format("%,.0f", nominal));
    }

    // Method abstrak untuk memproses pembayaran, yang akan diimplementasikan oleh kelas turunan
    public abstract void prosesPembayaran();
}
