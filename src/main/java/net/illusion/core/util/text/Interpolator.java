package net.illusion.core.util.text;

@FunctionalInterface
interface Interpolator {

    double[] interpolate(double from, double to, int max);
}