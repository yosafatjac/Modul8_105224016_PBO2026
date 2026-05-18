package com.rpg.main;

// Untuk kelas GameEngine yang berfungsi sebagai titik masuk utama untuk menjalankan permainan RPG Dungeon
import com.rpg.entitas.Monster;
import com.rpg.entitas.Pahlawan;
import java.io.PrintStream;
import java.util.Scanner;

public class GameEngine {
   public GameEngine() {
   }
   // Dalam metode main, kita membuat objek Scanner untuk membaca input dari pengguna, dan tampilkan pesan selamat datang.
   // Kemudian, kita meminta pengguna untuk memasukkan nama pahlawan mereka, 
   // dan membuat objek Pahlawan dengan nama tersebut serta atribut HP, damage, mana, dan jumlah potion.
   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      System.out.println("===========================================");
      System.out.println("       SELAMAT DATANG DI RPG DUNGEON      ");
      System.out.println("===========================================");
      System.out.print("Masukkan nama Pahlawan Anda: ");
      String var2 = var1.nextLine();
      Pahlawan var3 = new Pahlawan(var2, 150, 20, 80, 2);
      Monster[] var4 = new Monster[]{new Monster("Goblin Kecil", 60, 10, "Humanoid"), new Monster("Orc Berdarah", 100, 18, "Humanoid"), new Monster("Naga Kegelapan", 150, 30, "Naga")};
      boolean var5 = false;

      // Loop untuk setiap monster yang muncul, tampilkan status monster, serta
      // lakukan pertempuran hingga salah satu pihak kalah.
      for(int var6 = 0; var6 < var4.length; ++var6) {
         Monster var7 = var4[var6];
         System.out.println("\n#===========================================#");
         System.out.println("  MONSTER " + (var6 + 1) + " MUNCUL!");
         var7.tampilkanStatus();
         System.out.println("#===========================================#");

        // Pertempuran berlangsung dalam loop hingga HP salah satu pihak habis
         while(var3.getHp() > 0 && var7.getHp() > 0) {
            System.out.println("\n-------------------------------------------");
            var3.tampilkanStatus();
            var7.tampilkanStatus();
            System.out.println("-------------------------------------------");
            System.out.println("  Pilih aksi:");
            System.out.println("  1. Serang Biasa");
            System.out.println("  2. Gunakan Skill (butuh Mana)");
            System.out.println("  3. Bertahan + Heal (Potion)");
            System.out.print("  >> Pilihan: ");

            // Memvalidasi input untuk memastikan pengguna memasukkan angka yang benar
            int var8;
            try {
               var8 = Integer.parseInt(var1.nextLine().trim());
            } catch (NumberFormatException var14) {
               System.out.println("  [!] Input tidak valid, coba lagi.");
               continue;
            }

            // 3 pilihan aksi yaitu melakukan serangan biasa, serangan dengan skill, atau bertahan dan menggunakan item
            int var9 = 0;
            switch (var8) {
               case 1:
                  var9 = var3.serang();
                  PrintStream var10000 = System.out;
                  String var10001 = var3.getNama();
                  var10000.println("  >> " + var10001 + " menyerang " + var7.getNama() + " | Damage: " + var9);
                  var7.terimaDamage(var9);
                  break;
               case 2:
                  System.out.print("  Nama Skill: ");
                  String var10 = var1.nextLine();
                  System.out.print("  Mana Cost : ");

                  int var11;
                  try {
                     var11 = Integer.parseInt(var1.nextLine().trim());
                  } catch (NumberFormatException var13) {
                     System.out.println("  [!] Input Mana tidak valid.");
                     continue;
                  }

                  var9 = var3.serang(var10, var11);
                  if (var9 > 0) {
                     System.out.println("  >> " + var3.getNama() + " menggunakan [" + var10 + "] | Damage: " + var9);
                     var7.terimaDamage(var9);
                  }
                  break;
               case 3:
                  var3.bertahan();
                  var3.gunakanItem();
                  break;
               default:
                  System.out.println("  [!] Pilihan tidak valid, giliran terlewat!");
            }

            // Jika monster masih hidup setelah serangan pahlawan, monster akan membalas serangan
            if (var7.getHp() > 0) {
               int var17 = var7.serang();
               PrintStream var18 = System.out;
               String var19 = var7.getNama();
               var18.println("  >> " + var19 + " membalas " + var3.getNama() + " | Damage: " + var17);
               var3.terimaDamage(var17);
            } else {
               System.out.println("\n  *** " + var7.getNama() + " telah dikalahkan! ***");
            }
         }

         // Jika HP pahlawan habis, set var5 menjadi true untuk 
         // menandakan bahwa permainan berakhir dengan kekalahan, dan keluar dari loop monster
         if (var3.getHp() <= 0) {
            var5 = true;
            break;
         }
      }

      // Setelah loop pertempuran selesai, tampilkan pesan akhir berdasarkan 
      // apakah pahlawan berhasil menamatkan dungeon atau tidak, serta HP yang tersisa jika berhasil.
      System.out.println("\n===========================================");
      if (!var5) {
         System.out.println("  SELAMAT! " + var3.getNama() + " berhasil menamatkan Dungeon!");
         System.out.println("  HP Tersisa: " + var3.getHp());
      } else {
         System.out.println("  GAME OVER! " + var3.getNama() + " telah gugur dalam pertempuran...");
      }

      System.out.println("===========================================");
      var1.close();
   }
}
