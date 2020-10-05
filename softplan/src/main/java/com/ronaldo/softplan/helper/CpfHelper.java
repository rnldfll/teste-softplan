package com.ronaldo.softplan.helper;

public class CpfHelper {
    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

    public static boolean isValid(String cpf) {
        return (isValidCPF(cpf));
    }

    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
            digito = Integer.parseInt(str.substring(indice,indice+1));
            soma += digito*peso[(peso.length - str.length()) + indice];
        }
        soma = 11 - (soma % 11);
        return (soma > 9) ? 0 : soma;
    }

    private static String padLeft(String text, char character) {
        return String.format("%11s", text).replace(' ', character);
    }

    private static boolean isValidCPF(String cpf) {
        cpf = cpf.trim().replace(".", "").replace("-", "");

        if (cpf.length() != 11) {
            return false;
        }

        for (int j = 0; j < 10; j++)
            if (padLeft(Integer.toString(j), Character.forDigit(j, 10)).equals(cpf))
                return false;

        Integer digito1 = calcularDigito(cpf.substring(0,9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1, pesoCPF);

        return cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString());
    }

    public static String removeInvalidCharacters(String federalIdentification) {
        return federalIdentification.replaceAll("[^\\d]", "");
    }
}
