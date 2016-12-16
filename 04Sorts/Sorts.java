public class Sorts {

    public static void main(String[] args) {
        int[] test = {1,3,5,2,4,7,9,8,23,56,4,8,76,4,345,3,65,42,54,78,19};
        int[] testT = {20,19,18,17,15,14,13,13,12,12,12,10,8,7,6,5,3,2,1,0,-3,-5};
        bubbleSort(testT);
        printArray(testT);
        bubbleSort(test);
        printArray(test);
    }

    public static String name() {
        return "06.Shin.Nicole";
    }

    public static void printArray(int[] ary) {
        for (int i = 0; i< ary.length; i++) {
            System.out.print(ary[i] + ", ");
        }
        System.out.println();
    }

    public static void selectionSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int currentMin = i;
            int currentVal = data[i];
            for (int a = i+1; a < data.length; a++) {
                if (data[a] < data[currentMin]) {
                    currentMin = a;
                }
            }
            data[i] = data[currentMin];
            data[currentMin] = currentVal;
        }
    }

    public static void insertionSort(int[] data) {
        for (int lastIndex = 1; lastIndex < data.length; lastIndex++) {
            for (int firstIndex = lastIndex-1; firstIndex > -1; firstIndex-=1) {
                if (data[lastIndex] <= data[firstIndex] && firstIndex ==0) {
                    insert(data, firstIndex, lastIndex);
                } else if (data[lastIndex] > data[firstIndex]) {
                    insert(data, firstIndex+1, lastIndex);
                    break;
                }
            }
        }
    }

    private static void insert(int[] data, int firstIndex, int lastIndex) {
        int val = data[lastIndex];
        for (int i = lastIndex; i > firstIndex; i-=1) {
            data[i] = data[i-1];
        }
        data[firstIndex] = val;
    }

    public static void bubbleSort(int[] data) {
        boolean inOrder = true;
        int numLoops = data.length-1;
        while (true) {
            for (int index = 0; index < numLoops; index++) {
                if (data[index] > data[index+1]) {
                    inOrder = false;
                    int tempVal = data[index];
                    data[index] = data[index+1];
                    data[index+1] = tempVal;
                }
            }
            if (inOrder) break;
            numLoops -= 1;
            inOrder = true;
        }
    }
}
