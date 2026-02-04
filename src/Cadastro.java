import java.time.LocalDate;
import java.time.ZoneId;
import java.time.Period;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class Cadastro extends javax.swing.JFrame {
    private RegistrationDTO dto;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Cadastro.class.getName());

    public Cadastro() {
        initComponents();
        dto = new RegistrationDTO();
        dto.setD(new RegistrationData());
        dto.setE(new RegistrationAddress());
        
    }

    public Cadastro(RegistrationDTO dto) {
    initComponents();

    this.dto = dto;

    if (this.dto.getD() == null) this.dto.setD(new RegistrationData());
    if (this.dto.getE() == null) this.dto.setE(new RegistrationAddress());

    toFill();
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelNome = new javax.swing.JLabel();
        jLabelNasc = new javax.swing.JLabel();
        jLabelCpf = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnCons = new javax.swing.JButton();
        spnNasc = new javax.swing.JSpinner();
        canvas1 = new java.awt.Canvas();
        txtCpf = new javax.swing.JFormattedTextField();

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

        txtNome.addActionListener(this::txtNomeActionPerformed);

        btnCons.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCons.setText("PROXIMO");
        btnCons.addActionListener(this::btnConsActionPerformed);

        spnNasc.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1769604803492L), new java.util.Date(-2208942032000L), new java.util.Date(1769604803492L), java.util.Calendar.DAY_OF_MONTH));
        spnNasc.setEditor(new javax.swing.JSpinner.DateEditor(spnNasc, "dd/MM/yyyy"));

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-## ")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.addActionListener(this::txtCpfActionPerformed);

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
                            .addComponent(txtNome)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(spnNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(140, 140, 140)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCons)
                        .addGap(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNasc)
                    .addComponent(btnCons)
                    .addComponent(spnNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCpf)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void toFill() {
    if (dto == null) return;
    
    RegistrationData d = dto.getD();

    if (d.getNome() != null) txtNome.setText(d.getNome());
    if (d.getCpf() != null) txtCpf.setText(d.getCpf()); 
    if (d.getNascimento() != null) {
        Date data = java.util.Date.from(d.getNascimento()
                .atStartOfDay(java.time.ZoneId.systemDefault())
                .toInstant()
        );
        spnNasc.setValue(data);
    }
    }
    
    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        
    }//GEN-LAST:event_txtNomeActionPerformed
    
    private void btnConsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsActionPerformed
        RegistrationData d = dto.getD();
        
        if (dto.getE() == null) {
        dto.setE(new RegistrationAddress());
    }
        
        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        
        java.util.Date dataNasc = (java.util.Date) spnNasc.getValue();
        java.time.LocalDate nascimento = dataNasc.toInstant()
                .atZone(java.time.ZoneId.systemDefault())
                .toLocalDate();
        
        d.setNascimento(nascimento);
        
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        String nascFormatada = sdf.format(dataNasc);
        
        d.setNome(nome);
        d.setCpf(cpf);
        d.setNascimento(nascimento);
        d.setNascFormatada(nascFormatada);
        
        java.util.List<String> erros = RegistrationValidator.validateName(d);
        
        if (!erros.isEmpty()) {
            String msg = String.join("\n", erros);
            javax.swing.JOptionPane.showMessageDialog(this, "Dados inválidos:\n\n" + msg);
            return;
        }
        d.setNome(txtNome.getText());
        d.setCpf(txtCpf.getText());
        d.setNascFormatada(nascFormatada);
        
        Endereco telaEndereco = new Endereco (dto);
        telaEndereco.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnConsActionPerformed

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed
  
        
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Cadastro().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCons;
    private java.awt.Canvas canvas1;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelNasc;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner spnNasc;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}