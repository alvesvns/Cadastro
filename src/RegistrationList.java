import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class RegistrationList extends javax.swing.JFrame {
    // private static final List<RegistrationDto> registrations = new ArrayList<>();
    private DefaultTableModel model;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RegistrationList.class.getName());

    public RegistrationList() {
        initComponents();
        model = (DefaultTableModel) tblCadastro.getModel(); 
        updateTable();
        updateEmptyMessage();
        
        int colEdit = tblCadastro.getColumnCount() - 2;
        int colDelete = tblCadastro.getColumnCount() - 1;
        
        tblCadastro.getColumnModel().getColumn(colEdit).setCellRenderer(new ButtonRenderer());
        tblCadastro.getColumnModel().getColumn(colEdit).setCellEditor(new ButtonEditor());
        
        tblCadastro.getColumnModel().getColumn(colDelete).setCellRenderer(new ButtonRenderer());
        tblCadastro.getColumnModel().getColumn(colDelete).setCellEditor(new ButtonEditor());
        
        tblCadastro.getColumnModel().getColumn(colEdit).setPreferredWidth(70);
        tblCadastro.getColumnModel().getColumn(colDelete).setPreferredWidth(70);
    }
    
    public void addRegistrations(RegistrationDto registrationDto) {
    }
    
    public void updateTable(){
        model.setRowCount(0);
        
        try {
            PersonDao personDao = new PersonDao();
            List<RegistrationDto> list = personDao.findAll();
        
            for (RegistrationDto registrationDto : list) {
                RegistrationData registrationData = registrationDto.getRegistrationData();
                RegistrationAddress registrationAddress = registrationDto.getRegistrationAddress();
            
                model.addRow(new Object[]{
                    registrationData.getId(),
                    registrationData.getName(),
                    registrationData.getBirth(),
                    registrationData.getCpf(),
                    registrationAddress.getRua(),
                    registrationAddress.getBairro(),
                    registrationAddress.getCidade(),
                    registrationAddress.getUf(),
                    registrationAddress.getCep(),
                    "Editar",
                    "Excluir"
                });
            }
        
            updateEmptyMessage();
        
        } catch (Exception erro) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao carregar: " + erro.getMessage());
            erro.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNovo = new javax.swing.JButton();
        lblText = new javax.swing.JLabel();
        lblText1 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblCadastro = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnNovo.setText("NOVO CADASTRO");
        btnNovo.addActionListener(this::btnNovoActionPerformed);

        lblText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblText.setText("NENHUM CADASTRO ENCONTRADO");
        lblText.setToolTipText("");

        lblText1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblText1.setText("CLIQUE EM \"NOVO CADASTRO\" PARA COMEÇAR");

        tblCadastro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Matricula", "Nome", "Nascimento", "CPF", "Rua", "Bairro", "Cidade", "UF", "CEP", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(tblCadastro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblText)
                        .addGap(413, 413, 413))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 1085, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(382, 382, 382)
                .addComponent(lblText1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnNovo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblText1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onEdit(int row) {
        int modelRow = tblCadastro.convertRowIndexToModel(row);

        int id = Integer.parseInt(model.getValueAt(modelRow, 0).toString());

        try {
            PersonDao personDao = new PersonDao();
            RegistrationDto registrationDto = personDao.findById(id);

            Cadastro cadastro = new Cadastro(registrationDto, this);
            cadastro.setVisible(true);
            this.setVisible(false);

        } catch (Exception erro) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao editar: " + erro.getMessage());
            erro.printStackTrace();
        }
    }

    private void onDelete(int row) {
        try {
            int modelRow = tblCadastro.convertRowIndexToModel(row);

            Object idObj = model.getValueAt(modelRow, 0);
            int id = Integer.parseInt(idObj.toString());

            PersonDao personDao = new PersonDao();
            personDao.deleteById(id);

            updateTable();
            updateEmptyMessage();
        } catch (Exception erro) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao excluir: " + erro.getMessage());
            erro.printStackTrace();
        }
    }
    
    private void updateEmptyMessage(){
        boolean vazio = (model.getRowCount() == 0);
        lblText.setVisible(vazio);
        lblText1.setVisible(vazio);
        tblCadastro.setVisible(!vazio);
    }
    
    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        Cadastro cadastro = new Cadastro();
        cadastro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNovoActionPerformed
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new RegistrationList().setVisible(true));
    }
    class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() { setOpaque(true); }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value == null ? "" : value.toString());
        return this;
    }
}

    class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
        private final JButton button = new JButton();
        private int row;
        private String text;

    public ButtonEditor() { button.addActionListener(this); }

        @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
            this.row = row;
            this.text = value == null ? "" : value.toString();
            button.setText(text);
            return button;
            }

    @Override
    public Object getCellEditorValue() { return text; }

    @Override
    public void actionPerformed(ActionEvent e) {
        fireEditingStopped();

        if ("Editar".equals(text)) onEdit(row);
        if ("Excluir".equals(text)) onDelete(row);
    }
}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovo;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblText;
    private javax.swing.JLabel lblText1;
    private javax.swing.JTable tblCadastro;
    // End of variables declaration//GEN-END:variables
}
