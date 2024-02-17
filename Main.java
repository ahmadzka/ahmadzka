/*Kelompok 3
* Ahmad Adzka Najhan-235150200111037
* Muhammad Ridwan Novriansyah-235150201111041
* Putra Cakrawala Aulia Syafiq-235150200111040
*/
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;
public class Main{
    static final String[] FOOD_OPTIONS = {"Nasi Goreng", "Sate Ayam", "Mie Ayam", "Bakso", "Martabak", "Ayam Geprek", "Gacoan", "Naoki Rice", "Nasi Ayam", "Soto", "Tahu Telur", "Chicken Katsu"};
    static final int[] FOOD_PRICES = {15000, 20000, 15000, 18000, 30000, 15000, 10000, 30000, 11000, 11000, 12000, 15000};
    static final String[] DRINK_OPTIONS = {"Es Teh", "Es Jeruk", "Es Cincau", "Jus Alpukat", "Kopi", "Jus", "Es Teler", "Thai Tea", "Boba Tea", "Mixue", "Avocado Choco"};
    static final int[] DRINK_PRICES = {5000, 6000, 7000, 8000, 4000, 12000, 13000, 15000, 20000, 13000, 16000};
    static final int BIAYA_PER_KM = 1000;
    static final int biayaAplikasi = 5000;
    static final String[] YA_OPTIONS = {"Ya", "Iya", "iya", "y", "ya", "oke", "Oke", "Y", "Ya", "ya", "Boleh", "boleh", "sip", "Sip", "Siap", "siap"};
    static final String[] TIDAK_OPTIONS = {"n","N","no", "No", "nope", "Nope", "Tidak", "tidak", "enggak", "engga", "ngga", "nggak", "Enggak", "Engga", "Ngga", "Nggak", "Ga", "ga", "g", "G", "Ga", "GA", "Gak", "GAK", "gak", "Gak dulu", "gadulu", "Gadulu"};
    public static void main(String[] args) {
        boolean isValid_LogIn, isValid_SignIn, isValid_Verification=false;
        boolean appsvalue = true;
        String inputUsername="", inputPassword="", verifiedPassword;
        int [] saldoarray = {1000000, 500000, 200000};
        String[] username = {"adzka", "syafiq", "ridwan"};
        String[] password = {"111004", "12345", "98765"};
        int nextIndex = username.length;
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("Rp#,###.00",symbols);
        try (Scanner in = new Scanner(System.in)) {
            do{
                do {
                    clearScreen();
                    System.out.printf("===========================|FAST-TRACK|===========================\n");
                    System.out.println("Silahkan log-in atau Sign-In terlebih dahulu");
                    System.out.printf("\n%25s %20s\n\n", "Log-In", "Sign-in");
                    border();
                    System.out.print("Masukkan pilihanmu: ");
                    String pilihan = in.nextLine();
                    while (!(pilihan.equalsIgnoreCase("login")|| pilihan.equalsIgnoreCase("log in") || pilihan.equalsIgnoreCase("sign in") || pilihan.equalsIgnoreCase("signin"))) {
                        System.out.print("Invalid input. Please try again : ");
                        pilihan = in.nextLine();
                    }
                    if (pilihan.equalsIgnoreCase("login")|| pilihan.equalsIgnoreCase("log in")) {
                        do {
                            clearScreen();
                            System.out.printf("===========================|FAST-TRACK|===========================\n");
                            System.out.println("Log-In:");
                            System.out.println("Silahkan masukkan username dan password akun anda");
                            System.out.print("Username: ");
                            inputUsername = in.nextLine();
                            System.out.print("Password: ");
                            inputPassword = in.nextLine();
                            isValid_LogIn = verification1(username, password, inputUsername, inputPassword);
                            if (isValid_LogIn) {
                                clearScreen();
                                System.out.println("Login berhasil.");
                                isValid_Verification = true;
                            } else {
                                clearScreen();
                                border();
                                System.out.println("Login gagal. Mungkin Username atau password yang kamu masukkan ");
                                System.out.println("salah. Silakan coba lagi yaa!!!.");
                                border();
                            }
                        } while (!isValid_LogIn);
                    } else if (pilihan.equalsIgnoreCase("sign in") || pilihan.equalsIgnoreCase("signin")) {
                        do {
                            clearScreen();
                            System.out.printf("===========================|FAST-TRACK|===========================\n");
                            System.out.println("Sign-In:");
                            System.out.println("Silahkan masukkan username dan password akun anda");
                            System.out.print("Username: ");
                            inputUsername = in.nextLine();
                            System.out.print("Password: ");
                            inputPassword = in.nextLine();
                            isValid_SignIn = verification1(username, password, inputUsername, inputPassword);
                            if (isValid_SignIn) {
                                clearScreen();
                                border();
                                System.out.println("Sign-In gagal. Username atau password sudah digunakan.");
                                System.out.println("Silakan coba lagi yaa!!!.");
                                
                            } else {
                                clearScreen();
                                System.out.println("Sign-In berhasil.");
                                isValid_Verification = true;
                                username[nextIndex - 1] = inputUsername;
                                password[nextIndex - 1] = inputPassword;
                                saldoarray[nextIndex - 1]=0;
                                nextIndex++;
                            }
                        } while (isValid_SignIn);
                    }
                } while (!isValid_Verification);
                //menu utama
                int SaldoFastPay = verifySaldo(username, password, inputUsername, inputPassword, saldoarray);
                verifiedPassword = inputPassword;
                boolean IsValidMenu_Home = true;
                while(IsValidMenu_Home){
                    System.out.printf("===========================|FAST-TRACK|===========================\n\n");
                    System.out.println("Haloo!!!, Selamat datang kembali "+inputUsername+" di Aplikasi yang b-aja ini");
                    System.out.println("Silahkan pilih menu apapun yang kamu mau");
                    System.out.println("");
                    System.out.println("Ingfo Saldo Fast-Pay anda: "+df.format(SaldoFastPay)+"\n");
                    border();
                    System.out.println("Menu Yang Bisa Anda Pilih");
                    System.out.println("-------------------------------------");
                    System.out.printf("| %-16s| %-16s|\n","1) Fast-Pay", "4) Fast-Send");
                    System.out.printf("| %-16s| %-16s|\n","2) Fast-Go", "5) Fast-Rent");
                    System.out.printf("| %-16s| %-16s|\n","3) Fast-Food", "0) Keluar");
                    System.out.println("-------------------------------------");
                    System.out.print("\nMasukkan Pilihanmu: ");
                    int MenuUtama = in.nextInt();
                    border();
                    clearScreen();
                    switch (MenuUtama){
                        case 1 -> {
                            boolean IsValidMenu_FastPay = false;
                            do{
                                System.out.println("============================|Fast-Pay|============================");
                                System.out.println("Total SaldoFastPay Fast-Pay: " +df.format(SaldoFastPay));
                                System.out.println("");
                                System.out.println("1) Top-Up");
                                System.out.println("2) Pay/Transfer");
                                System.out.print("Pilih Menu: ");
                                int MenuFastPay = in.nextInt();
                                border();
                                clearScreen();
                                in.nextLine();
                                switch (MenuFastPay){
                                    case 1 ->{
                                        System.out.println("============================|Fast-Pay|============================");
                                        System.out.println("Pilih nominal Top-Up:");
                                        System.out.printf("| %-16s| %-16s|\n","Rp. 5.000", "Rp. 50.000");
                                        System.out.printf("| %-16s| %-16s|\n","Rp. 10.000", "Rp. 100.000");
                                        System.out.printf("| %-16s| %-16s|\n","Rp. 25.000", "Rp. 200.000");
                                        System.out.printf("Nominal : Rp. ");
                                        int nominal = in.nextInt();
                                        border();
                                        boolean IsValidSubMenu_TopUp;
                                        in.nextLine();
                                        do{
                                            System.out.println("Verifikasi akun");
                                            System.out.print("Password: ");
                                            inputPassword = in.nextLine();
                                            IsValidSubMenu_TopUp = verification2(verifiedPassword, inputPassword);
                                            System.out.println("");
                                            if (IsValidSubMenu_TopUp) {
                                                clearScreen();
                                                System.out.println("Verifikasi berhasil!!!");
                                                System.out.println("============================|Fast-Pay|============================");
                                                SaldoFastPay += nominal;
                                                System.out.println("Yeayy!!, anda berhasil top up sebesar "+df.format(nominal));
                                                System.out.println("Saldo Fast-Pay anda sekarang adalah Rp. "+SaldoFastPay);
                                                border();
                                                System.out.println("9) Kembali");
                                                System.out.println("0) Home");
                                                System.out.print("Pilih menu: ");
                                                int MenuBack = in.nextInt();
                                                if(MenuBack==0){
                                                    IsValidMenu_FastPay = true;
                                                }
                                                clearScreen();
                                            } else {
                                                clearScreen();
                                                border();
                                                System.out.println("Verifikasi gagal!!!");
                                                System.out.println("Silahkan Verifikasi kembali");
                                                System.out.println("============================|Fast-Pay|============================");
                                            }
                                        } while(!IsValidSubMenu_TopUp);
                                        break;
                                    }
                                    case 2 ->{
                                        System.out.println("============================|Fast-Pay|============================");
                                        System.out.print("Nama penerima: ");
                                        String NamaPenerima = in.nextLine();
                                        System.out.println("\nPilih nominal yang akan dibayar:");
                                        System.out.printf("| %-16s| %-16s|\n","Rp. 5.000", "Rp. 50.000");
                                        System.out.printf("| %-16s| %-16s|\n","Rp. 10.000", "Rp. 100.000");
                                        System.out.printf("| %-16s| %-16s|\n","Rp. 25.000", "Rp. 200.000");
                                        System.out.printf("Nominal : Rp. ");
                                        int nominal = in.nextInt();
                                        border();
                                        boolean IsValidSubMenu_Pay;
                                        in.nextLine();
                                        do{
                                            System.out.println("Verifikasi akun");
                                            System.out.print("Password: ");
                                            inputPassword = in.nextLine();
                                            IsValidSubMenu_Pay = verification2(verifiedPassword, inputPassword);
                                            System.out.println("");
                                            if (IsValidSubMenu_Pay) {
                                                for (int i = 0; i < username.length; i++) {
                                                    if(username[i].equalsIgnoreCase(NamaPenerima)){
                                                        saldoarray[i]+=nominal;
                                                    }
                                                }
                                                clearScreen();
                                                System.out.println("Verifikasi berhasil!!!");
                                                SaldoFastPay -= nominal;
                                                System.out.println("============================|Fast-Pay|============================");
                                                System.out.println("Yeayy!! anda berhasi membayar sebesar "+df.format(nominal)+" kepada "+NamaPenerima);
                                                System.out.println("Saldo Fast-Pay anda sekarang adalah "+df.format(SaldoFastPay));
                                                border();
                                                System.out.println("9) Kembali");
                                                System.out.println("0) Home");
                                                System.out.print("Pilih menu: ");
                                                int MenuBack = in.nextInt();
                                                if(MenuBack==0){
                                                    IsValidMenu_FastPay = true;
                                                }
                                                clearScreen();
                                            } else {
                                                clearScreen();
                                                System.out.println("Verifikasi gagal!!!");
                                                System.out.println("Silahkan Verifikasi kembali");
                                                System.out.println("============================|Fast-Pay|============================");
                                            }
                                        } while(!IsValidSubMenu_Pay);
                                        break;
                                    }
                                    default ->{
                                        System.out.println("Silahkan masukkan pilihan yang sesuai dengan menu yang ada");
                                    }
                                }
                            } while(!IsValidMenu_FastPay);
                        }
                        case 2->{
                            boolean IsValdiMenu_FastGo=false;
                            do{
                                String[] NamaDriver = {"fatir", "ivan", "ariel", "radit", "desta", "albab", "faiz", "wahyu"};
                                String[] PlatNomor = {"B 2567 UXL", "N 2345 TP", "B 6016 UTP", "F 5142 YZF", "AG 6665 XU", "A 51 K"};
                                int n = NamaDriver.length;
                                int m = PlatNomor.length;
                                int indeksAcak = (int) (Math.random() * n);
                                int indeksPlat = (int) (Math.random() * m);
                                System.out.println("============================|Fast--Go|============================");
                                System.out.println("Total SaldoFastPay Fast-Pay: " +df.format(SaldoFastPay));
                                System.out.printf("\n%-45s %s","Masukkan Jarak Perjalanan (Km)",": ");
                                float jarak = in.nextInt();
                                int tarifmobil, tarifmotor;
                                if (jarak <= 2) {
                                    tarifmobil = (int)jarak*25000;
                                    tarifmotor = (int) jarak*15000;
                                } else if (jarak <= 5) {
                                    tarifmobil = (int)jarak*40000;
                                    tarifmotor = (int) jarak*20000;
                                } else if (jarak <= 10) {
                                    tarifmobil = (int)jarak*65000;
                                    tarifmotor = (int) jarak*30000;
                                } else {
                                    tarifmobil = (int)jarak*15000;
                                    tarifmotor = (int) jarak*8000;
                                }
                                System.out.println("");
                                subborder();
                                System.out.printf("| %-25s | %-16s |\n", "Jenis Kendaraan Tersedia","Harga");
                                subborder();
                                System.out.printf("| %-25s | %-16s |\n", "Motor",df.format(tarifmotor));
                                System.out.printf("| %-25s | %-16s |\n", "Mobil",df.format(tarifmobil));
                                subborder();
                                System.out.printf("%-45s %s","Masukkan Jenis Kendaraan",": ");
                                String kendaraan = in.next();
                                double tarif = hitungTarif(jarak, kendaraan);
                                System.out.println("");
                                subborder();
                                System.out.printf("| %-15s | %-8s | %-15s |\n", "Opsi Pembayaran","Diskon %", "Harga");
                                System.out.printf("| %-15s | %-8s | %-15s |\n", "","", "(Setelah %)");
                                subborder();
                                System.out.printf("| %-15s | %-8s | %-15s |\n", "Fast-Pay","30%",df.format(tarif*0.7));
                                System.out.printf("| %-15s | %-8s | %-15s |\n", "Gopay","10%", df.format(tarif*0.9));
                                System.out.printf("| %-15s | %-8s | %-15s |\n", "OVO","5%", df.format(tarif*0.95));
                                System.out.printf("| %-15s | %-8s | %-15s |\n", "Cash","-", df.format(tarif));
                                subborder();
                                System.out.printf("%-45s %s","Masukkan opsi pembayaran",": ");
                                String pembayaran = in.next();
                                
                                border();
                                double total = hitunghargaDiskon(tarif, pembayaran);
                                if (pembayaran.equalsIgnoreCase("fastpay")){
                                    SaldoFastPay -=total;
                                }
                                System.out.printf("%-45s %s\n","Total pembayaran",": " + df.format(total));
                                border();
                                System.out.println("Yeayy!!, anda berhasil memesan layanan Fast-Go dengan");
                                System.out.println("tarif sebesar "+df.format(total)+". Tunggu Driver Mas "+ NamaDriver[indeksAcak]+ " dengan Plat Nomor "+ PlatNomor[indeksPlat]+ " yak!");
                                border();
                                System.out.println("9) Kembali");
                                System.out.println("0) Home");
                                System.out.print("Pilih menu: ");
                                int MenuBack = in.nextInt();
                                while (MenuBack!= 9 && MenuBack!=0) {
                                    System.out.println("Invalid in. Please try again : ");
                                    MenuBack = in.nextInt();
                                }
                                if(MenuBack==0){
                                    IsValdiMenu_FastGo=true;
                                }
                                clearScreen();
                            }while(!IsValdiMenu_FastGo);
                        }
                        case 3->{
                            boolean isValidMenu_FastFood = true;
                            while (isValidMenu_FastFood) {
                                boolean isValidOption;
                                String userChoice;
                                do {
                                    System.out.println("===========================|Fast--Food|===========================");
                                    System.out.print("Lanjut ke menu Fast-Food? (Y/N) ");
                                    userChoice = in.next();
                                    in.nextLine();
                                    
                                    isValidOption = false;
                                
                                    for (String yaOption : YA_OPTIONS) {
                                        if (yaOption.equalsIgnoreCase(userChoice)) {
                                            int jenisPesanan = getOrderChoice(in);
                                            clearScreen();
                                            double totalCost=0;
                                            in.nextLine();
                                            if (jenisPesanan == 1) {
                                                tampilanAplikasi();
                                                System.out.println("Total SaldoFastPay Fast-Pay: " +df.format(SaldoFastPay));
                                                System.out.println("");
                                                border();
                                                tampilanMakanan();
                                                int jenisMakanan = jenisMakanan(in);
                                                int jumlah = jumlahMakanan(in);
                                                double distance = jarakOngkir(in);
                                                double hargaTotalMakanan = penjumlahanMakanan(jenisMakanan, jumlah);
                                                double biayaOngkir = calculatebiayaOngkir(distance);
                                                totalCost = hargaTotalMakanan + biayaOngkir + biayaAplikasi;
                                                menuMetodePembayaran(totalCost, 5000, SaldoFastPay);
                                            } else if (jenisPesanan == 2) {
                                                tampilanAplikasi();
                                                System.out.println("Total SaldoFastPay Fast-Pay: " +df.format(SaldoFastPay));
                                                System.out.println("");
                                                int jenisMinuman = jenisMinuman(in);
                                                int jumlah = jumlahMinuman(in);
                                                double distance = jarakOngkir(in);
                                                double hargaTotalMinuman = penjumlahanMinuman(jenisMinuman, jumlah);
                                                double biayaOngkir = calculatebiayaOngkir(distance);
                                                totalCost = hargaTotalMinuman + biayaOngkir + biayaAplikasi;
                                                menuMetodePembayaran(totalCost, 5000, SaldoFastPay);
                                            }
                                            boolean isValidSubOption = false;
                                            do {
                                                System.out.print("Apakah anda ingin melanjutkan ke checkout? (Y/N) ");
                                                userChoice = in.next();
                                                in.nextLine();
                                                
                                                for (String Option : YA_OPTIONS) {
                                                    if (Option.equalsIgnoreCase(userChoice)) {
                                                        confirmOrder();
                                                        isValidSubOption = true;
                                                        border();
                                                        System.out.println("9) Kembali");
                                                        System.out.println("0) Home");
                                                        System.out.print("Pilih menu: ");
                                                        int MenuBack = in.nextInt();
                                                        while (MenuBack!= 9 && MenuBack!=0) {
                                                            System.out.println("Invalid in. Please try again : ");
                                                            MenuBack = in.nextInt();
                                                        }
                                                        if(MenuBack==0){
                                                            isValidMenu_FastFood=false;
                                                            isValidSubOption = true;
                                                            isValidOption = true;
                                                            clearScreen();
                                                            break;
                                                        } else if(MenuBack==9){
                                                            clearScreen();
                                                            break;
                                                        }
                                                    }
                                                }
                                                for (String tidakOption : TIDAK_OPTIONS) {
                                                    if (tidakOption.equalsIgnoreCase(userChoice)) {
                                                        isValidSubOption = true;
                                                        isValidOption = false;
                                                        clearScreen();
                                                        break;
                                                    }
                                                }
                                                if (!isValidSubOption) {
                                                    System.out.println("Invalid input. Please try again : ");
                                                }
                                            
                                            } while (!isValidSubOption);
                                        }
                                    }
                                    for (String tidakOption : TIDAK_OPTIONS) {
                                        if (tidakOption.equalsIgnoreCase(userChoice)) {
                                            isValidMenu_FastFood = false;
                                            isValidOption = true;
                                            clearScreen();
                                            break;
                                        }
                                    }
                                
                                    if (!isValidOption) {
                                        System.out.println("Invalid input. Please try again : ");
                                    }
                                
                                
                                } while (!isValidOption);
                            }
                        }
                        case 4->{
                            boolean IsValidMenu_FastSend = false;
                            do{
                                String[] NamaDriver = {"fatir", "ivan", "ariel", "radit", "desta", "albab", "faiz", "wahyu"};
                                String[] PlatNomor = {"B 2567 UXL", "N 2345 TP", "B 6016 UTP", "F 5142 YZF", "AG 6665 XU", "A 51 K"};
                                int n = NamaDriver.length;
                                int m = PlatNomor.length;
                                int indeksAcak = (int) (Math.random() * n);
                                int indeksPlat = (int) (Math.random() * m);
                                System.out.println("===========================|Fast--Send|===========================");
                                System.out.println("Total SaldoFastPay Fast-Pay: " +df.format(SaldoFastPay));
                                System.out.printf("\n%-40s %s","Masukkan Berat Barang (Kg)",": ");
                                float berat = in.nextInt();
                                double harga = hargatarif(berat);
                                System.out.printf("\n%-40s %s %s\n","Harga Pengiriman",": ",df.format(harga));
                                subborder();
                                System.out.printf("| %-15s | %-8s | %-15s |\n", "Opsi Pembayaran","Diskon %", "Harga");
                                System.out.printf("| %-15s | %-8s | %-15s |\n", "","", "(Setelah %)");
                                subborder();
                                System.out.printf("| %-15s | %-8s | %-15s |\n", "Fast-Pay","30%",df.format(harga*0.7));
                                System.out.printf("| %-15s | %-8s | %-15s |\n", "Gopay","10%", df.format(harga*0.9));
                                System.out.printf("| %-15s | %-8s | %-15s |\n", "OVO","5%", df.format(harga*0.95));
                                System.out.printf("| %-15s | %-8s | %-15s |\n", "Cash","-", df.format(harga));
                                subborder();
                                System.out.printf("%-40s %s","Masukkan Opsi Pembayaran",": ");
                                in.nextLine();
                                String pembayaran = in.nextLine();
                                double total = hitunghargaDiskon(harga, pembayaran);
                                SaldoFastPay -= total;
                                border();
                                System.out.printf("%-40s %s\n","Total pembayaran",": " + df.format(total));
                                border();
                                System.out.println("Yeayy!!, anda berhasil memesan layanan Fast-Send dengan");
                                System.out.println("tarif sebesar "+df.format(total)+". Tunggu Driver Mas "+ NamaDriver[indeksAcak]+ " dengan Plat Nomor "+ PlatNomor[indeksPlat]+ " yak!");
                                border();
                                System.out.println("9) Kembali");
                                System.out.println("0) Home");
                                System.out.print("Pilih menu: ");
                                int MenuBack = in.nextInt();
                                while (MenuBack!= 9 && MenuBack!=0) {
                                    System.out.println("Invalid in. Please try again : ");
                                    MenuBack = in.nextInt();
                                }
                                if(MenuBack==0){
                                    IsValidMenu_FastSend=true;
                                }
                                clearScreen();
                            }while (!IsValidMenu_FastSend);
                        }
                        case 5->{
                            String[] mobilBiasaOptions = {"Avanza", "Xenia", "Brio", "Agya", "Ayla", "Ertiga", "Cayla", "Xpander", "Rush", "Fortuner"};
                        String[] mobilPickupOptions = {"Grand Max", "Turismo", "Wuling", "New Carry"};
                        String[] minitruckOptions = {"Grand Max", "Turismo", "Wuling", "New Carry"};
                        String[] minibusOptions = {"Daihatsu Gran Max", "Daihatsu Luxio", "Nissan Evalia", "Suzuki APV","Toyota Kijang", "Kia Carnival","Hyundai H1", "Volkswagen Caravelle"};
                        String[] motorOptions = {"Vario 125", "Vario 150", "Vario 160", "Aerox", "Beat", "Beat Pop", "Scoopy", "Mio", "CBR", "Supra", "Revo", "Zx", "RX King"};
                        String[] PlatNomor = {"B 2567 UXL", "N 2345 TP", "B 6016 UTP", "F 5142 YZF", "AG 6665 XU", "A 51 K"};
                        int m = PlatNomor.length;
                        int indeksPlat = (int) (Math.random() * m);
                        boolean IsValidMenu_FastRent = false;

                        do {
                            System.out.println("===========================|Fast--Rent|===========================");
                            System.out.print("Lanjut ke menu Fast-Rent? (Y/N) ");
                            String check = in.next();
                            in.nextLine();

                            while (!check.equals("Y") && !check.equals("N")) {
                                System.out.println("Invalid input. Please try again : ");
                                check = in.nextLine();
                            }

                            if (check.equals("N")) {
                                IsValidMenu_FastRent = true;
                            }

                            clearScreen();

                            System.out.println("===========================|Fast--Rent|===========================");
                            System.out.println("Total SaldoFastPay Fast-Pay: " + df.format(SaldoFastPay));
                            System.out.println("\nSelamat datang di layanan Fast-Rent");
                            System.out.println("Berikut adalah list dari kendaraan yang bisa anda sewa:");
                            System.out.println("1) Mobil Biasa");
                            System.out.println("2) Mobil Pickup");
                            System.out.println("3) Minitruck");
                            System.out.println("4) Minibus");
                            System.out.println("5) Motor");
                            border();

                            System.out.print("Silakan masukkan pilihan kendaraan anda berdasarkan nomornya: ");
                            int kendaraan = in.nextInt();
                            while (kendaraan < 1 || kendaraan > 5) {
                                System.out.println("Invalid input. Please try again : ");
                                kendaraan = in.nextInt();
                            }

                            if (kendaraan == 1) {
                                System.out.println("Pilihan Mobil Biasa:");
                                for (int i = 0; i < mobilBiasaOptions.length; i++) {
                                    System.out.println((i + 1) + ") " + mobilBiasaOptions[i]);
                                }
                                System.out.print("Silakan masukkan nomor pilihan Mobil Biasa: ");
                                int mobilBiasaIndex = in.nextInt();
                                while (mobilBiasaIndex < 1 || mobilBiasaIndex > mobilBiasaOptions.length) {
                                    System.out.println("Invalid input. Please try again : ");
                                    mobilBiasaIndex = in.nextInt();
                                }
                                String selectedMobilBiasa = mobilBiasaOptions[mobilBiasaIndex - 1];
                                System.out.println("Anda memilih Mobil Biasa: " + selectedMobilBiasa + " " + PlatNomor[indeksPlat]);
                            } else if (kendaraan == 2) {
                                System.out.println("Pilihan Mobil Pickup:");
                                for (int i = 0; i < mobilPickupOptions.length; i++) {
                                    System.out.println((i + 1) + ") " + mobilPickupOptions[i]);
                                }
                                System.out.print("Silakan masukkan nomor pilihan Mobil Pickup: ");
                                int mobilPickupIndex = in.nextInt();
                                while (mobilPickupIndex < 1 || mobilPickupIndex > mobilPickupOptions.length) {
                                    System.out.println("Invalid input. Please try again : ");
                                    mobilPickupIndex = in.nextInt();
                                }
                                String selectedMobilPickup = mobilPickupOptions[mobilPickupIndex - 1];
                                System.out.println("Anda memilih Mobil Pickup: " + selectedMobilPickup + " " + PlatNomor[indeksPlat]);
                            } else if (kendaraan == 3) {
                                
                                System.out.println("Pilihan Minitruck:");
                                for (int i = 0; i < minitruckOptions.length; i++) {
                                    System.out.println((i + 1) + ") " + minitruckOptions[i]);
                                }

                                System.out.print("Silakan masukkan nomor pilihan Minitruck: ");
                                int minitruckIndex = in.nextInt();

                                while (minitruckIndex < 1 || minitruckIndex > minitruckOptions.length) {
                                    System.out.println("Invalid input. Please try again : ");
                                    minitruckIndex = in.nextInt();
                                }
                                String selectedMinitruck = minitruckOptions[minitruckIndex - 1];
                                System.out.println("Anda memilih Minitruck "+ selectedMinitruck + " " + PlatNomor[indeksPlat]); 
                            } else if (kendaraan == 4) {
                                System.out.println("Pilihan Minibus:");
                                for (int i = 0; i < minibusOptions.length; i++) {
                                    System.out.println((i + 1) + ") " + minibusOptions[i]);
                                }
                                System.out.print("Silakan masukkan nomor pilihan Minibus: ");
                                int minibusIndex = in.nextInt();
                                while (minibusIndex < 1 || minibusIndex > minibusOptions.length) {
                                    System.out.println("Invalid input. Please try again : ");
                                    minibusIndex = in.nextInt();
                                }
                                String selectedMinibus = minibusOptions[minibusIndex - 1];
                                System.out.println("Anda memilih Minibus: " + selectedMinibus+  " " +PlatNomor[indeksPlat]);
                            } else if (kendaraan == 5) {
                                System.out.println("Pilihan Motor:");
                                for (int i = 0; i < motorOptions.length; i++) {
                                    System.out.println((i + 1) + ") " + motorOptions[i]);
                                }
                                System.out.print("Silakan masukkan nomor pilihan Motor: ");
                                int motorIndex = in.nextInt();
                                while (motorIndex < 1 || motorIndex > motorOptions.length) {
                                    System.out.println("Invalid input. Please try again : ");
                                    motorIndex = in.nextInt();
                                }
                                String selectedMotor = motorOptions[motorIndex - 1];
                                System.out.println("Anda memilih Motor: " + selectedMotor +  " " +PlatNomor[indeksPlat]);
                            }
                            border();
                            System.out.println("Berikut adalah pilihan durasi peminjaman:");
                            System.out.println("1) 12 jam");
                            System.out.println("2) 24 jam");
                            System.out.println("3) 1 minggu");
                            border();
                            System.out.print("Silakan masukkan pilihan durasi anda berdasarkan nomornya: ");
                            int durasi = in.nextInt();
                            while (durasi < 1 || durasi > 3) {
                                System.out.println("Invalid input. Please try again : ");
                                durasi = in.nextInt();
                            }
                            if (check.equals("Y")) {
                                border();
                                System.out.println("*confirm regist");
                                menuMetodePembayaran(rentCalc(kendaraan, durasi), 10000,SaldoFastPay);
                                border();
                                System.out.println("Permohonan sewa anda diterima.");
                                System.out.println("Terima kasih telah menggunakan layanan Fast-Rent.");
                            } else if (check.equals("N")) {
                                clearScreen();
                                IsValidMenu_FastRent = true;
                            }
                            } while (!IsValidMenu_FastRent);
                        }
                        case 0->{
                            in.nextLine();
                            border();
                            System.out.println("Apakah anda ingin keluar?\n");
                            System.out.printf("%25s %20s\n", "Ganti Akun", "Keluar");
                            System.out.println("");
                            border();
                            System.out.print("Masukkan Pilihanmu: ");
                            String pilihan = in.nextLine();
                            while (!(pilihan.equalsIgnoreCase("ganti akun") || pilihan.equalsIgnoreCase("keluar"))) {
                                System.out.print("Invalid in. Please try again : ");
                                pilihan = in.nextLine();
                            }
                            if (pilihan.equalsIgnoreCase("ganti akun")) {
                                IsValidMenu_Home = false;
                                appsvalue = false;
                            } else if (pilihan.equalsIgnoreCase("keluar")) {
                                clearScreen();
                                System.out.printf("===========================|FAST-TRACK|===========================\n");
                                System.out.println("Terima-Kasih telah menggunakan layanan Fast-Track Kami\n");
                                System.out.println("Berlari cepat layaknya kijang");
                                System.out.println("Fast Track datang tanpa perlu menunggu lama");
                                System.out.println("Tak perlu lagi kamu merasa bimbang");
                                System.out.println("Dengan Fast Track, segala urusan jadi nyaman");
                                border();
                                appsvalue = true;
                                IsValidMenu_Home = false;
                            }
                        }
                    }
                }
            }while(!appsvalue);
        }
    }
    //tambah akun
    public static String[] appendArrayStrings(String[] a, String b) {
        String[] decoy = new String[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            decoy[i] = a[i];
        }
        decoy[a.length] = b;
        a = decoy;
        return a;
    }
    //Verifikasi 1
    public static boolean verification1(String[] usernames, String[] passwords, String inputUsername, String inputPassword) {
        for (int i = 0; i < usernames.length; i++) {
            if (usernames[i].equals(inputUsername) && passwords[i].equals(inputPassword)) {
                return true;
            }
        }
        return false;
    }

