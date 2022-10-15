package com.house;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

public class HouseTest {
    public static final String PATH = "E:\\Desktop\\Desktop\\house.txt";

    /**
     *Execute before executing test cases
     */
    @BeforeEach
    public void beforeEach() {
        System.out.println("-------------------------------Test case execution begins-------------------------------");
        // 房屋信息都删除
        deleteFile();
    }

    /**
     * Execute after executing the test case
     */
    @AfterEach
    public void afterEach() {
        System.out.println("-------------------------------The test case execution ends-------------------------------");
    }

    @Test
    public void houseCase1Test() {
        String houseId = "fadfasdfs";
        String houseAddress = "Guangdong";
        String houseType = "Apartment";
        double housePrice = 1000000;
        int numBedrooms = 3;
        int numBathrooms = 2;
        int numCarspace = 1;
        double sizeHouse = 100;
        String descriptionHouse = "Nice house";


        //Wrong house sign
        House data1 = new House(houseId, houseAddress, houseType, housePrice, numBedrooms, numBathrooms, numCarspace, sizeHouse, descriptionHouse);
        boolean r1 = data1.AddHouse();
        System.out.println(r1 ? "Add successfully" : "Wrong");

        System.out.println("--------------------------------------------------------------");
        // 正确的房屋标识
        houseId = "ABC0000000";
        House data2 = new House(houseId, houseAddress, houseType, housePrice, numBedrooms, numBathrooms, numCarspace, sizeHouse, descriptionHouse);
        boolean r2 = data2.AddHouse();
        System.out.println(r2 ? "Add successfully" : "Wrong");
    }

    @Test
    public void houseCase2Test() {
        String houseId = "ABC0000001";
        String houseAddress = "Guangdong";
        String houseType = "Apartment";
        double housePrice = 1000000;
        int numBedrooms = 3;
        int numBathrooms = 2;
        int numCarspace = 1;
        double sizeHouse = 100;
        String descriptionHouse = "Nice house";


        // Wrong house description
        House data1 = new House(houseId, houseAddress, houseType, housePrice, numBedrooms, numBathrooms, numCarspace, sizeHouse, descriptionHouse);
        boolean r1 = data1.AddHouse();
        System.out.println(r1 ? "Add successfully" : "Wrong");

        System.out.println("--------------------------------------------------------------");
        // Correct house description
        descriptionHouse = "Nice house";
        House data2 = new House(houseId, houseAddress, houseType, housePrice, numBedrooms, numBathrooms, numCarspace, sizeHouse, descriptionHouse);
        boolean r2 = data2.AddHouse();
        System.out.println(r2 ? "Add successfully" : "Wrong");
    }

    @Test
    public void houseCase3Test() {
        String houseId = "ABC0000002";
        String houseAddress = "Guangdong";
        String houseType = "Apartment";
        double housePrice = 1000000;
        int numBedrooms = 5;
        int numBathrooms = 2;
        int numCarspace = 1;
        double sizeHouse = 100;
        String descriptionHouse = "Nice house";


        // Wrong number of bedrooms and wrong number of bathrooms
        House data1 = new House(houseId, houseAddress, houseType, housePrice, numBedrooms, numBathrooms, numCarspace, sizeHouse, descriptionHouse);
        boolean r1 = data1.AddHouse();
        System.out.println(r1 ? "Add successfully" : "wrong");

        System.out.println("--------------------------------------------------------------");
        //Correct number of bedrooms and wrong number of bathrooms
        numBathrooms = 3;
        House data2 = new House(houseId, houseAddress, houseType, housePrice, numBedrooms, numBathrooms, numCarspace, sizeHouse, descriptionHouse);
        boolean r2 = data2.AddHouse();
        System.out.println(r2 ? "Add successfully" : "Wrong");
    }

    @Test
    public void houseCase4Test() {
        String houseId = "ABC0000003";
        String houseAddress = "Guangdong";
        String houseType = "Apartment";
        double housePrice = 360000;
        int numBedrooms = 5;
        int numBathrooms = 2;
        int numCarspace = 1;
        double sizeHouse = 50;
        String descriptionHouse = "Nice house";


        // The wrong room size and price
        House data1 = new House(houseId, houseAddress, houseType, housePrice, numBedrooms, numBathrooms, numCarspace, sizeHouse, descriptionHouse);
        boolean r1 = data1.AddHouse();
        System.out.println(r1 ? "Add successfully" : "Wrong");

        System.out.println("--------------------------------------------------------------");
        // The correct room size and price
        numBathrooms = 3;
        House data2 = new House(houseId, houseAddress, houseType, housePrice, numBedrooms, numBathrooms, numCarspace, sizeHouse, descriptionHouse);
        boolean r2 = data2.AddHouse();
        System.out.println(r2 ? "Add successfully" : "Wrong");
    }

