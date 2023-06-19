package app.models;
public class Mahasiswa {
    private String nama;
    private String NIM;
    private String prodi;
    public Mahasiswa(String nama, String nIM, String prodi) {
        this.nama = nama;
        NIM = nIM;
        this.prodi = prodi;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNIM() {
        return NIM;
    }
    public void setNIM(String nIM) {
        NIM = nIM;
    }
    public String getProdi() {
        return prodi;
    }
    public void setProdi(String prodi) {
        this.prodi = prodi;
    }
}
