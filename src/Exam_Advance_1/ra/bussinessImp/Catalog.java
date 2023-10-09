package Exam_Advance_1.ra.bussinessImp;

import Exam_Advance_1.ra.bussiness.IShop;

import java.util.Scanner;

public class Catalog implements IShop {
    int catalogId, priority;
    String catalogName, description;
    boolean catalogStatus;

    public Catalog() {
    }

    public Catalog(int catalogId, int priority, String catalogName, String description, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.priority = priority;
        this.catalogName = catalogName;
        this.description = description;
        this.catalogStatus = catalogStatus;
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.println("Nhập vào mã danh mục:");
        int inputId = Integer.parseInt(sc.nextLine());
        setCatalogId(inputId);

        System.out.println("Nhập vào tên danh mục:");
        String inputName = sc.nextLine();
        setCatalogName(inputName);

        System.out.println("Nhập vào độ ưu tiên:");
        int inputPiority = Integer.parseInt(sc.nextLine());
        setPriority(inputPiority);

        System.out.println("Nhập vào mô tả:");
        String inputDescription = sc.nextLine();
        setDescription(inputDescription);

        do {
            System.out.println("Nhập vào trạng thái danh mục:");
            System.out.println("1. true");
            System.out.println("2. false");
            int chooseStatus = Integer.parseInt(sc.nextLine());
            if (chooseStatus == 1) {
                setCatalogStatus(true);
                break;
            } else if (chooseStatus == 2) {
                setCatalogStatus(false);
                break;
            } else {
                System.err.println("Không có lựa chọn " + chooseStatus + ", vui lòng chọn lại!");
            }
        } while (true);
    }

    @Override
    public void displayData() {
        System.out.println("Danh mục: " + getCatalogId() +
                "\tTên danh mục: " + getCatalogName());
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }
}
