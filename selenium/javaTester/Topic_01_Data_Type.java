package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Topic_01_Data_Type {
    // Kiểu dữ liệu trong Java - 2 nhóm
    // 1, Kiểu dữ liệu nguyên thủy (Primitive Type)
    // Số nguyên: byte, short, int, long
    // Ko có phần thập phân

    byte bNumber = 40;
    short sNumber = 3000;
    int iNumber = 124144535;

    // Số thực: float - double
    // Có phân thập phân: điểm số, lương,...
     float fNumber = 9.95f;
     double dNumber = 35.94935454d;

     // Kí tự: char
    // Đại diện cho 1 kí tự
    char c = '$';
    char d = 'i';

    // Logic: boolen (luận lý)
    // Kết quả bài test: pass/fail (k ngoại lệ)
    boolean status = false;


    // 2, Kiểu dữ liệu tham chiếu (Reference type)
    // Class
    FirefoxDriver firefoxDriver = new FirefoxDriver();
    Select select = new Select(firefoxDriver.findElement(By.className("")));
    Topic_01_Data_Type topic01 = new Topic_01_Data_Type();

    // Interface
    WebDriver driver;
    JavascriptExecutor jsExcecutor;

    // Object
    Object name = "Automation FC";

    // Array (kiểu nguyên thủy/ tham chiếu)
    int[] studentAge = {15, 20, 8};
    String[] studentName = {"Automation", "Testing"};

    // Collection: List/ Set/ Queue
     List<String> studentAddress = new ArrayList<>();
     List<String> studentCity = new LinkedList<>();
     List<String> studentPhone = new Vector<>();

    // String - chuỗi kí tự
    String fullName = "Nguyễn Phương Anh";






}
