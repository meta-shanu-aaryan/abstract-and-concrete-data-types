import java.util.InputMismatchException;
import java.util.Scanner;

final class IntSet {
    private boolean[] set;

    // Constructors for initiating objects
    public IntSet(int[] arr) {
        try {
            set = new boolean[1001];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 1000 || arr[i] < 1) {
                    throw new AssertionError("The element should be between 1-1000");
                }

                set[arr[i]] = true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public IntSet() {
        this.set = new boolean[1001];
    }

    // getter
    public boolean[] getSet() {
        return this.set;
    }

    // Prints the set
    public void printSet() {
        for (int i = 1; i < 1001; i++) {
            if (set[i]) {
                System.out.print(i + ", ");
            }
        }
    }

    /**
     * Checks if x is in the set
     * 
     * @param x the number we want to check
     * @return true is x is in set else false
     */
    public boolean isMember(int x) {
        try {

            return set[x];
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Calculates the size of set
     * 
     * @return the size of the set
     */
    public int size() {
        try {
            int count = 0;

            for (boolean member : set) {
                if (member) {
                    count++;
                }
            }

            return count;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    /**
     * Checks if a set is subset of a set
     * 
     * @param s The set for which you
     * @return
     */
    public boolean isSubSet(IntSet s) {
        try {
            for (int i = 1; i < 1001; i++) {
                if (s.set[i] && !this.set[i]) {
                    return false;
                }
            }

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Gets the complement of the set
     * 
     * @return Set object containin the complement of the set
     */
    public IntSet getComplement() {
        try {
            IntSet complement = new IntSet();

            for (int i = 1; i < 1001; i++) {
                complement.set[i] = !this.set[i];
            }

            return complement;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new IntSet();
        }
    }

    /**
     * Gives union of two sets
     * 
     * @param s The second set as argument
     * @return Set object having union of two sets
     */
    public IntSet union(IntSet s) {
        try {
            IntSet un = new IntSet();

            for (int i = 1; i < 1001; i++) {
                if (s.set[i] || this.set[i]) {
                    un.set[i] = true;
                }
            }

            return un;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new IntSet();
        }
    }

    /**
     * Gives intersection of two sets
     * 
     * @param s The second set as argument
     * @return Set object having intersection of two sets
     */
    public IntSet intersection(IntSet s) {
        try {
            IntSet insec = new IntSet();

            for (int i = 1; i < 1001; i++) {
                if (s.set[i] && this.set[i]) {
                    insec.set[i] = true;
                }
            }

            return insec;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new IntSet();
        }
    }

    /**
     * Gives difference of two sets
     * 
     * @param s The second set as argument
     * @return Set object having difference of two sets
     */
    public IntSet difference(IntSet s) {
        try {
            IntSet diff = this;

            for (int i = 1; i < 1001; i++) {
                if (s.set[i] && this.set[i]) {
                    diff.set[i] = false;
                }
            }

            return diff;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new IntSet();
        }
    }

}

public class SetOperation {
    public int intScanner() {
        int n;
        while (true) {
            Scanner sc = new Scanner(System.in);
            try {
                n = sc.nextInt();
                if (n >= 0) {
                    break;
                } else {
                    System.out.println("Only positive values should be there");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Enter integer value only");
                continue;
            }
        }
        // sc.close();
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SetOperation so = new SetOperation();

        try {
            IntSet s1;
            IntSet s2;
            System.out.println("Set Operations");

            System.out.print("Enter the number of elements ");
            int size = so.intScanner();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                System.out.print("Element " + (i + 1) + " ");
                arr[i] = so.intScanner();
            }

            s1 = new IntSet(arr);
            while (true) {

                System.out.println("For Performing Operations select...");
                System.out.println("1.\tcheck Member");
                System.out.println("2.\tfind complement");
                System.out.println("3.\tcheck Subset");
                System.out.println("4.\tfind Difference");
                System.out.println("5.\tfind intersection");
                System.out.println("6.\tfind union");

                int choice = so.intScanner();

                switch (choice) {
                    case 1:
                        System.out.print("Enter the member you want to find ");
                        int num = so.intScanner();
                        if (s1.isMember(num)) {
                            System.out.println("It is in the set");
                        } else {
                            System.out.println("It is not in the set");
                        }
                        break;
                    case 2:
                        s2 = s1.getComplement();
                        s2.printSet();
                        break;
                    case 3:
                        System.out.print("Enter the size of second set ");
                        int size2 = so.intScanner();
                        int[] arr2 = new int[size2];
                        for (int i = 0; i < size2; i++) {
                            System.out.print("Element " + (i + 1) + " ");
                            arr2[i] = so.intScanner();
                        }
                        s2 = new IntSet(arr2);
                        if (s1.isSubSet(s2)) {
                            System.out.println("It is subset");
                        } else {
                            System.out.println("Not a subset");
                        }
                        break;
                    case 4:
                        System.out.print("Enter the size of second set ");
                        size2 = so.intScanner();
                        arr2 = new int[size2];
                        for (int i = 0; i < size2; i++) {
                            System.out.print("Element " + (i + 1) + " ");
                            arr2[i] = so.intScanner();
                        }
                        s2 = new IntSet(arr2);
                        IntSet s3 = s1.difference(s2);
                        System.out.println("Difference set is...");
                        s3.printSet();
                        break;
                    case 5:
                        System.out.print("Enter the size of second set ");
                        size2 = so.intScanner();
                        arr2 = new int[size2];
                        for (int i = 0; i < size2; i++) {
                            System.out.print("Element " + (i + 1) + " ");
                            arr2[i] = so.intScanner();
                        }
                        s2 = new IntSet(arr2);
                        s3 = s1.intersection(s2);
                        System.out.println("Intersection set is...");
                        s3.printSet();
                        break;
                    case 6:
                        System.out.print("Enter the size of second set ");
                        size2 = so.intScanner();
                        arr2 = new int[size2];
                        for (int i = 0; i < size2; i++) {
                            System.out.print("Element " + (i + 1) + " ");
                            arr2[i] = so.intScanner();
                        }
                        s2 = new IntSet(arr2);
                        s3 = s1.union(s2);
                        System.out.println("Union set is...");
                        s3.printSet();
                        break;

                    default:
                        break;

                }
                System.out.print("press 1 to continue --- ");
                int contin = so.intScanner();
                if (contin != 1) {
                    break;
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Enter the numeric value only");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
