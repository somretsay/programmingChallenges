import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SameSumGroups {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);

        findGroupsSameSum(numbers);
    }

    public static void findGroupsSameSum(List<Integer> numbers) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                int sum = numbers.get(i) + numbers.get(j);

                if (sumMap.containsKey(sum)) {
                    List<Integer> group = sumMap.get(sum);
                    group.add(numbers.get(i));
                    group.add(numbers.get(j));

                    // Print the group with the same sum
                    System.out.println("Group with the same sum found: " + group);
                } else {
                    List<Integer> group = new ArrayList<>();
                    group.add(numbers.get(i));
                    group.add(numbers.get(j));
                    sumMap.put(sum, group);
                }
            }
        }
    }
}
