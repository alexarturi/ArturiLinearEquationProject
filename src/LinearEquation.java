public class LinearEquation {

    //instance variables
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        //creates an instance of the class
    }

    public double distance(){
        double xDistance = Math.abs(x1-x2);
        double yDistance = Math.abs(y1-y2);
        double unRounded = Math.sqrt(Math.pow(xDistance, 2.0) + Math.pow(yDistance, 2.0));
        return roundedToHundredth(unRounded);
        //uses the pythagorean theorem to calculate the distance between two points rounded to the nearest hundredth
    }

    public double yIntercept(){
        return y1-(slope()*x1);
        //algebraically finds the y-intercept using a set of provided coordinates
    }

    public double slope(){
        double yDifference = y2 - y1;
        double xDifference = x2 - x1;
        return roundedToHundredth(yDifference/xDifference);
        //calculates slope by yChange over xChange
    }

    public String equation(){
        String slope = "";
        String yInt;
        //creates strings for slope and y-int to make sense of double negatives and negative exceptions

        int yDifference = y2 - y1;
        int xDifference = x2 - x1;
        if (slope()*10%10==0){ //checks if slope is a whole number
            if(slope()==1.0){
                slope += "";//if slope is 1, no coefficient is needed for x
            } else if (slope() == -1.0){
                slope += "-";//if slope is -1, only thing needed before x is negative symbol
            } else {
                slope += (int)(slope()); //if x is a whole number but not 1 or -1, just use the int value
            }
        } else { //makes sure negative sign is always in front of the first number is slope is negative.
            if(yDifference <0 && xDifference>0){
                slope += yDifference + "/" + xDifference;
            } else if (yDifference>0 && xDifference>0){
                slope += yDifference + "/" + xDifference;
            } else if(yDifference>0 && xDifference <0){
                slope += "-" + yDifference + "/" + Math.abs(xDifference);
            } else if (yDifference<0 && xDifference<0){
                slope += Math.abs(yDifference) + "/" + Math.abs(xDifference);
            } else {
                return ""; //if slope is zero -> string is empty
            }
        }

        if (yIntercept() <0){ //prevents double negative signs and double positive signs.
            yInt = "- " + Math.abs(yIntercept());
        } else if(yIntercept()>0){
            yInt = "+ " + Math.abs(yIntercept());
        } else{
            yInt = ""; // if y intercept is zero then string is blank.
        }

        if (slope() == 0) {
            if(yInt == ""){
                return "y = 0"; //test case for horizontal line at the x-axis
            } else {
                if (yIntercept()*10%10 == 0){ //checks and converts whole number y intercepts
                    return "y = " + (int)(yIntercept());
                } else {
                    return "y = " + yIntercept();
                }
            }
        } else {
            return "y = " + slope + "x " + yInt; //returns final equation
        }
    }


    public double roundedToHundredth(double toRound){
        return Math.round(toRound*100)/100.0;
    }//round method

    public String lineInfo(){
        String output = "";
        output += "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")";
        output += "\nThe equation of the line between these points is: " + equation();
        output += "\nThe slope of this line is: " + slope();
        output += "\nThe y-intercept of the line is: " + yIntercept();
        output += "\nThe distance between the two points is: " + distance();
        output += "\n";
        return output;
    }

    public String coordinateForX(double xVal){
        double slope;
        double yVal;
        String out = "";
        out += "(" + xVal + ", ";
        slope = slope();
        yVal = (slope * xVal) + yIntercept(); //calculates y value for given x value
        out += roundedToHundredth(yVal) + ")";
        return out;
    }
}
