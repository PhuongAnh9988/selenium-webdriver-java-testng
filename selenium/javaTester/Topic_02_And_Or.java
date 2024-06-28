package javaTester;

public class Topic_02_And_Or {

    public static void main(String[] args) {
        boolean member01;
        boolean member02;
        boolean result;

        // AND chir cần 1 trong 2 sai => Kết quả sai
        member01 = true;
        member02 = true;
        System.out.println("Result = " + (member01 && member02));

        member01 = true;
        member02 = false;
        System.out.println("Result = " + (member01 && member02));

        member01 = false;
        member02 = true;
        System.out.println("Result = " + (member01 && member02));

        member01 = false;
        member02 = false;
        System.out.println("Result = " + (member01 && member02));

        // OR chỉ cần 1 trong 2 đúng => Kết quả sẽ đúng
        member01 = false;
        member02 = false;
        System.out.println("Result = " + (member01 || member02));


    }
}
