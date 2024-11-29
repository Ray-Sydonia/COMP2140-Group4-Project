import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateRecord extends JFrame{
    private JFrame frame;
    
    //REGISTRATION FORM FIELDS

    private JTextField lastECCField, reasonForLeavingField, personCollectChildNameField, specialDietField;
    // private JTextField dateField;
    
    // Student Information Fields
    private JTextField firstNameField, lastNameField, dobField, birthCertificateNumField; 
    private JRadioButton maleRadioButton, femaleRadioButton; //Choose Sex option
    private JTextField classPlacedField, classLeavingField, numSiblingsField, religionField, petNameField, addressField;
    
    // Parents/Guardian Information Fields
    private JTextField motherNameField, motherContactNumberField, motherAddressField, motherOccupationField, motherWorkNumberField;
    private JTextField fatherNameField, fatherContactNumberField,  fatherAddressField, fatherOccupationField, fatherWorkNumberField;
    private JTextField gaurdianNameField, gaurdianContactNumberField, gaurdianAddressField, gaurdianOccupationField, gaurdianWorkNumberField;
    
    // Emergency Contacts
    private JTextField emergencyContact1NameField, emergencyContact1AddressField, emergencyContact1PhoneField;
    private JTextField emergencyContact2NameField, emergencyContact2AddressField, emergencyContact2PhoneField;
    
    // Submit Button
    private JButton submitButton;
    private JButton cancelButton;

    
    public CreateRecord(){
        frame = new JFrame();
        frame.setTitle("Create A Student Record");
        // frame.setSize(1200, 600);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
       
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel studentInfoPanel = getStudentInfoPanel();
        JPanel parentInfoPanel = getParentInfoPanel();
        JPanel EmergencyInfoPanel = getEmergencyInfoPanel();
        JPanel OtherInforPanel = getOtherInfoPanel();


        mainPanel.add(studentInfoPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        mainPanel.add(parentInfoPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        mainPanel.add(EmergencyInfoPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        mainPanel.add(OtherInforPanel);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel subCan = new JPanel();
        submitButton = new JButton("Submit");
        // submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(new SubmitButtonListener());

        cancelButton = new JButton("Cancel");
        // cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cancelButton.addActionListener(new CancelButtonListener());

        subCan.add(cancelButton);
        subCan.add(submitButton);
        frame.add(subCan, BorderLayout.SOUTH);
        frame.setVisible(true);
    }



    private JPanel getStudentInfoPanel() {
        JPanel studentPanel = new JPanel(new GridLayout(11, 2));
        studentPanel.setBorder(BorderFactory.createTitledBorder("STUDENT INFORMATION"));

        
        studentPanel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        studentPanel.add(firstNameField);

        studentPanel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        studentPanel.add(lastNameField);

        studentPanel.add(new JLabel("Date of Birth (MM/DD/YYYY):"));
        dobField = new JTextField();
        studentPanel.add(dobField);

        studentPanel.add(new JLabel("Birth Certificate Number:"));
        birthCertificateNumField = new JTextField();
        studentPanel.add(birthCertificateNumField);

        //-----------------------------------------------------        
        //Need to change this
        studentPanel.add(new JLabel("Sex:"));
        // Create a panel for the radio buttons
        JPanel sexPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");

        ButtonGroup sexGroup = new ButtonGroup();
        sexGroup.add(maleRadioButton);
        sexGroup.add(femaleRadioButton);
        
        // Add the radio buttons to the panel
        sexPanel.add(maleRadioButton);
        sexPanel.add(femaleRadioButton);
        
        studentPanel.add(sexPanel);

        //------------------------------------------

        studentPanel.add(new JLabel("Class Placed on Admission:"));
        classPlacedField = new JTextField();
        studentPanel.add(classPlacedField);

        studentPanel.add(new JLabel("Class Leaving:"));
        classLeavingField = new JTextField();
        studentPanel.add(classLeavingField);

        studentPanel.add(new JLabel("# of Siblings:"));
        numSiblingsField = new JTextField();
        studentPanel.add(numSiblingsField);

        //add place in family
        
        studentPanel.add(new JLabel("Pet Name:"));
        petNameField = new JTextField();
        studentPanel.add(petNameField);

        studentPanel.add(new JLabel("Address:"));
        addressField = new JTextField();
        studentPanel.add(addressField);

        studentPanel.add(new JLabel("Religion:"));
        religionField = new JTextField();
        studentPanel.add(religionField);


        // panel.add(new JLabel("Class Attending:"));
        // panel.add(new JComboBox<>(new String[] { "K1", "k2", "K3"}));
        // panel.add(new JLabel("Class Attending:"));
        // panel.add(new JComboBox<>(new String[] { "N/A","K1", "k2", "K3"}));

        return studentPanel;
    }

    
    private JPanel getParentInfoPanel() {
        JPanel studentPanel = new JPanel(new GridLayout(3, 2));
        studentPanel.setBorder(BorderFactory.createTitledBorder("PARENT/GAURDIAN INFORMATION"));

        JPanel  motherPanel = new JPanel(new GridLayout(5, 2));
        motherPanel.setBorder(BorderFactory.createTitledBorder("Mother Information"));
        
        JPanel  fatherPanel = new JPanel(new GridLayout(5, 2));
        fatherPanel.setBorder(BorderFactory.createTitledBorder("Father Information"));
        
        JPanel  gaurdianPanel = new JPanel(new GridLayout(5, 2));
        gaurdianPanel.setBorder(BorderFactory.createTitledBorder("Gaurdian Information"));

        motherPanel.add(new JLabel("Mother Name:"));
        motherNameField = new JTextField();
        motherPanel.add(motherNameField);

        motherPanel.add(new JLabel("Mother Contact Number:"));
        motherContactNumberField = new JTextField(15);
        motherPanel.add(motherContactNumberField);

        motherPanel.add(new JLabel("Mother Address:"));
        motherAddressField = new JTextField(15);
        motherPanel.add(motherAddressField);

        motherPanel.add(new JLabel("Mother Occupation:"));
        motherOccupationField = new JTextField(15);
        motherPanel.add(motherOccupationField);

        motherPanel.add(new JLabel("Mother Work Number:"));
        motherWorkNumberField = new JTextField(15);
        motherPanel.add(motherWorkNumberField);

        //Father Fields
        fatherPanel.add(new JLabel("Father Name:"));
        fatherNameField= new JTextField();
        fatherPanel.add(fatherNameField);

        fatherPanel.add(new JLabel("Father Contact Number:"));
        fatherContactNumberField = new JTextField();
        fatherPanel.add(fatherContactNumberField);

        fatherPanel.add(new JLabel("Father Address:"));
        fatherAddressField = new JTextField();
        fatherPanel.add(fatherAddressField);

        fatherPanel.add(new JLabel("Father Occupation:"));
        fatherOccupationField = new JTextField();
        fatherPanel.add(fatherOccupationField);

        fatherPanel.add(new JLabel("Father Work Number:"));
        fatherWorkNumberField = new JTextField();
        fatherPanel.add(fatherWorkNumberField);

        //Gaurdian Fields
        gaurdianPanel.add(new JLabel("Gaurdian Name:"));
        gaurdianNameField = new JTextField();
        gaurdianPanel.add(gaurdianNameField);

        gaurdianPanel.add(new JLabel("Gaurdian Contact Number:"));
        gaurdianContactNumberField = new JTextField();
        gaurdianPanel.add(gaurdianContactNumberField);

        gaurdianPanel.add(new JLabel("Gaurdian Address:"));
        gaurdianAddressField = new JTextField();
        gaurdianPanel.add(gaurdianAddressField);

        gaurdianPanel.add(new JLabel("Gaurdian Occupation:"));
        gaurdianOccupationField = new JTextField();
        gaurdianPanel.add(gaurdianOccupationField);

        gaurdianPanel.add(new JLabel("Gaurdian Work Number:"));
        gaurdianWorkNumberField = new JTextField();
        gaurdianPanel.add(gaurdianWorkNumberField);

        studentPanel.add(motherPanel);
        studentPanel.add(fatherPanel);
        studentPanel.add(gaurdianPanel);
        return studentPanel;
    }

    private JPanel getEmergencyInfoPanel() {
        JPanel studentPanel = new JPanel(new GridLayout(6, 2));
        studentPanel.setBorder(BorderFactory.createTitledBorder("EMERGENCY CONTACT INFORMATION"));

        // Emergency Contacts
        // Emergency Contact 1
        studentPanel.add(new JLabel("Emergency Contact 1 Name:"));
        emergencyContact1NameField = new JTextField();
        studentPanel.add(emergencyContact1NameField);

        studentPanel.add(new JLabel("Emergency Contact 1 Address:"));
        emergencyContact1AddressField = new JTextField();
        studentPanel.add(emergencyContact1AddressField);

        studentPanel.add(new JLabel("Emergency Contact 1 Number:"));
        emergencyContact1PhoneField = new JTextField();
        studentPanel.add(emergencyContact1PhoneField);

        // Emergency Contact 1
        studentPanel.add(new JLabel("Emergency Contact 2 Name:"));
        emergencyContact2NameField = new JTextField();
        studentPanel.add(emergencyContact2NameField);

        studentPanel.add(new JLabel("Emergency Contact 2 Address:"));
        emergencyContact2AddressField = new JTextField();
        studentPanel.add(emergencyContact2AddressField);

        studentPanel.add(new JLabel("Emergency Contact 2 Number:"));
        emergencyContact2PhoneField = new JTextField();
        studentPanel.add(emergencyContact2PhoneField);

        return studentPanel;
    }

    private JPanel getOtherInfoPanel() {
        JPanel studentPanel = new JPanel(new GridLayout(4, 2));
        studentPanel.setBorder(BorderFactory.createTitledBorder("OTHER INFORMATION"));


        studentPanel.add(new JLabel("Last ECC Attended:"));
        lastECCField= new JTextField();
        studentPanel.add(lastECCField);

        studentPanel.add(new JLabel("Reason for Leaving:"));
        reasonForLeavingField = new JTextField();
        studentPanel.add(reasonForLeavingField);

        // studentPanel.add(new JLabel("Date Registered:"));
        // dateField = new JTextField();
        // studentPanel.add(dateField);

        studentPanel.add(new JLabel("Person to Collect Child:"));
        personCollectChildNameField = new JTextField();
        studentPanel.add(personCollectChildNameField);

        studentPanel.add(new JLabel("Special Diet request:"));
        specialDietField = new JTextField();
        studentPanel.add(specialDietField);

        return studentPanel;
    }


    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Collecting data from text fields
            //Student Fields
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String dob = dobField.getText();
            String birthCertNum = birthCertificateNumField.getText();
            

            String sex = "";
            if(maleRadioButton.isSelected()) {
                sex = "Male";
            } else if(femaleRadioButton.isSelected()) {
                sex = "Female";
            }

            String classPlaced = classPlacedField.getText();
            String classLeaving = classLeavingField.getText();
            String numSiblings = numSiblingsField.getText();
            String petName = petNameField.getText();
            String address = addressField.getText();
            String religion = religionField.getText();

            //Parent/Gaurdian Fields
            String motherName = motherNameField.getText();
            String motherNum = motherContactNumberField.getText();
            String motherAddress = motherAddressField.getText();
            String motherOccu = motherOccupationField.getText();
            String motherWorNum = motherWorkNumberField.getText();

            String fatherName = fatherNameField.getText();
            String fatherNum = fatherContactNumberField.getText();
            String fatherAddress = fatherAddressField.getText();
            String fatherOccu = fatherOccupationField.getText();
            String fatherWorNum = fatherWorkNumberField.getText();

            String gaurdianName = gaurdianNameField.getText();
            String gaurdianNum = gaurdianContactNumberField.getText();
            String gaurdianAddress = gaurdianAddressField.getText();
            String gaurdianOccu = gaurdianOccupationField.getText();
            String gaurdianWorNum = gaurdianWorkNumberField.getText();

            //Emergency Contact
            String ec1Name = emergencyContact1NameField.getText();
            String ec1Address = emergencyContact1AddressField.getText();
            String ec1Num = emergencyContact1PhoneField.getText();

            String ec2Name = emergencyContact2NameField.getText();
            String ec2Address = emergencyContact2AddressField.getText();
            String ec2Num = emergencyContact2PhoneField.getText();

            //Other
            String lastECC = lastECCField.getText();
            String reasonLeave = reasonForLeavingField.getText();
            // String dateReg;
            String personCollect = personCollectChildNameField.getText();
            String specialDiet = specialDietField.getText();

            if (firstName.isEmpty() || lastName.isEmpty() || sex.isEmpty() || dob.isEmpty() || birthCertNum.isEmpty() || classPlaced.isEmpty() 
            || classLeaving.isEmpty() || numSiblings.isEmpty() || religion.isEmpty() || petName.isEmpty() || address.isEmpty() 
            || motherName.isEmpty() || motherNum.isEmpty()|| motherAddress.isEmpty() || motherOccu.isEmpty() || motherWorNum.isEmpty() || fatherName.isEmpty()
            || fatherNum.isEmpty()|| fatherAddress.isEmpty() || fatherOccu.isEmpty() || fatherWorNum.isEmpty() || gaurdianName.isEmpty() || gaurdianNum.isEmpty()
            || gaurdianAddress.isEmpty() || gaurdianOccu.isEmpty() || gaurdianWorNum.isEmpty() || ec1Name.isEmpty() || ec1Address.isEmpty() || ec1Num.isEmpty()
            || ec2Name.isEmpty() || ec2Address.isEmpty() || ec2Num.isEmpty() || lastECC.isEmpty() || reasonLeave.isEmpty() || personCollect.isEmpty() || specialDiet.isEmpty()){

                JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Student student = new Student(firstName, lastName, sex, dob, birthCertNum, classPlaced, classLeaving, numSiblings, religion,
            petName, address, motherName, motherNum, motherAddress, motherOccu, motherWorNum, fatherName, fatherNum, fatherAddress,
            fatherOccu, fatherWorNum, gaurdianName, gaurdianNum, gaurdianAddress, gaurdianOccu, gaurdianWorNum, ec1Name, ec1Address, 
            ec1Num, ec2Name, ec2Address, ec2Num, lastECC, reasonLeave, personCollect, specialDiet);
            DatabaseHelper.createDatabaseAndTables();
            DatabaseHelper.insertStudent(student);

            JOptionPane.showMessageDialog(frame, "Student registered successfully!", "Student Record", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
        }
    }


    private class CancelButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }

    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
    //         CreateRecord frame = new CreateRecord(); 
    //         // frame.setVisible(true); 
    //     });
    // }
}

