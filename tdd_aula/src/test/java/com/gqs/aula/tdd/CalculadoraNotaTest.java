package com.gqs.aula.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CalculadoraNotaTest {
// os testes vêm aqui
@Test
void deveSomarAsTresNotas() {
CalculadoraNota calc = new CalculadoraNota();
double resultado = calc.calcularNotaFinal(20, 20, 30);
assertEquals(70, resultado);
}
@Test
void deveSomarOutrasNotas() {
CalculadoraNota calc = new CalculadoraNota();
double resultado = calc.calcularNotaFinal(10, 15, 25);
assertEquals(50, resultado);
}
@Test
void deveAprovarComNota70() {
CalculadoraNota calc = new CalculadoraNota();
assertTrue(calc.estaAprovadoPorNota(70));
}

@Test
void deveReprovarComNota69() {
CalculadoraNota calc = new CalculadoraNota();
assertFalse(calc.estaAprovadoPorNota(69));
}
@Test 
void deveRejeitarA1MaiorQue30() {
    CalculadoraNota calc = new CalculadoraNota();
    assertThrows(IllegalArgumentException.class,
        () -> calc.calcularNotaFinal(35, 20, 30));
}
@Test 
    void deveRejeitarA2MaiorQue30() {
    CalculadoraNota calc = new CalculadoraNota();
    assertThrows(IllegalArgumentException.class,
        () -> calc.calcularNotaFinal(20, 35, 30));
}
@Test 
void deveRejeitarA3MaiorQue40() {
    CalculadoraNota calc = new CalculadoraNota();
    assertThrows(IllegalArgumentException.class,
        () -> calc.calcularNotaFinal(20, 20, 45));
}
@Test 
void deveAprovarComNotaEFrequenciaSuficientes() {
    CalculadoraNota calc = new CalculadoraNota();
    String resultado = calc.situacao(80, 90);
    assertEquals("APROVADO", resultado);
}
@Test 
void deveReprovarComNotaBaixa() {
    CalculadoraNota calc = new CalculadoraNota();
    String resultado = calc.situacao(60, 90);
    assertEquals("REPROVADO", resultado);
}
@Test 
void deveReprovarPorFrequenciaMesmoComNotaAlta() {
    CalculadoraNota calc = new CalculadoraNota();
    String resultado = calc.situacao(95, 74);
    assertEquals("REPROVADO", resultado);
}
@Test 
void deveAprovarComFrequenciaExatamente75() {
    CalculadoraNota calc = new CalculadoraNota();
    String resultado = calc.situacao(70, 75);
    assertEquals("APROVADO", resultado);
}
@Test
void devePermitirAIComNotaBaixaEFrequenciaSuficiente() {
    CalculadoraNota calc = new CalculadoraNota();
    boolean resultado = calc.podeFazerAI(10, 20, 30, 80);
    assertTrue(resultado);
}
@Test 
void devePermitirAICOmNotaBaixaExatamenteEFrequenciaSuficiente() {
    CalculadoraNota calc = new CalculadoraNota();
    boolean resultado = calc.podeFazerAI(10, 5, 30, 80);
    assertTrue(resultado);
}
@Test 
void naoDevePermitirAIComNotaAlta() {
    CalculadoraNota calc = new CalculadoraNota();
    boolean resultado = calc.podeFazerAI(25, 25, 30, 80);
    assertFalse(resultado);
}
@Test
void naoDevePermitirAIComFrequenciaInsuficiente() {
    CalculadoraNota calc = new CalculadoraNota();
    boolean resultado = calc.podeFazerAI(10, 20, 30, 70);
    assertFalse(resultado);
}
@Test
void naoDevePermitirAIComNotaBaixa() {
    CalculadoraNota calc = new CalculadoraNota();
    boolean resultado = calc.podeFazerAI(5, 5, 30, 80);
    assertFalse(resultado);
}

@Test
void deveSubstituirA1QuandoForAMenor() {
    CalculadoraNota calc = new CalculadoraNota();

    assertEquals(75.0, calc.aplicarAI(10, 20, 30, 25));
}

@Test
void deveSubstituirA2QuandoForAMenor() {
    CalculadoraNota calc = new CalculadoraNota();

    assertEquals(75.0, calc.aplicarAI(20, 10, 30, 25));
}

@Test
void naoDeveSubstituirQuandoAIForBaixa() {
    CalculadoraNota calc = new CalculadoraNota();

    assertEquals(60.0, calc.aplicarAI(10, 20, 30, 5));
}

@Test
void deveRejeitarAIInvalida() {
    CalculadoraNota calc = new CalculadoraNota();

    assertThrows(IllegalArgumentException.class,
        () -> calc.aplicarAI(10, 20, 30, 31));
}

@Test
void naoDeveSubstituirQuandoAIForIgualAMenorNota() {
    CalculadoraNota calc = new CalculadoraNota();

    assertEquals(60.0, calc.aplicarAI(10, 20, 30, 10));
}

}