import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;


public class writeFormulasInToFile {
    public void write(int count, int range) throws IOException {
        File exercises = new File("Exercises.txt");
        File answers = new File("Answers.txt");

        if (exercises.exists() || answers.exists()) {
            exercises.delete();
            answers.delete();
        }

        if (exercises.createNewFile() && answers.createNewFile()) {

            PrintStream exercisesPrintStream = new PrintStream(new FileOutputStream(exercises));


            PrintStream answersPrintStream = new PrintStream(new FileOutputStream(answers));
            Random random = new Random();

            CreateFraction createFraction = new CreateFraction();
            CreateInteger createInteger = new CreateInteger();

            String[] problem;
            for (int i = 1; i <= count; i++) {
                int choose = random.nextInt(2);
                if (choose == 0) {
                    problem = createFraction.createProblem(range);
                } else {
                    problem = createInteger.createProblem(range);
                }
                outputFile(i, problem, exercisesPrintStream, answersPrintStream);
            }


            exercisesPrintStream.close();
            answersPrintStream.close();

            System.out.println("文件创建成功 ");


        }

    }


    public void outputFile(int i, String[] problem, PrintStream var1 ,PrintStream var2) {
        try {
            var1.println(i + ". " + problem[0]);
            var2.println(i + ". " + problem[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
           e.printStackTrace();
        }
    }


}




