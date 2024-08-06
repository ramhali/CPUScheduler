package com.mycompany.mfqs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.BoxLayout;
import java.awt.Choice;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.Component;

public class Main{
	private static JTextField textField;
  public static void main(String[] args) {
    // JFrame 
    JFrame frame = new JFrame();
    frame.setSize(1600, 900);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new GridLayout(2,1));

    // add two rows
    JPanel row1 = new JPanel();
    row1.setLayout(new GridBagLayout());
    
    
    //Add Labels to Row 1
    GridBagConstraints ganttChartLabelConstraints = new GridBagConstraints();
    ganttChartLabelConstraints.fill = GridBagConstraints.BOTH;
    ganttChartLabelConstraints.gridx = 0;
    ganttChartLabelConstraints.gridy = 0;
    ganttChartLabelConstraints.weighty = 0.01; // minimal height
    ganttChartLabelConstraints.weightx = .9;
    row1.add(new JLabel("Gantt Chart"), ganttChartLabelConstraints);
    
    GridBagConstraints paLabelConstraints = new GridBagConstraints();
    paLabelConstraints.fill = GridBagConstraints.BOTH;
    paLabelConstraints.gridx = 1;
    paLabelConstraints.gridy = 0;
    paLabelConstraints.weighty = 0.01; // minimal height
    paLabelConstraints.weightx = .9;
    row1.add(new JLabel("Performance Analysis"), paLabelConstraints);
    
