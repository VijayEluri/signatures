package signature.display;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import signature.AbstractVertexSignature;
import signature.ColoredTree;

public class SignatureViewer extends JPanel implements ActionListener {
    
    private ColoredTreePanel treePanel;
    
    private JTextField signatureStringField;
    
    private final int TREE_PANEL_WIDTH = 1200;
    
    private final int TREE_PANEL_HEIGHT = 500;
    
    public SignatureViewer() {
        this.setLayout(new BorderLayout());
        
        treePanel = new ColoredTreePanel(TREE_PANEL_WIDTH, TREE_PANEL_HEIGHT);
        this.add(treePanel, BorderLayout.CENTER);
        
        signatureStringField = new JTextField();
        signatureStringField.addActionListener(this);
        this.add(signatureStringField, BorderLayout.SOUTH);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signatureStringField) {
            String signatureString = signatureStringField.getText();
            ColoredTree tree = AbstractVertexSignature.parse(signatureString);
            treePanel.setTree(tree);
            this.repaint();
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Signature Viewer");
        f.add(new SignatureViewer());
        f.pack();
        f.setVisible(true);
    }

}
