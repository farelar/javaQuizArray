package quiz.array;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Sistem{
    private Mahasiswa[] mhs = new Mahasiswa[3];
    private Dosen[] dosen = new Dosen[3];
    private Karyawan[] karyawan = new Karyawan[3];

    private int jmhs = -1;
    private int jdosen = -1;
    private int jkaryawan = -1;
    
    public Sistem() {
        mhs[0] = new Mahasiswa("101", "Andi", "Jakarta", "Sistem Informasi", 3.8, 0);
        mhs[1] = new Mahasiswa("102", "Budi", "Bandung", "Informatika", 3.2, 1);
        mhs[2] = new Mahasiswa("103", "Citra", "Semarang", "Teknik Komputer", 3.9, 0);
        
        jmhs = 2; 
    }

    public void jalankanMenu() {
        boolean running = true;
        do {
            int pilih = 0;
            boolean putar = true;
            do {
                try {
                    String inputMenu = JOptionPane.showInputDialog(
                        "MENU SISTEM\n\n" +
                        "1. Input Mahasiswa\n" +
                        "2. Input Dosen\n" +
                        "3. Input Karyawan\n" +
                        "4. Laporan Mahasiswa\n" +
                        "5. Laporan Dosen\n" +
                        "6. Laporan Karyawan\n" +
                        "7. Keluar\n\n" +
                        "Pilihan : "
                    );

                    if (inputMenu == null) {
                        System.exit(0); 
                    }

                    pilih = Integer.parseInt(inputMenu);
                    if (pilih >= 1 && pilih <= 7) {
                        putar = false;
                    } else {
                        JOptionPane.showMessageDialog(null, "Masukkan pilihan 1-7.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Masukkan angka yang valid!");
                }
            } while (putar);

            switch(pilih) {
                case 1: inputDataMahasiswa(); break;
                case 2: inputDataDosen(); break;
                case 3: inputDataKaryawan(); break;
                case 4: cetakLaporanMahasiswa(); break;
                case 5: cetakLaporanDosen(); break;
                case 6: cetakLaporanKaryawan(); break;
                case 7: running = false; break;
            }
        } while(running);
    }

    private void inputDataMahasiswa() {
        if (jmhs >= mhs.length - 1) {
            JOptionPane.showMessageDialog(null, "Data Mahasiswa sudah penuh (maksimal 3 data).");
            return;
        }

        String nim = inputNonEmpty("NIM");
        String namaMhs = inputNonEmpty("Nama");
        String alamatMhs = inputNonEmpty("Alamat");
        String jurusan = inputNonEmpty("Jurusan");
        
        Double ipk = 0.0;
        do {
            ipk = inputDouble("IPK (0.0 - 4.0)");
            if (ipk < 0.0 || ipk > 4.0) {
                JOptionPane.showMessageDialog(null, "IPK harus di antara 0.0 dan 4.0!");
            }
        } while (ipk < 0.0 || ipk > 4.0);

        int cuti = -1;
        do {
            cuti = inputInt("Cuti");
            if (cuti < 0) JOptionPane.showMessageDialog(null, "Cuti tidak boleh negatif!");
        } while (cuti < 0);

        jmhs++;
        mhs[jmhs] = new Mahasiswa(nim, namaMhs, alamatMhs, jurusan, ipk, cuti);

        JTextArea textArea = new JTextArea(mhs[jmhs].tampilData() + "\n");
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Data Mahasiswa Berhasil Disimpan", JOptionPane.INFORMATION_MESSAGE);
    }

    private void inputDataDosen() {
        if (jdosen >= dosen.length - 1) {
            JOptionPane.showMessageDialog(null, "Data Dosen sudah penuh (maksimal 3 data).");
            return;
        }

        String nidn = inputNonEmpty("NIDN");
        String namaDosen = inputNonEmpty("Nama");
        String alamatDosen = inputNonEmpty("Alamat");
        String matkul = inputNonEmpty("Matkul");
        Double gaji = inputDouble("Gaji");
        int tahunKerja = inputInt("Tahun Kerja");

        int jatahCuti = (tahunKerja >= 26) ? 20 : (tahunKerja >= 16) ? 18 : (tahunKerja >= 6) ? 15 : 12;
        
        int cutiDiambil = -1;
        do {
            cutiDiambil = inputInt("Cuti Diambil (Maksimal " + jatahCuti + "):");
            if (cutiDiambil < 0 || cutiDiambil > jatahCuti) {
                JOptionPane.showMessageDialog(null, "Cuti tidak valid! Maksimal " + jatahCuti);
            }
        } while (cutiDiambil < 0 || cutiDiambil > jatahCuti);

        jdosen++;
        dosen[jdosen] = new Dosen(nidn, namaDosen, alamatDosen, matkul, gaji, tahunKerja, cutiDiambil);

        JTextArea textArea = new JTextArea(dosen[jdosen].tampilData() + "\n");
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Data Dosen Berhasil Disimpan", JOptionPane.INFORMATION_MESSAGE);
    }

    private void inputDataKaryawan() {
        if (jkaryawan >= karyawan.length - 1) {
            JOptionPane.showMessageDialog(null, "Data Karyawan sudah penuh (maksimal 3 data).");
            return;
        }

        String namaKar = inputNonEmpty("Nama");
        String alamatKar = inputNonEmpty("Alamat");
        String jabatan = inputNonEmpty("Jabatan");
        double gaji = inputDouble("Gaji");
        int tahunKerja = inputInt("Tahun Kerja");

        int jatahCuti = (tahunKerja >= 26) ? 20 : (tahunKerja >= 16) ? 18 : (tahunKerja >= 6) ? 15 : 12;

        int cutiDiambil = -1;
        do {
            cutiDiambil = inputInt("Cuti Diambil (Maksimal " + jatahCuti + "):");
            if (cutiDiambil < 0 || cutiDiambil > jatahCuti) {
                JOptionPane.showMessageDialog(null, "Cuti tidak valid! Maksimal " + jatahCuti);
            }
        } while (cutiDiambil < 0 || cutiDiambil > jatahCuti);

        jkaryawan++;
        karyawan[jkaryawan] = new Karyawan(namaKar, alamatKar, jabatan, gaji, tahunKerja, cutiDiambil);

        JTextArea textArea = new JTextArea(karyawan[jkaryawan].tampilData() + "\n");
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Data Karyawan Berhasil Disimpan", JOptionPane.INFORMATION_MESSAGE);
    }

    //laporan method
    private void cetakLaporanMahasiswa() {
        if (jmhs < 0) {
            JOptionPane.showMessageDialog(null, "Data Mahasiswa kosong. Silakan input data terlebih dahulu.");
            return;
        }
        String hasil = "=========================== LAPORAN MAHASISWA ================================\n";
        hasil += "No    NIM    Nama    Alamat    Jurusan    IPK    Cuti(sem)    Status    Beasiswa\n";
        hasil += "==============================================================================\n";
        for (int i = 0; i <= jmhs; i++) {
            hasil += (i + 1) + ".   " + mhs[i].laporanMahasiswa() + "\n";
        }
        tampilkanScroll(hasil, "Laporan Mahasiswa");
    }

    private void cetakLaporanDosen() {
        if (jdosen < 0) {
            JOptionPane.showMessageDialog(null, "Data Dosen kosong. Silakan input data terlebih dahulu.");
            return;
        }
        String hasil = "=========================== LAPORAN DOSEN ===============================\n";
        hasil += "No    NIDN    Nama    Alamat    Matkul    Gaji    TahunKerja    Cuti    Sisa    Tunjangan\n";
        hasil += "=========================================================================\n";
        for (int i = 0; i <= jdosen; i++) {
            hasil += (i + 1) + ".   " + dosen[i].lapDosen() + "\n";
        }
        tampilkanScroll(hasil, "Laporan Dosen");
    }

    private void cetakLaporanKaryawan() {
        if (jkaryawan < 0) {
            JOptionPane.showMessageDialog(null, "Data Karyawan kosong. Silakan input data terlebih dahulu.");
            return;
        }
        String hasil = "=========================== LAPORAN KARYAWAN ===============================\n";
        hasil += "No    Nama    Alamat    Jabatan    Gaji    TahunKerja    Cuti    Sisa    Tunjangan\n";
        hasil += "=========================================================================\n";
        for (int i = 0; i <= jkaryawan; i++) {
            hasil += (i + 1) + ".   " + karyawan[i].lapKaryawan() + "\n";
        }
        tampilkanScroll(hasil, "Laporan Karyawan");
    }

    private void tampilkanScroll(String teks, String judul) {
        JTextArea area = new JTextArea(teks);
        area.setEditable(false);
        JOptionPane.showMessageDialog(null, new JScrollPane(area), judul, JOptionPane.INFORMATION_MESSAGE);
    }

    private String inputNonEmpty(String message) {
        String input;
        do {
            input = JOptionPane.showInputDialog(message);
            if (input == null) System.exit(0);
        } while (input.trim().isEmpty());
        return input.trim();
    }

    private double inputDouble(String message) {
        String input;
        double value = 0;
        boolean valid = false;
        do {
            input = inputNonEmpty(message);
            try {
                value = Double.parseDouble(input);
                valid = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Input harus angka. Silakan coba lagi.");
            }
        } while (!valid);
        return value;
    }

    private int inputInt(String message) {
        String input;
        int value = 0;
        boolean valid = false;
        do {
            input = inputNonEmpty(message);
            try {
                value = Integer.parseInt(input);
                valid = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Input harus angka bulat. Silakan coba lagi.");
            }
        } while (!valid);
        return value;
    }
}
