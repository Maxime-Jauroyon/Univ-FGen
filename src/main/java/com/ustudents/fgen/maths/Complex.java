package com.ustudents.fgen.maths;

import com.ustudents.fgen.common.json.JsonSerializable;

/** Represents a complex number. */
@JsonSerializable
public class Complex implements Cloneable {
    /** The real value. */
    @JsonSerializable
    public Double real = 0.;

    /** The imaginary value. */
    @JsonSerializable
    public Double imaginary = 0.;

    public Complex() {

    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getModulus() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    public Complex add(Complex addend) {
        return new Complex(
                real + addend.real,
                imaginary + addend.imaginary);
    }

    public Complex subtract(Complex subtrahend) {
        return new Complex(
                real - subtrahend.real,
                imaginary - subtrahend.imaginary);
    }

    public Complex multiply(Complex factor) {
        return new Complex(
                real * factor.real - imaginary * factor.imaginary,
                real * factor.imaginary + imaginary * factor.real);
    }

    public Complex multiply(double factor) {
        return new Complex(
                real * factor,
                imaginary * factor);
    }

    /* Implementation from: https://commons.apache.org/proper/commons-math/javadocs/api-3.6/src-html/org/apache/commons/math3/complex/Complex.html */
    public Complex log() {
        return new Complex(Math.log(getModulus()), Math.atan2(imaginary, real));
    }

    /* Implementation from: https://commons.apache.org/proper/commons-math/javadocs/api-3.6/src-html/org/apache/commons/math3/complex/Complex.html */
    public Complex exp() {
        double expOfReal = Math.exp(real);
        return new Complex(expOfReal * Math.cos(imaginary), expOfReal * Math.sin(imaginary));
    }

    /* Implementation from: https://commons.apache.org/proper/commons-math/javadocs/api-3.6/src-html/org/apache/commons/math3/complex/Complex.html */
    public Complex pow(Complex factor) {
        return log().multiply(factor).exp();
    }

    /* Implementation from: https://commons.apache.org/proper/commons-math/javadocs/api-3.6/src-html/org/apache/commons/math3/complex/Complex.html */
    public Complex pow(double factor) {
        return log().multiply(factor).exp();
    }

    public Complex divide(Complex divisor) {
        double denominator = divisor.real * divisor.real + divisor.imaginary * divisor.imaginary;
        return new Complex(
                (real * divisor.real + imaginary * divisor.imaginary) / denominator,
                (imaginary * divisor.real - real * divisor.imaginary) / denominator);
    }

    public static Complex fromPolarCoordinates(double rho, double theta) {
        return new Complex(rho * Math.cos(theta),rho * Math.sin(theta));
    }

    @Override
    public Complex clone() {
        final Complex clone;

        try {
            clone = (Complex)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        clone.real = real;
        clone.imaginary = imaginary;

        return clone;
    }
}