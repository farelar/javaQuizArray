package quiz.array;

public class Mahasiswa extends Orang {
    String nim;
    String jurusan;
    Double ipk;
    int cuti;

    public String getNim() {
        return nim;
    }
    
    public String getNama(){
        return nama;
    }

    public String getAlamat(){
        return alamat;
    }
    
    public String getJurusan() {
        return jurusan;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public Double getIpk() {
        return ipk;
    }

    public void setIpk(Double ipk) {
        this.ipk = ipk;
    }

    public int getCuti() {
        return cuti;
    }

    public void setCuti(int cuti) {
        this.cuti = cuti;
    }

    public Mahasiswa(String nim, String nama, String alamat, String jurusan, Double ipk, int cuti) {
        super(nama, alamat); 
        this.nim = nim;
        this.jurusan = jurusan;
        this.ipk = ipk;
        this.cuti = cuti;
    }

    
    @Override
    public double hitungTunjangan() {
        
        if(ipk >= 3.75)
            return 1000000;
        else
            return 0;
    }

    public String getStatusKuliah() {
        if(cuti <= 2)
            return "Lanjut Kuliah";
        else
            return "Do";
    }

    public String tampilData() {
        return "Laporan Mahasiswa\n" +
               "====================\n" +
               "NIM       : " + nim + "\n" +
               "Nama      : " + nama + "\n" +
               "Alamat    : " + alamat + "\n" +
               "Jurusan   : " + jurusan + "\n" +
               "IPK       : " + ipk + "\n" +
               "Cuti      : " + cuti + "\n" +
               "Status    : " + getStatusKuliah() + "\n" +
               "Beasiswa  : " + hitungTunjangan();
    }
    
    public String laporanMahasiswa() {
        return nim + "   " + nama + "    " + alamat + "     " + jurusan + "     " + ipk + "     " + cuti + "    " + getStatusKuliah() + "   " + hitungTunjangan();
    }
}
