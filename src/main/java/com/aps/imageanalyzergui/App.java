package com.aps.imageanalyzergui;

import com.aps.utils.image.ImageAnalyzer;
import com.aps.utils.image.ImageResizer;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFileChooser;
import java.io.File;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

public class App extends javax.swing.JFrame {

    public App() {
        this.initComponents();
        this.setupDataLayer();
    }

    private void setupDataLayer() {
        this.setupImageHandler();
    }

    private boolean isValidImage(String filename) {
        return filename.contains(".png") || filename.contains(".jpeg") || filename.contains(".jpg");
    }

    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private void setupImageHandler() {
        this.dataLayer.imageFile.subscribeToAfterChange((imageFile) -> {
            String filename = imageFile.getName();

            if (!isValidImage(filename)) {
                this.showErrorDialog("O arquivo escolhido não é suportado.");
                return;
            }

            this.imageTextField.setText(imageFile.getAbsolutePath());
            this.setLabelImage(this.originalImageLabelIcon, imageFile);
        });
    }

    private void setLabelImage(javax.swing.JLabel label, File imageFile) {
        ImageIcon imageIcon = new ImageIcon(imageFile.getAbsolutePath());
        Image rawImage = imageIcon.getImage();
        this.setLabelImage(label, rawImage);

    }

    private void setLabelImage(javax.swing.JLabel label, Image image) {
        Dimension scaledImageDimension = ImageResizer.getScaledDimension(
                new Dimension(image.getWidth(this), image.getHeight(this)), new Dimension(320, 260));
        Image scaledImage = image.getScaledInstance(scaledImageDimension.width, scaledImageDimension.height,
                Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(scaledImage));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        imageTextField = new javax.swing.JTextField();
        loadImageButton = new javax.swing.JButton();
        originalImageLabelIcon = new javax.swing.JLabel();
        processedImageLabelIcon = new javax.swing.JLabel();
        analyzeButton = new javax.swing.JButton();
        originalImageLabel = new javax.swing.JLabel();
        processesImageLabel = new javax.swing.JLabel();
        runtimeLabel = new javax.swing.JLabel();
        greenAreaPercentageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        titleLabel.setText("Análise de imagem");

        imageTextField.setEditable(false);
        imageTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        imageTextField.setToolTipText("Selecione uma imagem");
        imageTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                handleLoadImageClick(evt);
            }
        });

        loadImageButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loadImageButton.setText("Carregar uma imagem");
        loadImageButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                handleLoadImageClick(evt);
            }
        });
        loadImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadImageButtonActionPerformed(evt);
            }
        });

        originalImageLabelIcon.setMaximumSize(new java.awt.Dimension(320, 320));

        analyzeButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        analyzeButton.setText("Processar");
        analyzeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                handleAnalyzeButtonClick(evt);
            }
        });

        originalImageLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        originalImageLabel.setText("Original");

        processesImageLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        processesImageLabel.setText("Processada");

        runtimeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        runtimeLabel.setText("Tempo de execução: Não medido");

        greenAreaPercentageLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        greenAreaPercentageLabel.setText("Porcentagem de área verde: Não medido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(greenAreaPercentageLabel).addComponent(runtimeLabel)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(imageTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        479, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(loadImageButton))
                                        .addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup().addGap(119, 119, 119)
                                                        .addComponent(titleLabel).addGap(119, 119, 119))
                                                .addGroup(layout.createSequentialGroup().addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(originalImageLabel)
                                                        .addComponent(originalImageLabelIcon,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 320,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(processesImageLabel)
                                                                .addComponent(processedImageLabelIcon,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 320,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(analyzeButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(69, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(42, 42, 42).addComponent(titleLabel).addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(imageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(loadImageButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(analyzeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(originalImageLabel).addComponent(processesImageLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(originalImageLabelIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 260,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(processedImageLabelIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 260,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18).addComponent(runtimeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(greenAreaPercentageLabel).addGap(300, 300, 300)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void handleAnalyzeButtonClick(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_handleAnalyzeButtonClick
        File imageFile = this.dataLayer.imageFile.getState();

        if (imageFile == null) {
            return;
        }

        try {
            BufferedImage sourceImage = ImageAnalyzer.readImageFile(imageFile.getAbsolutePath());
            Color baseColor = ImageAnalyzer.getBaseColor(sourceImage);

            ImageAnalyzer imageAnalyzer = new ImageAnalyzer(20, baseColor, new Color(255, 0, 0));

            long start = System.nanoTime();
            double percentageOfBaseColor = imageAnalyzer.getPercentageOfBaseColor(sourceImage);
            BufferedImage analyzedImage = imageAnalyzer.highlightBaseColor(sourceImage);
            long end = System.nanoTime();

            double runtimeCost = (double) (end - start) / 1e6;

            this.runtimeLabel.setText(String.format("Tempo de execução: %.2fms", runtimeCost));
            this.greenAreaPercentageLabel
                    .setText(String.format("Porcentagem de área verde: %.2f%%", percentageOfBaseColor));
            this.setLabelImage(this.processedImageLabelIcon, analyzedImage);
        } catch (IOException e) {
            System.out.println("Erro!");
            System.out.println(e.toString());
        }
    }// GEN-LAST:event_handleAnalyzeButtonClick

    private void handleLoadImageClick(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_handleLoadImageClick
        JFileChooser fileChooser = new JFileChooser("user.home");

        int option = fileChooser.showDialog(this, null);

        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            this.dataLayer.imageFile.setState(file);
        }
    }// GEN-LAST:event_handleLoadImageClick

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new App().setVisible(true));
    }

    private final DataLayer dataLayer = new DataLayer();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton analyzeButton;
    private javax.swing.JLabel greenAreaPercentageLabel;
    private javax.swing.JTextField imageTextField;
    private javax.swing.JButton loadImageButton;
    private javax.swing.JLabel originalImageLabel;
    private javax.swing.JLabel originalImageLabelIcon;
    private javax.swing.JLabel processedImageLabelIcon;
    private javax.swing.JLabel processesImageLabel;
    private javax.swing.JLabel runtimeLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
