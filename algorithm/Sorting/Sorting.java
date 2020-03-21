import java.util.*;

public class Sorting {
    public static void SelectionSort(int[] a) {
        int flag;
        int index;
        for (int i = 0; i < a.length-1; ++i) {
            flag = a[i];
            index = i;
            for (int k = i+1; k < a.length; ++k) {
                if (a[k] < flag) {
                    flag = a[k];
                    index = k;
                }
            }
            if (index != i) {
                flag = a[i];
                a[i] = a[index];
                a[index] = flag;
            }
        }
    }

    public static void BubbleSort(int[] a) {
        int tmp = -1;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int j = 0; j < a.length-1; ++j) {
                if (a[j] > a[j+1]) {
                    flag = true;
                    tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
    }

    public static void InsertionSort(int[] a) {
        int tmp = -1;
        int j;
        for (int i = 1; i < a.length; ++i) {
            tmp = a[i];
            for (j = i-1; j >= 0; --j) {
                if (a[j] <= tmp) {
                    break;
                } else {
                    a[j+1] = a[j];
                }
            }
            a[j+1] = tmp;
        }
    }

    public static void ShellSort(int[] a) {
        int tmp = -1;
        for (int n = (a.length+1)/2; n >= 1; n = n/2) {
            for (int k = 0; k < n; ++k) {
                for (int i = k+n; i < a.length; i += n) {
                    int j = 0;
                    tmp = a[i];
                    for (j = i-n; j >= k; j -= n) {
                        if (a[j] <= tmp) {
                            break;
                        } else {
                            a[j+n] = a[j];
                        }
                    }
                    a[j+n] = tmp;
                }
            }
        }
    }

    public static void MergeSort(int[] a) {
        int[] b = new int[a.length];
        merge(a, b, 0, a.length-1);
    }

    private static void merge(int[] a, int[] b, int l, int r) {
        // both l and r are closured
        if (l >= r) return;
        int m = (l+r)/2;
        int i = l;
        int j = m+1;
        int k = l;
        merge(a, b, l, m);
        merge(a, b, m+1, r);
        while (i <= m && j <= r) {
            if (a[i] < a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
            }
        }
        if (i <= m) {
            for (; i <= m;) b[k++] = a[i++];
        } else {
            for (; j <= r;) b[k++] = a[j++];
        }
        for (i = l; i <= r; ++i) {
            a[i] = b[i];
        }
    }

    public static void MergeSort2(int[] a) {
        int[] b = new int[a.length];
        int k = 1;
        for (; k < a.length; k = k*2) {
            for (int n = 0; n < a.length; n += k*2) {
                int lm = Math.min(a.length, n+k);
                int rm = Math.min(a.length, n+k*2);
                int i = n, j = lm;
                int p = n;
                while (i < lm && j < rm) {
                    if (a[i] < a[j]) {
                        b[p++] = a[i++];
                    } else {
                        b[p++] = a[j++];
                    }
                }
                if (i < lm) {
                    for (; i < lm;) b[p++] = a[i++];
                } else {
                    for (; j < rm;) b[p++] = a[j++];
                }
                for (i = n; i < rm; ++i) a[i] = b[i];
            }
        }
    }

    public static void QuickSort(int[] a) {
        quick(a, 0, a.length-1);
    }

    private static void quick(int[] a, int l, int r) {
        if (l >= r) return;
        int m = (l+r)/2;
        int pivot = a[m];
        a[m] = a[r];
        a[r] = pivot;
        int tmp = -1;
        int i = l, j = r-1;
        while (i <= j) {
            while (a[i] <= pivot && i < r) {
                i++;
            }
            while (a[j] >= pivot && j >= l) {
                j--;
            }
            if (j >= l && i < r && i < j) {
                tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        a[r] = a[i];
        a[i] = pivot;
        quick(a, l, i-1);
        quick(a, i+1, r);
    }

    public static void HeapSort(int[] a) {
        // build a big heap
        int tmp = -1;
        for (int i = a.length/2; i >= 0; --i) {
            if (2*i+1 < a.length && a[i] < a[i*2+1]) {
                tmp = a[i];
                a[i] = a[i*2+1];
                a[i*2+1] = tmp;
            }
            if (2*i+2 < a.length && a[i] < a[i*2+2]) {
                tmp = a[i];
                a[i] = a[i*2+2];
                a[i*2+2] = tmp;
            }
        }
        // deheap the max value for n-1 times
        for (int i = a.length-1; i >= 1; --i) {
            tmp = a[i];
            a[i] = a[0];
            a[0] = tmp;
            for (int j = (i-1)/2; j >= 0; j--) {
                if (2*j+1 < i && a[j] < a[j*2+1]) {
                    tmp = a[j];
                    a[j] = a[j*2+1];
                    a[j*2+1] = tmp;
                }
                if (2*j+2 < i && a[j] < a[j*2+2]) {
                    tmp = a[j];
                    a[j] = a[j*2+2];
                    a[j*2+2] = tmp;
                }
            }
        }
    }

    public static void CountingSort(int[] a) {
        int[] target = new int[a.length];
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] < minVal) {
                minVal = a[i];
            }
            if (a[i] > maxVal) {
                maxVal = a[i];
            }
        }
        int n = maxVal - minVal + 1;
        int[] counting = new int[n];
        for (int i = 0; i < a.length; ++i) {
            counting[a[i] - minVal] += 1;
        }
        for (int i = 1; i < counting.length; ++i) {
            counting[i] = counting[i] + counting[i-1];
        }
        for (int i = a.length-1; i >= 0; --i) {
            target[--counting[a[i]-minVal]] = a[i];
        }
        for (int i = 0; i < a.length; ++i) {
            a[i] = target[i];
        }
    }

