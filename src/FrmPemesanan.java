/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */

//import library2nya
import Koneksi.KoneksiDB;
import java.sql.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//kelas utama aja keleru aja kelalen

public class FrmPemesanan extends javax.swing.JFrame {
    
    //membuat objek    
    private DefaultTableModel model;
    
    //deklarasi variabel
     String kdpesan, kdpegawai, kdpelanggan, kdproduk, produk, xtotal;
    int harga,jumlah;
    double sisa,total, dp, sTotal;
    
    /**
     * Creates new form FrmPemesanan
     */
    public FrmPemesanan() {
        initComponents();
        
        //membuat obyek
        model = new DefaultTableModel();
        
        //memberi nama header pada tabel
        tblProduk1.setModel(model);
        model.addColumn("KODE PEMESAN");
        model.addColumn("KODE PEGAWAI");
        model.addColumn("KODE PELANGGAN");
        model.addColumn("KODE PRODUK");
        model.addColumn("PRODUK");
        model.addColumn("HARGA");
        model.addColumn("JUMLAH");
        model.addColumn("SUBTOTAL");
    }
    
    //fungsi untuk memasukan barang yang sudah dipilih pada tabel sementara
    public void masukTabel(){
        try{
            String kdpesan=txtpesan.getText();
            String kdpegawai=txtpegawai.getText();
            String kdpelanggan=txtpelanggan.getText();
            String kdproduk=txtNmProduk.getText();
            String produk=txtprodukk.getText();
            double harga=Double.parseDouble(txtharga.getText());
            int jumlah=Integer.parseInt(txtjumlah.getText());
            sTotal = harga*jumlah;
            total = total + sTotal;
            xtotal=Double.toString(total);
            txttotal.setText(xtotal);
            model.addRow(new Object[]{kdpesan, kdpegawai, kdpelanggan, kdproduk, produk, harga,jumlah,sTotal});
        }
        catch(Exception e){
            System.out.println("Error : "+e);
        }
    }

    
    public void dataSelect(){
        //deklarasi variabel
        int i = tblProduk1.getSelectedRow();
        
        //uji adakah data di tabel?
        if(i == -1){
            //tidak ada yang terpilih atau dipilih.
            return;
        }
        txtpesan.setText(""+model.getValueAt(i,0));
        txtpegawai.setText(""+model.getValueAt(i,1));
        txtpelanggan.setText(""+model.getValueAt(i,2));
        txtNmProduk.setText(""+model.getValueAt(i,3));
        txtprodukk.setText(""+model.getValueAt(i,4));
        txtharga.setText(""+model.getValueAt(i,5));
        txtjumlah.setText(""+model.getValueAt(i,6));
        txttotal.setText(""+model.getValueAt(i,7));
        txtdp.setText(""+model.getValueAt(i,8));
    }
    public void reset(){
        kdpesan= "";
        kdpegawai= "";
        kdpelanggan = "";
        kdproduk= "";
        produk= "";
        harga = 0;
        jumlah = 0;
        total = 0;
        dp = 0;
        
        txtpesan.setText(kdpesan);
        txtpegawai.setText(kdpegawai);
        txtpelanggan.setText(kdpelanggan);
        txtNmProduk.setText(kdproduk);
        txtprodukk.setText(produk);
        txtharga.setText("");
        txtjumlah.setText("");
        txttotal.setText("");
        txtdp.setText("");
    }
  
