public class demo {

  public static void main(String[]args) {
    int param = 5;
    if (args.length != 0) param = Integer.parseInt(args[0]);
    printLoop(param);
  }

  public static void printLoop(int max) {
    for (int i = 1; i <= max; i++) {
      for (int j = 0; j < (max - i + 1); j++)
        System.out.print(i);
      System.out.println();
    }
  }

}
