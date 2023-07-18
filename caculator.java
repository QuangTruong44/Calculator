/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import static java.awt.SystemColor.text;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.Spring.width;
import javax.swing.border.EtchedBorder;


public class caculator {

    public caculator() {
        myGUI();
    }
    JFrame jMain;
    int x=5,y=5,w=400,h=400;
    JLabel lblKQ;
    String[] srtButtonName = {"1","2","3","/","sqrt",
                              "4","5","6","*","%",
                              "7","8","9","-","1/x",
                              "0","+/-","C","+","="};
    JButton[] btns = new JButton[srtButtonName.length];
    String strso1 = "", strso2 = "", strpheptinh = "";
    
    private void myGUI(){
        jMain = new JFrame();
        jMain.setSize(w,h);
        jMain.setLocationRelativeTo(null);
        jMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jMain.setTitle("Calculator");
        JPanel pMain = new JPanel();
        pMain.setLayout(null);
        
        //TAO TIEU DE CASIO
        JLabel lblCasio = new JLabel("Casio",JLabel.RIGHT);
        Font font1 = new Font("tahoma",Font.BOLD,18);
        lblCasio.setFont(font1);
        lblCasio.setBounds(x,y,w-30,50);
        pMain.add(lblCasio);
        y+=50;
        
        //TAO O KET QUA
        lblKQ = new JLabel("0",JLabel.RIGHT);
        Font font2 = new Font("tahoma",Font.PLAIN,18);
        lblKQ.setFont(font2);
        lblKQ.setForeground(Color.BLUE);
        lblKQ.setBounds(x,y,w-30,50);
        lblKQ.setBorder(new EtchedBorder(EtchedBorder.LOWERED));/*TAO KHUNG*/ 
        pMain.add(lblKQ);
        y+=70;
        
        JPanel pButton = new JPanel(new GridLayout(4,5,5,5));
        for(int i=0;i<srtButtonName.length;i++){
            btns[i] = new JButton(srtButtonName[i]);
            pButton.add(btns[i]);
            btns[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String s = e.getActionCommand();
                    switch (s) {
                        case "0","1","2","3","4","5","6","7","8","9":
                            if(strpheptinh.equals("")){
                                strso1 += s;
                                lblKQ.setText(strso1);
                            }else{
                                strso2 += s;
                                lblKQ.setText(strso2);
                            }
                            break;
                        case "+","-","*","/":
                            strpheptinh = s;
                            break;
                        case "=":
                            switch (strpheptinh) {
                                case "-":
                                    int so1 = Integer.parseInt(strso1);
                                    int so2 = Integer.parseInt(strso2);
                                    lblKQ.setText((so1-so2)+"");
                                    break;
                                case "+":
                                    int so3 = Integer.parseInt(strso1);
                                    int so4 = Integer.parseInt(strso2);
                                    lblKQ.setText((so3+so4)+"");
                                    break;
                                case "/":
                                    int so5 = Integer.parseInt(strso1);
                                    int so6 = Integer.parseInt(strso2);
                                    lblKQ.setText((so5/so6)+"");
                                    break;
                                case "*":
                                    int so7 = Integer.parseInt(strso1);
                                    int so8 = Integer.parseInt(strso2);
                                    lblKQ.setText((so7*so8)+"");
                                    break;
                                    
                                default:                                  
                            }
                        default:
                            
                    }
                    
                }
            });
        }
        
        pButton.setBounds(x,y,w-30,200);
        jMain.add(pButton);
        jMain.add(pMain);
        jMain.setVisible(true);
    }
}