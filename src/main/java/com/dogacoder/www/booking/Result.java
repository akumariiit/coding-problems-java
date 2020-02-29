import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 */


class Result {

    /*
     * Complete the 'findNumber' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER k
     */

    public static String findNumber(List<Integer> arr, int k) {

        // Write your code here

        List<Integer> filteredList = arr.stream().filter(e -> e == k).collect(Collectors.toList());
        if (filteredList.size() > 0) {
            return "YES";
        }
        return "NO";
    }

    public static List<Integer> oddNumbers(int l, int r) {

        // Write your code here
        return IntStream.rangeClosed(l, r).boxed().filter(e -> e % 2 != 0).collect(Collectors.toList());
    }
}
