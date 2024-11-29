import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class SearchDisplay {
    
    private JTable studentTable;

    // Student student1 = new Student("firstName", "lastName", "male",  "dob", "bcNumber" ,"classPlaced", "classLeaving", "numOfSiblings", "religion","petName", 
    //                 "address", "motherName", "motherContactNumber", "motherAddress", "motherOccupation", "motherWorkNumber", "fatherName", "fatherContactNumber",
    //                 "fatherAddress", "fatherOccupation", "fatherWorkNumber", "gaurdianName", "gaurdianContactNumber", "gaurdianAddress", "gaurdianOccupation", 
    //                 "gaurdianWorkNumber", "emergencyContact1Name", "emergencyContact1Address", "emergencyContact1Phone", "emergencyContact2Name", 
    //                 "emergencyContact2Address", "emergencyContact2Phone", "lastECC", "reasonForLeaving", "personCollectChildName", "specialDiet");

    public SearchDisplay(Student student){
        JFrame frame = new JFrame("Student");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new BorderLayout());
        


        frame.setVisible(true);

        String[] columnNames = {"First Name", "last Name", "Male",  "DOB", "Birth Certificate Number" ,"Class Placed", "Class Leaving", "# Of Siblings", "Religion","Pet Name", 
                    "Address", "Mother Name", "Mother Contact Number", "Mother Address", "Mother Occupation", "Mother Work Number", "Father Name", "Father Contact Number",
                    "Father Address", "Father Occupation", "Father Work Number", "Gaurdian Name", "Gaurdian Contact Number", "Gaurdian Address", "Gaurdian Occupation", 
                    "Gaurdian Work Number", "Emergency Contact 1 Name", "Emergency Contact 1 Address", "Emergency Contact 1 Phone", "Emergency Contact 2 Name", 
                    "Emergency Contact 2 Address", "Emergency Contact 2 Phone", "Last ECC", "Reason For Leaving", "Person to Collect Child", "Special Diet"};
        Object[][] data = new Object[1][36];   
        
        
        data[1][0] = student.getStudentFname();
        data[1][1] = student.getStudentLname();
        data[1][2] = student.getStudentSex();
        data[1][3] = student.getStudentDOB();
        data[1][4] = student.getBirthCertNum();
        data[1][5] = student.getClassPlaced();
        data[1][6] = student.getClassLeaving();
        data[1][7] = student.getNumOfSiblings();
        data[1][8] = student.getReligion();
        data[1][9] = student.getPetName();
        data[1][10] = student.getAddress();
        data[1][11] = student.getMotherName();
        data[1][12] = student.getMotherNum();
        data[1][13] = student.getMotherAddr();
        data[1][14] = student.getMotherOcc();
        data[1][15] = student.getMotherWorkNum();
        data[1][16] = student.getFatherName();
        data[1][17] = student.getFatherNum();
        data[1][18] = student.getFatherAddr();
        data[1][19] = student.getFatherOcc();
        data[1][20] = student.getFatherWorkNum();
        data[1][21] = student.getGaurdianName();
        data[1][22] = student.getGaurdianNum();
        data[1][23] = student.getGaurdianAddr();
        data[1][24] = student.getGaurdianOcc();
        data[1][25] = student.getGaurdianWorkNum();
        data[1][26] = student.getEmergency1Name();
        data[1][27] = student.getEmergency1Addr();
        data[1][28] = student.getEmergency1Num();
        data[1][29] = student.getEmergency2Name();
        data[1][30] = student.getEmergency2Addr();
        data[1][31] = student.getEmergency2Num();
        data[1][32] = student.getLastEccAttended();
        data[1][33] = student.getReasonForLeaveLastSch();
        data[1][34] = student.getPersonToCollectChild();
        data[1][35] = student.getSpecialDietReq();
        

        studentTable = new JTable(data, columnNames);
        studentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        studentTable.setRowHeight(30);
        // studentTable.getColumn("Actions").setCellRenderer(new ButtonRenderer());
        // studentTable.getColumn("Actions").setCellEditor(new ButtonEditor(new JCheckBox()));
        
        JScrollPane scrollPane = new JScrollPane(studentTable);
        frame.add(scrollPane, BorderLayout.CENTER);
    }



    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
        
    //         SearchDisplay frame = new SearchDisplay(student1);
    //         // frame.setVisible(true);
    //     });
    // }

}

