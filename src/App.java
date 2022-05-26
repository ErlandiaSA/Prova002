
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.function.IntToDoubleFunction;

import ClassAuxiliares.cls_produto;
import ClassAuxiliares.cls_vendas;

public class App {
    private final static int TAMANHO_INICIAL_LISTAS = 10;
    private static cls_produto[] _meuPrd = new cls_produto[TAMANHO_INICIAL_LISTAS];
    private static cls_vendas[] _mnhVnd = new cls_vendas[TAMANHO_INICIAL_LISTAS];

    private static int _nmProdutos = 0;
    private static int _nmVendas = 0;

    private static Scanner sc = new Scanner(System.in);   

    public static void main(String[] args) throws Exception {

        boolean cntExcMenuPrc = true;

        do {
            try {
                MenuPrinc();
                int mnPrc_sl = lerOpcao();
                cntExcMenuPrc = opcMnPrc(mnPrc_sl);
                
            } catch (Exception e) {
                System.out.println("************************************************************************************************\n");
                System.out.println("Ocorreu um erro durante a operação: " + e.getMessage());
                System.out.println("Pressione Enter para continuar");
                sc.nextLine();
                cntExcMenuPrc = true;
            }

        } while (cntExcMenuPrc);
    }

    private static boolean opcMnPrc(int opcao) throws Exception {
        switch (opcao) {
            case 0: {
                System.out.println("Saindo do sistema...");
                return false;
            }
            case 1: {
                boolean cntExcMenuPrd = true;
                do {                    
                    try {
                        MenuProdutos();
                        int mnPrd_sl = lerOpcao();
                        cntExcMenuPrd = opcMnPrd(mnPrd_sl);
                    } catch (Exception e) {
                        System.out.println("\n************************************************************************************************\n");
                        System.out.println("Ocorreu um erro durante a operação: " + e.getMessage());
                        System.out.println("Pressione Enter para continuar");
                        sc.nextLine();
                        cntExcMenuPrd = true;
                    }
                } while (cntExcMenuPrd);
                break;
            }
            case 2: {
                boolean cntExcMenuRt = true;
                do {                
                    try {                    
                        MenuRelatorio();
                        int mnRt_Sl = lerOpcao();
                        cntExcMenuRt = opcMnRt(mnRt_Sl);
                    } catch (Exception e) {
                        System.out.println("\n************************************************************************************************\n");
                        System.out.println("Ocorreu um erro durante a operação: " + e.getMessage());
                        System.out.println("Pressione Enter para continuar");
                        sc.nextLine();
                        cntExcMenuRt = true;
                    }
                } while (cntExcMenuRt);
                break;
            }
            //Mensagem de erro complementando a logica que deixei no validador de opções....
            case 3: {            
                System.out.println("\n************************************************************************************************\n");
                System.out.println("Opção inválida, por favor escolha uma das opções disponiveis!"); 
                System.out.println("Pressione Enter para continuar");
                sc.nextLine();
                break;
            }
        }
        return true;
    }

    private static boolean opcMnPrd(int opcao) throws Exception {
        switch (opcao) {
            //0 - Voltar
            case 0: {                
                System.out.println("Voltando ao menu anterior...");
                return false;
            }
            //1 - Listar produtos
            case 1: {
                
                break;
            }
            //2 - Consultar Produtos
            case 2: {                
                break;
            }
            //3 - Incluir Produto
            case 3: {
                cadastrarProdutos(); 
                break;               
            }            
        }
        return true;
    }

    private static boolean opcMnRt(int opcao) throws Exception {
        switch (opcao) {
            //0 - Voltar
            case 0: {                
                System.out.println("Voltando ao menu anterior...");
                return false;
            }
            //1 - Realizar vendas
            case 1: {
                cadastrarVenda();
                break;
            }
            //2 - Consultar vendas por periodo - Detalhado
            case 2: {                
                break;
            }
            //3 - Consultar Vendas por periodo - Consolidado
            case 3: { 
                
                break;               
            }           
        }
        return true;
    }

    private static void MenuPrinc() {
        System.out.println("************************************************************************************************\n");
        System.out.println("*************************************   MENU PRINCIPAL   ***************************************\n");
        System.out.println("************************************************************************************************\n");

        System.out.println("1 - Produtos");
        System.out.println("2 - Vendas");
        System.out.println("0 - Sair");
    }

    private static void MenuProdutos() {
        System.out.println("************************************************************************************************\n");
        System.out.println("***************************************   MENU PRODUTOS   **************************************\n");
        System.out.println("************************************************************************************************\n");

        System.out.println("1 - Listar produtos");
        System.out.println("2 - Consultar Produtos");
        System.out.println("3 - Incluir Produto");
        System.out.println("0 - Voltar");        
    } 

