package Exam_Advance_1.ra.run;

import Exam_Advance_1.ra.bussinessImp.Catalog;
import Exam_Advance_1.ra.bussinessImp.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    public static List<Catalog> catalogs = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean inMenu = true;

        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-2-MENU***************");
            System.out.println("1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục");
            System.out.println("2. Nhập số sản phẩm và nhập thông tin các sản phẩm");
            System.out.println("3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator)");
            System.out.println("4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm");
            System.out.println("5. Thoát");
            System.out.println();
            System.out.println("Nhập vào lựa chọn của bạn:");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addCatalog();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    sortProductByPrice();
                    break;
                case 4:
                    searchProductByCatalog();
                    break;
                case 5:
                    System.out.println("Bạn đã thoát khỏi chương trình!");
                    inMenu = false;
                    break;
                default:
                    System.err.println("Không có lựa chọn " + choice + ", vui lòng nhập lại!");
                    break;
            }
        } while (inMenu);
    }

    private static void searchProductByCatalog() {
        System.out.println("Nhập vào tên danh mục muốn tìm kiếm sản phẩm:");
        String catalogName = sc.nextLine().trim().toLowerCase();

        int index = -1;
        for (int i = 0; i < catalogs.size(); i++) {
            if (catalogs.get(i).getCatalogName().trim().toLowerCase().equals(catalogName)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.err.println("Không có danh mục nào phù hợp!");
        } else {
            List<Integer> indexs = new ArrayList<>();
            System.out.println();
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getCatalog().getCatalogId() == catalogs.get(index).getCatalogId()) {
                    indexs.add(i);
                }
            }

            if (indexs.isEmpty()) {
                System.err.println("Không có sản phẩm nào trong danh mục!");
            } else {
                System.out.println("Các sản phẩm có trong danh mục " + catalogs.get(index).getCatalogName() + " là:");
                for (int i = 0; i < indexs.size(); i++) {
                    products.get(i).displayData();
                }
            }
            System.out.println();
        }
    }

    private static void sortProductByPrice() {
        Collections.sort(products);
        System.out.println("--------------------Danh sách sản phẩm sau khi sắp xếp--------------------");
        products.forEach(Product::displayData);
        System.out.println();
    }

    private static void addProduct() {
        System.out.println("Nhập vào số lượng sản phẩm muốn thêm:");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            Product newProduct = new Product();
            newProduct.inputData(sc);
            products.add(newProduct);
        }

        System.out.println();
        System.out.println("----------------------Danh sách sản phẩm hiện tại là----------------------");
        products.forEach(Product::displayData);
        System.out.println();
    }

    private static void addCatalog() {
        System.out.println("Nhập vào số lượng danh mục muốn thêm:");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            Catalog newCatalog = new Catalog();
            newCatalog.inputData(sc);
            catalogs.add(newCatalog);
        }

        System.out.println();
        System.out.println("----------------------Danh sách danh mục hiện tại là----------------------");
        catalogs.forEach(Catalog::displayData);
        System.out.println();
    }
}
