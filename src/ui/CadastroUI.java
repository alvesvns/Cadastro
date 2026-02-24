package ui;

import dao.PersonDao;
import entity.Address;
import entity.Person;
import java.time.LocalDate;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;

public class CadastroUI extends javax.swing.JFrame {
    private Person person;
    private Address address;
    private RegistrationUI parentList;
    
    public CadastroUI() {
        initComponents();
        this.parentList = null;
        this.person = new Person();
        this.address = new Address();
    }

    public CadastroUI(Person person, Address address, RegistrationUI parentList) {
        initComponents();
        this.person = person;
        this.address = address;
        this.parentList = parentList;
        
        if (this.person == null) this.person = new Person();
        if (this.address == null) this.address = new Address();
        
        setInfoForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelNome = new javax.swing.JLabel();
        jLabelNasc = new javax.swing.JLabel();
        jLabelCpf = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnCons = new javax.swing.JButton();
        spnBirth = new javax.swing.JSpinner();
        canvas1 = new java.awt.Canvas();
        txtCpf = new javax.swing.JFormattedTextField();
        btnVoltar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelNome.setText("NOME:");

        jLabelNasc.setText("NASC:");

        jLabelCpf.setText("CPF:");

        txtName.addActionListener(this::txtNameActionPerformed);

        btnCons.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCons.setText("PROXIMO");
        btnCons.addActionListener(this::btnConsActionPerformed);

        spnBirth.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1769604803492L), new java.util.Date(-2208942032000L), new java.util.Date(1769604803492L), java.util.Calendar.DAY_OF_MONTH));
        spnBirth.setEditor(new javax.swing.JSpinner.DateEditor(spnBirth, "dd/MM/yyyy"));

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-## ")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.addActionListener(this::txtCpfActionPerformed);

        btnVoltar.setText("VOLTAR");
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNasc)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelCpf)
                                .addGap(11, 11, 11)))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(315, 315, 315)
                                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(67, 67, 67))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtName)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(spnBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(140, 140, 140)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCons)
                        .addGap(17, 17, 17))))
            .addComponent(btnVoltar)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNasc)
                    .addComponent(btnCons)
                    .addComponent(spnBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCpf)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVoltar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void setInfoForm() {
        
        if (person == null) return;

        if (person.getName() != null) txtName.setText(person.getName());
        if (person.getCpf() != null) txtCpf.setText(person.getCpf()); 
        if (person.getBirth() != null) {
        spnBirth.setValue(java.sql.Date.valueOf(person.getBirth())); 
        }
    }
    
    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        
    }//GEN-LAST:event_txtNameActionPerformed
    
    private void btnConsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsActionPerformed

        String name = txtName.getText();
        String cpf = txtCpf.getText();
        
        Date dateBirth = (Date) spnBirth.getValue();
        LocalDate birth = dateBirth.toInstant()
            .atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        
        person.setBirth(birth);
        
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        String formattedBirth = sdf.format(dateBirth);
        
        person.setName(name);
        person.setCpf(cpf);
        person.setBirth(birth);
        person.setFormattedBirth(formattedBirth);
        
        List<String> erros = person.validate();

        
        if (!erros.isEmpty()) {
            String msg = String.join("\n", erros);
            JOptionPane.showMessageDialog(this, "Dados inválidos:\n\n" + msg);
            return;
        }
        
        try {
            PersonDao personDao = new PersonDao();

            Integer id = person.getId();

            if (person.isInsert()) {
                if (personDao.existsByCpf(cpf)) {
                    JOptionPane.showMessageDialog(this, "CPF já cadastrado!");
                    return;
                }
            } else {
                if (personDao.existsByCpfAndNotId(cpf, id)) {
                    JOptionPane.showMessageDialog(this, "CPF já cadastrado em outro cadastro!");
                    return;
                }
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, "Erro ao verificar CPF: " + erro.getMessage());
            return;
        }
        
        EnderecoUI endereco = new EnderecoUI (person, parentList);
        endereco.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnConsActionPerformed

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        if (parentList != null) {
            parentList.setVisible(true);
        } else {
            new RegistrationUI().setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed
  
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new CadastroUI().setVisible(true));
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCons;
    private javax.swing.JButton btnVoltar;
    private java.awt.Canvas canvas1;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelNasc;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner spnBirth;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}