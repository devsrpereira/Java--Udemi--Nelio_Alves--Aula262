package application;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.DoublePredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        System.out.println("Entre como o endereço do arquivo: ");
        String fileTxt = sc.next();

        System.out.println();
        System.out.println("Lista de funcionarios e seus dados:");

        try {
            List<Employee> employeeList = new ArrayList<>();

            BufferedReader br = new BufferedReader(new FileReader(fileTxt));
            String line = br.readLine();
            while (line != null){
                String[] field = line.split(",");
                String name = field[0];
                String email = field[1];
                double salary = Double.parseDouble(field[2]);
                Employee employee = new Employee(name,email,salary);
                employeeList.add(employee);

                System.out.println("Nome: " + name + ", E-mail: " + email + ", Salary: $" + salary);

                line = br.readLine();
            }

            System.out.println();
            System.out.print("Entre com o salario que deseja comparar: ");
            double salaryComp = sc.nextDouble();
            System.out.println("Email dos funcionarios com salario acima de $" + String.format("%.2f",salaryComp) + ":");

            Comparator<String> comp = (s1,s2) -> s1.compareTo(s2);

            List<String> st1 = employeeList.stream()
                    .filter(e -> e.getSalary() > salaryComp)
                    .map(e -> e.getEmail())
                    .sorted(comp)
                    .collect(Collectors.toList());
            st1.forEach(System.out::println);

            double sum = employeeList.stream()
                    .filter(e -> e.getName().charAt(0) == 'M')
                    .map(e -> e.getSalary())
                    .reduce(0.0,(x,y) -> x + y);

//            for (Employee employee : employeeList) {
//                sum = employee.getName().charAt(0) == 'M' ? sum += employee.getSalary() : sum;
//            }

            System.out.println("Soma salarial dos funcionarios que começam com M: $" + String.format("%.2f",sum));

        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }




        sc.close();
    }
}
