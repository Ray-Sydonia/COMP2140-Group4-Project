public class Student{
    
    static private int studentID = 0;
    
    // Student Information Attributes
    private String lastName;
    private String firstName;
    private String sex;
    private String dob;
    private String bcNumber;
    private String classPlaced;
    private String classLeaving;
    private String numOfSiblings;
    private String religion;
    private String petName;
    private String address;


    // Parents/Guardian Information Attributes
    private String motherName, motherContactNumber, motherAddress, motherOccupation, motherWorkNumber;
    private String fatherName, fatherContactNumber,  fatherAddress, fatherOccupation, fatherWorkNumber;
    private String gaurdianName, gaurdianContactNumber, gaurdianAddress, gaurdianOccupation, gaurdianWorkNumber;


    // Emergency Contacts
    private String emergencyContact1Name, emergencyContact1Address, emergencyContact1Phone;
    private String emergencyContact2Name, emergencyContact2Address, emergencyContact2Phone;
    
    //other
    private String lastECC, reasonForLeaving, personCollectChildName, specialDiet;
    // private String date;

    
    
    public Student(String firstName, String lastName, String sex, String dob, String bcNumber,String classPlaced, 
    String classLeaving, String numOfSiblings, String religion, String petName, String address, String motherName, 
    String motherContactNumber, String motherAddress, String motherOccupation, String motherWorkNumber, String fatherName, 
    String fatherContactNumber,  String fatherAddress, String fatherOccupation, String fatherWorkNumber, String gaurdianName, 
    String gaurdianContactNumber, String gaurdianAddress, String gaurdianOccupation, String gaurdianWorkNumber, 
    String emergencyContact1Name, String emergencyContact1Address, String emergencyContact1Phone, String emergencyContact2Name, 
    String emergencyContact2Address, String emergencyContact2Phone, String lastECC, String reasonForLeaving, 
    String personCollectChildName, String specialDiet){

        // studentID = ++studentID;

        //Student Info
        this.lastName = lastName;
        this.firstName = firstName;
        this.sex = sex;
        this.dob = dob;
        this.bcNumber = bcNumber;
        this.classPlaced = classPlaced;
        this.classLeaving = classLeaving;
        this.numOfSiblings = numOfSiblings;
        this.religion = religion;
        this.petName = petName;
        this.address = address;

        //Mother Info
        this.motherName = motherName; 
        this.motherContactNumber = motherContactNumber; 
        this.motherAddress = motherAddress; 
        this.motherOccupation = motherOccupation; 
        this.motherWorkNumber = motherWorkNumber;

        //Father Info
        this.fatherName = fatherName; 
        this.fatherContactNumber = fatherContactNumber; 
        this.fatherAddress = fatherAddress; 
        this.fatherOccupation = fatherOccupation; 
        this.fatherWorkNumber = fatherWorkNumber;

        //Gaurdian Info
        this.gaurdianName = gaurdianName; 
        this.gaurdianContactNumber = gaurdianContactNumber; 
        this.gaurdianAddress = gaurdianAddress; 
        this.gaurdianOccupation = gaurdianOccupation; 
        this.gaurdianWorkNumber = gaurdianWorkNumber;

        //Emergency Contact
        this.emergencyContact1Name = emergencyContact1Name; 
        this.emergencyContact1Address = emergencyContact1Address; 
        this.emergencyContact1Phone = emergencyContact1Phone;

        this.emergencyContact2Name = emergencyContact2Name; 
        this.emergencyContact2Address = emergencyContact2Address; 
        this.emergencyContact2Phone = emergencyContact2Phone;

        //Other Info
        this.lastECC = lastECC; 
        this.reasonForLeaving = reasonForLeaving; 
        this.personCollectChildName = personCollectChildName; 
        this.specialDiet = specialDiet;


    }
    
    public int getID(){
        return studentID;
    }
    
    // Student Information Methods
    public String getStudentLname(){
        return lastName;
    }

    public String getStudentFname(){
        return firstName;
    }

    public String getStudentSex(){
        return sex;
    }

    public String getStudentDOB(){
        return dob;
    } 

    public String getBirthCertNum(){
        return bcNumber;
    }

    public String getNumOfSiblings(){
        return numOfSiblings;
    }

    public String getClassPlaced(){
        return classPlaced;
    }

    public String getClassLeaving(){
        return classLeaving;
    }

    public String getReligion(){
        return religion;
    }

    public String getPetName(){
        return petName;
    }

    public String getAddress(){
        return address;
    }


    // Parents/Guardian Information Methods
    //Mother Information
    public String getMotherName(){
        return motherName;
    }

    public String getMotherNum(){
        return motherContactNumber;
    }
    
    public String getMotherAddr(){
        return motherAddress;
    }

    public String getMotherOcc(){
        return motherOccupation;
    }

    public String getMotherWorkNum(){
        return motherWorkNumber;
    }

    
    //Father Information
    public String getFatherName(){
        return fatherName;
    }

    public String getFatherNum(){
        return fatherContactNumber;
    }
    
    public String getFatherAddr(){
        return fatherAddress;
    }

    public String getFatherOcc(){
        return fatherOccupation;
    }

    public String getFatherWorkNum(){
        return fatherWorkNumber;
    }

    
    //Gaurdian Information
    public String getGaurdianName(){
        return gaurdianName;
    }

    public String getGaurdianNum(){
        return gaurdianContactNumber;
    }
    
    public String getGaurdianAddr(){
        return gaurdianAddress;
    }

    public String getGaurdianOcc(){
        return gaurdianOccupation;
    }

    public String getGaurdianWorkNum(){
        return gaurdianWorkNumber;
    }


    // Emergency Contacts
    //Contact #1
    public String getEmergency1Name(){
        return emergencyContact1Name;
    }

    public String getEmergency1Num(){
        return emergencyContact1Phone;
    }

    public String getEmergency1Addr(){
        return emergencyContact1Address;
    }

    //Contact #2
    public String getEmergency2Name(){
        return emergencyContact2Name;
    }

    public String getEmergency2Num(){
        return emergencyContact2Phone;
    }

    public String getEmergency2Addr(){
        return emergencyContact2Address;
    } 

    //other
    public String getLastEccAttended(){
        return lastECC;
    }

    public String getReasonForLeaveLastSch(){
        return reasonForLeaving;
    }

    public String getPersonToCollectChild(){
        return personCollectChildName;
    }

    public String getSpecialDietReq(){
        return specialDiet;
    }

    

}