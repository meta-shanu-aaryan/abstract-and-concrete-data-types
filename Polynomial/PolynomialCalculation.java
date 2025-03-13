/*
 * @author Shanu Aaryan
 * 
 * Code for Polynomial calculation
 */

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

final class Poly {
    private HashMap<Integer, Integer> coefficient;

    // Constructor to intiate object
    public Poly(int[][] arr) {
        try {
            coefficient = new HashMap<>();

            for (int i = 0; i < arr.length; i++) {
                coefficient.put(arr[i][0], arr[i][1]);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Poly() {

    }

    /**
     * Calculates degree of polynomial
     * 
     * @return degree of polynomial
     */
    public int getDegree() {
        try {
            int maxExponential = 0;

            for (Map.Entry<Integer, Integer> me : this.coefficient.entrySet()) {
                maxExponential = Math.max(maxExponential, me.getKey());
            }

            return maxExponential;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    // Prints the polynomial
    public void printPoly() {
        try {
            for (Map.Entry<Integer, Integer> me : this.coefficient.entrySet()) {
                System.out.print(me.getValue() + "x^" + me.getKey() + " + ");
            }
            System.out.println();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Evaluates the polynomial for value of variable
     * 
     * @param num float number as value
     * @return result, the calculated value
     */
    public float evaluate(float num) {
        try {
            float result = 0;
            for (Map.Entry<Integer, Integer> e : this.coefficient.entrySet()) {
                if (e.getKey() > 0) {
                    result += (Math.pow(num, e.getKey()) * e.getValue());
                } else {
                    result += (float) e.getValue();
                }
            }

            return result;

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Adds two polynomial
     * 
     * @param p1 First polynomial
     * @param p2 Second polynomial
     * @return Poly object having sum of two polynomial
     */
    static public Poly addPoly(Poly p1, Poly p2) {
        try {
            HashMap<Integer, Integer> added = new HashMap<>(p1.coefficient);

            for (Map.Entry<Integer, Integer> mp : p2.coefficient.entrySet()) {
                if (added.get(mp.getKey()) != null) {

                    added.replace(mp.getKey(), added.get(mp.getKey()) + mp.getValue());
                } else {
                    added.put(mp.getKey(), mp.getValue());
                }
            }

            Poly newPoly = new Poly();
            newPoly.coefficient = added;

            return newPoly;

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Adds two polynomial
     * 
     * @param p1 First polynomial
     * @param p2 Second polynomial
     * @return Poly object having product of two polynomial
     */
    static public Poly multiplyPoly(Poly p1, Poly p2) {
        try {

            HashMap<Integer, Integer> multiply = new HashMap<>();

            for (Map.Entry<Integer, Integer> poly1 : p1.coefficient.entrySet()) {
                for (Map.Entry<Integer, Integer> poly2 : p2.coefficient.entrySet()) {
                    if (multiply.get(poly1.getKey() + poly2.getKey()) == null) {
                        multiply.put(poly1.getKey() + poly2.getKey(), poly1.getValue() * poly2.getValue());
                    } else {
                        multiply.replace(poly1.getKey() + poly2.getKey(),
                                multiply.get(poly1.getKey() + poly2.getKey()) + (poly1.getValue() * poly2.getValue()));
                    }
                }

            }

            Poly p3 = new Poly();
            p3.coefficient = multiply;

            return p3;
        } catch (Exception e) {
            throw e;
        }
    }
}

public class PolynomialCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Poly p1;
            Poly p2;
            int arr1[][];
            int arr2[][];

            while (true) {

                System.out.println("Polynomial Calculations");
                System.out.println("Choose the operation");
                System.out.println("1.\tTo check degree of polynomial");
                System.out.println("2.\tTo evaluate polynomial");
                System.out.println("3.\tTo add two polynomial");
                System.out.println("3.\tTo multiply two polynomial");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter the number of degrees ");
                        int size = sc.nextInt();
                        arr1 = new int[size][2];
                        for (int i = 0; i < size; i++) {
                            System.out.print("Enter the coefficient " + (i + 1));
                            arr1[i][1] = sc.nextInt();
                            System.out.println("Enter exponential " + (i + 1));
                            arr1[i][0] = sc.nextInt();
                        }
                        p1 = new Poly(arr1);
                        System.out.println("Degree is " + p1.getDegree());
                        break;
                    case 2:
                        System.out.print("Enter the number of degrees ");
                        size = sc.nextInt();
                        arr1 = new int[size][2];
                        for (int i = 0; i < size; i++) {
                            System.out.print("Enter the coefficient " + (i + 1));
                            arr1[i][1] = sc.nextInt();
                            System.out.println("Enter degree " + (i + 1));
                            arr1[i][0] = sc.nextInt();
                        }
                        p1 = new Poly(arr1);
                        System.out.print("Enter the value of \"x\" variable ");
                        float x = sc.nextFloat();
                        System.out.println("Evaluation Result " + p1.evaluate(x));
                        break;
                    case 3:
                        System.out.print("Enter the number of degrees for first Polynomial ");
                        size = sc.nextInt();
                        arr1 = new int[size][2];
                        for (int i = 0; i < size; i++) {
                            System.out.print("Enter the coefficient " + (i + 1));
                            arr1[i][1] = sc.nextInt();
                            System.out.println("Enter degree " + (i + 1));
                            arr1[i][0] = sc.nextInt();
                        }

                        p1 = new Poly(arr1);

                        System.out.print("Enter the number of degrees for second Polynomial ");
                        int size2 = sc.nextInt();
                        arr2 = new int[size2][2];
                        for (int i = 0; i < size2; i++) {
                            System.out.print("Enter the coefficient of " + (i + 1));
                            arr2[i][1] = sc.nextInt();
                            System.out.print("Enter degree of " + (i + 1));
                            arr2[i][0] = sc.nextInt();
                        }
                        p2 = new Poly(arr2);

                        Poly p3 = Poly.addPoly(p1, p2);
                        p3.printPoly();
                        break;
                    case 4:
                        System.out.print("Enter the number of degrees for first Polynomial ");
                        size = sc.nextInt();
                        arr1 = new int[size][2];
                        for (int i = 0; i < size; i++) {
                            System.out.print("Enter the coefficient of " + (i + 1) + " ");
                            arr1[i][1] = sc.nextInt();
                            System.out.println("Enter degree of " + (i + 1) + " ");
                            arr1[i][0] = sc.nextInt();
                        }

                        p1 = new Poly(arr1);

                        System.out.print("Enter the number of degrees for second Polynomial ");
                        size2 = sc.nextInt();
                        arr2 = new int[size2][2];
                        for (int i = 0; i < size2; i++) {
                            System.out.print("Enter the coefficient " + (i + 1));
                            arr2[i][1] = sc.nextInt();
                            System.out.println("Enter degree " + (i + 1));
                            arr2[i][0] = sc.nextInt();
                        }
                        p2 = new Poly(arr2);

                        p3 = Poly.multiplyPoly(p1, p2);
                        p3.printPoly();
                        break;

                    default:
                        break;
                }
                System.out.println("Press 1 to continue ");
                int cont = sc.nextInt();
                if (cont != 1) {
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Enter the valid values only");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
