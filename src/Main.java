import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        System.out.println("Welcome to the Storage support console application!");

        while (true) {
            printMenu();
            Scanner console = new Scanner(System.in);
            int menuNum = console.nextInt();
            if (menuNum == 1) {
                System.out.println("Please enter 1, if you act as an individual, or 2, if you represent a legal entity");
                int menuNum1 = console.nextInt();
                if (menuNum1 == 1) {
                    fillParcelOfIndividuals();
                } else if (menuNum1 == 2) {
                    fillParcelOfLegalEntities();
                } else {
                    System.out.println("You should enter 1 for an individual or 2 for a legal entity");
                }
            } else if (menuNum == 2) {
                System.out.println("Please enter 1, if you act as an individual, or 2, if you represent a legal entity");
                int menuNum3 = console.nextInt();
                if (menuNum3 == 1) {
                    printIndividualParcelById();
                } else if (menuNum3 == 2) {
                    printEntityParcelById();
                } else {
                    System.out.println("You should enter 1 for an individual or 2 for a legal entity");
                }
            } else if (menuNum == 3) {
                System.out.println("Please enter 1, if you act as an individual, or 2, if you represent a legal entity");
                int menuNum2 = console.nextInt();
                if (menuNum2 == 1) {
                    Scanner console5 = new Scanner(System.in);
                    System.out.println("Please type the parcel's ID");
                    long parId = console5.nextLong();
                    calculateStoragePeriodForIndividual(parId);
                } else if (menuNum2 == 2) {
                    Scanner console6 = new Scanner(System.in);
                    System.out.println("Please type the parcel's ID");
                    long parId1 = console6.nextLong();
                    calculateStoragePeriodForEntity(parId1);
                } else {
                    System.out.println("You should enter 1 for an individual or 2 for a legal entity");
                }
            } else if (menuNum == 4) {
                System.out.println("Please enter 1, if you act as an individual, or 2, if you represent a legal entity");
                int menuNum5 = console.nextInt();
                if (menuNum5 == 1) {
                    Scanner console6 = new Scanner(System.in);
                    System.out.println("Please type the parcel's ID");
                    long parId1 = console6.nextLong();
                    long storageDaysForIndividual = calculateStoragePeriodForIndividual(parId1);
                    float dailyPriceForIndividual = getDailyPriceOfIndividualParcelById(parId1);
                    float amountOfStorageChargeForIndividual =  amountOfStorageChargeForIndividual(parId1,
                            storageDaysForIndividual, dailyPriceForIndividual);
                    System.out.println("The amount of the storage charge for the specified parcel and period is " +
                            amountOfStorageChargeForIndividual);
                } else if (menuNum5 == 2) {
                    Scanner console7 = new Scanner(System.in);
                    System.out.println("Please type the parcel's ID");
                    long parId2 = console7.nextLong();
                    long storageDaysForLegalEntity = calculateStoragePeriodForEntity(parId2);

                    float dailyPriceForLegalEntity = getDailyPriceOfEntityParcelById(parId2);
                    float amountOfStorageChargeForLegalEntity = (float) amountOfStorageChargeForLegalEntity(parId2,
                            storageDaysForLegalEntity, dailyPriceForLegalEntity);
                    System.out.println("The amount of the storage charge for the specified parcel and period is " +
                            amountOfStorageChargeForLegalEntity);
                } else {
                    System.out.println("You should enter 1 for an individual or 2 for a legal entity");
                }
            } else if (menuNum == 5) {
                System.out.println("Thank you for using this application");
                System.exit(0);
            }
        }
    }



    public static void printMenu() {
        System.out.println("Please make your choice from this menu by entering the relevant number in console:");
        System.out.println("1. Create a new storage parcel");
        System.out.println("2. Find existing parcel with its ID number");
        System.out.println("3. Calculate the period of storage for specified / existing parcel");
        System.out.println("4. Calculate an amount of the storage charge for existing parcel");
        System.out.println("5. Exit from the application");
    }
    public static ArrayList<ParcelOfIndividual> parcelOfIndividuals = new ArrayList<>();
    public static void fillParcelOfIndividuals() {
        Scanner console = new Scanner(System.in);
        System.out.println("Please type your parcel's ID");
        long parcelID1 = console.nextLong();
        System.out.println("Please type your name in the format NameSurname");
        String name1 = console.next();
        System.out.println("Please type your tax ID");
        long individualId2 = console.nextLong();
        System.out.println("Please indicate your gender by typing M for a man or W for a woman");
        String gen = console.next();
        Gender gend = null;
        if (gen.equals("M")) {
            gend = Gender.MAN;
        } else if (gen.equals("W")) {
            gend = Gender.WOMAN;
        } else {
            gend = Gender.TRANS;
        }
        System.out.println("Please type P, if you are registered as private entrepreneur, or I," +
                "if you act as an ordinary individual");
        String indSt = console.next();
        IndividualStatus indStatus = null;
        if (indSt.equals("P")) {
            indStatus = IndividualStatus.PRIVATEENTREPRENEUR;
        } else if (indSt.equals("I")) {
            indStatus = IndividualStatus.ORDINARYINDIVIDUAL;
        }
        System.out.println("Please type S, if your parcel is of small size, or M," +
                "if your parcel is of medium size, or B, if your parcel is of big size");
        String parcelCateg1 = console.next();
        ParcelCategories pCateg = null;
        if (parcelCateg1.equals("S")) {
            pCateg = ParcelCategories.SMALLPARCEL;
        } else if (parcelCateg1.equals("M")) {
            pCateg = ParcelCategories.MEDIUMPARCEL;
        } else if (parcelCateg1.equals("B")) {
            pCateg = ParcelCategories.BIGPARCEL;
        };
        System.out.println("Please type the parcel's date of transfer to storage in the format MM/DD/YYYY");
        String date1 = console.next()+ " 12:00:00";
        System.out.println("Please type a price of the daily storage of a medium parcel in the format XX.XX");
        float dailyPrice1 = (float) console.nextFloat();

        parcelOfIndividuals.add(new ParcelOfIndividual(parcelID1, new BailorIndividual(name1, individualId2, gend), pCateg,
                indStatus, date1, dailyPrice1));


        System.out.println ("You have successfully created a new storage parcel");

    }
    public static ArrayList<ParcelOfLegalEntity> parcelOfLegalEntities = new ArrayList<>();
    public static void fillParcelOfLegalEntities() {
        Scanner console2 = new Scanner(System.in);
        System.out.println("Please type your parcel's ID");
        long parcelID2 = console2.nextLong();
        System.out.println("Please type the name of your legal entity");
        String name2 = console2.next();
        System.out.println("Please type tax ID of your legal entity");
        long legalEntityId3 = console2.nextLong();
        System.out.println("Please type VAT registration number of your legal entity");
        long numberVat = console2.nextLong();
        System.out.println("Please type S, if your parcel is of small size, or M," +
                "if your parcel is of medium size, or B, if your parcel is of big size");
        String parcelCateg2 = console2.next();
        ParcelCategories pCateg2 = null;
        if (parcelCateg2.equals("S")) {
            pCateg2 = ParcelCategories.SMALLPARCEL;
        } else if (parcelCateg2.equals("M")) {
            pCateg2 = ParcelCategories.MEDIUMPARCEL;
        } else if (parcelCateg2.equals("B")) {
            pCateg2 = ParcelCategories.BIGPARCEL;
        };
        System.out.println("Please type the parcel's date of transfer to storage in format MM/DD/YYYY");
        String date2 = console2.next()+ " 12:00:00";
        System.out.println("Please type a price of the daily storage of a medium parcel in the format XX.XX");
        float dailyPrice2 = (float) console2.nextFloat();

        parcelOfLegalEntities.add (new ParcelOfLegalEntity (parcelID2, new BailorLegalEntity (name2, legalEntityId3,
                numberVat), pCateg2, date2, dailyPrice2));

        System.out.println ("You have successfully created a new storage parcel");

    }

    // Methods for individuals
    public static long calculateStoragePeriodForIndividual(long parId) throws ParseException {

        String initDate = getDateOfIndividualParcelById(parId);
        Scanner console3 = new Scanner(System.in);
        System.out.println("Please type the parcel's date of extracting from storage (the storage final date) " +
                "in format MM/DD/YYYY");
        String finalDate = console3.next()+ " 12:00:00";
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date d1 = null;
        Date d2 = null;
        d1 = format.parse(initDate);
        d2 = format.parse(finalDate);
        long diff = d2.getTime() - d1.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);
        System.out.println(diffDays + " days of storage ");
        return diffDays;

    }
    public static String getDateOfIndividualParcelById (long x) {
        ParcelOfIndividual current = null;

        for (ParcelOfIndividual parcelOfIndividual : parcelOfIndividuals) {
            if (parcelOfIndividual.getIndividualParcelID() == x) {
                current = parcelOfIndividual;
            } else {
                System.out.println("There is no parcel with such ID. Try again");
            }
        }
        return current.getDateOfTransfer();
    }

    public static void printIndividualParcelById () {
        Scanner console8 = new Scanner(System.in);
        System.out.println("Please type your parcel's ID");
        long parcelID4 = console8.nextLong();
        ParcelOfIndividual current = null;
        for (ParcelOfIndividual parcelOfIndividual : parcelOfIndividuals) {
            if (parcelOfIndividual.getIndividualParcelID() == parcelID4) {
                current = parcelOfIndividual;

            } else {
                System.out.println("There is no parcel with such ID. Try again");
            }
        } System.out.println(current.toString());
    }


    public static float getDailyPriceOfIndividualParcelById (long y) {
        ParcelOfIndividual current = null;
        for (ParcelOfIndividual parcelOfIndividual : parcelOfIndividuals) {
            if (parcelOfIndividual.getIndividualParcelID() == y) {
                current = parcelOfIndividual;
            } else {
                System.out.println("There is no parcel with such ID. Try again");
            }
        }
        return current.getPriceOfDailyStorage();
    }

    public static float amountOfStorageChargeForIndividual (long parId1, long storageDaysForIndividual,
                                                            float dailyPriceForIndividual) {
        IndividualStatus indStatus = getIndividualStatus(parId1);
        ParcelCategories parCateg = getParcelCategory(parId1);
        float storageChargeAmount =0;
        if (indStatus == IndividualStatus.ORDINARYINDIVIDUAL) {
            switch (parCateg) {
                case SMALLPARCEL:
                    storageChargeAmount = storageDaysForIndividual * dailyPriceForIndividual/2;
                    break;
                case MEDIUMPARCEL:
                    storageChargeAmount = storageDaysForIndividual * dailyPriceForIndividual;
                    break;
                case BIGPARCEL:
                    storageChargeAmount = storageDaysForIndividual * dailyPriceForIndividual*2;
                    break;
            }
        } else { // 20 per cent VAT is charged additionally for PRIVATE ENTREPRENEURS
            switch (parCateg) {
                case SMALLPARCEL:
                    storageChargeAmount = (float) ((storageDaysForIndividual * dailyPriceForIndividual / 2)*1.2);
                    break;
                case MEDIUMPARCEL:
                    storageChargeAmount = (float) ((storageDaysForIndividual * dailyPriceForIndividual)*1.2);
                    break;
                case BIGPARCEL:
                    storageChargeAmount = (float) ((storageDaysForIndividual * dailyPriceForIndividual * 2)*1.2);
                    break;
            }
        } return storageChargeAmount;
    }
    public static IndividualStatus getIndividualStatus (long parId1) {
        ParcelOfIndividual current = null;

        for (ParcelOfIndividual parcelOfIndividual : parcelOfIndividuals) {
            if (parcelOfIndividual.getIndividualParcelID() == parId1) {
                current = parcelOfIndividual;
            } else {
                System.out.println("There is no parcel with such ID. Try again");
            }
        }
        return current.getIndividualStatus();
    }
    public static ParcelCategories getParcelCategory (long parId1) {
        ParcelOfIndividual current = null;

        for (ParcelOfIndividual parcelOfIndividual : parcelOfIndividuals) {
            if (parcelOfIndividual.getIndividualParcelID() == parId1) {
                current = parcelOfIndividual;
            } else {
                System.out.println("There is no parcel with such ID. Try again");
            }
        }
        return current.getParcelCategory();
    }

    // Methods for legal entities

    public static long calculateStoragePeriodForEntity(long parId1) throws ParseException {

        String initDate = getDateOfEntityParcelById(parId1);
        Scanner console3 = new Scanner(System.in);
        System.out.println("Please type the parcel's date of extracting from storage (the storage final date) " +
                "in format MM/DD/YYYY");
        String finalDate = console3.next()+ " 12:00:00";
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date d1 = null;
        Date d2 = null;
        d1 = format.parse(initDate);
        d2 = format.parse(finalDate);
        long diff = d2.getTime() - d1.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);
        System.out.println(diffDays + " days of storage");
        return diffDays;

    }
    public static String getDateOfEntityParcelById (long parId1) {
        ParcelOfLegalEntity current = null;

        for (ParcelOfLegalEntity parcelOfLegalEntity : parcelOfLegalEntities) {
            if (parcelOfLegalEntity.getLegalEntityParcelID() == parId1) {
                current = parcelOfLegalEntity;
            } else {
                System.out.println("There is no parcel with such ID. Try again");
            }
        }
        return current.getDateOfTransfer();
    }

    public static void printEntityParcelById () {
        Scanner console9 = new Scanner(System.in);
        System.out.println("Please type your parcel's ID");
        long parcelID5 = console9.nextLong();
        ParcelOfLegalEntity current = null;
        for (ParcelOfLegalEntity parcelOfLegalEntity : parcelOfLegalEntities) {
            if (parcelOfLegalEntity.getLegalEntityParcelID() == parcelID5) {
                current = parcelOfLegalEntity;
            } else {
                System.out.println("There is no parcel with such ID. Try again");
            }
        } System.out.println(current.toString());
    }

    public static float getDailyPriceOfEntityParcelById (long v) {
        ParcelOfLegalEntity current = null;

        for (ParcelOfLegalEntity parcelOfLegalEntity : parcelOfLegalEntities) {
            if (parcelOfLegalEntity.getLegalEntityParcelID() == v) {
                current = parcelOfLegalEntity;
            } else {
                System.out.println("There is no parcel with such ID. Try again");
            }
        }
        return current.getPriceOfDailyStorage();

    }


    public static float amountOfStorageChargeForLegalEntity (long parId2, long storageDaysForLegalEntity,
                                                            float dailyPriceForLegalEntity) {

        ParcelCategories parCateg = getParcelCategory1(parId2);
        float storageChargeAmount1 = 0;
            switch (parCateg) {
                case SMALLPARCEL:
                    storageChargeAmount1 = (float) ((storageDaysForLegalEntity * dailyPriceForLegalEntity / 2)*1.2);
                    break;
                case MEDIUMPARCEL:
                    storageChargeAmount1 = (float) ((storageDaysForLegalEntity * dailyPriceForLegalEntity)*1.2);
                    break;
                case BIGPARCEL:
                    storageChargeAmount1 = (float) ((storageDaysForLegalEntity * dailyPriceForLegalEntity * 2)*1.2);
                    break;
            } return storageChargeAmount1;
        }




    public static ParcelCategories getParcelCategory1 (long parId2) {
        ParcelOfLegalEntity current = null;

        for (ParcelOfLegalEntity parcelOfLegalEntity : parcelOfLegalEntities) {
            if (parcelOfLegalEntity.getLegalEntityParcelID() == parId2) {
                current = parcelOfLegalEntity;
            } else {
                System.out.println("There is no parcel with such ID. Try again");
            }
        }
        return current.getParcelCategory();
    }

}
