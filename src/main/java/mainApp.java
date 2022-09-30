import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class mainApp {
    public static void main(String[] args) throws IOException {

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
            int flag = 1;
            while (flag == 1) {
                switch (in.next()) {
                    case "-n":
                        System.out.println("请输入要生成的题目个数：");
                        count = in.nextInt();
                        flag = 0;
                        break;
                    case "-r":
                        System.out.println("请输入运算数的数值范围：");
                        range = in.nextInt();
                        flag = 0;

                        break;
                    case "-g":

                        comparetor comparetor = new comparetor();
                        comparetor.compare();
                        flag = 0;
                        break;

                    case "Do":
                        writeFormulasInToFile writeFormulasInToFile = new writeFormulasInToFile();
                        writeFormulasInToFile.write(count, range);
                        flag = 0;
                        break;

                    default:
                        throw new IllegalStateException("Unexpected value: " + in.next());
                }
            }
        }
    }


}