import java.io.*;
import java.text.*;
import java.util.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import com.borland.jbcl.layout.*;

public class CdcMain
  extends JFrame
  implements ActionListener, KeyListener
{
  Date currentDate = new Date();
  SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
  SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
  SimpleDateFormat fTime = new SimpleDateFormat("HHmm");
  String dateString = sdf.format(currentDate);
  String dashDate = new SimpleDateFormat("dd MMM yy").format(currentDate);
  String timeString = time.format(currentDate);
  String fileTime = fTime.format(currentDate);

  int correct = 0;
  int total = 0;
  int done;
  int number = 0;
  int set;
  int userTotal = 0;
  int log[];
  double percent;
  double percent2;
  boolean exam;
  String totalq;
  String totalm;
  String passFail;
  String name = null;
  String password = "1";
  String output = "";
  String status;
  String logFile;
  String qtext;
  Vector qList = new Vector(1, 1);
  Vector missedQuestions = new Vector(1, 1);
  Vector QSET = new Vector();
  Vector QLog = new Vector();
  PrintWriter outputFile;
  QInfo current, qTemp;
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel4 = new JPanel();
  JTextArea jtextAreaA = new JTextArea();
  JTextArea jtextAreaB = new JTextArea();
  JTextArea jtextAreaC = new JTextArea();
  JTextArea jtextAreaD = new JTextArea();
  JTextArea jtextQuestion = new JTextArea();
  JTextArea jTextArea5 = new JTextArea();
  JScrollPane jScrollPane1 = new JScrollPane();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel JLabelQuestionNum = new JLabel();
  JLabel correctLabel = new JLabel();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JButton set1Button = new JButton();
  JButton set2Button = new JButton();
  JButton set3Button = new JButton();
  JButton set4Button = new JButton();
  JButton exitButton = new JButton();
  JButton buttonA = new JButton();
  JButton buttonB = new JButton();
  JButton buttonC = new JButton();
  JButton buttonD = new JButton();
  JButton nextButton = new JButton();
  JButton returnToMainButton = new JButton();
  JRadioButton reviewButton = new JRadioButton();
  JRadioButton examButton = new JRadioButton();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  ButtonGroup TestChoice = new ButtonGroup();
  ButtonGroup editChoice = new ButtonGroup();
  XYLayout xYLayout1 = new XYLayout();
  XYLayout xYLayout3 = new XYLayout();
  XYLayout xYLayout2 = new XYLayout();
  TitledBorder titledBorder1;
  XYLayout xYLayout5 = new XYLayout();
  XYLayout xYLayout7 = new XYLayout();
  JButton exitButton1 = new JButton();
  JButton exitButton2 = new JButton();
  JButton returnToMainButton1 = new JButton();
  JButton updateButton = new JButton();
  JPanel jPanel5 = new JPanel();
  XYLayout xYLayout4 = new XYLayout();
  JButton set1Update = new JButton();
  JButton set2Update = new JButton();
  JButton set3Update = new JButton();
  JButton set4Update = new JButton();
  JTextArea jTextArea1 = new JTextArea();
  JButton textUpdateButton = new JButton();
  public JTextArea jTextArea2 = new JTextArea();
  public JTextArea jTextArea3 = new JTextArea();
  public JTextArea jTextArea4 = new JTextArea();
  public JTextArea jTextArea7 = new JTextArea();
  public JRadioButton jRadioButton1 = new JRadioButton();
  public JRadioButton jRadioButton2 = new JRadioButton();
  public JRadioButton jRadioButton3 = new JRadioButton();
  public JRadioButton jRadioButton4 = new JRadioButton();
  public JButton jButton1 = new JButton();
  public JButton jButton2 = new JButton();
  public JButton jButton3 = new JButton();
  public JButton jButton4 = new JButton();
  public JButton jButton5 = new JButton();
  public JTextField jTextField1 = new JTextField();
  public JLabel jLabel3 = new JLabel();
  public JLabel jLabel5 = new JLabel();
  public JLabel jLabel13 = new JLabel();
  public JTextField jTextField2 = new JTextField();
  public JButton jButton6 = new JButton();
  public JButton returnToMainButton2 = new JButton();
  public JLabel jLabel14 = new JLabel();
  public JButton jButton7 = new JButton();
  public JButton set5Button = new JButton();
  public JButton set5Update = new JButton();
  public JLabel jLabel15 = new JLabel();
  public JLabel jLabel16 = new JLabel();
  public JLabel jLabel17 = new JLabel();
  public JLabel jLabel18 = new JLabel();
  public JButton returnToMainButton3 = new JButton();
  public JLabel jLabel19 = new JLabel();

  public void keyTyped(KeyEvent e)
  {

  }

  public void keyPressed(KeyEvent e)
  {
    if (jPanel3.hasFocus())
    {
      char x;
      x = e.getKeyChar();
      if (x == 'a')
      {
        questionDisplay(0);
        jPanel3.requestFocus();
      }
      else if (x == 'b')
      {
        questionDisplay(1);
        jPanel3.requestFocus();
      }
      else if (x == 'c')
      {
        questionDisplay(2);
        jPanel3.requestFocus();
      }

      else if (x == 'd')
      {
        questionDisplay(3);
        jPanel3.requestFocus();
      }
      else if (e.getKeyChar() == e.VK_ENTER)
      {
        number++;
        if ( (number == qList.size() - 1) || number == userTotal)
        {
          showFinal(correct);
        }
        showQuestion();
        correctLabel.setVisible(false);
        nextButton.setVisible(false);
        nextButton.setEnabled(false);

      }
    }
    if (jPanel5.hasFocus())
    {
      char x;
      x = e.getKeyChar();
      if (x == 'a')
      {
        this.jRadioButton1.setSelected(true);
        this.jRadioButton1.updateUI();
        this.jPanel5.validate();
      }
      if (e.getKeyChar() == 'b')
      {
        this.jRadioButton2.setSelected(true);
      }

      if (e.getKeyChar() == 'c')
      {
        this.jRadioButton3.setSelected(true);
      }

      if (e.getKeyChar() == 'd')
      {
        this.jRadioButton4.setSelected(true);
      }

      if (e.getKeyChar() == e.VK_ENTER)
      {
        if (updateQuestion(number) != false)
        {
          updateQuestion(number);
          number = number + 1;
          showEditQuestion(number);
          jButton3.setEnabled(true);
          jButton2.setEnabled(true);
          if (number == QSET.size())
          {
            jButton3.setEnabled(false);
          }

        }
        else
        {
          showError(status);
        }
        jPanel5.requestFocus();
      }

    }

  }

  public void keyReleased(KeyEvent e)
  {

  }

  public static void main(String[] args)
  {

    // Io.readTextWriteDat("set1.txt");
    // Io.readTextWriteDat("set2.txt");
    // Io.readTextWriteDat("set3.txt");
    // Io.readTextWriteDat("set4.txt");
    // Io.readTextWriteDat("set5.txt");
    // Io.renumber("set5vol2b.txt");

    CdcMain cdcMain = new CdcMain();
    cdcMain.setVisible(true);
    JOptionPane.showMessageDialog(null,
      "Disclaimer: \n This program was written for the sole \n" +
      "purpose of assisting upgrade trainees study for\n" +
      "their EOCs.  This software should not be the only source \n" +
      "for EOC preperation.  The author cannot be held accountable for \n" + "any failures of the trainee. \n\n Any other use of this software is unauthorized\n" +
      "and could result in UCMJ action. \n\n Thank You!");

  }

  public CdcMain()
  {
    try
    {
      jbInit();
    }

    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public void actionPerformed(ActionEvent e)
  {
    if (e.getActionCommand().equals("Exit Program"))
    {
      int n = JOptionPane.showConfirmDialog(null,
        "Are you sure you want to exit?", "Confirm Exit", 2);
      if (n == 0)
      {
        System.exit(0);
      }
    }
    else if (e.getActionCommand().equals("CDC Set 1"))
    {
      set = 1;
      getList("dat1.dat");
      //    logFile = "log1.dat";

    }
    else if (e.getActionCommand().equals("CDC Set 2"))
    {
      set = 2;
      getList("dat2.dat");
      //   logFile = "log2.dat";
    }
    else if (e.getActionCommand().equals("CDC Set 3"))
    {
      set = 3;
      getList("dat3.dat");
      // logFile = "log3.dat";
    }
    else if (e.getActionCommand().equals("CDC Set 4"))
    {
      set = 4;
      getList("dat4.dat");
      //logFile = "log4.dat";
    }
    else if (e.getActionCommand().equals("7 Level CDC"))
    {
      set = 5;
      getList("dat5.dat");
      //logFile = "log5.dat";
    }

    else if (e.getActionCommand().equals("Return to Main"))
    {
      set = 0;
      number = 0;
      jPanel1.setVisible(true);
      jPanel2.setVisible(true);
      jPanel3.setVisible(false);
      jPanel4.setVisible(false);
      jPanel5.setVisible(false);
      correctLabel.setVisible(false);
      nextButton.setVisible(false);
      missedQuestions.removeAllElements();
      correct = 0;
      output = "";
      this.jLabel16.setVisible(false);
      this.jLabel15.setVisible(false);

      set1Button.setEnabled(true);
      set2Button.setEnabled(true);
      set3Button.setEnabled(true);
      //  set4Button.setEnabled(true);
      set5Button.setEnabled(true);

    }

    else if (e.getActionCommand().equals("A"))
    {
      questionDisplay(0);
      jPanel3.requestFocus();
    }
    else if (e.getActionCommand().equals("B"))
    {
      questionDisplay(1);
      jPanel3.requestFocus();
    }
    else if (e.getActionCommand().equals("C"))
    {
      questionDisplay(2);
      jPanel3.requestFocus();
    }
    else if (e.getActionCommand().equals("D"))
    {
      questionDisplay(3);
      jPanel3.requestFocus();
    }
    else if (e.getActionCommand().equals("Next"))
    {
      number++;
      if ( (number == qList.size() - 1) || number == userTotal)
      {
        showFinal(correct);
      }
      showQuestion();
      correctLabel.setVisible(false);
      nextButton.setVisible(false);
      nextButton.setEnabled(false);
    }
    else if (e.getActionCommand().equals("Update Questions"))
    {
      password = JOptionPane.showInputDialog("Enter Password");
      if (password.equalsIgnoreCase("update"))
      {
        jPanel1.setVisible(false);
        jPanel2.setVisible(false);
        jPanel5.setVisible(true);
        jRadioButton1.setEnabled(false);
        jRadioButton2.setEnabled(false);
        jRadioButton3.setEnabled(false);
        jRadioButton4.setEnabled(false);
        JOptionPane.showMessageDialog(null,
          "To load a CDC question set, \n" +
          "click on the corrosponding set button. \n\n" +
          "To save you changes click save and then exit the program \n" +
          "to ensure your changes are saved. \n\n Thank You!");

        jPanel5.requestFocus();

      }
      else
      {
        JOptionPane.showMessageDialog(null,
          "You have entered an inccorrect password.");
        number = 0;
        jPanel1.setVisible(true);
        jPanel2.setVisible(true);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel5.setVisible(false);
        correctLabel.setVisible(false);
        nextButton.setVisible(false);
        missedQuestions.removeAllElements();
        correct = 0;
        output = "";
        setDisable();

      }

    }

    else if (e.getActionCommand().equals("SET 1"))
    {
      set = 1;
      QSET = Io.getdatQuestions("dat1.dat");
      setEnable();

    }

    else if (e.getActionCommand().equals("SET 2"))
    {
      set = 2;
      QSET = Io.getdatQuestions("dat2.dat");
      setEnable();
    }
    else if (e.getActionCommand().equals("SET 3"))
    {
      set = 3;
      QSET = Io.getdatQuestions("dat3.dat");
      setEnable();
    }
    else if (e.getActionCommand().equals("SET 4"))
    {
      set = 4;
      QSET = Io.getdatQuestions("dat4.dat");
      setEnable();
    }
    else if (e.getActionCommand().equals("7 Level"))
    {
      set = 5;
      QSET = Io.getdatQuestions("dat5.dat");
      setEnable();
    }

    else if (e.getActionCommand().equals("FIRST"))
    {
      if (updateQuestion(number) != false)
      {
        QSET.setElementAt(qTemp, number - 1);
        number = 1;
        showEditQuestion(number);
        jButton2.setEnabled(false);
        jButton3.setEnabled(true);
      }
      else
      {
        showError(status);

      }
      jPanel5.requestFocus();
    }
    else if (e.getActionCommand().equals("LAST"))
    {
      if (updateQuestion(number) != false)
      {
        QSET.setElementAt(qTemp, number - 1);
        number = QSET.size();
        showEditQuestion(number);
        jButton3.setEnabled(false);
        jButton2.setEnabled(true);
      }
      else
      {
        showError(status);
      }
      jPanel5.requestFocus();
    }
    else if (e.getActionCommand().equals("NEXT2"))
    {
      if (updateQuestion(number) != false)
      {
        updateQuestion(number);
        number = number + 1;
        showEditQuestion(number);
        jButton3.setEnabled(true);
        jButton2.setEnabled(true);
        if (number == QSET.size())
        {
          jButton3.setEnabled(false);
        }

      }
      else
      {
        showError(status);
      }
      jPanel5.requestFocus();
    }
    else if (e.getActionCommand().equals("PREVIOUS"))
    {
      if (updateQuestion(number) != false)
      {
        updateQuestion(number);
        number = number - 1;
        showEditQuestion(number);
        jButton3.setEnabled(true);
        jButton2.setEnabled(true);
        if (number == 1)
        {
          jButton2.setEnabled(false);
        }

      }
      else
      {
        showError(status);
      }
      jPanel5.requestFocus();
    }
    else if (e.getActionCommand().equals("ADD NEW"))
    {
      if (updateQuestion(number) != false)
      {
        jButton3.setEnabled(false);
        jButton2.setEnabled(true);
        QSET.addElement(new QInfo());
        number = (QSET.size());
        ( (QInfo)QSET.elementAt(number - 1)).setNumber(number);
          showEditQuestion(number);

      }
      else
      {
        showError(status);
      }
      jPanel5.requestFocus();
    }
    else if (e.getActionCommand().equals("Delete"))
    {
      int n = JOptionPane.showConfirmDialog(null,
        "Are you sure you want to delete this question?", "Confirm Delete",
        2);
      if (n == 0)
      {
        if (updateQuestion(number) != false)
        {
          QSET.removeElementAt(number - 1);
          for (int index = number; index <= QSET.size(); index++)
          {
            QInfo delTemp = new QInfo();
            delTemp = (QInfo)QSET.elementAt(index - 1);
            delTemp.setNumber(delTemp.getNumber() - 1);
          }
          number = number - 1;
          showEditQuestion(number);
        }
      }
      jPanel5.requestFocus();
    }
    else if (e.getActionCommand().equals("GO"))
    {
      updateQuestion(number);

      if (Integer.parseInt(jTextField2.getText()) > QSET.size() - 1)
      {
        number = QSET.size();
        jButton3.setEnabled(false);
        jButton2.setEnabled(true);
      }
      else if (Integer.parseInt(jTextField2.getText()) == 0)
      {
        number = 1;
        jButton3.setEnabled(true);
        jButton2.setEnabled(false);
      }
      else
      {
        number = Integer.parseInt(jTextField2.getText());
      }
      showEditQuestion(number);
      jTextField2.setText("");
      jButton2.setEnabled(true);
    }

    else if (e.getActionCommand().equals("SAVE"))
    {
      updateQuestion(number);
      Io.writeDatQuestions("dat" + set + ".dat", QSET);
      clearEdit();
    }

  }

  private void jbInit()
    throws Exception
  {
    setLocation(100, 100);
    setSize(500, 530);
    Container content = getContentPane();
    titledBorder1 = new TitledBorder("");
    getContentPane().setLayout(xYLayout1);
    setBackground(Color.darkGray);
    // setDefaultCloseOperation(EXIT_ON_CLOSE);
    setForeground(Color.black);
    setResizable(false);
    setState(Frame.NORMAL);
    setTitle("AIS CDC Tester");
    xYLayout1.setWidth(498);
    xYLayout1.setHeight(500);
    jPanel1.setLayout(xYLayout2);
    jPanel2.setLayout(xYLayout3);
    jPanel3.setLayout(xYLayout5);
    jPanel4.setLayout(xYLayout7);
    exitButton1.setText("Exit Program");
    exitButton1.addActionListener(this);
    exitButton2.setText("Exit Program");
    exitButton2.addActionListener(this);
    returnToMainButton1.addActionListener(this);
    returnToMainButton1.setText("Return to Main");
    returnToMainButton1.setToolTipText("");
    updateButton.setBackground(Color.red);
    updateButton.setFont(new java.awt.Font("Dialog", 0, 14));
    updateButton.setText("Update Questions");
    jPanel5.setLayout(xYLayout4);
    set1Update.setBackground(Color.orange);
    set1Update.setText("SET 1");
    set1Update.addActionListener(this);
    set2Update.setBackground(Color.orange);
    set2Update.setText("SET 2");
    set2Update.addActionListener(this);
    set3Update.setBackground(Color.orange);
    set3Update.setText("SET 3");
    set3Update.addActionListener(this);
    set4Update.setBackground(Color.orange);
    set4Update.setText("SET 4");
    set4Update.addActionListener(this);
    jTextArea1.setText("jTextArea1");
    textUpdateButton.setBackground(Color.red);
    textUpdateButton.setEnabled(false);
    textUpdateButton.setFont(new java.awt.Font("Dialog", 0, 16));
    textUpdateButton.setText("SAVE");
    textUpdateButton.addActionListener(this);
    jTextArea1.setFont(new java.awt.Font("SansSerif", 0, 12));
    jTextArea1.setToolTipText("");
    jTextArea1.setCaretPosition(0);
    jTextArea1.setText("Question Text");
    jTextArea1.setLineWrap(true);
    jTextArea1.setTabSize(8);
    jTextArea1.setWrapStyleWord(true);
    jTextArea2.setText("Answer A");
    jTextArea2.setLineWrap(true);
    jTextArea2.setWrapStyleWord(true);
    jTextArea3.setText("Answer B");
    jTextArea3.setLineWrap(true);
    jTextArea3.setWrapStyleWord(true);
    jTextArea4.setText("Answer C");
    jTextArea4.setLineWrap(true);
    jTextArea4.setWrapStyleWord(true);
    jTextArea7.setText("Answer D");
    jTextArea7.setLineWrap(true);
    jTextArea7.setWrapStyleWord(true);
    jRadioButton1.setBackground(Color.lightGray);
    jRadioButton1.setText("");
    jRadioButton2.setBackground(Color.lightGray);
    jRadioButton2.setText("");
    jRadioButton3.setBackground(Color.lightGray);
    jRadioButton3.setText("");
    jRadioButton4.setBackground(Color.lightGray);
    jRadioButton4.setText("");
    jButton1.setEnabled(false);
    jButton1.setSelected(false);
    jButton1.setText("FIRST");
    jButton2.setEnabled(false);
    jButton2.setDoubleBuffered(false);
    jButton2.setText("PREVIOUS");
    jButton3.setEnabled(false);
    jButton3.setDoubleBuffered(false);
    jButton3.setActionCommand("NEXT2");
    jButton3.setText("NEXT");
    jButton4.setEnabled(false);
    jButton4.setToolTipText("");
    jButton4.setSelected(false);
    jButton4.setText("LAST");
    jPanel5.setBackground(Color.lightGray);
    jButton5.setBackground(Color.green);
    jButton5.setEnabled(false);
    jButton5.setText("ADD NEW");
    jButton5.addActionListener(this);
    jTextField1.setFont(new java.awt.Font("Dialog", 0, 18));
    jTextField1.setText("000");
    jLabel3.setFont(new java.awt.Font("Dialog", 0, 18));
    jLabel3.setHorizontalAlignment(SwingConstants.LEADING);
    jLabel3.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel3.setText("Section:");
    jLabel5.setFont(new java.awt.Font("Dialog", 0, 18));
    jLabel5.setPreferredSize(new Dimension(63, 15));
    jLabel5.setText("QUESTION # ");
    jLabel13.setFont(new java.awt.Font("Dialog", 0, 14));
    jLabel13.setText("Goto Question #");
    jTextField2.setFont(new java.awt.Font("Dialog", 0, 18));
    // jTextField2.setSelectionStart(3);
    jButton6.addActionListener(this);
    jButton6.setText("GO");
    jButton6.setEnabled(false);
    jButton6.setAlignmentY( (float)0.5);
    jButton6.setBackground(new Color(0, 90, 255));
    returnToMainButton2.addActionListener(this);
    returnToMainButton2.setText("Return to Main");
    returnToMainButton2.setToolTipText("");
    jLabel14.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel14.setFont(new java.awt.Font("Dialog", 0, 20));
    exitButton.setBackground(Color.lightGray);
    exitButton.setFont(new java.awt.Font("Dialog", 0, 20));
    set1Button.setBackground(new Color(0, 187, 0));
    set2Button.setBackground(new Color(0, 187, 0));

    set3Button.setBackground(new Color(0, 187, 0));
    set4Button.setBackground(new Color(0, 180, 0));
    jButton7.addActionListener(this);
    jButton7.setText("Delete");
    jButton7.setEnabled(false);
    jButton7.setBackground(Color.red);
    set5Button.setEnabled(false);
    set5Button.addActionListener(this);
    set5Button.setText("7 Level CDC");
    set5Button.setFont(new java.awt.Font("Dialog", 0, 16));
    set5Button.setBackground(Color.orange);
    set5Update.addActionListener(this);
    set5Update.setText("7 Level");
    set5Update.setBackground(Color.cyan);
    jtextQuestion.setWrapStyleWord(true);
    jtextAreaA.setWrapStyleWord(true);
    jtextAreaB.setWrapStyleWord(true);
    jtextAreaC.setWrapStyleWord(true);
    jtextAreaD.setWrapStyleWord(true);
    jTextArea5.setWrapStyleWord(true);
    jLabel15.setFont(new java.awt.Font("Dialog", 0, 14));
    jLabel15.setForeground(Color.green);
    jLabel16.setFont(new java.awt.Font("SansSerif", 0, 16));
    jLabel16.setForeground(Color.red);
    jLabel16.setText("Current Score");
    jLabel16.setVisible(false);
    jLabel17.setFont(new java.awt.Font("Dialog", 0, 16));
    jLabel17.setForeground(Color.green);
    jLabel17.setText("This program was written by SSgt Corey T. Willinger");
    jLabel18.setText("Your feedback is important! Please report any errors, bugs, or suggestions.");
    jLabel18.setFont(new java.awt.Font("Dialog", 0, 11));
    jLabel18.setForeground(Color.green);
    jLabel18.setToolTipText("");
    returnToMainButton3.setToolTipText("");
    returnToMainButton3.setText("Exit Program");
    returnToMainButton3.addActionListener(this);
    jLabel19.setForeground(Color.red);
    jLabel19.setText("Rev Date: 25 Mar 04");
    jPanel2.setRequestFocusEnabled(true);
    buttonGroup1.add(buttonA);
    buttonGroup1.add(buttonB);
    buttonGroup1.add(buttonC);
    buttonGroup1.add(buttonD);
    TestChoice.add(examButton);
    TestChoice.add(reviewButton);
    getContentPane().add(jPanel1, new XYConstraints(10, 10, 470, 97));

    jPanel1.setBackground(Color.red);

    jPanel1.add(jLabel1, new XYConstraints(5, 3, 365, 62));

    jLabel1.setFont(new java.awt.Font("SansSerif", 1, 40));
    jLabel1.setText("AIS CDC Tester");

    jPanel1.add(jLabel2, new XYConstraints(57, 57, 389, 38));

    jLabel2.setFont(new java.awt.Font("Dialog", 0, 20));
    jLabel2.setText("Choose Review or Exam and a CDC set");

    jPanel1.add(jLabel12, new XYConstraints(332, 0, 123, 47));
    jPanel1.add(jLabel14, new XYConstraints(334, 23, 123, 47));

    jLabel12.setFont(new java.awt.Font("Dialog", 0, 20));
    jLabel12.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel12.setText(dateString);

    getContentPane().add(jPanel2, new XYConstraints(10, 108, 470, 375));

    jPanel2.setBackground(Color.blue);
    exitButton.addActionListener(this);

    set1Button.setEnabled(true);
    set1Button.setFont(new java.awt.Font("Dialog", 0, 16));
    set1Button.setText("CDC Set 1");
    set1Button.addActionListener(this);

    set2Button.setFont(new java.awt.Font("Dialog", 0, 16));
    set2Button.setText("CDC Set 2");
    set2Button.addActionListener(this);

    set3Button.setFont(new java.awt.Font("Dialog", 0, 16));
    set3Button.setText("CDC Set 3");
    set3Button.addActionListener(this);

    set4Button.setFont(new java.awt.Font("Dialog", 0, 16));
    set4Button.setText("CDC Set 4");
    set4Button.addActionListener(this);

    reviewButton.setBackground(Color.lightGray);
    reviewButton.setFont(new java.awt.Font("SansSerif", 1, 20));
    examButton.setSelected(true);
    reviewButton.setText("REVIEW");

    jPanel2.add(reviewButton, new XYConstraints(35, 12, 129, 36));
    jPanel2.add(examButton, new XYConstraints(36, 54, 93, -1));
    jPanel2.add(set1Button, new XYConstraints(289, 11, 151, 49));
    jPanel2.add(set2Button, new XYConstraints(290, 66, 151, 49));
    jPanel2.add(set3Button, new XYConstraints(289, 122, 151, 49));
    jPanel2.add(set4Button, new XYConstraints(289, 177, 151, 49));
    jPanel2.add(updateButton, new XYConstraints(21, 117, 199, 53));
    jPanel2.add(set5Button, new XYConstraints(290, 239, 151, 49));
    jPanel2.add(exitButton, new XYConstraints(23, 210, 201, 77));
    jPanel2.add(jLabel17, new XYConstraints(21, 295, 371, 23));
    jPanel2.add(jLabel18, new XYConstraints(22, 313, 441, 23));
    jPanel2.add(jLabel19, new XYConstraints(259, 331, 127, 24));

    exitButton.setText("Exit Program");
    examButton.setBackground(Color.lightGray);
    examButton.setFont(new java.awt.Font("SansSerif", 1, 20));
    examButton.setText("EXAM");

    jPanel3.setLayout(xYLayout3);
    jPanel3.setBackground(Color.blue);
    jPanel3.setAlignmentY( (float)0.5);

    JLabelQuestionNum.setBackground(Color.lightGray);
    JLabelQuestionNum.setEnabled(true);
    JLabelQuestionNum.setFont(new java.awt.Font("SansSerif", 1, 14));
    JLabelQuestionNum.setForeground(Color.green);
    JLabelQuestionNum.setBorder(BorderFactory.createLoweredBevelBorder());
    JLabelQuestionNum.setText("Question # " + number + 1);

    jPanel3.add(JLabelQuestionNum, new XYConstraints(12, 13, 116, -1));
    jPanel3.add(jLabel4, new XYConstraints(139, 14, 114, -1));
    jPanel3.add(returnToMainButton, new XYConstraints(327, 7, 146, 35));
    jPanel3.add(correctLabel, new XYConstraints(143, 424, 182, 50));
    jPanel3.add(nextButton, new XYConstraints(342, 435, 112, 32));
    jPanel3.add(jtextQuestion, new XYConstraints(7, 94, 469, 120));
    jPanel3.add(jtextAreaD, new XYConstraints(77, 389, 397, 40));
    jPanel3.add(buttonD, new XYConstraints(26, 394, 30, 30));
    jPanel3.add(buttonC, new XYConstraints(26, 342, 30, 30));
    jPanel3.add(jtextAreaC, new XYConstraints(76, 335, 397, 40));
    jPanel3.add(jtextAreaB, new XYConstraints(74, 284, 399, 40));
    jPanel3.add(buttonB, new XYConstraints(26, 289, 30, 30));
    jPanel3.add(buttonA, new XYConstraints(28, 239, 30, 30));
    jPanel3.add(jtextAreaA, new XYConstraints(75, 233, 399, 40));
    jPanel3.add(exitButton1, new XYConstraints(3, 436, 110, 32));
    jPanel3.add(jLabel15, new XYConstraints(138, 50, 61, 33));
    jPanel3.add(jLabel16, new XYConstraints(12, 49, 117, 31));
    this.getContentPane().add(jPanel5, new XYConstraints(0, 2, 499, 493));
    jPanel5.add(jTextArea2, new XYConstraints(70, 210, 420, 40));
    jPanel5.add(jTextArea3, new XYConstraints(69, 264, 422, 40));
    jPanel5.add(jTextArea4, new XYConstraints(68, 319, 422, 40));
    jPanel5.add(jTextArea7, new XYConstraints(70, 370, 422, 40));
    jPanel5.add(jRadioButton3, new XYConstraints(23, 316, 23, 36));
    jPanel5.add(jRadioButton1, new XYConstraints(23, 210, 23, 36));
    jPanel5.add(jRadioButton2, new XYConstraints(23, 262, 23, 36));
    jPanel5.add(jRadioButton4, new XYConstraints(23, 370, 23, 36));
    jPanel5.add(jButton2, new XYConstraints(85, 423, 100, 26));
    jPanel5.add(jButton1, new XYConstraints(9, 423, 68, 26));
    jPanel5.add(jButton3, new XYConstraints(197, 422, 79, 26));
    jPanel5.add(jButton4, new XYConstraints(288, 422, 66, 26));
    jPanel5.add(jLabel13, new XYConstraints(19, 455, 124, 31));
    jPanel5.add(textUpdateButton, new XYConstraints(376, 415, 116, 36));
    jPanel5.add(jLabel5, new XYConstraints(326, 63, 172, 31));
    jPanel5.add(jTextField1, new XYConstraints(273, 63, 44, -1));
    jPanel5.add(jLabel3, new XYConstraints(204, 67, 75, 25));
    jPanel5.add(jButton5, new XYConstraints(9, 63, 94, 34));
    jPanel5.add(jTextArea1, new XYConstraints(12, 105, 477, 98));
    jPanel5.add(jButton7, new XYConstraints(113, 64, 87, 34));
    jPanel5.add(set1Update, new XYConstraints(1, 9, 96, 39));
    jPanel5.add(set5Update, new XYConstraints(395, 10, 92, 39));
    jPanel5.add(set4Update, new XYConstraints(296, 10, 92, 39));
    jPanel5.add(set3Update, new XYConstraints(202, 9, 88, 39));
    jPanel5.add(set2Update, new XYConstraints(101, 10, 95, 39));
    jPanel5.add(jTextField2, new XYConstraints(131, 457, 44, -1));
    jPanel5.add(jButton6, new XYConstraints(183, 456, 60, 34));
    jPanel5.add(returnToMainButton2, new XYConstraints(375, 456, 117, 35));
    jPanel5.add(returnToMainButton3, new XYConstraints(256, 456, 108, 35));

    jLabel4.setText("Section: ");
    jLabel4.setDoubleBuffered(true);
    jLabel4.setDebugGraphicsOptions(0);
    jLabel4.setBorder(BorderFactory.createLoweredBevelBorder());
    jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14));
    jLabel4.setForeground(Color.green);
    jLabel4.setEnabled(true);
    jLabel4.setBackground(Color.lightGray);

    returnToMainButton.setToolTipText("");
    returnToMainButton.setText("Return to Main");
    returnToMainButton.addActionListener(this);

    jtextQuestion.setEditable(false);
    jtextQuestion.setText("Info");
    jtextQuestion.setLineWrap(true);

    buttonA.addActionListener(this);
    buttonA.setBorder(titledBorder1);
    buttonA.setText("A");

    buttonB.addActionListener(this);
    buttonB.setBorder(titledBorder1);
    buttonB.setText("B");

    buttonC.addActionListener(this);
    buttonC.setBorder(titledBorder1);
    buttonC.setText("C");

    buttonD.addActionListener(this);
    buttonD.setBorder(titledBorder1);
    buttonD.setText("D");

    jtextAreaA.setText("jtextAreaA");
    jtextAreaA.setEditable(false);
    jtextAreaA.setLineWrap(true);

    jtextAreaB.setText("jtextAreaB");
    jtextAreaB.setEditable(false);
    jtextAreaB.setLineWrap(true);

    jtextAreaC.setText("jtextAreaC");
    jtextAreaC.setEditable(false);
    jtextAreaC.setLineWrap(true);

    jtextAreaD.setText("jtextAreaD");
    jtextAreaD.setEditable(false);
    jtextAreaD.setLineWrap(true);

    correctLabel.setFont(new java.awt.Font("SansSerif", 0, 40));
    correctLabel.setForeground(Color.red);
    correctLabel.setText("Correct");

    nextButton.setDoubleBuffered(false);
    nextButton.setText("Next");
    nextButton.addActionListener(this);

    getContentPane().add(jPanel4, new XYConstraints(7, 9, 476, 477));

    jPanel4.setBackground(Color.gray);

    jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.
      HORIZONTAL_SCROLLBAR_NEVER);
    //jScrollPane1.setWheelScrollingEnabled(true);
    jTextArea5.setEditable(false);
    jTextArea5.setLineWrap(true);
    updateButton.addActionListener(this);

    jLabel10.setFont(new java.awt.Font("Dialog", 0, 15));
    jLabel10.setText("Missed Questions");

    jPanel4.add(jLabel9, new XYConstraints(22, 4, 249, 70));

    jLabel9.setFont(new java.awt.Font("Monospaced", 1, 50));
    jLabel9.setText("Status: ");

    jPanel4.add(jLabel6, new XYConstraints(244, 7, 193, 71));

    jLabel6.setFont(new java.awt.Font("Monospaced", 1, 50));
    jLabel6.setForeground(Color.green);
    jLabel6.setText("Passed");

    jLabel7.setFont(new java.awt.Font("Monospaced", 0, 25));
    jLabel7.setText("Total Questions: ");

    jLabel8.setFont(new java.awt.Font("Monospaced", 0, 25));
    jLabel8.setText("Number Missed: ");

    jPanel4.add(jScrollPane1, new XYConstraints(3, 162, 466, 270));
    jPanel4.add(exitButton2, new XYConstraints(28, 439, 127, 33));
    jPanel4.add(jLabel7, new XYConstraints(16, 72, 300, 38));
    jPanel4.add(jLabel8, new XYConstraints(18, 97, 289, 42));
    jPanel4.add(jLabel10, new XYConstraints(20, 131, 126, 29));
    jPanel4.add(returnToMainButton1, new XYConstraints(267, 439, 146, 35));
    jPanel4.add(jLabel11, new XYConstraints(330, 57, 145, 99));
    this.getContentPane().add(jPanel3, new XYConstraints(8, 3, 482, 485));
    jScrollPane1.getViewport().add(jTextArea5, null);

    jLabel11.setFont(new java.awt.Font("Monospaced", 1, 40));
    editChoice.add(jRadioButton1);
    editChoice.add(jRadioButton2);
    editChoice.add(jRadioButton3);
    editChoice.add(jRadioButton4);
    this.jButton1.addActionListener(this);
    this.jButton2.addActionListener(this);
    this.jButton3.addActionListener(this);
    this.jButton4.addActionListener(this);
    jLabel14.setText(timeString);

    nextButton.setVisible(false);
    correctLabel.setVisible(false);
    //   this.set1Button.setEnabled(false);
