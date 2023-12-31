import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String appTitle = "[엄타 서비스]";
        String title = "[회원정보]";
        System.out.print("학번? ");
        String studentNumber = scan.nextLine();
        System.out.print("이름은?");
        String name = scan.nextLine();
        System.out.print("나이는?");
        int age = scan.nextInt();
        System.out.print("내국인 여부?");
        boolean local = scan.nextBoolean();
        System.out.print("성별?");
        char gender = scan.next().charAt(0);
        System.out.print("학점?");
        float averageGrade = scan.nextFloat();

        scan.close();


        System.out.println(appTitle);
        System.out.println(title);

        System.out.printf("학번: %s\n", studentNumber);

        System.out.printf("이름: %s\n", name);

        System.out.printf("나이: %d\n", age);

        System.out.printf("내국인: %b\n", local);

        System.out.printf("성별: %c\n", gender);
        
        System.out.printf("누적학점: %.2f\n", averageGrade);

    }

}

// gradle progress bar 감추기
// gradle run -q --console=plain