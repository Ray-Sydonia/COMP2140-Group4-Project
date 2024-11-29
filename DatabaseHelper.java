import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.interfaces.PBEKey;

import java.sql.SQLException;


public class DatabaseHelper {
    private static final String DatabaseURL = "jdbc:sqlite:student.db"; //URL of the database to be used to establish connection

    public static void createDatabaseAndTables() {
        String createStudentsTable = "CREATE TABLE IF NOT EXISTS student ("
        + "student_id INTEGER PRIMARY KEY AUTOINCREMENT, "
        + "first_name TEXT NOT NULL, "
        + "last_name TEXT NOT NULL, "
        + "sex TEXT, "
        + "dob TEXT NOT NULL, "
        + "bert_cert_num TEXT NOT NULL, "
        + "class_placed TEXT NOT NULL, "
        + "class_leaving TEXT NOT NULL, "
        + "num_of_sibs TEXT NOT NULL, "
        + "religion TEXT NOT NULL, "
        + "pet_name TEXT NOT NULL, "
        + "address TEXT NOT NULL, "
        + "mother_name TEXT NOT NULL, "
        + "mother_cnum TEXT NOT NULL, "
        + "mother_addr TEXT NOT NULL, "
        + "mother_occu TEXT NOT NULL, "
        + "mother_wnum TEXT NOT NULL, "
        + "father_name TEXT NOT NULL, "
        + "father_cnum TEXT NOT NULL, "
        + "father_addr TEXT NOT NULL, "
        + "father_occu TEXT NOT NULL, "
        + "father_wnum TEXT NOT NULL, "
        + "gaurdian_name TEXT NOT NULL, "
        + "gaurdian_cnum TEXT NOT NULL, "
        + "gaurdian_addr TEXT NOT NULL, "
        + "gaurdian_occu TEXT NOT NULL, "
        + "gaurdian_wnum TEXT NOT NULL, "
        + "emerg_c1name TEXT NOT NULL, "
        + "emerg_c1addr TEXT NOT NULL, "
        + "emerg_c1num TEXT NOT NULL, "
        + "emerg_c2name TEXT NOT NULL, "
        + "emerg_c2addr TEXT NOT NULL, "
        + "emerg_c2num TEXT NOT NULL, "
        + "last_ecc TEXT NOT NULL, "
        + "reason_for_leaving TEXT NOT NULL, "
        + "person_to_collect TEXT NOT NULL, "
        + "special_diet TEXT NOT NULL, "
        + "date_created TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP"
        +");";

        File databaseFile = new File("student.db");
        if (!databaseFile.exists()) {  
            System.out.println("No Database Found");
            System.out.println("Creating a New Database...");
        } 
        else {
                System.out.println("Database Already Exists");
        }

        try (Connection conn = DriverManager.getConnection(DatabaseURL);
            Statement stmt = conn.createStatement()) {   
            
            stmt.execute(createStudentsTable);

            // System.out.println("Database created successfully.");
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }


    }



