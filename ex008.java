import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ex008 extends JFrame {
    private JPanel imagePanel;
    private JButton loadButton;
    private ExecutorService executor;

    public ex008() {
        setTitle("Processador de Imagens em Escala de Cinza");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(0, 2, 10, 10)); 
        JScrollPane scrollPane = new JScrollPane(imagePanel);

        loadButton = new JButton("Carregar Imagem");
        loadButton.addActionListener(e -> loadImages());

        add(scrollPane, BorderLayout.CENTER);
        add(loadButton, BorderLayout.SOUTH);

        executor = Executors.newFixedThreadPool(4); 
    }

    private void loadImages() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true); 
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File[] files = fileChooser.getSelectedFiles();

            for (File file : files) {
                executor.submit(() -> processImage(file));
            }
        }
    }

    private void processImage(File file) {
        try {
            BufferedImage originalImage = ImageIO.read(file);
            BufferedImage grayscaleImage = convertToGrayscale(originalImage);

            SwingUtilities.invokeLater(() -> {
                addImageToPanel(originalImage, grayscaleImage);
            });
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar a imagem: " + file.getName());
        }
    }

    private BufferedImage convertToGrayscale(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage grayscale = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);

        Graphics g = grayscale.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();

        return grayscale;
    }

    private void addImageToPanel(BufferedImage original, BufferedImage grayscale) {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JLabel(new ImageIcon(original.getScaledInstance(300, 300, Image.SCALE_SMOOTH))));
        panel.add(new JLabel(new ImageIcon(grayscale.getScaledInstance(300, 300, Image.SCALE_SMOOTH))));

        imagePanel.add(panel);
        imagePanel.revalidate();
        imagePanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ex008 processor = new ex008();
            processor.setVisible(true);
        });
    }
}
