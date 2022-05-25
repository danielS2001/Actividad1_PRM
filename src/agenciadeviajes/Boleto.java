/*
    Alumno: Daniel Saenz Apodaca. Grupo: 9-3.
    Clase "Boleto".
 */

package agenciadeviajes;

import java.util.Scanner;

public class Boleto {
    //Atributos
    private int numeroDeBoleto;
    private String nombreDeCliente;
    private String destino;
    private int tipoDeViaje;
    private String fecha;
    private float precio;
    
    //Constructores
    public Boleto() { //Constructor vacío.
        this.numeroDeBoleto = 0;
        this.nombreDeCliente = "";
        this.destino = "";
        this.tipoDeViaje = 0;
        this.fecha = "";
        this.precio = 0.0f;
    }
    
    public Boleto(int numeroDeBoleto, String nombreDeCliente, String destino,  //Constructor de parametros
        int tipoDeViaje, String fecha, float precio) {
        this.numeroDeBoleto = numeroDeBoleto;
        this.nombreDeCliente = nombreDeCliente;
        this.destino = destino;
        this.tipoDeViaje = tipoDeViaje;
        this.fecha = fecha;
        this.precio = precio;
    }
    
    public Boleto (Boleto tickets) { //Constructor de copia
        this.numeroDeBoleto = tickets.numeroDeBoleto;
        this.nombreDeCliente = tickets.nombreDeCliente;
        this.destino = tickets.destino;
        this.tipoDeViaje = tickets.tipoDeViaje;
        this.fecha = tickets.fecha;
        this.precio = tickets.precio;
    }

    /**
     * @return the numeroDeBoleto
     */
    public int getNumeroDeBoleto() {
        return numeroDeBoleto;
    }

    /**
     * @param numeroDeBoleto the numeroDeBoleto to set
     */
    public void setNumeroDeBoleto(int numeroDeBoleto) {
        this.numeroDeBoleto = numeroDeBoleto;
    }

    /**
     * @return the nombreDeCliente
     */
    public String getNombreDeCliente() {
        return nombreDeCliente;
    }

    /**
     * @param nombreDeCliente the nombreDeCliente to set
     */
    public void setNombreDeCliente(String nombreDeCliente) {
        this.nombreDeCliente = nombreDeCliente;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return the tipoDeViaje
     */
    public int getTipoDeViaje() {
        return tipoDeViaje;
    }

    /**
     * @param tipoDeViaje the tipoDeViaje to set
     */
    public void setTipoDeViaje(int tipoDeViaje) {
        this.tipoDeViaje = tipoDeViaje;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    //Funciones
    public void capturarDatos() {
        Scanner b = new Scanner(System.in);
        System.out.print("Escriba el numero del boleto: ");
        numeroDeBoleto = b.nextInt(); b.nextLine();
        System.out.print("Escriba el nombre del cliente: ");
        nombreDeCliente = b.nextLine();
        System.out.print("Escriba el destino: ");
        destino = b.nextLine();
        System.out.print("Escriba el tipo de viaje. 1. Sencillo, 2. Doble: ");
        tipoDeViaje = b.nextInt(); b.nextLine();
        System.out.print("Escriba la fecha: ");
        fecha = b.nextLine();
        System.out.print("Escriba el precio: ");
        precio = b.nextFloat(); b.nextLine();
    }
    
    public double calcularSubTotal() {
        double subTotal = 0;
        if(this.tipoDeViaje==1) subTotal = this.precio;
        if(this.tipoDeViaje==2) subTotal = this.precio*1.8f;
        return subTotal;
    }
    
    public double sacarDescuento(int edad) {
        double descuento = 0;
        if (edad >= 60) {
            descuento = (calcularSubTotal()) /2;
        }
        return descuento;
    }
    
    public double sacarImpuesto() {
        double impuesto = 0;
        double subTotal = calcularSubTotal();
        impuesto = subTotal *.16;
        subTotal = subTotal + impuesto;
        return impuesto;
    }
    
    public double sacarTotal() {
        double total = 0;
        total = calcularSubTotal() - sacarDescuento(80);
        return total;
    }
    
    public void imprimirBoleto() {
        System.out.println("-----------------------------------------------");
        System.out.println("Numero de boleto " +numeroDeBoleto);
        System.out.println("Nombre del cliente " +nombreDeCliente);
        System.out.println("Destino " +destino);
        System.out.println("Tipo de Viaje " +tipoDeViaje);
        System.out.println("Fecha " +fecha);
        System.out.println("El subtotal es de: " +(calcularSubTotal()-sacarImpuesto()));
        System.out.println("Impuesto "+sacarImpuesto());
        System.out.println("El descuento es igual a: " +sacarDescuento(80));
        System.out.println("Total a pagar " +sacarTotal());
    }
    
    
}
