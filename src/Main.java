
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        ArrayList<Pessoa> pessoasImcNormal = new ArrayList<>();
        ArrayList<Pessoa> pessoasImcAbaixo = new ArrayList<>();
        ArrayList<Pessoa> pessoasImcAcima = new ArrayList<>();

        System.out.println("\nClínica Vida - Cuidando da sua saúde!\n" +
                "\nUsaremos os dados informados para calcular seu IMC.\n" +
                "Vamos dizer a você, se está dentro do peso ideal!\n" +
                "Preparado(a)? Então vamos lá!");

        for(int i=0;i <5;i++) {
            System.out.println("\nInforme o NOME da pessoa " + (i+1));
            String nome = sc.next();
            System.out.println("\nOlá " + nome + ", informe o seu PESO em kg, separando por vírgula." +
                    " \nExemplo: 68,00 ");
            float peso = sc.nextFloat();
            System.out.println("Muito bem " + nome + "! agora informe a sua ALTURA " +
                    "\nUse vírgula para separar a altura dos centímetros. " +
                    "\nExemplo: 1,61 ");
            float altura = sc.nextFloat();

            Pessoa pessoa = new Pessoa(nome, peso, altura);
            float imc = pessoa.getImc();

            System.out.print("Seu IMC é de ");
            System.out.printf("%.2f", imc);
            System.out.println("");

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

        if(pessoasImcAbaixo.size() >0 | pessoasImcAcima.size() > 0){
            System.out.println("\nPessoas fora de seu peso ideal.");
        }else{
            System.out.println("\nParabéns!! Segundo o resultado dos IMC's, todos estão dentro do peso ideal.");
        }
       for (int i=0; i < pessoasImcAbaixo.size(); i++ ){
           System.out.println(pessoasImcAbaixo.get(i).getNome());
       }
        for (int i=0; i < pessoasImcAcima.size(); i++ ){
            System.out.println(pessoasImcAcima.get(i).getNome());
        }
    }

}

