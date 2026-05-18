package com.rpg.arena;

// Untuk kelas abstrak Karakter yang mengimplementasikan interface AksiBertarung,
public abstract class Karakter implements AksiBertarung {
    protected String nama;
    protected int hp;
    protected int baseDamage;
    protected boolean isDefending;

    // Sebagai konstruktor untuk inisialisasi nama, hp, baseDamage, dan status bertahan
    public Karakter(String nama, int hp, int baseDamage) {
        this.nama = nama;
        this.hp = hp;
        this.baseDamage = baseDamage;
        this.isDefending = false; // default
    }

    // untuk getter dan setter
    public String getNama()           { return nama; }
    public void setNama(String nama)  { this.nama = nama; }

    public int getHp()                { return hp; }
    public void setHp(int hp)         { this.hp = hp; }

    public int getBaseDamage()                  { return baseDamage; }
    public void setBaseDamage(int baseDamage)    { this.baseDamage = baseDamage; }

    public boolean isDefending()                { return isDefending; }
    public void setDefending(boolean defending) { this.isDefending = defending; }

    // untuk menerima damage, jika sedang bertahan maka damage dikurangi setengah
    public void terimaDamage(int damage) {
        if (isDefending) {
            damage = damage / 2; // damage dikurangi setengah saat bertahan
            isDefending = false; // reset status bertahan
        }
        hp -= damage;
        if (hp < 0) hp = 0; // HP tidak boleh di bawah nol
    }

    // Untuk menampilkan status karakter (nama, HP, dan status bertahan)
    public abstract void tampilkanStatus();
}
