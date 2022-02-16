public class Square extends RegularShape{
    private int edgeLength;
    
    public Square(int edgeLength){
        super(4, edgeLength);
    }

    @Override
    public void calculateArea(){
        this.area = this.getEdgeLength() * this.getEdgeLength();
    }
}