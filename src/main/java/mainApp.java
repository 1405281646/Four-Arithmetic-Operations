import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class mainApp {
    public static void main(String[] args) throws IOException {
        Random r = new Random();
        int count = 10;
        int range = 10;
        while (true) {
            System.out.println("---------------四则运算程序---------------");
            System.out.println("-------做题直接在Exercises.txt文件做-------");
            System.out.println("-n：生成题目个数:" + count);
            System.out.println("-r：参数数值范围:" + range);
            System.out.println("-g：进行结果对比");
            System.out.println("Do：执行程序");
            System.out.println("请输入指令：");

            Scanner in = new Scanner(System.in);
            while (in.hasNext()) {
                switch (in.next()) {
                    case "-n":
                        System.out.println("请输入要生成的题目个数：");
                        count = in.nextInt();
                        break;
                    case "-r":
                        System.out.println("请输入运算数的数值范围：");
                        range = in.nextInt();
                        System.out.println("请重新输入");

                        break;
                    case "-g":

                        String exerciseFilePath ="Exercises.txt";
                        String answerFilePath = "Answers.txt";

                        try {
                            List<String> exerciseAnswers = exerciseFileReader(exerciseFilePath);
                            List<String> answers = answerReader(answerFilePath);

                            List<String> correct = new ArrayList<>();
                            List<String> wrong = new ArrayList<>();

                            int min = Math.min(exerciseAnswers.size(), answers.size());
                            int num = 1;
                            for (int i = 0; i < min; i++){
                                if (exerciseAnswers.get(i).equals(answers.get(i))){
                                    correct.add(String.valueOf(num++));
                                }else {
                                    wrong.add(String.valueOf(num++));
                                }
                            }

                            File grade = new File("Grade.txt");
                            if (grade.exists()){
                                grade.delete();
                            }
                            if (grade.createNewFile()){
                                FileOutputStream gradeOutput = new FileOutputStream(grade);
                                PrintStream gradePrintStream = new PrintStream(gradeOutput);
                                String corrects = String.join(",", correct);
                                gradePrintStream.println("Correct：" + correct.size() +
                                        " (" + corrects + ")");
                                String wrongs = String.join(",", wrong);
                                gradePrintStream.println("Wrong：" + wrong.size() +
                                        " (" + wrongs + ")");
                            }

                            System.out.println("判定完成");

                        } catch (FileNotFoundException e) {
                            System.out.println("文件不存在");
                        } catch (IOException e) {
                            System.out.println("文件读入异常");
                        }

                        break;       //答案和做题文档对比，结果写入Grade文档

                    case "Do":
                        File exercises = new File("Exercises.txt");
                        File answers = new File("Answers.txt");

                        if (exercises.exists() || answers.exists()) {
                            exercises.delete();
                            answers.delete();
                        }

                        if (exercises.createNewFile() && answers.createNewFile()) {
                            FileOutputStream exercisesOutput = new FileOutputStream(exercises);
                            PrintStream exercisesPrintStream = new PrintStream(exercisesOutput);

                            FileOutputStream answersOutput = new FileOutputStream(answers);
                            PrintStream answersPrintStream = new PrintStream(answersOutput);
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

                            exercisesOutput.close();
                            answersOutput.close();
                            exercisesPrintStream.close();
                            answersPrintStream.close();

                            System.out.println("文件创建成功 ");

                            break;

                        }
                        System.out.println("请输入指令：");
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + in.next());
                }
            }
        }
    }
    public static void outputFile(int i, String problem[], PrintStream... var){
        try {
            var[0].println(i + ". " + problem[0]);
            var[1].println(i + ". " + problem[1]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("程序内部出错了");
        }
    }
    public static List<String> exerciseFileReader(String path) throws IOException {
        BufferedReader exerciseReader = new BufferedReader(new FileReader(path));
        String exerciseAnswer = "";
        List<String> exerciseAnswers = new ArrayList<>();
        while ((exerciseAnswer = exerciseReader.readLine()) != null){
            String[] split = exerciseAnswer.split("=");
            if (split.length >= 2){
                exerciseAnswers.add(split[1]);
            }else {
                exerciseAnswers.add(" ");
            }
        }
        return exerciseAnswers;
    }
    public static List<String> answerReader(String path) throws IOException {
        BufferedReader answerReader = new BufferedReader(new FileReader(path));
        String answer = "";
        List<String> answers = new ArrayList<>();
        while ((answer = answerReader.readLine()) != null){
            String[] split = answer.split(" ");
            answers.add(split[1]);
        }
        return answers;
    }
}