package actividad6;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.NumberFormatException;
/**
 *
 * @author arbel
 */
public class Pantalla extends javax.swing.JFrame {

    /**
     * Creates new form Pantalla
     */
    public Pantalla() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        Number = new javax.swing.JTextField();
        Create = new javax.swing.JButton();
        Read = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name:");

        jLabel2.setText("Number:");

        Create.setText("Create");
        Create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateActionPerformed(evt);
            }
        });

        Read.setText("Read");
        Read.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReadActionPerformed(evt);
            }
        });

        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(21, 21, 21)
                            .addComponent(Number))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(32, 32, 32)
                            .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Create, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Read, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(Number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Create)
                    .addComponent(Read)
                    .addComponent(Update)
                    .addComponent(Delete)
                    .addComponent(Clear))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateActionPerformed
        try {
            String newName = Name.getText();
            long newNumber = Long.parseLong(Number.getText()); 
            String nameNumberString;
            String name;
            long number;
            int index;
            File file = new File("friendsContact.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            RandomAccessFile raf= new RandomAccessFile(file, "rw");
            boolean found = false;
 
            while (raf.getFilePointer() < raf.length()) {
                nameNumberString = raf.readLine();
                String[] lineSplit= nameNumberString.split("!");
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);
                if (name == newName|| number == newNumber) {
                    found = true;
                    break;
                }
            }
            if (found == false) {
                nameNumberString= newName + "!"+ String.valueOf(newNumber);
                raf.writeBytes(nameNumberString);
                raf.writeBytes(System.lineSeparator());
                System.out.println(" Amigo Añadido. ");
                raf.close();
            }
            else {
                raf.close();
                System.out.println(" Nombre ingresado"+ " no existe. ");
            }
        }
        catch (IOException ioe) {
            System.out.println(ioe);
        }
        catch (NumberFormatException nef) {
            System.out.println(nef);
        }
    }//GEN-LAST:event_CreateActionPerformed

    private void ReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReadActionPerformed
        try {
            String nameNumberString;
            String name;
            long number;
            int index;
            File file = new File("friendsContact.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;            
            while (raf.getFilePointer() < raf.length()) {
                nameNumberString = raf.readLine();
                String[] lineSplit
                    = nameNumberString.split("!");
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);
                System.out.println("Friend Name: " + name + "\n"+ "Contact Number: " + number + "\n");
            }
        }
            catch (IOException | NumberFormatException ioe)
            { 
                System.out.println(ioe);
            }
    }//GEN-LAST:event_ReadActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        try {
            String newName = Name.getText();
            long newNumber = Long.parseLong(Number.getText()); 
            String nameNumberString;
            String name;
            long number;
            int index;
            File file = new File("friendsContact.txt"); 
            if (!file.exists()) {
                file.createNewFile();
            }
            RandomAccessFile raf= new RandomAccessFile(file, "rw");
            boolean found = false;
            while (raf.getFilePointer() < raf.length()) {
                nameNumberString = raf.readLine();
                String[] lineSplit= nameNumberString.split("!");
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);
                if (name.equals(newName) || number == newNumber) {
                    found = true;
                    break;
                } else {
                }
            }
            if (found == true) {
                File tmpFile = new File("temp.txt");
                RandomAccessFile tmpraf= new RandomAccessFile(tmpFile, "rw");
                raf.seek(0);
                while (raf.getFilePointer()< raf.length()) {
                    nameNumberString = raf.readLine(); 
                    index = nameNumberString.indexOf('!');
                    name = nameNumberString.substring(0, index);
                    if (name.equals(newName)) {
                        nameNumberString
                            = name + "!"+ String.valueOf(newNumber);
                    }
                    tmpraf.writeBytes(nameNumberString);
                    tmpraf.writeBytes(System.lineSeparator());
                }
                raf.seek(0);
                tmpraf.seek(0);
                while (tmpraf.getFilePointer()< tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }
                raf.setLength(tmpraf.length());
                tmpraf.close();
                raf.close();
                tmpFile.delete(); 
                System.out.println(" Friend updated. ");
            }
            else {
                raf.close();
                System.out.println(" Input name"+ " does not exists. ");
            }
        }
        catch (IOException | NumberFormatException ioe) {
            System.out.println(ioe);
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        Name.setText("");
        Number.setText("");
    }//GEN-LAST:event_ClearActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        try {
            String newName = Name.getText(); 
            String nameNumberString;
            String name;
            long number;
            int index;
            File file = new File("friendsContact.txt");
 
            if (!file.exists()) {
                file.createNewFile();
            }
            RandomAccessFile raf= new RandomAccessFile(file, "rw");
            boolean found = false;
            while (raf.getFilePointer() < raf.length()) {
                nameNumberString = raf.readLine();
                String[] lineSplit = nameNumberString.split("!");
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);
                if (name.equals(newName)) {
                    found = true;
                    break;
                }
            }
            if (found == true) {
                File tmpFile = new File("temp.txt");
                RandomAccessFile tmpraf= new RandomAccessFile(tmpFile, "rw");
                raf.seek(0);
                while (raf.getFilePointer()< raf.length()) {
                    nameNumberString = raf.readLine();
                    index = nameNumberString.indexOf('!');
                    name = nameNumberString.substring(
                        0, index);
                    if (name.equals(newName)) {
                        continue;
                    }
                    tmpraf.writeBytes(nameNumberString);
                    tmpraf.writeBytes(
                        System.lineSeparator());
                }
                raf.seek(0);
                tmpraf.seek(0);
                while (tmpraf.getFilePointer()
                       < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }
                raf.setLength(tmpraf.length());
                tmpraf.close();
                raf.close();
                tmpFile.delete();
                System.out.println(" Friend deleted. ");
            }
            else {
                raf.close();
                System.out.println(" Input name"+ " does not exists. ");
            }
        }
        catch (IOException ioe) {
            System.out.println(ioe);
        }
    }//GEN-LAST:event_DeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JButton Create;
    private javax.swing.JButton Delete;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Number;
    private javax.swing.JButton Read;
    private javax.swing.JButton Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
