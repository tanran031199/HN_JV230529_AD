package Exam_Advance_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static Queue<String> parent = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean inMenu = true;

        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
            System.out.println("1. Nhập tên phụ huynh nộp hồ sơ");
            System.out.println("2. Phụ huynh tiếp theo");
            System.out.println("3. Thoát");
            System.out.println();
            System.out.println("Nhập vào lựa chọn của bạn:");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    parent.offer(sc.nextLine());
                    break;
                case 2:
                    String poll = parent.poll();
                    if (poll != null) {
                        System.out.println("Phụ huynh tiếp theo là:");
                        System.out.println(poll);
                    } else {
                        System.out.println("Không có phụ huynh nào trong danh sách");
                    }
                    break;
                case 3:
                    System.out.println("Bạn đã thoát khỏi chương trình!");
                    inMenu = false;
                    break;
                default:
                    System.err.println("Không có lựa chọn " + choice + ", vui lòng chọn lại!");
                    break;
            }
        } while (inMenu);

        sc.close();
    }
}