    private static void MenuRelatorio() {
        System.out.println("************************************************************************************************\n");
        System.out.println("***************************************   MENU RELATÓRIO   *************************************\n");
        System.out.println("************************************************************************************************\n");

        System.out.println("1 - Realizar vendas");
        System.out.println("2 - Consultar vendas por periodo - Detalhado");
        System.out.println("3 - Consultar Vendas por periodo - Consolidado");
        System.out.println("0 - Voltar");        
    } 

    private static void cadastrarProdutos() throws Exception {
        System.out.println("************************************************************************************************\n");
        System.out.println("************************************   Cadastro de Produto   ***********************************\n");
        System.out.println("************************************************************************************************\n");
        System.out.println("");
        System.out.println("Digite o código do produto:");
        String cdPrd = sc.nextLine();
        System.out.println("Digite o nome do produto:");
        String nomePrd = sc.nextLine();
        System.out.println("Digite o valor do produto:");
        //double vlrPrd = Integer.parseInt(sc.nextLine()); //sc.nextDouble();
        double vlrPrd = Double.parseDouble(sc.nextLine());
        System.out.println("Digite a quantidade de produto:");
        int qtdPrd = Integer.parseInt(sc.nextLine());
        //cls_produto _meuPrd = buscarproduto(cdPrd);

        cls_produto _meuPrd = new cls_produto(cdPrd, nomePrd, vlrPrd,  qtdPrd);
        addProdutoNaLista(_meuPrd);

        System.out.println("Produto cadastrado com sucesso....");
        System.out.println("Pressione Enter para continuar:");
        sc.nextLine();
    }

    private static void addProdutoNaLista(cls_produto produto) {
        if (_nmProdutos == _meuPrd.length) {
            cls_produto[] novaLista = new cls_produto[_meuPrd.length * 2];
            
            // Copio os elementos da lista antiga para a nova lista.
            for (int i = 0; i < _meuPrd.length; i++) {
                novaLista[i] = _meuPrd[i];
            }

            // Substituo a lista antiga pela nova.
            _meuPrd = novaLista;
        }

        // Adiciono o piloto a lista.
        _meuPrd[_nmProdutos] = produto;
        _nmProdutos++;
    }

    private static void cadastrarVenda() throws Exception {
        System.out.println("************************************************************************************************\n");
        System.out.println("************************************   Cadastro de Venda   *************************************\n");
        System.out.println("************************************************************************************************\n");
        System.out.println("");
        System.out.println("Digite a data do dia ex: dd/mm/aaaa:");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dataDia = LocalDate.parse(sc.nextLine(), dtf);
        System.out.println("Digite o nome do produto:");
        String nomePrd = sc.nextLine();
        System.out.println("Digite a quantidade vendida:");
        int qdtVnd = Integer.parseInt(sc.nextLine());        

        cls_vendas _meuPrd = new cls_vendas(dataDia, nomePrd, qdtVnd);
        addVendaNaLista(_meuPrd);
    }

    private static void addVendaNaLista(cls_vendas vendas) {
        if (_nmVendas == _mnhVnd.length) {
            cls_vendas[] novaLista = new cls_vendas[_mnhVnd.length + 10];
            
            // Copio os elementos da lista antiga para a nova lista.
            for (int i = 0; i < _mnhVnd.length; i++) {
                novaLista[i] = _mnhVnd[i];
            }

            // Substituo a lista antiga pela nova.
            _mnhVnd = novaLista;
        }

        // Adiciono o piloto a lista.
        _mnhVnd[_nmVendas] = vendas;
        _nmVendas++;
    }

    private static boolean validarOpcaoMenu(int opcao) {
        return (opcao >= 0 && opcao <= 3);
    }

    private static int lerOpcao() {
        int opcao = 0;
        do {
            System.out.print("Selecione a opção desejada: ");
            try {                
                opcao = Integer.parseInt(sc.nextLine());
                if (!validarOpcaoMenu(opcao)) {
                    System.out.println("\n************************************************************************************************\n");
                    System.out.println("Opção inválida, por favor escolha uma das opções disponiveis!");
                    System.out.println("Pressione Enter para continuar");
                sc.nextLine();
                    break;
                }
            } catch (Exception e) {
                System.out.println("\n************************************************************************************************\n");
                System.out.println("Opção inválida, por favor escolha uma das opções disponiveis!");
                System.out.println("Pressione Enter para continuar");
                sc.nextLine();
                break;
            }
        } while (!validarOpcaoMenu(opcao));

        return opcao;
    }
}
