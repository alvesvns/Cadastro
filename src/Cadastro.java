import java.time.LocalDate;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;

public class Cadastro extends javax.swing.JFrame {
    private RegistrationDto registrationDto;
    private RegistrationList parentList;
    
    public Cadastro() {
        initComponents();
        this.parentList = null;
        registrationDto = new RegistrationDto();
        registrationDto.setRegistrationData(new RegistrationData());
        registrationDto.setRegistrationAddress(new RegistrationAddress());
    }

    public Cadastro(RegistrationDto registrationDto, RegistrationList parentList) {
        initComponents();
        this.registrationDto = registrationDto;
        this.parentList = parentList;
        
        if (this.registrationDto.getRegistrationData() == null) {
            this.registrationDto.setRegistrationData(new RegistrationData());
        }
        if (this.registrationDto.getRegistrationAddress() == null) {
            this.registrationDto.setRegistrationAddress(new RegistrationAddress());
        }
        
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
        
        if (registrationDto == null) return;
    
        RegistrationData registrationData = registrationDto.getRegistrationData();

        if (registrationData.getName() != null) txtName.setText(registrationData.getName());
        if (registrationData.getCpf() != null) txtCpf.setText(registrationData.getCpf()); 
        if (registrationData.getBirth() != null) {
        spnBirth.setValue(java.sql.Date.valueOf(registrationData.getBirth())); 
        }
    }
    
    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        
    }//GEN-LAST:event_txtNameActionPerformed
    
    private void btnConsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsActionPerformed
        RegistrationData registrationData = registrationDto.getRegistrationData();
        
        if (registrationDto.getRegistrationAddress() == null) {
            registrationDto.setRegistrationAddress(new RegistrationAddress());
        }
        
        String name = txtName.getText();
        String cpf = txtCpf.getText();
        
        Date dateBirth = (java.util.Date) spnBirth.getValue();
        LocalDate birth = dateBirth.toInstant()
            .atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        
        registrationData.setBirth(birth);
        
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        String formattedBirth = sdf.format(dateBirth);
        
        registrationData.setName(name);
        registrationData.setCpf(cpf);
        registrationData.setBirth(birth);
        registrationData.setFormattedBirth(formattedBirth);
        
        List<String> erros = registrationData.validate();

        
        if (!erros.isEmpty()) {
            String msg = String.join("\n", erros);
            JOptionPane.showMessageDialog(this, "Dados inválidos:\n\n" + msg);
            return;
        }
        
        try {
            PersonDao dao = new PersonDao();

            Integer id = registrationData.getId();

            if (id == null || id == 0) {
                if (dao.existsByCpf(cpf)) {
                    JOptionPane.showMessageDialog(this, "CPF já cadastrado!");
                    return;
                }
            } else {
                if (dao.existsByCpfAndNotId(cpf, id)) {
                    JOptionPane.showMessageDialog(this, "CPF já cadastrado em outro cadastro!");
                    return;
                }
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, "Erro ao verificar CPF: " + erro.getMessage());
            return;
        }

        registrationData.setName(txtName.getText());
        registrationData.setCpf(txtCpf.getText());
        registrationData.setFormattedBirth(formattedBirth);
        
        Endereco endereco = new Endereco (registrationDto, parentList);
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
            new RegistrationList().setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed
  
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Cadastro().setVisible(true));
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