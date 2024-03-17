package services;

import entities.Custo;
import entities.Formação;
import entities.Usuário;
import repositories.EuCalculo;

import static utils.Utilidade.imprimeMensagem;

public class CustoServico implements EuCalculo {

    public static void mostraCusto(Usuário usuário, Formação formação){
        double desconto = 0.0;
        Custo custo = new Custo(69.90, desconto);
        imprimeMensagem("Olá, caro usuário, a cada avanço nos níveis,\n" +
                "você ganha descontos consecutivos em uma nova formação\n" +
                "não gratuita que custa R$ 69.90 brutos.\n");
        System.out.println("Informações pertinentes.\n" +
                            "\n   > Status da primeira formação escolhida : " + formação.getStatusFormação() +
                            "\n   > Nível do usuário : " + usuário.getNivel() +
                            "\n   > Custo de uma nova formação : R$ " + defineDesconto(usuário, custo, desconto));
    }
    public static double defineDesconto(Usuário usuário, Custo custo, double desconto){
        switch(usuário.getNivel()){
            case NICKEL -> {
                 desconto = 0.00;
            }
            case BRONZE -> {
                desconto = 0.05;
            }
            case SILVER -> {
                desconto = 0.1;
            }
            case GOLD -> {
                desconto = 0.125;
            }
            case PLATINUM -> {
                desconto = 0.15;
            }
        }
        double novoCusto = calculaCusto(custo, desconto);
        return novoCusto;
    }
    static double calculaCusto(Custo custo, double desconto){
        double novoValor = custo.getPreco() * (1 - desconto);
        return novoValor;
    }

}
