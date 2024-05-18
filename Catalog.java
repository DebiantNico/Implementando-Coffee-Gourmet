public class Catalog {
    
    private product[] products;
    private int indice;
    
    public Catalog(){
        indice = 0;
        products = new product[3];
    }
    public void addProduct(product product){
        if (indice == products.length){
            product [] tmp = new product[products.length + 1];
            for (int i = 0; i < indice; i++){
                tmp[i] = products[i];
            }
            products = tmp;
    }
    //     posición    Parametro
    products[indice] = product;   
    indice = indice + 1;
    }
    public int getNoProduct() {
        return products.length;
    }
    public product getProduct(int pos) {
        if(pos < products.length) {
            return products[pos];	
        }
        return null;
    }

    public product getProduct(String code){
        for (product product : products){
            if (product.getCode().equals(code)){
                return product;
            }
        }
        return null;
    }
    }