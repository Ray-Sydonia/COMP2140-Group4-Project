import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu{
    private static JTextArea resultArea;
    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new BorderLayout());
        
    
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));
        
        JButton createStudRecordButton = new JButton("CREATE A STUDENT RECORD");
        JButton searchButton = new JButton("SEARCH");
        JButton displayButton = new JButton("DISPLAY");
        JButton removeStudRecordButton = new JButton("REMOVE A STUDENT RECORD");
        
        createStudRecordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // JOptionPane.showMessageDialog(frame, "Create a student record clicked");
                CreateRecord createRecord = new CreateRecord();
            }
        });
        
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // JOptionPane.showMessageDialog(frame, "Search clicked");
                
                String userInput = JOptionPane.showInputDialog(frame, "Enter ID to search:");
                int studentId = Integer.parseInt(userInput);
                Student foundStudent = DatabaseHelper.searchStudentById(studentId);
                
                // JOptionPane.showMessageDialog(frame,"First Name: " + searchedStudent.getStudentFname() + " Last Name: " + searchedStudent.getStudentLname());
                if (foundStudent != null) {
                    JOptionPane.showMessageDialog(frame,"First Name: " + foundStudent.getStudentFname() + "   "+ " Last Name: " + foundStudent.getStudentLname() +"   "+ "Sex: " + foundStudent.getStudentSex() + "\n" +
                    "Date of Birth: " + foundStudent.getStudentDOB() +"   "+ "Bert Cert Number: " +  foundStudent.getBirthCertNum() +"   "+ "Class Placed: " + foundStudent.getClassPlaced() + "\n" + 
                    "Class Leaving: " +foundStudent.getClassLeaving()+"   "+ "Number of Siblings: " + foundStudent.getNumOfSiblings() +"   "+ "Religion: " + foundStudent.getReligion() + "\n" +
                    "Pet Name: " + foundStudent.getPetName() +"   "+ "Address: " + foundStudent.getAddress() +"   "+ "Mother's Name: " + foundStudent.getMotherName() + "\n" +
                    "Mother's Contact Number: " + foundStudent.getMotherNum() +"   "+ "Mother's Address: " + foundStudent.getMotherAddr() +"   "+ "Mother's Occupation: " + foundStudent.getMotherOcc() + "\n" +
                    "Mother's Work Number: " + foundStudent.getFatherWorkNum() +"   "+ "Father's Name: " + foundStudent.getFatherName() +"   "+ "Father's Contact Number: " + foundStudent.getFatherNum() + "\n" +
                    "Father's Address: " + foundStudent.getFatherAddr() +"   "+ "Father's Occupation: " + foundStudent.getFatherOcc() +"   "+ "Father's Work Number: " + foundStudent.getFatherWorkNum() + "\n" +
                    "Guardian's Name: " + foundStudent.getGaurdianName() +"   "+ "Guardian's Contact Number: " + foundStudent.getGaurdianNum() +"   "+ "Guardian's Address: " + foundStudent.getGaurdianAddr() + "\n" +
                    "Guardian's Occupation: " + foundStudent.getGaurdianOcc() +"   "+ "Guardian's Work Number: " + foundStudent.getGaurdianWorkNum() +"   "+ "Emergency Contact 1 - Name: " + foundStudent.getEmergency1Name() + "\n" + 
                    "Emergency Contact 1 - Address: " + foundStudent.getEmergency1Addr() +"   "+ "Emergency Contact 1 - Number: " + foundStudent.getEmergency1Num() +"   "+ "Emergency Contact 2 - Name: " + foundStudent.getEmergency2Name() + "\n" +
                    "Emergency Contact 2 - Address: " + foundStudent.getEmergency2Addr() +"   "+ "Emergency Contact 2 - Number: " + foundStudent.getEmergency2Num() +"   "+ "Last ECC: " + foundStudent.getLastEccAttended() + "\n" +
                    "Reason for Leaving: " + foundStudent.getReasonForLeaveLastSch() +"   "+ "Person to Collect: " + foundStudent.getPersonToCollectChild() +"   "+ "Special Diet: " + foundStudent.getSpecialDietReq());
                    // SearchDisplay searchDisplay = new SearchDisplay(foundStudent);

                } else {
                    
                    JOptionPane.showMessageDialog(frame, "Student with #ID - "+ studentId +" not found");
                }
                
            }
        });
        
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // JOptionPane.showMessageDialog(frame, "Display clicked");
                DisplayStudents displayStudents = new DisplayStudents();

            }
        });
        
        removeStudRecordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // JOptionPane.showMessageDialog(frame, "Remove a student record clicked");
                String userInput = JOptionPane.showInputDialog(frame, "Enter ID to search:");
                int studentId = Integer.parseInt(userInput);
                boolean isDeleted = DatabaseHelper.removeStudentRecord(studentId);
                
                if (isDeleted == true){
                    JOptionPane.showMessageDialog(frame, "Student Removed");
                }else{
                    JOptionPane.showMessageDialog(frame, "Student with #ID - "+ studentId +" not found");
                }

            }
        });
        
    
        buttonPanel.add(createStudRecordButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(removeStudRecordButton);
        

        frame.add(buttonPanel, BorderLayout.CENTER);
        
    
        frame.setVisible(true);
    }
}
