// Membuat kelas KartuKredit yang merupakan turunan dari Pembayaran dan mengimplementasi interface Keamanan
public class KartuKredit extends Pembayaran implements Keamanan {
    private String nomorKartu;

    public KartuKredit(String namaPembayar, double nominal, String nomorKartu) {
        super(namaPembayar, nominal);
        this.nomorKartu = nomorKartu;
    }

    @Override
    public void prosesPembayaran() {
        double biayaAdmin = nominal * 0.02;
        double totalTagihan = nominal + biayaAdmin;
        System.out.println("Biaya Admin (2%) : Rp " + String.format("%,.0f", biayaAdmin));
        System.out.println("Total Tagihan    : Rp " + String.format("%,.0f", totalTagihan));
    }

    @Override
    public boolean autentikasi() {
        System.out.println("[KartuKredit] Autentikasi PIN berhasil.");
        return true;
    }
}