    public static void BucketSort(int[] a) {
        int aMax = Integer.MIN_VALUE;
        int aMin = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; ++i) {
            if (aMax < a[i]) aMax = a[i];
            if (aMin > a[i]) aMin = a[i];
        }
        int n = (aMax-aMin+1+5)/10;
        List<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; ++i) {
            buckets[i] = new ArrayList<>();
        }
        for (int i = 0; i < a.length; ++i) {
            List<Integer> t = buckets[(a[i]-aMin)/n];
            int k = 0;
            for (k = t.size()-1; k >= 0 && t.get(k) >= a[i]; --k);
            t.add(k+1, a[i]);
        }
        // System.out.println(Arrays.toString(buckets));
        int k = 0;
        for (int i = 0; i < buckets.length; ++i) {
            for (Integer e : buckets[i]) {
                a[k++] = e;
            }
        }
    }

    public static void RadixSort(int[] a) {
        int aMax = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] > aMax) {
                aMax = a[i];
            }
        }
        List<Integer>[] buckets = new ArrayList[10];
        int n = 1;
        for (int i = 0; i < buckets.length; ++i) {
            buckets[i] = new ArrayList<>();
        }
        while (true) {
            for (int i = 0; i < a.length; ++i) {
                int index = (a[i]/n)%10;
                buckets[index].add(a[i]);
            }
            int k = 0;
            for (List<Integer> t : buckets) {
                for (Integer e : t) {
                    a[k++] = e;
                }
            }

            if (buckets[0].size() == a.length) break;
            n = n*10;
            for (List<Integer> t : buckets) {
                t.clear();
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {
            111,  865,  124,   16,  699,  621,  617,  317,   20,  311,   35, 
            626,  453,  978,  784,  514,   44,  587,  292,  821,  159,   51,
            487,  803,  143,  325,  260,   47,  905,  917,  707,  776,  541,
             96,  857,  524,  850,  941,  433,  428,  742,  799,  285,   43,
            701,  961,  116,  537,  947,   24,  531,  232,  792,  402,  718,
            797,  923,  248,  189, 1000,  413,  619,  543,  279,  924,  958,
            922,  212,  229,  797,  924,  602,  232,  456,  863,  475,  798,
            284,  941,  499,  497,  798,  900,   43,  879,  993,  500,  304,
            715,  501,  217,  151,  667,  561,  441,  278,  245,  986,  850,
            836};
        int[] to = a.clone();
        Arrays.sort(to);
        // System.out.println(Arrays.toString(to));
        int[] b = a.clone();
        int[] c = a.clone();
        int[] d = a.clone();
        int[] e = a.clone();
        int[] f = a.clone();
        int[] g = a.clone();
        int[] h = a.clone();
        int[] i = a.clone();
        int[] j = a.clone();
        SelectionSort(a);
        System.out.println("SelectionSort is "+Arrays.equals(a, to));
        BubbleSort(b);
        System.out.println("BubbleSort is "+Arrays.equals(b, to));
        InsertionSort(c);
        System.out.println("InsertionSort is "+Arrays.equals(c, to));
        // d = new int[] {12, 11, 10, 9, 8};
        ShellSort(d);
        System.out.println("ShellSort is "+Arrays.equals(d, to));
        MergeSort2(e);
        System.out.println("MergeSort is "+Arrays.equals(e, to));
        QuickSort(f);
        System.out.println("QuickSort is "+Arrays.equals(f, to));
        CountingSort(g);
        System.out.println("CountingSort is "+Arrays.equals(g, to));
        BucketSort(h);
        System.out.println("BucketSort is "+Arrays.equals(h, to));
        RadixSort(i);
        System.out.println("RadixSort is "+Arrays.equals(i, to));
        HeapSort(j);
        System.out.println("HeapSort is "+Arrays.equals(j, to));
    }
}