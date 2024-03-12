package ra.model;
import ra.run.MusicManagement;
import ra.model.Song;
import ra.model.Singer;
import java.util.Date;
import java.util.Scanner;

public class Song {
    private String songId ;
    private String songName;
    private String descriptions;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;

    public Song(String songId, String songName, String descriptions, Singer singer, String songWriter, Date createdDate, boolean songStatus) {
        this.songId = songId;
        this.songName = songName;
        this.descriptions = descriptions;
        this.singer = singer;
        this.songWriter = songWriter;
        this.createdDate = createdDate;
        this.songStatus = songStatus;
    }
    public Song(){

    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    public void inputData(Scanner scanner, Song[] songs,Singer[] singers){
//        Mã bài hát
        while (true){
            System.out.println("Nhập mã bài hát bắt đầu bằng kí tự S");
            String idInput = scanner.nextLine();
            boolean idCheck = false;
            if (!idInput.startsWith("S")){
                System.out.println("Mã bài hát phải bắt đầu bằng S");
            }else if(idInput.length()!=4){
                System.out.println("Mã bài hát phải có 4 kí tự");
            }else{
                songId = idInput;
                for (Song song : songs) {
                    if (song.getSongId().equals(idInput)){
                        System.out.println("Mã bài hát đã tồn tại");
                        idCheck = true;
                    }
                }
                if(!idCheck){
                    break;
                }
            }
        }

//        Tên bài hát
        while (true){
            System.out.println("Nhập tên bài hát");
            String nameInput = scanner.nextLine().trim();
            if(!nameInput.isEmpty()){
                songName = nameInput;
                System.out.println("Tên bài hát hợp lệ");
                break;
            }else{
                System.out.println("Tên bài hát không được để trống");
            }
        }

//        mô tả bài hát
        System.out.println("Nhập mô tả bài hát");
        this.descriptions = scanner.nextLine();

//        ca sĩ
        while (true){
            System.out.println("Nhập mã id của ca sĩ");
            int idSingerInput = Integer.parseInt(scanner.nextLine());
            boolean idCheck = false;
            for (Singer singer1 : singers){
                if (singer1.getSingerId() == idSingerInput){
                    this.singer = singer1;
                    idCheck = true;
                    break;
                }
            }
            if (!idCheck){
                System.out.println("Mã ca sĩ không tồn tại, vui lòng nhập lại");
            }else{
                break;
            }
        }

//        nhạc sĩ
        while (true){
            System.out.println("Nhập tên người sáng tác");
            String writerInput = scanner.nextLine().trim();
            if(!writerInput.isEmpty()){
                songWriter = writerInput;
                System.out.println("Tên người sáng tác hợp lệ");
                break;
            }else{
                System.out.println("Tên người sáng tác không được để trống");
            }
        }

//        Trạng thái
        System.out.println("Nhập trạng thái bài hát");
        this.songStatus = Boolean.parseBoolean(scanner.nextLine());
    }

//    this.songId = songId;
//        this.songName = songName;
//        this.descriptions = descriptions;
//        this.singer = singer;
//        this.songWriter = songWriter;
//        this.createdDate = createdDate;
//        this.songStatus = songStatus;
    public void displayData(){
        System.out.println("Song{" +
                "songId='" + songId + "\'" +
                ", songName='" + songName + "\'" +
                ", descriptions=" + descriptions +
                ", singer=" + singer.getSingerName() +
                ", songWriter=" + songWriter +
                ", createdDate=" + createdDate +
                ", songStatus=" + (songStatus ? "Đang bán" : "Không bán") +
                "}");
    }
}
