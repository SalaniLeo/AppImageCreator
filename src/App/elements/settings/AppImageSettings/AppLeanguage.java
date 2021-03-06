package App.elements.settings.AppImageSettings;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AppLeanguage {

    
    public JComboBox<String> cb = new JComboBox<String>();
	
    public AppLeanguage() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
            	cb.setBounds(10,300,100,20);
                cb.addItem("Apple");
                cb.addItem("Banana");
                cb.addItem("Orange");
                cb.setEditable(true);
                cb.setEditor(new MyComboBoxEditor());
                
            }
        });
    }
    
    public class MyComboBoxEditor implements ComboBoxEditor {

        private EditorPane editorPane;
        
        public MyComboBoxEditor() {
            editorPane = new EditorPane();
        }
        
        @Override
        public Component getEditorComponent() {
            return editorPane;
        }

        @Override
        public void setItem(Object anObject) {
            editorPane.setText(anObject == null ? null : anObject.toString());
        }

        @Override
        public Object getItem() {
            return editorPane.getText();
        }

        @Override
        public void selectAll() {
            editorPane.selectAll();
        }

        @Override
        public void addActionListener(ActionListener l) {
            editorPane.addActionListener(l);
        }

        @Override
        public void removeActionListener(ActionListener l) {
            editorPane.removeActionListener(l);
        }
        
    }
    
    public class EditorPane extends JPanel {

        private static final long serialVersionUID = 1L;
		private JTextField field;
        private JButton button;
        
        public EditorPane() {
            field = new JTextField(10);
            button = new JButton("X");
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            add(field, gbc);
            gbc.weightx = 0;
            gbc.fill = GridBagConstraints.NONE;
            gbc.gridx++;
            add(button, gbc);
        }

        @Override
        public void addNotify() {
            super.addNotify(); 
            field.requestFocusInWindow();
        }
        
        public void selectAll() {
            field.selectAll();
        }
        
        public void setText(String text) {
            field.setText(text);
        }
        
        public String getText() {
            return field.getText();
        }
        
        public void addActionListener(ActionListener listener) {
            field.addActionListener(listener);
        }
        
        public void removeActionListener(ActionListener listener) {
            field.removeActionListener(listener);
        }
        
    }
    
}