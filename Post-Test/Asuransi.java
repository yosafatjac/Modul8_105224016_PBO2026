// Membuat interface Asuransi memiliki metode hitungPremi() yang akan menghitung premi asuransi berdasarkan nilai barang yang diasuransikan.
public interface Asuransi {
    double hitungPremi(double nilaiBarang);

    // Default method (fitur Java 8)
    default void cetakPolis() {
        System.out.println("Polis Asuransi aktif: Menanggung kehilangan dan kerusakan fisik sebesar 100% dari nilai barang.");
    }
}
