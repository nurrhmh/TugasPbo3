package week4;

import java.util.Scanner; // Mengimpor kelas Scanner untuk menerima input dari pengguna

public class Mainquiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk input pengguna
        Quiz quiz = new Quiz(); // Membuat objek dari kelas Quiz

        // Menampilkan pesan pembuka
        System.out.println("Selamat datang di Kuis Pengetahuan Umum!");
        System.out.println("Jawab semua pertanyaan dengan memilih nomor opsi (1-4).\n");

        // ini Loop untuk menampilkan setiap pertanyaan dalam kuis
        for (int i = 0; i < quiz.getQuestionCount(); i++) {
            quiz.displayQuestion(i); // Menampilkan pertanyaan
            System.out.print("Masukkan jawaban Anda (1-4): ");
            
            int userAnswer;
            while (true) {
                if (scanner.hasNextInt()) { // Memeriksa apakah input berupa angka
                    userAnswer = scanner.nextInt();
                    if (userAnswer >= 1 && userAnswer <= 4) { // Memastikan input dalam rentang 1-4
                        break; // Jawaban valid, keluar dari loop
                    }
                } else {
                    scanner.next(); // Membuang input yang tidak valid
                }
                System.out.print("Input tidak valid. Masukkan angka 1-4: ");
            }

            quiz.checkAnswer(i, userAnswer); // Mengecek jawaban pengguna
        }

        // Tampilkan skor akhir setelah semua pertanyaan dijawab
        int finalScore = quiz.getScore();
        System.out.println("\nSkor akhir Anda: " + finalScore);

        // Menampilkan pesan berdasarkan skor yang diperoleh
        if (finalScore == 30) {
            System.out.println("Luar biasa! Anda menjawab semua dengan benar!");
        } else if (finalScore >= 20) {
            System.out.println("Bagus! Anda hampir sempurna.");
        } else if (finalScore >= 10) {
            System.out.println("Lumayan, tapi masih bisa lebih baik.");
        } else {
            System.out.println("Coba lagi, masih banyak yang bisa dipelajari!");
        }

        scanner.close(); // Menutup objek Scanner untuk menghindari kebocoran sumber daya
    }
}
