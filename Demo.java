import java.util.Random;


public class Demo {

  public static void main(String[]args) {
    int param = 5;
    if (args.length != 0) param = Integer.parseInt(args[0]);
    printLoop(param);

  //  System.out.println(generateTests());
  }

  public static boolean generateTests() {
    Random rng = new Random();
    for (int i = 0; i < 100; i++) {
      int rows = Math.abs(rng.nextInt(101));
      int cols = Math.abs(rng.nextInt(101));
      int maxValue = Math.abs(rng.nextInt());

      int[][] test = create2DArrayRandomized(rows, cols, maxValue);
      if (!test2DArrayCreation(rows, cols, maxValue, test)) return false;
    }

    return true;
  }

  public static boolean test2DArrayCreation(int rows, int cols, int maxValue, int[][] arr) {
    if (arr.length != rows) return false;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].length > cols) return false;
      for (int j = 0; j < arr[i].length; j++) {
        if ((arr[i][j] > maxValue) || (arr[i][j] < 0)) return false;
      }
    }

    return true;
  }

  public static void printLoop(int max) {
    for (int i = 1; i <= max; i++) {
      for (int j = 0; j < (max - i + 1); j++)
        System.out.print(i);
      System.out.println();
    }
  }

  public static String arrToString(int[] arr) {
    String array = "{";
    for (int i = 0; i < arr.length; i++) {
      array += String.valueOf(arr[i]);
      if (i != arr.length - 1) array += ", ";
    }

    return (array += "}");
  }

  public static String arrayDeepToString(int[][] arr) {
    String fullString = "{";

    for (int i = 0; i < arr.length; i++) {
      int[] row = new int[arr[i].length];
      int count = 0;
      for (int j = 0; j < arr[i].length; j++) {
        row[count] = arr[i][j];
        count++;
      }

      if (i == arr.length - 1) fullString += arrToString(row) + "}";
      else fullString += arrToString(row) + ", ";
    }

    return fullString;
  }

  public static int[][] create2DArray(int rows, int cols, int maxValue) {
    int[][] toReturn = new int[rows][cols];
    Random rng = new Random();

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        toReturn[i][j] = rng.nextInt(maxValue + 1);
      }
    }

    return toReturn;
  }

  public static int[][] create2DArrayRandomized(int rows, int cols, int maxValue) {
    Random rng = new Random();
    int[][] toReturn = new int[rows][];

    for (int i = 0; i < rows; i++) {
      toReturn[i] = new int[rng.nextInt(cols + 1)];
      for (int j = 0; j < toReturn[i].length; j++) {
        toReturn[i][j] = rng.nextInt(maxValue + 1);
      }
    }

    return toReturn;
  }

}
