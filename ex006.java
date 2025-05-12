package ex006;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class ex006 extends JFrame {
    private JComboBox<String> diagonalMainEffect;
    private JComboBox<String> diagonalSecondaryEffect;
    private JButton generateButton;
    private JLabel previewLabel;

    public ex006() {
        setTitle("Efeitos de Cor nas Diagonais");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3, 2, 10, 10));

        controlPanel.add(new JLabel("Efeito na Diagonal Principal:"));
        diagonalMainEffect = new JComboBox<>(new String[]{"Gradiente Vermelho", "Gradiente Verde", "Gradiente Azul", "Mistura"});
        controlPanel.add(diagonalMainEffect);

        controlPanel.add(new JLabel("Efeito na Diagonal Secundária:"));
        diagonalSecondaryEffect = new JComboBox<>(new String[]{"Gradiente Vermelho", "Gradiente Verde", "Gradiente Azul", "Mistura"});
        controlPanel.add(diagonalSecondaryEffect);

        generateButton = new JButton("Gerar Imagem");
        controlPanel.add(generateButton);

        add(controlPanel, BorderLayout.NORTH);

        previewLabel = new JLabel("Pré-visualização será exibida aqui", SwingConstants.CENTER);
        previewLabel.setPreferredSize(new Dimension(400, 400));
        add(previewLabel, BorderLayout.CENTER);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateImage();
            }
        });
    }

    private void generateImage() {
        int width = 800;
        int height = 800;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        String mainEffect = (String) diagonalMainEffect.getSelectedItem();
        String secondaryEffect = (String) diagonalSecondaryEffect.getSelectedItem();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int color;

                if (x == y) {
                    color = applyEffect(mainEffect, x, y, width, height);
                } else if (x + y == width - 1) {
                    color = applyEffect(secondaryEffect, x, y, width, height);
                } else {
                    color = 0;
                }

                image.setRGB(x, y, color);
            }
        }
        Image scaledImage = image.getScaledInstance(previewLabel.getWidth(), previewLabel.getHeight(), Image.SCALE_SMOOTH);
        previewLabel.setIcon(new ImageIcon(scaledImage));
        try {
            File outputFile = new File("diagonal_color_effect.png");
            ImageIO.write(image, "png", outputFile);
            JOptionPane.showMessageDialog(this, "Imagem gerada e salva como: " + outputFile.getAbsolutePath());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar a imagem: " + ex.getMessage());
        }
    }

    private int applyEffect(String effect, int x, int y, int width, int height) {
        int red = 0, green = 0, blue = 0;
        switch (effect) {
            case "Gradiente Vermelho":
                red = (x * 255) / width;
                break;
            case "Gradiente Verde":
                green = (y * 255) / height;
                break;
            case "Gradiente Azul":
                blue = (x * 255) / width;
                break;
            case "Mistura":
                red = (x * 255) / width;
                green = (y * 255) / height;
                blue = ((x + y) * 255) / (width + height);
                break;
        }
        return (red << 16) | (green << 8) | blue;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ex006 gui = new ex006();
            gui.setVisible(true);
        });
    }
}
