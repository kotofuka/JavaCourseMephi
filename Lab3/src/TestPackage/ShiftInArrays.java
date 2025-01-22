package TestPackage;

public class ShiftInArrays {
    public static void main(String[] args) {
        int[][] array = new int[8][8];

        int counter = 0;

        for(int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                array[i][j] = counter++;
            }
        }

        printArray(array);

        //shiftArrayOnRight(new int[]{2, 3, 3, 2}, array);

        shiftArrayOnDown(new int[]{3, 1, 5, 1}, array);
    }

    public static void printArray(int[][] array){
        for (var list: array){
            for(var elem: list){
                System.out.print(elem + "\t");
            }
            System.out.println();
        }
        System.out.println("=========================================");
    }

    public static void shiftArrayOnRight(int[] info, int[][] array){ // info = {i, j, count_cells, direction}, where direction = 2 symbolize: choose "right"
        //int i = info[0], j = info[1], count_cells = info[2], direction = info[3];

        // shift on base situation
        for (int i = info[0]; i > 0; i--) {
            for (int j = info[1]; j < info[1] + info[2]; j++){
                array[i][j] = array[i - 1][j];
            }
        }

        // randomize new element line
        int k = -1;
        for(int j = info[1]; j < info[1] + info[2]; j++){
            array[0][j] = k--;
        }

        printArray(array);
    }

    public static void shiftArrayOnDown(int[] info, int[][] array) { // info = {i, j, count_cells, direction}, where direction = 2 symbolize: choose "down"
        //int i = info[0], j = info[1], count_cells = info[2], direction = info[3];

        int prev = info[0] - 1, temp = prev + info[2];

        // shift on base situation
        while (prev >= 0){
            array[temp][info[1]] = array[prev][info[1]];
            prev--;
            temp--;
        }

        // randomize new element column
        int k = -1;
        while (temp >= 0){
            array[temp][info[1]] = k;
            k--;
            temp--;
        }

        // 1 -> 3

        printArray(array);
    }

}