//    this.set2Button.setEnabled(false);
//    this.set3Button.setEnabled(false);
    this.set4Button.setEnabled(false);
    this.set5Button.setEnabled(true);
    nextButton.setDefaultCapable(true);
    this.set4Update.setEnabled(false);
    WindowDestroyer close = new WindowDestroyer();
    this.addWindowListener(close);
    this.addKeyListener(this);
    jPanel3.addKeyListener(this);
    jPanel3.setFocusable(true);
    jPanel5.addKeyListener(this);
    jPanel5.setFocusable(true);

//  jPanel1.setVisible(false);
//   jPanel2.setVisible(false);
    jPanel3.setVisible(false);
    jPanel4.setVisible(false);
    jPanel5.setVisible(false);

  }

  public void getList(String qfile)
  {
    jPanel3.requestFocus();
    number = 0;
    if (reviewButton.isSelected())
    {
      exam = false;
    }
    else
    {
      exam = true;
    }
    qList = Io.getdatRandomQuestions(qfile);
    total = qList.size();
    //log = new int[(qList.size())-1];
    //log = Io.getLog(logFile,qList.size()-1);
    jPanel2.setVisible(false);
    jPanel1.setVisible(false);
    if (exam)
    {
      if (name == null)
      {
        name = JOptionPane.showInputDialog("Please enter last name");
      }
      nextButton.setEnabled(false);
    }
    String enter;
    enter = JOptionPane.showInputDialog("Enter # of Questions to Test" +
      "\nMax Questions = " + (total - 1));
    if (enter.equals(null) || enter.equalsIgnoreCase(""))
    {
      userTotal = 10;
    }
    else
    {
      userTotal = Integer.parseInt(enter);
    }
    if (userTotal > total)
    {
      userTotal = total;
    }
    jPanel3.setVisible(true);
    set1Button.setEnabled(false);
    set2Button.setEnabled(false);
    set3Button.setEnabled(false);
    set4Button.setEnabled(false);

    showQuestion();
    if (exam == true)
    {
      try
      {
        outputFile = new PrintWriter(new FileOutputStream(name + "_" +
          dashDate + "_" + fileTime + ".txt"));
      }
      catch (FileNotFoundException e)
      {
      }
    }
  }

  public void showQuestion()
  {
    {
      buttonA.setEnabled(true);
      buttonB.setEnabled(true);
      buttonC.setEnabled(true);
      buttonD.setEnabled(true);

      buttonA.setBackground(Color.lightGray);
      buttonB.setBackground(Color.lightGray);
      buttonC.setBackground(Color.lightGray);
      buttonD.setBackground(Color.lightGray);
      current = new QInfo();
      current = (QInfo)qList.elementAt(number);
      jtextQuestion.setText(current.getNumber() + ". (" +
                            current.getSection() + ") " + current.getText());
      jtextAreaA.setText(current.getChoice(0));
      jtextAreaB.setText(current.getChoice(1));
      jtextAreaC.setText(current.getChoice(2));
      jtextAreaD.setText(current.getChoice(3));
      JLabelQuestionNum.setText("Question # " + (number + 1));
      jLabel4.setText("Section: " + current.getSection());
      if (number != 0 && !exam)
      {
        jLabel16.setVisible(true);
        jLabel15.setText( (int) (correct * 100) / number + "%");
      }
    }
  }

  public void reviewDisplay(boolean right)
  {
    if (right == true)
    {
      correctLabel.setForeground(Color.green);
      correctLabel.setText("Correct");
    }
    else
    {
      correctLabel.setForeground(Color.red);
      correctLabel.setText("Incorrect");
    }
    correctLabel.setVisible(true);

  }

  public void questionDisplay(int i)
  {

    if (exam == false)
    {
      showCorrect(i);
      nextButton.setEnabled(true);
      nextButton.setVisible(true);

      if (current.getCorrect() == i)
      {
        correct++;
        reviewDisplay(true);
      }
      else
      {
        // current.setNumber(number);
        current.setMarked(i);
        missedQuestions.addElement(current);
        reviewDisplay(false);
      }
    }
    else
    {
      if (current.getCorrect() == i)
      {
        correct++;
        number++;
        if ( (number == qList.size() - 1) || number == userTotal)
        {
          showFinal(correct);
        }
        showQuestion();
      }
      else
      {
        current.setMarked(i);
        //   current.setNumber(number);
        missedQuestions.addElement(current);
        //     log[number]++;
        number++;
        if ( (number == qList.size() - 1) || number == userTotal)
        {
          showFinal(correct);
        }
        showQuestion();

      }
    }
  }

  public void showCorrect(int y)
  {
    if (y == 0)
    {
      buttonA.setBackground(Color.red);
    }
    if (y == 1)
    {
      buttonB.setBackground(Color.red);
    }
    if (y == 2)
    {
      buttonC.setBackground(Color.red);
    }
    if (y == 3)
    {
      buttonD.setBackground(Color.red);
    }
    if (current.getCorrect() == 0)
    {
      buttonA.setBackground(Color.green);
    }
    if (current.getCorrect() == 1)
    {
      buttonB.setBackground(Color.green);
    }
    if (current.getCorrect() == 2)
    {
      buttonC.setBackground(Color.green);
    }
    if (current.getCorrect() == 3)
    {
      buttonD.setBackground(Color.green);
    }
  }

  public void showFinal(int right)
  {
    //Io.setLog(logFile,log);
    jPanel1.setVisible(false);
    jPanel3.setVisible(false);
    jPanel2.setVisible(false);
    jPanel4.setVisible(true);
    correct = right;
    totalq = Integer.toString(userTotal);
    totalm = Integer.toString(missedQuestions.size());
    percent2 = ( (int) (correct * 100) / userTotal);
    jLabel11.setText( (int)percent2 + "%");
    percent = (double)correct / (double)userTotal;
    qTemp = new QInfo();
    for (int index = 0; index < missedQuestions.size(); index++)
    {
      qTemp = (QInfo)missedQuestions.elementAt(index);
      output = output + qTemp.getNumber() + ") " + qTemp.getText() + '\n';
      for (int i = 0; i < 4; i++)
      {
        if (i == qTemp.getCorrect())
        {
          output = output + "     " + (char) (i + 65) + ") " +
            qTemp.getChoice(i) + " <-- Correct Answer" + '\n';
        }
        else if (i == qTemp.getMarked())
        {
          output = output + "     " + (char) (i + 65) + ") " +
            qTemp.getChoice(i) + " <-- Selected Answer" + '\n';
        }
        else
        {
          output = output + "     " + (char) (i + 65) + ") " +
            qTemp.getChoice(i) + '\n';
        }
      }
      output = output + '\n';
    }
    jTextArea5.setText(output);
    this.jTextArea5.setCaretPosition(0);

    if (percent2 < 65)

    {
      passFail = "Failed";
      jLabel6.setForeground(Color.red);
      jLabel6.setText(passFail);
      jLabel11.setForeground(Color.red);
    }

    else if (percent < .70)
    {
      passFail = "Study Harder";
      jLabel6.setForeground(Color.yellow);
      jLabel6.setText(passFail);
      jLabel11.setForeground(Color.yellow);
    }
    else if (percent > .70)
    {
      passFail = "Passed";
      jLabel6.setForeground(Color.green);
      jLabel6.setText(passFail);
      jLabel11.setForeground(Color.green);
    }

    jLabel7.setText("Total Questions: " + totalq);

    jLabel8.setText("Number missed: " + totalm);
    if (exam == true)
    {
      outputResults();
    }
  }

  public void showEditQuestion(int x)
  {
    qTemp = (QInfo)QSET.elementAt(x - 1);
    this.jLabel5.setText("Question: " + qTemp.getNumber() + " of " +
                         QSET.size());
    this.jTextField1.setText(qTemp.getSection());
    this.jTextArea1.setText(qTemp.getText());
    this.jTextArea2.setText(qTemp.getChoice(0));
    this.jTextArea3.setText(qTemp.getChoice(1));
    this.jTextArea4.setText(qTemp.getChoice(2));
    this.jTextArea7.setText(qTemp.getChoice(3));
    if (qTemp.getCorrect() == 0)
    {
      jRadioButton1.setSelected(true);
    }
    else if (qTemp.getCorrect() == 1)
    {
      jRadioButton2.setSelected(true);
    }
    else if (qTemp.getCorrect() == 2)
    {
      jRadioButton3.setSelected(true);
    }
    else if (qTemp.getCorrect() == 3)
    {
      jRadioButton4.setSelected(true);
    }
  }

  public boolean updateQuestion(int x)
  {
    boolean verify = false;
    if (!jTextField1.getText().equalsIgnoreCase(""))
    {
      if (!jTextArea1.getText().equalsIgnoreCase(""))
      {
        if (!jTextArea2.getText().equalsIgnoreCase(""))
        {
          if (!jTextArea3.getText().equalsIgnoreCase(""))
          {
            if (!jTextArea4.getText().equalsIgnoreCase(""))
            {
              if (!jTextArea7.getText().equalsIgnoreCase(""))
              {
                if (jRadioButton1.isSelected() || jRadioButton2.isSelected() ||
                    jRadioButton3.isSelected() || jRadioButton4.isSelected())
                {
                  verify = true;
                  qTemp.setText(jTextArea1.getText());
                  qTemp.setChoice(0, jTextArea2.getText());
                  qTemp.setChoice(1, jTextArea3.getText());
                  qTemp.setChoice(2, jTextArea4.getText());
                  qTemp.setChoice(3, jTextArea7.getText());
                  qTemp.setNumber(x);
                  qTemp.setSection(jTextField1.getText());
                  if (jRadioButton1.isSelected())
                  {
                    qTemp.setCorrect(0);
                  }
                  else if (jRadioButton2.isSelected())
                  {
                    qTemp.setCorrect(1);
                  }
                  else if (jRadioButton3.isSelected())
                  {
                    qTemp.setCorrect(2);
                  }
                  else if (jRadioButton4.isSelected())
                  {
                    qTemp.setCorrect(3);
                  }
                }
                else
                {
                  status = "Select a correct answer";
                }
              }
              else
              {
                status = "Answer D is blank";
              }
            }
            else
            {
              status = "Answer C is blank";
            }
          }
          else
          {
            status = "Answer B is blank";
          }
        }
        else
        {
          status = "Answer A is blank";
        }
      }
      else
      {
        status = "Question text is blank";
      }
    }
    else
    {
      status = "Section # is blank";
    }
    return verify;
  }

  public void setEnable()
  {
    number = 1;
    showEditQuestion(number);
    jButton1.setEnabled(true);
    jButton2.setEnabled(false);
    jButton3.setEnabled(true);
    jButton4.setEnabled(true);
    jButton5.setEnabled(true);
    textUpdateButton.setEnabled(true);
    jButton6.setEnabled(true);
    jButton7.setEnabled(true);
    jRadioButton1.setEnabled(true);
    jRadioButton2.setEnabled(true);
    jRadioButton3.setEnabled(true);
    jRadioButton4.setEnabled(true);
    jPanel5.requestFocus();

  }

  public void setDisable()
  {
    jRadioButton1.setEnabled(false);
    jRadioButton2.setEnabled(false);
    jRadioButton3.setEnabled(false);
    jRadioButton4.setEnabled(false);
    jButton1.setEnabled(false);
    jButton2.setEnabled(false);
    jButton3.setEnabled(false);
    jButton4.setEnabled(false);
    jButton5.setEnabled(false);
    textUpdateButton.setEnabled(false);
    jButton6.setEnabled(false);
    jButton7.setEnabled(false);
    jTextArea2.setText("");
    jTextArea3.setText("");
    jTextArea4.setText("");
    jTextArea7.setText("");
    jTextField2.setText("");
    jTextArea1.setText("");
    jTextField1.setText("");
    jLabel5.setText("Question:");
  }

  public void showError(String status)
  {
    JOptionPane.showMessageDialog(null,
      "Please check the following error: " + status);
  }

  public void outputResults()
  {
    qTemp = new QInfo();
    outputFile.println("AIS CDC Test Results for:");
    outputFile.println();
    outputFile.println("Name: " + name);
    outputFile.println("Date: " + dateString + " " + timeString);
    outputFile.println("CDC Set " + set);
    outputFile.println();
    outputFile.println("Total Questions: " + totalq);
    outputFile.println("Number missed: " + totalm);
    outputFile.println("Score: " + percent2 + "%");
    outputFile.println();

    for (int index = 0; index < missedQuestions.size(); index++)
    {

      qTemp = (QInfo)missedQuestions.elementAt(index);
      outputFile.println( ( (int)qTemp.getNumber()) + ". (" +
                         qTemp.getSection() + ") " + qTemp.getText());
      for (int i = 0; i < 4; i++)
      {
        if (i == qTemp.getCorrect())
        {
          outputFile.println("     " + (char) (i + 65) + ") " +
                             qTemp.getChoice(i) + " <---  CORRECT ANSWER");
        }
        else if (i == qTemp.getMarked())
        {
          outputFile.println("     " + (char) (i + 65) + ") " +
                             qTemp.getChoice(i) + " <---  YOU CHOSE");
        }
        else
        {
          outputFile.println("     " + (char) (i + 65) + ") " +
                             qTemp.getChoice(i));
        }
      }
      outputFile.println();
    }
    outputFile.close();
    JOptionPane.showMessageDialog(null,
      "Your Results have been saved to disk. \n" +
      "Please open the file  " + name + "_" + dashDate + "_" + fileTime +
      ".txt \n" + " and print out a copy for your supervisors records.");

  }

  public void clearEdit()
  {
    jTextArea1.setText("");
    jTextArea2.setText("");
    jTextArea3.setText("");
    jTextArea4.setText("");
    jTextArea7.setText("");
    jTextField1.setText("");
    jTextField2.setText("");
  }

  private class WindowDestroyer
    extends WindowAdapter
  {
    public void windowClosing(WindowEvent e)
    {
      System.exit(0);
    }
  }
}