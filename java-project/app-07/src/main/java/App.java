import java.util.Scanner;

public class App {

  static final int DEFAULT_SIZE = 3;
  static String[] studentNumber = new String[DEFAULT_SIZE];
  static String[] name = new String[DEFAULT_SIZE];
  static int[] age = new int[DEFAULT_SIZE];
  static boolean[] local = new boolean[DEFAULT_SIZE];
  static char[] gender = new char[DEFAULT_SIZE];
  static float[] averageGrade = new float[DEFAULT_SIZE];
  static int size = 0;
  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    String appTitle = "[엄타 서비스]";
    System.out.println(appTitle);

    printMenu();

    loop:
    while (true) {
      System.out.print("> ");
      String command = scan.nextLine();

      switch (command) {
        case "1":
          addMember();
          break;

        case "2":
          detailMember();
          break;

        case "3":
          listMember();
          break;
        case "4":
          updateMember();
          break;
        case "5":
          deleteMember();
          break;
        case "0":
          System.out.println("종료합니다.");
          break loop;
        case "menu":
          printMenu();

          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }

    scan.close();
  }

  static void printMenu() {
    String title = "[회원정보]";
    System.out.println(title);
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 목록");
    System.out.println("4. 변경");
    System.out.println("5. 삭제");
    System.out.println("0. 종료");
  }

  static void addMember() {
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

    studentNumber[size] = promptString("학번? ");
    name[size] = promptString("이름은?");
    age[size] = promptInt("나이는?");
    local[size] = promptBoolean("내국인 여부?");
    gender[size] = promptChar("성별?");
    averageGrade[size] = promptFloat("학점?");

    size++;
  }

  static void detailMember() {
    int no = promptInt("번호? ");
    if (no < 0 || no >= size) {
      System.out.println("인덱스가 유효하지 않습니다.");
      return;
    }
    System.out.printf("학번: %s\n", studentNumber[no]);
    System.out.printf("이름: %s\n", name[no]);
    System.out.printf("나이: %d\n", age[no]);
    System.out.printf("내국인: %b\n", local[no]);
    System.out.printf("성별: %c\n", gender[no]);
    System.out.printf("누적학점: %.2f\n", averageGrade[no]);
  }

  static void listMember() {
    for (int i = 0; i < size; i++) {
      System.out.printf("%d,  %s,  %s,  %s\n", i, studentNumber[i], name[i], gender[i]);
    }
  }

  static void updateMember() {
    int no = promptInt("번호? ");
    if (no < 0 || no >= size) {
      System.out.println("인덱스가 유효하지 않습니다.");
      return;
    }

    studentNumber[no] = promptString("학번(%s)? ", studentNumber[no]);
    name[no] = promptString("이름은(%s)? ", name[no]);
    age[no] = promptInt("나이는?(%d) ", age[no]);
    local[no] = promptBoolean("내국인 여부?(%b) ", local[no]);
    gender[no] = promptChar("성별?(%s) ", gender[no]);
    averageGrade[no] = promptFloat("학점?(%.2f) ", averageGrade[no]);
  }

  static void deleteMember() {
    int no = promptInt("번호? ");
    if (no < 0 || no >= size) {
      System.out.println("인덱스가 유효하지 않습니다.");
      return;
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
  }

  static String promptString(String title, Object... args) {
    System.out.printf(title, args);
    return scan.nextLine();
  }

  static int promptInt(String title, Object... args) {
    return Integer.valueOf(promptString(title, args));
  }

  static float promptFloat(String title, Object... args) {
    return Float.valueOf(promptString(title, args));
  }

  static boolean promptBoolean(String title, Object... args) {
    return Boolean.valueOf(promptString(title, args));
  }

  static char promptChar(String title, Object... args) {
    return promptString(title, args).charAt(0);
  }
}

// gradle progress bar 감추기
// gradle run -q --console=plain
