/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibravenda.gui;

import ibravenda.fachada.Fachada;
import ibravenda.pedido.Pedido;
import ibravenda.pedidoProduto.PedidoProduto;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrew
 */
public class GUIPedidoProduto extends javax.swing.JInternalFrame {

    /**
     * Creates new form GUIPedidoProduto
     */
    public GUIPedidoProduto() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPedido = new javax.swing.JPanel();
        jTextFieldNumero = new javax.swing.JTextField();
        jLabelVendedor = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jLabelTotalInfo = new javax.swing.JLabel();
        jLabelVendedorInfo = new javax.swing.JLabel();
        jLabelCliente = new javax.swing.JLabel();
        jLabelClienteInfo = new javax.swing.JLabel();
        jButtonBuscarNumero = new javax.swing.JButton();
        jLabelNumero = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jLabelDataInfo = new javax.swing.JLabel();
        jPanelItens = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProduto = new javax.swing.JTable();

        setClosable(true);

        jPanelPedido.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedido: "));

        jLabelVendedor.setText("Vendedor:");

        jLabelTotal.setText("Total:");

        jLabelCliente.setText("Cliente:");

        jButtonBuscarNumero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ibravenda/imagens/magnifier.png"))); // NOI18N
        jButtonBuscarNumero.setText("Buscar pedido");
        jButtonBuscarNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarNumeroActionPerformed(evt);
            }
        });

        jLabelNumero.setText("Número:");

        jLabelData.setText("Data:");

        javax.swing.GroupLayout jPanelPedidoLayout = new javax.swing.GroupLayout(jPanelPedido);
        jPanelPedido.setLayout(jPanelPedidoLayout);
        jPanelPedidoLayout.setHorizontalGroup(
            jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTotal)
                    .addComponent(jLabelVendedor)
                    .addComponent(jLabelNumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPedidoLayout.createSequentialGroup()
                        .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBuscarNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelPedidoLayout.createSequentialGroup()
                        .addGroup(jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelTotalInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelVendedorInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelData, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelCliente, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPedidoLayout.createSequentialGroup()
                                .addComponent(jLabelClienteInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabelDataInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanelPedidoLayout.setVerticalGroup(
            jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPedidoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNumero)
                    .addComponent(jButtonBuscarNumero)
                    .addComponent(jLabelNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelVendedorInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelClienteInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelData)
                    .addComponent(jLabelDataInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTotalInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(jLabelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );

        jPanelItens.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens: "));

        jTableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Descrição", "Preço", "Quantidade", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTableProduto);

        javax.swing.GroupLayout jPanelItensLayout = new javax.swing.GroupLayout(jPanelItens);
        jPanelItens.setLayout(jPanelItensLayout);
        jPanelItensLayout.setHorizontalGroup(
            jPanelItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelItensLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelItensLayout.setVerticalGroup(
            jPanelItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelItensLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelItens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addComponent(jPanelPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelItens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarNumeroActionPerformed
        // TODO add your handling code here:
        try {
            double total = 0.00;
            Pedido p = new Pedido();
            
            if(jTextFieldNumero.getText().trim().equals("")) {
                throw new Exception("Digite um número válido.");
            }
            
            p.setNumero(Integer.parseInt(jTextFieldNumero.getText()));
            ArrayList<Pedido> lista = new Fachada().listar(p);
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.setColumnIdentifiers(new Object[]{"Descrição", "Preço", "Quantidade", "Total"});

            if (lista.size() > 0) {

                p = lista.get(0);
                jLabelVendedorInfo.setText(p.getVendedor().getNome() + " - " + p.getVendedor().getCpf());
                jLabelClienteInfo.setText(p.getCliente().getNome() + " - " + p.getCliente().getCpf());

                for (PedidoProduto pp : p.getProdutos()) {
                    float subtotal = pp.getPreco() * pp.getQuantidade();
                    total += subtotal;
                    modelo.addRow(new Object[]{
                        pp.getProduto().getDescricao(),
                        pp.getPreco(),
                        pp.getQuantidade(),
                        subtotal
                    });
                }

                jTableProduto.setModel(modelo);
                DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
                rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
                jTableProduto.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
                jTableProduto.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
                jTableProduto.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);

                jLabelTotalInfo.setText(String.format("%.2f", total));
                jLabelDataInfo.setText(p.getData());
            } else {
                JOptionPane.showMessageDialog(null, "Pedido não encontrado!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonBuscarNumeroActionPerformed

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarNumero;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JLabel jLabelClienteInfo;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelDataInfo;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelTotalInfo;
    private javax.swing.JLabel jLabelVendedor;
    private javax.swing.JLabel jLabelVendedorInfo;
    private javax.swing.JPanel jPanelItens;
    private javax.swing.JPanel jPanelPedido;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProduto;
    private javax.swing.JTextField jTextFieldNumero;
    // End of variables declaration//GEN-END:variables
}
