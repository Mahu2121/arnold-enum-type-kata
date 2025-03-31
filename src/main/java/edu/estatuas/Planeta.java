package edu.estatuas;

import java.util.EnumSet;

public enum Planeta {

    MERCURY(3.303e+23, 2.4397e+6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6),
    MARS(6.421e+23, 3.3972e6),
    JUPITER(1.9e+27,   7.1492e7),
    SATURN(5.688e+26, 6.0268e7),
    URANUS(8.686e+25, 2.5559e7),
    NEPTUNE(1.024e+26, 2.4746e7);

    public static final double G = 6.67400e-11;


    private final double masa;
    private final double radius;

    Planeta(double masa, double radius) {
        this.masa = masa;
        this.radius = radius;
    }

    public double getMasa() {
        return masa;
    }

    public double getRadius() {
        return radius;
    }

    public double gravedadSuperficie() {
        return G * this.masa / this.radius;
    }

    public double masaPersona(double peso) {
        return peso / (G * EARTH.getMasa() / EARTH.getRadius());
    }

    public double pesoSuperficie(double peso) {
        return masaPersona(peso) * gravedadSuperficie();
    }

    public static EnumSet<Planeta> getGigantesGaseosos() {
        return EnumSet.range(JUPITER, NEPTUNE);

    }

    public static EnumSet<Planeta> getPlanetasTerrestres() {
        return EnumSet.range(MERCURY, MARS);
    }
}
