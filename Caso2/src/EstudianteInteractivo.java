import java.util.Scanner;

public class EstudianteInteractivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la edad del estudiante: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingrese la carrera del estudiante: ");
        String carrera = scanner.nextLine();

        Estudiante estudiante = new Estudiante(nombre, edad, carrera);

        System.out.println("\n--- Datos del Estudiante ---");
        System.out.println("Nombre: " + estudiante.getNombre());
        System.out.println("Edad: " + estudiante.getEdad());
        System.out.println("Carrera: " + estudiante.getCarrera());

        scanner.close();
    }
}
