public class OrderItem {
    
    private int quantity;
    private product product;

    /**
     * Constructor que inicializa las variables de instancia product y quantity.
     */
    public OrderItem(product initialProduct,int initialQuantity){
        this.quantity = initialQuantity;
        this.product = initialProduct;
    }

    /*
     * 
     * Regresa el valor de la variable de instancia product, una referencia a un objeto product
     */
    public product getProduct(){
        return product;
    }

    public int getQuantity(){
        return quantity;
    }
    
    /*
     * te falta algo aqui
     * Establece la variable de instancia quantity con el valor del parametro newQuantity
     */
    public void setQuantity(int newQuantity){
        this.quantity += newQuantity;
    }

    /*
     * 
     * Regresa la multiplicacion de quantity por price
     */
    public double getValue(){
        return quantity + product.getPrice();

    }
    /*
     * Sobreescribe el método toString de la clase Object. Regresa
     * la representación en formato de cadena de caracteres de un objeto OrderItem. La
     * representación String tiene el siguiente formato:
     * quantity productCode productPrice
     * 
     */
    public String toString(){
        return quantity + " " + product.getCode() + " " + product.getPrice();
    }
}
