package com.gqs.aula.tdd;

/**
 * Calculates a final grade from three assessment grades.
 */
public class CalculadoraNota {

public double calcularNotaFinal(double a1, double a2, double a3) {
validarNota(a1, 30,"A1");
validarNota(a2, 30,"A2");
validarNota(a3,40,"A3");
return a1 + a2 + a3;
}

public static final double NOTA_MINIMA_APROVACAO = 70;

public boolean estaAprovadoPorNota(double notaFinal) {
return notaFinal >= NOTA_MINIMA_APROVACAO;
}
public static final double FREQUENCIA_MINIMA_APROVACAO = 75;

public boolean estaAprovadoPorFrequencia(double frequencia) {
return frequencia >= FREQUENCIA_MINIMA_APROVACAO;
}
private void validarNota(double nota, double notaMaxima, String nomeAvaliacao) {
if (nota < 0 || nota > notaMaxima) {
throw new IllegalArgumentException(
nomeAvaliacao + " deve estar entre 0 e " + notaMaxima);
}
}
public String situacao(double notaFinal, double frequencia) // "APROVADO" ou "REPROVADO"
{ if (notaFinal >= NOTA_MINIMA_APROVACAO && frequencia >= FREQUENCIA_MINIMA_APROVACAO) {
        return "APROVADO";
    }else {
    return "REPROVADO";
}
}
}