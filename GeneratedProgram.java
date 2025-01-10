public class GeneratedProgram {
    public static void main(String[] args) {
            int x = 10;
            int y = 5;
        // L1:
        while (true) {
            int t1 = x - y;
            if (t1 <= 0) {
                break; // GOTO L2
            }
            x = x - 1;
            break; // GOTO L1
        }
        // L2:
        while (true) {
            int result = x;
        }
        System.out.println("Programme terminé.");
    }
}
