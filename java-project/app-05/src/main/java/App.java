import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    String appTitle = "[엄타 서비스]";
    String title = "[회원정보]";
    System.out.println(appTitle);
    System.out.println(title);

    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("0. 종료");

    String studentNumber = null;
    String name = null;
    int age = 0;
    boolean local = false;
    char gender = 'M';
    float averageGrade = 0;

    loop:
    while (true) {
      System.out.print("> ");
      String command = scan.nextLine();

      switch (command) {
        case "1":
          System.out.print("학번? ");
          studentNumber = scan.nextLine();
          System.out.print("이름은?");
          name = scan.nextLine();
          System.out.print("나이는?");
          age = Integer.valueOf(scan.nextLine());
          System.out.print("내국인 여부?");
          local = Boolean.valueOf(scan.nextLine());
          System.out.print("성별?");
          gender = scan.nextLine().charAt(0);
          System.out.print("학점?");
          averageGrade = Float.valueOf(scan.nextLine());
          break;

        case "2":
          System.out.printf("학번: %s\n", studentNumber);

          System.out.printf("이름: %s\n", name);

          System.out.printf("나이: %d\n", age);

          System.out.printf("내국인: %b\n", local);

          System.out.printf("성별: %c\n", gender);

          System.out.printf("누적학점: %.2f\n", averageGrade);
          break;
        case "0":
          System.out.println("종료합니다.");
          break loop;
        case "menu":
          System.out.println(title);
          System.out.println("1. 등록");
          System.out.println("2. 조회");
          System.out.println("0. 종료");
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }

    scan.close();
  }
}

// gradle progress bar 감추기
// gradle run -q --console=plain
