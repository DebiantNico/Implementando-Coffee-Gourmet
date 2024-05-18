public class coffeeBrewer extends product{
    private String model;
    private String waterSupply;
    private int numberOfCups;
 
 
    public coffeeBrewer(String code, String description, double price,
     String model, String waterSupply, int numberOfCups){
        super(code, description, price);
        this.model = model;
        this.waterSupply = waterSupply;
        this.numberOfCups = numberOfCups;
 }
 
 public void setModel(String newModel){
     this.model = newModel;
 }
 
 public String getModel(){
     return this.model;
 } 
 
 public void setWaterSupply(String newWaterSupply){
     this.waterSupply = newWaterSupply;
 }
 
 public String getWaterSupply(){
     return this.waterSupply;
 }
 
 public void setNumberOfCups(int newNumberOfCups){
     this.numberOfCups = newNumberOfCups;
 }
 
 public int getNumberOfCups(){
     return this.numberOfCups;
 }
 @Override
 public String toString(){
     return "coffee [code:" + getCode() + "description:" + getDescription() + "price:" + getPrice()+ "model" + getModel() + "waterSupply:" + getWaterSupply() + "numerOfCups:" + getNumberOfCups() +"]";
 }

 }