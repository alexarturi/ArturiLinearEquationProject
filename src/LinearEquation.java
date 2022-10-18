public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double distance(){
        double xDistance = Math.abs(x1-x2);
        double yDistance = Math.abs(y1-y2);
        double unRounded = Math.sqrt(Math.pow(xDistance, 2.0) + Math.pow(yDistance, 2.0));
        return roundedToHundredth(unRounded);
    }

    public double yIntercept(){
        return y1-(slope()*x1);
    }

    public double slope(){
        double yDifference = y2 - y1;
        double xDifference = x2 - x1;
        return roundedToHundredth(yDifference/xDifference);
    }

    public String equation(){
        String slope = "";
        String yInt;

        int yDifference = y2 - y1;
        int xDifference = x2 - x1;
        if (slope()*10%10==0){
            if(slope()==1.0){
                slope += "";
            } else if (slope() == -1.0){
                slope += "-";
            } else {
                slope += (int)(slope());
            }
        } else {
            if(yDifference <0 && xDifference>0){
                slope += yDifference + "/" + xDifference;
            } else if (yDifference>0 && xDifference>0){
                slope += yDifference + "/" + xDifference;
            } else if(yDifference>0 && xDifference <0){
                slope += "-" + yDifference + "/" + Math.abs(xDifference);
            } else if (yDifference<0 && xDifference<0){
                slope += Math.abs(yDifference) + "/" + Math.abs(xDifference);
            } else {
                return "";
            }
        }

        if (yIntercept() <0){
            yInt = "- " + Math.abs(yIntercept());
        } else if(yIntercept()>0){
            yInt = "+ " + Math.abs(yIntercept());
        } else{
            yInt = "";
        }

        return "y = " + slope+"x "+ yInt;
    }


    public double roundedToHundredth(double toRound){
        return Math.round(toRound*100)/100.0;
    }
}
