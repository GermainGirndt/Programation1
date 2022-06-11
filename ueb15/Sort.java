
/**
 * Beschreiben Sie hier die Klasse Sort.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class Sort
{
    public static void bubbleSort(float[] arr) {  
        int n = arr.length;  
        float temp = 0;  
        for (int i=0; i < n; i++) {  
            for (int j=1; j < (n-i); j++) {  
                if (arr[j-1] > arr[j]) {  
                    temp = arr[j-1];  
                    arr[j-1] = arr[j];  
                    arr[j] = temp;
                }     
            }  
         } 
    
    }
}
