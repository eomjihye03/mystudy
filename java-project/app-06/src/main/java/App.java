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
    System.out.println("3. 목록");
    System.out.println("4. 변경");
    System.out.println("5. 삭제");
    System.out.println("0. 종료");

    final int DEFAULT_SIZE = 3;
    String[] studentNumber = new String[DEFAULT_SIZE];
    String[] name = new String[DEFAULT_SIZE];
    int[] age = new int[DEFAULT_SIZE];
    boolean[] local = new boolean[DEFAULT_SIZE];
    char[] gender = new char[DEFAULT_SIZE];
    float[] averageGrade = new float[DEFAULT_SIZE];

    int size = 0;
    int no = 0;

    loop:
    while (true) {
      System.out.print("> ");
      String command = scan.nextLine();

      switch (command) {
        case "1":
          if (size >= studentNumber.length) {
            int oldSize = studentNumber.length;
            int newSize = oldSize + (oldSize >> 1);

            String[] newStudentNumber = new String[newSize];
            String[] newName = new String[newSize];
            int[] newAge = new int[newSize];
            boolean[] newLocal = new boolean[newSize];
            char[] newGender = new char[newSize];
            float[] newAverage = new float[newSize];

            for (int i = 0; i < size; i++) {
              newStudentNumber[i] = studentNumber[i];
              newName[i] = name[i];
              newAge[i] = age[i];
              newLocal[i] = local[i];
              newGender[i] = gender[i];
              newAverage[i] = averageGrade[i];
            }

            studentNumber = newStudentNumber;
            name = newName;
            age = newAge;
            local = newLocal;
            gender = newGender;
            averageGrade = newAverage;
          }
          System.out.print("학번? ");
          studentNumber[size] = scan.nextLine();

          System.out.print("이름은?");
          name[size] = scan.nextLine();

          System.out.print("나이는?");
          age[size] = Integer.valueOf(scan.nextLine());

          System.out.print("내국인 여부?");
          local[size] = Boolean.valueOf(scan.nextLine());

          System.out.print("성별?");
          gender[size] = scan.nextLine().charAt(0);

          System.out.print("학점?");
          averageGrade[size] = Float.valueOf(scan.nextLine());

          size++;
          break;

        case "2":
          System.out.print("번호? ");
          no = Integer.valueOf(scan.nextLine());
          if (no < 0 || no >= size) {
            System.out.println("인덱스가 유효하지 않습니다.");
            break;
          }
          System.out.printf("학번: %s\n", studentNumber[no]);
          System.out.printf("이름: %s\n", name[no]);
          System.out.printf("나이: %d\n", age[no]);
          System.out.printf("내국인: %b\n", local[no]);
          System.out.printf("성별: %c\n", gender[no]);
          System.out.printf("누적학점: %.2f\n", averageGrade[no]);
          break;

        case "3":
          for (int i = 0; i < size; i++) {
            System.out.printf("%d,  %s,  %s,  %s\n", i, studentNumber[i], name[i], gender[i]);
          }
          break;
        case "4":
          System.out.print("번호? ");
          no = Integer.valueOf(scan.nextLine());
          if (no < 0 || no >= size) {
            System.out.println("인덱스가 유효하지 않습니다.");
            break;
          }
          System.out.printf("학번(%s)? ", studentNumber[no]);
          studentNumber[no] = scan.nextLine();

          System.out.printf("이름은(%s)? ", name[no]);
          name[no] = scan.nextLine();

          System.out.printf("나이는?(%d) ", age[no]);
          age[no] = Integer.valueOf(scan.nextLine());

          System.out.printf("내국인 여부?(%b) ", local[no]);
          local[no] = Boolean.valueOf(scan.nextLine());

          System.out.printf("성별?(%s) ", gender[no]);
          gender[no] = scan.nextLine().charAt(0);

          System.out.printf("학점?(%.2f) ", averageGrade[no]);
          averageGrade[no] = Float.valueOf(scan.nextLine());
          break;
        case "5":
          System.out.print("번호? ");
          no = Integer.valueOf(scan.nextLine());
          if (no < 0 || no >= size) {
            System.out.println("인덱스가 유효하지 않습니다.");
            break;
          }
          for (int i = no; i < (size - 1); i++) {
            studentNumber[i] = studentNumber[i + 1];
            name[i] = name[i + 1];
            age[i] = age[i + 1];
            local[i] = local[i + 1];
            gender[i] = gender[i + 1];
            averageGrade[i] = averageGrade[i + 1];
          }
          size--;
          break;
        case "0":
          System.out.println("종료합니다.");
          break loop;
        case "menu":
          System.out.println(title);
          System.out.println("1. 등록");
          System.out.println("2. 조회");
          System.out.println("3. 목록");
          System.out.println("4. 변경");
          System.out.println("5. 삭제");
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
