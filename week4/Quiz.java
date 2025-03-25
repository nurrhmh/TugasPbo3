package week4;
import java.util.Scanner; // Mengimpor kelas Scanner untuk menerima input dari pengguna

public class Quiz {
    // Array yang berisi daftar pertanyaan
    private String[] questions = {
        "Apa nama ibu kota negara Jepang?",
        "Planet mana yang dikenal sebagai 'Planet Merah'?",
        "Berapa hasil dari Penjumlahan dari 10+25+15? =",
        "Lagu kebangsaan Indonesia adalah?",
        "Hewan apa yang menjadi simbol negara Australia?",
        "Apa nama gas yang kita hirup untuk bernafas?",
        "Negara mana yang terkenal dengan Menara Pisa?",
        "Apa nama benua yang paling kecil di dunia?",
        "Apa nama alat untuk mengukur gempa bumi?",
        "Apa mata uang resmi di Indonesia?"
    };
    
    // Array dua dimensi yang berisi pilihan jawaban untuk setiap pertanyaan
    private String[][] options = {
        {"1. Beijing", "2. Seoul", "3. Tokyo", "4. Bangkok"},
        {"1. Venus", "2. Mars", "3. Jupiter", "4. Saturnus"},
        {"1. 30", "2. 40", "3. 50", "4. 60"},
        {"1. Indonesia Raya", "2. Garuda Pancasila", "3. Tanah Airku", "4. Bagimu Negeri"},
        {"1. Koala", "2. Kanguru", "3. Unta", "4. Sapi"},
        {"1. Karbon dioksida", "2. Nitrogen", "3. Oksigen", "4. Hidrogen"},
        {"1. Spanyol", "2. Italia", "3. Prancis", "4. Jerman"},
        {"1. Australia", "2. Afrika", "3. Antartika", "4. Amerika"},
        {"1. Barometer", "2. Seismograf", "3. Anemometer", "4. Termometer"},
        {"1. Euro", "2. Ringgit", "3. Rupiah", "4. Dolar"}
    };
    
    // Array yang menyimpan indeks jawaban yang benar (1-based index)
    private int[] correctAnswers = {3, 2, 3, 1, 2, 3, 2, 1, 2, 3}; 
    private int score = 0; // Variabel untuk menyimpan skor pengguna

    // Method untuk mendapatkan jumlah pertanyaan dalam kuis
    public int getQuestionCount() {
        return questions.length;
    }

    // Method untuk menampilkan pertanyaan dan pilihan jawaban
    public void displayQuestion(int index) {
        System.out.println("\nPertanyaan " + (index + 1) + ": " + questions[index]);
        for (String option : options[index]) {
            System.out.println(option);
        }
    }

    // Method untuk memeriksa jawaban yang dimasukkan oleh pengguna
    public void checkAnswer(int questionIndex, int userAnswer) {
        if (userAnswer == correctAnswers[questionIndex]) {
            System.out.println("Benar!");
            score += 10; // Menambah skor jika jawaban benar
        } else {
            System.out.println("Salah! Jawaban yang benar adalah: " + options[questionIndex][correctAnswers[questionIndex] - 1]);
        }
    }

    // Method untuk mendapatkan skor akhir
    public int getScore() {
        return score;
    }

    // Method utama untuk menjalankan program kuis
    public static void main(String[] args) {
        Quiz quiz = new Quiz(); // Membuat objek dari kelas Quiz
        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk input pengguna

        // Loop untuk menampilkan semua pertanyaan dalam kuis
        for (int i = 0; i < quiz.getQuestionCount(); i++) {
            quiz.displayQuestion(i); // Menampilkan pertanyaan
            System.out.print("Masukkan jawaban Anda (1-4): ");
            int userAnswer = scanner.nextInt(); // Menerima input jawaban dari pengguna
            quiz.checkAnswer(i, userAnswer); // Mengecek jawaban yang dimasukkan
        }

        // Menampilkan skor akhir setelah kuis selesai
        System.out.println("\nSkor akhir Anda: " + quiz.getScore());
        scanner.close(); // Menutup objek Scanner untuk menghindari kebocoran sumber daya
    }
}