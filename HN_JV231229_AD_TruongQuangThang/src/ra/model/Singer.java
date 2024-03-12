package ra.model;

import java.util.Scanner;

public class Singer {
    private static int currentId = 0;
    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;

    public Singer(int singerId, String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    public Singer(){
        this.singerId = currentId++;
    }
    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void inputData(Scanner scanner, Singer[] singers){
//      Nhập tên ca sĩ
        boolean checkName = false;
        do {
            System.out.println("Nhập tên ca sĩ");
            String inputName = scanner.nextLine().trim();
            if (!inputName.isEmpty()){
                singerName = inputName;
                checkName = true;
                System.out.println("Tên hợp lệ");
            }else {
            System.out.println("Không được để trống, Nhập lại tên ca sĩ : ");
            }
        }while (!checkName);

//        Nhập tuổi ca sĩ
        boolean checkAge = false;
        do {
            System.out.println("Nhập tuổi ca sĩ");
            int inputAge = Integer.parseInt(scanner.nextLine());
            if(inputAge > 0){
                age = inputAge;
                checkAge = true;
                System.out.println("Tuổi hợp lệ");
            }else{
                System.out.println("Tuổi không hợp lệ !!! Nhập lại tuổi ca sĩ");
            }
        }while (!checkAge);

//      Nhập quốc tịch
        boolean checkNation = false;
        do{
            System.out.println("Nhập quốc tịch ca sĩ");
            String inputNation = scanner.nextLine().trim();
            if (!inputNation.isEmpty()){
                nationality = inputNation;
                checkNation = true;
                System.out.println("Tên quốc tịch hợp lệ");
            }else {
                System.out.println("Tên quốc tịch không được để trống, Nhập lại tên quốc tịch  : ");
            }
        }while (!checkNation);

//        Nhap giới tính
        System.out.println("Nhập giới tính ca sĩ(true : Nam/ false: Nữ");
        this.gender = Boolean.getBoolean(scanner.nextLine());

//        NHập thể loại
        boolean checkGenre = false;
        do{
            System.out.println("Nhập thể loại ca sĩ");
            String inputGenre = scanner.nextLine().trim();
            if (!inputGenre.isEmpty()){
                genre = inputGenre;
                checkGenre = true;
                System.out.println("Tên thể loại hợp lệ");
            }else {
                System.out.println("Tên thể loại không được để trống, Nhập lại tên quốc tịch  : ");
            }
        }while (!checkGenre);
    }

    public void displayData(){
        if(gender){
        System.out.println("Singer{"+
                "singerID='"+singerId+"\'"+
                "singerName='"+singerName+"\'"+
                "age='"+age+"\'"+
                "nationality='"+nationality+"\'"+
                "gender='"+"Nam"+"\'"+
                "genre='"+genre+"\'"+"}"
        );
        }else{
            System.out.println("Singer{"+
                    "singerID='"+singerId+"\'"+
                    "singerName='"+singerName+"\'"+
                    "age='"+age+"\'"+
                    "nationality='"+nationality+"\'"+
                    "gender='"+"Nữ"+"\'"+
                    "genre='"+genre+"\'"+"}"
            );
        }
        System.out.println("============================");
    }
}
