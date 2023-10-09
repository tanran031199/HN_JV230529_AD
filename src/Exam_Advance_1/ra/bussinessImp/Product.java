package Exam_Advance_1.ra.bussinessImp;

import Exam_Advance_1.ra.bussiness.IShop;
import Exam_Advance_1.ra.run.ProductManagement;

import java.util.List;
import java.util.Scanner;

public class Product implements IShop, Comparable<Product> {
    int productId;
    String productName, title, description;
    Catalog catalog;
    float importPrice, exportPrice;
    boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, String title, String description, Catalog catalog, float importPrice, float exportPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.description = description;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.println("Nhập vào mã sản phẩm:");
        int inputId = Integer.parseInt(sc.nextLine());
        setProductId(inputId);

        System.out.println("Nhập vào tên sản phẩm:");
        String inputName = sc.nextLine();
        setProductName(inputName);

        System.out.println("Nhập vào tiêu đề sản phẩm:");
        String inputTitle = sc.nextLine();
        setTitle(inputTitle);

        System.out.println("Nhập vào mô tả:");
        String inputDescription = sc.nextLine();
        setDescription(inputDescription);

        System.out.println("Nhập vào giá nhập sản phẩm:");
        int inputImportPrice = Integer.parseInt(sc.nextLine());
        setImportPrice(inputImportPrice);

        do {
            System.out.println("Nhập vào trạng thái sản phẩm:");
            System.out.println("1. true");
            System.out.println("2. false");
            int chooseStatus = Integer.parseInt(sc.nextLine());
            if (chooseStatus == 1) {
                setProductStatus(true);
                break;
            } else if (chooseStatus == 2) {
                setProductStatus(false);
                break;
            } else {
                System.err.println("Không có lựa chọn " + chooseStatus + ", vui lòng chọn lại!");
            }
        } while (true);

        do {
            List<Catalog> catalogs = ProductManagement.catalogs;
            System.out.println("Chọn danh mục muốn thêm vào: ");
            for (int i = 0; i < catalogs.size(); i++) {
                System.out.println((i + 1) + ". " + catalogs.get(i).getCatalogName());
            }

            int chooseCatalog = Integer.parseInt(sc.nextLine());

            if(chooseCatalog < 0 || chooseCatalog > catalogs.size() + 1) {
                System.err.println("Không có lựa chọn " + chooseCatalog + ", vui lòng chọn lại!");
            } else {
                setCatalog(catalogs.get(chooseCatalog - 1));
                break;
            }
        } while(true);

        setExportPrice(inputImportPrice * RATE);
    }

    @Override
    public void displayData() {
        System.out.println("Sản phẩm: " + getProductId() +
                "\tTên sản phẩm: " + getProductName() +
                "\tTên danh mục sản phẩm: " + catalog.getCatalogName() +
                "\tGiá bán sản phẩm: " + getExportPrice() +
                "\tTrạng thái sản phẩm: " + isProductStatus());
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public int compareTo(Product o) {
        return (int) (this.importPrice - o.importPrice);
    }
}
