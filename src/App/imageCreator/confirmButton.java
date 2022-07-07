package App.imageCreator;

import java.io.IOException;
import javax.swing.ImageIcon;

import App.elements.advancedOptions.setFolderMode;

/**
 *
 * @author leo
 */
@SuppressWarnings("serial")
public class confirmButton extends javax.swing.JPanel {
    public confirmButton() {
        initComponents();
    }                       
    private void initComponents() {
    	
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Next.png"))); // NOI18N
        jLabel1.setText("");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel1MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
					jLabel1MouseClicked(evt);
				} catch (IOException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );
    }// </editor-fold>                        

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {                                     
        ImageIcon II = new ImageIcon(getClass().getResource("/Images/NextPressed.png"));
        jLabel1.setIcon(II); // NOI18N
    }                                    

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {                                     
        ImageIcon II = new ImageIcon(getClass().getResource("/Images/NextEntered.png"));
        jLabel1.setIcon(II);
    }
    
    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {                                    
        ImageIcon II = new ImageIcon(getClass().getResource("/Images/Next.png"));
        jLabel1.setIcon(II);
    }       
    private void jLabel1MouseReleased(java.awt.event.MouseEvent evt) {                                      
        ImageIcon II = new ImageIcon(getClass().getResource("/Images/NextEntered.png"));
        jLabel1.setIcon(II); 
    }    
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) throws IOException, InterruptedException {                                      
       
    	initializer init = new initializer();
    	if(!setFolderMode.sb.isSelected()) {
    	init.createImageFiles();
    	} else {
    	init.FolderModeInit();
    	}
    }   
    // Variables declaration - do not modify                     
    public static javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}
