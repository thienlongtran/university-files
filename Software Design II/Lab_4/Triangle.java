public class Triangle extends RegularShape{
    public Triangle(int edgeLength){
        super(3, edgeLength);
    }

    @Override
    public void calculateArea(){
        this.area = (Math.sqrt(3)/4) * Math.pow(this.getEdgeLength(),2);
    }
}