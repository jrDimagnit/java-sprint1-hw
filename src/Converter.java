public class Converter {
    public double distanceSteps (int allSteps){
        double distance ;
        distance = (allSteps * 0.75) / 1000;
        return distance;
    }

    public int kKal(int allSteps){
        int kal ;
        kal = allSteps * 50 / 1000;
        return kal;
    }

}

