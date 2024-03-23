import java.util.*; // todas as bibliotecas necessárias estão no java.util


// Classe Produto
class Produto implements Comparable<Produto> {
    private String nome;
    private float preco;
    private String descricao;
    private boolean disponivel;

    public int compareTo(Produto outroProduto) {
        return Float.compare(this.preco, outroProduto.getPreco());
    }
    public String getNome() {
        return nome;
    }
    // construcotr *importante*
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public boolean isDisponivel() {
        return disponivel;
    }
    public String getDisponibilidadeFormatada() {
        return disponivel ? "Sim" : "Não";
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    public Produto(String nome) {
        this.nome = nome;
    }











public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        // Exibe uma mensagem inicial
        System.out.println("Cadastro de produtos");
         // Loop principal do programa, faz com que o usuário fique nesse loop até digitar uma opção válida.
         while (true) {
            try {
            // Exibe o menu de opções/métodos
System.out.println("\nEscolha uma opção:");
System.out.println("1. Adicionar um produto");
System.out.println("2. Renomear um produto");
System.out.println("3. Adicionar preço ao produto");
System.out.println("4. Disponibilidade para venda ");
System.out.println("5. Listar produtos");
System.out.println("6. Adicionar descrição a um produto existente");
System.out.println("7. Remover um produto cadastrado");
System.out.println("8. Encerrar programa");
System.out.print("Opção: ");
int opcao = scanner.nextInt();
scanner.nextLine();

            
   /* Executa a opção escolhida pelo usuário*/ switch (opcao) {
                                                         case 1:
                                                             adicionarProduto(scanner, produtos);
                                                             break;
                                                         case 2:
                                                             renomearProduto(scanner, produtos);
                                                             break;
                                                         case 3:
                                                             adicionarPrecoProduto(scanner, produtos);
                                                             break;
                                                         case 4:
                                                             adicionarDisponibilidadeProduto(scanner, produtos);
                                                             break;
                                                         case 5:
                                                             listarProdutos(scanner, produtos);
                                                             break;
                                                         case 6:
                                                             adicionarDescricaoProduto(scanner, produtos);
                                                             break;
                                                         case 7:
                                                             removerProduto(scanner, produtos);
                                                             break;
                                                         case 8:
                                                             System.out.println("Encerrando o programa...");
                                                             scanner.close();
                                                             return;
                                                             default:
                                                                 System.out.println("Opção inválida. Tente novamente.");
                                                             }
                                                         }
                                                                    catch (InputMismatchException e) {
                                                     System.out.println("Por favor, insira uma opção válida.");
                                                     scanner.nextLine(); // Limpa o scanner para evitar loops infinitos
                                                         }
                                                     }
                                                 }
        
        
    












    // Opção para adicionar um novo produto
    private static void adicionarProduto(Scanner scanner, ArrayList<Produto> produtos) {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        if (nome.equalsIgnoreCase("voltar")) {
            System.out.println("Retornando para a tela de seleção...");
            return; // Retorna ao menu de opções
        }
        produtos.add(new Produto(nome));
        System.out.println("Produto adicionado com sucesso!");
        listarProdutos(scanner, produtos);
    }