    // Gantt Chart - row 1
    JPanel gannChart = new JPanel();
    gannChart.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 5), new EtchedBorder()));
    // get the width of the window for 

    // Performance Analysis panel - row1
    JPanel perfAnalysis = new JPanel();
    perfAnalysis.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 5, 10, 10), new EtchedBorder()));
    
    //Add Panels to Row 1
    
    GridBagConstraints gcc_gbc = new GridBagConstraints();
    gcc_gbc.fill = GridBagConstraints.BOTH;
    gcc_gbc.gridx = 0;
    gcc_gbc.gridy = 1;
    gcc_gbc.weighty = 0.99;
    row1.add(gannChart, gcc_gbc);
    
    GridBagConstraints pa_gbc = new GridBagConstraints();
    pa_gbc.fill = GridBagConstraints.BOTH;
    pa_gbc.gridx = 1;
    pa_gbc.gridy = 1;
    pa_gbc.weighty = 0.99;
    row1.add(perfAnalysis, pa_gbc);

    JPanel row2 = new JPanel();
    GridBagLayout gbl_row2 = new GridBagLayout();
    gbl_row2.rowWeights = new double[]{0.0, 0.0};
    gbl_row2.columnWeights = new double[]{1.0, 1.0, 0.0};
    row2.setLayout(gbl_row2);
    JPanel classConfig = new JPanel(new BorderLayout());
    classConfig.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5, 5, 5, 5), new EtchedBorder()));
    
    
    //NORTH part of Class Config
    JPanel classConfigL1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
    JTextField processCount = new JTextField(20);
    classConfigL1.add(new JLabel("No of Processes"));
    classConfigL1.add(processCount);
    JButton classConfigGenerate = new JButton("Generate");
    JButton classConfigClear = new JButton("Clear");
    classConfigL1.add(classConfigGenerate);
    classConfigL1.add(classConfigClear);
    classConfig.add(classConfigL1, BorderLayout.NORTH);
    
    //South part of class config
    JButton randomizeBtn = new JButton("Randomize");
    
    classConfig.add(randomizeBtn, BorderLayout.SOUTH);
    
    JPanel mlfqConfig = new JPanel(new BorderLayout());
    mlfqConfig.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5, 5, 5, 5), new EtchedBorder()));
    
    //North Part of mlfqConfig
    JPanel mlfqConfigL1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    mlfqConfigL1.add(new JLabel("No. of Queues"));
    JTextField queueCount = new JTextField(20);
    mlfqConfigL1.add(queueCount);
    JButton mlfqConfigGenerate = new JButton("Generate");
    JButton mlfqConfigClear = new JButton("Clear");
    mlfqConfigL1.add(mlfqConfigGenerate);
    mlfqConfigL1.add(mlfqConfigClear);
    
    mlfqConfig.add(mlfqConfigL1, BorderLayout.NORTH);
    
    JPanel miscConfig = new JPanel();
    miscConfig.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5, 5, 5, 5), new EtchedBorder()));
    
    //Add Box and Labels to second row
    GridBagConstraints ccl_gbc = new GridBagConstraints();
    ccl_gbc.insets = new Insets(0, 0, 5, 5);
    ccl_gbc.fill = GridBagConstraints.BOTH;
    ccl_gbc.gridx = 0;
    ccl_gbc.gridy = 0;
    ccl_gbc.weighty = 0.01; // minimal height
    ccl_gbc.weightx = .9;
    row2.add(new JLabel("Classification Configuration"), ccl_gbc);
    
    GridBagConstraints mcl_gbc = new GridBagConstraints();
    mcl_gbc.insets = new Insets(0, 0, 5, 5);
    mcl_gbc.fill = GridBagConstraints.BOTH;
    mcl_gbc.gridx = 1;
    mcl_gbc.gridy = 0;
    mcl_gbc.weighty = 0.01; // minimal height
    mcl_gbc.weightx = .9;
    row2.add(new JLabel("MLFQ Configuration Panel"), mcl_gbc);
    
    GridBagConstraints acl_gbc = new GridBagConstraints();
    acl_gbc.insets = new Insets(0, 0, 5, 0);
    acl_gbc.fill = GridBagConstraints.BOTH;
    acl_gbc.gridx = 2;
    acl_gbc.gridy = 0;
    acl_gbc.weighty = 0.01; // minimal height
    acl_gbc.weightx = .9;
    row2.add(new JLabel("Additional Configuration Panel"), acl_gbc);
    
    GridBagConstraints cc_gbc = new GridBagConstraints();
    cc_gbc.insets = new Insets(0, 0, 5, 5);
    cc_gbc.fill = GridBagConstraints.BOTH;
    cc_gbc.gridx = 0;
    cc_gbc.gridy = 1;
    cc_gbc.weighty = 0.99;
    cc_gbc.weightx = .9;
    row2.add(classConfig, cc_gbc);
    
    GridBagConstraints mc_gbc = new GridBagConstraints();
    mc_gbc.insets = new Insets(0, 0, 5, 5);
    mc_gbc.fill = GridBagConstraints.BOTH;
    mc_gbc.gridx = 1;
    mc_gbc.gridy = 1;
    mc_gbc.weighty = 0.99;
    mc_gbc.weightx = .9;
    row2.add(mlfqConfig, mc_gbc);
    miscConfig.setLayout(null);
    
    GridBagConstraints misc_gbc = new GridBagConstraints();
    misc_gbc.insets = new Insets(0, 0, 5, 0);
    misc_gbc.fill = GridBagConstraints.BOTH;
    misc_gbc.gridx = 2;
    misc_gbc.gridy = 1;
    misc_gbc.weighty = 0.99;
    misc_gbc.weightx = .9;
    row2.add(miscConfig, misc_gbc);
    
    JPanel panel = new JPanel();
    panel.setBounds(10, 31, 294, 34);
    miscConfig.add(panel);
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    
    JLabel label = new JLabel("Priority Policy");
    label.setHorizontalAlignment(SwingConstants.LEFT);
    label.setAlignmentY(2.0f);
    panel.add(label);
    
    JComboBox comboBox = new JComboBox();
    comboBox.setModel(new DefaultComboBoxModel(new String[] {"Higher Before Lower", "Fixed Time Slot"}));
    comboBox.setMaximumRowCount(2);
    panel.add(comboBox);
    
    JPanel panel_1 = new JPanel();
    panel_1.setBounds(10, 82, 297, 34);
    miscConfig.add(panel_1);
    panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
    
    JLabel lblNewLabel = new JLabel("Entry Queue");
    panel_1.add(lblNewLabel);
    
    textField = new JTextField();
    textField.setColumns(10);
    panel_1.add(textField);
    
    JPanel panel_2 = new JPanel();
    panel_2.setBounds(0, 0, 10, 10);
    miscConfig.add(panel_2);
    
    
    frame.getContentPane().add(row2);

    // Gann Chart



    // row 2
    frame.getContentPane().add(row1);
    frame.getContentPane().add(row2);

    // set visible
    frame.setVisible(true);
    frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
   
  }
}

// p.setBorder(new EmptyBorder(10, 10, 10, 10)); -- for adding padding