package Exercicios_Aula4;

import Exercicios_Aula4.Personagem.PlayerJogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JFrame {

    PlayerJogo playerJogo;

    public Screen(){
        playerJogo = new PlayerJogo();

        setVisible(true);
        setSize(800,500);
        setTitle("Game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o aplicativo quando a janela é fechada

        JPanel painel = new JPanel();
        JButton buttonNomePlayer = new JButton("Salvar nome player");


        buttonNomePlayer.setBackground(new Color(92, 217, 51));
        buttonNomePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarNome();
            }
        });

        JButton buttonIniciarGame = new JButton("Iniciar Game");
        buttonIniciarGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarGame();
                if(playerJogo.getNome() != null){
                    painel.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "O nome do seu personagem deve ser informado");
                }

            }
        });

        painel.add(buttonNomePlayer);
        painel.add(buttonIniciarGame);
        add(painel);
    }

    public void salvarNome(){
        String input = JOptionPane.showInputDialog(null, "Digite algo:");
        if(input != null){
            if(input.equals("")){
                JOptionPane.showMessageDialog(null, "O nome do seu personagem deve ser digitado");
            }else{
                JOptionPane.showMessageDialog(null, "O nome do seu personagem é: " + input);
                playerJogo.setNome(input);
            }
        }

    }

    public void iniciarGame(){

    }


}
