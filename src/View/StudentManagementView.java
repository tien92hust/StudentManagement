package View;

import ConnData.ConnJDBC;
import Controller.StudentManagementController;
import Model.Student;
import Model.StudentManagementModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManagementView extends JFrame {
    private static JTable stTable;
    private final StudentManagementModel studentManagementModel;
    private JScrollPane scrollPane;
    private JTextField nameTextField;
    private JTextField ageTextField;
    private JComboBox<String> genderCBB;
    private JTextField majorTextField;
    private JTextField scoreTextField;
    private JTextField passwordTextField;
    private JButton saveButton;
    private JButton deleteButton;
    private JButton findButton;
    private JButton updateButton;
    private JButton refreshButton;

    public StudentManagementView(){
        this.studentManagementModel = new StudentManagementModel();
        this.initStudentMN();
    }
    private void initStudentMN(){
        this.setTitle("Student Management");
        this.setSize(1000,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Action action = new StudentManagementController(this);

        GridBagConstraints gbcSM = new GridBagConstraints();

        JPanel panelSM = new JPanel();
        panelSM.setBackground(new Color(0xCCCCCC));
        panelSM.setLayout(new GridBagLayout());

        Font inputFont = new Font("Arial",Font.BOLD,16);
        Font fontTop = new Font("Arial",Font.BOLD,32);
        Font textFieldFont = new Font("Arial",Font.PLAIN,16);


        gbcSM.insets = new Insets(0,0,20,0);
//        --------input name----------
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(inputFont);
        nameLabel.setPreferredSize(new Dimension(90,40));
        gbcSM.gridx = 0;
        gbcSM.gridy = 1;
        panelSM.add(nameLabel, gbcSM);

        nameTextField = new JTextField();
        nameTextField.setFont(textFieldFont);
        nameTextField.setPreferredSize(new Dimension(200,40));
        gbcSM.gridx = 1;
        gbcSM.gridy = 1;
        panelSM.add(nameTextField, gbcSM);

//        --------input age----------
        JLabel ageLabel = new JLabel("Age");
        ageLabel.setFont(inputFont);
        ageLabel.setPreferredSize(new Dimension(90,40));
        gbcSM.gridx = 0;
        gbcSM.gridy = 2;
        panelSM.add(ageLabel, gbcSM);

        ageTextField = new JTextField();
        ageTextField.setFont(textFieldFont);
        ageTextField.setPreferredSize(new Dimension(200,40));
        gbcSM.gridx = 1;
        gbcSM.gridy = 2;
        panelSM.add(ageTextField, gbcSM);

//        --------input gender----------
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setFont(inputFont);
        genderLabel.setPreferredSize(new Dimension(90,40));
        gbcSM.gridx = 0;
        gbcSM.gridy = 3;
        panelSM.add(genderLabel, gbcSM);


//        --------input major----------
        JLabel majorLabel = new JLabel("Major");
        majorLabel.setFont(inputFont);
        majorLabel.setPreferredSize(new Dimension(90,40));
        gbcSM.gridx = 0;
        gbcSM.gridy = 4;
        panelSM.add(majorLabel, gbcSM);

        majorTextField = new JTextField();
        majorTextField.setFont(textFieldFont);
        majorTextField.setPreferredSize(new Dimension(200,40));
        gbcSM.gridx = 1;
        gbcSM.gridy = 4;
        panelSM.add(majorTextField, gbcSM);

//        --------input score----------
        JLabel scoreLabel = new JLabel("Score");
        scoreLabel.setFont(inputFont);
        scoreLabel.setPreferredSize(new Dimension(90,40));
        gbcSM.gridx = 0;
        gbcSM.gridy = 5;
        panelSM.add(scoreLabel, gbcSM);

        scoreTextField = new JTextField();
        scoreTextField.setFont(textFieldFont);
        scoreTextField.setPreferredSize(new Dimension(200,40));
        gbcSM.gridx = 1;
        gbcSM.gridy = 5;
        panelSM.add(scoreTextField, gbcSM);

//      --------input ID----------
//        JLabel idLabel = new JLabel("Student ID");
//        idLabel.setFont(inputFont);
//        idLabel.setPreferredSize(new Dimension(90,40));
//        gbcSM.gridx = 0;
//        gbcSM.gridy = 1;
//        panelSM.add(idLabel, gbcSM);
//
//        JTextField idTextField = new JTextField();
//        idTextField.setFont(textFieldFont);
//        idTextField.setPreferredSize(new Dimension(200,40));
//        gbcSM.gridx = 1;
//        gbcSM.gridy = 1;
//        panelSM.add(idTextField, gbcSM);

//        --------input password----------
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(inputFont);
        passwordLabel.setPreferredSize(new Dimension(90,40));
        gbcSM.gridx = 0;
        gbcSM.gridy = 6;
        panelSM.add(passwordLabel, gbcSM);

        passwordTextField = new JTextField();
        passwordTextField.setFont(textFieldFont);
        passwordTextField.setPreferredSize(new Dimension(200,40));
        gbcSM.gridx = 1;
        gbcSM.gridy = 6;
        panelSM.add(passwordTextField, gbcSM);

        //        ------CBB gender-------
        String gender[] = {"","Male","Female"};
        genderCBB = new JComboBox<>(gender);
        genderCBB.setFont(textFieldFont);
//        genderCBB.
        genderCBB.setPreferredSize(new Dimension(120,40));
//       gbcSM.fill = GridBagConstraints.HORIZONTAL;
        gbcSM.gridx = 1;
//        gbcSM.gridwidth = 1;
        gbcSM.gridy = 3;
        gbcSM.anchor = GridBagConstraints.LINE_START;
//        gbcSM.insets = new Insets(0,0,15,80);
//        gbcSM.gridheight = 1;
        panelSM.add(genderCBB, gbcSM);


//      ------top----------
        JLabel userLoginLabel = new JLabel("Student Management");
        userLoginLabel.setHorizontalAlignment(JLabel.CENTER);
        userLoginLabel.setFont(fontTop);
        userLoginLabel.setForeground(Color.blue);
        gbcSM.insets = new Insets(0,0,60,0);
        gbcSM.gridwidth = 5;
        gbcSM.gridx = 0;
        gbcSM.gridy = 0;
        panelSM.add(userLoginLabel, gbcSM);

//        --------Button---------
        saveButton = new JButton("Save");
        saveButton.addActionListener(action);
        saveButton.setPreferredSize(new Dimension(100,50));
        saveButton.setFont(inputFont);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(action);
        deleteButton.setPreferredSize(new Dimension(100,50));
        deleteButton.setFont(inputFont);

        findButton = new JButton("Find");
        findButton.addActionListener(action);
        findButton.setPreferredSize(new Dimension(100,50));
        findButton.setFont(inputFont);

        updateButton = new JButton("Update");
        updateButton.addActionListener(action);
        updateButton.setPreferredSize(new Dimension(100,50));
        updateButton.setFont(inputFont);

        refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(action);
        refreshButton.setPreferredSize(new Dimension(100,50));
        refreshButton.setFont(inputFont);


//        ------------Button-------------
        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(100,100));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,60,0));
        buttonPanel.setBackground(new Color(0xCCCCCC));
        buttonPanel.add(saveButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(findButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(refreshButton);

//        ---------Table---------
//        studentTable = new DefaultTableModel();
//        studentTable.addColumn("Student ID");
//        studentTable.addColumn("Password");
//        studentTable.addColumn("Name");
//        studentTable.addColumn("Age");
//        studentTable.addColumn("Gender");
//        studentTable.addColumn("Major");
//        studentTable.addColumn("Score");

        stTable = new JTable();
        stTable.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null}
                },
                new String[] {"Student ID", "Name","Age","Gender","Major","Score","Password"}
        ));
