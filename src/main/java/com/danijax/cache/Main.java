package com.danijax.cache;

/**
 * Created by danijax on 8/3/17.
 */
public class Main {
    static int[] wQ1 = {0, 1, 3, 4, 5, 6, 8};
    static int[] xQ1 = {0, 2, 3, 5, 6, 7, 8};
    static int[] yQ1 = {1, 2, 3, 4, 5, 6, 7};
    static int[] zQ1 = {0, 2, 3, 4, 5, 6, 8};

    static int[] getIndices(char placement) {
        //System.out.println(this);
        System.out.println(placement);
        Mask mask = null;

        return getPlacement(Mask.W, placement);
    }

    static String returnArray(int[] x) {
        String end = "";
        for (int i = 0; i < x.length; i++) {
            end = end + String.valueOf(x[i]);
        }
        return end;
    }

    static int rotatePoint(int x) {
        switch (x) {
            case 0:
                return 2;
            case 1:
                return 5;
            case 2:
                return 8;
            case 3:
                return 1;
            case 4:
                return 4;
            case 5:
                return 7;
            case 6:
                return 0;
            case 7:
                return 3;
            case 8:
                return 6;
            default:
                return -1; // if the case is not matched.
        }
    }

    static int[] mapRotate(int[] x) {
        for (int i = 0; i < x.length; i++) {
            x[i] = rotatePoint(i);
        }
        return x;
    }

    static int[] scaleArray(int[] x, int factor) {
        for (int i = 0; i < x.length; i++) {
            x[i] = x[i] + factor;
        }
        return x;
    }

    static int[] getPlacement(Enum m, char p) {
        int[] q1 = getQ1Indicies(m);

        switch (p + "") {

            case "A":
                return q1;
            case "B":
                return mapRotate(q1);
            case "C":
                return mapRotate(mapRotate(q1));
            case "D":
                return mapRotate(mapRotate(mapRotate(q1)));
            case "E":
                return changeQuadrant(q1, 2);
            case "F":
                return changeQuadrant(mapRotate(q1), 2);
            case "G":
                return changeQuadrant(mapRotate(mapRotate(q1)), 2);
            case "H":
                return changeQuadrant(mapRotate(mapRotate(mapRotate(q1))), 2);
            case "I":
                return changeQuadrant(q1, 3);
            case "J":
                return changeQuadrant(mapRotate(q1), 3);
            case "K":
                return changeQuadrant(mapRotate(mapRotate(q1)), 3);
            case "L":
                return changeQuadrant(mapRotate(mapRotate(mapRotate(q1))), 3);
            case "M":
                return changeQuadrant(q1, 4);
            case "N":
                return changeQuadrant(mapRotate(q1), 4);
            case "O":
                return changeQuadrant(mapRotate(mapRotate(q1)), 4);
            case "P":
                return changeQuadrant(mapRotate(mapRotate(mapRotate(q1))), 4);
            default:
                System.out.println("Placement Error, reverting to original placement");
                return q1;
        }

    }


    static int[] changeQuadrant(int[] quadrantOneValues, int destinationQuadrant) {

        if (destinationQuadrant == 2) {
            return scaleArray(quadrantOneValues, 9);
        } else if (destinationQuadrant == 3) {
            return scaleArray(quadrantOneValues, 18);
        } else if (destinationQuadrant == 4) {
            return scaleArray(quadrantOneValues, 27);
        } else {
            System.out.println("Error, invalid value in changeQuadrant");
            return quadrantOneValues;
        }
    }

    static int[] getQ1Indicies(Enum m) {
        if (m == Mask.W) {
            System.out.println("Returning W " + returnArray(wQ1));
            return wQ1;
        } else if (m == Mask.X) {
            System.out.println("Returning X " + returnArray(xQ1));
            return xQ1;
        } else if (m == Mask.Y) {
            System.out.println("Returning Y");
            return yQ1;
        } else {
            System.out.println("Returning Z");
            return zQ1;
        }

    }
    public static void main(String[] args) {
        getIndices('W');
    }
}
