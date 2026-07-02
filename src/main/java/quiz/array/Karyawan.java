package quiz.array;

public class Karyawan extends Orang {
    String jabatan;
    double gaji;
    int tahunKerja;
    int cutiDiambil;

    public Karyawan(String nama, String alamat, String jabatan, double gaji, int tahunKerja, int cutiDiambil) {
        super(nama, alamat);
        this.jabatan = jabatan;
        this.gaji = gaji;
        this.tahunKerja = tahunKerja;
        this.cutiDiambil = cutiDiambil;
    }

    public String tampilData() {
        return "Laporan Karyawan\n" +
               "====================\n" +
               "Nama     : " + nama + "\n" +
               "Alamat   : " + alamat + "\n" +
               "Jabatan  : " + jabatan + "\n" +
               "Gaji     : Rp " + String.format("%.2f", gaji) + "\n" +
               "Tahun Kerja  : " + tahunKerja + "\n" +
               "Cuti Diambil : " + cutiDiambil + "\n" +
               "Sisa Cuti    : " + sisaCuti() + "\n" +
               "Tunjangan     : Rp " + String.format("%.2f", hitungTunjangan()) + "\n";
    }

    public String lapKaryawan() {
        return nama + "     " + alamat + "     " + jabatan + "     " + String.format("%.2f", gaji) + "     " + tahunKerja + "     " + cutiDiambil + "     " + sisaCuti() + "     " + String.format("%.2f", hitungTunjangan());
    }

    public int sisaCuti() {
        return tentukanCuti() - cutiDiambil;
    }

    public int tentukanCuti() {
        if (tahunKerja >= 26) {
            return 20;
        } else if (tahunKerja >= 16) {
            return 18;
        } else if (tahunKerja >= 6) {
            return 15;
        } else {
            return 12;
        }
    }

    @Override
    public double hitungTunjangan() {
        return gaji * 0.10;
    }
}

