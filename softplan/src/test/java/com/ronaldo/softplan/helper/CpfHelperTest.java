package com.ronaldo.softplan.helper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CpfHelperTest {

    @Test
    public void testInvalidCpf() throws Exception {
        String invalidCpf = "1234";

        Assertions.assertFalse(CpfHelper.isValid(invalidCpf));
    }

    @Test
    public void testValidCpfWithDots() throws Exception {
        String invalidCpf = "752.574.700-80";

        Assertions.assertTrue(CpfHelper.isValid(invalidCpf));
    }

    @Test
    public void testValidCpfWithoutFormat() throws Exception {
        String invalidCpf = "75257470080";

        Assertions.assertTrue(CpfHelper.isValid(invalidCpf));
    }

    @Test
    public void testRemoveInvalidCharacters() {
        String cpf = "752.574.700-80";
        Assertions.assertEquals("75257470080", CpfHelper.removeInvalidCharacters(cpf));
    }
}
