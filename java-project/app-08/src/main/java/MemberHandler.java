public class MemberHandler {
  static final int DEFAULT_SIZE = 3;
  static String[] studentNumber = new String[DEFAULT_SIZE];
  static String[] name = new String[DEFAULT_SIZE];
  static int[] age = new int[DEFAULT_SIZE];
  static boolean[] local = new boolean[DEFAULT_SIZE];
  static char[] gender = new char[DEFAULT_SIZE];
  static float[] averageGrade = new float[DEFAULT_SIZE];
  static int size = 0;

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

    studentNumber[size] = Prompt.inputString("학번? ");
    name[size] = Prompt.inputString("이름은?");
    age[size] = Prompt.inputInt("나이는?");
    local[size] = Prompt.inputBoolean("내국인 여부?");
    gender[size] = Prompt.inputChar("성별?");
    averageGrade[size] = Prompt.inputFloat("학점?");

    size++;
  }

  static void detailMember() {
    int no = Prompt.inputInt("번호? ");
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
    int no = Prompt.inputInt("번호? ");
    if (no < 0 || no >= size) {
      System.out.println("인덱스가 유효하지 않습니다.");
      return;
    }

    studentNumber[no] = Prompt.inputString("학번(%s)? ", studentNumber[no]);
    name[no] = Prompt.inputString("이름은(%s)? ", name[no]);
    age[no] = Prompt.inputInt("나이는?(%d) ", age[no]);
    local[no] = Prompt.inputBoolean("내국인 여부?(%b) ", local[no]);
    gender[no] = Prompt.inputChar("성별?(%s) ", gender[no]);
    averageGrade[no] = Prompt.inputFloat("학점?(%.2f) ", averageGrade[no]);
  }

  static void deleteMember() {
    int no = Prompt.inputInt("번호? ");
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
}