   // Opção para renomear um produto existente
   private static void renomearProduto(Scanner scanner, ArrayList<Produto> produtos) {
    if (produtos.isEmpty()) {
        System.out.println("Não há produtos cadastrados.");
        return; // Retorna ao menu de opções
    }

    // Exibe os produtos cadastrados com seus índices
    System.out.println("Produtos cadastrados:");
    for (int i = 0; i < produtos.size(); i++) {
        System.out.println((i + 1) + ". " + produtos.get(i).getNome());
    }

    // Solicita ao usuário que selecione o índice do produto a ser renomeado
    System.out.print("Selecione o número do produto que deseja renomear (ou digite '0' para voltar): ");
    int indice = scanner.nextInt();
    scanner.nextLine(); // Limpa o buffer do scanner
    
    // Verifica se o usuário digitou "0" para voltar
    if (indice == 0) {
        System.out.println("Retornando para a tela de seleção...");
        return; // Retorna ao menu de opções
    }

    // Verifica se o índice selecionado é válido
    if (indice >= 1 && indice <= produtos.size()) {
        // Solicita ao usuário o novo nome para o produto
        System.out.print("Digite o novo nome para o produto: ");
        String novoNome = scanner.nextLine();

        // Renomeia o produto
        try {
            Produto produto = produtos.get(indice - 1);
            produto.setNome(novoNome);
            System.out.println("Produto renomeado com sucesso!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("O índice selecionado é inválido.");
        }
    } else {
        System.out.println("Índice inválido. Por favor, insira um número entre 1 e " + produtos.size() + ".");
    }
}











// Opção para alterar a disponibilidade de venda de um produto
private static void adicionarDisponibilidadeProduto(Scanner scanner, ArrayList<Produto> produtos) {
    if (produtos.isEmpty()) {
        System.out.println("Não há produtos cadastrados.");
        return; // Retorna ao menu de opções
    }

    // Exibe os produtos cadastrados com seus índices
    System.out.println("Produtos cadastrados:");
    for (int i = 0; i < produtos.size(); i++) {
        Produto produto = produtos.get(i);
        System.out.println((i + 1) + ". " + produto.getNome());
    }

    // Solicita ao usuário que selecione o índice do produto cuja disponibilidade deseja alterar
    System.out.print("Selecione o número do produto cuja disponibilidade deseja alterar (ou digite 'voltar' para voltar): ");
    String input = scanner.nextLine();

    // Verifica se o usuário digitou "voltar" para retornar
    if (input.equalsIgnoreCase("voltar")) {
        System.out.println("Retornando para a tela de seleção...");
        return; // Retorna ao menu de opções
    }

    // Tenta converter a entrada do usuário em um número
    int indice;
    try {
        indice = Integer.parseInt(input);
    } catch (NumberFormatException e) {
        System.out.println("Entrada inválida. Por favor, insira um número de produto válido ou 'voltar'.");
        return; // Retorna ao menu de opções
    }

    // Verifica se o índice selecionado é válido
    if (indice < 1 || indice > produtos.size()) {
        System.out.println("Índice inválido.");
        return; // Retorna ao menu de opções
    }

    // Solicita ao usuário a nova disponibilidade para o produto
    System.out.print("Disponível para venda (sim/não): ");
    String disponibilidade = scanner.nextLine().toLowerCase();
    Produto produto = produtos.get(indice - 1);
    produto.setDisponivel(disponibilidade.equals("sim") || disponibilidade.equals("s"));
    if (disponibilidade.equalsIgnoreCase("sim") || disponibilidade.equalsIgnoreCase("s")) {
        System.out.println("Disponibilidade do produto alterada com sucesso!");
    } else if (disponibilidade.equalsIgnoreCase("não") || disponibilidade.equalsIgnoreCase("n")) {
        System.out.println("Disponibilidade do produto alterada com sucesso!");
    } else {
        System.out.println("Opção inválida. A disponibilidade não foi alterada.");
    }
}












    // Opção para adicionar um preço a um produto existente
   private static void adicionarPrecoProduto(Scanner scanner, ArrayList<Produto> produtos) {
    // Exibe os produtos cadastrados com seus índices
    System.out.println("Produtos cadastrados:");
    for (int i = 0; i < produtos.size(); i++) {
        System.out.println((i + 1) + ". " + produtos.get(i).getNome());
    }

    // Solicita ao usuário que selecione o índice do produto ao qual deseja adicionar o preço
    System.out.print("Selecione o número do produto ao qual deseja adicionar o preço (ou digite 'voltar' para voltar): ");
    String input = scanner.nextLine();

    // Verifica se o usuário digitou "voltar" para retornar
    if (input.equalsIgnoreCase("voltar")) {
        System.out.println("Retornando para a tela de seleção...");
        return; // Retorna ao menu de opções
    }

    // Tenta converter a entrada do usuário em um número
    int indice;
    try {
        indice = Integer.parseInt(input);
    } catch (NumberFormatException e) {
        System.out.println("Entrada inválida. Por favor, insira um número de produto válido ou 'voltar'.");
        return; 
    }

    // Verifica se o índice selecionado é válido
    if (indice < 1 || indice > produtos.size()) {
        System.out.println("Índice inválido.");
        return; 
    }

    // Solicita ao usuário o preço para o produto
    float preco;
    while (true) {
        System.out.print("Digite o preço para o produto: R$");
        if (scanner.hasNextFloat()) {
            preco = scanner.nextFloat();
            scanner.nextLine(); // Limpa o buffer do scanner
            break;
        } else {
            System.out.println("Por favor, insira um número válido.");
            scanner.next(); // Limpa a entrada inválida do scanner
        }
    }

    // Define o preço para o produto selecionado
    Produto produto = produtos.get(indice - 1);
    produto.setPreco(preco);

    System.out.println("Preço adicionado ao produto com sucesso!");
}











// Método para listar todos os produtos cadastrados
private static void listarProdutos(Scanner scanner, ArrayList<Produto> produtos) {
    while (true) {
        System.out.println("\nProdutos cadastrados:");
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            System.out.println((i + 1) + ". Nome: " + produto.getNome() + ", Preço: R$" + produto.getPreco() + ", Disponível?: " + produto.getDisponibilidadeFormatada());
        }
        
        System.out.println("\nOpções:");
        System.out.println("1. Adicionar novo produto");
        System.out.println("0. Voltar");

        System.out.print("\nOpção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner

        switch (opcao) {
            case 1:
                adicionarNovoProduto(scanner, produtos);
                break;
            case 0:
                return;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
// Método para adicionar um novo produto dentro da tela de listagem de produtos
private static void adicionarNovoProduto(Scanner scanner, ArrayList<Produto> produtos) {
    System.out.print("Digite o nome do produto: ");
    String nome = scanner.nextLine();
    // Aqui você pode solicitar outros detalhes do produto, como preço, descrição, etc.
    // Depois de obter todos os detalhes, crie um novo objeto Produto e adicione-o à lista
    Produto novoProduto = new Produto(nome);
    produtos.add(novoProduto);
    System.out.println("Produto \"" + novoProduto.getNome() + "\" adicionado com sucesso!");
}












// Opção para adicionar uma descrição a um produto existente
private static void adicionarDescricaoProduto(Scanner scanner, ArrayList<Produto> produtos) {
    if (produtos.isEmpty()) {
        System.out.println("Não há produtos cadastrados.");
        return; // Retorna ao menu de opções
    }

    // Exibe os produtos cadastrados com seus índices
    System.out.println("Produtos cadastrados:");
    for (int i = 0; i < produtos.size(); i++) {
        System.out.println((i + 1) + ". " + produtos.get(i).getNome());
    }

    int indice;
    while (true) {
        // Solicita ao usuário que selecione o índice do produto ao qual deseja adicionar a descrição (ou digite 'voltar' para retornar à tela de seleção)
        System.out.print("Selecione o número do produto ao qual deseja adicionar a descrição (ou digite 'voltar' para retornar à tela de seleção): ");
        String input = scanner.nextLine();

        // Verifica se o usuário digitou "voltar" para retornar
        if (input.equalsIgnoreCase("voltar")) {
            System.out.println("Retornando para a tela de seleção...");
            return; // Retorna ao menu de opções
        }

        // Tenta converter a entrada do usuário em um número
        try {
            indice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, insira um número de produto válido ou 'voltar'.");
            continue;
        }

        // Verifica se o índice selecionado é válido
        if (indice < 1 || indice > produtos.size()) {
            System.out.println("Índice inválido. Por favor, insira um número de produto válido ou 'voltar'.");
            continue;
        }

        break; // Sai do loop se o índice for válido
    }

    // Solicita ao usuário a descrição para o produto
    System.out.print("Digite a descrição para o produto (ou digite 'voltar' para retornar à tela de seleção): ");
    String descricao = scanner.nextLine();

    // Verifica se o usuário digitou "voltar" para retornar
    if (descricao.equalsIgnoreCase("voltar")) {
        System.out.println("Retornando para a tela de seleção...");
        return; // Retorna ao menu de opções
    }

    // Define a descrição para o produto selecionado
    Produto produto = produtos.get(indice - 1);
    produto.setDescricao(descricao);

    System.out.println("Descrição adicionada ao produto com sucesso!");
}











// Opção para remover um produto existente
private static void removerProduto(Scanner scanner, ArrayList<Produto> produtos) {
    if (produtos.isEmpty()) {
        System.out.println("Não há produtos cadastrados para remover.");
        return; // Retorna ao menu de opções// Retorna ao menu de opções
    }

    // Exibe os produtos cadastrados com seus índices
    System.out.println("Produtos cadastrados:");
    for (int i = 0; i < produtos.size(); i++) {
        System.out.println((i + 1) + ". " + produtos.get(i).getNome());
    }

    // Solicita ao usuário que selecione o índice do produto a ser removido
    System.out.print("Selecione o número do produto que deseja remover (ou digite 'voltar' para retornar): ");
    String input = scanner.nextLine();

    if (input.equalsIgnoreCase("voltar")) {
        return; // Retorna ao menu de opções
    }

    try {
        int indice = Integer.parseInt(input);
        // Verifica se o índice selecionado é válido
        if (indice < 1 || indice > produtos.size()) {
            System.out.println("Índice inválido.");
            return;
        }
    
        // Remove o produto selecionado
        Produto produtoRemovido = produtos.remove(indice - 1);
        System.out.println("Produto \"" + produtoRemovido.getNome() + "\" removido com sucesso!");
    } catch (NumberFormatException e) {
        System.out.println("Entrada inválida. Por favor, digite um número válido ou 'voltar'.");
    }
}
}
}