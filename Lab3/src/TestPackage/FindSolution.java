package TestPackage;

public class FindSolution {
    public static void main(String[] args) {
        int[][] array = new int[8][8];

        int counter = 0;

        for(int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                array[i][j] = counter++;
            }
        }

        printArray(array);

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

    int[] findSolution(){
        return null;
    }
}
