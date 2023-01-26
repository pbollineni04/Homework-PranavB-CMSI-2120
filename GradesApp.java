import java.util.Arrays;

class Grades {
    

    private int[] gradesArray;
    int maxGrade = 100;
    int lowestGrade = 0;

    public Grades() {
        gradesArray = new int[]{};
    }
    
    public Grades(int[] myGrades) {
        gradesArray = myGrades;
    }

    public int highest(){
        int highestValue = 0;
        for(var i = 1; i < gradesArray.length; i++){
            if(gradesArray[i] > highestValue){
                highestValue = gradesArray[i];
            }
        }
        return highestValue;
    }

    
    public int lowest(){
        int lowestValue = maxGrade;
        for(var i = 1; i < gradesArray.length; i++){
            if(gradesArray[i] < lowestValue){
                lowestValue = gradesArray[i];
            }
        }
        return lowestValue;
    }

    public int numberOfGrades(){
        return gradesArray.length;
    }

    public double average(){
        double gradesSum = 0;
        for(var i = 1; i < gradesArray.length; i++){
            gradesSum += gradesArray[i];
        }
        return gradesSum/numberOfGrades();
    }


    public int numberOfFailingGrades(int baseLine){
        int failingGrades = 0;
        for(var i= 0; i < gradesArray.length; i++){
            if(gradesArray[i] < baseLine){
                failingGrades++;
            }
        }
        return failingGrades;
    }

    public String histogram(){
        String h1 = "90 - 100 | ";
        String h2 = "80 - 89  | ";
        String h3 = "70 - 79  | ";
        String h4 = "60 - 69  | ";
        String h5 = "< 60     | ";
        for(var i = 0; i < gradesArray.length; i++){
            if(gradesArray[i] >= 90){
                h1 += "*";
            }else if(gradesArray[i] >= 80 && gradesArray[i] < 90){
                h2 += "*";
            }else if(gradesArray[i] >= 70 && gradesArray[i] < 80){
                h3 += "*";
            }else if(gradesArray[i] >= 60 && gradesArray[i] < 70){
                h4 += "*";
            }else if(gradesArray[i] < 60){
                h5 += "*";
            }
        }
        return h1 + "\n" + h2 + "\n" + h3 + "\n" + h4 + "\n" + h5;


    }

    class GradesApp{
        public static void main(String[] args) {
            try{
                String response = System.console().readLine("Enter the number of grades to input: ");
                var numGrades = Integer.parseInt(response);
                if(numGrades <= 0){
                    throw new IllegalArgumentException("Please input a valid number of grades.");
                }
                int[] gradesArray = new int[numGrades];
                for (var i = 1; i <= numGrades; i++){
                    String gradeQuestion = System.console().readLine("Enter grade " + i + ": ");
                    var grade = Integer.parseInt(gradeQuestion);
                    if(grade > 100 || grade < 0){
                        throw new IllegalArgumentException("Grades can only be 0-100, please try again.");
                    }
                    gradesArray[i-1] = grade;
                }

                Grades grades = new Grades(gradesArray);
                
                System.out.println("Highest grade: " + grades.highest());
                System.out.println("Lowest grade: " + grades.lowest());
                System.out.println("Number of grades: " + grades.numberOfGrades());
                System.out.println("Average grade: " + grades.average());
                System.out.println("Number of Failing grades: " + grades.numberOfFailingGrades(60));
                System.out.println("Histogram of grades: \n" + grades.histogram());
            }catch(IllegalArgumentException e){
                System.out.print(e);
            }
        }
    }
}