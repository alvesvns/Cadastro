package ui;

import service.PersonService;
import entity.Address;
import entity.Person;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.EventQueue;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.swing.SwingWorker;
import java.net.URI;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.net.SocketTimeoutException;
import java.time.Duration;
import javax.swing.JDialog;

public class CadastroUI extends JFrame {

    private Person person;
    private Address address;
    private RegistrationUI parentList;
    private JDialog loadingDialog;

    public CadastroUI() {
        initComponents();

        this.parentList = null;
        this.person = new Person();
        this.address = new Address();

        this.person.setAddress(this.address);

        setListUf();
        setInfoForm();  
    }

    public CadastroUI(Person person, RegistrationUI parentList) {
        initComponents();

        this.parentList = parentList;
        this.person = (person != null) ? person : new Person();

        if (this.person.getAddress() != null) {
            this.address = this.person.getAddress();
        } else {
            this.address = new Address();
            this.person.setAddress(this.address);
        }
        setListUf();
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
        btnCadastrar = new javax.swing.JButton();
        spnBirth = new javax.swing.JSpinner();
        canvas1 = new java.awt.Canvas();
        txtCpf = new javax.swing.JFormattedTextField();
        btnVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCep = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbUf = new javax.swing.JComboBox<>();

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

        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameFocusLost(evt);
            }
        });
        txtName.addActionListener(this::txtNameActionPerformed);

        btnCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCadastrar.setText("CADASTRAR");
        btnCadastrar.addActionListener(this::btnCadastrarActionPerformed);

        spnBirth.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1769604803492L), new java.util.Date(-2208942032000L), new java.util.Date(1769604803492L), java.util.Calendar.DAY_OF_MONTH));
        spnBirth.setEditor(new javax.swing.JSpinner.DateEditor(spnBirth, "dd/MM/yyyy"));
        spnBirth.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                spnBirthFocusLost(evt);
            }
        });

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-## ")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCpfFocusLost(evt);
            }
        });
        txtCpf.addActionListener(this::txtCpfActionPerformed);

        btnVoltar.setText("VOLTAR");
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);

        jLabel1.setText("CEP:");

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-### ")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCepFocusLost(evt);
            }
        });
        txtCep.addActionListener(this::txtCepActionPerformed);
        txtCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCepKeyReleased(evt);
            }
        });

        jLabel2.setText("Rua:");

        txtRua.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRuaFocusLost(evt);
            }
        });

        jLabel3.setText("Bairro:");

        txtBairro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBairroFocusLost(evt);
            }
        });
        txtBairro.addActionListener(this::txtBairroActionPerformed);

        jLabel4.setText("Cidade:");

        txtCidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCidadeFocusLost(evt);
            }
        });
        txtCidade.addActionListener(this::txtCidadeActionPerformed);

        jLabel5.setText("UF:");

        cmbUf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVoltar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(36, 36, 36)
                        .addComponent(cmbUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNasc)
                                    .addComponent(jLabelCpf))
                                .addGap(16, 16, 16))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spnBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtBairro, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtRua, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCep, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCpf, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnCadastrar)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(btnCadastrar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNome)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNasc)
                            .addComponent(spnBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCpf)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnVoltar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    
    private void setInfoForm() {
        
        if (person == null) return;

        if (person.getName() != null) txtName.setText(person.getName());
        if (person.getCpf() != null) txtCpf.setText(person.getCpf()); 
        if (person.getBirth() != null) {
        spnBirth.setValue(java.sql.Date.valueOf(person.getBirth())); 
        }
        if (address == null) return;

        if (address.getCep() != null) txtCep.setText(address.getCep());
        if (address.getRua() != null) txtRua.setText(address.getRua());
        if (address.getBairro() != null) txtBairro.setText(address.getBairro());
        if (address.getCidade() != null) txtCidade.setText(address.getCidade());

        if (address.getUf() != null && !address.getUf().isBlank()) {
            cmbUf.setSelectedItem(address.getUf());
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
    
    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        
    }//GEN-LAST:event_txtNameActionPerformed
    
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed

        if (person == null) person = new Person();
        if (address == null) address = new Address();

        String name = txtName.getText();
        String cpf = txtCpf.getText();
        String uf = cmbUf.getSelectedItem().toString();

        Date dateBirth = (Date) spnBirth.getValue();
        LocalDate birth = dateBirth.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formattedBirth = sdf.format(dateBirth);

        person.setName(name);
        person.setCpf(cpf);
        person.setBirth(birth);
        person.setFormattedBirth(formattedBirth);

        address.setCep(txtCep.getText());
        address.setRua(txtRua.getText());
        address.setBairro(txtBairro.getText());
        address.setCidade(txtCidade.getText());
        address.setUf(uf);

        person.setAddress(address);

        List<String> erros = new ArrayList<>();
        erros.addAll(person.validate());
        erros.addAll(address.validate());

        if (!erros.isEmpty()) {
            String msg = String.join("\n", erros);
            JOptionPane.showMessageDialog(this, "Dados inválidos:\n\n" + msg);
            return;
        }

        boolean isInsert = person.isInsert();

        try {
            PersonService personService = new PersonService();

            if (isInsert) {
                if (personService.existsByCpf(cpf)) {
                    JOptionPane.showMessageDialog(this, "CPF já cadastrado!");
                    return;
                }
            } else {
                if (personService.existsByCpfAndNotId(cpf, person.getId())) {
                    JOptionPane.showMessageDialog(this, "CPF já cadastrado em outro cadastro!");
                    return;
                }

                if (person.getAddress() != null && person.getAddress().getId() != null) {
                    address.setId(person.getAddress().getId());
                }
            }

            personService.save(person);

            if (isInsert) {
                JOptionPane.showMessageDialog(this, "Salvo com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Editado com sucesso!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + e.getMessage());
            return;
        }

        if (parentList != null) {
            parentList.updateTable();
            parentList.setVisible(true);
        } else {
            new RegistrationUI().setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_btnCadastrarActionPerformed

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
                        JOptionPane.showMessageDialog(CadastroUI.this,
                                "Aguarde, buscando o CEP");
                    }

                    if (json == null) {
                        JOptionPane.showMessageDialog(CadastroUI.this,
                            "Sem internet. Verifique sua conexão e tente novamente.");
                        return;
                    }

                    if ("ERRO".equals(json)) {
                        JOptionPane.showMessageDialog(CadastroUI.this,
                            "Erro ao buscar CEP.");
                        return;
                    }

                    if (json.contains("\"erro\": true")) {
                        JOptionPane.showMessageDialog(CadastroUI.this, "CEP não encontrado");
                        return;
                    }

                    txtRua.setText(getValue(json, "logradouro"));
                    txtBairro.setText(getValue(json, "bairro"));
                    txtCidade.setText(getValue(json, "localidade"));
                    cmbUf.setSelectedItem(getValue(json, "uf"));

                } catch (Exception registrationAddress) {
                JOptionPane.showMessageDialog(CadastroUI.this, "Erro ao buscar CEP.");
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
    
    private void txtCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCepActionPerformed

    }//GEN-LAST:event_txtCepActionPerformed

    private void txtCepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCepKeyReleased
        String cep = txtCep.getText().replaceAll("\\D", "");
        if (cep.length()==8){
            getCep(cep);
        }
    }//GEN-LAST:event_txtCepKeyReleased

    private void txtBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBairroActionPerformed

    }//GEN-LAST:event_txtBairroActionPerformed

    private void txtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeActionPerformed

    }//GEN-LAST:event_txtCidadeActionPerformed

    private void txtCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCpfFocusLost
        person.setCpf(txtCpf.getText());

        List<String> erros = person.validateCpf();

        if (!erros.isEmpty()) {
            JOptionPane.showMessageDialog(this, erros.get(0));
            txtCpf.requestFocus();
        }
    }//GEN-LAST:event_txtCpfFocusLost

    private void txtCepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCepFocusLost
        address.setCep(txtCep.getText());

        List<String> erros = address.validateCep();

        if (erros.contains("- CEP deve conter 8 números.")) {
            JOptionPane.showMessageDialog(this, "CEP inválido.");
            txtCep.requestFocus();
        }
    }//GEN-LAST:event_txtCepFocusLost

    private void spnBirthFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_spnBirthFocusLost
        
    }//GEN-LAST:event_spnBirthFocusLost

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        person.setName(txtName.getText());

        List<String> erros = person.validateName();

        if (!erros.isEmpty()) {
            JOptionPane.showMessageDialog(this, erros.get(0));
            txtName.requestFocus();
        }
    }//GEN-LAST:event_txtNameFocusLost

    private void txtRuaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRuaFocusLost
        address.setRua(txtRua.getText());

        List<String> erros = address.validateRua();

        if (!erros.isEmpty()) {
            JOptionPane.showMessageDialog(this, erros.get(0));
            txtRua.requestFocus();
        }
    }//GEN-LAST:event_txtRuaFocusLost

    private void txtBairroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBairroFocusLost
        address.setBairro(txtBairro.getText());

        List<String> erros = address.validateBairro();

        if (!erros.isEmpty()) {
            JOptionPane.showMessageDialog(this, erros.get(0));
            txtBairro.requestFocus();
        }
    }//GEN-LAST:event_txtBairroFocusLost

    private void txtCidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCidadeFocusLost
        address.setCidade(txtCidade.getText());

        List<String> erros = address.validateCidade();

        if (!erros.isEmpty()) {
            JOptionPane.showMessageDialog(this, erros.get(0));
            txtCidade.requestFocus();
        }
    }//GEN-LAST:event_txtCidadeFocusLost
  
    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new CadastroUI().setVisible(true));
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnVoltar;
    private java.awt.Canvas canvas1;
    private javax.swing.JComboBox<String> cmbUf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelNasc;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner spnBirth;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtRua;
    // End of variables declaration//GEN-END:variables
}