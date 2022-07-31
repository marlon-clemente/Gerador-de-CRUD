package telas;

import gerador.Dados;
import gerador.GeradorConexao;
import gerador.GeradorDAO;
import gerador.GeradorModel;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import manipularquivos.DadosDAO;

public class Atributos extends javax.swing.JFrame {
    
    String nomeClasse;
    String localClasse;
    String tipoClasse;
    String nomeTabela;
    DadosDAO dadosDAO = new DadosDAO();
    GeradorModel ger = new GeradorModel();
    GeradorDAO dao = new GeradorDAO();
    GeradorConexao con = new GeradorConexao();
    public Atributos() {
        initComponents();
        
        DefaultTableModel modelo = (DefaultTableModel) tableAtributos.getModel();
        tableAtributos.setRowSorter(new TableRowSorter(modelo));
        tabela();
    }
    
    void tabela(){
        DefaultTableModel modelo = (DefaultTableModel) tableAtributos.getModel();
        modelo.setNumRows(0);
        List<Dados> lstDados;
        lstDados = dadosDAO.listarDados();
        for(Dados a : lstDados ){
            modelo.addRow(new Object[]{
                a.getTipo(),
                a.getNome()
            });
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Destino = new javax.swing.JPanel();
        txtLocal = new javax.swing.JLabel();
        pastaBtt = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tipoAtributo = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        boxName = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAtributos = new javax.swing.JTable();
        excluirBtt = new javax.swing.JToggleButton();
        SalvarBtt = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        nameClasseBox = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        radioPrivate = new javax.swing.JRadioButton();
        radioPublic = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        boxTabela = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Destino.setBorder(javax.swing.BorderFactory.createTitledBorder("Localização"));
        Destino.setToolTipText("Gerador de Crud");

        txtLocal.setText("Destino: ...\\");

            pastaBtt.setText("Salvar em...");
            pastaBtt.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    pastaBttActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout DestinoLayout = new javax.swing.GroupLayout(Destino);
            Destino.setLayout(DestinoLayout);
            DestinoLayout.setHorizontalGroup(
                DestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DestinoLayout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(txtLocal)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pastaBtt)
                    .addGap(18, 18, 18))
            );
            DestinoLayout.setVerticalGroup(
                DestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DestinoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(DestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtLocal, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addComponent(pastaBtt))
                    .addContainerGap())
            );

            jButton1.setText("Cancelar");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Adicionar atributos"));

            tipoAtributo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "int", "float", "String", "boolean", " " }));

            jButton2.setText("Adicionar");
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tipoAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(boxName)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton2)
                    .addContainerGap())
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tipoAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)
                        .addComponent(boxName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Atributos"));

            tableAtributos.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Tipo", "Nome"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            jScrollPane1.setViewportView(tableAtributos);
            if (tableAtributos.getColumnModel().getColumnCount() > 0) {
                tableAtributos.getColumnModel().getColumn(0).setPreferredWidth(50);
                tableAtributos.getColumnModel().getColumn(1).setPreferredWidth(50);
            }

            excluirBtt.setText("Excluir Atributo");
            excluirBtt.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    excluirBttActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(excluirBtt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(excluirBtt)
                    .addGap(7, 7, 7))
            );

            SalvarBtt.setText("Salvar");
            SalvarBtt.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    SalvarBttActionPerformed(evt);
                }
            });

            jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Criar Classe"));

            jLabel1.setText("Nome da Classe:");

            radioPrivate.setText("Private");

            radioPublic.setSelected(true);
            radioPublic.setText("Public");

            javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(radioPublic)
                            .addGap(78, 78, 78)
                            .addComponent(radioPrivate))
                        .addComponent(nameClasseBox, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
            );
            jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radioPrivate)
                        .addComponent(radioPublic))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nameClasseBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Banco de Dados"));

            jLabel2.setText("Nome da tabela");

            javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
            jPanel4.setLayout(jPanel4Layout);
            jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addGap(18, 18, 18)
                    .addComponent(boxTabela)
                    .addContainerGap())
            );
            jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(boxTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(SalvarBtt, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Destino, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(21, 21, 21)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(SalvarBtt))
                    .addContainerGap())
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents
public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Atributos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Atributos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Atributos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Atributos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Atributos().setVisible(true);
            }
        });
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tipoAtributo.getSelectedItem().equals("int")){
            String tipo = "int";
            String nome = boxName.getText();
            Dados dados = new Dados(tipo, nome);
            dadosDAO.salvarDados(dados);
        }
        if (tipoAtributo.getSelectedItem().equals("float")){
            String tipo = "float";
            String nome = boxName.getText();
            Dados dados = new Dados(tipo, nome);
            dadosDAO.salvarDados(dados);
        }
        if (tipoAtributo.getSelectedItem().equals("String")){
            String tipo = "String";
            String nome = boxName.getText();
            Dados dados = new Dados(tipo, nome);
            dadosDAO.salvarDados(dados);
        }
        if (tipoAtributo.getSelectedItem().equals("Boolean")){
            String tipo = "boolean";
            String nome = boxName.getText();
            Dados dados = new Dados(tipo, nome);
            dadosDAO.salvarDados(dados);
        }
        tabela();
        boxName.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void excluirBttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirBttActionPerformed
        int linha = this.tableAtributos.getSelectedRow();
        String tipo = (String) this.tableAtributos.getValueAt(linha, 0);
        String nome = (String) this.tableAtributos.getValueAt(linha, 1);
        dadosDAO.removerDado(tipo, nome);
        tabela();
    }//GEN-LAST:event_excluirBttActionPerformed

    private void SalvarBttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarBttActionPerformed
        nomeClasse = nameClasseBox.getText();
        nomeTabela = boxTabela.getText();
        String tipo;
        if (radioPrivate.isSelected()){
            tipoClasse = "private";
        } else if(radioPublic.isSelected()){
            tipoClasse = "public";
        }
        ger.criarClasseModel(nomeClasse, tipoClasse, localClasse);
        dao.criaClassDAO(nomeClasse, localClasse, nomeTabela);
        con.criaClassDAO(nomeClasse, localClasse, nomeTabela);
    }//GEN-LAST:event_SalvarBttActionPerformed

    private void pastaBttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pastaBttActionPerformed
        JFileChooser chooserDiretorio = new JFileChooser();
        chooserDiretorio.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooserDiretorio.showOpenDialog(getParent());
        String url = chooserDiretorio.getSelectedFile().getAbsolutePath();
        System.out.println(url);
        txtLocal.setText("Destino: " + url);
        localClasse = url;
    }//GEN-LAST:event_pastaBttActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Destino;
    private javax.swing.JToggleButton SalvarBtt;
    private javax.swing.JTextField boxName;
    private javax.swing.JTextField boxTabela;
    private javax.swing.JToggleButton excluirBtt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameClasseBox;
    private javax.swing.JButton pastaBtt;
    private javax.swing.JRadioButton radioPrivate;
    private javax.swing.JRadioButton radioPublic;
    private javax.swing.JTable tableAtributos;
    private javax.swing.JComboBox<String> tipoAtributo;
    private javax.swing.JLabel txtLocal;
    // End of variables declaration//GEN-END:variables
}
