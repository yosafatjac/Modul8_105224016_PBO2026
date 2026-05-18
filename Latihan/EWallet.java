//Disini kita membuat kelas EWallet 
//yang merupakan turunan dari Pembayaran dan mengimplementasi interface Keamanan

public class EWallet extends Pembayaran implements Keamanan {
    private String nomorHP;

    public EWallet(String namaPembayar, double nominal, String nomorHP) {
        super(namaPembayar, nominal);
        this.nomorHP = nomorHP;
    }

    @Override
    public void prosesPembayaran() {
        // Tidak ada biaya admin, total = nominal
        System.out.println("Total Tagihan : Rp " + String.format("%,.0f", nominal));
    }

    @Override
    public boolean autentikasi() {
        System.out.println("[EWallet] Autentikasi berhasil.");
        return true;
    }
}
