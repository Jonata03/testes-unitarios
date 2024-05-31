package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Locacao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

public class CalculadoraMockTest {
    @Mock
    private Calculadora calcMock;

    @Spy
    private Calculadora calcSpy;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void devoMostrarDiferencaMockSpy(){
        Mockito.when(calcMock.somar(1,2)).thenCallRealMethod();
        Mockito.when(calcSpy.somar(1,2)).thenReturn(8);
        Mockito.doNothing().when(calcSpy).imprime();

        System.out.println("Mock"+calcMock.somar(1,2));
        System.out.println("Spy"+calcMock.somar(1,2));
    }

    @Test
    public void teste(){
        Calculadora calc = Mockito.mock(Calculadora.class);

        ArgumentCaptor<Integer> orgCapt = ArgumentCaptor.forClass(Integer.class);
        Mockito.when(calc.somar(orgCapt.capture(), orgCapt.capture())).thenReturn(5);

        Assert.assertEquals(5,calc.somar(1, 2));
        System.out.println(orgCapt.getAllValues());
    }
}
