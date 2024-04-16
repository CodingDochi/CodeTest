package pete_the_baker;

import java.util.Map;
import java.util.Set;

public class PeteBaker {
    public static int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {
        // TODO: Insert Code Here
        Set<String> need = recipe.keySet();
        Set<String> have = available.keySet();
        int max_cake = Integer.MAX_VALUE;
        for (String key : need) {
            if (!have.contains(key)) {
                return 0;
            } else {
                if (recipe.get(key) > available.get(key)) {
                    return 0;
                } else {
                    int cake = available.get(key) / recipe.get(key);
                    max_cake = Math.min(max_cake, cake);
                }
            }
        }

        return max_cake;
    }
}