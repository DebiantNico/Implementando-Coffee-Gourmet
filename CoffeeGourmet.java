import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Scanner;

public class CoffeeGourmet{

	private Catalog catalog;
    private Order order;
    private Sales sales;
	private static final String RUTA = "catalog.dat";
	private Scanner stdIn;

public CoffeeGourmet() {
    stdIn = new Scanner(System.in);
    catalog = llenarCatalog();
    order = new Order();
    sales = new Sales();
}

	public Coffee separaCafe(String dato){
		try {
			StringTokenizer st = new StringTokenizer(dato, "_");
			st.nextToken();
			Coffee cof = new Coffee(st.nextToken(), st.nextToken(), 
							Double.parseDouble(st.nextToken()), st.nextToken(),
							st.nextToken(), st.nextToken(), st.nextToken(),
							st.nextToken(),st.nextToken());
			return cof;				
			
		}catch (NumberFormatException nfe){
			System.err.println(" La entrada \" " + dato + " \" no es correcta");
		}		
		return null;		
	}
    
	
	public coffeeBrewer separaBrewer(String dato){
		try {
			String [] datos = dato.split("_");			
			coffeeBrewer brewer = new coffeeBrewer(datos[1], datos[2], 
							Double.parseDouble(datos[3]), datos[4],
							datos[5], Integer.parseInt(datos[6]));
			return brewer;				
		}catch (NumberFormatException nfe){
			System.err.println(" La entrada \" " + dato + " \" no es correcta");
		}
		return null;
		
	}
	
	public product separaProduct(String dato){
		try {
			String [] datos = dato.split("_");			
			product product = new product(datos[1], datos[2], 
							Double.parseDouble(datos[3]));
			return product;				
		}catch (NumberFormatException nfe){
			System.err.println(" La entrada \" " + dato + " \" no es correcta");
		}
		return null;
	}
//Nuevo
    public Catalog llenarCatalog(){
        Catalog cat = new Catalog();
        try (BufferedReader fileIn = new BufferedReader(new FileReader(RUTA))) {
            String linea;
            product prod;
            while ((linea = fileIn.readLine()) != null) {
                if (linea.startsWith("Coffee")) {
                    prod = separaCafe(linea);
                } else if (linea.startsWith("Brewer")) {
                    prod = separaBrewer(linea);
                } else {
                    prod = separaProduct(linea);
                }
                if (prod != null) {
                    cat.addProduct(prod);
                }
            }
        } catch (FileNotFoundException fne) {
            fne.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return cat;
    }

	private int menu(){
		while(true){
			try{
				System.out.print("[0] Quit \n[1] Display catalog \n[2] Display product "
								+ "\n[3] Display current order \n[4] Add|Modify product to|in current order \n[5] Remove product from current order" 
								+ "\n[6] Register sale of current order \n[7] Display sales"
								+ "\n[8] Display number of orders with a specific product "
								+ "\n[9] Display the total quantity sold for each product "
								+ "\nchoice> ");
				int op = Integer.parseInt(stdIn.nextLine());
				if (op >= 0 && op <=9){
					return op;
				} 
				throw new NumberFormatException();
			}catch (NumberFormatException nfe){
				System.err.println("Se espera un numero entre 0 y 9 ");
			}
		}
	}
	


	private void displayCatalog(){
		for (int i = 0; i < catalog.getNoProduct(); i++){
			System.out.println(catalog.getProduct(i).toString());
		}
	}
	
    private String solicitaCodigo(){
        System.out.println("Product code: ");
        String code = stdIn.nextLine();
        return code;
    
    }

    private void displayProduct(){
        String code = solicitaCodigo();
        product prod = catalog.getProduct(code);
        if (prod != null){
            System.out.println(prod);
        } else {
            System.out.println(code + " no existe ");
        }
    }
//N	
    private void displayOrder(){
        int size = order.getNoItems();
        if (size == 0) {
            System.out.println("No hay productos en la orden");
        } else {
            for (int i = 0; i < size; i++) {
                OrderItem item = order.getItem(i);
                if(item != null){
                    System.out.println(item.toString());
                }
             }
        System.out.println("Total: " + NumberFormat.getCurrencyInstance().format(order.getTotalCost()));
        }    
}
   //N
    private void addModifyProduct(){
        String code = solicitaCodigo();
        product prod = catalog.getProduct(code);
        if (prod != null) {
            System.out.println("Quantity: ");
            int quantity = Integer.parseInt(stdIn.nextLine());
            OrderItem item = order.getItem(code);
            if (item != null) {
                item.setQuantity(quantity);
                System.out.println("Se modifico la cantidad de " + code);
            } else {
                order.addOrderItem(new OrderItem(prod, quantity));
                System.out.println("Se agrego " + code + " a la orden");
            }
        } else {
            System.out.println(code + " no existe ");
        }
    }
//N
    private void removeProduct(){
        String code = solicitaCodigo();
        OrderItem orderItem = order.getItem(code);
        if (orderItem != null) {
            order.removeOrderItem(orderItem);
            System.out.println("Se removio " + code + " de la orden");
        } else {
            System.out.println(code + " no existe ");
        }
    }
//N
    private void registerSale(){
        if(order.getNoItems() > 0){
         sales.addOrder(order);
                System.out.println("Se registro la venta");
             order = new Order(); //reinicia la orden
      } else {
          System.out.println("No hay productos en la orden");
       }
    }
//N
private void displaySales() {
        int numOrder = sales.getNoOrders();
        if (numOrder != 0) {
            int orderNumber = 1;
            for (Order order : sales) {
                System.out.println("Order: " + orderNumber++);
                for (int i = 0; i < order.getNoItems(); i++) {
                    System.out.println("  " + order.getItem(i).toString());
                }
                System.out.println(" Total: " + NumberFormat.getCurrencyInstance().format(order.getTotalCost()));
            }
        } else {
            System.out.println("There are no sales");
        }
    }
//N
    private void displayNumOrders(){
        String code = solicitaCodigo();
        int numOrders = sales.countOrdersWithProduct(code);
        System.out.println("Numero de ordenes con " + code + ": " + numOrders);
    }
//N
    private void displayTotalQuantitySold(){
        for (int i = 0; i < catalog.getNoProduct(); i++){
            product prod = catalog.getProduct(i);
            int totalQuantity = sales.totalQuantitySold(prod.getCode());
            System.out.println(prod.getCode() + ": " + totalQuantity);
        }
    }


	public void principal(){
		catalog = llenarCatalog();
		int op = 0;
		do{
			op = menu();
			switch (op) {
				case 1: 
					displayCatalog();
					break;
                case 2:
                    displayProduct();
                    break;
                case 3: 
					displayOrder();
					break;
                case 4:
                    addModifyProduct();
                    break;
                case 5: 
					removeProduct();
					break;
                case 6:
                    registerSale();
                    break;
                case 7: 
					displaySales();
					break;
                case 8:
                    displayNumOrders(); 
                break;

                case 9:
               displayTotalQuantitySold();
                break;
			}
		}while (op != 0);
	}
	
	public static void main(String [] args){
		CoffeeGourmet cG = new CoffeeGourmet();
		cG.principal();
		
	}


}
