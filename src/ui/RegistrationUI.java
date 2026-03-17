package ui;

import dao.AddressDao;
import dao.PersonDao;
import entity.Address;
import entity.Person;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class RegistrationUI extends JFrame {
  
    private DefaultTableModel model;
    private final PersonDao personDao = new PersonDao();
    private final AddressDao addressDao = new AddressDao();
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RegistrationUI.class.getName());

    public RegistrationUI() {
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
    
    public void updateTable() {
    model.setRowCount(0);

    try {
        List<Person> pessoas = personDao.findAll();

        for (Person person : pessoas) {
            Address address = null;

            if (person.getAddress().getId() != null) {
                address = addressDao.findById(person.getAddress().getId());
            }

            model.addRow(new Object[] {
                person.getId(),
                person.getName(),
                person.getBirth(),
                person.getCpf(),
                (address != null ? address.getRua() : ""),
                (address != null ? address.getBairro() : ""),
                (address != null ? address.getCidade() : ""),
                (address != null ? address.getUf() : ""),
                (address != null ? address.getCep() : ""),
                "Editar",
                "Excluir"
            });
        }

        updateEmptyMessage();

    } catch (Exception erro) {
        JOptionPane.showMessageDialog(this, "Erro ao carregar: " + erro.getMessage());
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane9)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(403, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblText)
                        .addGap(399, 399, 399))))
            .addGroup(layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(lblText1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnNovo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(lblText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblText1)
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onEdit(int row) {
        int modelRow = tblCadastro.convertRowIndexToModel(row);
        int id = Integer.parseInt(model.getValueAt(modelRow, 0).toString());

        try {
            Person person = personDao.findById(id);

            if (person != null && person.getAddress() != null && person.getAddress().getId() != null) {
                Address address = addressDao.findById(person.getAddress().getId());
                person.setAddress(address);
            }

            CadastroUI cadastro = new CadastroUI(person, this);
            cadastro.setVisible(true);
            this.setVisible(false);

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, "Erro ao editar: " + erro.getMessage());
            erro.printStackTrace();
        }
    }

    private void onDelete(int row) {
        int resposta = JOptionPane.showConfirmDialog(
            this,
            "Tem certeza que deseja excluir este cadastro?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        ); 
        if (resposta != JOptionPane.YES_OPTION) {
            return; 
        }
        try {
            int modelRow = tblCadastro.convertRowIndexToModel(row);
            int id = Integer.parseInt(model.getValueAt(modelRow, 0).toString());

            personDao.deleteById(id);

            updateTable();
            updateEmptyMessage();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir: " + erro.getMessage());
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
        CadastroUI cadastro = new CadastroUI();
        cadastro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNovoActionPerformed
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new RegistrationUI().setVisible(true));
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
