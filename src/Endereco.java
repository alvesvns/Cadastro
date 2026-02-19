import javax.swing.SwingWorker;
import javax.swing.JOptionPane;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.net.SocketTimeoutException;
import java.time.Duration;
import javax.swing.JDialog;




    public class Endereco extends javax.swing.JFrame {
        private RegistrationDto registrationDto;
        private RegistrationList parentList;
        private JDialog loadingDialog;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Endereco.class.getName());

    public Endereco() {
        initComponents();
        this.parentList = null;

        this.registrationDto = new RegistrationDto();
        this.registrationDto.setRegistrationData(new RegistrationData());
        this.registrationDto.setRegistrationAddress(new RegistrationAddress());

        setListUf();
        setInfoForm();
    }

    public Endereco(RegistrationDto registrationDto, RegistrationList parentList) {
        initComponents();
        this.registrationDto = registrationDto;
        this.parentList = parentList;

        if (this.registrationDto.getRegistrationData() == null) {
            this.registrationDto.setRegistrationData(new RegistrationData());
        }
        if (this.registrationDto.getRegistrationAddress() == null) {
            this.registrationDto.setRegistrationAddress(new RegistrationAddress());
        }

        setListUf();
        setInfoForm();
    }
    
    public Endereco(RegistrationDto registrationDto) {
        this(registrationDto, null);
    }


    private void setListUf() {
        cmbUf.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[] {
                "Selecione",
                "AC","AL","AP","AM","BA","CE","DF","ES","GO",
                "MA","MT","MS","MG","PA","PB","PR","PE","PI",
                "RJ","RN","RS","RO","RR","SC","SP","SE","TO"
            }
        ));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCep = new javax.swing.JFormattedTextField();
        txtRua = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        cmbUf = new javax.swing.JComboBox<>();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("CEP:");

        jLabel2.setText("Rua:");

        jLabel3.setText("Bairro:");

        jLabel4.setText("Cidade:");

        jLabel5.setText("UF:");

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-### ")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCep.addActionListener(this::txtCepActionPerformed);
        txtCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCepKeyReleased(evt);
            }
        });

        txtBairro.addActionListener(this::txtBairroActionPerformed);

        txtCidade.addActionListener(this::txtCidadeActionPerformed);

        btnCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCadastrar.setText("CADASTRAR");
        btnCadastrar.addActionListener(this::btnCadastrarActionPerformed);

        cmbUf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnVoltar.setText("VOLTAR");
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(btnCadastrar)
                                .addGap(24, 24, 24))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRua, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(txtCep))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnVoltar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(cmbUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(btnVoltar))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setInfoForm() {
        
        RegistrationAddress registrationAddress = registrationDto.getRegistrationAddress();
        if (registrationAddress == null) return;
        if (registrationAddress.getCep() != null) txtCep.setText(registrationAddress.getCep());
        if (registrationAddress.getRua() != null) txtRua.setText(registrationAddress.getRua());
        if (registrationAddress.getBairro() != null) txtBairro.setText(registrationAddress.getBairro());
        if (registrationAddress.getCidade() != null) txtCidade.setText(registrationAddress.getCidade());

        if (registrationAddress.getUf() != null && !registrationAddress.getUf().isBlank()) {
            cmbUf.setSelectedItem(registrationAddress.getUf());
        } else {
            cmbUf.setSelectedIndex(0);
        }
    }
    
    private void showLoading(){
        JOptionPane optionPane = new JOptionPane(
        "Buscando CEP...",
        JOptionPane.INFORMATION_MESSAGE,
        JOptionPane.DEFAULT_OPTION,
        null,
        new Object[]{},
        null
        );
        
        loadingDialog = optionPane.createDialog(this, "Aguarde");
        loadingDialog.setModal(false);
        loadingDialog.setVisible(true);
    }
    
    private void hideLoading(){
        if (loadingDialog != null){
            loadingDialog.dispose();
        }
    }

    private void txtCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCepActionPerformed
        
    }//GEN-LAST:event_txtCepActionPerformed

    private void txtBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBairroActionPerformed
       
    }//GEN-LAST:event_txtBairroActionPerformed

    private void txtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeActionPerformed
       
    }//GEN-LAST:event_txtCidadeActionPerformed

    private void txtCepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCepKeyReleased
        String cep = txtCep.getText().replaceAll("\\D", "");
        if (cep.length()==8){
            getCep(cep);
        }    
    }//GEN-LAST:event_txtCepKeyReleased

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        
        RegistrationAddress registrationAddress = registrationDto.getRegistrationAddress();
        if (registrationAddress == null) {
            registrationDto.setRegistrationAddress(new RegistrationAddress());
            registrationAddress = registrationDto.getRegistrationAddress();
        }
        
        String cep = txtCep.getText();
        String rua = txtRua.getText();
        String bairro = txtBairro.getText();
        String cidade = txtCidade.getText();
        String uf = cmbUf.getSelectedItem().toString();

        String cepNumeros = cep.replaceAll("\\D", ""); 

        if (cepNumeros.length() != 8) {
            JOptionPane.showMessageDialog(this, "CEP inválido. Digite 8 números.");
            txtCep.requestFocus();
            return;
        }

        if (rua.trim().isEmpty() || bairro.trim().isEmpty() || cidade.trim().isEmpty() || uf.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Busque um CEP válido antes de cadastrar.");
            txtCep.requestFocus();
            return;
        }

        if (cmbUf.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Selecione um UF válido.");
            cmbUf.requestFocus();
            return;
        }
        registrationAddress.setCep(txtCep.getText());
        registrationAddress.setRua(txtRua.getText());
        registrationAddress.setBairro(txtBairro.getText());
        registrationAddress.setCidade(txtCidade.getText());
        registrationAddress.setUf(cmbUf.getSelectedItem().toString());
        
        try {
            PersonDao dao = new PersonDao();

            Integer id = registrationDto.getRegistrationData().getId();

            if (id != null && id > 0) {
                dao.update(registrationDto);
                JOptionPane.showMessageDialog(this, "Editado com sucesso!");
            } else {
                dao.save(registrationDto);
                JOptionPane.showMessageDialog(this, "Salvo com sucesso!");
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + erro.getMessage());
            erro.printStackTrace();
            return;
        }

        FinalTela telaFinal = new FinalTela(registrationDto, parentList);
        telaFinal.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        RegistrationAddress registrationAddress = registrationDto.getRegistrationAddress();
    
        registrationAddress.setCep(txtCep.getText());
        registrationAddress.setRua(txtRua.getText());
        registrationAddress.setBairro(txtBairro.getText());
        registrationAddress.setCidade(txtCidade.getText());
        registrationAddress.setUf(cmbUf.getSelectedItem().toString());

        Cadastro cadastro = new Cadastro(registrationDto, parentList);
        cadastro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void getCep(String cep) {
        txtRua.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        cmbUf.setSelectedIndex(0);
        
        showLoading();

        new SwingWorker<String, Void>() {
            @Override
            protected String doInBackground() {
                try {
                    HttpClient client = HttpClient.newBuilder()
                        .connectTimeout(Duration.ofSeconds(3))
                        .build();

                    HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json/"))
                        .timeout(Duration.ofSeconds(5))
                        .GET()
                        .build();

                    return client.send(request, HttpResponse.BodyHandlers.ofString()).body();

                } catch (UnknownHostException | ConnectException | SocketTimeoutException e) {
                    return null;
                } catch (Exception registrationAddress) {
                return "ERRO";
                }
            }

            @Override
            protected void done() {
                hideLoading();
                try {
                    String json = get();
                    if (json.isEmpty()){
                        JOptionPane.showMessageDialog(Endereco.this,
                                "Aguarde, buscando o CEP");
                    }

                    if (json == null) {
                        JOptionPane.showMessageDialog(Endereco.this,
                            "Sem internet. Verifique sua conexão e tente novamente.");
                        return;
                    }

                    if ("ERRO".equals(json)) {
                        JOptionPane.showMessageDialog(Endereco.this,
                            "Erro ao buscar CEP.");
                        return;
                    }

                    if (json.contains("\"erro\": true")) {
                        JOptionPane.showMessageDialog(Endereco.this, "CEP não encontrado");
                        return;
                    }

                    txtRua.setText(getValue(json, "logradouro"));
                    txtBairro.setText(getValue(json, "bairro"));
                    txtCidade.setText(getValue(json, "localidade"));
                    cmbUf.setSelectedItem(getValue(json, "uf"));

                } catch (Exception registrationAddress) {
                JOptionPane.showMessageDialog(Endereco.this, "Erro ao buscar CEP.");
                }
            }
        }.execute();
    }

    private String getValue(String json, String chave) {
        String busca = "\"" + chave + "\":";
        int i = json.indexOf(busca);
        if (i == -1) return "";

        int inicio = json.indexOf("\"", i + busca.length()) + 1;
        int fim = json.indexOf("\"", inicio);
        if (inicio < 0 || fim < 0) return "";

        return json.substring(inicio, fim);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cmbUf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtRua;
    // End of variables declaration//GEN-END:variables
}