//        stTable.setModel(studentTable);
        stTable.setFont(new Font("Arial",Font.PLAIN,13));
        stTable.getColumnModel().getColumn(0).setPreferredWidth(70);
        stTable.getColumnModel().getColumn(0).setMinWidth(70);
        stTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        stTable.getColumnModel().getColumn(1).setMinWidth(120);
        stTable.getColumnModel().getColumn(2).setPreferredWidth(40);
        stTable.getColumnModel().getColumn(2).setMinWidth(40);
        stTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        stTable.getColumnModel().getColumn(3).setMinWidth(50);
        stTable.getColumnModel().getColumn(4).setPreferredWidth(70);
        stTable.getColumnModel().getColumn(4).setMinWidth(70);
        stTable.getColumnModel().getColumn(5).setPreferredWidth(40);
        stTable.getColumnModel().getColumn(5).setMinWidth(40);
        stTable.getColumnModel().getColumn(6).setPreferredWidth(80);
        stTable.getColumnModel().getColumn(6).setMinWidth(80);

        scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(500,20));
        scrollPane.setViewportView(stTable);

        gbcSM.insets = new Insets(0,30,0,0);
        gbcSM.fill = GridBagConstraints.BOTH;
        gbcSM.gridwidth = 3;
        gbcSM.gridheight = 7;
        gbcSM.gridx = 2;
        gbcSM.gridy = 1;
        panelSM.add(scrollPane, gbcSM);

