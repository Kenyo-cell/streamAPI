

public class Main {
    public static void main(String[] args) {
        int[] list = { 1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4 };
        int[] filtered = new int[5];
        int counter = 0;
        for (int el : list) {
            if (el > 0 && el % 2 == 0) {
                filtered[counter++] = el;
            }
        }

        for (int i = 0; i < filtered.length - 1; i++) {
            for (int j = i + 1; j < filtered.length; j++) {
                if (filtered[i] > filtered[j]) {
                    int swap = filtered[j];
                    filtered[j] = filtered[i];
                    filtered[i] = swap;
                }
            }
        }

        for (int el : filtered) {
            System.out.println(el);
        }
    }
}