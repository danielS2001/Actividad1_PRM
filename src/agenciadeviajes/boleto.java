/*
    Alumno: Daniel Saenz Apodaca. Grupo: 9-3.
    Clase "Boleto".
 */

package agenciadeviajes;

import java.util.Scanner;

public class boleto {
    //Atributos
    private int numeroDeBoleto;
    private String nombreDeCliente;
    private String destino;
    private int tipoDeViaje;
    private String fecha;
    private float precio;
    
    private double impuesto;
    private double descuento;
    private double subTotal;
    private double total;
    
    //Constructores
    public boleto() { //Constructor vacío.
        this.numeroDeBoleto = 0;
        this.nombreDeCliente = "";
        this.destino = "";
        this.tipoDeViaje = 0;
        this.fecha = "";
        this.precio = 0.0f;
    }
    
    public boleto(int numeroDeBoleto, String nombreDeCliente, String destino,  //Constructor de parametros
        int tipoDeViaje, String fecha, float precio) {
        this.numeroDeBoleto = numeroDeBoleto;
        this.nombreDeCliente = nombreDeCliente;
        this.destino = destino;
        this.tipoDeViaje = tipoDeViaje;
        this.fecha = fecha;
        this.precio = precio;
    }
    
    public boleto (boleto tickets) { //Constructor de copia
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
    
    public void calcularSubTotal() {
        if(this.tipoDeViaje==1) subTotal = this.precio;
        if(this.tipoDeViaje==2) subTotal = this.precio*1.8f;
    }
    
    public void sacarDescuento(int edad) {
        if (edad >= 60) {
            descuento = (subTotal) /2;
        }
    }
    
    public void sacarImpuesto() {
        impuesto = subTotal *.16;
        subTotal = subTotal + impuesto;
    }
    
    public void sacarTotal() {
        total = subTotal - descuento;
    }
    
    public void imprimirBoleto() {
        System.out.println("-----------------------------------------------");
        System.out.println("Numero de boleto " +numeroDeBoleto);
        System.out.println("Nombre del cliente " +nombreDeCliente);
        System.out.println("Destino " +destino);
        System.out.println("Tipo de Viaje " +tipoDeViaje);
        System.out.println("Fecha " +fecha);
        System.out.println("El subtotal es de: " +(subTotal-impuesto));
        System.out.println("Impuesto "+impuesto);
        System.out.println("El descuento es igual a: " +descuento);
        System.out.println("Total a pagar " +total);
    }
}
