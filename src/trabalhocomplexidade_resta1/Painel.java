/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhocomplexidade_resta1;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Alison Sassi e André
 */
public class Painel extends javax.swing.JFrame {

    // Criar uma matriz 7y7
    public static int TamY = 7;
    public static int TamX = 7;
    public static int[][] tabuleiro = new int[TamY][TamX];

    /**
     * Creates new form Painel
     */
    public Painel() {
        initComponents();
        // Setar valores nessa matriz sendo.. 1 para preenchido e Zero para Vazio e 9 
        for (int y = 0; y < TamY; y++) {
            for (int x = 0; x < TamX; x++) {
                if ((y == 0 || y == 1) && (x == 0 || x == 1)) {
                    tabuleiro[y][x] = 9;
                } else if ((y == 0 || y == 1) && (x == 5 || x == 6)) {
                    tabuleiro[y][x] = 9;
                } else if ((y == 5 || y == 6) && (x == 0 || x == 1)) {
                    tabuleiro[y][x] = 9;
                } else if ((y == 5 || y == 6) && (x == 5 || x == 6)) {
                    tabuleiro[y][x] = 9;
                } else {
                    tabuleiro[y][x] = 1;
                }
            } // End For x
        }// End For y
        //--------------Setar valores--------------------------  

    }// ------------FIM PAINEL -----------

