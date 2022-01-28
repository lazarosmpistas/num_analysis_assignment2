import java.text.DecimalFormat;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        double[] x;
        double[] y;
        double xPoint = -Math.PI;
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(6);

        //initializing values of x (and y) (this will be modified if values or number of x points need to be changed)
        int xNumOfPoints = 10;
        x = new double[xNumOfPoints];
        y = new double[xNumOfPoints];

        /*
        METHOD TO INITIALIZE EVERY X RANDOMLY, DISCARDED BECAUSE WE NEED TO STUDY ON PREDETERMINED X POINTS

         Random r = new Random();
         x[0] = -4;
         for (int i = 1; i < x.length; i++) {
            x[i] = x[i-1] + (5 - x[i-1]) * r.nextDouble(0.5);
            System.out.println("X IS: " + x[i]);
            y[i] = Math.sin(x[i]);
        }

        */

        for (int i = 0; i < xNumOfPoints; i++) {
            if (i < 4) {
                x[i] = -Math.PI / Math.pow(2, i);
            } else if (i == 4) {
                x[i] = 0;
            } else {
                x[i] = Math.PI / 16 * Math.pow(2, i - 5);
            }
            y[i] = Math.sin(x[i]);
        }
        for (int i = 0; i < 200; i++) {
            System.out.println("SINX WITH X = " + df.format(xPoint) + " USING LAGRANGE METHOD EQUALS: " +
                    df.format(LagrangeMethod.LagrangeMethodResult(x, y, xPoint)));
            xPoint += 2 * Math.PI / 199;
        }
        /*
        System.out.println("SINX WITH X = π/2 USING OLS 1st DEGREE POLYNOMIAL METHOD EQUALS: "
                + ols.olsMethod(x, y, xPoint));

    */
    }

}
