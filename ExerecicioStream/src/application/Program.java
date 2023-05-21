package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.function.DoublePredicate;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entre como o endereço do arquivo: ");
        String fileTxt = sc.next();

        System.out.println();
        System.out.println("Lista de funcionarios e seus dados:");

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileTxt));
            String line = br.readLine();
            while (line != null){
                String[] field = line.split(",");
                String name = field[0];
                String email = field[1];
                double salary = Double.parseDouble(field[2]);

                System.out.println("Nome: " + name + ", E-mail: " + email + ", Salary: $" + salary);

                line = br.readLine();
            }

            System.out.println();
            System.out.print("Entre com o salario que deseja comparar: ");
            double salaryComp = sc.nextDouble();
            System.out.println("Email dos funcionarios com salario acima de $" + String.format("%.2f",salaryComp));

        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }




        sc.close();
    }
}
