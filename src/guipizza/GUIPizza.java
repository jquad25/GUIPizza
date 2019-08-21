/*
 * GUIMenu allows customers to order a pizza.
 */
package guipizza;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintStream; 

/**
 *
 * @author ujordanaquadro
 * @version v1.0
 */
public class GUIPizza {
    
    private JFrame frame;
    
    private JPanel contentPane;
    
    // radio buttons and button group
    private JRadioButton regularCrustButton;
    private JRadioButton thinCrustButton;
    private JRadioButton handCrustButton;
    private JRadioButton deepCrustButton;
    private ButtonGroup crustButtonGroup;

    // check boxes
    private JCheckBox pepperoniBox;
    private JCheckBox sausageBox;
    private JCheckBox cheeseBox;
    private JCheckBox pepperBox;
    private JCheckBox onionBox;
    private JCheckBox mushroomBox;
    private JCheckBox oliveBox;
    private JCheckBox anchovyBox;

    // text fields
    private JTextField breadSticksText;
    private JTextField buffaloWingsText;
    private JTextField nameText;
    private JTextField addressText;
    private JTextField cityText;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       GUIPizza gui = new GUIPizza();
      gui.start();
      System.setProperty("apple.laf.useScreenMenuBar", "true");
    }
    
    public void start() 
    {
      frame = new JFrame("GUI Menus");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container contentPane = frame.getContentPane();
      makeMenus();
      makeContent();

      frame.setSize(300, 300);
      frame.setVisible(true);
    }
    
    private void makeMenus()
    {
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
        
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        
    //set up the File menu
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menu);
        
       //set up the File menu items New Order, Save Order, and Exit
       menuItem = new JMenuItem("New Order");
       menuItem.addActionListener(new NewOrderListener());
       menuItem.setMnemonic(KeyEvent.VK_N);
       menuItem.setAccelerator(
            KeyStroke.getKeyStroke(KeyEvent.VK_N,
                    Event.CTRL_MASK));
       menu.add(menuItem);
       
       menuItem = new JMenuItem("Save Order");
       menuItem.addActionListener(new SaveOrderListener());
       menuItem.setMnemonic(KeyEvent.VK_S);
       menuItem.setAccelerator(
            KeyStroke.getKeyStroke(KeyEvent.VK_S,
                        Event.CTRL_MASK));
       menu.add(menuItem);
       menu.addSeparator();
       
       menuItem = new JMenuItem("Exit");
       menuItem.addActionListener(new ExitListener());
       menuItem.setMnemonic(KeyEvent.VK_E);
       menuItem.setAccelerator(
            KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                        Event.CTRL_MASK));
       menu.add(menuItem);
       
       
        // set up the Help menu
        menu = new JMenu("Help");
        menu.setMnemonic(KeyEvent.VK_H);
        menuBar.add(menu);
    
        // set up the Help menu item About GUI Pizza
        menuItem = new JMenuItem("About GUI Pizza");
        menuItem.addActionListener(new AboutListener());
        menuItem.setMnemonic(KeyEvent.VK_A);
        menu.add(menuItem);
    }
    
        //conent method
    private void makeContent()
    {
        contentPane = (JPanel)frame.getContentPane();
        contentPane.setLayout(new BorderLayout(6,6));
        
        makeNorthRegion();
        makeWestRegion();
        makeCenterRegion();
        makeEastRegion();
        makeSouthRegion();
        
    }
    
    private void makeNorthRegion()
    {
        JLabel imgLabel = new JLabel(new ImageIcon("Pizza_L8.jpeg"), 
                JLabel.CENTER);
        contentPane.add(imgLabel, BorderLayout.NORTH);
    }
    
    private void makeWestRegion() 
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Choose a Crust"));
        
        crustButtonGroup = new ButtonGroup();
         
         regularCrustButton = new JRadioButton("Regular Crust", true);
         crustButtonGroup.add(regularCrustButton);
         panel.add(regularCrustButton);
         
         thinCrustButton = new JRadioButton("Thin Crust", false);
         crustButtonGroup.add(thinCrustButton);
         panel.add(thinCrustButton);
         
         handCrustButton = new JRadioButton("Hand-Tossed Crust", false);
         crustButtonGroup.add(handCrustButton);
         panel.add(handCrustButton);
         
         deepCrustButton = new JRadioButton("Deep-Dish Crust", false);
         crustButtonGroup.add(deepCrustButton);
         panel.add(deepCrustButton);
         
        contentPane.add(panel, BorderLayout.WEST);                 
    }
    
    private void makeCenterRegion() 
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("SelectToppings"));
        
            pepperoniBox = new JCheckBox("Pepperoni", false);
            panel.add(pepperoniBox);
            
            sausageBox = new JCheckBox("Sausage", false);
            panel.add(sausageBox);
            
            cheeseBox = new JCheckBox("Extra Cheese", false);
            panel.add(cheeseBox);
            
            pepperBox = new JCheckBox("Bell Peppers", false);
            panel.add(pepperBox);
            
            onionBox = new JCheckBox("Onions", false);
            panel.add(onionBox);
            
            mushroomBox = new JCheckBox("Mushrooms", false);
            panel.add(mushroomBox);
            
            oliveBox = new JCheckBox("Olives", false);
            panel.add(oliveBox);
            
            anchovyBox = new JCheckBox("Anchovies", false);
            panel.add(anchovyBox);
            
        contentPane.add(panel, BorderLayout.CENTER);           
    }
    
    private void makeEastRegion()
    {
        // set up side orders with quantities in EAST
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Sides (Enter Quantity)"));
        panel.setPreferredSize(new Dimension (150, 0));
    
        JPanel smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.X_AXIS));
        breadSticksText = new JTextField("",2);
        smallPanel.add(breadSticksText);
        smallPanel.add(new JLabel(" Bread Sticks"));
        panel.add(smallPanel);
        contentPane.add(panel, BorderLayout.EAST);
        breadSticksText.setMaximumSize(new Dimension(20,24));
        smallPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    }
    
    private void makeSouthRegion()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Deliver To:"));
        
        JPanel smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel,BoxLayout.Y_AXIS));
        smallPanel.add(new JLabel("Name:"));
        smallPanel.add(new JLabel("Address:"));
        smallPanel.add(new JLabel("City, St, Zip"));    
        
        //add text fields
        smallPanel = new JPanel();
        smallPanel.setLayout(new BoxLayout(smallPanel,BoxLayout.Y_AXIS));
        nameText = new JTextField();
        addressText = new JTextField();
        cityText = new JTextField();
        smallPanel.add(nameText);
        smallPanel.add(addressText);
        smallPanel.add(cityText);
        panel.add(smallPanel);
        smallPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        
        panel.add(smallPanel);
        contentPane.add(panel, BorderLayout.SOUTH);        
    }
    
     //set up internal classes that implement the ActionListener interface
    private class NewOrderListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {            
            //clear the radio buttons
            regularCrustButton.setSelected(true);
            //clear the check boxes
            pepperoniBox.setSelected(false);
            sausageBox.setSelected(false);
            cheeseBox.setSelected(false);
            pepperBox.setSelected(false);
            onionBox.setSelected(false);
            mushroomBox.setSelected(false);
            oliveBox.setSelected(false);
            anchovyBox.setSelected(false);
            //clear the text fields
            breadSticksText.setText("");
            buffaloWingsText.setText("");
            nameText.setText("");
            addressText.setText("");
            cityText.setText("");
        }
    }
    
    private class SaveOrderListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            
            //save the radio button information
            String order = "Pizza Order\n" + "===========\n" + "Crust:\n";
            if (regularCrustButton.isSelected())
                order += "     Regular\n";
            else if (thinCrustButton.isSelected())
                order += "     Thin\n";
            else if (deepCrustButton.isSelected())
                order += "     Deep-Dish\n";
            else if (handCrustButton.isSelected())
                order += "     Hand-Tossed\n";
            else JOptionPane.showMessageDialog(frame, 
                "You must select a crust type!",
                "Crust Type Error", 
                JOptionPane.ERROR_MESSAGE);
            
            //save the checkboxinformation
            order += "Toppings:\n";
            if (pepperoniBox.isSelected())
                order += "     Pepperoni\n";
            if (sausageBox.isSelected())
                order += "     Sausage\n";
            if (cheeseBox.isSelected())
                order += "     Extra Cheese\n";
            if (pepperBox.isSelected())
                order += "     Peppers\n";
            if (onionBox.isSelected())
                order += "     Onions\n";
            if (mushroomBox.isSelected())
                order += "     Mushrooms\n";
            if (oliveBox.isSelected())
                order += "     Olives\n";
            if (anchovyBox.isSelected())
                order += "     Anchovies\n";
            
            //save the sides information
            int bs = 0;
            int bw = 0;
            try
            {
                if (!breadSticksText.getText().isEmpty())
                bs = Integer.parseInt(breadSticksText.getText());
                if (!buffaloWingsText.getText().isEmpty())
                bw = Integer.parseInt(buffaloWingsText.getText());
            }
            catch (NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(frame, 
                "Side order entries must be numeric,\n" +
                "and must be whole numbers", 
                "Side Order Error", 
                JOptionPane.ERROR_MESSAGE);
            }           
            if (bs > 0 || bw > 0)
            {
                order += "Sides:\n";
                if (bs > 0)
                order += "     " + bs + " Bread Sticks\n";
                if (bw > 0)
                order += "     " + bw + " Buffalo Wings\n";
            }   
            //save the text field information
            if (nameText.getText().isEmpty() ||
            addressText.getText().isEmpty() ||
            cityText.getText().isEmpty())
            JOptionPane.showMessageDialog(frame, 
            "Address fields may not be empty.",
            "Address Error", 
            JOptionPane.ERROR_MESSAGE);
            else
            {
                order += "Deliver To:\n";
                order += "     " + nameText.getText() + "\n";
                order += "     " + addressText.getText() + "\n";
                order += "     " + cityText.getText() + "\n";
            }
            order += "\n***END OF ORDER ***\n";
            
            //output order file
            try
            {
                PrintStream oFile = new PrintStream("PizzaOrder.txt");
                oFile.print(order);
                oFile.close();
            }
            catch(IOException ioe)
            {
                System.out.println("\n*** I/O Error ***\n" + ioe);
            }
        }
    }
    
    private class ExitListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            System.exit(0);
        }
    }
    
    private class AboutListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            JOptionPane.showMessageDialog(frame,
                    "GUI Pizza\n\nVersion 1.0\nBuild B20080226-1746\n\n" +
                    "(c) Copyright Merrill Hall 2008\nAll Rights Reserved\n\n" +
                    "Visit\nEducation To Go\n" +
                    "Intermediate Java Course",
                    "About GUI Pizza",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
