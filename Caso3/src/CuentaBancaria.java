import java.util.Scanner;

public class CuentaBancaria {
    private String titular;
    private double saldo;

    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("✅ Depósito exitoso.");
        } else {
            System.out.println("⚠️ El monto debe ser mayor a cero.");
        }
    }

    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("✅ Retiro exitoso.");
        } else {
            System.out.println("❌ Fondos insuficientes o monto inválido.");
        }
    }

    public void mostrarInformacion() {
        System.out.println("\n--- Información de la cuenta ---");
        System.out.println("👤 Titular: " + titular);
        System.out.println("💰 Saldo actual: $" + saldo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese nombre del titular: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        CuentaBancaria cuenta = new CuentaBancaria(nombre, saldoInicial);

        String continuar;
        do {
            System.out.println("\n=== Menú de Operaciones ===");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Mostrar información");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el monto a depositar: ");
                    double deposito = scanner.nextDouble();
                    cuenta.depositar(deposito);
                    break;
                case 2:
                    System.out.print("Ingrese el monto a retirar: ");
                    double retiro = scanner.nextDouble();
                    cuenta.retirar(retiro);
                    break;
                case 3:
                    cuenta.mostrarInformacion();
                    break;
                case 4:
                    System.out.println("👋 Gracias por usar el sistema.");
                    scanner.close();
                    return; // Salir del programa
                default:
                    System.out.println("⚠️ Opción inválida.");
            }

            // Mostrar datos después de cada operación
            cuenta.mostrarInformacion();

            // Preguntar si desea continuar
            scanner.nextLine(); // Limpiar buffer
            System.out.print("\n¿Desea realizar otra operación? (S/N): ");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("S"));

        System.out.println("👋 Gracias por usar el sistema. ¡Hasta luego!");
        scanner.close();
    }
}
