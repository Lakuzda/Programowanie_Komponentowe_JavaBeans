/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komponenty;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.PanelUI;

/**
 *
 * @author Adam
 */
public class Kompas3 extends JPanel{
    
    private int wartoscUstawiona, wartoscOczekiwana, wartoscObrotu;
    private JLabel lN,lS,lE,lW;
    
    public Kompas3() {
        
        setPreferredSize(new Dimension(230, 230));
        this.setLayout(null);
           
        lN = new JLabel("N");
        lN.setBounds(112, 0, 15, 10);
        this.add(lN);
        
        lS = new JLabel("S");
        lS.setBounds(112, 220, 15, 10);
        this.add(lS);
        
        lE = new JLabel("E");
        lE.setBounds(220, 112, 15, 10);
        this.add(lE);
        
        lW = new JLabel("W");
        lW.setBounds(0, 112, 15, 10);
        this.add(lW);
        
    }
        
    @Override
    protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            g2d.drawOval(15, 15, 200, 200);
            g2d.drawLine(115, 15, 115, 35);
    }


        
        public int getWartoscUstawiona() {
            return wartoscUstawiona;
        }

        public void setWartoscUstawiona(int wartoscUstawiona) {
            int old_wartoscUstawiona = this.wartoscUstawiona;
            this.wartoscUstawiona = wartoscUstawiona;
            
            firePropertyChange("wartoscUstawiona", old_wartoscUstawiona, wartoscUstawiona);
        }

        
        public int getWartoscOczekiwana() {
            return wartoscOczekiwana;
        }

        public void setWartoscOczekiwana(int wartoscOczekiwana) {
            int old_wartoscOczekiwana = this.wartoscOczekiwana;
            this.wartoscOczekiwana = wartoscOczekiwana;
            
            firePropertyChange("wartoscOczekiwana", old_wartoscOczekiwana, wartoscOczekiwana);
        }

        
        public int getWartoscObrotu() {
            return wartoscObrotu;
        }

        public void setWartoscObrotu(int wartoscObrotu) {
            int old_wartoscObrotu = this.wartoscObrotu;
            this.wartoscObrotu = wartoscObrotu;
            
            firePropertyChange("wartoscObrotu", old_wartoscObrotu, wartoscObrotu);
        }
        
        
        public void obliczKat(){
            
            if ( (wartoscUstawiona >= 0) && (wartoscUstawiona <=360) && (wartoscOczekiwana >= 0) && (wartoscOczekiwana <=360) ){
            wartoscObrotu = wartoscOczekiwana - wartoscUstawiona;
                if((wartoscObrotu < -180)&&(wartoscObrotu > 180))
                {
                    if (wartoscObrotu < 0)
                    {
                        wartoscObrotu += 360;
                    }
                    else
                    {
                        wartoscObrotu -= 360;
                    }
                }
            } else{
                JOptionPane.showMessageDialog(this, "Wprowadź poprawne dane !");
            }
            setWartoscObrotu(wartoscObrotu);
        }
        
    
}
