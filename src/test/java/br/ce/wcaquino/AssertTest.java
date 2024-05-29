package br.ce.wcaquino;

import br.ce.wcaquino.entidades.Usuario;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class AssertTest {
    @Test
    public void test(){
        Assert.assertTrue(true);
        Assert.assertFalse(false);

        Assert.assertEquals(1,1);
        Assert.assertEquals(0.51,0.51, 0.0001);
        //esse delta é a margem de erro que o esperado e o atual pode ter
        Assert.assertEquals(Math.PI, 3.14, 0.01);

        int i = 5;
        Integer i2 =5;
        Assert.assertEquals(Integer.valueOf(i), i2);
        Assert.assertEquals(i, i2.intValue());

        Assert.assertEquals("bola", "bola");
        Assert.assertNotEquals("bola", "casa");
        Assert.assertTrue("bola".equalsIgnoreCase("BOla"));
        Assert.assertTrue("bola".startsWith("bo"));

        Usuario u1 = new Usuario("Usuario 1");
        Usuario u2 = new Usuario("Usuario 1");
//        para verificar se os dois usuarios sao iguais, precisa gerar um equals and hash code na classe
        Assert.assertEquals(u1, u2);

        Assert.assertSame(u2, u2);
        Assert.assertNotSame(u2, u1);

        Usuario u3 =null;
        Assert.assertNull(u3);
        Assert.assertNotNull(u2);



    }
}