    @Test
    public void houseCase5Test() {
        String houseId = "ABC0000004";
        String houseAddress = "Guangdong";
        String houseType = "Apartment";
        double housePrice = 360000;
        int numBedrooms = 5;
        int numBathrooms = 3;
        int numCarspace = 0;
        double sizeHouse = 50;
        String descriptionHouse = "Nice house";


        // No park space
        House data1 = new House(houseId, houseAddress, houseType, housePrice, numBedrooms, numBathrooms, numCarspace, sizeHouse, descriptionHouse);
        boolean r1 = data1.AddHouse();
        System.out.println(r1 ? "Add successfully" : "Wrong");

        System.out.println("--------------------------------------------------------------");
        // 公寓有停车位
        numCarspace = 1;
        House data2 = new House(houseId, houseAddress, houseType, housePrice, numBedrooms, numBathrooms, numCarspace, sizeHouse, descriptionHouse);
        boolean r2 = data2.AddHouse();
        System.out.println(r2 ? "Add successfully" : "Wrong");
    }

    @Test
    public void houseCase6Test() {
        // 房屋标识
        String houseId = "ABC0000005";
        // 房屋地址
        String houseAddress = "广东省广州市天河区";
        // 房屋类型
        String houseType = "Apartment";
        // 房屋价格
        double housePrice = 1600000;
        // 房屋卧室数量
        int numBedrooms = 5;
        // 房屋洗手间数量
        int numBathrooms = 3;
        // 房屋停车位数量
        int numCarspace = 1;
        // 房屋面积
        double sizeHouse = 50;
        //房屋描述
        String descriptionHouse = "不错的房子";


        // 错误的房子价格
        House data1 = new House(houseId, houseAddress, houseType, housePrice, numBedrooms, numBathrooms, numCarspace, sizeHouse, descriptionHouse);
        boolean r1 = data1.AddHouse();
        System.out.println(r1 ? "添加成功" : "添加失败");

        System.out.println("--------------------------------------------------------------");
        // 正确的房子价格
        housePrice = 1400000;
        House data2 = new House(houseId, houseAddress, houseType, housePrice, numBedrooms, numBathrooms, numCarspace, sizeHouse, descriptionHouse);
        boolean r2 = data2.AddHouse();
        System.out.println(r2 ? "添加成功" : "添加失败");
    }

    @Test
    public void houseCase7Test() {
        // 房屋标识
        String houseId = "ABC0000006";
        // 房屋地址
        String houseAddress = "广东省广州市天河区";
        // 房屋类型
        String houseType = "Apartment";
        // 房屋价格
        double housePrice = 760000;
        // 房屋卧室数量
        int numBedrooms = 3;
        // 房屋洗手间数量
        int numBathrooms = 1;
        // 房屋停车位数量
        int numCarspace = 1;
        // 房屋面积
        double sizeHouse = 50;
        //房屋描述
        String descriptionHouse = "不错的房子";


        // 三室两卫数量以下价格超75万
        House data1 = new House(houseId, houseAddress, houseType, housePrice, numBedrooms, numBathrooms, numCarspace, sizeHouse, descriptionHouse);
        boolean r1 = data1.AddHouse();
        System.out.println(r1 ? "添加成功" : "添加失败");

        System.out.println("--------------------------------------------------------------");
        // 三室两卫以下价格低于75万
        housePrice = 740000;
        House data2 = new House(houseId, houseAddress, houseType, housePrice, numBedrooms, numBathrooms, numCarspace, sizeHouse, descriptionHouse);
        boolean r2 = data2.AddHouse();
        System.out.println(r2 ? "添加成功" : "添加失败");
    }

    @Test
    public void houseCase8Test() {
        // 房屋标识
        String houseId = "ABC0000007";
        // 房屋地址
        String houseAddress = "广东省广州市天河区";
        // 房屋类型
        String houseType = "Apartment";
        // 房屋价格
        double housePrice = 740000;
        // 房屋卧室数量
        int numBedrooms = 2;
        // 房屋洗手间数量
        int numBathrooms = 1;
        // 房屋停车位数量
        int numCarspace = 1;
        // 房屋面积
        double sizeHouse = 50;
        //房屋描述
        String descriptionHouse = "不错的房子";
        House data0 = new House(houseId, houseAddress, houseType, housePrice, numBedrooms, numBathrooms, numCarspace, sizeHouse, descriptionHouse);
        boolean r0 = data0.AddHouse();
        System.out.println(r0 ? "添加成功" : "添加失败");

        // 房屋地址
        String newAddress = "";
        // 房屋类型
        String newType = "Apartment";
        // 房屋价格
        double newPrice = 760000;
        // 房屋卧室数量
        int newBedrooms = 2;
        // 房屋洗手间数量
        int newBathrooms = 1;
        // 房屋停车位数量
        int newCarspace = 1;
        // 房屋面积
        double newSize = 50;
        //房屋描述
        String newDescription = "不错的房子";

        // 如果三室以下的住宅价格不能上涨10%
        House data1 = new House(houseId);
        boolean r1 = data1.UpdateHouse(newAddress, newType, newPrice, newBedrooms, newBathrooms, newCarspace, newSize, newDescription);
        System.out.println(r1 ? "更新成功" : "更新失败");

        System.out.println("--------------------------------------------------------------");
        // 如果三室以下的住宅价格不能上涨10%
        House data2 = new House(houseId);
        newPrice = 740000;
        boolean r2 = data2.UpdateHouse(newAddress, newType, newPrice, newBedrooms, newBathrooms, newCarspace, newSize, newDescription);
        System.out.println(r2 ? "更新成功" : "更新失败");
    }

