package quicksort;
import java.util.Arrays;
import java.lang.Math;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class QuickSort<T extends Comparable<T>>
{
    void swap(T[] list, int a, int b)
    {
        T temp = list[a];
        list[a]  = list[b];
        list[b]  = temp;
    }

    int
    partition(T[] list, int left, int right, int pivotidx)
    {
        T pivot = list[pivotidx];
        swap(list, right, pivotidx);

        for (int i = left; i < right; i++) {
            if (list[i].compareTo(pivot) < 0) {
                swap(list, i, left);
                left++;
            }
        }

        swap(list, left, right);
        return left;
    }

    private void _quickSort(T[] list, int left, int right)
    {
        if (right > left) {
            int pivotidx = (int)(Math.random() * (right - left + 1)) + left;
            pivotidx = partition( list, left, right, pivotidx );
            _quickSort( list, left, pivotidx );
            _quickSort( list, pivotidx+1, right );
        }
    }

    public T[] quickSort(T[] list)
    {
        _quickSort( list, 0, list.length-1 );
        return list;
    }

    public static void main(String[] args)
    {
        if (args.length == 2) {
            try {
                BufferedReader file = new BufferedReader(new FileReader( args[0] ));
                Integer length = Integer.parseInt(args[1]);
                Integer[] list = new Integer[length];

                for(int i = 0; i < length; i++)
                    list[i] = Integer.parseInt(file.readLine());

                QuickSort<Integer> ms = new QuickSort<Integer>();
                Integer[] sortedList = ms.quickSort(list);
                System.out.println(Arrays.toString( sortedList ));
            }
            catch (FileNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
            catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        else {
            System.out.println("Usage: ./program [list file] [list length]");
        }
    }
}
