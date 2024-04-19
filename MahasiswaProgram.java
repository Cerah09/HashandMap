import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MahasiswaProgram {
    private Map<String, Integer> mahasiswaMap;

    public MahasiswaProgram() {
        mahasiswaMap = new HashMap<>();
    }

    public void tambahMahasiswa(String nim, String kelas, String nama, int nilai) {
        String key = nim + "-" + kelas + "-" + nama;
        mahasiswaMap.put(key, nilai);
    }

    public void hapusMahasiswa(String nim, String kelas, String nama) {
        String key = nim + "-" + kelas + "-" + nama;
        mahasiswaMap.remove(key);
    }

    public void simpanNilaiMahasiswa(String nim, String kelas, String nama, int nilai) {
        String key = nim + "-" + kelas + "-" + nama;
        if (mahasiswaMap.containsKey(key)) {
            mahasiswaMap.put(key, nilai);
        } else {
            System.out.println("Mahasiswa dengan NIM " + nim + ", kelas " + kelas + ", dan nama " + nama + " tidak ditemukan.");
        }
    }

    public void tampilkanNilaiMahasiswa() {
        System.out.println("Nilai Mahasiswa:");
        for (Map.Entry<String, Integer> entry : mahasiswaMap.entrySet()) {
            String[] keyParts = entry.getKey().split("-");
            String nim = keyParts[0];
            String kelas = keyParts[1];
            String nama = keyParts[2];
            int nilai = entry.getValue();
            System.out.println("NIM: " + nim + ", Kelas: " + kelas + ", Nama: " + nama + ", Nilai: " + nilai);
        }
    }

    public double hitungRataRataNilai() {
        if (mahasiswaMap.isEmpty()) {
            return 0;
        }

        int totalNilai = 0;
        for (int nilai : mahasiswaMap.values()) {
            totalNilai += nilai;
        }

        return (double) totalNilai / mahasiswaMap.size();
    }

    public static void main(String[] args) {
        MahasiswaProgram program = new MahasiswaProgram();
        Scanner scanner = new Scanner(System.in);

        // Menu
        int pilihan;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("3. Simpan Nilai Mahasiswa");
            System.out.println("4. Tampilkan Nilai Mahasiswa");
            System.out.println("5. Hitung Rata-rata Nilai Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline di buffer

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Kelas: ");
                    String kelas = scanner.nextLine();
                    System.out.print("Masukkan Nilai: ");
                    int nilaiTambah = scanner.nextInt();
                    program.tambahMahasiswa(nim, kelas, nama, nilaiTambah);
                    break;
                case 2:
                    System.out.print("Masukkan NIM: ");
                    nim = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    nama = scanner.nextLine();
                    System.out.print("Masukkan Kelas: ");
                    kelas = scanner.nextLine();
                    program.hapusMahasiswa(nim, kelas, nama);
                    break;
                case 3:
                    System.out.print("Masukkan NIM: ");
                    nim = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    nama = scanner.nextLine();
                    System.out.print("Masukkan Kelas: ");
                    kelas = scanner.nextLine();
                    System.out.print("Masukkan Nilai: ");
                    int nilaiSimpan = scanner.nextInt();
                    program.simpanNilaiMahasiswa(nim, kelas, nama, nilaiSimpan);
                    break;
                case 4:
                    program.tampilkanNilaiMahasiswa();
                    break;
                case 5:
                    System.out.println("Rata-rata Nilai Mahasiswa: " + program.hitungRataRataNilai());
                    break;
                case 0:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak valid.");
            }
        } while (pilihan != 0);

        scanner.close();
    }
}