    /**
     * Método para mostrat matriz
     */
    public void MostraMatriz() {

        for (int y = 0; y < TamY; y++) {
            for (int x = 0; x < TamX; x++) {
                System.out.print(tabuleiro[x][y] + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     * @return Retorna a quantidades de Zeros que tem na Matriz
     */
    public static int QuantidadeDeZeros(int[][] Tabuleiro, int TamY, int TamX) {
        int qtd = 0;
        for (int y = 0; y < TamY; y++) {
            for (int x = 0; x < TamX; x++) {
                if (Tabuleiro[y][x] == 0) {
                    qtd++;
                }
            }
        }
        return qtd;
    }

    /**
     *
     * @return Retorna a quantidades de 1 que tem na Matriz
     */
    public static int QuantidadeDePeças(int[][] Tabuleiro, int TamY, int TamX) {
        int qtd = 0;
        for (int y = 0; y < TamY; y++) {
            for (int x = 0; x < TamX; x++) {
                if (Tabuleiro[y][x] == 1) {
                    qtd++;
                }
            }
        }
        return qtd;
    }

    public void Joga_Peca_Manual(int X_Atual, int Y_Atual, int X_Meio, int Y_Meio, int X_Novo, int Y_Novo) {
        System.out.println("Quantidade de peças: " + this.QuantidadeDePeças(tabuleiro, TamY, TamX));
        //System.out.println("O que realmente jogou = Atual="+X_Atual+","+Y_Atual+" o Meio = "+X_Meio+","+Y_Meio+""+ " e o Novo ="+X_Novo+","+Y_Novo);
        tabuleiro[X_Atual][Y_Atual] = 0;
        tabuleiro[X_Meio][Y_Meio] = 0;
        tabuleiro[X_Novo][Y_Novo] = 1;

    }

    /**
     *
     * @return Retorna a quantidades de 1 que tem na Matriz
     */
    public boolean Verifica_se_terminou(int[][] Tabuleiro, int TamY, int TamX) {
       // Esse método está muito lento!!!
        
        /*int qtd_pecas = this.QuantidadeDePeças(Tabuleiro, TamY, TamX);

        for (int y = 0; y < TamY; y++) {
            for (int x = 0; x < TamX; x++) {
                if (qtd_pecas < 10) {
                    if (Tabuleiro[y][x] == 1) {
                        int conta_peca = this.verifica_Possibilidade_Manual(Tabuleiro, x, y);

                        if (conta_peca == 0 && qtd_pecas == 1) {
                            JOptionPane.showMessageDialog(null, "Você ganhou!");
                            return true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Você perdeu!");
                            return true;
                        }
                    }
                }
            }
        }*/
        return false;
    }

    public int verifica_Possibilidade_Manual(int[][] Tabuleiro, int posX, int posY) {
        int cont_pos = 0; // Contar as Possíves jogadas.
        String Str = null;

        int proximo_cima = posY - 1;
        int proximo_baixo = posY + 1;
        int proximo_esquerda = posX - 1;
        int proximo_direita = posX + 1;
        int segundo_proximo_cima = posY - 2;
        int segundo_proximo_baixo = posY + 2;
        int segundo_proximo_esquerda = posX - 2;
        int segundo_proximo_direita = posX + 2;
        int X_Atual = 1000;
        int Y_Atual = 1000;
        int X_Meio = 1000;
        int Y_Meio = 1000;
        int X_Novo = 1000;
        int Y_Novo = 1000;

        try {
            if (tabuleiro[posX][posY] == 1 && tabuleiro[posX][proximo_cima] == 1 && tabuleiro[posX][segundo_proximo_cima] == 0) {
                Str = "Para CIMA";

                X_Atual = posX;
                Y_Atual = posY;
                X_Meio = posX;
                Y_Meio = proximo_cima;
                X_Novo = posX;
                Y_Novo = segundo_proximo_cima;
                cont_pos++;
            }
        } catch (Exception e) {
        }
        try {
            if (tabuleiro[posX][posY] == 1 && tabuleiro[posX][proximo_baixo] == 1 && tabuleiro[posX][segundo_proximo_baixo] == 0) {
                Str = "Para BAIXO";

                X_Atual = posX;
                Y_Atual = posY;
                X_Meio = posX;
                Y_Meio = proximo_baixo;
                X_Novo = posX;
                Y_Novo = segundo_proximo_baixo;

                cont_pos++;
            }
        } catch (Exception e) {
        }
        try {
            if (tabuleiro[posX][posY] == 1 && tabuleiro[proximo_esquerda][posY] == 1 && tabuleiro[segundo_proximo_esquerda][posY] == 0) {
                Str = "Para ESQUERDA";
                // Esquerda é posX - 1;
                X_Atual = posX;
                Y_Atual = posY;
                X_Meio = proximo_esquerda;
                Y_Meio = posY;
                X_Novo = segundo_proximo_esquerda;
                Y_Novo = posY;

                cont_pos++;
            }
        } catch (Exception e) {
        }
        try {
            if (tabuleiro[posX][posY] == 1 && tabuleiro[proximo_direita][posY] == 1 && tabuleiro[segundo_proximo_direita][posY] == 0) {
                Str = "Para DIREITA";

                X_Atual = posX;
                Y_Atual = posY;
                X_Meio = proximo_direita;
                Y_Meio = posY;
                X_Novo = segundo_proximo_direita;
                Y_Novo = posY;
                cont_pos++;
            }
        } catch (Exception e) {
        }
        if (cont_pos == 1) {
            System.out.println("Jogou" + Str + " ! Atual= " + X_Atual + "," + Y_Atual + " Meio= " + X_Meio + "," + Y_Meio + " Novo= " + X_Novo + "," + Y_Novo);
            this.Joga_Peca_Manual(X_Atual, Y_Atual, X_Meio, Y_Meio, X_Novo, Y_Novo);

        }
        if (cont_pos > 1) {
            JOptionPane.showConfirmDialog(jMenu2, "Selecione qual peça é para jogar! AO CLICAR SIM IRÁ PARA O ULTIMO IF");

            this.Joga_Peca_Manual(X_Atual, Y_Atual, X_Meio, Y_Meio, X_Novo, Y_Novo);
        } else {
            System.out.println("Contador de peças: " + cont_pos);
            System.out.println(Str);
        }
        this.MostraMatriz();
        this.AtualizaMatriz();
        this.Verifica_se_terminou(tabuleiro, TamY, TamX);
        return cont_pos;
    }

    /**
     * 
     * @param tab_atual
     * @param jog_passadas
     * @return 
     * Método para identificar as possíbilidades e realizar as jogadas automaticamente.
     * 
     */


    public boolean verifica_Possibilidade_Automatica(int[][] tab_atual, ArrayList<Jogada> jog_passadas) {
        
        
        
        return true;
    }
    public void AtualizaMatriz() {

        // 2X0 ------------------
        if (tabuleiro[2][0] == 1) {
            jB2x0.setBackground(Color.BLUE);

        } else {
            jB2x0.setBackground(Color.WHITE);
        }
        //3X0 ----------------------
        if (tabuleiro[3][0] == 1) {
            jB3x0.setBackground(Color.BLUE);
        } else {
            jB3x0.setBackground(Color.WHITE);
        }
        //4X0
        if (tabuleiro[4][0] == 1) {
            jB4x0.setBackground(Color.BLUE);
        } else {
            jB4x0.setBackground(Color.WHITE);
        }

        //2X1
        if (tabuleiro[2][1] == 1) {
            jB2x1.setBackground(Color.BLUE);
        } else {
            jB2x1.setBackground(Color.WHITE);
        }
        //3X1
        if (tabuleiro[3][1] == 1) {
            jB3x1.setBackground(Color.BLUE);
        } else {
            jB3x1.setBackground(Color.WHITE);
        }
        // 4X1
        if (tabuleiro[4][1] == 1) {
            jB4x1.setBackground(Color.BLUE);
        } else {
            jB4x1.setBackground(Color.WHITE);
        }
        //0X2
        if (tabuleiro[0][2] == 1) {
            jB0x2.setBackground(Color.BLUE);
        } else {
            jB0x2.setBackground(Color.WHITE);
        }
        //1X2
        if (tabuleiro[1][2] == 1) {
            jB1x2.setBackground(Color.BLUE);
        } else {
            jB1x2.setBackground(Color.WHITE);
        }

        //2X2
        if (tabuleiro[2][2] == 1) {
            jB2x2.setBackground(Color.BLUE);
        } else {
            jB2x2.setBackground(Color.WHITE);
        }
        //3X2
        if (tabuleiro[3][2] == 1) {
            jB3x2.setBackground(Color.BLUE);
        } else {
            jB3x2.setBackground(Color.WHITE);
        }
        // 4X2
        if (tabuleiro[4][2] == 1) {
            jB4x2.setBackground(Color.BLUE);
        } else {
            jB4x2.setBackground(Color.WHITE);
        }
        //5X2
        if (tabuleiro[5][2] == 1) {
            jB5x2.setBackground(Color.BLUE);
        } else {
            jB5x2.setBackground(Color.WHITE);
        }
        //6X2
        if (tabuleiro[6][2] == 1) {
            jB6x2.setBackground(Color.BLUE);
        } else {
            jB6x2.setBackground(Color.WHITE);
        }

        //0X3
        if (tabuleiro[0][3] == 1) {
            jB0x3.setBackground(Color.BLUE);
        } else {
            jB0x3.setBackground(Color.WHITE);
        }
        //1X3
        if (tabuleiro[1][3] == 1) {
            jB1x3.setBackground(Color.BLUE);
        } else {
            jB1x3.setBackground(Color.WHITE);
        }
        // 2X3
        if (tabuleiro[2][3] == 1) {
            jB2x3.setBackground(Color.BLUE);
        } else {
            jB2x3.setBackground(Color.WHITE);
        }
        //3X3
        if (tabuleiro[3][3] == 1) {
            jB3x3.setBackground(Color.BLUE);
        } else {
            jB3x3.setBackground(Color.WHITE);
        }
        //4X3
        if (tabuleiro[4][3] == 1) {
            jB4x3.setBackground(Color.BLUE);
        } else {
            jB4x3.setBackground(Color.WHITE);
        }

        //5X3
        if (tabuleiro[5][3] == 1) {
            jB5x3.setBackground(Color.BLUE);
        } else {
            jB5x3.setBackground(Color.WHITE);
        }
        //6X3
        if (tabuleiro[6][3] == 1) {
            jB6x3.setBackground(Color.BLUE);
        } else {
            jB6x3.setBackground(Color.WHITE);
        }
        // 0X4
        if (tabuleiro[0][4] == 1) {
            jB0x4.setBackground(Color.BLUE);
        } else {
            jB0x4.setBackground(Color.WHITE);
        }
        //1X4
        if (tabuleiro[1][4] == 1) {
            jB1x4.setBackground(Color.BLUE);
        } else {
            jB1x4.setBackground(Color.WHITE);
        }
        //2X4
        if (tabuleiro[2][4] == 1) {
            jB2x4.setBackground(Color.BLUE);
        } else {
            jB2x4.setBackground(Color.WHITE);
        }

        //3X4
        if (tabuleiro[3][4] == 1) {
            jB3x4.setBackground(Color.BLUE);
        } else {
            jB3x4.setBackground(Color.WHITE);
        }
        //4X4
        if (tabuleiro[4][4] == 1) {
            jB4x4.setBackground(Color.BLUE);
        } else {
            jB4x4.setBackground(Color.WHITE);
        }
        // 5X4
        if (tabuleiro[5][4] == 1) {
            jB5x4.setBackground(Color.BLUE);
        } else {
            jB5x4.setBackground(Color.WHITE);
        }
        //6X4
        if (tabuleiro[6][4] == 1) {
            jB6x4.setBackground(Color.BLUE);
        } else {
            jB6x4.setBackground(Color.WHITE);
        }
        //2X5
        if (tabuleiro[2][5] == 1) {
            jB2x5.setBackground(Color.BLUE);
        } else {
            jB2x5.setBackground(Color.WHITE);
        }

        //3X5
        if (tabuleiro[3][5] == 1) {
            jB3x5.setBackground(Color.BLUE);
        } else {
            jB3x5.setBackground(Color.WHITE);
        }
        //4X5
        if (tabuleiro[4][5] == 1) {
            jB4x5.setBackground(Color.BLUE);
        } else {
            jB4x5.setBackground(Color.WHITE);
        }
        // 2X6
        if (tabuleiro[2][6] == 1) {
            jB2x6.setBackground(Color.BLUE);
        } else {
            jB2x6.setBackground(Color.WHITE);
        }
        //3X6
        if (tabuleiro[3][6] == 1) {
            jB3x6.setBackground(Color.BLUE);
        } else {
            jB3x6.setBackground(Color.WHITE);
        }
        //4X6
        if (tabuleiro[4][6] == 1) {
            jB4x6.setBackground(Color.BLUE);
        } else {
            jB4x6.setBackground(Color.WHITE);
        }
    } // FIM MOSTRA MATRIZ

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pain_Esq = new javax.swing.JPanel();
        jB1x2 = new javax.swing.JButton();
        jB0x2 = new javax.swing.JButton();
        jB1x3 = new javax.swing.JButton();
        jB1x4 = new javax.swing.JButton();
        jB0x3 = new javax.swing.JButton();
        jB0x4 = new javax.swing.JButton();
        Pain_Direito = new javax.swing.JPanel();
        jB6x2 = new javax.swing.JButton();
        jB5x2 = new javax.swing.JButton();
        jB6x3 = new javax.swing.JButton();
        jB6x4 = new javax.swing.JButton();
        jB5x3 = new javax.swing.JButton();
        jB5x4 = new javax.swing.JButton();
        Pain_Cima = new javax.swing.JPanel();
        jB2x0 = new javax.swing.JButton();
        jB3x0 = new javax.swing.JButton();
        jB3x1 = new javax.swing.JButton();
        jB4x0 = new javax.swing.JButton();
        jB4x1 = new javax.swing.JButton();
        jB2x1 = new javax.swing.JButton();
        Pain_Centro = new javax.swing.JPanel();
        jB4x2 = new javax.swing.JButton();
        jB3x2 = new javax.swing.JButton();
        jB2x2 = new javax.swing.JButton();
        jB4x3 = new javax.swing.JButton();
        jB3x3 = new javax.swing.JButton();
        jB4x4 = new javax.swing.JButton();
        jB3x4 = new javax.swing.JButton();
        jB2x4 = new javax.swing.JButton();
        jB2x3 = new javax.swing.JButton();
        Pan_Baixo = new javax.swing.JPanel();
        jB2x5 = new javax.swing.JButton();
        jB3x5 = new javax.swing.JButton();
        jB3x6 = new javax.swing.JButton();
        jB4x5 = new javax.swing.JButton();
        jB4x6 = new javax.swing.JButton();
        jB2x6 = new javax.swing.JButton();
        JPosInicialX = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JPosFinalX = new javax.swing.JTextField();
        IniciarJogo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        JPosInicialY = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JPosFinalY = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        JogarManualmente = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        SobreSoftare = new javax.swing.JRadioButtonMenuItem();
        SobreIntegrantes = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Pain_Esq.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jB1x2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB1x2ActionPerformed(evt);
            }
        });
        Pain_Esq.add(jB1x2, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 0, 82, 68));

