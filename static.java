class Battery7v{
    // 要件に応じてprivateに設定してください。
    private String manufacturer;
    private String model;
    private static final double VOLTAGE = 7.2;
    private static final String TYPE = "Lithium-Ion";
    private static int manufacturedCount;
    private double ampHours;
    private double weightKg;
    private double[] dimensionMm;

    public Battery7v(String manufacturer, String model, double ampHours, double weightKg, double wMm, double hMm, double dMm){
        this.manufacturer = manufacturer;
        this.model = model;
        this.ampHours = ampHours;
        this.weightKg = weightKg;
        this.dimensionMm = new double[]{wMm, hMm, dMm};
        this.manufacturedCount+=1;
    }

    // ゲッターとセッターの作成が必要です。

    public String getManufacturer(){
        return this.manufacturer;
    }

    public String getModel(){
        return this.model;

    }

    // VOLTAGE 

    public double VOLTAGE(){
        return VOLTAGE;
    }




    // TYPE
    public String TYPE(){
        return TYPE;
    }



    public int manufacturedCount(){
        return manufacturedCount;
    }


    public double getAmpHours(){
        return this.ampHours;
    }

    public void setAmpHours(double ampHours){
        this.ampHours = ampHours;
    }

    
    public double getWeightKg() {
        return this.weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public double[] getDimensionMm(){
        return this.dimensionMm;
    }
    

    public void setDimensionMm(){

    }




    public String toString(){
        return this.manufacturer + " " + this.model + " " + Battery7v.TYPE + " Battery: " + this.getPowerCapacity() + "Wh (" + Battery7v.VOLTAGE + "V/" + this.ampHours + "Ah) - " + this.dimensionMm[0] + "(W)x" + this.dimensionMm[1] + "(H)x" + this.dimensionMm[2] + "(D) " + this.getVolume() + " volume " + this.weightKg + "kg";
    }

    public double getPowerCapacity(){
        return Battery7v.VOLTAGE * this.ampHours;
    }

    public double getVolume(){
        return this.dimensionMm[0] * this.dimensionMm[1] * this.dimensionMm[2];
    }
}

class ExternalModule{
    public static void dangerousMethod(String customerId, Battery7v battery){
        System.out.println("Processing data....internals");
        System.out.println("Client " + customerId + " purchased a " + battery.toString());
        //battery.manufacturedCount += 4234;
    }

    public static void otherDangerousMethod(){
        //Battery7v.manufacturedCount += 10000;
    }
}

class Main {
    public static void main(String[] args) {
        Battery7v zlD72 = new Battery7v("MT-Dell Tech", "ZL-D72", 9.9, 1.18, 38, 80, 70);
        Battery7v zlD50 = new Battery7v("MT-Dell Tech", "ZL-D50", 6.6, 0.9, 28, 50, 65);
        Battery7v zlD40 = new Battery7v("MT-Dell Tech", "ZL-D40", 5.3, 1.18, 38, 80, 70);
        // privateにはアクセスできません。
        // System.out.println("Total batteries manufactured: " + Battery7v.manufacturedCount);

        //全てのメンバ変数をプライベートに設定し、ユーザがデータにアクセスして読み込めるようにセッターとゲッターを作成してください。
        // manufacturedCount は、一度設定された後はユーザによる上書きができないように設定してください。これにより、意図しないデータの変更を防ぐことができます。

        System.out.println();
        ExternalModule.dangerousMethod("AD515221", zlD40);
        ExternalModule.otherDangerousMethod();

        System.out.println();
        // privateにはアクセスできません。
        // System.out.println("Total batteries manufactured: " + Battery7v.manufacturedCount);

        Battery7v battery = new Battery7v("Sony", "Model-X", 7.0, 5.5, 1.2, 100.0, 500);

        // セッターで値を設定
        battery.setAmpHours(5.5);

        // ゲッターで値を取得して表示
        System.out.println("Amp Hours: " + battery.getAmpHours());
    }
}