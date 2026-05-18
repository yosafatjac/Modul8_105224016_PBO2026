// Ini untuk membuat interface Keamanan yang memiliki metode autentikasi() 
// yang akan digunakan untuk mengamankan proses pembayaran pada kelas EWallet dan KartuKredit.
public interface Keamanan {
    boolean autentikasi();
}
