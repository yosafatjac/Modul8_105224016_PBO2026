// untuk kelas Monster yang merupakan subclass dari Karakter, 
// dengan atribut tambahan jenisMonster.
package com.rpg.entitas;
// Untuk mengimport kelas Karakter dari package com.rpg.arena 
// agar bisa digunakan sebagai superclass untuk Monster
import com.rpg.arena.Karakter;

public class Monster extends Karakter {
    private String jenisMonster;
    // Konstruktor untuk inisialisasi nama, hp, baseDamage, dan jenisMonster
    public Monster(String nama, int hp, int baseDamage, String jenisMonster) {
        super(nama, hp, baseDamage);
        this.jenisMonster = jenisMonster;
    }
    // Getter dan setter untuk jenisMonster
    public String getJenisMonster()               { return jenisMonster; }
    public void setJenisMonster(String jenis)     { this.jenisMonster = jenis; }

    // Override metode serang untuk memberikan damage tetap tanpa multiplier
    @Override
    public int serang() {
        return baseDamage; // damage tetap, tanpa multiplier
    }
    // Override metode bertahan untuk memulihkan HP alih-alih mengurangi damage
    @Override
    public void bertahan() {
        // Monster memulihkan HP alih-alih mengurangi damage
        hp += 10;
        System.out.println("  >> " + nama + " memulihkan 10 HP! HP sekarang: " + hp);
    }
    // Override metode gunakanItem untuk menampilkan pesan bahwa monster tidak memiliki item
    @Override
    public void gunakanItem() {
        System.out.println("  >> " + nama + " tidak memiliki item.");
    }
    // Override metode tampilkanStatus untuk menampilkan nama, jenis monster, HP, dan ATK
    @Override
    public void tampilkanStatus() {
        System.out.println("  [MONSTER] " + nama
                + " (" + jenisMonster + ")"
                + " | HP: " + hp
                + " | ATK: " + baseDamage);
    }
}
