package com.gqs.aula.tdd;

/**
 * Calculates a final grade from three assessment grades.
 */
public class CalculadoraNota {
public double calcularNotaFinal(double a1, double a2, double a3) {
return a1 + a2 + a3;
}
public boolean estaAprovadoPorNota(double notaFinal) {
return notaFinal >= 70;
}

}
