
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Pessoa> pessoasImcNormal = new ArrayList<>();
    static ArrayList<Pessoa> pessoasImcAbaixo = new ArrayList<>();
    static ArrayList<Pessoa> pessoasImcAcima = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){

        boasVindas();

        for(int i=0;i <5;i++) {
            String nome = nome(i);
            float peso = peso(nome);
            float altura = altura(nome);
            Pessoa pessoa = criarPessoa(nome, peso, altura);
            float imc = pessoa.getImc();
            mostraImc(imc);
            definindoImc(pessoa);
        }

        mostraResultadoImc();
        pessoasForaDoPesoIdeal();

    }

    public static Pessoa criarPessoa(String nome, float peso, float altura){
        Pessoa pessoa = new Pessoa(nome, peso, altura);
        return pessoa;
    }

    public static String nome(int i){
        System.out.println("\nInforme o NOME da pessoa " + (i+1));
        String nome = sc.next();
        //TODO while( se o nome, ou melhor, os caracteres forem  letras ok , agora se tiver numeros, não ok) Validar nome
//        System.out.println("Seus caracteres estão incorretos, favor digitar apenas letras");
        return nome;
    }

    public static float peso(String nome){
        System.out.println("\nOlá " + nome + ", informe o seu PESO em kg, separando por vírgula." +
                " \nExemplo: 68,00 ");
        float peso = verificandoNumero();
        return peso;
    }

    public static float altura(String nome){
        System.out.println("Muito bem " + nome + "! agora informe a sua ALTURA " +
                "\nUse vírgula para separar a altura dos centímetros. " +
                "\nExemplo: 1,61 ");
        float altura = verificandoNumero();
                 //TODO while/ try catch( se o nome, ou melhor, os caracteres forem  numeros ok , senão lanças execção e validar a virgula
//        System.out.println("Seus caracteres estão incorretos, favor digitar apenas números");
        return altura;
    }

    public static void mostraImc(float imc){
        System.out.print("Seu IMC é de " );
        System.out.printf("%.2f", imc);
        System.out.println("");
    }

    public static void definindoImc(Pessoa pessoa){
        float imc = pessoa.getImc();
        if(imc > 18.4 && imc < 26){
            pessoasImcNormal.add(pessoa);
            System.out.print("IMC dentro do normal\n");
        }else if (imc < 18.5){
            pessoasImcAbaixo.add(pessoa);
            System.out.print("IMC abaixo do Normal\n");
        }else {
            pessoasImcAcima.add(pessoa);
            System.out.println("IMC acima do Normal\n");
        }
    }

    public static void mostraResultadoImc(){
        if(pessoasImcAbaixo.size() >0 | pessoasImcAcima.size() > 0){
            System.out.println("\nPessoas fora de seu peso ideal, segundo os resultados de IMC's.");
        }else{
            System.out.println("\nParabéns!! Segundo os resultado de IMC's, todos estão dentro do peso ideal.");
        }
    }

    public static void mostraPessoaImcAbaixo(){
        for (int i=0; i < pessoasImcAbaixo.size(); i++ ){
            System.out.println(pessoasImcAbaixo.get(i).getNome());
        }
    }

    public static void mostraPessoaImcAcima() {
        for (int i = 0; i < pessoasImcAcima.size(); i++) {
            System.out.println(pessoasImcAcima.get(i).getNome());
        }
    }

    public static void pessoasForaDoPesoIdeal(){
        mostraPessoaImcAbaixo();
        mostraPessoaImcAcima();
    }

    public static void boasVindas(){
        System.out.println("\nClínica Vida - Cuidando da sua saúde!\n" +
                "\nUsaremos os dados informados para calcular seu IMC.\n" +
                "Vamos dizer a você, se está dentro do peso ideal!\n" +
                "Preparado(a)? Então vamos lá!");
    }

    public static boolean validaNumero(float numero){
        //TODO while/ try catch( se o nome, ou melhor, os caracteres forem  numeros ok , senão lançar execção e validar a virgula
        if(numero > 1 && numero <200.00){
            return true;
        }
        return false;
    }

    public static float verificandoNumero(){
        boolean verificado = true;
        float numero = 0;

        while(verificado){
            numero = sc.nextFloat();

            boolean validado = validaNumero(numero);
            if(!validado){
                System.out.println("Seus caracteres estão incorretos. Favor informe o seu PESO em kg, separando por vírgula " +
                        "\nExemplo: 68,00 ");
            }
            verificado = !validado;
        }
        return numero;



//        try {
//
//        }catch (Exception caractereErrado){
//            System.out.println("Caractére Errado! Aceita somente números. \nSepare números com vírgula após duas casas decimais");
//        }


    }




}