    //fungsi untuk menampilkan data pada textbox
    public void dataProduk(){   
        try{
            //tes koneksi
            Statement stat = (Statement) KoneksiDB.getKoneksi().createStatement();
           
            //perintah sql untuk membaca data dari tabel produk
            String sql = "SELECT * FROM tabel_produk WHERE kode_produk = '"+ txtNmProduk.getText() +"'";
            ResultSet res = stat.executeQuery(sql);
                        
            //baca data dan tampilkan pada text produk dan harga
            while(res.next()){
                //membuat obyek berjenis array
               txtprodukk.setText(res.getString("produk"));
               txtharga.setText(res.getString("harga"));
            }
        }catch(SQLException err){
           JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
   
    public void simpanDataTransaksi(){ 
        //proses perhitungan uang kembalian
        dp = Double.parseDouble(txtdp.getText());
        sisa = total - dp;
        String xsisa=Double.toString(sisa);
        txtkurang.setText(xsisa);
       
        //uji koneksi dan eksekusi perintah
        try{
            //test koneksi
            Statement stat = (Statement) KoneksiDB.getKoneksi().createStatement();
            
            //perintah sql untuk simpan data
            String  sql =   "INSERT INTO tabel_pemesanan(kode_pemesanan, kode_pegawai, kode_pelanggan, kode_produk, produk, harga, jumlah, total, dp, sisa)"
                            + "VALUES('"+ txtpesan.getText() +"','"+ txtpegawai.getText() +"','"+ txtpelanggan.getText() +"','"+ txtNmProduk.getText() +"','"+ txtprodukk.getText() +"', '"+ txtharga.getText() +"', '"+ txtjumlah.getText() +"','"+ txttotal.getText() +"','"+ txtdp.getText() +"','"+ sisa +"')";
            PreparedStatement p = (PreparedStatement) KoneksiDB.getKoneksi().prepareStatement(sql);
            p.executeUpdate();
            
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
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

        txtkategori = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        txtHrg = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduk = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtproduk = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        cmdKeluar = new javax.swing.JButton();
        cmdSimpan = new javax.swing.JButton();
        cmdReset = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProduk1 = new javax.swing.JTable();
        txtjumlah = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txttotal = new javax.swing.JLabel();
        txtNmProduk = new javax.swing.JTextField();
        txtkurang = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtprodukk = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtdp = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtpegawai = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtpesan = new javax.swing.JTextField();
        txtpelanggan = new javax.swing.JTextField();

        txtkategori.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtkategoriKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel1.setText("MASTER DATA PRODUK");

        jLabel2.setText("KODE PRODUK");

        tblProduk.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduk);

        jLabel3.setText("KODE KATEGORI");

        jLabel4.setText("NAMA PRODUK");

        jLabel5.setText("HARGA");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        cmdKeluar.setText("KELUAR");
        cmdKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdKeluarMouseClicked(evt);
            }
        });
        cmdKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKeluarActionPerformed(evt);
            }
        });

        cmdSimpan.setText("SIMPAN");
        cmdSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSimpanActionPerformed(evt);
            }
        });

        cmdReset.setText("RESET");
        cmdReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdResetActionPerformed(evt);
            }
        });

        jButton1.setText("HITUNG");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblProduk1.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProduk1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProduk1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProduk1);

        jLabel19.setText("HARGA");

        txttotal.setText("Total Harga");

        txtNmProduk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNmProdukKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNmProdukKeyReleased(evt);
            }
        });

        txtkurang.setText("Sisa Bayar");

        jLabel8.setText("KODE PRODUK");

        jLabel20.setText("SISA PEMBAYARAN");

        txtprodukk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprodukkActionPerformed(evt);
            }
        });

        jLabel9.setText("PRODUK");

        jLabel16.setText("DP");

        jLabel17.setText("TOTAL");

        jLabel18.setText("JUMLAH CETAK");

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel6.setText("MASTER DATA PEMESANAN");

        jLabel10.setText("KODE PELANGGAN");

        jLabel7.setText("KODE PEMESANAN");

        jLabel11.setText("KODE PEGAWAI");

        txtpesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpesanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(30, 30, 30))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(14, 14, 14)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtpesan, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                    .addComponent(txtpelanggan)
                                    .addComponent(txtpegawai))
                                .addGap(21, 21, 21))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(cmdReset, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmdKeluar))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cmdSimpan)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNmProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(txtprodukk, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtdp, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtkurang, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(71, 71, 71)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(185, 185, 185))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtpesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtNmProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtpegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtprodukk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtpelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(cmdSimpan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdReset)
                    .addComponent(cmdKeluar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtkurang, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtkategoriKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkategoriKeyReleased
        //memanggil fungsi data produk
        dataProduk();
    }//GEN-LAST:event_txtkategoriKeyReleased

    private void tblProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdukMouseClicked
        // TODO add your handling code here:
        dataSelect();
    }//GEN-LAST:event_tblProdukMouseClicked

    private void cmdKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdKeluarMouseClicked
        this.dispose();
         new FrmUtama().setVisible(true);
    }//GEN-LAST:event_cmdKeluarMouseClicked

    private void tblProduk1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProduk1MouseClicked
        // TODO add your handling code here:
        dataSelect();
    }//GEN-LAST:event_tblProduk1MouseClicked

    private void cmdSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSimpanActionPerformed
        simpanDataTransaksi();
    }//GEN-LAST:event_cmdSimpanActionPerformed

    private void cmdResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdResetActionPerformed
        reset();
    }//GEN-LAST:event_cmdResetActionPerformed

    private void txtpesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpesanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpesanActionPerformed

    private void txtNmProdukKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNmProdukKeyPressed
        // TODO add your handling code here:
          dataProduk();
    }//GEN-LAST:event_txtNmProdukKeyPressed

    private void txtNmProdukKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNmProdukKeyReleased
        // TODO add your handling code here:
        dataProduk();
    }//GEN-LAST:event_txtNmProdukKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        masukTabel();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtprodukkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprodukkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprodukkActionPerformed

    private void cmdKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKeluarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdKeluarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPemesanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdKeluar;
    private javax.swing.JButton cmdReset;
    private javax.swing.JButton cmdSimpan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblProduk;
    private javax.swing.JTable tblProduk1;
    private javax.swing.JTextField txtHrg;
    private javax.swing.JTextField txtNmProduk;
    private javax.swing.JTextField txtdp;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txtkategori;
    private javax.swing.JLabel txtkurang;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtpegawai;
    private javax.swing.JTextField txtpelanggan;
    private javax.swing.JTextField txtpesan;
    private javax.swing.JTextField txtproduk;
    private javax.swing.JTextField txtprodukk;
    private javax.swing.JLabel txttotal;
    // End of variables declaration//GEN-END:variables
}
