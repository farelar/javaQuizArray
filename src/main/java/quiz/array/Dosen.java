package quiz.array;
import java.text.DecimalFormat;

public class Dosen extends Orang {
    String nidn;
    String matkul;
    Double gaji;
    int tahunKerja;
    int cutiDiambil;
    int sisaCuti;

    public Dosen(String nidn, String nama, String alamat, String matkul, Double gaji, int tahunKerja, int cutiDiambil) {
        super(nama, alamat);
        this.nidn = nidn;
        this.matkul = matkul;
        this.gaji = gaji;
        this.tahunKerja = tahunKerja;
        this.cutiDiambil = cutiDiambil;
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
        return gaji * 0.15;
    }

    public String tampilData() {
        DecimalFormat df = new DecimalFormat("#");
        return  "Laporan Dosen\n" +
                "====================\n" +
                "NIDN     : " + nidn + "\n" +
                "Nama     : " + nama + "\n" +
                "Alamat   : " + alamat + "\n" +
                "Matkul   : " + matkul + "\n" +
                "Gaji     : " + df.format(gaji) + "\n" +
                "Tahun Kerja : " + tahunKerja + "\n" +
                "Cuti Diambil : " + cutiDiambil + "\n" +
                "Sisa Cuti : " + sisaCuti() + "\n" +
                "Tunjangan : " + hitungTunjangan() + "\n";

    }

    public String lapDosen() {
        DecimalFormat df = new DecimalFormat("#");
        return nidn + "     " + nama + "     " + alamat + "     " + matkul + "     " + df.format(gaji) + "     " + tahunKerja + "     " + cutiDiambil + "     " + sisaCuti() + "     " + hitungTunjangan();
    }

}
