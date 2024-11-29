import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;


public class DisplayStudents extends JFrame {
    JFrame frame = new JFrame("Student List");
    private JTable studentTable;
    private JButton closeButton;

    public DisplayStudents(){
        

        ArrayList<Student> students = DatabaseHelper.getAllStudents();
        
        
        if (students.size() < 1){
            JOptionPane.showMessageDialog(frame, "No Students found");
        }else{
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1200, 600);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setLayout(new BorderLayout());
            frame.setVisible(true);


            String[] columnNames = {"First Name", "Last Name", "DOB", "Class Placed", "Actions"};
            Object[][] data = new Object[students.size()][5];

            
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                data[i][0] = student.getStudentFname();
                data[i][1] = student.getStudentLname();
                data[i][2] = student.getStudentDOB();
                data[i][3] = student.getClassPlaced();
                data[i][4] = "Edit";
            }
        
            studentTable = new JTable(data, columnNames);
            studentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            studentTable.setRowHeight(30);
            // studentTable.getColumn("Actions").setCellRenderer(new ButtonRenderer());
            // studentTable.getColumn("Actions").setCellEditor(new ButtonEditor(new JCheckBox()));
        
            JScrollPane scrollPane = new JScrollPane(studentTable);
            frame.add(scrollPane, BorderLayout.CENTER);
            closeButton = new JButton("Close");
            // closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            closeButton.addActionListener(new CloseButtonListener());

            frame.add(closeButton, BorderLayout.SOUTH);



        }

        

        
    }
    
    private class CloseButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }

    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
    //         DisplayStudents frame = new DisplayStudents();
    //         // frame.setVisible(true);
    //     });
    // }

}
