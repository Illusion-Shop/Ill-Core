package net.illusion.core.util.text;

import com.google.common.base.Preconditions;
import net.md_5.bungee.api.ChatColor;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.Arrays;


public class Gradient implements Interpolator {

    public static double[] linear(double from, double to, int max) {
        final double[] res = new double[max];
        for (int i = 0; i < max; i++) {
            res[i] = from + i * ((to - from) / (max - 1));
        }
        return res;
    }

    public static String multiRgbGradient(String str, Color[] colors, @Nullable double[] portions, Interpolator interpolator) {
        final double[] p;
        if (portions == null) {
            p = new double[colors.length - 1];
            Arrays.fill(p, 1 / (double) p.length);
        } else {
            p = portions;
        }

        Preconditions.checkArgument(colors.length >= 2);
        Preconditions.checkArgument(p.length == colors.length - 1);

        final StringBuilder builder = new StringBuilder();
        int strIndex = 0;

        for (int i = 0; i < colors.length - 1; i++) {
            builder.append(rgbGradient(
                    str.substring(strIndex, strIndex + (int) (p[i] * str.length())),
                    colors[i],
                    colors[i + 1],
                    interpolator));
            strIndex += p[i] * str.length();
        }
        return builder.toString();
    }

    public static double[] quadratic(double from, double to, int max, boolean mode) {
        final double[] results = new double[max];
        if (mode) {
            double a = (to - from) / (max * max);
            for (int i = 0; i < results.length; i++) {
                results[i] = a * i * i + from;
            }
        } else {
            double a = (from - to) / (max * max);
            double b = -2 * a * max;
            for (int i = 0; i < results.length; i++) {
                results[i] = a * i * i + b * i + from;
            }
        }
        return results;
    }

    public static String rgbGradient(String str, Color from, Color to, Interpolator interpolator) {

        final double[] red = interpolator.interpolate(from.getRed(), to.getRed(), str.length());
        final double[] green = interpolator.interpolate(from.getGreen(), to.getGreen(), str.length());
        final double[] blue = interpolator.interpolate(from.getBlue(), to.getBlue(), str.length());

        final StringBuilder builder = new StringBuilder();


        for (int i = 0; i < str.length(); i++) {
            builder.append(ChatColor.of(new Color(
                            (int) Math.round(red[i]),
                            (int) Math.round(green[i]),
                            (int) Math.round(blue[i]))))
                    .append(str.charAt(i));
        }

        return builder.toString();
    }

    private static String hsvGradient(String str, Color from, Color to, Interpolator interpolator) {

        final float[] hsvFrom = Color.RGBtoHSB(from.getRed(), from.getGreen(), from.getBlue(), null);
        final float[] hsvTo = Color.RGBtoHSB(to.getRed(), to.getGreen(), to.getBlue(), null);

        final double[] h = interpolator.interpolate(hsvFrom[0], hsvTo[0], str.length());
        final double[] s = interpolator.interpolate(hsvFrom[1], hsvTo[1], str.length());
        final double[] v = interpolator.interpolate(hsvFrom[2], hsvTo[2], str.length());

        final StringBuilder builder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            builder.append(ChatColor.of(Color.getHSBColor((float) h[i], (float) s[i], (float) v[i]))).append(str.charAt(i));
        }
        return builder.toString();
    }

    public static String multiHsvQuadraticGradient(String str, boolean first) {
        final StringBuilder builder = new StringBuilder();

        builder.append(hsvGradient(
                str.substring(0, (int) (0.2 * str.length())),
                Color.RED,
                Color.GREEN,
                (from, to, max) -> quadratic(from, to, max, first)
        ));

        for (int i = (int) (0.2 * str.length()); i < (int) (0.8 * str.length()); i++) {
            builder.append(ChatColor.of(Color.GREEN)).append(str.charAt(i));
        }

        builder.append(hsvGradient(
                str.substring((int) (0.8 * str.length())),
                Color.GREEN,
                Color.RED,
                (from, to, max) -> quadratic(from, to, max, !first)
        ));

        return builder.toString();
    }

    @Override
    public double[] interpolate(double from, double to, int max) {
        final double[] res = new double[max];
        for (int i = 0; i < max; i++) {
            res[i] = from + i * ((to - from) / (max - 1));
        }
        return res;
    }
}