    public static void insertStudent(Student student) {
        String studentSQL = "INSERT INTO student (first_name, last_name, sex, dob, bert_cert_num, class_placed, "
        + "class_leaving, num_of_sibs, religion, pet_name, address, mother_name, mother_cnum, mother_addr, mother_occu, mother_wnum, "
        + "father_name, father_cnum, father_addr, father_occu, father_wnum, gaurdian_name, gaurdian_cnum, gaurdian_addr, gaurdian_occu, "
        + "gaurdian_wnum, emerg_c1name, emerg_c1addr, emerg_c1num, emerg_c2name, emerg_c2addr, emerg_c2num, last_ecc, reason_for_leaving, "
        + "person_to_collect, special_diet) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
        + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        try (Connection conn = DriverManager.getConnection(DatabaseURL);
            PreparedStatement prepStatement = conn.prepareStatement(studentSQL, PreparedStatement.RETURN_GENERATED_KEYS)){


            
            
            prepStatement.setString(1, student.getStudentFname()); 
            prepStatement.setString(2, student.getStudentLname());
            prepStatement.setString(3, student.getStudentSex());
            prepStatement.setString(4, student.getStudentDOB());
            prepStatement.setString(5, student.getBirthCertNum());
            prepStatement.setString(6, student.getClassPlaced());
            prepStatement.setString(7, student.getClassLeaving());
            prepStatement.setString(8, student.getNumOfSiblings());
            prepStatement.setString(9, student.getReligion());
            prepStatement.setString(10, student.getPetName());
            prepStatement.setString(11, student.getAddress());

            prepStatement.setString(12, student.getMotherName());
            prepStatement.setString(13, student.getMotherNum());
            prepStatement.setString(14, student.getMotherAddr());
            prepStatement.setString(15, student.getMotherOcc());
            prepStatement.setString(16, student.getMotherWorkNum());

            prepStatement.setString(17, student.getFatherName());
            prepStatement.setString(18, student.getFatherNum());
            prepStatement.setString(19, student.getFatherAddr());
            prepStatement.setString(20, student.getFatherOcc());
            prepStatement.setString(21, student.getFatherWorkNum());

            prepStatement.setString(22, student.getGaurdianName());
            prepStatement.setString(23, student.getGaurdianNum());
            prepStatement.setString(24, student.getGaurdianAddr());
            prepStatement.setString(25, student.getGaurdianOcc());
            prepStatement.setString(26, student.getGaurdianWorkNum());

            prepStatement.setString(27, student.getEmergency1Name());
            prepStatement.setString(28, student.getEmergency1Addr());
            prepStatement.setString(29, student.getEmergency1Num());
            prepStatement.setString(30, student.getEmergency2Name());
            prepStatement.setString(31, student.getEmergency2Addr());
            prepStatement.setString(32, student.getEmergency2Num());

            prepStatement.setString(33, student.getLastEccAttended());
            prepStatement.setString(34, student.getReasonForLeaveLastSch());
            prepStatement.setString(35, student.getPersonToCollectChild());
            prepStatement.setString(36, student.getSpecialDietReq());

            prepStatement.executeUpdate();
            System.out.println("Student Added!");
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static Student searchStudentById(int studentId) {
        Student student = null;
        String query = "SELECT * FROM student WHERE student_id = ?";

        try (Connection conn = DriverManager.getConnection(DatabaseURL);
             PreparedStatement prepStatement = conn.prepareStatement(query)) {

            prepStatement.setInt(1, studentId);

            // ResultSet rs = prepStatement.executeQuery();
            try (ResultSet rs = prepStatement.executeQuery()) {
                System.out.print(rs);
                
                if (rs.next()) {
                    // Student student = new Student();
                    // rs.getString("student_id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    String sex = rs.getString("sex");
                    String dob = rs.getString("dob");
                    String bcNumber = rs.getString("bert_cert_num");
                    String classPlaced = rs.getString("class_placed");
                    String classLeaving = rs.getString("class_leaving");
                    String numOfSiblings = rs.getString("num_of_sibs");
                    String religion = rs.getString("religion");
                    String petName = rs.getString("pet_name");
                    String address = rs.getString("address");

                    String motherName = rs.getString("mother_name");
                    String motherContactNumber = rs.getString("mother_cnum");
                    String motherAddress= rs.getString("mother_addr");
                    String motherOccupation= rs.getString("mother_occu");
                    String motherWorkNumber = rs.getString("mother_wnum");

                    String fatherName = rs.getString("father_name");
                    String fatherContactNumber = rs.getString("father_cnum");
                    String fatherAddress = rs.getString("father_addr");
                    String fatherOccupation = rs.getString("father_occu");
                    String fatherWorkNumber = rs.getString("father_wnum");

                    String gaurdianName = rs.getString("gaurdian_name");
                    String gaurdianContactNumber = rs.getString("gaurdian_cnum");
                    String gaurdianAddress = rs.getString("gaurdian_addr");
                    String gaurdianOccupation = rs.getString("gaurdian_occu");
                    String gaurdianWorkNumber = rs.getString("gaurdian_wnum");

                    String emergencyContact1Name =  rs.getString("emerg_c1name");
                    String emergencyContact1Address = rs.getString("emerg_c1addr");
                    String emergencyContact1Phone = rs.getString("emerg_c1num");
                    String emergencyContact2Name = rs.getString("emerg_c2name");
                    String emergencyContact2Address = rs.getString("emerg_c2addr");
                    String emergencyContact2Phone = rs.getString("emerg_c2num");

                    String lastECC = rs.getString("last_ecc");
                    String reasonForLeaving = rs.getString("reason_for_leaving");
                    String personCollectChildName = rs.getString("person_to_collect");
                    String specialDiet = rs.getString("special_diet");
                    
                    student = new Student(firstName, lastName, sex,  dob, bcNumber ,classPlaced, classLeaving, numOfSiblings, religion,petName, 
                    address, motherName, motherContactNumber, motherAddress, motherOccupation, motherWorkNumber, fatherName, fatherContactNumber,
                    fatherAddress, fatherOccupation, fatherWorkNumber, gaurdianName, gaurdianContactNumber, gaurdianAddress, gaurdianOccupation, 
                    gaurdianWorkNumber, emergencyContact1Name, emergencyContact1Address, emergencyContact1Phone, emergencyContact2Name, 
                    emergencyContact2Address, emergencyContact2Phone, lastECC, reasonForLeaving, personCollectChildName, specialDiet);
                    
                    
                    
                } else {
                    System.out.println("No student found with ID: " + studentId);
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }

        return student;
    }

    public static boolean removeStudentRecord(int studentId) {
        String sql = "DELETE FROM student WHERE student_id = ?";

        try (Connection conn = DriverManager.getConnection(DatabaseURL);
             PreparedStatement prepStatement= conn.prepareStatement(sql)) {

            prepStatement.setInt(1, studentId);

            int rowsAffected = prepStatement.executeUpdate();

            
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Error occurred while deleting student record: " + e.getMessage());
            return false;
        }
    }

    public static ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();


        String queryString = "SELECT * FROM student";

        try (Connection conn = DriverManager.getConnection(DatabaseURL);
            Statement stmt = conn.createStatement();
            
             ResultSet rs = stmt.executeQuery(queryString)) {

            
            while (rs.next()) {
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    String sex = rs.getString("sex");
                    String dob = rs.getString("dob");
                    String bcNumber = rs.getString("bert_cert_num");
                    String classPlaced = rs.getString("class_placed");
                    String classLeaving = rs.getString("class_leaving");
                    String numOfSiblings = rs.getString("num_of_sibs");
                    String religion = rs.getString("religion");
                    String petName = rs.getString("pet_name");
                    String address = rs.getString("address");

                    String motherName = rs.getString("mother_name");
                    String motherContactNumber = rs.getString("mother_cnum");
                    String motherAddress= rs.getString("mother_addr");
                    String motherOccupation= rs.getString("mother_occu");
                    String motherWorkNumber = rs.getString("mother_wnum");

                    String fatherName = rs.getString("father_name");
                    String fatherContactNumber = rs.getString("father_cnum");
                    String fatherAddress = rs.getString("father_addr");
                    String fatherOccupation = rs.getString("father_occu");
                    String fatherWorkNumber = rs.getString("father_wnum");

                    String gaurdianName = rs.getString("gaurdian_name");
                    String gaurdianContactNumber = rs.getString("gaurdian_cnum");
                    String gaurdianAddress = rs.getString("gaurdian_addr");
                    String gaurdianOccupation = rs.getString("gaurdian_occu");
                    String gaurdianWorkNumber = rs.getString("gaurdian_wnum");

                    String emergencyContact1Name =  rs.getString("emerg_c1name");
                    String emergencyContact1Address = rs.getString("emerg_c1addr");
                    String emergencyContact1Phone = rs.getString("emerg_c1num");
                    String emergencyContact2Name = rs.getString("emerg_c2name");
                    String emergencyContact2Address = rs.getString("emerg_c2addr");
                    String emergencyContact2Phone = rs.getString("emerg_c2num");

                    String lastECC = rs.getString("last_ecc");
                    String reasonForLeaving = rs.getString("reason_for_leaving");
                    String personCollectChildName = rs.getString("person_to_collect");
                    String specialDiet = rs.getString("special_diet");
                    
                    Student student = new Student(firstName, lastName, sex,  dob, bcNumber ,classPlaced, classLeaving, numOfSiblings, religion,petName, 
                    address, motherName, motherContactNumber, motherAddress, motherOccupation, motherWorkNumber, fatherName, fatherContactNumber,
                    fatherAddress, fatherOccupation, fatherWorkNumber, gaurdianName, gaurdianContactNumber, gaurdianAddress, gaurdianOccupation, 
                    gaurdianWorkNumber, emergencyContact1Name, emergencyContact1Address, emergencyContact1Phone, emergencyContact2Name, 
                    emergencyContact2Address, emergencyContact2Phone, lastECC, reasonForLeaving, personCollectChildName, specialDiet);
                
                students.add(student);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving students from the database: " + e.getMessage());
        }

        
        return students;
    }
}

