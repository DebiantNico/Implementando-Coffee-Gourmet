public class product {
    
    private String code;
    private String description;
    private double price;

    public product(String newcode, String newdescription, double newprice){
        this.code = newcode;
        this.description = newdescription;
        this.price = newprice;
    }

    public void setDescription8(String newDescription){
        this.description = newDescription;
    }

    public String getDescription(){
        return this.description;
    }

    public void setPrice(double newPrice){
        this.price = newPrice;
    }

    public Double getPrice(){
        return this.price;
    }

    public String getCode(){
        return this.code;
    }
    @Override
    public String toString(){
        return "product [code: "+ code +"description: "+ description + "price:" + price+ "]";
    }
}