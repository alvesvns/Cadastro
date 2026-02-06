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
    private static final List<RegistrationDto> registrations = new ArrayList<>();
    private DefaultTableModel model;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RegistrationList.class.getName());

    public RegistrationList() {
        initComponents();
        model = (DefaultTableModel) tblCadastro.getModel(); 
        updateTable();
        
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
        registrations.add(registrationDto);
        updateTable();
    }
    
    public void updateTable(){
        model.setRowCount(0);
        
        for (RegistrationDto registrationDto : registrations) {
            RegistrationData registrationData = registrationDto.getRegistrationData();
            RegistrationAddress registrationAddress = registrationDto.getRegistrationAddress();
            
            model.addRow(new Object[]{
                registrationData.getName(),
                registrationData.getFormattedBirth(),
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane1 = new java.awt.ScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCadastro = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblCadastro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "Nascimento", "Cpf", "Rua", "Bairro", "Cidade", "UF", "CEP", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCadastro);

        scrollPane1.add(jScrollPane1);

        btnNovo.setText("NOVO CADASTRO");
        btnNovo.addActionListener(this::btnNovoActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(1010, Short.MAX_VALUE)
                .addComponent(btnNovo)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onEdit(int row) {
        int modelRow = tblCadastro.convertRowIndexToModel(row);
        RegistrationDto registrationDto = registrations.get(modelRow);
        
        Cadastro cadastro = new Cadastro(registrationDto, this); 
        cadastro.setVisible(true);
        this.setVisible(false);
}

    private void onDelete(int row) {
        int modelRow = tblCadastro.convertRowIndexToModel(row);
        registrations.remove(modelRow);
        updateTable();
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
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JTable tblCadastro;
    // End of variables declaration//GEN-END:variables
}
