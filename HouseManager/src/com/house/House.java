package com.house;




import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class House {

    // house ID
    private String houseId;

    // house address
    private String houseAddress;

    // house type
    private String houseType;

    // house price
    private double housePrice;

    // unmber of bedroom
    private int numBedrooms;

    // number of bathroom
    private int numBathrooms;

    // car space
    private int numCarspace;

    // house size
    private double sizeHouse;

    //description
    private String descriptionHouse;

    /**
     * Full parameter constructor
     *
     * @param houseId
     * @param houseAddress
     * @param houseType
     * @param housePrice
     * @param numBedrooms
     * @param numBathrooms
     * @param numCarspace
     * @param sizeHouse
     * @param descriptionHouse
     */
    public House(String houseId, String houseAddress, String houseType, double housePrice, int numBedrooms, int numBathrooms, int numCarspace, double sizeHouse, String descriptionHouse) {
        this.houseId = houseId;
        this.houseAddress = houseAddress;
        this.houseType = houseType;
        this.housePrice = housePrice;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.numCarspace = numCarspace;
        this.sizeHouse = sizeHouse;
        this.descriptionHouse = descriptionHouse;
    }

    /**
     *Identity constructor method
     *
     * @param houseId
     */
    public House(String houseId) {
        this.houseId = houseId;
    }

    /**
     *Override the toString function to easily generate a saved string
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(houseId).append("@@@@@");
        sb.append(houseAddress).append("@@@@@");
        sb.append(houseType).append("@@@@@");
        sb.append(housePrice).append("@@@@@");
        sb.append(numBedrooms).append("@@@@@");
        sb.append(numBathrooms).append("@@@@@");
        sb.append(numCarspace).append("@@@@@");
        sb.append(sizeHouse).append("@@@@@");
        sb.append(descriptionHouse);
        return sb.toString();
    }


    public boolean AddHouse() {
        // House ID should be exactly 10-character long and the first three characters should be upper case letters (A-Z) and the rest should be numbers between 1-9
        Pattern pattern = Pattern.compile("^[A-Z]{3}+[0-9]{7}?");
        if (!pattern.matcher(this.houseId).matches()) {
            System.out.println("House ID should be exactly 10-character long and the first three characters should be upper case letters (A-Z) and the rest should be numbers between 1-9");
            System.out.println(String.format("houseId：%s", houseId));
            return false;
        }

        //The House description should be between 5 and 10 words long.
        if (this.descriptionHouse == null || "".equals(this.descriptionHouse) || this.descriptionHouse.length() < 5 || this.descriptionHouse.length() > 10) {
            System.out.println("The House description should be between 5 and 10 words long.");
            System.out.println(String.format("descriptionHouse：%s", descriptionHouse));
            return false;
        }

        // It should not be possible to add houses that have more than 4 bedrooms and the number of their bathrooms is 2 or less.
        if (this.numBedrooms > 4 && this.numBathrooms <= 2) {
            System.out.println("It should not be possible to add houses that have more than 4 bedrooms and the number of their bathrooms is 2 or less.");
            System.out.println(String.format("numBedrooms：%s", numBedrooms));
            System.out.println(String.format("numBathrooms：%s", numBathrooms));
            return false;
        }

        // It should not be possible to add houses with less than < 50 m2 size and their price is more than $350000.
        if (this.housePrice > 350000 && this.sizeHouse < 50) {
            System.out.println("It should not be possible to add houses with less than < 50 m2 size and their price is more than $350000.");
            System.out.println(String.format("housePrice：%s", housePrice));
            System.out.println(String.format("sizeHouse：%s", sizeHouse));
            return false;
        }

        //  Houses with the type “Apartment” should have at least one car space. The other types of houses can have zero or more care spaces.
        if ("Apartment".equals(this.houseType) && this.numCarspace < 1) {
            System.out.println(" Houses with the type “Apartment” should have at least one car space. The other types of houses can have zero or more care spaces.");
            System.out.println(String.format("houseType：%s", houseType));
            System.out.println(String.format("numCarspace：%s", numCarspace));
            return false;
        }

        //  The price of each house should be between $100000 and $1500000.。
        if (this.housePrice < 100000 || this.housePrice > 1500000) {
            System.out.println(" The price of each house should be between $100000 and $1500000.");
            System.out.println(String.format("housePrice：%s", housePrice));
            return false;
        }

        //The price of houses with less than 3 bedrooms and 2 bathrooms cannot exceed $750000.
        if ((this.numBedrooms < 3 || this.numBathrooms < 2) && this.housePrice > 750000) {
            System.out.println("The price of houses with less than 3 bedrooms and 2 bathrooms cannot exceed $750000.");
            System.out.println(String.format("numBedrooms：%s", numBedrooms));
            System.out.println(String.format("numBathrooms：%s", numBathrooms));
            System.out.println(String.format("housePrice：%s", housePrice));
            return false;
        }

        
        List<House> houseList = getHouseList();

        // Determine if houseId already exists or if it does, save fails
        if (houseList != null && houseList.size() > 0) {
            for (int i = 0; i < houseList.size(); i++) {
                // houseId does exist, save failed
                if (houseId.equals(houseList.get(i).houseId)) {
                    System.out.println("houseId does exist");
                    System.out.println(String.format("houseId：%s", houseId));
                    return false;
                }
            }
        }


        House house = new House(houseId, houseAddress, houseType, housePrice, numBedrooms, numBathrooms, numCarspace, sizeHouse, descriptionHouse);
        List<House> addList = new ArrayList<>();
        addList.add(house);
        // save house information
        saveHouse(addList, true);
        return true;
    }

    /**
     * update house 
     *
     * @param newAddress
     * @param newType
     * @param newPrice
     * @param newBedrooms
     * @param newBathrooms
     * @param newCarspace
     * @param newSize
     * @param newDescription
     * @return
     */
    public boolean UpdateHouse(String newAddress, String newType, double newPrice, int newBedrooms
            , int newBathrooms, int newCarspace, double newSize, String newDescription) {

        //The house ID should be 10 characters long. The first three characters should be uppercase letters (A-Z) and the remaining characters should be numbers between 1 and 9.
        Pattern pattern = Pattern.compile("^[A-Z]{3}+[0-9]{7}?");
        if (!pattern.matcher(this.houseId).matches()) {
            System.out.println("The house ID should be 10 characters long. The first three characters should be uppercase letters (A-Z) and the remaining characters should be numbers between 1 and 9.");
            System.out.println(String.format("houseId：%s", houseId));
            return false;
        }

        // If the house information stored in the file is empty, the house information cannot be updated
        List<House> houseList = getHouseList();
        if (houseList == null || houseList.size() <= 0) {
            System.out.println("If the house information stored in the file is empty, the house information cannot be updated.");
            return false;
        }

        // Gets the subscript of the old house in the list, with an initial value of -1
        int index = -1;
        for (int i = 0; i < houseList.size(); i++) {
            if (houseList.get(i).houseId.equals(this.houseId)) {
                index = i;
                System.out.println("The subscript to get information about the old house is：" + i);
                System.out.println("oldhouse information：" + houseList.get(i));
            }
        }

        // If the index is still -1, the list does not contain the house information and cannot be updated
        if (index == -1) {
            System.out.println(String.format("The house logo was not found in the old house information：%s", houseId));
            return false;
        }

        // The House description should be between 5 and 10 words long.
        if (newDescription == null || "".equals(newDescription) || newDescription.length() < 5 || newDescription.length() > 10) {
            System.out.println("The House description should be between 5 and 10 words long.");
            System.out.println(String.format("newDescription：%s", newDescription));
            return false;
        }

        //  It should not be possible to add houses that have more than 4 bedrooms and the number of their bathrooms is 2 or less.
        if (newBedrooms > 4 && newBedrooms <= 2) {
            System.out.println(" It should not be possible to add houses that have more than 4 bedrooms and the number of their bathrooms is 2 or less.");
            System.out.println(String.format("newDescription：%s", newDescription));
            return false;
        }

        // It should not be possible to add houses with less than < 50 m2 size and their price is more than $350000.
        if (newPrice > 350000 && newSize < 50) {
            System.out.println("It should not be possible to add houses with less than < 50 m2 size and their price is more than $350000.");
            System.out.println(String.format("newPrice：%s", newPrice));
            System.out.println(String.format("newSize：%s", newSize));
            return false;
        }

        //  Houses with the type “Apartment” should have at least one car space. The other types of houses can have zero or more care spaces.
        if ("Apartment".equals(newType) && newCarspace < 1) {
            System.out.println(" Houses with the type “Apartment” should have at least one car space. The other types of houses can have zero or more care spaces.");
            System.out.println(String.format("newType：%s", newType));
            System.out.println(String.format("newCarspace：%s", newCarspace));
            return false;
        }

        // The price of each house should be between $100000 and $1500000.
        if (newPrice < 100000 || newPrice > 1500000) {
            System.out.println("The price of each house should be between $100000 and $1500000.");
            System.out.println(String.format("newPrice：%s", newPrice));
            return false;
        }

        // The price of houses with less than 3 bedrooms and 2 bathrooms cannot exceed $750000.
        if (newBedrooms < 3 && newBathrooms < 2 && newPrice > 750000) {
            System.out.println("The price of houses with less than 3 bedrooms and 2 bathrooms cannot exceed $750000.");
            System.out.println(String.format("newPrice：%s", newPrice));
            return false;
        }

        //Get an instance of the old house information
        House oldHouse = houseList.get(index);
        double oldPrice = oldHouse.housePrice;
        String oldType = oldHouse.houseType;
        double oldSize = oldHouse.sizeHouse;
        // If prices of houses with less than three bedrooms cannot rise by 10%
        if (newBedrooms < 3) {
            if (((newPrice - oldPrice) / oldPrice) >= 0.1) {
                System.out.println("If prices of houses with less than three bedrooms cannot rise by 10%");
                System.out.println(String.format("oldPrice：%s", oldPrice));
                System.out.println(String.format("newPrice：%s", newPrice));
                System.out.println(String.format("present：%s", ((newPrice - oldPrice) / oldPrice) * 100));
                return false;
            }
        } else {
            // Other housing prices cannot rise by 20%
            if (((newPrice - oldPrice) / oldPrice) >= 0.2) {
                System.out.println("Other housing prices cannot rise by 20%");
                System.out.println(String.format("oldPrice：%s", oldPrice));
                System.out.println(String.format("newPrice：%s", newPrice));
                System.out.println(String.format("present：%s", ((newPrice - oldPrice) / oldPrice) * 100));
                return false;
            }
        }

        // For all types of houses, except "townhouses", it should not be possible to change the address.
        if (!"townhouse".equals(oldType) && !"townhouse".equals(newType)) {
            if (newAddress != null && !"".equals(newAddress)) {
                System.out.println("For all types of houses, except \"townhouses\", it should not be possible to change the address.");
                return false;
            }
        }

        // The size of the house can be increased by 5% to 10%..
        double present = (newSize - oldSize) / oldSize;
        if ((present > 0 && (present < 0.05 || present > 0.1)) || present < 0) {
            System.out.println("The size of the house can be increased by 5% to 10%.");
            System.out.println(String.format("oldSize：%s", oldSize));
            System.out.println(String.format("newSize：%s", newSize));
            System.out.println(String.format("present：%s", present));
            return false;
        }
        
        //built newhouse infoematiom
        House newHouse = new House(houseId, newAddress, newType, newPrice, numBedrooms, numBathrooms, numCarspace, newSize, newDescription);
        houseList.remove(index);
        houseList.add(newHouse);
        saveHouse(houseList, false);
        return true;
    }

    /**
     * Save housing information to a file
     */
    private void saveHouse(List<House> list, boolean isAppend) {
        File file = new File(HouseTest.PATH);
        if (!file.exists()) {
            try {
                System.out.println("The file storing the house information does not exist, re-create...");
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Creat fail");
            }
        }

        // Create a write I/O stream
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, isAppend)))) {
            for (int i = 0; i < list.size(); i++) {
                out.write(list.get(i).toString());
            }
        } catch (Exception e) {
            System.out.println("Failed to save the housing information value file");
            e.printStackTrace();
        }
    }

    /**
     * Get a list of housing information from the file
     *
     * @return
     */
    private List<House> getHouseList() {
        //Definition returns an empty list of data
        List<House> list = new ArrayList<>();

        // Define file path
        File file = new File(HouseTest.PATH);

        //Returns empty data if the file does not exist
        if (!file.exists()) {
            System.out.println("The file storing the house information does not exist.");
            return list;
        }

        //Start reading files and create io streams
        try (InputStream is = new FileInputStream(file);
             BufferedReader br = new BufferedReader(new InputStreamReader(is));) {
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line != null && !"".equals(line)) {
                    String[] split = line.split("@@@@@");

                    // Construct the entity class
                    House house = new House(split[0], split[1], split[2], Double.valueOf(split[3]),
                            Integer.valueOf(split[4]), Integer.valueOf(split[5]), Integer.valueOf(split[6]), Double.valueOf(split[7]), split[8]);
                    System.out.println(house);
                    // Add to the return list
                    list.add(house);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("WRONG");
        }

        return list;
    }
}
