package ex007;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.io.File;
import java.io.IOException;

public class ex007 extends JFrame {
    private JSlider redSlider, greenSlider, blueSlider;
    private JLabel previewLabel;
    private JButton saveButton;

    public ex007() {
        setTitle("Gerador de Imagens RGB");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel para os sliders
        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout(4, 2, 10, 10));

        // Sliders de vermelho, verde e azul
        redSlider = createColorSlider("Vermelho");
        greenSlider = createColorSlider("Verde");
        blueSlider = createColorSlider("Azul");

        // Botão para salvar a imagem
        saveButton = new JButton("Salvar Imagem");
        sliderPanel.add(saveButton);

        add(sliderPanel, BorderLayout.NORTH);

        // Pré-visualização
        previewLabel = new JLabel("Pré-visualização será exibida aqui", SwingConstants.CENTER);
        previewLabel.setPreferredSize(new Dimension(500, 500));
        add(previewLabel, BorderLayout.CENTER);

        // Atualizar a imagem ao mover os sliders
        ChangeListener updateImageListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateImagePreview();
            }
        };
        redSlider.addChangeListener(updateImageListener);
        greenSlider.addChangeListener(updateImageListener);
        blueSlider.addChangeListener(updateImageListener);

        // Ação do botão de salvar
        saveButton.addActionListener(e -> saveImage());

        // Atualiza a imagem inicial
        SwingUtilities.invokeLater(() -> updateImagePreview());
    }

    private JSlider createColorSlider(String label) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel sliderLabel = new JLabel(label + " (%)");
        JSlider slider = new JSlider(0, 100, 50); // Valores de 0 a 100
        slider.setMajorTickSpacing(25);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        panel.add(sliderLabel, BorderLayout.NORTH);
        panel.add(slider, BorderLayout.CENTER);

        return slider;
    }

    private void updateImagePreview() {
        int width = 400;
        int height = 400;

        // Obtemos os valores RGB dos sliders
        int redPercent = redSlider.getValue();
        int greenPercent = greenSlider.getValue();
        int bluePercent = blueSlider.getValue();

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Aplicamos os valores de cor
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int red = (x * 255 * redPercent) / (width * 100);
                int green = (y * 255 * greenPercent) / (height * 100);
                int blue = ((x + y) * 255 * bluePercent) / ((width + height) * 100);

                int color = (red << 16) | (green << 8) | blue;
                image.setRGB(x, y, color);
            }
        }

        // Verifique se o JLabel foi dimensionado
        int previewWidth = previewLabel.getWidth();
        int previewHeight = previewLabel.getHeight();

        // Se a largura ou altura do JLabel for zero, use valores padrão
        if (previewWidth <= 0 || previewHeight <= 0) {
            previewWidth = 400; // Largura padrão
            previewHeight = 400; // Altura padrão
        }

        // Redimensionar a imagem para caber no JLabel
        Image scaledImage = image.getScaledInstance(previewWidth, previewHeight, Image.SCALE_SMOOTH);
        previewLabel.setIcon(new ImageIcon(scaledImage));
    }

    private void saveImage() {
        int width = 800;
        int height = 800;

        // Obtemos os valores RGB dos sliders
        int redPercent = redSlider.getValue();
        int greenPercent = greenSlider.getValue();
        int bluePercent = blueSlider.getValue();

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Aplicamos os valores de cor
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int red = (x * 255 * redPercent) / (width * 100);
                int green = (y * 255 * greenPercent) / (height * 100);
                int blue = ((x + y) * 255 * bluePercent) / ((width + height) * 100);

                int color = (red << 16) | (green << 8) | blue;
                image.setRGB(x, y, color);
            }
        }

        // Salvamos a imagem no arquivo
        try {
            File outputFile = new File("rgb_image.png");
            ImageIO.write(image, "png", outputFile);
            JOptionPane.showMessageDialog(this, "Imagem salva como: " + outputFile.getAbsolutePath());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar a imagem: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ex007 gui = new ex007();
            gui.setVisible(true);
        });
    }
}