    @Test
    public void houseCase9Test() {
        // 房屋标识
        String houseId = "ABC0000008";
        // 房屋地址
        String houseAddress = "广东省广州市天河区";
        // 房屋类型
        String houseType = "Apartment";
        // 房屋价格
        double housePrice = 740000;
        // 房屋卧室数量
        int numBedrooms = 2;
        // 房屋洗手间数量
        int numBathrooms = 1;
        // 房屋停车位数量
        int numCarspace = 1;
        // 房屋面积
        double sizeHouse = 50;
        //房屋描述
        String descriptionHouse = "不错的房子";
        House data0 = new House(houseId, houseAddress, houseType, housePrice, numBedrooms, numBathrooms, numCarspace, sizeHouse, descriptionHouse);
        boolean r0 = data0.AddHouse();
        System.out.println(r0 ? "添加成功" : "添加失败");

        // 房屋地址
        String newAddress = "广东省广州市天河区";
        // 房屋类型
        String newType = "Apartment";
        // 房屋价格
        double newPrice = 740000;
        // 房屋卧室数量
        int newBedrooms = 2;
        // 房屋洗手间数量
        int newBathrooms = 1;
        // 房屋停车位数量
        int newCarspace = 1;
        // 房屋面积
        double newSize = 50;
        //房屋描述
        String newDescription = "不错的房子";

        // 对于所有类型的房屋，除了“townhouse”，应该不可能更改地址。
        House data1 = new House(houseId);
        boolean r1 = data1.UpdateHouse(newAddress, newType, newPrice, newBedrooms, newBathrooms, newCarspace, newSize, newDescription);
        System.out.println(r1 ? "更新成功" : "更新失败");

        System.out.println("--------------------------------------------------------------");

        House data2 = new House(houseId);
        newAddress = "";
        boolean r2 = data2.UpdateHouse(newAddress, newType, newPrice, newBedrooms, newBathrooms, newCarspace, newSize, newDescription);
        System.out.println(r2 ? "更新成功" : "更新失败");
    }

    @Test
    public void houseCase10Test() {
        // 房屋标识
        String houseId = "ABC0000009";
        // 房屋地址
        String houseAddress = "广东省广州市天河区";
        // 房屋类型
        String houseType = "Apartment";
        // 房屋价格
        double housePrice = 740000;
        // 房屋卧室数量
        int numBedrooms = 2;
        // 房屋洗手间数量
        int numBathrooms = 1;
        // 房屋停车位数量
        int numCarspace = 1;
        // 房屋面积
        double sizeHouse = 50;
        //房屋描述
        String descriptionHouse = "不错的房子";
        House data0 = new House(houseId, houseAddress, houseType, housePrice, numBedrooms, numBathrooms, numCarspace, sizeHouse, descriptionHouse);
        boolean r0 = data0.AddHouse();
        System.out.println(r0 ? "添加成功" : "添加失败");

        // 房屋地址
        String newAddress = "";
        // 房屋类型
        String newType = "Apartment";
        // 房屋价格
        double newPrice = 740000;
        // 房屋卧室数量
        int newBedrooms = 2;
        // 房屋洗手间数量
        int newBathrooms = 1;
        // 房屋停车位数量
        int newCarspace = 1;
        // 房屋面积
        double newSize = 70;
        //房屋描述
        String newDescription = "不错的房子";

        // 设置修改房屋大小超过10%
        House data1 = new House(houseId);
        boolean r1 = data1.UpdateHouse(newAddress, newType, newPrice, newBedrooms, newBathrooms, newCarspace, newSize, newDescription);
        System.out.println(r1 ? "更新成功" : "更新失败");

        System.out.println("--------------------------------------------------------------");

        // 设置修改房屋大小小于10%大于5%
        House data2 = new House(houseId);
        newSize = 54;
        boolean r2 = data2.UpdateHouse(newAddress, newType, newPrice, newBedrooms, newBathrooms, newCarspace, newSize, newDescription);
        System.out.println(r2 ? "更新成功" : "更新失败");
    }

    private void deleteFile() {
        File file = new File(PATH);
        if (file.exists()) {
            file.delete();
        }
    }
}