//        ----------------
        this.setLayout(new BorderLayout());
        this.add(panelSM, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
        showData(ConnJDBC.findAll());
    }

    public void showData(List<Student>studentl){
        List<Student> listStudent = new ArrayList<>();
        listStudent = studentl;
        DefaultTableModel tableModel;
        stTable.getModel();
        tableModel = (DefaultTableModel)stTable.getModel();
        tableModel.setRowCount(0);
        listStudent.forEach((student) -> {
            String gender;
            if(student.getGender()  == 0) gender = "Male";
            else {gender = "Female";}
            tableModel.addRow(new Object[]{
                    student.getId(), student.getName(), student.getAge(),
                    gender, student.getMajor(), student.getScore(),  student.getPassword()
            });
        });
    }

    public void refresh() {
        passwordTextField.setText("");
        nameTextField.setText("");
        ageTextField.setText("");
        genderCBB.setSelectedIndex(-1);
        majorTextField.setText("");
        scoreTextField.setText("");
        showData(ConnJDBC.findAll());
    }

    public void saveStudent() {
        Student st = new Student();
        st.setName(nameTextField.getText());
        st.setAge(Integer.parseInt(ageTextField.getText()));
        st.setGender(genderCBB.getSelectedIndex());
        st.setMajor(majorTextField.getText());
        st.setScore(Float.parseFloat(scoreTextField.getText()));
        st.setPassword(passwordTextField.getText());
        ConnJDBC.insert(st);
        JOptionPane.showMessageDialog(null, "Save success! ");
        showData(ConnJDBC.findAll());
    }


    public void deleteStudent() {
        Student st = new Student();
        st.setName(nameTextField.getText());
        ConnJDBC.delete(st);
        showData(ConnJDBC.findAll());
    }

    public void searchStudent() {
        Student st = new Student();
        st.setName(nameTextField.getText());
        showData(ConnJDBC.findByName(st));
    }

    public void updateStudent() {
        Student st = new Student();
        st.setName(nameTextField.getText());
        st.setAge(Integer.parseInt(ageTextField.getText()));
        st.setGender(genderCBB.getSelectedIndex());
        st.setMajor(majorTextField.getText());
        st.setScore(Float.parseFloat(scoreTextField.getText()));
        st.setPassword(passwordTextField.getText());
        ConnJDBC.Update(st);
        JOptionPane.showMessageDialog(null, "Save success! ");
        showData(ConnJDBC.findAll());
    }
}
