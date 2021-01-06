import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class StreamMain {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4));

        list.stream()
            .filter(a -> a > 0)
            .filter(a -> a % 2 == 0)
            .sorted(Comparator.naturalOrder())
            .forEach(System.out::println);
    }
}