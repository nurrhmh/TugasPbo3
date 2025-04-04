package B02;

public class Nilai {
    // Atribut
    String nim;          
    String nama;
    double nilaiUts;
    double nilaiTugas;
    double nilaiUas;
    double pNilaiUts;    
    double pNilaiTugas;  
    double pNilaiUas;    
    double nilaiAkhir;

    // Method untuk hitung nilai
    void hitungNilai() {
        this.pNilaiTugas = this.nilaiTugas * 0.30;  
        this.pNilaiUts = this.nilaiUts * 0.35;      
        this.pNilaiUas = this.nilaiUas * 0.35;      
        this.nilaiAkhir = this.pNilaiUts + this.pNilaiTugas + this.pNilaiUas; 
    }

    // Method untuk cetak nilai lengkap
    void cetakNilai() {
        System.out.println("Nilai Tugas : " + this.nilaiTugas + " (20%)   = " + this.pNilaiTugas);
        System.out.println("Nilai UTS   : " + this.nilaiUts + " (35%)   = " + this.pNilaiUts);
        System.out.println("Nilai UAS   : " + this.nilaiUas + " (45%)   = " + this.pNilaiUas);
        System.out.println("Nilai Akhir : " + this.nilaiAkhir);
    }

    // Method untuk cetak daftar nilai ringkas
    void daftarNilai() {
        System.out.println("NIM: " + this.nim + ", Nama: " + this.nama + ", Nilai Akhir: " + this.nilaiAkhir);
    }

    // Method main sebagai titik awal program
    public static void main(String[] args) {
        // Membuat objek dari kelas Nilai
        Nilai mahasiswa = new Nilai();

        // Mengisi data
        mahasiswa.nim = "12345678";
        mahasiswa.nama = "Ani";
        mahasiswa.nilaiTugas = 90;
        mahasiswa.nilaiUts = 85;
        mahasiswa.nilaiUas = 85;

        // Memproses dan menampilkan hasil
        mahasiswa.hitungNilai();
        mahasiswa.cetakNilai();
        mahasiswa.daftarNilai();
    }
}
