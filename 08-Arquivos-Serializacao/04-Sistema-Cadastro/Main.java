package exercicios.beluzo.ex28;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Pessoa> pessoa = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        int opcao;
        
        do {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Cadastro");
            System.out.println("2. Listagem de Pessoas");
            System.out.println("0. Sair");
            
            System.out.print("\nDigite a opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = sc.nextLine();
                    
                    System.out.print("Digite a idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    
                    Pessoa p = new Pessoa(nome, idade);
                    pessoa.add(p);
                    
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pessoa.ser"));
                    
                    oos.writeObject(pessoa);
                    
                    oos.close();
                    
                    System.out.println("\nPessoa cadastrada com sucesso!\n");
                    break;
                    
                case 2:
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pessoa.ser"));
                    
                    pessoa = (ArrayList<Pessoa>) ois.readObject();
                    
                    ois.close();
                    
                    System.out.println("\n--- LISTA DE PESSOAS DO ARQUIVO ---");
                    for (Pessoa item : pessoa) {
                        System.out.println(item); 
                        System.out.println("-----------------------------------");
                    }
                    break;
                    
                case 0:
                    System.out.println("Você saiu!");
                    break;
                    
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }while(opcao != 0);
    }
}
