public class App {
    public static void main(String[] args) {
        String appTitle = "[엄타 서비스]";
        String title = "[회원정보]";
        String studentNumber = "202322185";
        String name = "엄지혜";
        int age = 22;
        boolean local = true;
        char gender = 'F';
        float averageGrade = 4.2f;


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
