import java.util.*;

public class Solution {
    static int[] array;
    
    static double mean() {
        int sum = 0;
        
        for(int i : array) {
            sum += i;
        }
        
        return (double) sum / array.length;
    }
    
    static double median() {
        int halfN = array.length / 2;
        
        if( (array.length & 1) == 1 ) { // if odd
            return array[halfN];
        }
        // else, average middle 2 elements
        return (array[halfN] + array[halfN - 1]) / 2.0;
    }
    
    static int mode() {
        // map frequency to smallest number having that frequency (we are not concerned with larger numbers having same frequency)
        HashMap<Integer, Integer> occurrences = new LinkedHashMap<Integer, Integer>();
        for(int i = 1; i <= array.length; i++) { 
            int current = array[i - 1];
            int count = 1;
            for(int j = i; j < array.length; j++) { 
                if(current == array[j]) {
                    count++;
                }
            }
            // if our map doesn't contain any value for this frequency
            if(occurrences.get(count) == null) {
                occurrences.put(count, current);
            }
        }
        
        // find minimum number that occurs a maximum number of times in array
        return occurrences.get( Collections.max(occurrences.keySet(), null) );
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        array = new int[scan.nextInt()];
        
        for(int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }
        scan.close();
        Arrays.sort(array);
        
        System.out.println(mean());
        System.out.println(median());
        System.out.println(mode());
    }
}