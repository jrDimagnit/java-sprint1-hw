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
        getDaySteps(stepMonth.get(month),getAllSteps(stepMonth.get(month)));
        System.out.println("В этом месяце пройдено " + getAllSteps(stepMonth.get(month)) + " шагов.");
        middleSteps(getAllSteps(stepMonth.get(month)),stepMonth.get(month));
        System.out.println("Пройденно " + converter.distanceSteps(getAllSteps(stepMonth.get(month))) + " км.");
        System.out.println("Кол-во сожженых килокалорий составляет " + converter.kKal(getAllSteps(stepMonth.get(month))));
        niceSeries(stepMonth.get(month),limitSteps);

    }
    void newLimitSteps (int steps) {
        limitSteps = steps;
    }

    public void getDaySteps(int [] stepsByDay, int allSteps){
        int maxSteps = 0;
        for (int i = 0; i < stepsByDay.length; i++){
            allSteps += stepsByDay[i];
            if (maxSteps < stepsByDay[i]){
                maxSteps = stepsByDay[i];
            }
            System.out.print( (i+1) +" день: " + stepsByDay[i] + " ,");
        }
        System.out.println(".");
        System.out.println("Максимальное кол-во шагов в день в этом месяце " + maxSteps);
    }

    public int getAllSteps(int [] stepsByDay){
        int allSteps = 0;
        for (int i = 0; i < stepsByDay.length; i++) {
            allSteps += stepsByDay[i];
        }
        return allSteps;
    }
    public void middleSteps(int allSteps,int [] stepsByDay){
        int middleSteps =  allSteps /stepsByDay.length;
        System.out.println("Средне кол-во шагов в день: " + middleSteps);
    }

    public void niceSeries(int [] stepsByDay, int limitSteps){
        int maxSeries = 0;
        int max =0;
        for (int i =0 ; i < stepsByDay.length ; i++){
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
}