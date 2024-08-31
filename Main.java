import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // INICIANDO OBTENDO OS DADOS DO USUÁRIO
        // Inicializando o Scanner para ler um valor do usuário
        Scanner leitura = new Scanner(System.in);
        // Variavel para guardar o tipo de conta
        String tipoDeConta = "";

        // Receber o nome completo do usuário
        System.out.println("Informe seu nome Completo: ");
        String nome = leitura.nextLine();

        // Receber o tipo de conta que o usuário deseja, sendo 1 para corrente e 2 para salário
        System.out.println("Digite 1 para criar uma conta corrente ou 2 para criar uma conta salário! ");
        int conta = leitura.nextInt();

        if (conta == 1) {
            tipoDeConta = "Corrente";
        } else {
            tipoDeConta = "Salário";
        }
        // Realiza uma opção de saque inicial
        System.out.println("Gostaria de realizar um depósito inicial:");
        double saldo = leitura.nextDouble();


        String dadosDoCliente = """
                ***************************************************
                Dados Iniciais do Cliente
                
                Nome:                  %s
                Tipo de Conta:         %s
                Saldo Inicial:         %.2f
                ***************************************************
                """.formatted(nome, tipoDeConta, saldo);

        // imprime todos os dados do usuário
        System.out.println(dadosDoCliente);

        //INICIO DOS CÓDIGOS RELACIONADOS AS OPERAÇÕES

        int opcao = 0;
        // Realiza o looping das operações enquanto a opção 4 não for selecionada
        while (opcao != 4) {
            String operacoes = """
                    Operações
                    
                    1- Cosultar Valores
                    2- Receber Valor
                    3- Transferir Valor
                    4- Sair
                    
                    Digite a opção desejada:
                    """;

            System.out.println(operacoes);
            opcao = leitura.nextInt();

            // Verifica se a opção digitada não é diferente das disponiveis
            if (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4) {
                System.out.println("Opção inválida! tente novamente");
            } else {

                if (opcao == 1) {
                    String exibirSaldo = """
                            
                            ************************************
                            Seu saldo é de: %.2f
                            ************************************
                            
                            """.formatted(saldo);
                    System.out.println(exibirSaldo);
                    opcao -= 1;
                } else if (opcao == 2) {
                    System.out.println("Digite o valor a receber:");
                    double saldoRecebido = leitura.nextDouble();
                    saldo += saldoRecebido;
                } else if (opcao == 3) {
                    System.out.println("Digite o valor a transferir:");
                    double saldoTrasnferido = leitura.nextDouble();
                    if (saldoTrasnferido > saldo) {
                        System.out.println("Você não tem saldo suficiente para essa transferência!");
                    } else {
                        saldo -= saldoTrasnferido;
                    }
                }

            }
        }
    }
}