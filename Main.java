
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Scanner;
public class Main {

    public static List<Genero> listadeGeneros = new ArrayList<>();
    public static List<Filme> listadeFilmes = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);




        boolean i = true;

        while(i){
            System.out.println("1.Cadastrar Genero");
            System.out.println("2.Cadastrar Filme");
            System.out.println("3.Listar Generos");
            System.out.println("4.Listar Filmes");
            System.out.println("5.Encerrar sistema");

            int es = sc.nextInt();
            switch (es){
                case 1:
                    Genero genero = new Genero();
                    System.out.println("Digite a descrição do genero:");
                    genero.setDescricao(sc.next());
                    System.out.println("Digite o codigo do gênero");
                    genero.setCodigo(sc.nextInt());
                    System.out.println("Genero cadastrado com sucesso!");
                    listadeGeneros.add(genero);
                    break;

                case 2:

                    if(listadeGeneros.isEmpty()){
                    System.out.println("Nenhum Genero cadastrado!");
                    System.out.println("Cadastre um gênero para poder atrela-lo a um fime!");
                    break;
                }
                    Filme filme = new Filme();
                    System.out.println("Digite o nome do filme");
                    filme.setNome(sc.next());
                    sc.nextLine();
                    System.out.println("Digite a duração do filme");
                    filme.setDuracao(sc.nextLine());
                    System.out.println("Generos cadastrados no sistema:");


                    for(Genero gen : listadeGeneros){
                        System.out.println(gen.getCodigo() + "-" + gen.getDescricao());
                    }
                    System.out.println("Digite o codigo do genero acima que deseja atrelar ao filme " + filme.getNome());
                    int cd = sc.nextInt();

                    boolean generoEncontrado = false;
                    for(Genero gen: listadeGeneros){
                        if(cd == gen.getCodigo()){
                            filme.setGenero(gen);
                            System.out.println("Filme cadastrado com sucesso!!");
                            listadeFilmes.add(filme);
                            generoEncontrado = true;
                            break;
                        }



                    }
                    if(!generoEncontrado){
                    System.out.println("Codigo digitado invalido!");
                    System.out.println("Retornando ao menu...");

                    }
                    break;

                    case 3:
                        if(listadeGeneros.isEmpty()){
                            System.out.println("========Nenhum Genero cadastrado========");
                            break;
                        }
                        System.out.println("Lista de gêneros");
                        System.out.println("------------------------");
                        for(Genero gen : listadeGeneros){
                            System.out.println(gen.getCodigo() + "-" + gen.getDescricao());
                        }
                        System.out.println("------------------------");
                        break;

                    case 4:
                        if(listadeFilmes.isEmpty()){
                            System.out.println("========Nenhum Filme cadastrado========");
                            break;
                        }
                        System.out.println("Lista de filmes");
                        for(Filme filme1 : listadeFilmes){
                            System.out.println("______________________________________________");
                            System.out.println("nome: " + filme1.getNome());
                            System.out.println("duracao: " + filme1.getDuracao());
                            System.out.println("Genero: " + filme1.getGenero().getDescricao());
                            System.out.println("______________________________________________");
                        }
                        break;


                    case 5:
                        System.out.println("Sistema Encerrado com sucesso!");
                        i = false;
                        break;
                default:
                    System.out.println("Digite uma opção valida!!");
                    break;
            }


        }



    }
}