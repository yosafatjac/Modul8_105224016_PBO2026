// Ini untuk membuat interface LacakKargo yang memiliki metode untuk melacak status dan lokasi kargo

public interface LacakKargo {
    void updateStatus(String status);
    String cekLokasiTerakhir();
}