    //verifikasi 2 (Fast-Pay)
    public static boolean verification2(String verifiedPassword, String inputPassword) {
        return verifiedPassword.equals(inputPassword);
    }

    //clear screen di terminal
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    //Border
    public static void border() {
        System.out.println("==================================================================");
    }
    public static void subborder() {
        System.out.println("------------------------------------------------");
    }

    //Fast-Pay (pembayaran)
    public static void pembayaran(double total){
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("Rp#,###.00",symbols);
        System.out.printf("%-50s %s\n","Total pembayaran",": " + df.format(total));
    }

    //Fast-Pay (hitungtarif)
    public static double hitungTarif(double jarak, String kendaraan) {
        double tarif;
        if (jarak <= 2) {
            tarif = (kendaraan.equalsIgnoreCase("Mobil")) ? 25000*jarak : 15000*jarak;
        } else if (jarak <= 5) {
            tarif = (kendaraan.equalsIgnoreCase("Mobil")) ? 40000*jarak : 20000*jarak;
        } else if (jarak <= 10) {
            tarif = (kendaraan.equalsIgnoreCase("Mobil")) ? 65000*jarak : 30000*jarak;
        } else {
            tarif = (kendaraan.equalsIgnoreCase("Mobil")) ? jarak * 15000 : jarak * 8000;
        }
        return tarif;
    }

