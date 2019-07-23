package realworld;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Let's assume you have a column of strings in a database which contains no duplicates,
 * except those which differ in terms of case-sensitivity. For example, `Test` and `TEst` are considered
 * different, non-duplicate strings.
 * Now, you need to introduce case-insensitivity on that column. Meaning that previously non-duplicate strings may
 * become duplicates. Thus, you need to distinguish them and one of approaches suggested by management was to add
 * consequent numbers to strings, which turn out to have case-insensitive duplicate.
 * For example, having Test and TEst, we need to make TEst -> TEst2 to not be a case-insensitive duplicate of Test.
 * Write a function, which performs such migration, considering also that after adding numbers there may be another
 * case-insensitive duplicate with number. For example, TEst2 may be already present in initial column.
 */
public class CaseSensitiveMigration {
    private List<String> input;
    private List<String> output;

    public CaseSensitiveMigration(List<String> input) {
        this.input = input;
    }

    public void migrate() {
        Map<String, Integer> groups = new HashMap<>();
        boolean[] isChanged = new boolean[input.size()];
        String lower;
        output = new LinkedList<>();
        for (int i = 0; i < input.size(); i++) {
            String str = input.get(i);
            lower = str.toLowerCase();
            if (!groups.containsKey(lower)) {
                groups.put(lower, 1);
                output.add(str);
            } else {
                int count = groups.get(lower);
                groups.put(lower, count + 1);
                output.add(str + (count + 1));
                isChanged[i] = true;
            }
        }
        boolean isSameExists;
        do {
            Map<String, List<Integer>> counter = new HashMap<>();
            isSameExists = false;
            for (int i = 0; i < output.size(); i++) {
                String str = output.get(i).toLowerCase();
                if (!counter.containsKey(str)) {
                    List<Integer> list = new LinkedList<>();
                    list.add(i);
                    counter.put(str, list);
                } else {
                    isSameExists = true;
                    counter.get(str).add(i);
                }
            }
            if (isSameExists) {
                for (Map.Entry<String, List<Integer>> entry : counter.entrySet()) {
                    if (entry.getValue().size() > 1) {
                        int additionalCounter;
                        for (int index : entry.getValue()) {
                            if (isChanged[index]) {
                                String lowerCaseInput = input.get(index).toLowerCase();
                                additionalCounter = groups.get(lowerCaseInput);
                                output.set(index, input.get(index) + (additionalCounter + 1));
                                groups.put(lowerCaseInput, additionalCounter + 1);
                            }
                        }
                    }
                }
            }
        } while (isSameExists);
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("Test", "test", "tEst", "TesT", "test4", "test2");
        CaseSensitiveMigration migration = new CaseSensitiveMigration(input);
        migration.migrate();
        migration.printOutput();
    }

    private void printOutput() {
        for (int i = 0; i < output.size(); i++) {
            String s = input.get(i) + " -> " + output.get(i);
            System.out.println(s);
        }
    }
}
