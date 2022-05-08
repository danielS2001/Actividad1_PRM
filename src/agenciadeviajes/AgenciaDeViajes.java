/*
    Alumno: Daniel Saenz Apodaca. Grupo: 9-3.
    Clase principal "Agencia de Viajes".
 */
package agenciadeviajes;

import java.util.Scanner;

public class AgenciaDeViajes {

    public static void main(String[] args) {
        Scanner b = new Scanner(System.in);
        boleto boletos = new boleto(); //Instanciar un objeto usando la clase.
        boletos.capturarDatos();
        System.out.print("Capture la edad: ");
        int edad = b.nextInt(); b.nextLine();
        boletos.calcularSubTotal();
        boletos.sacarImpuesto();
        boletos.sacarDescuento(edad);
        boletos.sacarTotal();
        boletos.imprimirBoleto();
    }
    
}