    //Fast-go (diskon)
    public static double hitunghargaDiskon(double tarif, String metodePembayaran) {
        double hargadiskon = 0;
        if (metodePembayaran.equalsIgnoreCase("GoPay")) {
            hargadiskon = 0.9 * tarif;
        } else if (metodePembayaran.equalsIgnoreCase("OVO")) {
            hargadiskon = 0.95 * tarif;
        } else if(metodePembayaran.equalsIgnoreCase("fastpay")){
            hargadiskon = 0.7 * tarif;
        } else if(metodePembayaran.equalsIgnoreCase("cash")){
            hargadiskon =tarif;
        }
        return hargadiskon;
    }

    //SaldoFastPay Fast-Pay
    public static int verifySaldo(String[] usernames, String[] passwords, String inputUsername, String inputPassword, int[] saldoarray) {
        for (int i = 0; i < usernames.length; i++) {
            if (usernames[i].equals(inputUsername) && passwords[i].equals(inputPassword)) {
                int SaldoFastPay = saldoarray[i];
                return SaldoFastPay;
            }
        }
        return -1;
    }
    //harga tarif fast send dan fas go
    public static int hargatarif(float berat){
        int harga;
        if(berat<=2){
            harga = 15000;
        } else if(2<berat && berat<=5){
            harga=20000;
        } else if(5<berat&& berat<=10){
            harga = 30000;
        } else{
            harga = (int)berat*8000;
        }
        return harga;
    }
    //total fast rent
    public static int rentCalc(int k, int d) {
        int mobil_Biasa = 400000; // perhari
        int mobil_pickup = 150000; // perhari
        int minitruck = 1000000; // perhari
        int minibus = 2000000; // perhari
        int motor = 60000; // perhari
        int biaya_aplikasi = 0;
        int total = 0;
        if (k == 1) {
            if (d == 1) {
                total += (mobil_Biasa / 2) + biaya_aplikasi;
            } else if (d == 2) {
                total += mobil_Biasa + biaya_aplikasi;
            } else if (d == 3) {
                total += (mobil_Biasa * 7) + biaya_aplikasi;
            }
        } else if (k == 2) {
            if (d == 1) {
                total += (mobil_pickup / 2) + biaya_aplikasi;
            } else if (d == 2) {
                total += mobil_pickup + biaya_aplikasi;
            } else if (d == 3) {
                total += (mobil_pickup * 7) + biaya_aplikasi;
            }
        } else if (k == 3) {
            if (d == 1) {
                total += (minitruck / 2) + biaya_aplikasi;
            } else if (d == 2) {
                total += minitruck + biaya_aplikasi;
            } else if (d == 3) {
                total += (minitruck * 7) + biaya_aplikasi;
            }
        } else if (k == 4) {
            if (d == 1) {
                total += (minibus / 2) + biaya_aplikasi;
            } else if (d == 2) {
                total += minibus + biaya_aplikasi;
            } else if (d == 3) {
                total += (minibus * 7) + biaya_aplikasi;
            }
        } else if (k == 5) {
            if (d == 1) {
                total += (motor / 2) + biaya_aplikasi;
            } else if (d == 2) {
                total += motor + biaya_aplikasi;
            } else if (d == 3) {
                total += (motor * 7) + biaya_aplikasi;
            }
        }
        return total;
    }

