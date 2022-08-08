import java.util.Random;

public class testing {
    public static void main(String[] args){
        Random rand = new Random();

        int[] array = new int[10];
        int[][] matrix = new int[10][10];

        for(int i=0;i<array.length;i++){
            array[i] = rand.nextInt(100);
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                matrix[i][j] = rand.nextInt(100);
            }
        }

        displayArray(array);
        bubbleSort(array);
        quickSort(array,0,array.length-1);
        displayArray(array);
        maxElem(array);
        minElem(array);
        removeElements(array);

        displayMatrix(matrix);
        maxElem(matrix);
        minElem(matrix);
        displayDiagPrinc(matrix);
        displayDiagSecund(matrix);
    }

    private static void displayArray(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }

    private static void bubbleSort(int[] array){
        boolean swapped = true;

        while(swapped){
            swapped = false;
            for(int i=0;i<array.length-1;i++){
                if(array[i] > array[i+1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    swapped = true;
                }
            }
        }

        displayArray(array);
    }

    private static void quickSort(int[] array,int lowIndex, int highIndex){

        if(lowIndex>highIndex){
            return;
        }
        int leftPointer = lowIndex;
        int rightPointer = highIndex;


        int pivot = array[highIndex];

        while(leftPointer < rightPointer){
            while(leftPointer < rightPointer && array[leftPointer] <= pivot){
                leftPointer++;
            }

            while(leftPointer < rightPointer && array[rightPointer] >= pivot){
                rightPointer--;
            }

            swap(array,leftPointer,rightPointer);
        }

        swap(array,leftPointer,highIndex);
        quickSort(array,lowIndex,leftPointer-1);
        quickSort(array,leftPointer+1,highIndex);
    }

    private static void swap(int[] array,int leftPointer,int rightPointer){
        int aux = array[leftPointer];
        array[leftPointer] = array[rightPointer];
        array[rightPointer] = aux;
    }

    private static void maxElem(int[] array){
        int max = -1;
        for(int i=0;i<array.length;i++){
            if(array[i] > max){
                max = array[i];
            }
        }

        System.out.println(max);
    }

    private static void maxElem(int[][] matrix){
        int max = -1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] > max){
                    max = matrix[i][j];
                }
            }
        }

        System.out.println(max);
    }

    private static void minElem(int[] array){
        int min = 101;
        for(int i=0;i<array.length;i++){
            if(array[i] < min){
                min = array[i];
            }
        }

        System.out.println(min);
    }

    private static void minElem(int[][] matrix){
        int min = 101;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                }
            }
        }

        System.out.println(min);
    }

    private static void removeElements(int[] array){
        int contor = 0;

        for(int i=0;i<array.length;i++){
            if(array[i] >= 20){
                contor++;
            }
        }

        int[] newArray = new int[contor];
        contor = 0;

        for(int i=0;i<array.length;i++){
            if(array[i] >= 20){
                newArray[contor++] = array[i];
            }
        }

        displayArray(newArray);
    }

    private static void displayMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void displayDiagPrinc(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(i == j){
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }

        System.out.println();
    }

    private static void displayDiagSecund(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(i+j == matrix.length-1){
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }
}
