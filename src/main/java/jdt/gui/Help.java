package jdt.gui;

import com.vladsch.flexmark.ast.Document;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.options.MutableDataSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 * Help page that displays help from text files.
 *
 * @author Luke Leppan
 */
public class Help extends javax.swing.JFrame {

    private File[] files;

    /**
     * Creates new form Help
     */
    public Help() {
        initComponents();

        this.setTitle("Help - 1.Welcome");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon icon = new ImageIcon(getClass().getResource("/jdt/images/logo.png"));
        setIconImage(icon.getImage());

        treeFileChooser.setModel(new FilesContentProvider(getClass().getResource("/jdt/help").getPath()));
        treeFileChooser.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent event) {
                File file = (File) treeFileChooser.getLastSelectedPathComponent();
                if (!file.isDirectory()) {
                    setHelpFile(file);
                }
            }
        });
        setHelpFile(new File(getClass().getResource("/jdt/help/1.Welcome.md").getPath()));
    }

    private void setHelpFile(File file) {
        this.setTitle("Help - " + file.getName().substring(0, file.getName().length() - 3));
        String text = "";
        try (Scanner inFile = new Scanner(new FileReader(file))) {
            while (inFile.hasNextLine()) {
                text = text + inFile.nextLine() + "\n";
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Help.class.getName()).log(Level.SEVERE, null, ex);
        }

        String style = "<head>" + "<style>" + " body {" + "  font-family: Arial, Helvetica, sans-serif;" + " }"
                + "</style>" + "</head>";

        MutableDataSet options = new MutableDataSet();
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        Document document = parser.parse(text);
        String html = renderer.render(document);

        System.out.println(style + "<body>" + html + "</body>");

        pnlDocumentViewer.setEditable(false);
        pnlDocumentViewer.setContentType("text/html");
        pnlDocumentViewer.setText(style + "<body>" + html + "</body>");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFileChooserScroll = new javax.swing.JScrollPane();
        treeFileChooser = new javax.swing.JTree();
        pnlDocumentViewerScroll = new javax.swing.JScrollPane();
        pnlDocumentViewer = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        treeFileChooser.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treeFileChooser.setToolTipText("");
        pnlFileChooserScroll.setViewportView(treeFileChooser);

        pnlDocumentViewerScroll.setViewportView(pnlDocumentViewer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlFileChooserScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlDocumentViewerScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 607,
                                javax.swing.GroupLayout.PREFERRED_SIZE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlFileChooserScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                .addComponent(pnlDocumentViewerScroll));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane pnlDocumentViewer;
    private javax.swing.JScrollPane pnlDocumentViewerScroll;
    private javax.swing.JScrollPane pnlFileChooserScroll;
    private javax.swing.JTree treeFileChooser;
    // End of variables declaration//GEN-END:variables
}

class FilesContentProvider implements TreeModel {

    private File root;
    private Vector listeners = new Vector();

    public FilesContentProvider(String rootDirectory) {
        root = new File(rootDirectory);
    }

    @Override
    public Object getRoot() {
        return new TreeFile(root.getParentFile(), root.getName());
    }

    @Override
    public Object getChild(Object parent, int index) {
        File directory = (File) parent;
        String[] children = directory.list();
        return new TreeFile(directory, children[index]);
    }

    @Override
    public int getChildCount(Object parent) {
        File file = (File) parent;
        if (file.isDirectory()) {
            String[] fileList = file.list();
            if (fileList != null) {
                return file.list().length;
            }
        }
        return 0;
    }

    @Override
    public boolean isLeaf(Object node) {
        File file = (File) node;
        return file.isFile();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        File directory = (File) parent;
        File file = (File) child;
        String[] children = directory.list();
        for (int i = 0; i < children.length; i++) {
            if (file.getName().equals(children[i])) {
                return i;
            }
        }
        return -1;

    }

    @Override
    public void valueForPathChanged(TreePath path, Object value) {
        File oldFile = (File) path.getLastPathComponent();
        String fileParentPath = oldFile.getParent();
        String newFileName = (String) value;
        File targetFile = new File(fileParentPath, newFileName);
        oldFile.renameTo(targetFile);
        File parent = new File(fileParentPath);
        int[] changedChildrenIndices = { getIndexOfChild(parent, targetFile) };
        Object[] changedChildren = { targetFile };
        fireTreeNodesChanged(path.getParentPath(), changedChildrenIndices, changedChildren);
    }

    private void fireTreeNodesChanged(TreePath parentPath, int[] indices, Object[] children) {
        TreeModelEvent event = new TreeModelEvent(this, parentPath, indices, children);
        Iterator iterator = listeners.iterator();
        TreeModelListener listener = null;
        while (iterator.hasNext()) {
            listener = (TreeModelListener) iterator.next();
            listener.treeNodesChanged(event);
        }
    }

    @Override
    public void addTreeModelListener(TreeModelListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeTreeModelListener(TreeModelListener listener) {
        listeners.remove(listener);
    }

    private class TreeFile extends File {

        public TreeFile(File parent, String child) {
            super(parent, child);
        }

        @Override
        public String toString() {
            return isDirectory() ? getName() : getName().substring(0, getName().length() - 3);
        }

    }
}
