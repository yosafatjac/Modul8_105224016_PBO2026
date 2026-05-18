// Karyawan.java
abstract class Karyawan {
    protected String nama;

    public Karyawan(String nama) {
        this.nama = nama;
    }

    public abstract double hitungGaji();
}

// Programmer.java
class Programmer extends Karyawan {
    private double gajiPokok;

    public Programmer(String nama, double gajiPokok) {
        super(nama);
        this.gajiPokok = gajiPokok;
    }

    @Override
    public double hitungGaji() {
        return gajiPokok;
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Programmer p = new Programmer("Yosafat", 8500000);
        System.out.println("Nama     : " + p.nama);
        System.out.println("Total Gaji: Rp" + p.hitungGaji());
    }
}
