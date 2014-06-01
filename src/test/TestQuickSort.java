import quicksort.QuickSort;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestQuickSort extends junit.framework.TestCase {

    private QuickSort<Integer> ms;
    
    @BeforeClass
    public void setUp() {
        ms = new QuickSort<Integer>();
    }
    
    public void testQuickSort() {
        Integer[] list     = new Integer[] {7, 2, 1, 5, 77, 23, 12};
        Integer[] expected = new Integer[] {1, 2, 5, 7, 12, 23, 77};
        
        assertArrayEquals(expected, ms.quickSort( list ));
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestQuickSort.class);
            for (Failure failure : result.getFailures()) {
                  System.out.println(failure.toString());
        }
    }
}
