public class Main {
    static void bubbleSort(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
            if (arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                swapped = true;
            }
        }
        if (swapped == false)
        {
            break;
        }
        }
    }
    public static void main(String[] args){
        System.out.println("Hello, World!");
        int[] array = {12, 6, 8, 3, 9, 21, 17, 22, 66, 43, 1};
        bubbleSort(array);
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
            sum += array[i];
        }
        System.out.println();
        int average = sum / array.length;
        System.out.println(sum);
        System.out.println(average);
    }
}
