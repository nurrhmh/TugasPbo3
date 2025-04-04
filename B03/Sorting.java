package B03;
import java.util.Arrays;
import java.util.Scanner;

public class Sorting {
    public static int jmlData;
    public static Scanner masukan = new Scanner(System.in);
    public static int[] arrayKu;
    public static int[] arrayOriginal; // Untuk menyimpan array asli

    public static void main(String[] args) {
        System.out.println("");
        System.out.println("-----------------------------");
        System.out.println("> Program sorting Array");
        System.out.println("-----------------------------");
        System.out.println("");

        System.out.println("Ingin input berapa Data?");
        System.out.print("Answer : ");
        jmlData = masukan.nextInt();
        arrayKu = new int[jmlData];
        arrayOriginal = new int[jmlData];

        // Input data Array
        System.out.println("-----------------------------");
        System.out.println("Input data Array");
        System.out.println("-----------------------------");

        for (int i = 0; i < jmlData; i++) {
            System.out.print("Input data ke-" + (i + 1) + " : ");
            arrayKu[i] = masukan.nextInt();
        }
        
        // Simpan array original
        System.arraycopy(arrayKu, 0, arrayOriginal, 0, jmlData);
        
        System.out.println("-----------------------------");
        System.out.println("");

        // Menu sorting
        int pilihan;
        do {
            System.out.println("\nPilih metode sorting:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Quick Sort");
            System.out.println("3. Insertion Sort");
            System.out.println("4. Selection Sort");
            System.out.println("5. Merge Sort");
            System.out.println("0. Keluar");
            System.out.print("Pilihan Anda: ");
            pilihan = masukan.nextInt();

            // Reset array ke kondisi awal sebelum sorting baru
            System.arraycopy(arrayOriginal, 0, arrayKu, 0, jmlData);

            switch (pilihan) {
                case 1:
                    System.out.println("\n=== Bubble Sort ===");
                    bubbleSort();
                    break;
                case 2:
                    System.out.println("\n=== Quick Sort ===");
                    quickSort(0, jmlData - 1);
                    break;
                case 3:
                    System.out.println("\n=== Insertion Sort ===");
                    insertionSort();
                    break;
                case 4:
                    System.out.println("\n=== Selection Sort ===");
                    selectionSort();
                    break;
                case 5:
                    System.out.println("\n=== Merge Sort ===");
                    mergeSort(0, jmlData - 1);
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }

    // Bubble Sort
    public static void bubbleSort() {
        System.out.println("Array awal: " + Arrays.toString(arrayKu));
        for (int i = 0; i < jmlData - 1; i++) {
            for (int j = 0; j < jmlData - i - 1; j++) {
                if (arrayKu[j] > arrayKu[j + 1]) {
                    // Tukar elemen
                    int temp = arrayKu[j];
                    arrayKu[j] = arrayKu[j + 1];
                    arrayKu[j + 1] = temp;
                    
                    // Cetak perubahan
                    System.out.println("Iterasi " + (i + 1) + ", Tukar " + arrayKu[j] + " dan " + arrayKu[j + 1] + 
                                     ": " + Arrays.toString(arrayKu));
                }
            }
        }
        System.out.println("Array setelah sorting: " + Arrays.toString(arrayKu));
    }

    // Quick Sort
    public static void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private static int partition(int low, int high) {
        int pivot = arrayKu[high];
        int i = (low - 1);
        
        System.out.println("\nPartisi dari indeks " + low + " sampai " + high + " dengan pivot " + pivot);
        System.out.println("Array sebelum partisi: " + Arrays.toString(Arrays.copyOfRange(arrayKu, low, high + 1)));

        for (int j = low; j < high; j++) {
            if (arrayKu[j] < pivot) {
                i++;
                
                // Tukar arrayKu[i] dan arrayKu[j]
                int temp = arrayKu[i];
                arrayKu[i] = arrayKu[j];
                arrayKu[j] = temp;
                
                if (i != j) {
                    System.out.println("Tukar " + arrayKu[i] + " dan " + arrayKu[j] + 
                                     ": " + Arrays.toString(arrayKu));
                }
            }
        }

        // Tukar arrayKu[i+1] dan arrayKu[high] (pivot)
        int temp = arrayKu[i + 1];
        arrayKu[i + 1] = arrayKu[high];
        arrayKu[high] = temp;
        
        System.out.println("Pivot " + pivot + " dipindahkan ke posisi " + (i + 1) + 
                         ": " + Arrays.toString(arrayKu));

        return i + 1;
    }

    // Insertion Sort
    public static void insertionSort() {
        System.out.println("Array awal: " + Arrays.toString(arrayKu));
        for (int i = 1; i < jmlData; ++i) {
            int key = arrayKu[i];
            int j = i - 1;

            System.out.println("\nMemproses elemen ke-" + (i + 1) + " (" + key + ")");

            while (j >= 0 && arrayKu[j] > key) {
                arrayKu[j + 1] = arrayKu[j];
                j = j - 1;
                
                System.out.println("Geser " + arrayKu[j + 1] + " ke kanan: " + 
                                 Arrays.toString(arrayKu));
            }
            arrayKu[j + 1] = key;
            
            System.out.println("Tempatkan " + key + " di posisi " + (j + 1) + 
                             ": " + Arrays.toString(arrayKu));
        }
        System.out.println("\nArray setelah sorting: " + Arrays.toString(arrayKu));
    }

    // Selection Sort
    public static void selectionSort() {
        System.out.println("Array awal: " + Arrays.toString(arrayKu));
        for (int i = 0; i < jmlData - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < jmlData; j++) {
                if (arrayKu[j] < arrayKu[min_idx]) {
                    min_idx = j;
                }
            }
            
            // Tukar elemen terkecil dengan elemen pertama
            int temp = arrayKu[min_idx];
            arrayKu[min_idx] = arrayKu[i];
            arrayKu[i] = temp;
            
            System.out.println("Iterasi " + (i + 1) + ": Elemen terkecil " + temp + 
                             " dipindahkan ke posisi " + i + 
                             ": " + Arrays.toString(arrayKu));
        }
        System.out.println("\nArray setelah sorting: " + Arrays.toString(arrayKu));
    }

    // Merge Sort
    public static void mergeSort(int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            
            System.out.println("\nMemecah array dari indeks " + l + " sampai " + r + 
                             " dengan titik tengah " + m);
            System.out.println("Kiri: " + Arrays.toString(Arrays.copyOfRange(arrayKu, l, m + 1)));
            System.out.println("Kanan: " + Arrays.toString(Arrays.copyOfRange(arrayKu, m + 1, r + 1)));

            mergeSort(l, m);
            mergeSort(m + 1, r);
            
            merge(l, m, r);
        }
    }

    private static void merge(int l, int m, int r) {
        System.out.println("\nMenggabungkan array dari indeks " + l + " sampai " + r);
        
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arrayKu[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arrayKu[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arrayKu[k] = L[i];
                i++;
            } else {
                arrayKu[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arrayKu[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arrayKu[k] = R[j];
            j++;
            k++;
        }
        
        System.out.println("Hasil penggabungan: " + Arrays.toString(Arrays.copyOfRange(arrayKu, l, r + 1)));
    }
}