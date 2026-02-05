
public class FinalTela extends javax.swing.JFrame{
    
    private RegistrationDTO registrationDto;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FinalTela.class.getName());

    public FinalTela(RegistrationDTO registrationDto) { 
        initComponents();
        this.registrationDto = registrationDto;
                
        if (this.registrationDto.getRegistrationData() == null) this.registrationDto.setRegistrationData(new RegistrationData());
        if (this.registrationDto.getRegistrationAddress() == null) this.registrationDto.setRegistrationAddress(new RegistrationAddress());

        RegistrationData registrationData = this.registrationDto.getRegistrationData();
        RegistrationAddress registrationAddress = this.registrationDto.getRegistrationAddress();
        
        lblNome.setText("Nome: " + registrationData.getName());
        lblNascimento.setText("Nascimento: " + registrationData.getFormattedBirth() + " - " + registrationData.getAge() + " anos");
        lblCpf.setText("CPF: " + registrationData.getCpf());
        lblEndereco.setText("Endereço: " + registrationAddress.getAddressText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        lblNascimento = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();
        btnVoltar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNome.setText("\"Nome: \" + nome");

        lblNascimento.setText("\"Data de nascimento: \" + nascFormatada");

        lblCpf.setText("\"CPF: \" + cpf");

        lblEndereco.setText("\"Endereço: \" + rua + \", \" + bairro + \", \" + cidade + \" - \" + uf + \" - \" + cep");

        jLabel9.setText("CADASTRO REALIZADO");

        btnFinalizar.setText("FINALIZAR");
        btnFinalizar.addActionListener(this::btnFinalizarActionPerformed);

        btnVoltar1.setText("VOLTAR");
        btnVoltar1.addActionListener(this::btnVoltar1ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEndereco)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(btnFinalizar)))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnVoltar1))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNascimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCpf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEndereco)
                .addGap(64, 64, 64)
                .addComponent(btnFinalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnVoltar1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar1ActionPerformed
        Endereco endereco = new Endereco(registrationDto);
        endereco.setVisible(true);
        this.dispose();        
    }//GEN-LAST:event_btnVoltar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnVoltar1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNascimento;
    private javax.swing.JLabel lblNome;
    // End of variables declaration//GEN-END:variables
}
