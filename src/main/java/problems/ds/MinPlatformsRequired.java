package problems.ds;

import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class MinPlatformsRequired {

    public static int minPlatform(int arrival[], int departure[], int n) {

        TreeSet<Pair<Integer, Character>> platformMap = new TreeSet<>((o1, o2) -> Integer.compare(o1.getKey(), o2.getKey()));
        for (int i = 0; i < n; i++) {
            platformMap.add(Pair.of(arrival[i], 'A'));
            platformMap.add(Pair.of(departure[i], 'D'));
        }
        int requiredPlatform = 0;
        int result = 0;

        for (Pair pair : platformMap) {
            if(pair.getValue().equals('A')) {
                requiredPlatform++;
            } else {
                requiredPlatform--;
            }
            if(requiredPlatform > result) {
                result = requiredPlatform;
            }
        }
        return result;
    }

    public static int minPlatform1(int arrival[], int departure[], int n) {

        Arrays.stream(departure).forEach(num -> System.out.print(num + ","));

        int[] platform = new int[2361];
        int requiredPlatform = 1;

        for (int i = 0; i < n; i++) {
            platform[arrival[i]]++;
            platform[departure[i] + 1]--;
        }
        for (int i = 1; i < 2361; i++) {
            platform[i] = platform[i] + platform[i - 1];
            requiredPlatform = Math.max(requiredPlatform, platform[i]);
        }
        return requiredPlatform;
    }

    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};

//        System.out.println(minPlatform(arr, dep, 6));
//        Arrays.sort(dep);Arrays.sort(dep);
//        System.out.println(minPlatform1(arr, dep, 6));

        int arr1[] = {100, 300, 500, 700, 900, 1100};
        int dep1[] = {200, 400, 600, 800, 1000, 1200};

        System.out.println(minPlatform(arr1, dep1, 6));
        System.out.println(minPlatform1(arr1, dep1, 6));
    }
}
