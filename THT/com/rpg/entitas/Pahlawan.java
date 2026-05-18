package com.rpg.entitas;

import com.rpg.arena.Karakter;

public class Pahlawan extends Karakter {
    private int mana;
    private int level;

    public Pahlawan(String nama, int hp, int baseDamage, int mana, int level) {
        super(nama, hp, baseDamage);
        this.mana = mana;
        this.level = level;
    }

    // Getter dan setter untuk mana dan level
    public int getMana()          { return mana; }
    public void setMana(int mana) { this.mana = mana; }
    public int getLevel()           { return level; }
    public void setLevel(int level) { this.level = level; }

    // Override untuk metode serang, damage meningkat berdasarkan level
    @Override
    public int serang() {
        return baseDamage * level;
    }

    // Metode serang dengan nama skill dan mana cost, damage lebih besar jika mana cukup
    public int serang(String namaSkill, int manaCost) {
        if (mana >= manaCost) {
            mana -= manaCost;
            return baseDamage * level * 2; // damage besar
        } else {
            System.out.println("  [!] Mana tidak cukup untuk menggunakan skill '" + namaSkill + "'!");
            return 0;
        }
    }
    // Ini untuk bertahan damage diterima akan dikurangi setengah, 
    // dan status bertahan akan direset setelah menerima damage
    @Override
    public void bertahan() {
        isDefending = true;
        System.out.println("  >> " + nama + " bersiaga! Damage yang diterima akan dikurangi setengah.");
    }

    // Saat menggunakan item, HP akan bertambah 30
    @Override
    public void gunakanItem() {
        hp += 30;
        System.out.println("  >> " + nama + " menggunakan Potion! HP +30 => HP sekarang: " + hp);
    }
    
    // Override untuk menampilkan status pahlawan, termasuk nama, HP, mana, dan level
    @Override
    public void tampilkanStatus() {
        System.out.println("  [PAHLAWAN] " + nama
                + " | HP: " + hp
                + " | Mana: " + mana
                + " | Level: " + level);
    }
}
