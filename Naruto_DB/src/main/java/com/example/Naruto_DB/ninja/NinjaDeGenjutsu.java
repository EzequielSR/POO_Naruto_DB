package com.example.Naruto_DB.ninja;

import com.example.Naruto_DB.entity.Personagem;

import java.util.Random;

public class NinjaDeGenjutsu extends Personagem implements Ninja {
    public NinjaDeGenjutsu(String nome, int idade, String aldeia, int vida){
        super(nome, idade, aldeia, 100, vida);
    }

    @Override
    public void usarJutsu(Personagem inimigo, String nomeJutsu){
        if (!podeAtacar()) {
            System.out.println(getNome() + " não tem chakra suficiente para atacar!");
            return;
        }

        Jutsu jutsu = getJutsus().get(nomeJutsu);
        if (jutsu != null) {
            System.out.println(getNome() + " está usando " + nomeJutsu + "!");
            inimigo.perderVida(jutsu.getDano());
            System.out.println(inimigo.getNome() + " perdeu " + jutsu.getDano() + " de vida!");
            System.out.println(inimigo.getNome() + " agora tem " + inimigo.getVida() + " de vida restante.");
            setChakra(getChakra() - jutsu.getConsumoDeChakra());
        } else {
            System.out.println("Jutsu " + nomeJutsu + " não encontrado!");
        }
    }

    @Override
    public void desviar(int dano){
        Random random = new Random();
        boolean sucesso = random.nextBoolean();
        if (sucesso) {
            System.out.println(getNome() + " desviou do ataque!");
        } else {
            System.out.println(getNome() + " não conseguiu desviar e perdeu " + dano + " de vida!");
            perderVida(dano);
        }
    }
}
