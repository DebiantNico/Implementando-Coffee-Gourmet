public class Coffee extends product{
    private String origin;
    private String roast;
    private String flavor;
    private String aroma;
    private String acidity;
    private String body;

    public Coffee(String code, String description, 
    double price, String origin, String roast, 
    String flavor, String aroma, String acidity, String body){
        super(code, description, price);
        this.origin = origin;
        this.roast = roast;
        this.flavor = flavor;
        this.aroma = aroma;
        this.acidity = acidity;
        this.body = body;
    }

    public void setOrigin(String newOrigin){
        this.origin = newOrigin;
    }

    public String getOrigin(){
        return this.origin;
    }
    
    public void setRoast(String newRoast){
        this.roast = newRoast;
    }

    public String getRoast(){
        return this.roast;
    }
    public void setFlavor(String newFlavor){
        this.flavor = newFlavor;
    }

    public String getFlavor(){
        return this.flavor;
    }
    public void setAroma(String newAroma){
        this.aroma = newAroma;
    }

    public String getAroma(){
        return this.aroma;
    }
    public void setAcidity(String newAcidity){
        this.acidity = newAcidity;
    }

    public String getAcidity(){
        return this.acidity;
    }
      public void setBody(String newBody){
        this.body = newBody;
    }

    public String getBody(){
        return this.body;
    }
    @Override
    public String toString(){
        return "coffee [ code: "+ this.getCode() + "description: "+ this.getDescription() + "price: "+ this.getPrice() + "origin: "+ this.origin + "roast: " + this.roast + "flavor:" + this.flavor + "aroma:" + this.aroma + "acidity:" + this.acidity + "body:" + this.body +"]";
    }
}
