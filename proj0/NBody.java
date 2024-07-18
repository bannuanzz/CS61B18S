public class NBody {
    public static double readRadius(String FileName) {
        In in = new In(FileName);
        int numberOfPlanets = in.readInt();
        return in.readDouble();

    }

    public static Planet[] readPlanets(String FileName) {

        In in = new In(FileName);
        int numberOfPlanets = in.readInt();
        Planet[] planets = new Planet[numberOfPlanets];
        double radius = in.readDouble();
        for (int i = 0; i < numberOfPlanets; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] p = readPlanets(filename);
        double radius = readRadius(filename);
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-dt, dt);
        double time = 0;
        while (time <= T) {
            double[] xForces = new double[p.length];
            double[] yForces = new double[p.length];
            for (int i = 0; i < p.length; i++) {

                xForces[i] = p[i].calcNetForceExertedByY(p);
                yForces[i] = p[i].calcNetForceExertedByY(p);
            }
            for (int i = 0; i < p.length; i++) {
                p[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet planet : p) {
                planet.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }


    }

}
