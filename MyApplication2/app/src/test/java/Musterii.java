public class Musterii {
    private int musteriid;
    private String musteriad;
    private String musterisoyad;
    private String telefon;
    private String mail;
    private String adres;
    private String kuladi;
    private String sifre;

    public Musterii(int musteriid, String musteriad, String musterisoyad, String telefon, String mail, String adres, String kuladi, String sifre) {
        this.musteriid = musteriid;
        this.musteriad = musteriad;
        this.musterisoyad = musterisoyad;
        this.telefon = telefon;
        this.mail = mail;
        this.adres = adres;
        this.kuladi = kuladi;
        this.sifre = sifre;
    }

    public int getMusteriid() {
        return musteriid;
    }

    public void setMusteriid(int musteriid) {
        this.musteriid = musteriid;
    }

    public String getMusteriad() {
        return musteriad;
    }

    public void setMusteriad(String musteriad) {
        this.musteriad = musteriad;
    }

    public String getMusterisoyad() {
        return musterisoyad;
    }

    public void setMusterisoyad(String musterisoyad) {
        this.musterisoyad = musterisoyad;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getKuladi() {
        return kuladi;
    }

    public void setKuladi(String kuladi) {
        this.kuladi = kuladi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
}
