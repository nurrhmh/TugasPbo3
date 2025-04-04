package B01;
import java.util.Scanner;

public class Array1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] x;  // membuat Array x bertipe data int 


        System.out.println("Program Input data Array []");
        System.out.println();
        System.out.print("Jumlah Data : ");
        int total = input.nextInt();  // input data untuk menentukan limit
        x = new int[total]; // deklarasi jumlah slot utk array 
                           // Karena Array biasa perlu di tentukan slotnya dari awal. / tidak dinamis 

        // Looping untuk input data array
        for (int i = 0; i < total; i++) {
            System.out.print("Data ke - " + (i + 1) + " : " );
            x[i] = input.nextInt();  // Menyimpan input ke array
        }

        // Looping untuk cetak data array
        System.out.println();
        System.out.println("Output : ");
        for (int i = 0; i < total; i++) {
            System.out.println("Nilai x[ " + i + " ] : " + x[i]);
        }
    }
}