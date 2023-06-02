JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Load the image file
                Image backgroundImage = new ImageIcon("C/Users/Pc/Pictures/wms.jpeg").getImage();

                // Draw the image onto the panel
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };