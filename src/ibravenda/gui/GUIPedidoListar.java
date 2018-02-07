/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibravenda.gui;

import ibravenda.cliente.Cliente;
import ibravenda.fachada.Fachada;
import ibravenda.pedido.Pedido;
import ibravenda.pedidoProduto.PedidoProduto;
import ibravenda.vendedor.Vendedor;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrew
 */
public class GUIPedidoListar extends javax.swing.JInternalFrame {

    ArrayList<Vendedor> vendedores;
    ArrayList<Cliente> clientes;
    ArrayList<PedidoProduto> pedido_produto = new ArrayList<>();
    ArrayList<Pedido> listaPedidos;

    /**
     * Creates new form GUIPedidoProduto
     */
    public GUIPedidoListar() {
        initComponents();
        popularComboCliente();
        popularComboVendedor();
        limparTabelas();
    }

    private void limparTabelas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Número", "Cliente", "Vendedor", "Data", "Total"});
        jTablePedidos.setModel(modelo);
        DefaultTableModel modelo2 = new DefaultTableModel();
        modelo2.setColumnIdentifiers(new Object[]{"Descrição", "Preço", "Quantidade", "Total"});
        jTableProdutosPedido.setModel(modelo2);
    }

    private void popularComboVendedor() {
        try {
            Vendedor filtro = new Vendedor();
            Fachada f = new Fachada();
            vendedores = f.listar(filtro);

            DefaultComboBoxModel modelo = new DefaultComboBoxModel();

            if (vendedores.size() > 0) {
                for (int i = 0; i < vendedores.size(); i++) {
                    Vendedor v = vendedores.get(i);
                    modelo.addElement(v.getNome());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum vendedor cadastrado.");
            }

            jComboBoxVendedor.setModel(modelo);
            jComboBoxVendedor.setSelectedIndex(-1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void popularComboCliente() {
        try {
            Cliente filtro = new Cliente();
            Fachada f = new Fachada();
            clientes = f.listar(filtro);

            DefaultComboBoxModel modelo = new DefaultComboBoxModel();

            if (clientes.size() > 0) {
                for (int i = 0; i < clientes.size(); i++) {
                    Cliente c = clientes.get(i);
                    modelo.addElement(c.getNome());
                }
                //jLabelClienteInfo.setText("CPF: " + clientes.get(0).getCpf());
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado.");
            }

            jComboBoxCliente.setModel(modelo);
            jComboBoxCliente.setSelectedIndex(-1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void carregarTabelaItens() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Descrição", "Preço", "Quantidade", "Total"});

        if (jTablePedidos.getSelectedRow() >= 0) {

            Pedido p = this.listaPedidos.get(jTablePedidos.getSelectedRow());
            for (PedidoProduto pp : p.getProdutos()) {
                float subtotal = pp.getPreco() * pp.getQuantidade();

                modelo.addRow(new Object[]{
                    pp.getProduto().getDescricao(),
                    pp.getPreco(),
                    pp.getQuantidade(),
                    String.format("%.2f", subtotal)
                });
            }

            jTableProdutosPedido.setModel(modelo);
            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
            rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
            jTableProdutosPedido.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
            jTableProdutosPedido.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
            jTableProdutosPedido.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFiltro = new javax.swing.JPanel();
        jLabelNumero = new javax.swing.JLabel();
        jTextFieldNumero = new javax.swing.JTextField();
        jButtonBuscarNumero = new javax.swing.JButton();
        jLabelVendedor = new javax.swing.JLabel();
        jLabelCliente = new javax.swing.JLabel();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        jComboBoxVendedor = new javax.swing.JComboBox<>();
        jButtonVendedorLimpar = new javax.swing.JButton();
        jButtonClienteLimpar = new javax.swing.JButton();
        jPanelPedidos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePedidos = new javax.swing.JTable();
        jPanelItensDoPedido = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProdutosPedido = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros "));
        setClosable(true);

        jPanelFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros: "));

        jLabelNumero.setText("Número:");

        jButtonBuscarNumero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ibravenda/imagens/magnifier.png"))); // NOI18N
        jButtonBuscarNumero.setText("Buscar pedido");
        jButtonBuscarNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarNumeroActionPerformed(evt);
            }
        });

        jLabelVendedor.setText("Vendedor:");

        jLabelCliente.setText("Cliente:");

        jComboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        jComboBoxVendedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        jButtonVendedorLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ibravenda/imagens/page_white.png"))); // NOI18N
        jButtonVendedorLimpar.setText("Limpar");
        jButtonVendedorLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVendedorLimparActionPerformed(evt);
            }
        });

        jButtonClienteLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ibravenda/imagens/page_white.png"))); // NOI18N
        jButtonClienteLimpar.setText("Limpar");
        jButtonClienteLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClienteLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFiltroLayout = new javax.swing.GroupLayout(jPanelFiltro);
        jPanelFiltro.setLayout(jPanelFiltroLayout);
        jPanelFiltroLayout.setHorizontalGroup(
            jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelFiltroLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonBuscarNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelFiltroLayout.createSequentialGroup()
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelVendedor)
                            .addComponent(jLabelCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxCliente, 0, 304, Short.MAX_VALUE)
                            .addComponent(jComboBoxVendedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelFiltroLayout.createSequentialGroup()
                        .addComponent(jLabelNumero)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonVendedorLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonClienteLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelFiltroLayout.setVerticalGroup(
            jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumero))
                .addGap(18, 18, 18)
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelVendedor)
                    .addComponent(jButtonVendedorLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCliente)
                    .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonClienteLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jButtonBuscarNumero)
                .addContainerGap())
        );

        jPanelPedidos.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedidos: "));

        jTablePedidos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablePedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePedidosMouseClicked(evt);
            }
        });
        jTablePedidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTablePedidosKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePedidos);

        javax.swing.GroupLayout jPanelPedidosLayout = new javax.swing.GroupLayout(jPanelPedidos);
        jPanelPedidos.setLayout(jPanelPedidosLayout);
        jPanelPedidosLayout.setHorizontalGroup(
            jPanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelPedidosLayout.setVerticalGroup(
            jPanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelItensDoPedido.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens: "));

        jTableProdutosPedido.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableProdutosPedido);

        javax.swing.GroupLayout jPanelItensDoPedidoLayout = new javax.swing.GroupLayout(jPanelItensDoPedido);
        jPanelItensDoPedido.setLayout(jPanelItensDoPedidoLayout);
        jPanelItensDoPedidoLayout.setHorizontalGroup(
            jPanelItensDoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelItensDoPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelItensDoPedidoLayout.setVerticalGroup(
            jPanelItensDoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelItensDoPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelItensDoPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelItensDoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarNumeroActionPerformed
        // TODO add your handling code here:
        try {
            Pedido p = new Pedido();

            if (jTextFieldNumero.getText().trim().equals("") == false) {
                p.setNumero(Integer.parseInt(jTextFieldNumero.getText()));
            }

            if (jComboBoxCliente.getSelectedIndex() >= 0) {
                Cliente c = clientes.get(jComboBoxCliente.getSelectedIndex());
                p.setCliente(c);
            }
            if (jComboBoxVendedor.getSelectedIndex() >= 0) {
                Vendedor v = vendedores.get(jComboBoxVendedor.getSelectedIndex());
                p.setVendedor(v);
            }

            this.listaPedidos = new Fachada().listar(p);
            this.limparTabelas();
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.setColumnIdentifiers(new Object[]{"Número", "Cliente", "Vendedor", "Data", "Total"});

            if (listaPedidos.size() > 0) {
                for (Pedido pp : listaPedidos) {
                    modelo.addRow(new Object[]{
                        pp.getNumero(),
                        pp.getCliente().getNome(),
                        pp.getVendedor().getNome(),
                        pp.getData(),
                        String.format("%.2f", pp.getTotalPedido())
                    });
                }

                jTablePedidos.setModel(modelo);
                DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
                rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
                jTablePedidos.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
            } else {
                JOptionPane.showMessageDialog(null, "Pedido não encontrado!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonBuscarNumeroActionPerformed

    private void jButtonVendedorLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVendedorLimparActionPerformed
        // TODO add your handling code here:
        jComboBoxVendedor.setSelectedIndex(-1);
    }//GEN-LAST:event_jButtonVendedorLimparActionPerformed

    private void jButtonClienteLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClienteLimparActionPerformed
        // TODO add your handling code here:
        jComboBoxCliente.setSelectedIndex(-1);
    }//GEN-LAST:event_jButtonClienteLimparActionPerformed

    private void jTablePedidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTablePedidosKeyReleased
        // TODO add your handling code here:
        carregarTabelaItens();

    }//GEN-LAST:event_jTablePedidosKeyReleased

    private void jTablePedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePedidosMouseClicked
        // TODO add your handling code here:
        carregarTabelaItens();
    }//GEN-LAST:event_jTablePedidosMouseClicked

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarNumero;
    private javax.swing.JButton jButtonClienteLimpar;
    private javax.swing.JButton jButtonVendedorLimpar;
    private javax.swing.JComboBox<String> jComboBoxCliente;
    private javax.swing.JComboBox<String> jComboBoxVendedor;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelVendedor;
    private javax.swing.JPanel jPanelFiltro;
    private javax.swing.JPanel jPanelItensDoPedido;
    private javax.swing.JPanel jPanelPedidos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePedidos;
    private javax.swing.JTable jTableProdutosPedido;
    private javax.swing.JTextField jTextFieldNumero;
    // End of variables declaration//GEN-END:variables
}