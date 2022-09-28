import java.util.Scanner;

public class mainApp {
    public static void main(String[] args) {
        int count=0;
        int range=0;
        while (true) {
            System.out.println("---------------四则运算程序---------------");
            System.out.println("-n：生成题目个数:"+count);
            System.out.println("-r：参数数值范围:"+range);
            System.out.println("-g：查看测试结果");
            System.out.println("Do：执行程序");
            System.out.println("请输入指令：");

            Scanner in =new Scanner(System.in);
            while(in.hasNext()){
                switch(in.next()){
                    case "-n" :
                        System.out.println("请输入要生成的题目个数：");
                        count = in.nextInt();
                        break;
                    case "-r":
                        System.out.println("请输入运算数的数值范围：");
                        System.out.println("请重新输入");

                        break;
//                    case "-g": fo.FileC(file2, file3, file4);        //答案和做题文档对比，结果写入Grade文档

                    case "Do":

                        



//                        for(int i=0;i<n;i++){
//                            String s=ex.CreatExp(n,m),fstr;   //生成随机表达式并求解
//                            String rus=its.suffixToArithmetic(its.infixToSuffix(s));
//
//                            fstr=i+1+":"+s+"\r\n";
//                            fo.FileW(file1, fstr);            //表达式写入文档
//
//                            fstr=i+1+":"+rus+"\r\n";
//                            fo.FileW(file2, fstr);            //答案写入文档
                        }
                        break;
//                    default:
//                        System.out.println("无效指令！");
//                        break;
                }
                System.out.println("请输入指令：");
            }
    }
}
