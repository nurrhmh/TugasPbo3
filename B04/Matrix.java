package B04;
import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner masukan = new Scanner(System.in);
        
        // Pesan pembuka
        System.out.println("---------------------------------");
        System.out.println("> PROGRAM OPERASI MATRIX");
        System.out.println("---------------------------------");
        
        // Input ukuran matriks (sama untuk R dan B)
        System.out.print("\nInput baris matrix = ");
        int rows = masukan.nextInt();
        System.out.print("Input kolom matrix = ");
        int cols = masukan.nextInt();
        
        // Deklarasi ukuran matriks R dan B
        int rowsR = rows;
        int rowsB = rows;
        int colsR = cols;
        int colsB = cols;

        // Input matriks pertama (R)
        int[][] matrixR = inputMatrix(masukan, rowsR, colsR, "R");
        
        // Input matriks kedua (B)
        int[][] matrixB = inputMatrix(masukan, rowsB, colsB, "B");
        
        // Variabel kontrol perulangan
        boolean lanjut = true;
        
        // Loop utama program
        do {
            // Menu pilihan operasi
            System.out.println("\n---------------------------------");
            System.out.println("PILIH OPERASI MATRIX");
            System.out.println("---------------------------------");
            System.out.println("1. Penjumlahan Matrix (R + B)");
            System.out.println("2. Perkalian Matrix (R × B)");
            System.out.println("3. Transpos Matrix (Rᵀ)");
            System.out.println("4. Transpos Matrix (Bᵀ)");
            System.out.println("5. Semua Operasi");
            System.out.print("Pilih operasi (1-5): ");
            int choice = masukan.nextInt();
            
            // Proses sesuai pilihan user
            switch (choice) {
                case 1:
                    // Penjumlahan matriks
                    System.out.println("\nHasil penjumlahan matrix R + B:");
                    printMatrix(addMatrices(matrixR, matrixB));
                    break;
                case 2:
                    // Perkalian matriks
                    System.out.println("\nHasil perkalian matrix R × B:");
                    printMatrix(multiplyMatrices(matrixR, matrixB));
                    break;
                case 3:
                    // Transpos matriks R
                    System.out.println("\nHasil transpos matrix Rᵀ:");
                    printMatrix(transposeMatrix(matrixR));
                    break;
                case 4:
                    // Transpos matriks B
                    System.out.println("\nHasil transpos matrix Bᵀ:");
                    printMatrix(transposeMatrix(matrixB));
                    break;
                case 5:
                    // Semua operasi
                    System.out.println("\nHasil penjumlahan matrix R + B:");
                    printMatrix(addMatrices(matrixR, matrixB));
                    
                    System.out.println("\nHasil perkalian matrix R × B:");
                    printMatrix(multiplyMatrices(matrixR, matrixB));
                    
                    System.out.println("\nHasil transpos matrix Rᵀ:");
                    printMatrix(transposeMatrix(matrixR));
                    
                    System.out.println("\nHasil transpos matrix Bᵀ:");
                    printMatrix(transposeMatrix(matrixB));
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }

            // Konfirmasi kelanjutan program
            System.out.println("\n---------------------------");
            System.out.println("> Apakah anda ingin lanjut?");
            System.out.println(" Y | Untuk lanjut");
            System.out.println(" T | Untuk selesai ");
            System.out.println("---------------------------");
            System.out.print("Jawaban : ");
            String lanjutga = masukan.next();

            // Mengecek input user untuk melanjutkan atau tidak
            if (lanjutga.equalsIgnoreCase("Y")) {
                lanjut = true;
            } else {
                lanjut = false;
            }
            
            System.out.println("---------------------------");

        } while (lanjut);
        
        // Menutup scanner
        masukan.close();
    }
    
    /**
     * Method untuk menginput elemen matriks
     * @param scanner Objek Scanner untuk input
     * @param rows Jumlah baris matriks
     * @param cols Jumlah kolom matriks
     * @param name Nama matriks (R atau B)
     * @return Matriks yang telah diisi
     */
    public static int[][] inputMatrix(Scanner scanner, int rows, int cols, String name) {
        int[][] matrix = new int[rows][cols];
        System.out.println("\nInput elemen matrix " + name + ":");
        
        // Loop untuk mengisi setiap elemen matriks
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Input elemen matrix " + name + " [" + i + "," + j + "] = ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }
    
    /**
     * Method untuk penjumlahan dua matriks
     * @param a Matriks pertama
     * @param b Matriks kedua
     * @return Hasil penjumlahan matriks
     */
    public static int[][] addMatrices(int[][] a, int[][] b) {
        // Validasi ukuran matriks
        if (a.length != b.length || a[0].length != b[0].length) {
            System.out.println("Error: Ukuran matrix tidak sama!");
            return null;
        }
        
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];
        
        // Melakukan penjumlahan elemen per elemen
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }
    
    /**
     * Method untuk perkalian dua matriks
     * @param a Matriks pertama
     * @param b Matriks kedua
     * @return Hasil perkalian matriks
     */
    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        // Validasi ukuran matriks
        if (a[0].length != b.length) {
            System.out.println("Error: Jumlah kolom matrix R harus sama dengan baris matrix B!");
            return null;
        }
        
        int rowsA = a.length;
        int colsA = a[0].length;
        int colsB = b[0].length;
        int[][] result = new int[rowsA][colsB];
        
        // Melakukan perkalian matriks
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }
    
    /**
     * Method untuk melakukan transpos matriks
     * @param matrix Matriks yang akan ditranspos
     * @return Matriks hasil transpos
     */
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        
        // Melakukan transpos matriks
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
    
    /**
     * Method untuk mencetak matriks ke layar
     * @param matrix Matriks yang akan dicetak
     */
    public static void printMatrix(int[][] matrix) {
        // Jika matriks null (misal karena error validasi), tidak dicetak
        if (matrix == null) return;
        
        // Mencetak matriks baris per baris
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
