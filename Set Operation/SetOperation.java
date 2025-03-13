import java.util.InputMismatchException;
import java.util.Scanner;

final class IntSet {
    private boolean[] set;

    // Constructors for initiating objects
    public IntSet(int[] arr) {
        set = new boolean[1001];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1000 || arr[i] < 1) {
                throw new AssertionError("The element should be between 1-1000");
            }

            set[arr[i]] = true;
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
        return set[x];
    }

    /**
     * Calculates the size of set
     * 
     * @return the size of the set
     */
    public int size() {
        int count = 0;

        for (boolean member : set) {
            if (member) {
                count++;
            }
        }

        return count;
    }

    /**
     * Checks if a set is subset of a set
     * 
     * @param s
     * @return
     */
    public boolean isSubSet(IntSet s) {

        for (int i = 1; i < 1001; i++) {
            if (s.set[i] && !this.set[i]) {
                return false;
            }
        }

        return true;
    }

    public IntSet getComplement() {
        IntSet complement = new IntSet();

        for (int i = 1; i < 1001; i++) {
            complement.set[i] = !this.set[i];
        }

        return complement;
    }

    public IntSet union(IntSet s) {
        IntSet un = new IntSet();

        for (int i = 1; i < 1001; i++) {
            if (s.set[i] || this.set[i]) {
                un.set[i] = true;
            }
        }

        return un;
    }

    public IntSet intersection(IntSet s) {
        IntSet insec = new IntSet();

        for (int i = 1; i < 1001; i++) {
            if (s.set[i] && this.set[i]) {
                insec.set[i] = true;
            }
        }

        return insec;
    }

    public IntSet difference(IntSet s) {
        IntSet diff = this;

        for (int i = 1; i < 1001; i++) {
            if (s.set[i] && this.set[i]) {
                diff.set[i] = false;
            }
        }

        return diff;
    }

}

public class SetOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            IntSet s1;
            IntSet s2;
            System.out.println("Set Operations");

            System.out.print("Enter the number of elements ");
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                System.out.print("Element " + (i + 1) + " ");
                arr[i] = sc.nextInt();
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

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter the member you want to find ");
                        int num = sc.nextInt();
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
                        int size2 = sc.nextInt();
                        int[] arr2 = new int[size2];
                        for (int i = 0; i < size2; i++) {
                            System.out.print("Element " + (i + 1) + " ");
                            arr2[i] = sc.nextInt();
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
                        size2 = sc.nextInt();
                        arr2 = new int[size2];
                        for (int i = 0; i < size2; i++) {
                            System.out.print("Element " + (i + 1) + " ");
                            arr2[i] = sc.nextInt();
                        }
                        s2 = new IntSet(arr2);
                        IntSet s3 = s1.difference(s2);
                        System.out.println("Difference set is...");
                        s3.printSet();
                        break;
                    case 5:
                        System.out.print("Enter the size of second set ");
                        size2 = sc.nextInt();
                        arr2 = new int[size2];
                        for (int i = 0; i < size2; i++) {
                            System.out.print("Element " + (i + 1) + " ");
                            arr2[i] = sc.nextInt();
                        }
                        s2 = new IntSet(arr2);
                        s3 = s1.intersection(s2);
                        System.out.println("Intersection set is...");
                        s3.printSet();
                        break;
                    case 6:
                        System.out.print("Enter the size of second set ");
                        size2 = sc.nextInt();
                        arr2 = new int[size2];
                        for (int i = 0; i < size2; i++) {
                            System.out.print("Element " + (i + 1) + " ");
                            arr2[i] = sc.nextInt();
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
                int contin = sc.nextInt();
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
