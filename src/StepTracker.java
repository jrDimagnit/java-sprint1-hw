import java.util.HashMap;

public class StepTracker {

    HashMap <Integer,int[]> stepMonth = new HashMap<>();
    int limitSteps = 10000;
    Converter converter = new Converter();

    void  addStepsMonth(int month,int day, int steps){
        if(stepMonth.containsKey(month)){
            int[] stepsByDay = stepMonth.get(month);
            stepsByDay[day - 1] = steps;
        }else{
            int[] stepsByDay = new int [30];
            stepsByDay[day - 1] = steps;
            stepMonth.put(month,stepsByDay);
        }
    }
    void statsMonth(int month){
        int allSteps = 0;
        int maxSteps = 0;
        int maxSeries = 0;
        int max =0;
        int[] stepsByDay = stepMonth.get(month);
        for (int i = 0; i < stepsByDay.length; i++){
            allSteps += stepsByDay[i];
            if (maxSteps < stepsByDay[i]){
                maxSteps = stepsByDay[i];
            }
            System.out.print( (i+1) +" день: " + stepsByDay[i] + " ,");
        }
        System.out.println(".");
        System.out.println("В этом месяце пройдено " + allSteps + " шагов.");
        int middleSteps =  allSteps /stepsByDay.length;
        System.out.println("Средне кол-во шагов в день: " + middleSteps);
        System.out.println("Пройденно " + converter.distanceSteps(allSteps) + " км.");
        System.out.println("Кол-во сожженых килокалорий составляет " + converter.kKal(allSteps));
        for (int i = 0; i < stepsByDay.length; i++){
            if (stepsByDay[i] >= limitSteps){
                max+=1;
            }
            else if(stepsByDay[i] < limitSteps && maxSeries < max){
                maxSeries = max;
                max = 0;
            }
        }
        System.out.println("Лучшая серия " + maxSeries + " дня(-ей).");

    }
    void newLimitSteps (int steps) {
        limitSteps = steps;
    }
}