    public static void menuMetodePembayaran(double a, double b, int SaldoFastPay) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("Rp#,###.00", symbols);
        Scanner in = new Scanner(System.in);
        System.out.println("------------------------------------------------");
        System.out.printf("| %-15s | %-8s | %-15s |\n", "Opsi Pembayaran", "Diskon %", "Harga");
        System.out.printf("| %-15s | %-8s | %-15s |\n", "", "", "(Setelah %)");
        System.out.println("------------------------------------------------");
        System.out.printf("| %-15s | %-8s | %-15s |\n", "Fast-Pay", "30%", df.format((a + b) * 0.7));
        System.out.printf("| %-15s | %-8s | %-15s |\n", "Gopay", "10%", df.format((a + b) * 0.9));
        System.out.printf("| %-15s | %-8s | %-15s |\n", "OVO", "5%", df.format((a + b) * 0.95));
        System.out.printf("| %-15s | %-8s | %-15s |\n", "Cash", "-", df.format(a + b));
        System.out.println("------------------------------------------------");
        System.out.printf("%-45s %s", "Masukkan opsi pembayaran", ": ");
        String pembayaran = in.next();
        System.out.println("==================================================================");
        double total = hitunghargaDiskon(a + b, pembayaran);
        System.out.printf("%-45s %s\n", "Total order", ": " + df.format(a));
        System.out.printf("%-45s %s\n", "Biaya aplikasi", ": " + df.format(b));
        double diskon = 0;
        if (pembayaran.equalsIgnoreCase("GoPay")) {
            diskon = 0.1 * (a + b);
        } else if (pembayaran.equalsIgnoreCase("OVO")) {
            diskon = 0.05 * (a + b);
        } else if (pembayaran.equalsIgnoreCase("fastpay")) {
            diskon = 0.3 * (a + b);
        } else if (pembayaran.equalsIgnoreCase("cash")) {
            diskon = 0;
        }
        System.out.printf("%-45s %s\n", "Diskon", ": -" + df.format(diskon));
        System.out.printf("%-45s %s\n", "Total pembayaran", ": " + df.format(total));
        System.out.println("==================================================================");
        if (pembayaran.equalsIgnoreCase("fastpay")){
            SaldoFastPay -=total;
        }
    }

    private static int jenisMinuman(Scanner input) {
        tampilanMinuman();
        System.out.print("Silakan masukkan pilihan minuman anda berdasarkan nomornya: ");
        int jenisMinuman = input.nextInt();

        while (jenisMinuman < 1 || jenisMinuman > 11) {
            System.out.println("Invalid input. Please try again : ");
            jenisMinuman = input.nextInt();
        }
        return jenisMinuman;
    }

    private static void tampilanMinuman() {
        System.out.println("=".repeat(66));
        System.out.println("Berikut adalah list minuman yang bisa anda pesan:");

        for (int i = 0; i < DRINK_OPTIONS.length; i++) {
            System.out.println((i + 1) + ") " + DRINK_OPTIONS[i] + " - Rp" + DRINK_PRICES[i]);
        }
        System.out.println("=".repeat(66));
    }

    private static int jumlahMinuman(Scanner input) {
        System.out.print("Silakan masukkan jumlah pesanan: ");
        int jumlah = input.nextInt();

        while (jumlah <= 0) {
            System.out.println("Invalid input. Please try again : ");
            jumlah = input.nextInt();
        }
        return jumlah;
    }

    private static double penjumlahanMinuman(int jenisMinuman, int jumlah) {
        int harga = jenisMinuman - 1;
        return DRINK_PRICES[harga] * jumlah;
    }

    private static int jenisMakanan(Scanner input) {
        System.out.print("Silakan masukan pilihan makanan anda berdasarkan nomornya: ");
        int jenisMakanan = input.nextInt();

        while (jenisMakanan < 1 || jenisMakanan > 12) {
            System.out.println("Invalid input. Please try again : ");
            jenisMakanan = input.nextInt();
        }
        return jenisMakanan;
    }

    private static void tampilanAplikasi() {
        System.out.println("===========================|Fast--Food|===========================");
        System.out.println("Selamat datang di layanan Fast-Food");
    }
    private static void tampilanMakanan() {
        System.out.println("Berikut adalah list makanan yang bisa anda pesan:");
        for (int i = 0; i < FOOD_OPTIONS.length; i++) {
            System.out.println((i + 1) + ") " + FOOD_OPTIONS[i] + " - Rp" + FOOD_PRICES[i]);
        }
        System.out.println("=".repeat(66));
    }

    private static int jumlahMakanan(Scanner input) {
        System.out.print("Silakan masukkan jumlah pesanan: ");
        int jumlah = input.nextInt();

        while (jumlah <= 0) {
            System.out.println("Invalid input. Please try again : ");
            jumlah = input.nextInt();
        }
        return jumlah;
    }


    private static double jarakOngkir(Scanner input) {
        System.out.print("Silakan masukkan jarak pesanan (km): ");
        double distance = input.nextDouble();

        while (distance <= 0) {
            System.out.println("Invalid input. Please try again : ");
            distance = input.nextDouble();
        }
        return distance;
    }

    private static double penjumlahanMakanan(int jenisMakanan, int jumlah) {
        int harga = jenisMakanan - 1;
        return FOOD_PRICES[harga] * jumlah;
    }

    private static int getOrderChoice(Scanner input) {
        System.out.println("===========================|Fast--Food|===========================");
        System.out.println("Pilih kategori pesanan:");
        System.out.println("1) Makanan");
        System.out.println("2) Minuman");
        System.out.print("Masukkan pilihan (1/2): ");
        return input.nextInt();
    }

    private static double calculatebiayaOngkir(double distance) {
        return BIAYA_PER_KM * distance;
    }

    private static void confirmOrder() {
        String[] NamaDriver = {"fatir", "ivan", "ariel", "radit", "desta", "albab", "faiz", "wahyu"};
        String[] PlatNomor = {"B 2567 UXL", "N 2345 TP", "B 6016 UTP", "F 5142 YZF", "AG 6665 XU", "A 51 K"};
        int n = NamaDriver.length;
        int m = PlatNomor.length;
        int indeksAcak = (int) (Math.random() * n);
        int indeksPlat = (int) (Math.random() * m);
        System.out.println("=".repeat(66));
        System.out.println("*confirm order");
        System.out.println("=".repeat(66));
        System.out.println("Pesanan anda telah diterima.");
        System.out.println("Terima kasih telah menggunakan layanan Fast-Food");
        System.out.println("Tunggu Driver Mas "+ NamaDriver[indeksAcak]+ " dengan Plat Nomor "+ PlatNomor[indeksPlat]+ " yak!");
    }
}