        jB0x2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB0x2ActionPerformed(evt);
            }
        });
        Pain_Esq.add(jB0x2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 82, 68));

        jB1x3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB1x3ActionPerformed(evt);
            }
        });
        Pain_Esq.add(jB1x3, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 79, 82, 68));

        jB1x4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB1x4ActionPerformed(evt);
            }
        });
        Pain_Esq.add(jB1x4, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 153, 82, 68));

        jB0x3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB0x3ActionPerformed(evt);
            }
        });
        Pain_Esq.add(jB0x3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 79, 82, 68));

        jB0x4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB0x4ActionPerformed(evt);
            }
        });
        Pain_Esq.add(jB0x4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 153, 82, 68));

        Pain_Direito.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jB6x2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB6x2ActionPerformed(evt);
            }
        });
        Pain_Direito.add(jB6x2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 82, 68));

        jB5x2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB5x2ActionPerformed(evt);
            }
        });
        Pain_Direito.add(jB5x2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 82, 68));

        jB6x3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB6x3ActionPerformed(evt);
            }
        });
        Pain_Direito.add(jB6x3, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 79, 82, 68));

        jB6x4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB6x4ActionPerformed(evt);
            }
        });
        Pain_Direito.add(jB6x4, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 153, 82, 68));

        jB5x3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB5x3ActionPerformed(evt);
            }
        });
        Pain_Direito.add(jB5x3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 82, 68));

        jB5x4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB5x4ActionPerformed(evt);
            }
        });
        Pain_Direito.add(jB5x4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 153, 82, 68));

        Pain_Cima.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jB2x0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB2x0ActionPerformed(evt);
            }
        });
        Pain_Cima.add(jB2x0, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 82, 68));

        jB3x0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB3x0ActionPerformed(evt);
            }
        });
        Pain_Cima.add(jB3x0, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 82, 68));

        jB3x1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB3x1ActionPerformed(evt);
            }
        });
        Pain_Cima.add(jB3x1, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 85, 82, 68));

        jB4x0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB4x0ActionPerformed(evt);
            }
        });
        Pain_Cima.add(jB4x0, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 11, 82, 68));

        jB4x1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB4x1ActionPerformed(evt);
            }
        });
        Pain_Cima.add(jB4x1, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 85, 82, 68));

        jB2x1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB2x1ActionPerformed(evt);
            }
        });
        Pain_Cima.add(jB2x1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 85, 82, 68));

        Pain_Centro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jB4x2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB4x2ActionPerformed(evt);
            }
        });
        Pain_Centro.add(jB4x2, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 0, 82, 68));

        jB3x2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB3x2ActionPerformed(evt);
            }
        });
        Pain_Centro.add(jB3x2, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 0, 82, 68));

        jB2x2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB2x2ActionPerformed(evt);
            }
        });
        Pain_Centro.add(jB2x2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 82, 68));

        jB4x3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB4x3ActionPerformed(evt);
            }
        });
        Pain_Centro.add(jB4x3, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 74, 82, 68));

        jB3x3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB3x3ActionPerformed(evt);
            }
        });
        Pain_Centro.add(jB3x3, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 74, 82, 68));

        jB4x4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB4x4ActionPerformed(evt);
            }
        });
        Pain_Centro.add(jB4x4, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 153, 82, 68));

        jB3x4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB3x4ActionPerformed(evt);
            }
        });
        Pain_Centro.add(jB3x4, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 153, 82, 68));

        jB2x4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB2x4ActionPerformed(evt);
            }
        });
        Pain_Centro.add(jB2x4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 153, 82, 68));

        jB2x3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB2x3ActionPerformed(evt);
            }
        });
        Pain_Centro.add(jB2x3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 74, 82, 68));

        Pan_Baixo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jB2x5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB2x5ActionPerformed(evt);
            }
        });
        Pan_Baixo.add(jB2x5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 82, 68));

        jB3x5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB3x5ActionPerformed(evt);
            }
        });
        Pan_Baixo.add(jB3x5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 82, 68));

        jB3x6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB3x6ActionPerformed(evt);
            }
        });
        Pan_Baixo.add(jB3x6, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 85, 82, 68));

        jB4x5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB4x5ActionPerformed(evt);
            }
        });
        Pan_Baixo.add(jB4x5, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 11, 82, 68));

        jB4x6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB4x6ActionPerformed(evt);
            }
        });
        Pan_Baixo.add(jB4x6, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 85, 82, 68));

        jB2x6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB2x6ActionPerformed(evt);
            }
        });
        Pan_Baixo.add(jB2x6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 85, 82, 68));

        JPosInicialX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPosInicialXActionPerformed(evt);
            }
        });

        jLabel1.setText("Posição  X   Inicial:");

        jLabel2.setText("Posição  X   Final:");

        JPosFinalX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPosFinalXActionPerformed(evt);
            }
        });

        IniciarJogo.setText("Iniciar Jogo");
        IniciarJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarJogoActionPerformed(evt);
            }
        });

        jLabel3.setText("Posição  Y   Inicial:");

        JPosInicialY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPosInicialYActionPerformed(evt);
            }
        });

        jLabel4.setText("Posição  Y   Final:");

        JPosFinalY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPosFinalYActionPerformed(evt);
            }
        });

        jButton1.setText("Desisto!QueroJogar Novamente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu2.setText("Ferramentas");

        JogarManualmente.setText("Jogar manualmente");
        JogarManualmente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JogarManualmenteActionPerformed(evt);
            }
        });
        jMenu2.add(JogarManualmente);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Sobre");

        SobreSoftare.setSelected(true);
        SobreSoftare.setText("Sobre o Sowftare");
        SobreSoftare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SobreSoftareActionPerformed(evt);
            }
        });
        jMenu3.add(SobreSoftare);

        SobreIntegrantes.setSelected(true);
        SobreIntegrantes.setText("Sobre os integrantes");
        jMenu3.add(SobreIntegrantes);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(Pain_Esq, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Pain_Centro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Pain_Cima, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Pan_Baixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IniciarJogo, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel4)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(JPosFinalY, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                                            .addComponent(JPosFinalX)
                                            .addComponent(JPosInicialY)
                                            .addComponent(JPosInicialX)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(Pain_Direito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 12, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JPosInicialX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JPosInicialY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JPosFinalX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JPosFinalY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(IniciarJogo))
                    .addComponent(Pain_Cima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Pain_Esq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pain_Centro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pain_Direito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pan_Baixo, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jB6x2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB6x2ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 6, 2);
    }//GEN-LAST:event_jB6x2ActionPerformed

    private void SobreSoftareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SobreSoftareActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SobreSoftareActionPerformed

    private void JogarManualmenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JogarManualmenteActionPerformed
        tabuleiro[3][3] = 0;
        this.AtualizaMatriz();
        JogarManualmente.setEnabled(false);
    }//GEN-LAST:event_JogarManualmenteActionPerformed

    private void jB4x1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB4x1ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 4, 1);
    }//GEN-LAST:event_jB4x1ActionPerformed

    private void jB4x2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB4x2ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 4, 2);
    }//GEN-LAST:event_jB4x2ActionPerformed

    private void jB2x0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB2x0ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 2, 0);
    }//GEN-LAST:event_jB2x0ActionPerformed

    private void jB3x0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB3x0ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 3, 0);
    }//GEN-LAST:event_jB3x0ActionPerformed

    private void JPosInicialXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPosInicialXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPosInicialXActionPerformed

    private void JPosFinalXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPosFinalXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPosFinalXActionPerformed

    private void IniciarJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarJogoActionPerformed
        int passa = 0;
        while (passa == 0) {
            if (JPosInicialY.getText().equals("") || JPosInicialX.getText().equals("")
                    || JPosFinalY.getText().equals("") || JPosFinalX.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Os valores X e Y devem estar preenchidos!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                passa = 0;
                break;
            }

            int posy1 = Integer.parseInt(JPosInicialY.getText());//LER POSI. y INICIAL
            int posx1 = Integer.parseInt(JPosInicialX.getText()); //LER POSI. x INICIAL
            int posy2 = Integer.parseInt(JPosFinalY.getText()); //LER POSI. x INICIAL
            int posx2 = Integer.parseInt(JPosFinalX.getText()); //LER POSI. x INICIAL

            if (posy1 > TamY || posy1 < 0) {
                JOptionPane.showMessageDialog(null, "Valor de Y INICIAL fora da Matriz, Tente Novamente!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                passa = 0;
                break;
            } else if (posx1 > TamX || posx1 < 0) {
                JOptionPane.showMessageDialog(null, "Valor de X INICIAL fora da Matriz, Tente Novamente!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                passa = 0;
                break;
            } else if (tabuleiro[posx1][posy1] == 9) {
                JOptionPane.showMessageDialog(null, "Posição INICIAL informada é inválida!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                passa = 0;
                break;
            } else if (posy2 > TamY || posy2 < 0) {
                JOptionPane.showMessageDialog(null, "Valor de Y FINAL fora da Matriz, Tente Novamente!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                passa = 0;
                break;
            } else if (posx2 > TamX || posx2 < 0) {
                JOptionPane.showMessageDialog(null, "Valor de X FINAL fora da Matriz, Tente Novamente!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                passa = 0;
                continue;
            } else if (tabuleiro[posx2][posy2] == 9) {
                JOptionPane.showMessageDialog(null, "Posição FINAL informada é inválida!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                passa = 0;
                break;
            } else {
                passa = 1;
            }

            // Declaraçao da POSICAO FINAL
            int[][] PosicaoFinal = new int[posx2][posy2];

            // Setando campo como zero
            tabuleiro[posx1][posy1] = 0;
            IniciarJogo.setEnabled(false);

            this.AtualizaMatriz();

            System.out.println("----------------MATRIZ INICIAL-------------------------");
            this.MostraMatriz();

        } // Fim posições INICIAL


    }//GEN-LAST:event_IniciarJogoActionPerformed

    private void JPosInicialYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPosInicialYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPosInicialYActionPerformed

    private void JPosFinalYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPosFinalYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPosFinalYActionPerformed

    private void jB3x1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB3x1ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 3, 1);
    }//GEN-LAST:event_jB3x1ActionPerformed

    private void jB3x5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB3x5ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 3, 5);
    }//GEN-LAST:event_jB3x5ActionPerformed

    private void jB4x0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB4x0ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 4, 0);
    }//GEN-LAST:event_jB4x0ActionPerformed

    private void jB2x1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB2x1ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 2, 1);
    }//GEN-LAST:event_jB2x1ActionPerformed

    private void jB0x2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB0x2ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 0, 2);
    }//GEN-LAST:event_jB0x2ActionPerformed

    private void jB1x2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB1x2ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 1, 2);
    }//GEN-LAST:event_jB1x2ActionPerformed

    private void jB2x2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB2x2ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 2, 2);
    }//GEN-LAST:event_jB2x2ActionPerformed

    private void jB3x2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB3x2ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 3, 2);
    }//GEN-LAST:event_jB3x2ActionPerformed

    private void jB5x2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB5x2ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 5, 2);
    }//GEN-LAST:event_jB5x2ActionPerformed

    private void jB0x3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB0x3ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 0, 3);
    }//GEN-LAST:event_jB0x3ActionPerformed

    private void jB1x3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB1x3ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 1, 3);
    }//GEN-LAST:event_jB1x3ActionPerformed

    private void jB2x3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB2x3ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 2, 3);
    }//GEN-LAST:event_jB2x3ActionPerformed

    private void jB3x3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB3x3ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 3, 3);
    }//GEN-LAST:event_jB3x3ActionPerformed

    private void jB4x3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB4x3ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 4, 3);
    }//GEN-LAST:event_jB4x3ActionPerformed

    private void jB5x3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB5x3ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 5, 3);
    }//GEN-LAST:event_jB5x3ActionPerformed

    private void jB6x3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB6x3ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 6, 3);
    }//GEN-LAST:event_jB6x3ActionPerformed

    private void jB0x4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB0x4ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 0, 4);
    }//GEN-LAST:event_jB0x4ActionPerformed

    private void jB1x4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB1x4ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 1, 4);
    }//GEN-LAST:event_jB1x4ActionPerformed

    private void jB2x4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB2x4ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 2, 4);
    }//GEN-LAST:event_jB2x4ActionPerformed

    private void jB3x4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB3x4ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 3, 4);
    }//GEN-LAST:event_jB3x4ActionPerformed

    private void jB4x4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB4x4ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 4, 4);
    }//GEN-LAST:event_jB4x4ActionPerformed

    private void jB5x4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB5x4ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 5, 4);
    }//GEN-LAST:event_jB5x4ActionPerformed

    private void jB6x4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB6x4ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 6, 4);
    }//GEN-LAST:event_jB6x4ActionPerformed

    private void jB2x5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB2x5ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 2, 5);
    }//GEN-LAST:event_jB2x5ActionPerformed

    private void jB4x5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB4x5ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 4, 5);
    }//GEN-LAST:event_jB4x5ActionPerformed

    private void jB2x6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB2x6ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 2, 6);
    }//GEN-LAST:event_jB2x6ActionPerformed

    private void jB3x6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB3x6ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 3, 6);
    }//GEN-LAST:event_jB3x6ActionPerformed

    private void jB4x6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB4x6ActionPerformed
        this.verifica_Possibilidade_Manual(tabuleiro, 4, 6);
    }//GEN-LAST:event_jB4x6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(null, "Feche e abra novamente!");
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Painel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Painel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Painel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Painel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Painel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton IniciarJogo;
    private javax.swing.JTextField JPosFinalX;
    private javax.swing.JTextField JPosFinalY;
    private javax.swing.JTextField JPosInicialX;
    private javax.swing.JTextField JPosInicialY;
    private javax.swing.JMenuItem JogarManualmente;
    private javax.swing.JPanel Pain_Centro;
    private javax.swing.JPanel Pain_Cima;
    private javax.swing.JPanel Pain_Direito;
    private javax.swing.JPanel Pain_Esq;
    private javax.swing.JPanel Pan_Baixo;
    private javax.swing.JRadioButtonMenuItem SobreIntegrantes;
    private javax.swing.JRadioButtonMenuItem SobreSoftare;
    private javax.swing.JButton jB0x2;
    private javax.swing.JButton jB0x3;
    private javax.swing.JButton jB0x4;
    private javax.swing.JButton jB1x2;
    private javax.swing.JButton jB1x3;
    private javax.swing.JButton jB1x4;
    private javax.swing.JButton jB2x0;
    private javax.swing.JButton jB2x1;
    private javax.swing.JButton jB2x2;
    private javax.swing.JButton jB2x3;
    private javax.swing.JButton jB2x4;
    private javax.swing.JButton jB2x5;
    private javax.swing.JButton jB2x6;
    private javax.swing.JButton jB3x0;
    private javax.swing.JButton jB3x1;
    private javax.swing.JButton jB3x2;
    private javax.swing.JButton jB3x3;
    private javax.swing.JButton jB3x4;
    private javax.swing.JButton jB3x5;
    private javax.swing.JButton jB3x6;
    private javax.swing.JButton jB4x0;
    private javax.swing.JButton jB4x1;
    private javax.swing.JButton jB4x2;
    private javax.swing.JButton jB4x3;
    private javax.swing.JButton jB4x4;
    private javax.swing.JButton jB4x5;
    private javax.swing.JButton jB4x6;
    private javax.swing.JButton jB5x2;
    private javax.swing.JButton jB5x3;
    private javax.swing.JButton jB5x4;
    private javax.swing.JButton jB6x2;
    private javax.swing.JButton jB6x3;
    private javax.swing.JButton jB6x4;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables

}
