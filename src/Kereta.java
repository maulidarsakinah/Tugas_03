public class Kereta {
    private String namaKereta; // menyimpan nama kereta
    private int jumlahTiket; // menyimpan jumlah tiket yang tersedia
    private Ticket[] tiket; // menyimpan ticket penumpang dalam objek array 

    // default constructor
    public Kereta() { // konstruktor untuk kereta komuter dengan jumlah tiket sebanyak 1000
        this.namaKereta = "komuter";
        this.jumlahTiket = 1000;
        tiket = new Ticket[jumlahTiket];
    }

    // overload constructor
    public Kereta(String namaKereta, int jumlahTiket) { // konstruktor untuk KAJJ dengan nama dan jumlah tiket diinputkan
        this.namaKereta = namaKereta;
        this.jumlahTiket = jumlahTiket;
        tiket = new Ticket[jumlahTiket];
    }

    // default method untuk menambahkan tiket
    public void tambahTiket(String namaPenumpang) { // menambahkan tiket untuk kereta komuter
        if (jumlahTiket > 0) { // memeriksa ketersediaan tiket yang masih ada
            tiket[jumlahTiket - 1] = new Ticket(); // membuat objek baru di array tiket
            tiket[jumlahTiket - 1].setNamaPenumpang(new String[]{namaPenumpang}); // mengatur nama penumpang pada objek tiket
            jumlahTiket--; // mengurangi jumlah tiket yang tersedia
            System.out.println("==================================================");
            System.out.println("Tiket berhasil dipesan");
        } else { // jika tiket sudah habis akan mencetak pesan sebagai berikut
            System.out.println("==================================================");
            System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
        }

        if (jumlahTiket < 30) { // menampilkan sisa tiket jika kurang dari 30
            System.out.println("Sisa tiket tersedia: " + jumlahTiket);
        }
    }

    // overload method untuk menambahkan tiket
    public void tambahTiket(String namaPenumpang, String asal, String tujuan) { // menambahkan tiket untuk KAJJ
        if (jumlahTiket > 0) {
            tiket[jumlahTiket - 1] = new Ticket();
            tiket[jumlahTiket - 1].setNamaPenumpang(new String[]{namaPenumpang}); // mengatur nama penumpang pada objek tiket
            tiket[jumlahTiket - 1].setAsal(new String[]{asal}); // mengatur asal penumpang pada objek tiket
            tiket[jumlahTiket - 1].setTujuan(new String[]{tujuan}); // mengatur tujuan penumpang pada objek tiket
            jumlahTiket--;

            if (jumlahTiket < 30) { // menampilkan sisa tiket jika kurang dari 30 dan pesan berikut
                System.out.println("==================================================");
                System.out.println("Tiket berhasil dipesan Sisa tiket tersedia: " + jumlahTiket);
            } else { // jika tidak akan mencetak pesan sebagai berikut yaitu penumpang KAJJ wajib memiliki asal dan tujuan tiket 
                System.out.println("==================================================");
                System.out.println("Penumpang KAJJ wajib memiliki asal dan tujuan tiket");
            }
        } else { // jika tiket sudah habis akan mencetak pesan sebagai berikut
            System.out.println("==================================================");
            System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
        }
    }

    // menampilkan daftar penumpang
    public void tampilkanTiket() {
        System.out.println("==================================================");
        System.out.println("Daftar penumpang kereta api " + namaKereta + ":"); // mencetak nama kereta
        System.out.println("------------------------------");
        for (int i = tiket.length - 1; i >= 0; i--) { // melakukan loop dari belakang array tiket
            if (tiket[i] != null) { // memastikan objek  tiket tidak null
                for (String nama : tiket[i].getNamaPenumpang()) { // melakukan loop untuk setiap nama penumpang
                    System.out.println("Nama: " + nama); // mencetak nama penumpang
                }
                if (namaKereta != "komuter") { // memeriksa nama kereta bukan komuter
                    for (int j = 0; j < tiket[i].getAsal().length; j++) { // melakukan loop untuk setiap asal dan tujuan penumpang
                        System.out.println("Asal: " + tiket[i].getAsal()[j]); // mencetak asal penumpang
                        System.out.println("Tujuan: " + tiket[i].getTujuan()[j]); // mencetak tujuan penumpang
                        System.out.println("------------------------------");
                    }
                }
            }
        }
    }
}