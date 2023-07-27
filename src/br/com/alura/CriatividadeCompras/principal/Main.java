package br.com.alura.CriatividadeCompras.principal;

import br.com.alura.CriatividadeCompras.modelo.Cartao;
import br.com.alura.CriatividadeCompras.modelo.Compra;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int operacao = 1;
        String perguntaLimite = "Digite o Limite do Cartão";
        Scanner leitor = new Scanner(System.in);
        String nomeCompraPergunta = "Digite a nome ou descrição do produto:";
        String perguntaValor = "Qual o valor da Compra?";
        String perguntaSair = "Deseja sair? 0 para sair e 1 para continuar as compras";
        List<Compra> listaDeCompras = new LinkedList<>();

        /* Perguntando o saldo inicial de limite */
        System.out.println(perguntaLimite);
        Cartao cartaoCliente = new Cartao(leitor.nextDouble());

        /* Interface que pergunta os produtos e preços */
        do {
            System.out.println(nomeCompraPergunta);
            String descricaoInput = leitor.next();

            System.out.println(perguntaValor);
            double precoInput = leitor.nextDouble();

            if (precoInput <= cartaoCliente.getLimiteDoCartao()){
                var compra = new Compra(descricaoInput, precoInput);
                listaDeCompras.add(compra);
                System.out.println("Compra realizada com sucesso!");
                cartaoCliente.compra(precoInput);
            } else {
                System.out.println("Saldo indisponivel, impossível realizar a compra!");
                System.out.println("Saldo: " + cartaoCliente.getLimiteDoCartao() + " R$");
            }

            System.out.println(perguntaSair);
            operacao = leitor.nextInt();
        } while (operacao == 1);

        /* mostrando o saldo e as compras */
        String saldoCartao = """
                *****************************
                Saldo do Cartão: %.2f R$
                *****************************
                Lista de compras:
                """.formatted(cartaoCliente.getLimiteDoCartao());
        System.out.println(saldoCartao);

        Collections.sort(listaDeCompras);
        listaDeCompras.forEach(item -> System.out.println(item.getNome() + "\nR$" + item.getValor()));
        System.out.println("*****************************");
    }
}