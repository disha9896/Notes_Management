/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;

import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javafx.scene.control.ScrollBar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author admin1
 */
public class Calendar extends javax.swing.JFrame implements MouseListener, ItemListener,AdjustmentListener {

    /**
     * Creates new form Calendar
     */
    int width = this.getToolkit().getScreenSize().getSize().width;
    int height = this.getToolkit().getScreenSize().getSize().height;

    public Calendar() {
        initComponents();
        jCalendar1.setBackground(new Color(3, 20, 38));
        this.setBounds(0, 0, width, height);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jCalendar1.setBounds(this.getBounds());
        jCalendar1.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        jCalendar1.setForeground(Color.WHITE);
        //jCalendar1.getDayChooser().addMouseListener(this);
        //addMouseListener(this);
        jCalendar1.getMonthChooser().addMouseListener(this);
        jCalendar1.getYearChooser().addMouseListener(this);

        setBtnColor(true);
        addListeners();
    }
    
    void addListeners()
    {
        for (Component c : jCalendar1.getMonthChooser().getComponents()) {
            if (c instanceof JComboBox) {
                System.out.println("cfdsd");
                ((JComboBox) c).addItemListener(this);
            }
            System.out.println(" --- " + c.getClass());
        }
        
        for(Component c : jCalendar1.getYearChooser().getComponents())
        {
            if (c instanceof JScrollBar) {
                
                System.out.println("cfdsd");
                ((JScrollBar) c).addAdjustmentListener(this);
              //  ((JTextField) c).addVa;
            }
            else if(c instanceof JTextField)
            {
                c.setEnabled(false);
            }
                
            System.out.println(" xxx " + c.getClass());
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g); //To change body of generated methods, choose Tools | Templates.
        setBtnColor(false);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);
        getContentPane().add(jCalendar1);
        jCalendar1.setBounds(0, 50, 770, 470);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void setBtnColor(boolean addListener) {
        for (Component c : jCalendar1.getComponents()) {
            System.out.println(c.getClass());
            if (c instanceof JDayChooser) {
                JDayChooser jc = (JDayChooser) c;
                for (Component c1 : jc.getComponents()) {
                    System.out.println(c1.getClass());
                    if (c1 instanceof JButton) {
                        JButton b = (JButton) c1;
                        //System.out.println(c1.getClass());
                        b.setBackground(new Color(1, 185, 225));

                        if (addListener) {
                            b.addMouseListener(this);
                        }

                    }

                }

            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calendar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar jCalendar1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.print(jCalendar1.getDayChooser().getDay() + " - ");
        System.out.print(jCalendar1.getMonthChooser().getMonth() + " - ");
        System.out.println(jCalendar1.getYearChooser().getYear() + "");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        setBtnColor(false);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        setBtnColor(false);
        repaint();
        System.out.println(e.getItem().toString());
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println(e.getValue()+"t");
        repaint();
    }
}
