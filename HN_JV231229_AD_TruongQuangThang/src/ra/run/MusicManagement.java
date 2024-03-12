package ra.run;
import ra.model.Song;
import ra.model.Singer;

import java.util.Objects;
import java.util.Scanner;


public class MusicManagement {
    private static int songCount = 0;
    private static int singerCount = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Singer[] singers = new Singer[100];
        Song[] songs = new Song[100];

        for (int i = 0; i < songCount; i++) {
            boolean check = false;
            for (int j = 0; j < songCount; j++) {
                if (singers[i].getSingerId() == songs[i].getSinger().getSingerId()) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                singers[i] = songs[i].getSinger();
                singerCount++;
            }
        }
        ManagementMain(scanner, songs, singers);
    }

    public static void ManagementMain(Scanner scanner, Song[] songs, Singer[] singers){
        int choice;
        do {
            System.out.println("***********************MUSIC-MANAGEMENT*************************");
            System.out.println("1. QUẢN LÝ CA SĨ");
            System.out.println("2. QUẢN LÝ BÀI HÁT");
            System.out.println("3. TÌM KIẾM BÀI HÁT");
            System.out.println("0. Thoát");
            System.out.print("Mời lựa chọn (1/2/3/4): ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    menuSinger(scanner,singers,songs);
                    break;
                case 2:
                    menuSong(scanner,singers,songs);
                    break;
                case 3:
                    menuSearch(scanner,singers,songs);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }

    public static void menuSinger(Scanner scanner,Singer[] singers,Song[] songs){
        int choice;
        do {
            System.out.println("**********************SINGER-MANAGEMENT************************");
            System.out.println("1. Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới");
            System.out.println("2. Hiển thị danh sach tất cả ca sĩ đã lưu trữ");
            System.out.println("3. Thay đổi thông tin ca sĩ theo mã id");
            System.out.println("4. Xóa ca sĩ theo mã id");
            System.out.println("5. Quay lai");
            System.out.print("Mời lựa chọn (1/2/3/4/5): ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập số lượng ca sĩ cần thêm");
                    int n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        Singer newSinger = new Singer();
                        newSinger.inputData(scanner, singers);
                        singers[singerCount]=newSinger;
                        singerCount++;
                    }
                    break;
                case 2:
                    System.out.println("Danh sách ca sĩ:");
                    for (int i = 0; i < singerCount; i++) {
                        singers[i].displayData();
                    }
                    break;
                case 3:
                    System.out.println("Nhập id ca sĩ");
                    int idUpdate = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < singerCount; i++) {
                        if (singers[i].getSingerId() == idUpdate){
                            System.out.println("Nhập thông tin cập nhật");
                            singers[i].inputData(scanner,singers);
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Nhập mã ca sĩ muốn xóa");
                    int idDelete = Integer.parseInt(scanner.nextLine());
                    boolean checkDel = true;
                    for (int i = 0; i < singerCount; i++) {
                        if (idDelete == singers[i].getSingerId()){
                            for (int j = 0; j < songCount; j++) {
                                if (songs[j].getSinger() == singers[i]){
                                    System.out.println("Ca sĩ có bài hát nên không xóa được");
                                    checkDel = false;
                                    break;
                                }
                            }
                            if (checkDel){
                                singers[i]=null;
                                for (int k = i; k < singerCount -1; k++) {
                                    singers[k]=singers[k+1];
                                }
                                singers[singerCount]=null;
                            }
                            break;
                        }
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }

    public static void menuSong(Scanner scanner, Singer[] singers, Song[] songs){
        int choice;
        do {
            System.out.println("**********************SONG-MANAGEMENT************************");
            System.out.println("1. Thêm mới bài hát");
            System.out.println("2. Hiển thị danh sách tất cả bài hát đã lưu trữ");
            System.out.println("3. Thay đổi thông tin bài hát theo mã id");
            System.out.println("4. Xóa bài hát theo mã id");
            System.out.println("5. Quay lai");
            System.out.print("Mời lựa chọn (1/2/3/4/5): ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Song newSong = new Song();
                    newSong.inputData(scanner,songs,singers);
                    songs[songCount]=newSong;
                    songCount++;
                    break;
                case 2:
                    System.out.println("Danh sách bài hát:");
                    for (int i = 0; i < songCount; i++) {
                        songs[i].displayData();
                    }
                    break;
                case 3:
                    System.out.println("Nhập id bài hát");
                    String idSongUpdate = scanner.nextLine();
                    for (int i = 0; i < singerCount; i++) {
                        if (Objects.equals(songs[i].getSongId(), idSongUpdate)){
                            System.out.println("Nhập thông tin cập nhật");
                            songs[i].inputData(scanner,songs,singers);
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Nhập mã bài hát cần xóa:");
                    String delSongId = scanner.nextLine();
                    boolean checkDelete = false;
                    for (int i = 0; i < songCount; i++) {
                        if (songs[i].getSongId().equals(delSongId)) {
                            checkDelete = true;
                            for (int j = i; j < songCount - 1; j++) {
                                songs[j] = songs[j + 1];
                            }
                            songs[songCount]=null;
                            System.out.println("Đã xóa bài hát");
                            break;
                        }
                    }
                    if (!checkDelete) {
                        System.out.println("Không tìm thấy bài hát!");
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }

    public static void menuSearch(Scanner scanner, Singer[] singers, Song[] songs){
        int choice;
        do {
            System.out.println("**********************SEARCH-MANAGEMENT************************");
            System.out.println("1. Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại");
            System.out.println("2. Tìm kiếm ca sĩ theo tên hoặc thể loại");
            System.out.println("3. Hiển thị danh sách bài hát theo thứ tự tên tăng dần");
            System.out.println("4. Hiển thị 10 bài hát được đăng mới nhất");
            System.out.println("5. Quay lai");
            System.out.print("Mời lựa chọn (1/2/3/4/5): ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập tên ca sĩ hoặc thể loại");
                    String inputName = scanner.nextLine();
                    System.out.println("Danh sách bài hát");
                    for (int i = 0; i < songCount; i++) {
                        if(Objects.equals(songs[i].getSinger().getSingerName(), inputName) || Objects.equals(songs[i].getSinger().getGenre(), inputName)){
                            System.out.println(songs[i].getSongName());
                        }
                    }
                    break;
                case 2:
                    System.out.println("Nhập tên ca sĩ hoặc thể loại");
                    String inputSinger = scanner.nextLine();
                    System.out.println("Danh sách ca sĩ:");
                    for (int i = 0; i < singerCount; i++) {
                        if (Objects.equals(singers[i].getSingerName(), inputSinger) || Objects.equals(singers[i].getGenre(), inputSinger)){
                            System.out.println(singers[i].getSingerName());
                        }
                    }
                    break;
                case 3:

                    break;
                case 4:
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }
}
