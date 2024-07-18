public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;

    static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.yyPos = yP;
        this.xxPos = xP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;

    }

    public Planet(Planet p) {
        this.yyPos = p.yyPos;
        this.xxPos = p.xxPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;


    }

    public double calcDistance(Planet p1) {
        double x = (this.xxPos - p1.xxPos) * (this.xxPos - p1.xxPos);
        double y = (this.yyPos - p1.yyPos) * (this.yyPos - p1.yyPos);
        return Math.sqrt(x + y);
    }

    public double calcForceExertedBy(Planet p) {
        double r = calcDistance(p);
        return G * this.mass * p.mass / (r * r);
    }


    public double calcForceExertedByX(Planet p) {
        double f = calcForceExertedBy(p);
        double distance = calcDistance(p);
        double disX = p.xxPos - this.xxPos;
        return disX * f / distance;
    }

    public double calcForceExertedByY(Planet p) {
        double f = calcForceExertedBy(p);
        double distance = calcDistance(p);
        double disY = p.yyPos - this.yyPos;
        return disY * f / distance;
    }

    public double calcNetForceExertedByX(Planet[] p) {
        double sum = 0;
        for (Planet planet : p) {
            if (planet == this)
                continue;
            sum += calcForceExertedByX(planet);
        }
        return sum;
    }

    public double calcNetForceExertedByY(Planet[] p) {
        double sum = 0;
        for (Planet planet : p) {
            if (planet == this)
                continue;
            sum += calcForceExertedByY(planet);
        }
        return sum;
    }


    public void update(double dt, double fX, double fY) {
        double ax = fX / this.mass;
        double ay = fY / this.mass;
        this.xxVel = this.xxVel + dt * ax;
        this.yyVel = this.yyVel + dt * ay;
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

    public void draw() {

        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);

    }

}