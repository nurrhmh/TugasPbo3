package B02;
import java.util.Scanner;

public class Nilai2 {
    // ATTRIBUT
    static Nilai[] daftarMahasiswa;                     
    static Scanner masukan = new Scanner(System.in);

    public static void inputData(int index) {
        // Mengisi data mahasiswa ke-n
        // Pesan awal
        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println("> Input Data mahasiswa ke-" + (index + 1));
        System.out.println("-------------------------------------");
        
        daftarMahasiswa[index] = new Nilai(); // create objek

        // input data
        System.out.print("Input data NIM            : ");
        daftarMahasiswa[index].nim = masukan.next();

        System.out.print("Input data Nama           : ");
        daftarMahasiswa[index].nama = masukan.next();

        System.out.print("Input data Nilai Tugas    : ");
        daftarMahasiswa[index].nilaiTugas = masukan.nextDouble();

        System.out.print("Input data Nilai UTS      : ");
        daftarMahasiswa[index].nilaiUts = masukan.nextDouble();

        System.out.print("Input data Nilai UAS      : ");
        daftarMahasiswa[index].nilaiUas = masukan.nextDouble();

        // Proses penghitungan Nilai
        daftarMahasiswa[index].hitungNilai();
        System.out.println("-------------------------------------");
        System.out.println();
    }

    // Cetak Data Nilai
    public static void printNilai(int index) {
        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println("> DAFTAR NILAI MAHASISWA KE-" + (index + 1));
        System.out.println("-------------------------------------");
        System.out.println("Nim     : "+ daftarMahasiswa[index].nim);
        System.out.println("Nama    : "+ daftarMahasiswa[index].nama);
        daftarMahasiswa[index].cetakNilai(); // cetak detail
        System.out.println("-------------------------------------");
        System.out.println();
    }

    public static void main(String[] args) {
        int total;

        System.out.println("Program input Data Nilai");
        System.out.println("-------------------------");
        System.out.println("Berapa Data yang ingin anda input?");
        System.out.print("Answer : ");
        total = masukan.nextInt(); // input jumlah mhs yg ingin di input
        daftarMahasiswa = new Nilai[total]; // menyiapkan slot mhs yg ingin diinput

        
        // Mengisi data mahasiswa pertama
        for (int i = 0; i < total; i++) {
            inputData(i); // Panggil void inputData
        }

        // Menampilkan daftar nilai semua mahasiswa
        System.out.println("");
        System.out.println("-------------------------------------");
        System.out.println("> DAFTAR NILAI SEMUA MAHASISWA");
        System.out.println("-------------------------------------");
        System.out.println("");

        for (Nilai mhs : daftarMahasiswa) {
            mhs.daftarNilai(); // Cetak semua satu per satu
        }

        System.out.println("-------------------------------------");
        System.out.println("");


        // UNTUK PRINT NILAI PER MHS
        for (int i = 0; i < total; i++) {
            printNilai(i); // Panggil void printNilai
        }
        // detail Nilai Mahasiswa       
    }
}